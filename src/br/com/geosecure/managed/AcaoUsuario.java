package br.com.geosecure.managed;

import java.util.Date;



public class AcaoUsuario {

	private String nomeUsuario;
	private String nomeEstacao;
	private String toque;
	private Date dataHora;
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
	public String getToque() {
		return toque;
	}
	public void setToque(String toque) {
		this.toque = toque;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public AcaoUsuario(String nomeUsuario, String nomeEstacao, String toque,
			Date dataHora) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.nomeEstacao = nomeEstacao;
		this.toque = toque;
		this.dataHora = dataHora;
	}
	public AcaoUsuario() {
		super();
	}
	
	
}