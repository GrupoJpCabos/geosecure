package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="ultimocheck")
public class UltimoCheck {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idUltimoCheck;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraUltimoCheck;

	public Integer getIdUltimoCheck() {
		return idUltimoCheck;
	}

	public void setIdUltimoCheck(Integer idUltimoCheck) {
		this.idUltimoCheck = idUltimoCheck;
	}

	public Date getDataHoraUltimoCheck() {
		return dataHoraUltimoCheck;
	}

	public void setDataHoraUltimoCheck(Date dataHoraUltimoCheck) {
		this.dataHoraUltimoCheck = dataHoraUltimoCheck;
	}

	public UltimoCheck(Integer idUltimoCheck, Date dataHoraUltimoCheck) {
		super();
		this.idUltimoCheck = idUltimoCheck;
		this.dataHoraUltimoCheck = dataHoraUltimoCheck;
	}

	public UltimoCheck() {
		super();
	}
	
}
