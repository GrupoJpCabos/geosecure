package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idUsuario;
	
	@Column
	private String nomeUsuario;
	@Column(unique=true)
	private String loginUsuario;
	@Column
	private String senhaUsuario;
	
	@ManyToOne
	@JoinColumn(name="idNivelUsuario")
	private NivelUsuario nivelUsuario;
	
	@OneToMany(mappedBy="usuario")
	private List<AcaoHistorico> acaoHistorico;
	
	@OneToMany(mappedBy="usuariolh")
	private List<LoginHistorico> loginHistorico;
	
	
	public List<LoginHistorico> getLoginHistorico() {
		return loginHistorico;
	}

	public void setLoginHistorico(List<LoginHistorico> loginHistorico) {
		this.loginHistorico = loginHistorico;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public NivelUsuario getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(NivelUsuario nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public List<AcaoHistorico> getAcaoHistorico() {
		return acaoHistorico;
	}

	public void setAcaoHistorico(List<AcaoHistorico> acaoHistorico) {
		this.acaoHistorico = acaoHistorico;
	}

	public Usuario(Integer idUsuario, String nomeUsuario, String loginUsuario,
			String senhaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUsuario="
				+ nomeUsuario + ", loginUsuario=" + loginUsuario
				+ ", senhaUsuario=" + senhaUsuario + "]";
	}


	
	
}
