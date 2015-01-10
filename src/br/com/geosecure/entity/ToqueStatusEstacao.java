package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="toquestatusestacao")
public class ToqueStatusEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idToqueStatusEstacao;
	@Column
	private String tipoToqueStatusEstacao;
	
	@OneToMany(mappedBy="toquestatusestacao")
	private List<StatusEstacao> statusestacao;
	
	
	public List<StatusEstacao> getStatusestacao() {
		return statusestacao;
	}
	public void setStatusestacao(List<StatusEstacao> statusestacao) {
		this.statusestacao = statusestacao;
	}
	public Integer getIdToqueStatusEstacao() {
		return idToqueStatusEstacao;
	}
	public void setIdToqueStatusEstacao(Integer idToqueStatusEstacao) {
		this.idToqueStatusEstacao = idToqueStatusEstacao;
	}
	public String getTipoToqueStatusEstacao() {
		return tipoToqueStatusEstacao;
	}
	public void setTipoToqueStatusEstacao(String tipoToqueStatusEstacao) {
		this.tipoToqueStatusEstacao = tipoToqueStatusEstacao;
	}
	public ToqueStatusEstacao(Integer idToqueStatusEstacao,
			String tipoToqueStatusEstacao) {
		super();
		this.idToqueStatusEstacao = idToqueStatusEstacao;
		this.tipoToqueStatusEstacao = tipoToqueStatusEstacao;
	}
	public ToqueStatusEstacao() {
		super();
	}
	@Override
	public String toString() {
		return "ToqueStatusEstacao [idToqueStatusEstacao="
				+ idToqueStatusEstacao + ", tipoToqueStatusEstacao="
				+ tipoToqueStatusEstacao + "]";
	}
	
	

}
