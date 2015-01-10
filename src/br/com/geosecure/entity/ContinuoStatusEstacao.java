package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="continuostatusestacao")
public class ContinuoStatusEstacao {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContinuoStatusEstacao;
	@Column
	private Integer idEstacao;
	@Column
	private Integer modoStatusEstacao;
	@Column
	private Double totalEstacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	@Column
	private Integer cont;
	@OneToOne(mappedBy="continuoStatusEstacao",cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private StatusEstacao statusEstacao;
	
	public Integer getIdContinuoStatusEstacao() {
		return idContinuoStatusEstacao;
	}

	public void setIdContinuoStatusEstacao(Integer idContinuoStatusEstacao) {
		this.idContinuoStatusEstacao = idContinuoStatusEstacao;
	}

	public Integer getIdEstacao() {
		return idEstacao;
	}

	public void setIdEstacao(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}
	
	public Double getTotalEstacao() {
		return totalEstacao;
	}

	public void setTotalEstacao(Double totalEstacao) {
		this.totalEstacao = totalEstacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}
	
	public Integer getModoStatusEstacao() {
		return modoStatusEstacao;
	}

	public void setModoStatusEstacao(Integer modoStatusEstacao) {
		this.modoStatusEstacao = modoStatusEstacao;
	}

	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}

	public ContinuoStatusEstacao(Integer idContinuoStatusEstacao,
			Integer idEstacao, Double totalEstacao, Date dataInicio,
			Date dataFinal, Integer cont) {
		super();
		this.idContinuoStatusEstacao = idContinuoStatusEstacao;
		this.idEstacao = idEstacao;
		this.totalEstacao = totalEstacao;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.cont = cont;
	}

	public ContinuoStatusEstacao() {
		super();
	}

	@Override
	public String toString() {
		return "ContinuoStatusEstacao [idContinuoStatusEstacao="
				+ idContinuoStatusEstacao + ", idEstacao=" + idEstacao
				+ ", totalEstacao=" + totalEstacao + ", dataInicio="
				+ dataInicio + ", dataFinal=" + dataFinal + ", cont=" + cont
				+ "]";
	}
	
	
	
}
