package br.com.geosecure.managed;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.geosecure.entity.TipoEstacao;
import br.com.geosecure.persistence.TipoEstacaoDao;

public class TipoEstacaoBean {
	
	private TipoEstacao tipoestacao;
	private List<SelectItem> selectTipoEstacao;
	private List<TipoEstacao> listarTipoEstacao;
	
	public TipoEstacaoBean() {
		tipoestacao = new TipoEstacao();		
	}

	public TipoEstacao getTipoestacao() {
		return tipoestacao;
	}

	public void setTipoestacao(TipoEstacao tipoestacao) {
		this.tipoestacao = tipoestacao;
	}

	public List<SelectItem> getSelectTipoEstacao() {
		
		try {
			selectTipoEstacao = new ArrayList<SelectItem>();
			for(TipoEstacao te : new TipoEstacaoDao().findAll()){
				selectTipoEstacao.add(new SelectItem(te.getIdTipoEstacao(),te.getNomeTipoEstacao()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectTipoEstacao;
	}

	public void setSelectTipoEstacao(List<SelectItem> selectTipoEstacao) {
		this.selectTipoEstacao = selectTipoEstacao;
	}

	public List<TipoEstacao> getListarTipoEstacao() {
		try {
			listarTipoEstacao = new ArrayList<TipoEstacao>();
			listarTipoEstacao = new TipoEstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarTipoEstacao;
	}

	public void setListarTipoEstacao(List<TipoEstacao> listarTipoEstacao) {
		this.listarTipoEstacao = listarTipoEstacao;
	}
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new TipoEstacaoDao().save(tipoestacao);
			tipoestacao = new TipoEstacao();
			fc.addMessage("formte", new FacesMessage("Cadastrado com sucesso !"));
		} catch (Exception e) {
			fc.addMessage("formte", new FacesMessage("Erro: "+e.getMessage()));
		}
		return "cadastrar_estacao";
	}
	
	public String excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new TipoEstacaoDao().delete(tipoestacao);
			tipoestacao = new TipoEstacao();
			fc.addMessage("formte", new FacesMessage("Excluido com Sucesso!"));
		} catch (Exception e) {
			fc.addMessage("formte", new FacesMessage("Erro: Deverá excluir a Estação que tiver agregado a esse Tipo "));
			e.printStackTrace();
		}
		return null;
	}
	public String editar(){
		return "editar_tipo";
	}
	
	public String editar2(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new TipoEstacaoDao().update(tipoestacao);
			tipoestacao = new TipoEstacao();
			fc.addMessage("formte", new FacesMessage("Editado com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formte", new FacesMessage("Erro: "+ e.getMessage()));
		}
		return "cadastrar_tipo";
	}
	
	
	

}
