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
@Table(name="acaohistorico")
public class AcaoHistorico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idAcaoHistorico;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idEstacao")
	private Estacao estacaoah;
	
	@Column
	private Integer toqueStatusEstacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraAcaoHistorico;
	
	
	public Date getDataHoraAcaoHistorico() {
		return dataHoraAcaoHistorico;
	}
	public void setDataHoraAcaoHistorico(Date dataHoraAcaoHistorico) {
		this.dataHoraAcaoHistorico = dataHoraAcaoHistorico;
	}
	public Integer getToqueStatusEstacao() {
		return toqueStatusEstacao;
	}
	public void setToqueStatusEstacao(Integer toqueStatusEstacao) {
		this.toqueStatusEstacao = toqueStatusEstacao;
	}
	public Integer getIdAcaoHistorico() {
		return idAcaoHistorico;
	}
	public void setIdAcaoHistorico(Integer idAcaoHistorico) {
		this.idAcaoHistorico = idAcaoHistorico;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Estacao getEstacaoah() {
		return estacaoah;
	}
	public void setEstacaoah(Estacao estacaoah) {
		this.estacaoah = estacaoah;
	}
	public AcaoHistorico(Integer idAcaoHistorico, Date dataHoraAcaoHistorico) {
		super();
		this.idAcaoHistorico = idAcaoHistorico;
		this.dataHoraAcaoHistorico = dataHoraAcaoHistorico;
	}
	public AcaoHistorico() {
		super();
	}
	@Override
	public String toString() {
		return "AcaoHistorico [idAcaoHistorico=" + idAcaoHistorico
				+ ", dataHoraAcaoHistorico=" + dataHoraAcaoHistorico + "]";
	}
	
	
}
