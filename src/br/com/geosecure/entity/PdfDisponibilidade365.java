package br.com.geosecure.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="pdfdisponibilidade365")
public class PdfDisponibilidade365 {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPdfDisponibilidade365;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio365;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim365;
	
	@Column
	private String modo365;
	
	@Column
	private Double total365;
	
	@ManyToOne
	@JoinColumn(name="idPdfDisponibilidadeRelatorio")
	private PdfDisponibilidadeRelatorio disponibilidadeRelatorio2;
	
	
	public PdfDisponibilidadeRelatorio getDisponibilidadeRelatorio2() {
		return disponibilidadeRelatorio2;
	}
	public void setDisponibilidadeRelatorio2(
			PdfDisponibilidadeRelatorio disponibilidadeRelatorio2) {
		this.disponibilidadeRelatorio2 = disponibilidadeRelatorio2;
	}
	public Integer getIdPdfDisponibilidade365() {
		return idPdfDisponibilidade365;
	}
	public void setIdPdfDisponibilidade365(Integer idPdfDisponibilidade365) {
		this.idPdfDisponibilidade365 = idPdfDisponibilidade365;
	}
	public Date getDataInicio365() {
		return dataInicio365;
	}
	public void setDataInicio365(Date dataInicio365) {
		this.dataInicio365 = dataInicio365;
	}
	public Date getDataFim365() {
		return dataFim365;
	}
	public void setDataFim365(Date dataFim365) {
		this.dataFim365 = dataFim365;
	}
	public String getModo365() {
		return modo365;
	}
	public void setModo365(String modo365) {
		this.modo365 = modo365;
	}
	public Double getTotal365() {
		return total365;
	}
	public void setTotal365(Double total365) {
		this.total365 = total365;
	}
	public PdfDisponibilidade365(Integer idPdfDisponibilidade365,
			Date dataInicio365, Date dataFim365, String modo365, Double total365) {
		super();
		this.idPdfDisponibilidade365 = idPdfDisponibilidade365;
		this.dataInicio365 = dataInicio365;
		this.dataFim365 = dataFim365;
		this.modo365 = modo365;
		this.total365 = total365;
	}
	public PdfDisponibilidade365() {
		super();
	}
	@Override
	public String toString() {
		return "PdfDisponibilidade365 [idPdfDisponibilidade365="
				+ idPdfDisponibilidade365 + ", dataInicio365=" + dataInicio365
				+ ", dataFim365=" + dataFim365 + ", modo365=" + modo365
				+ ", total365=" + total365 + "]";
	}
	
	
}
