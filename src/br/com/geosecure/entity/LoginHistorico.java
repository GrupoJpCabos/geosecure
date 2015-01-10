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
@Table(name="loginhistorico")
public class LoginHistorico {
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer idHistoricoLogin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraLoginHistorico;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuariolh;
	
	
	
	public Date getDataHoraLoginHistorico() {
		return dataHoraLoginHistorico;
	}
	public void setDataHoraLoginHistorico(Date dataHoraLoginHistorico) {
		this.dataHoraLoginHistorico = dataHoraLoginHistorico;
	}
	public Usuario getUsuariolh() {
		return usuariolh;
	}
	public void setUsuariolh(Usuario usuariolh) {
		this.usuariolh = usuariolh;
	}
	public Integer getIdHistoricoLogin() {
		return idHistoricoLogin;
	}
	public void setIdHistoricoLogin(Integer idHistoricoLogin) {
		this.idHistoricoLogin = idHistoricoLogin;
	}

	public Date getDataHora() {
		return dataHoraLoginHistorico;
	}
	public void setDataHora(Date dataHora) {
		this.dataHoraLoginHistorico = dataHora;
	}
	public LoginHistorico(Integer idHistoricoLogin, Date dataHora) {
		super();
		this.idHistoricoLogin = idHistoricoLogin;

		this.dataHoraLoginHistorico = dataHora;
	}
	public LoginHistorico() {
		super();
	}
	@Override
	public String toString() {
		return "LoginHistorico [idHistoricoLogin=" + idHistoricoLogin
				+ ", dataHoraLoginHistorico=" + dataHoraLoginHistorico + "]";
	}
	
	
	
	
	
	
	
}
