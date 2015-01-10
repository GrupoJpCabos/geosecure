package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="statusestacao")
public class StatusEstacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idStatusEstacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraStatusEstacao;
	
	@Column
	private String pause;
	
	@Column
	private String amplificador;
	
	@Column
	private String porta;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idEstacao" , unique=true)
	private Estacao estacaose;
	
	@ManyToOne
	@JoinColumn(name="idModoStatusEstacao")
	private ModoStatusEstacao modostatusestacao;
	
	@ManyToOne
	@JoinColumn(name="idToqueStatusEstacao")
	private ToqueStatusEstacao toquestatusestacao;
	
	@OneToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="idDisponibilidadeStatusEstacao", unique=true)
	private DisponibilidadeStatusEstacao disponibilidadeStatusEstacao;
	
	@OneToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="idContinuoStatusEstacao")
	private ContinuoStatusEstacao continuoStatusEstacao;
	
	
	public ContinuoStatusEstacao getContinuoStatusEstacao() {
		return continuoStatusEstacao;
	}

	public void setContinuoStatusEstacao(ContinuoStatusEstacao continuoStatusEstacao) {
		this.continuoStatusEstacao = continuoStatusEstacao;
	}

	public DisponibilidadeStatusEstacao getDisponibilidadeStatusEstacao() {
		return disponibilidadeStatusEstacao;
	}

	public void setDisponibilidadeStatusEstacao(
			DisponibilidadeStatusEstacao disponibilidadeStatusEstacao) {
		this.disponibilidadeStatusEstacao = disponibilidadeStatusEstacao;
	}

	public Estacao getEstacaose() {
		return estacaose;
	}

	public void setEstacaose(Estacao estacaose) {
		this.estacaose = estacaose;
	}

	public Integer getIdStatusEstacao() {
		return idStatusEstacao;
	}

	public void setIdStatusEstacao(Integer idStatusEstacao) {
		this.idStatusEstacao = idStatusEstacao;
	}

	public Date getDataHoraStatusEstacao() {
		return dataHoraStatusEstacao;
	}

	public void setDataHoraStatusEstacao(Date dataHoraStatusEstacao) {
		this.dataHoraStatusEstacao = dataHoraStatusEstacao;
	}

	public ModoStatusEstacao getModostatusestacao() {
		return modostatusestacao;
	}

	public void setModostatusestacao(ModoStatusEstacao modostatusestacao) {
		this.modostatusestacao = modostatusestacao;
	}

	public ToqueStatusEstacao getToquestatusestacao() {
		return toquestatusestacao;
	}

	public void setToquestatusestacao(ToqueStatusEstacao toquestatusestacao) {
		this.toquestatusestacao = toquestatusestacao;
	}
	

	public String getPause() {
		return pause;
	}

	public void setPause(String pause) {
		this.pause = pause;
	}
	

	public String getAmplificador() {
		return amplificador;
	}

	public void setAmplificador(String amplificador) {
		this.amplificador = amplificador;
	}
	

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public StatusEstacao(Integer idStatusEstacao, Date dataHoraStatusEstacao,
			ModoStatusEstacao modostatusestacao,
			ToqueStatusEstacao toquestatusestacao) {
		super();
		this.idStatusEstacao = idStatusEstacao;
		this.dataHoraStatusEstacao = dataHoraStatusEstacao;
		this.modostatusestacao = modostatusestacao;
		this.toquestatusestacao = toquestatusestacao;
	}

	public StatusEstacao() {
		super();
	}

	@Override
	public String toString() {
		return "StatusEstacao [idStatusEstacao=" + idStatusEstacao
				+ ", dataHoraStatusEstacao=" + dataHoraStatusEstacao + "]";
	}

	
	
	
	
	
	
}
