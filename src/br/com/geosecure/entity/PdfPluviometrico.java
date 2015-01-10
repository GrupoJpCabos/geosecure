package br.com.geosecure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pdfpluviometrico")
public class PdfPluviometrico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idListLeituraModelo;
	@Column
	private String nome;
	@Column
	private Float leitura;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	
	public Integer getIdListLeituraModelo() {
		return idListLeituraModelo;
	}
	public void setIdListLeituraModelo(Integer idListLeituraModelo) {
		this.idListLeituraModelo = idListLeituraModelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Float getLeitura() {
		return leitura;
	}
	public void setLeitura(Float leitura) {
		this.leitura = leitura;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public PdfPluviometrico(Integer idListLeituraModelo, String nome,
			Float leitura, Date dataInicial, Date dataFinal) {
		super();
		this.idListLeituraModelo = idListLeituraModelo;
		this.nome = nome;
		this.leitura = leitura;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	public PdfPluviometrico() {
		super();
	}
	@Override
	public String toString() {
		return "ListLeituraModelo [idListLeituraModelo=" + idListLeituraModelo
				+ ", nome=" + nome + ", leitura=" + leitura + ", dataInicial="
				+ dataInicial + ", dataFinal=" + dataFinal + "]";
	}
	

	
}
