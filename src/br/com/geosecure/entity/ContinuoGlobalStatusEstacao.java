package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="continuoglobalstatusestacao")
public class ContinuoGlobalStatusEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idContinuoGlobalStatusEstacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraIncial;
	@Column
	private Double totalGlobal;
	public Integer getIdContinuoGlobalStatusEstacao() {
		return idContinuoGlobalStatusEstacao;
	}
	public void setIdContinuoGlobalStatusEstacao(
			Integer idContinuoGlobalStatusEstacao) {
		this.idContinuoGlobalStatusEstacao = idContinuoGlobalStatusEstacao;
	}
	public Date getDataHoraIncial() {
		return dataHoraIncial;
	}
	public void setDataHoraIncial(Date dataHoraIncial) {
		this.dataHoraIncial = dataHoraIncial;
	}
	public Double getTotalGlobal() {
		return totalGlobal;
	}
	public void setTotalGlobal(Double totalGlobal) {
		this.totalGlobal = totalGlobal;
	}
	public ContinuoGlobalStatusEstacao(Integer idContinuoGlobalStatusEstacao,
			Date dataHoraIncial, Double totalGlobal) {
		super();
		this.idContinuoGlobalStatusEstacao = idContinuoGlobalStatusEstacao;
		this.dataHoraIncial = dataHoraIncial;
		this.totalGlobal = totalGlobal;
	}
	public ContinuoGlobalStatusEstacao() {
		super();
	}
	@Override
	public String toString() {
		return "ContinuoGlobalStatusEstacao [idContinuoGlobalStatusEstacao="
				+ idContinuoGlobalStatusEstacao + ", dataHoraIncial="
				+ dataHoraIncial + ", totalGlobal=" + totalGlobal + "]";
	}
	
	
}
