package br.com.geosecure.managed;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.entity.StatusEstacaoHistorico;
import br.com.geosecure.persistence.ContinuoGlobalStatusEstacaoDao;
import br.com.geosecure.persistence.DisponibilidadeStatusEstacaoDao;
import br.com.geosecure.persistence.StatusEstacaoDao;
import br.com.geosecure.persistence.UltimoCheckDao;



public class StatusEstacaoBean {
	private Estacao estacao;
	private StatusEstacao statusEstacao;
	private StatusEstacaoHistorico statusEstacaoHistorico;
	private Date ultimoCheck;
	private OutrasInformacoes outrasInformacoes;

	private List<StatusEstacao> listaStatusOn;
	private List<StatusEstacao> listaStatusOff;
	private List<StatusEstacao> listaStatusManuntencao;
	private List<OutrasInformacoes> listaInfomarcoes;


	public StatusEstacaoBean() {
		statusEstacaoHistorico = new StatusEstacaoHistorico();
		statusEstacao =  new StatusEstacao();
		estacao = new Estacao();
		ultimoCheck = new Date();
		listaInfomarcoes = new ArrayList<OutrasInformacoes>();
		outrasInformacoes = new OutrasInformacoes();
	}
	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public StatusEstacaoHistorico getStatusEstacaoHistorico() {
		return statusEstacaoHistorico;
	}

	public void setStatusEstacaoHistorico(
			StatusEstacaoHistorico statusEstacaoHistorico) {
		this.statusEstacaoHistorico = statusEstacaoHistorico;
	}

	public List<StatusEstacao> getListaStatusOn() {
		try {
			

			listaStatusOn = new StatusEstacaoDao().findByModoStatus(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaStatusOn;
	}

	public void setListaStatusOn(List<StatusEstacao> listaStatusOn) {
		this.listaStatusOn = listaStatusOn;
	}

	public List<StatusEstacao> getListaStatusOff() {
		try {
			listaStatusOff = new StatusEstacaoDao().findByModoStatus(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaStatusOff;
	}

	public void setListaStatusOff(List<StatusEstacao> listaStatusOff) {
		this.listaStatusOff = listaStatusOff;
	}
	
	public List<StatusEstacao> getListaStatusManuntencao() {
		try {
			listaStatusManuntencao = new StatusEstacaoDao().findByModoStatus(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaStatusManuntencao;
	}

	public void setListaStatusManuntencao(List<StatusEstacao> listaStatusManuntencao) {
		this.listaStatusManuntencao = listaStatusManuntencao;
	}

	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}

	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}

	public Date getUltimoCheck() {
		return ultimoCheck;
	}

	public void setUltimoCheck(Date ultimoCheck) {
		this.ultimoCheck = ultimoCheck;
	}
	public OutrasInformacoes getOutrasInformacoes() {
		return outrasInformacoes;
	}
	public void setOutrasInformacoes(OutrasInformacoes outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}
	public List<OutrasInformacoes> getListaInfomarcoes() {
		try {
			Date ultimoCheck = new UltimoCheckDao().findByUltimoCheck();
			Double globalIndisponivel = new DisponibilidadeStatusEstacaoDao().indisponibilidadeAnualGlobal();
			Double totalContinuo = new ContinuoGlobalStatusEstacaoDao().totalContinuoGlobal();
			outrasInformacoes.setTotalIndisponibilidadeAnual(globalIndisponivel);
			outrasInformacoes.setUltimoCheck(ultimoCheck);
			outrasInformacoes.setTotalContinuo(totalContinuo);
			listaInfomarcoes.add(outrasInformacoes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaInfomarcoes;
	}
	public void setListaInfomarcoes(List<OutrasInformacoes> listaInfomarcoes) {
		this.listaInfomarcoes = listaInfomarcoes;
	}
	public String status(){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

	

}
