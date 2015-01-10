package br.com.geosecure.managed;

import java.util.Date;

public class ListaFalhas365 {
	private String nomeEstacao;
	private Date dataFinal;
	private Date dataInicial;
	private String modoStatus;
	private Double total;
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
	
	public String getModoStatus() {
		return modoStatus;
	}
	public void setModoStatus(String modoStatus) {
		this.modoStatus = modoStatus;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public ListaFalhas365(String nomeEstacao, Date dataFinal, Date dataInicial,
			String modoStatus, Double total) {
		super();
		this.nomeEstacao = nomeEstacao;
		this.dataFinal = dataFinal;
		this.dataInicial = dataInicial;
		this.modoStatus = modoStatus;
		this.total = total;
	}
	public ListaFalhas365() {
		super();
	}
	@Override
	public String toString() {
		return "ListaFalhas [nomeEstacao=" + nomeEstacao + ", dataFinal="
				+ dataFinal + ", dataInicial=" + dataInicial + ", modoStatus="
				+ modoStatus + ", total=" + total + "]";
	}
	
	
	
	
	
}
