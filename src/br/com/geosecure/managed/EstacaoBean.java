package br.com.geosecure.managed;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.geosecure.entity.AcessoEstacao;
import br.com.geosecure.entity.EnderecoEstacao;
import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.GrupoEstacao;
import br.com.geosecure.entity.Pluviometro;
import br.com.geosecure.entity.PluviometroHistoricoConvertido;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.entity.TipoEstacao;
import br.com.geosecure.persistence.AcessoEstacaoDao;
import br.com.geosecure.persistence.EnderecoEstacaoDao;
import br.com.geosecure.persistence.EstacaoDao;
import br.com.geosecure.persistence.PluviometroDao;
import br.com.geosecure.persistence.StatusEstacaoDao;


public class EstacaoBean {
	
	
	private Estacao estacao;
	private List<Estacao> listaEstacao;
	private List<Estacao> buscarEstacao;
	private List<EnderecoEstacao> listaEndereco;
	private List<AcessoEstacao> listaAcesso;
	private TipoEstacaoBean TipoEstacaoBean;
	private GrupoEstacaoBean GrupoEstacaoBean;
	private Pluviometro pluviometro;
	private PluviometroHistoricoConvertido pluviometroHistoricoConvertido;
	
	private AcessoEstacao acessoEstacao;
	private StatusEstacao statusEstacao;
	private GrupoEstacao grupoEstacao;
	private TipoEstacao tipoEstacao;
	private EnderecoEstacao enderecoEstacao;
	
	
	private String acao;
	
	private List<Pluviometro> listaAbaixo10;
	private List<Pluviometro> listaEntre10e20;
	private List<Pluviometro> listaAcima20;
	

	
	public EstacaoBean() {
		tipoEstacao = new TipoEstacao();
		grupoEstacao = new GrupoEstacao();
		statusEstacao = new StatusEstacao();
		estacao = new Estacao();
		TipoEstacaoBean = new TipoEstacaoBean();
		GrupoEstacaoBean = new GrupoEstacaoBean();
		buscarEstacao = new ArrayList<Estacao>();
		enderecoEstacao = new EnderecoEstacao();
		pluviometro = new Pluviometro();
		pluviometroHistoricoConvertido = new PluviometroHistoricoConvertido();
		acessoEstacao = new AcessoEstacao();
		listaEndereco = new ArrayList<EnderecoEstacao>();
		listaAcesso = new ArrayList<AcessoEstacao>();
	}
	


	public GrupoEstacao getGrupoEstacao() {
		return grupoEstacao;
	}



	public void setGrupoEstacao(GrupoEstacao grupoEstacao) {
		this.grupoEstacao = grupoEstacao;
	}



	public TipoEstacao getTipoEstacao() {
		return tipoEstacao;
	}



	public void setTipoEstacao(TipoEstacao tipoEstacao) {
		this.tipoEstacao = tipoEstacao;
	}



