package br.com.geosecure.entity;



import javax.persistence.*;


@Entity
@Table(name="disponibilidadestatusestacao")
public class DisponibilidadeStatusEstacao {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idDisponibilidadeStatusEstacao;
	
	@Column
	private Double indisponibilidadeAnual;
	
	@Column
	private Double disponibilidadeAnual;
	
	@OneToOne(mappedBy="disponibilidadeStatusEstacao",cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private StatusEstacao statusEstacao;

	public Integer getIdDisponibilidadeStatusEstacao() {
		return idDisponibilidadeStatusEstacao;
	}

	public void setIdDisponibilidadeStatusEstacao(
			Integer idDisponibilidadeStatusEstacao) {
		this.idDisponibilidadeStatusEstacao = idDisponibilidadeStatusEstacao;
	}


	public Double getIndisponibilidadeAnual() {
		return indisponibilidadeAnual;
	}

	public void setIndisponibilidadeAnual(Double indisponibilidadeAnual) {
		this.indisponibilidadeAnual = indisponibilidadeAnual;
	}
	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}

	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}

	public Double getDisponibilidadeAnual() {
		return disponibilidadeAnual;
	}

	public void setDisponibilidadeAnual(Double disponibilidadeAnual) {
		this.disponibilidadeAnual = disponibilidadeAnual;
	}

	public DisponibilidadeStatusEstacao(Integer idDisponibilidadeStatusEstacao,
			Double indisponibilidadeAnual, Double disponibilidadeAnual,
			StatusEstacao statusEstacao) {
		super();
		this.idDisponibilidadeStatusEstacao = idDisponibilidadeStatusEstacao;
		this.indisponibilidadeAnual = indisponibilidadeAnual;
		this.disponibilidadeAnual = disponibilidadeAnual;
		this.statusEstacao = statusEstacao;
	}

	public DisponibilidadeStatusEstacao() {
		super();
	}

	@Override
	public String toString() {
		return "DisponibilidadeStatusEstacao [idDisponibilidadeStatusEstacao="
				+ idDisponibilidadeStatusEstacao + ", indisponibilidadeAnual="
				+ indisponibilidadeAnual + ", disponibilidadeAnual="
				+ disponibilidadeAnual + ", statusEstacao=" + statusEstacao
				+ "]";
	}
	
	
	
	
	
	
}