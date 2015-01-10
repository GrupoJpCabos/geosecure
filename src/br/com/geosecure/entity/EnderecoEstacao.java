package br.com.geosecure.entity;

import javax.persistence.*;

@Entity
@Table(name="enderecoestacao")
public class EnderecoEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idEnderecoEstacao;
	
	@Column
	private String ruaEnderecoEstacao;
	
	@Column
	private Integer numeroEnderecoEstacao;
	
	@Column
	private String bairroEnderecoEstacao;
	
	@Column
	private String estadoEnderecoEstacao;
	
	@Column
	private String cidadeEnderecoEstacao;
	
	@Column
	private String latitudeEnderecoEstacao;
	
	@Column
	private String longitudeEnderecoEstacao;
	
	@OneToOne(mappedBy="enderecoestacao", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Estacao estacao;
	
	
	public Estacao getEstacao() {
		return estacao;
	}
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	public Integer getIdEnderecoEstacao() {
		return idEnderecoEstacao;
	}
	public void setIdEnderecoEstacao(Integer idEnderecoEstacao) {
		this.idEnderecoEstacao = idEnderecoEstacao;
	}
	public String getRuaEnderecoEstacao() {
		return ruaEnderecoEstacao;
	}
	public void setRuaEnderecoEstacao(String ruaEnderecoEstacao) {
		this.ruaEnderecoEstacao = ruaEnderecoEstacao;
	}
	public Integer getNumeroEnderecoEstacao() {
		return numeroEnderecoEstacao;
	}
	public void setNumeroEnderecoEstacao(Integer numeroEnderecoEstacao) {
		this.numeroEnderecoEstacao = numeroEnderecoEstacao;
	}
	public String getBairroEnderecoEstacao() {
		return bairroEnderecoEstacao;
	}
	public void setBairroEnderecoEstacao(String bairroEnderecoEstacao) {
		this.bairroEnderecoEstacao = bairroEnderecoEstacao;
	}
	public String getEstadoEnderecoEstacao() {
		return estadoEnderecoEstacao;
	}
	public void setEstadoEnderecoEstacao(String estadoEnderecoEstacao) {
		this.estadoEnderecoEstacao = estadoEnderecoEstacao;
	}
	public String getCidadeEnderecoEstacao() {
		return cidadeEnderecoEstacao;
	}
	public void setCidadeEnderecoEstacao(String cidadeEnderecoEstacao) {
		this.cidadeEnderecoEstacao = cidadeEnderecoEstacao;
	}
	public String getLatitudeEnderecoEstacao() {
		return latitudeEnderecoEstacao;
	}
	public void setLatitudeEnderecoEstacao(String latitudeEnderecoEstacao) {
		this.latitudeEnderecoEstacao = latitudeEnderecoEstacao;
	}
	public String getLongitudeEnderecoEstacao() {
		return longitudeEnderecoEstacao;
	}
	public void setLongitudeEnderecoEstacao(String longitudeEnderecoEstacao) {
		this.longitudeEnderecoEstacao = longitudeEnderecoEstacao;
	}
	public EnderecoEstacao(Integer idEnderecoEstacao,
			String ruaEnderecoEstacao, Integer numeroEnderecoEstacao,
			String bairroEnderecoEstacao, String estadoEnderecoEstacao,
			String cidadeEnderecoEstacao, String latitudeEnderecoEstacao,
			String longitudeEnderecoEstacao) {
		super();
		this.idEnderecoEstacao = idEnderecoEstacao;
		this.ruaEnderecoEstacao = ruaEnderecoEstacao;
		this.numeroEnderecoEstacao = numeroEnderecoEstacao;
		this.bairroEnderecoEstacao = bairroEnderecoEstacao;
		this.estadoEnderecoEstacao = estadoEnderecoEstacao;
		this.cidadeEnderecoEstacao = cidadeEnderecoEstacao;
		this.latitudeEnderecoEstacao = latitudeEnderecoEstacao;
		this.longitudeEnderecoEstacao = longitudeEnderecoEstacao;
	}
	public EnderecoEstacao() {
		super();
	}
	
	

}