	public List<AcessoEstacao> getListaAcesso() {
		try {
			////////System.out.println("ID: " +acessoEstacao.getIdAcessoEstacao());
			listaAcesso = new AcessoEstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAcesso;
	}
	public void setListaAcesso(List<AcessoEstacao> listaAcesso) {
		this.listaAcesso = listaAcesso;
	}

	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}
	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}

	public List<EnderecoEstacao> getListaEndereco() {
		
		try {
			listaEndereco = new EnderecoEstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEndereco;
	}
	public void setListaEndereco(List<EnderecoEstacao> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	public AcessoEstacao getAcessoEstacao() {
		return acessoEstacao;
	}
	public void setAcessoEstacao(AcessoEstacao acessoEstacao) {
		this.acessoEstacao = acessoEstacao;
	}
	public PluviometroHistoricoConvertido getPluviometroHistoricoConvertido() {
		return pluviometroHistoricoConvertido;
	}
	public void setPluviometroHistoricoConvertido(
			PluviometroHistoricoConvertido pluviometroHistoricoConvertido) {
		this.pluviometroHistoricoConvertido = pluviometroHistoricoConvertido;
	}
	public Pluviometro getPluviometro() {
		return pluviometro;
	}
	public void setPluviometro(Pluviometro pluviometro) {
		this.pluviometro = pluviometro;
	}
	public EnderecoEstacao getEnderecoEstacao() {
		return enderecoEstacao;
	}
	public void setEnderecoEstacao(EnderecoEstacao enderecoEstacao) {
		this.enderecoEstacao = enderecoEstacao;
	}
	public List<Estacao> getBuscarEstacao() {
		return buscarEstacao;
	}
	public void setBuscarEstacao(List<Estacao> buscarEstacao) {
		this.buscarEstacao = buscarEstacao;
	}

	public Estacao getEstacao() {
		return estacao;
	}
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	public List<Estacao> getListaEstacao() {
		try {
			
			listaEstacao=new EstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEstacao;
	}
	public void setListaEstacao(List<Estacao> listaEstacao) {
		this.listaEstacao = listaEstacao;
	}
	public TipoEstacaoBean getTipoEstacaoBean() {
		return TipoEstacaoBean;
	}
	public void setTipoEstacaoBean(TipoEstacaoBean tipoEstacaoBean) {
		TipoEstacaoBean = tipoEstacaoBean;
	}
	public GrupoEstacaoBean getGrupoEstacaoBean() {
		return GrupoEstacaoBean;
	}
	public void setGrupoEstacaoBean(GrupoEstacaoBean grupoEstacaoBean) {
		GrupoEstacaoBean = grupoEstacaoBean;
	}

	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}



	public List<Pluviometro> getListaAbaixo10() {
		try {
			listaAbaixo10 = new EstacaoDao().findByLeituraMenor10();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAbaixo10;
	}
	public void setListaAbaixo10(List<Pluviometro> listaAbaixo10) {
		this.listaAbaixo10 = listaAbaixo10;
	}
	
	public List<Pluviometro> getListaEntre10e20() {
		try {
			listaEntre10e20 = new EstacaoDao().findByLeituraEntre10e20();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEntre10e20;
	}
	public void setListaEntre10e20(List<Pluviometro> listaEntre10e20) {
		this.listaEntre10e20 = listaEntre10e20;
	}
	public List<Pluviometro> getListaAcima20() {
		try {
			listaAcima20 = new EstacaoDao().findByLeituraAcima20();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAcima20;
	}
	public void setListaAcima20(List<Pluviometro> listaAcima20) {
		this.listaAcima20 = listaAcima20;
	}

	
	public String cadastrar(){
		FacesContext fc =FacesContext.getCurrentInstance();
		try {			
			
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
			String cidade = req.getParameter("cidade");
			String estado = req.getParameter("estado");
			
			//////System.out.println("Cidade"+ cidade + " Estado:"+ estado);
			
			enderecoEstacao.setCidadeEnderecoEstacao(cidade);
			enderecoEstacao.setEstadoEnderecoEstacao(estado);
			
			boolean flag = true;
			
//			Pattern p1 = Pattern.compile("[0-9]{0,3}+\\.[0-9]{0,3}+\\.[0-9]{0,3}\\.[0-9]{0,3}");
//			Matcher m1 = p1.matcher(acessoEstacao.getDnsAcessoEstacao());
			
			
			if(estacao.getNomeEstacao().trim().length()<3){
				flag= false;
				fc.addMessage("forme:nome", new FacesMessage("Nome invalido! Informe o Nome no minimo 3 Caracteres"));
			}
			if(enderecoEstacao.getLatitudeEnderecoEstacao().trim().length()<2){
				flag =false;
				fc.addMessage("forme:latitude", new FacesMessage("Digite uma latitude exata"));
			}
			if(enderecoEstacao.getLongitudeEnderecoEstacao().trim().length()<2){
				flag =false;
				fc.addMessage("forme:longitude", new FacesMessage("Digite uma longitude exata"));
			}
			if(pluviometro.getIdPluviometro()==0 ){
				flag =false;
				fc.addMessage("forme:id", new FacesMessage("Digite um Id exato"));
			}
//			if(!m1.matches()){
//				flag = false;
//				fc.addMessage("forme:dns", new FacesMessage("DNS invalido! Informe o DNS seguido de xxx.xxx.xxx.xxx"));
//			}
//			if(acessoEstacao.getPortaAcessoEstacao().trim().length()<4){
//				flag =false;
//				fc.addMessage("forme:porta", new FacesMessage("Digite uma Porta exata"));
//			}
			if(acessoEstacao.getUsuarioAcessoEstacao().trim().length()<1){
				flag =false;
				fc.addMessage("forme:usuario", new FacesMessage("Digite um Usuario"));
			}
			if(acessoEstacao.getSenhaAcessoEstacao().trim().length()<1){
				flag =false;
				fc.addMessage("forme:senha", new FacesMessage("Digite uma Senha exata"));
			}
			if(flag == true){
				
				
				
				estacao.setPluviometroe(pluviometro);
				estacao.setAcessoestacao(acessoEstacao);
				estacao.setEnderecoestacao(enderecoEstacao);
				estacao.setTipoestacao(TipoEstacaoBean.getTipoestacao());
				estacao.setGrupoestacao(GrupoEstacaoBean.getGrupoestacao());
				
				
				
				new PluviometroDao().save(pluviometro);
				new AcessoEstacaoDao().save(acessoEstacao);
				new EstacaoDao().save(estacao);
				
				acessoEstacao = new AcessoEstacao();
				estacao = new Estacao();
				enderecoEstacao = new EnderecoEstacao();
				pluviometro = new Pluviometro();
				fc.addMessage("forme", new FacesMessage("Cadastrado com Sucesso!"));
			}
			
		} catch (Exception e) {
			fc.addMessage("forme", new FacesMessage("Cadastrado com Sucesso!"));
			estacao = new Estacao();
			enderecoEstacao = new EnderecoEstacao();
			pluviometro = new Pluviometro();
			acessoEstacao = new AcessoEstacao();
		}
		return null;
	}
	public String excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new EstacaoDao().delete(estacao);
			fc.addMessage("forme", new FacesMessage("Estação excluida com Sucesso!"));
		} catch (Exception e) {
			fc.addMessage("forme", new FacesMessage("Erro: "+e.getMessage()));
		}
		return null;	
	}
	
	public String editar(){		
		return "editar_estacao";
	}
	public String editar2() {
		FacesContext fc =FacesContext.getCurrentInstance();
		try {			
			
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
			String cidade = req.getParameter("cidade");
			String estado = req.getParameter("estado");
			
			//////System.out.println("Cidade"+ cidade + " Estado:"+ estado);
			
			enderecoEstacao.setCidadeEnderecoEstacao(cidade);
			enderecoEstacao.setEstadoEnderecoEstacao(estado);
			
			boolean flag = true;
			
//			Pattern p1 = Pattern.compile("[0-9]{0,3}+\\.[0-9]{0,3}+\\.[0-9]{0,3}\\.[0-9]{0,3}");
//			Matcher m1 = p1.matcher(acessoEstacao.getDnsAcessoEstacao());
			
			
			if(estacao.getNomeEstacao().trim().length()<3){
				flag= false;
				fc.addMessage("forme:nome", new FacesMessage("Nome invalido! Informe o Nome no minimo 3 Caracteres"));
			}
			if(enderecoEstacao.getLatitudeEnderecoEstacao().trim().length()<2){
				flag =false;
				fc.addMessage("forme:latitude", new FacesMessage("Digite uma latitude exata"));
			}
			if(enderecoEstacao.getLongitudeEnderecoEstacao().trim().length()<2){
				flag =false;
				fc.addMessage("forme:longitude", new FacesMessage("Digite uma longitude exata"));
			}

//			if(!m1.matches()){
//				flag = false;
//				fc.addMessage("forme:dns", new FacesMessage("DNS invalido! Informe o DNS seguido de xxx.xxx.xxx.xxx"));
//			}
//			if(acessoEstacao.getPortaAcessoEstacao().trim().length()<4){
//				flag =false;
//				fc.addMessage("forme:porta", new FacesMessage("Digite uma Porta exata"));
//			}
//			if(acessoEstacao.getUsuarioAcessoEstacao().trim().length()<1){
//				flag =false;
//				fc.addMessage("forme:usuario", new FacesMessage("Digite um Usuario"));
//			}
//			if(acessoEstacao.getSenhaAcessoEstacao().trim().length()<1){
//				flag =false;
//				fc.addMessage("forme:senha", new FacesMessage("Digite uma Senha exata"));
//			}
			if(flag == true){
				
				
				
				estacao.setPluviometroe(pluviometro);
				estacao.setAcessoestacao(acessoEstacao);
				estacao.setEnderecoestacao(enderecoEstacao);
				estacao.setTipoestacao(TipoEstacaoBean.getTipoestacao());
				estacao.setGrupoestacao(GrupoEstacaoBean.getGrupoestacao());
				
				
				
				
				new EstacaoDao().update(estacao);
				
				acessoEstacao = new AcessoEstacao();
				estacao = new Estacao();
				enderecoEstacao = new EnderecoEstacao();
				pluviometro = new Pluviometro();
				fc.addMessage("forme", new FacesMessage("Editado com Sucesso!"));
			}
			
		} catch (Exception e) {
			fc.addMessage("forme", new FacesMessage("Editado com Sucesso!"));
			e.printStackTrace();
		}
		return "listar_estacao";
	}
	public String consultar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			buscarEstacao = new EstacaoDao().findByObj(estacao.getNomeEstacao()+"%");
		} catch (Exception e) {
			fc.addMessage("forme", new FacesMessage("Erro: "+e.getMessage()));
		}
		return null;
	}
	

}
