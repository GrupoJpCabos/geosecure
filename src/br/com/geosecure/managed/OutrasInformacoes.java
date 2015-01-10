package br.com.geosecure.managed;

import java.util.Date;

public class OutrasInformacoes {
	private Double totalDisponibilidadeAnual;
	private Double totalIndisponibilidadeAnual;
	private Double totalContinuo;
	private Date ultimoCheck;
	
	
	public Date getUltimoCheck() {
		return ultimoCheck;
	}
	public void setUltimoCheck(Date ultimoCheck) {
		this.ultimoCheck = ultimoCheck;
	}
	public Double getTotalDisponibilidadeAnual() {
		return totalDisponibilidadeAnual;
	}
	public void setTotalDisponibilidadeAnual(Double totalDisponibilidadeAnual) {
		this.totalDisponibilidadeAnual = totalDisponibilidadeAnual;
	}
	public Double getTotalIndisponibilidadeAnual() {
		return totalIndisponibilidadeAnual;
	}
	public void setTotalIndisponibilidadeAnual(Double totalIndisponibilidadeAnual) {
		this.totalIndisponibilidadeAnual = totalIndisponibilidadeAnual;
	}
	
	public Double getTotalContinuo() {
		return totalContinuo;
	}
	public void setTotalContinuo(Double totalContinuo) {
		this.totalContinuo = totalContinuo;
	}
	public OutrasInformacoes(Double totalDisponibilidadeAnual,
			Double totalIndisponibilidadeAnual, Double totalContinuo,
			Date ultimoCheck) {
		super();
		this.totalDisponibilidadeAnual = totalDisponibilidadeAnual;
		this.totalIndisponibilidadeAnual = totalIndisponibilidadeAnual;
		this.totalContinuo = totalContinuo;
		this.ultimoCheck = ultimoCheck;
	}
	public OutrasInformacoes() {
		super();
	}
	@Override
	public String toString() {
		return "OutrasInformacoes [totalDisponibilidadeAnual="
				+ totalDisponibilidadeAnual + ", totalIndisponibilidadeAnual="
				+ totalIndisponibilidadeAnual + ", totalContinuo="
				+ totalContinuo + ", ultimoCheck=" + ultimoCheck + "]";
	}
}