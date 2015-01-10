package br.com.geosecure.managed;

import java.util.List;

public class Listao {
	
	
	private ListaRelatorioDisponibilidade relatorio;
	private List<ListaFalhas365> listaFalhas365;
	private List<ListaFalhas30>listaFalhas30;
	public ListaRelatorioDisponibilidade getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(ListaRelatorioDisponibilidade relatorio) {
		this.relatorio = relatorio;
	}
	public List<ListaFalhas365> getListaFalhas365() {
		return listaFalhas365;
	}
	public void setListaFalhas365(List<ListaFalhas365> listaFalhas365) {
		this.listaFalhas365 = listaFalhas365;
	}
	public List<ListaFalhas30> getListaFalhas30() {
		return listaFalhas30;
	}
	public void setListaFalhas30(List<ListaFalhas30> listaFalhas30) {
		this.listaFalhas30 = listaFalhas30;
	}
	public Listao(ListaRelatorioDisponibilidade relatorio,
			List<ListaFalhas365> listaFalhas365,
			List<ListaFalhas30> listaFalhas30) {
		super();
		this.relatorio = relatorio;
		this.listaFalhas365 = listaFalhas365;
		this.listaFalhas30 = listaFalhas30;
	}
	public Listao() {
		super();
	}
	@Override
	public String toString() {
		return "Listao [relatorio=" + relatorio + ", listaFalhas365="
				+ listaFalhas365 + ", listaFalhas30=" + listaFalhas30 + "]";
	}
	
	
	
	
	


	
}

