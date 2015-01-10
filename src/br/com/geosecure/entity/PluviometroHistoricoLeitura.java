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
@Table(name="pluviometrohistoricoleitura")
public class PluviometroHistoricoLeitura {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idPluviometroHistoricoLeitura;
	@Column
	private Double leituraPluviometroHistoricoLeitura;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraPluviometroHistoricoLeitura;
	
	@ManyToOne
	@JoinColumn(name="idPluviometro")
	private Pluviometro pluviometro;

	
	public Pluviometro getPluviometro() {
		return pluviometro;
	}
	public void setPluviometro(Pluviometro pluviometro) {
		this.pluviometro = pluviometro;
	}
	public Integer getIdPluviometroHistoricoLeitura() {
		return idPluviometroHistoricoLeitura;
	}
	public void setIdPluviometroHistoricoLeitura(
			Integer idPluviometroHistoricoLeitura) {
		this.idPluviometroHistoricoLeitura = idPluviometroHistoricoLeitura;
	}
	public Double getLeituraPluviometroHistoricoLeitura() {
		return leituraPluviometroHistoricoLeitura;
	}
	public void setLeituraPluviometroHistoricoLeitura(
			Double leituraPluviometroHistoricoLeitura) {
		this.leituraPluviometroHistoricoLeitura = leituraPluviometroHistoricoLeitura;
	}
	public Date getDataHoraPluviometroHistoricoLeitura() {
		return dataHoraPluviometroHistoricoLeitura;
	}
	public void setDataHoraPluviometroHistoricoLeitura(
			Date dataHoraPluviometroHistoricoLeitura) {
		this.dataHoraPluviometroHistoricoLeitura = dataHoraPluviometroHistoricoLeitura;
	}
	public PluviometroHistoricoLeitura(Integer idPluviometroHistoricoLeitura,
			Double leituraPluviometroHistoricoLeitura,
			Date dataHoraPluviometroHistoricoLeitura) {
		super();
		this.idPluviometroHistoricoLeitura = idPluviometroHistoricoLeitura;
		this.leituraPluviometroHistoricoLeitura = leituraPluviometroHistoricoLeitura;
		this.dataHoraPluviometroHistoricoLeitura = dataHoraPluviometroHistoricoLeitura;
	}
	public PluviometroHistoricoLeitura() {
		super();
	}
	
	
	
}
