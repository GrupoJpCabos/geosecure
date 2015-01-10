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
@Table(name="statusestacaohistorico")
public class StatusEstacaoHistorico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idStatusEstacaoHistorico;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraStatusEstacaoHistorico;
	@Column
	private Integer idEstacao;
	@Column
	private Integer idModoStatusEstacao;
	@Column
	private Integer idToqueStatusEstacao;
	
	
	public Integer getIdStatusEstacaoHistorico() {
		return idStatusEstacaoHistorico;
	}
	public void setIdStatusEstacaoHistorico(Integer idStatusEstacaoHistorico) {
		this.idStatusEstacaoHistorico = idStatusEstacaoHistorico;
	}
	public Date getDataHoraStatusEstacaoHistorico() {
		return dataHoraStatusEstacaoHistorico;
	}
	public void setDataHoraStatusEstacaoHistorico(
			Date dataHoraStatusEstacaoHistorico) {
		this.dataHoraStatusEstacaoHistorico = dataHoraStatusEstacaoHistorico;
	}
	public Integer getIdEstacao() {
		return idEstacao;
	}
	public void setIdEstacao(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}
	public Integer getIdModoStatusEstacao() {
		return idModoStatusEstacao;
	}
	public void setIdModoStatusEstacao(Integer idModoStatusEstacao) {
		this.idModoStatusEstacao = idModoStatusEstacao;
	}
	public Integer getIdToqueStatusEstacao() {
		return idToqueStatusEstacao;
	}
	public void setIdToqueStatusEstacao(Integer idToqueStatusEstacao) {
		this.idToqueStatusEstacao = idToqueStatusEstacao;
	}

	public StatusEstacaoHistorico() {
		super();
	}
	public StatusEstacaoHistorico(Integer idStatusEstacaoHistorico,
			Date dataHoraStatusEstacaoHistorico, Integer idEstacao,
			Integer idModoStatusEstacao, Integer idToqueStatusEstacao) {
		super();
		this.idStatusEstacaoHistorico = idStatusEstacaoHistorico;
		this.dataHoraStatusEstacaoHistorico = dataHoraStatusEstacaoHistorico;
		this.idEstacao = idEstacao;
		this.idModoStatusEstacao = idModoStatusEstacao;
		this.idToqueStatusEstacao = idToqueStatusEstacao;
	}
	

	
}