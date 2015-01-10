package br.com.geosecure.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="acessoestacao")
public class AcessoEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idAcessoEstacao;
	
	@Column
	private String dnsAcessoEstacao;
	@Column
	private String portaAcessoEstacao;
	@Column
	private String usuarioAcessoEstacao;
	@Column
	private String senhaAcessoEstacao;
	
	@OneToOne(mappedBy="acessoestacao", cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	private Estacao estacao;
	
	
	public Estacao getEstacao() {
		return estacao;
	}
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	public Integer getIdAcessoEstacao() {
		return idAcessoEstacao;
	}
	public void setIdAcessoEstacao(Integer idAcessoEstacao) {
		this.idAcessoEstacao = idAcessoEstacao;
	}
	
	public String getDnsAcessoEstacao() {
		return dnsAcessoEstacao;
	}
	public void setDnsAcessoEstacao(String dnsAcessoEstacao) {
		this.dnsAcessoEstacao = dnsAcessoEstacao;
	}
	public String getPortaAcessoEstacao() {
		return portaAcessoEstacao;
	}
	public void setPortaAcessoEstacao(String portaAcessoEstacao) {
		this.portaAcessoEstacao = portaAcessoEstacao;
	}
	public String getUsuarioAcessoEstacao() {
		return usuarioAcessoEstacao;
	}
	public void setUsuarioAcessoEstacao(String usuarioAcessoEstacao) {
		this.usuarioAcessoEstacao = usuarioAcessoEstacao;
	}
	public String getSenhaAcessoEstacao() {
		return senhaAcessoEstacao;
	}
	public void setSenhaAcessoEstacao(String senhaAcessoEstacao) {
		this.senhaAcessoEstacao = senhaAcessoEstacao;
	}
	public AcessoEstacao(Integer idAcessoEstacao, String dnsAcessoEstacao,
			String portaAcessoEstacao, String usuarioAcessoEstacao,
			String senhaAcessoEstacao) {
		super();
		this.idAcessoEstacao = idAcessoEstacao;
		this.dnsAcessoEstacao = dnsAcessoEstacao;
		this.portaAcessoEstacao = portaAcessoEstacao;
		this.usuarioAcessoEstacao = usuarioAcessoEstacao;
		this.senhaAcessoEstacao = senhaAcessoEstacao;
	}
	public AcessoEstacao() {
		super();
	};
	
	

}
