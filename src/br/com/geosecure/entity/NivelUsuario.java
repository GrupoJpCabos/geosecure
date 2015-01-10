package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="nivelusuario")
public class NivelUsuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idNivelUsuario;
	@Column
	private String nivel;
	
	@OneToMany(mappedBy="nivelUsuario")
	private List<Usuario> usuario;
	
	
	public Integer getIdNivelUsuario() {
		return idNivelUsuario;
	}
	public void setIdNivelUsuario(Integer idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public NivelUsuario(Integer idNivelUsuario, String nivel) {
		super();
		this.idNivelUsuario = idNivelUsuario;
		this.nivel = nivel;
	}
	
	public NivelUsuario() {
		super();
	}
	@Override
	public String toString() {
		return "NivelUsuario [idNivelUsuario=" + idNivelUsuario + ", nivel="
				+ nivel + "]";
	}
	
	
}
