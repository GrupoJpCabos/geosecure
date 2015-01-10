package br.com.geosecure.managed;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.geosecure.entity.GrupoEstacao;
import br.com.geosecure.persistence.GrupoEstacaoDao;




public class GrupoEstacaoBean {
	
	private GrupoEstacao grupoestacao;
	private List<SelectItem> selectGrupo;
	private List<GrupoEstacao> listaGrupoEstacao;
	
	public GrupoEstacaoBean() {
		listaGrupoEstacao = new ArrayList<GrupoEstacao>();
		grupoestacao= new GrupoEstacao();
	}

	public GrupoEstacao getGrupoestacao() {
		return grupoestacao;
	}

	public void setGrupoestacao(GrupoEstacao grupoestacao) {
		this.grupoestacao = grupoestacao;
	}

	public List<SelectItem> getSelectGrupo() {
		try {
			selectGrupo = new ArrayList<SelectItem>();
			for(GrupoEstacao ge : new GrupoEstacaoDao().findAll()){
				selectGrupo.add(new SelectItem(ge.getIdGrupoEstacao(),ge.getNomeGrupoEstacao()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return selectGrupo;
	}

	public void setSelectGrupo(List<SelectItem> selectGrupo) {
		this.selectGrupo = selectGrupo;
	}

	public List<GrupoEstacao> getListaGrupoEstacao() {
		try {
			listaGrupoEstacao = new GrupoEstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaGrupoEstacao;
	}

	public void setListaGrupoEstacao(List<GrupoEstacao> listaGrupoEstacao) {
		this.listaGrupoEstacao = listaGrupoEstacao;
	}
	
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			new GrupoEstacaoDao().save(grupoestacao);
			grupoestacao = new GrupoEstacao();
			fc.addMessage("formGE", new FacesMessage("Grupo cadastrado com Sucesso!"));
		} catch (Exception e) {
			fc.addMessage("formGE", new FacesMessage(e.getMessage()));
		}
		return "cadastrar_estacao";
	}
	public String excluir(){
		FacesContext fc= FacesContext.getCurrentInstance();
		try {
			new GrupoEstacaoDao().delete(grupoestacao);
			grupoestacao = new GrupoEstacao();
			fc.addMessage("formGE", new FacesMessage("Excluido com Sucesso! "));
		} catch (Exception e) {
			fc.addMessage("formGE", new FacesMessage("Deverá excluir a Estação que tiver agregada neste grupo"));
		}
		return null;
	}
	public String editar(){
		return "editar_grupo";
	}
	public String editar2(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new GrupoEstacaoDao().update(grupoestacao);
			grupoestacao = new GrupoEstacao();
			fc.addMessage("formGE", new FacesMessage("Editado com Sucesso"));
		} catch (Exception e) {
			fc.addMessage("formGE", new FacesMessage(e.getMessage()));
		}
		return "cadastrar_grupo";
		
	}
	
	
	
	
	
	

}
