package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tipoestacao")
@NamedQueries(
		@NamedQuery(name="tipoestacaoAll", query="SELECT te FROM TipoEstacao te ORDER BY te.nomeTipoEstacao")
)
public class TipoEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idTipoEstacao;
	@Column
	private String nomeTipoEstacao;
	
	@OneToMany(mappedBy="tipoestacao")
	private List<Estacao> estacao;
	
	
	public List<Estacao> getEstacao() {
		return estacao;
	}
	public void setEstacao(List<Estacao> estacao) {
		this.estacao = estacao;
	}
	public Integer getIdTipoEstacao() {
		return idTipoEstacao;
	}
	public void setIdTipoEstacao(Integer idTipoEstacao) {
		this.idTipoEstacao = idTipoEstacao;
	}
	public String getNomeTipoEstacao() {
		return nomeTipoEstacao;
	}
	public void setNomeTipoEstacao(String nomeTipoEstacao) {
		this.nomeTipoEstacao = nomeTipoEstacao;
	}
	public TipoEstacao(Integer idTipoEstacao, String nomeTipoEstacao) {
		super();
		this.idTipoEstacao = idTipoEstacao;
		this.nomeTipoEstacao = nomeTipoEstacao;
	}
	public TipoEstacao() {
		super();
	}
	
	
	
}
