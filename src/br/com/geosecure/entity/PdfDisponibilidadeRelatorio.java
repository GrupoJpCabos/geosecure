package br.com.geosecure.entity;


import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="pdfdisponibilidaderelatorio")
public class PdfDisponibilidadeRelatorio {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPdfDisponibilidade;
	@Column
	private String nome;
	@Column
	private Double tempoAnualDisponivel;
	@Column
	private Double tempoMensalDisponivel;
	@Column
	private Double porcentual;
	
	@OneToMany(mappedBy="disponibilidadeRelatorio2")
	private List<PdfDisponibilidade365> disponibilidade365;
	
	
	@OneToMany(mappedBy="disponibilidadeRelatorio")
	private List<PdfDisponibilidade30> disponibilidade30;
	
	
	
	
	public List<PdfDisponibilidade30> getDisponibilidade30() {
		return disponibilidade30;
	}
	public void setDisponibilidade30(List<PdfDisponibilidade30> disponibilidade30) {
		this.disponibilidade30 = disponibilidade30;
	}
	public List<PdfDisponibilidade365> getDisponibilidade365() {
		return disponibilidade365;
	}
	public void setDisponibilidade365(List<PdfDisponibilidade365> disponibilidade365) {
		this.disponibilidade365 = disponibilidade365;
	}
	public Integer getIdPdfDisponibilidade() {
		return idPdfDisponibilidade;
	}
	public void setIdPdfDisponibilidade(Integer idPdfDisponibilidade) {
		this.idPdfDisponibilidade = idPdfDisponibilidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getTempoAnualDisponivel() {
		return tempoAnualDisponivel;
	}
	public void setTempoAnualDisponivel(Double tempoAnualDisponivel) {
		this.tempoAnualDisponivel = tempoAnualDisponivel;
	}
	public Double getTempoMensalDisponivel() {
		return tempoMensalDisponivel;
	}
	public void setTempoMensalDisponivel(Double tempoMensalDisponivel) {
		this.tempoMensalDisponivel = tempoMensalDisponivel;
	}
	public Double getPorcentual() {
		return porcentual;
	}
	public void setPorcentual(Double porcentual) {
		this.porcentual = porcentual;

	}
	


	public PdfDisponibilidadeRelatorio() {
		super();
	}
	public PdfDisponibilidadeRelatorio(Integer idPdfDisponibilidade,
			String nome, Double tempoAnualDisponivel,
			Double tempoMensalDisponivel, Double porcentual) {
		super();
		this.idPdfDisponibilidade = idPdfDisponibilidade;
		this.nome = nome;
		this.tempoAnualDisponivel = tempoAnualDisponivel;
		this.tempoMensalDisponivel = tempoMensalDisponivel;
		this.porcentual = porcentual;
	}
}