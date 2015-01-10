package br.com.geosecure.managed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jcommon.encryption.SimpleMD5;
import br.com.geosecure.entity.LoginHistorico;
import br.com.geosecure.entity.NivelUsuario;
import br.com.geosecure.entity.Usuario;
import br.com.geosecure.persistence.LoginHistoricoDao;
import br.com.geosecure.persistence.NivelUsuarioDao;
import br.com.geosecure.persistence.UsuarioDao;

public class UsuarioBean {

	private Usuario usuario;
	private String confirmarSenha;
	List<Usuario> listarUsuario;
	private LoginHistorico historico;
	private List<SelectItem> listarNivel; 
	private NivelUsuario nivelUsuario;
	private Integer id;

	public UsuarioBean() {

		usuario = new Usuario();
		historico = new LoginHistorico();
		nivelUsuario = new NivelUsuario();
		
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}


	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}


	public List<SelectItem> getListarNivel() {
		try {
			listarNivel = new ArrayList<SelectItem>();
			for(NivelUsuario nu : new NivelUsuarioDao().findAll()){
				listarNivel.add(new SelectItem(nu.getIdNivelUsuario(), nu.getNivel()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarNivel;
	}


	public void setListarNivel(List<SelectItem> listarNivel) {
		this.listarNivel = listarNivel;
	}


	public LoginHistorico getHistorico() {
		return historico;
	}


	public void setHistorico(LoginHistorico historico) {
		this.historico = historico;
	}


	public List<Usuario> getListarUsuario() {
		try {
			listarUsuario = new  UsuarioDao().findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarUsuario;
	}


	public void setListarUsuario(List<Usuario> listarUsuario) {
		this.listarUsuario = listarUsuario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getConfirmarSenha() {
		return confirmarSenha;
	}


	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		UsuarioDao ud = new UsuarioDao();
		try {
			if(usuario.getNomeUsuario().trim().equals("")){
				fc.addMessage("forml", new FacesMessage("Preencha o campo nome"));
			
			}else if(ud.findbyLogin(usuario.getLoginUsuario()) != null){
				fc.addMessage("forml", new FacesMessage("Usuario ja existe"));
			}
			else if(!usuario.getSenhaUsuario().equals(confirmarSenha)){
				fc.addMessage("forml", new FacesMessage("As senhas devem ser iguais ou digite uma senha"));
			}
			else{
				SimpleMD5 md5 = new SimpleMD5(usuario.getSenhaUsuario(), "grupojp");
				usuario.setSenhaUsuario(md5.toHexString());
				usuario.setNivelUsuario(nivelUsuario);
				new UsuarioDao().save(usuario);				

				usuario = new Usuario();
				confirmarSenha = "";
				fc.addMessage("forml",new FacesMessage("Usuário Cadastrado com Sucesso!"));
			}
			
		} catch (Exception e) {
			fc.addMessage("forml", new FacesMessage("Erro: " + e.getMessage()));
		}
		return null;
		
	}
	public String logar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		UsuarioDao ud = new UsuarioDao();

		try {
			
			System.out.println("Usuario" + usuario.getLoginUsuario());
			
			SimpleMD5 md5 = new SimpleMD5(usuario.getSenhaUsuario(), "grupojp");
			usuario.setSenhaUsuario(md5.toHexString());
			
			System.out.println(ud.efetuarLogin(usuario));
			
			if(ud.efetuarLogin(usuario) == null){
				fc.addMessage("form1", new FacesMessage("Usuario ou senha invalida ! "));
				return null;
			}
				System.out.println("Login: " +usuario.getLoginUsuario());
				
				usuario = ud.findbyLogin(usuario.getLoginUsuario());
				System.out.println("ID: " + usuario.getIdUsuario());
				System.out.println("Usuario: " +usuario.getNomeUsuario());
				
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.setAttribute("login", usuario.getLoginUsuario());
				session.setAttribute("nome", usuario.getNomeUsuario());
				session.setAttribute("id", usuario.getIdUsuario());
				session.setAttribute("nivel", usuario.getNivelUsuario().getIdNivelUsuario());
				Date data = new Date();
				
				SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
				String dataHoraFormatada = formatador.format(data);
				String dataHora =  dataHoraFormatada;
				System.out.println("Data antes a conversão= " + dataHora);
				
				@SuppressWarnings("deprecation")
				Date data2 = new Date(dataHora);

				historico.setDataHora(data2);
				historico.setUsuariolh(usuario);
				historico.setIdHistoricoLogin(null);
				
				System.out.println("ID_HISTORICO: "+historico.getIdHistoricoLogin());
				System.out.println("USUARIO: "+historico.getUsuariolh().getNomeUsuario());
				System.out.println("LOGINING :" +historico.getUsuariolh().getLoginUsuario());
				System.out.println("DATA: "+historico.getDataHora());
				
				new LoginHistoricoDao().save(historico);
				
				
				
				if(usuario.getNivelUsuario().getIdNivelUsuario()==2){
					return "/usuario/home.jsf";
				}else if(usuario.getNivelUsuario().getIdNivelUsuario()==1){
					return "/admin/home.jsf";
				}else{
					fc.addMessage("forml", new FacesMessage("Usuário sem nivel especificado!"));
					return null;
				}
				

		} catch (Exception e) {
			fc.addMessage("forml", new FacesMessage("Erro: "+e.getMessage()));
			e.printStackTrace();
			return null;
			
			
		}
		
	}
	
	
	public String editar(){
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
		
		
		
		
		System.out.println("Login: "+usuario.getLoginUsuario());
		id = usuario.getIdUsuario();
		System.out.println(getId());
		
		req.setAttribute("msg", id);
		
		return "editar_usuario";
	}
	
	
	public String editar2(){
		FacesContext fc = FacesContext.getCurrentInstance();
			
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
		
		String nome =req.getParameter("nome");
		String login = req.getParameter("login");
		String in = req.getParameter("id");
		
		System.out.println("login: "+login);
		System.out.println("Nome:"+nome );
		
		System.out.println("id : "+ in);
		try {
			 
			if(!usuario.getSenhaUsuario().equals(confirmarSenha)){
				fc.addMessage("forml", new FacesMessage("As senhas devem ser iguais ou digite uma senha"));
			}
			else{

				SimpleMD5 md5 = new SimpleMD5(usuario.getSenhaUsuario(), "grupojp");
				usuario.setSenhaUsuario(md5.toHexString());
				
				usuario.setNivelUsuario(nivelUsuario);
				new UsuarioDao().update(usuario);				

				usuario = new Usuario();
				confirmarSenha = "";
				fc.addMessage("forml",new FacesMessage("Usuário editado com Sucesso!"));
			}
			
		}catch (Exception e) {
			fc.addMessage("formu", new FacesMessage("Erro: "+e.getMessage()));
			e.printStackTrace();
		}
		return "listar_usuario";
	}
	public String excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			new UsuarioDao().delete(usuario);
			fc.addMessage("formu", new FacesMessage("Usuario excluida com Sucesso!"));
		} catch (Exception e) {
			fc.addMessage("formu", new FacesMessage("Erro: "+e.getMessage()));
		}
		return null;
	}
	public String editarUsuario1(){
		return "usuario/editar";
	}
	
	
	public String editarUsuario(){
		FacesContext fc = FacesContext.getCurrentInstance();
		UsuarioDao uDao = new UsuarioDao();
		try {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			usuario.setNomeUsuario((String) session.getAttribute("nome"));
			usuario.setLoginUsuario((String) session.getAttribute("login"));
			usuario.setIdUsuario((Integer) session.getAttribute("id"));
			
			System.out.println("Usuario: "+ usuario.getLoginUsuario());
			if(!usuario.getSenhaUsuario().equals(confirmarSenha)){
				fc.addMessage("forml", new FacesMessage("As senhas devem ser iguais ou digite uma senha"));
			}
			else{
				System.out.println("Entro no Else");
				SimpleMD5 md5 = new SimpleMD5(usuario.getSenhaUsuario(), "grupojp");
				usuario.setSenhaUsuario(md5.toHexString());
				
				nivelUsuario.setIdNivelUsuario(2);
				nivelUsuario.setNivel("usuário");
				
				usuario.setNivelUsuario(nivelUsuario);
				uDao.update(usuario);			

				usuario = new Usuario();
				confirmarSenha = "";
				nivelUsuario = new NivelUsuario();
				fc.addMessage("forml",new FacesMessage("Usuário editado com Sucesso!"));
			}
			
		
			
		} catch (Exception e) {
			fc.addMessage("forml", new FacesMessage("Erro:  "+e.getMessage()));
			e.printStackTrace();
		}
		
		return null;
			
	}
}
	


