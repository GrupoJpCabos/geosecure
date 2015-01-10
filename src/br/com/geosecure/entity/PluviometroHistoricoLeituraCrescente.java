package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="pluviometrohistoricoleituracrescente")
public class PluviometroHistoricoLeituraCrescente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idPluviometroHistoricoLeituraCrescente;
	@Column
	private Double leituraPluviometroHistoricoLeituraCrescente;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraPluviometroHistoricoLeituraCrescente;
	
	@ManyToOne
	@JoinColumn(name="idPluviometro")
	private Pluviometro pluviometroCrescente;

	public Integer getIdPluviometroHistoricoLeituraCrescente() {
		return idPluviometroHistoricoLeituraCrescente;
	}

	public void setIdPluviometroHistoricoLeituraCrescente(
			Integer idPluviometroHistoricoLeituraCrescente) {
		this.idPluviometroHistoricoLeituraCrescente = idPluviometroHistoricoLeituraCrescente;
	}

	public Double getLeituraPluviometroHistoricoLeituraCrescente() {
		return leituraPluviometroHistoricoLeituraCrescente;
	}

	public void setLeituraPluviometroHistoricoLeituraCrescente(
			Double leituraPluviometroHistoricoLeituraCrescente) {
		this.leituraPluviometroHistoricoLeituraCrescente = leituraPluviometroHistoricoLeituraCrescente;
	}

	public Date getDataHoraPluviometroHistoricoLeituraCrescente() {
		return dataHoraPluviometroHistoricoLeituraCrescente;
	}

	public void setDataHoraPluviometroHistoricoLeituraCrescente(
			Date dataHoraPluviometroHistoricoLeituraCrescente) {
		this.dataHoraPluviometroHistoricoLeituraCrescente = dataHoraPluviometroHistoricoLeituraCrescente;
	}

	public Pluviometro getPluviometroCrescente() {
		return pluviometroCrescente;
	}

	public void setPluviometroCrescente(Pluviometro pluviometroCrescente) {
		this.pluviometroCrescente = pluviometroCrescente;
	}

	public PluviometroHistoricoLeituraCrescente(
			Integer idPluviometroHistoricoLeituraCrescente,
			Double leituraPluviometroHistoricoLeituraCrescente,
			Date dataHoraPluviometroHistoricoLeituraCrescente) {
		super();
		this.idPluviometroHistoricoLeituraCrescente = idPluviometroHistoricoLeituraCrescente;
		this.leituraPluviometroHistoricoLeituraCrescente = leituraPluviometroHistoricoLeituraCrescente;
		this.dataHoraPluviometroHistoricoLeituraCrescente = dataHoraPluviometroHistoricoLeituraCrescente;
	}

	public PluviometroHistoricoLeituraCrescente() {
		super();
	}

	@Override
	public String toString() {
		return "PluviometroHistoricoLeituraCrescente [idPluviometroHistoricoLeituraCrescente="
				+ idPluviometroHistoricoLeituraCrescente
				+ ", leituraPluviometroHistoricoLeituraCrescente="
				+ leituraPluviometroHistoricoLeituraCrescente
				+ ", dataHoraPluviometroHistoricoLeituraCrescente="
				+ dataHoraPluviometroHistoricoLeituraCrescente + "]";
	}

	
	
	
}
