package br.com.geosecure.managed;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.geosecure.entity.Usuario;

public class AdminBean {
	private Usuario usuario;

	
	public AdminBean() {
		
		usuario = new Usuario();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		if(session.getAttribute("login") != null){
			
			usuario.setNomeUsuario((String) session.getAttribute("nome"));
			usuario.setLoginUsuario((String) session.getAttribute("login"));
			usuario.setIdUsuario((Integer) session.getAttribute("id"));
			
			
		}
	}
	
	
	public String logout(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		
		session.removeAttribute("login");
		session.removeAttribute("nome");
		session.removeAttribute("id");
		session.invalidate();
		
		HttpServletResponse res = (HttpServletResponse) fc.getExternalContext().getResponse();
		try {
			res.sendRedirect("../index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
