package br.com.geosecure.managed;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.geosecure.entity.NivelUsuario;
import br.com.geosecure.persistence.NivelUsuarioDao;

public class NivelUsuarioBean {
	private NivelUsuario nivelUsuario;
	
	
	
	public NivelUsuarioBean() {
		nivelUsuario= new NivelUsuario();
	}

	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new NivelUsuarioDao().save(nivelUsuario);
		} catch (Exception e) {
			fc.addMessage("formnv", new FacesMessage("Erro: "+e.getMessage()));
			
		}
		
		return "cadastrar_login";
	}
	
}
