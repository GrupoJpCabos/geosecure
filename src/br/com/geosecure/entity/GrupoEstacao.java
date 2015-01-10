package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupoestacao")
public class GrupoEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idGrupoEstacao;
	@Column
	private String nomeGrupoEstacao;
	
	@OneToMany(mappedBy="grupoestacao")
	private List<Estacao> estacao;
	
	
	public List<Estacao> getEstacao() {
		return estacao;
	}
	public void setEstacao(List<Estacao> estacao) {
		this.estacao = estacao;
	}
	public Integer getIdGrupoEstacao() {
		return idGrupoEstacao;
	}
	public void setIdGrupoEstacao(Integer idGrupoEstacao) {
		this.idGrupoEstacao = idGrupoEstacao;
	}
	public String getNomeGrupoEstacao() {
		return nomeGrupoEstacao;
	}
	public void setNomeGrupoEstacao(String nomeGrupoEstacao) {
		this.nomeGrupoEstacao = nomeGrupoEstacao;
	}
	public GrupoEstacao(Integer idGrupoEstacao, String nomeGrupoEstacao) {
		super();
		this.idGrupoEstacao = idGrupoEstacao;
		this.nomeGrupoEstacao = nomeGrupoEstacao;
	}
	public GrupoEstacao() {
		super();
	}
	
	

}
