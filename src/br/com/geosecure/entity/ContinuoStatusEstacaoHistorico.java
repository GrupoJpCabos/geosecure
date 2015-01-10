package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="continuostatusestacaohistorico")
public class ContinuoStatusEstacaoHistorico {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContinuoStatusEstacaoHistorico;
	@Column
	private Integer idEstacao;
	@Column
	private Double totalEstacaoHistorico;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioHistorico;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinalHistorico;
	@Column
	private Integer modoStatusEstacao;
	
	
	public Integer getIdContinuoStatusEstacaoHistorico() {
		return idContinuoStatusEstacaoHistorico;
	}
	public void setIdContinuoStatusEstacaoHistorico(
			Integer idContinuoStatusEstacaoHistorico) {
		this.idContinuoStatusEstacaoHistorico = idContinuoStatusEstacaoHistorico;
	}
	public Integer getIdEstacao() {
		return idEstacao;
	}
	public void setIdEstacao(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}
	public Double getTotalEstacaoHistorico() {
		return totalEstacaoHistorico;
	}
	public void setTotalEstacaoHistorico(Double totalEstacaoHistorico) {
		this.totalEstacaoHistorico = totalEstacaoHistorico;
	}
	public Date getDataInicioHistorico() {
		return dataInicioHistorico;
	}
	public void setDataInicioHistorico(Date dataInicioHistorico) {
		this.dataInicioHistorico = dataInicioHistorico;
	}
	public Date getDataFinalHistorico() {
		return dataFinalHistorico;
	}
	public void setDataFinalHistorico(Date dataFinalHistorico) {
		this.dataFinalHistorico = dataFinalHistorico;
	}
	public Integer getModoStatusEstacao() {
		return modoStatusEstacao;
	}
	public void setModoStatusEstacao(Integer modoStatusEstacao) {
		this.modoStatusEstacao = modoStatusEstacao;
	}
	public ContinuoStatusEstacaoHistorico(
			Integer idContinuoStatusEstacaoHistorico, Integer idEstacao,
			Double totalEstacaoHistorico, Date dataInicioHistorico,
			Date dataFinalHistorico, Integer modoStatusEstacao) {
		super();
		this.idContinuoStatusEstacaoHistorico = idContinuoStatusEstacaoHistorico;
		this.idEstacao = idEstacao;
		this.totalEstacaoHistorico = totalEstacaoHistorico;
		this.dataInicioHistorico = dataInicioHistorico;
		this.dataFinalHistorico = dataFinalHistorico;
		this.modoStatusEstacao = modoStatusEstacao;
	}
	public ContinuoStatusEstacaoHistorico() {
		super();
	}
	@Override
	public String toString() {
		return "ConitnuoStatusEstacaoHistorico [idContinuoStatusEstacaoHistorico="
				+ idContinuoStatusEstacaoHistorico
				+ ", idEstacao="
				+ idEstacao
				+ ", totalEstacaoHistorico="
				+ totalEstacaoHistorico
				+ ", dataInicioHistorico="
				+ dataInicioHistorico
				+ ", dataFinalHistorico="
				+ dataFinalHistorico
				+ ", modoStatusEstacao=" + modoStatusEstacao + "]";
	}
	
	
	
}
