package br.com.geosecure.managed;

public class ListaRelatorioDisponibilidade {
	private String nomeEstacao;
	private Double tempoOffAnual;
	private Double tempoOffMensal;
	private Double tempoOnAnual;
	private Double tempoOnMensal;
	private Double porcento;
	private Double falhaAnual;
	private Double falhaMensal;
	
	
	public Double getTempoOnAnual() {
		return tempoOnAnual;
	}
	public void setTempoOnAnual(Double tempoOnAnual) {
		this.tempoOnAnual = tempoOnAnual;
	}
	public Double getTempoOnMensal() {
		return tempoOnMensal;
	}
	public void setTempoOnMensal(Double tempoOnMensal) {
		this.tempoOnMensal = tempoOnMensal;
	}
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
	public Double getTempoOffAnual() {
		return tempoOffAnual;
	}
	public void setTempoOffAnual(Double tempoOffAnual) {
		this.tempoOffAnual = tempoOffAnual;
	}
	public Double getTempoOffMensal() {
		return tempoOffMensal;
	}
	public void setTempoOffMensal(Double tempoOffMensal) {
		this.tempoOffMensal = tempoOffMensal;
	}
	public Double getPorcento() {
		return porcento;
	}
	public void setPorcento(Double porcento) {
		this.porcento = porcento;
	}
	public Double getFalhaAnual() {
		return falhaAnual;
	}
	public void setFalhaAnual(Double falhaAnual) {
		this.falhaAnual = falhaAnual;
	}
	public Double getFalhaMensal() {
		return falhaMensal;
	}
	public void setFalhaMensal(Double falhaMensal) {
		this.falhaMensal = falhaMensal;
	}
	public ListaRelatorioDisponibilidade(String nomeEstacao,
			Double tempoOffAnual, Double tempoOffMensal, Double tempoOnAnual,
			Double tempoOnMensal, Double porcento, Double falhaAnual,
			Double falhaMensal) {
		super();
		this.nomeEstacao = nomeEstacao;
		this.tempoOffAnual = tempoOffAnual;
		this.tempoOffMensal = tempoOffMensal;
		this.tempoOnAnual = tempoOnAnual;
		this.tempoOnMensal = tempoOnMensal;
		this.porcento = porcento;
		this.falhaAnual = falhaAnual;
		this.falhaMensal = falhaMensal;
	}
	public ListaRelatorioDisponibilidade() {
		super();
	}
	
	
	

}
