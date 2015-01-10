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
@Table(name="modostatusestacao")
public class ModoStatusEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idModoStatusEstacao;
	@Column
	private String modoStatusEstacao;
	
	@OneToMany(mappedBy="modostatusestacao")
	private List<StatusEstacao> statusestacao;
	
	
	public List<StatusEstacao> getStatusestacao() {
		return statusestacao;
	}
	public void setStatusestacao(List<StatusEstacao> statusestacao) {
		this.statusestacao = statusestacao;
	}
	public Integer getIdModoStatusEstacao() {
		return idModoStatusEstacao;
	}
	public void setIdModoStatusEstacao(Integer idModoStatusEstacao) {
		this.idModoStatusEstacao = idModoStatusEstacao;
	}
	
	public String getModoStatusEstacao() {
		return modoStatusEstacao;
	}
	public void setModoStatusEstacao(String modoStatusEstacao) {
		this.modoStatusEstacao = modoStatusEstacao;
	}
	
	public ModoStatusEstacao(Integer idModoStatusEstacao,
			String modoStatusEstacao) {
		super();
		this.idModoStatusEstacao = idModoStatusEstacao;
		this.modoStatusEstacao = modoStatusEstacao;
	}
	public ModoStatusEstacao() {
		super();
	}
	@Override
	public String toString() {
		return "ModoStatusEstacao [idModoStatusEstacao=" + idModoStatusEstacao
				+ ", modoStatusEstacao=" + modoStatusEstacao + "]";
	}
	
	
	
	
	
}
