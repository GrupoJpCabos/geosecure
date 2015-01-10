package br.com.geosecure.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="pdfdisponibilidade30")
public class PdfDisponibilidade30 {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column
	private Integer id;
	@Column
	private String modo30;
	@Column
	private Double total30;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio30;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim30;
	@ManyToOne
	@JoinColumn(name="idPdfDiponibilidadeRelatorio")
	private PdfDisponibilidadeRelatorio disponibilidadeRelatorio;
	
	
	public PdfDisponibilidadeRelatorio getDisponibilidadeRelatorio() {
		return disponibilidadeRelatorio;
	}
	public void setDisponibilidadeRelatorio(
			PdfDisponibilidadeRelatorio disponibilidadeRelatorio) {
		this.disponibilidadeRelatorio = disponibilidadeRelatorio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModo30() {
		return modo30;
	}
	public void setModo30(String modo30) {
		this.modo30 = modo30;
	}
	public Double getTotal30() {
		return total30;
	}
	public void setTotal30(Double total30) {
		this.total30 = total30;
	}
	public Date getDataInicio30() {
		return dataInicio30;
	}
	public void setDataInicio30(Date dataInicio30) {
		this.dataInicio30 = dataInicio30;
	}
	public Date getDataFim30() {
		return dataFim30;
	}
	public void setDataFim30(Date dataFim30) {
		this.dataFim30 = dataFim30;
	}
	public PdfDisponibilidade30(Integer id, String modo30, Double total30,
			Date dataInicio30, Date dataFim30) {
		super();
		this.id = id;
		this.modo30 = modo30;
		this.total30 = total30;
		this.dataInicio30 = dataInicio30;
		this.dataFim30 = dataFim30;
	}
	public PdfDisponibilidade30() {
		super();
	}
	
}
