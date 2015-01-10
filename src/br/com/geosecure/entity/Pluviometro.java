package br.com.geosecure.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pluviometro")
public class Pluviometro {
	@Id
	@Column
	private Integer idPluviometro;
	
	@Column
	private Float tempo15minutos;
	
	@Column
	private Float tempo30minutos;
	
	@Column
	private Float tempo45minutos;
	
	@Column
	private Float tempo60minutos;
	
	@Column
	private Float tempo120minutos;
	
	@Column
	private Float tempo180minutos;
	
	@Column
	private Float tempo240minutos;
	
	@Column
	private Float tempo1440minutos; //1dia
	
	@Column
	private Float tempo2880minutos; //2dias
	
	@Column
	private Float tempo4320minutos; //3dias
	
	@Column
	private Float tempo5760minutos; //4dias
	
	@Column
	private Float tempo43200minutos; //1mês
	
	@Column
	private Float tempo525600minutos; //1ano
	
	
	@Column
	private Float multiplicador;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraPluviometro;

	@OneToMany(mappedBy="pluviometro")
	private List<PluviometroHistoricoLeitura> pluviometroHistoricoLeitura;
	
	@OneToOne(mappedBy="pluviometroe", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private Estacao estacaop;
	
	@OneToMany(mappedBy="pluviometroCrescente")
	private List<PluviometroHistoricoLeituraCrescente> pluviometroHistoricoLeituraCrescente;
	
	
	
	
	
	public List<PluviometroHistoricoLeituraCrescente> getPluviometroHistoricoLeituraCrescente() {
		return pluviometroHistoricoLeituraCrescente;
	}
	public void setPluviometroHistoricoLeituraCrescente(
			List<PluviometroHistoricoLeituraCrescente> pluviometroHistoricoLeituraCrescente) {
		this.pluviometroHistoricoLeituraCrescente = pluviometroHistoricoLeituraCrescente;
	}
	public Date getDataHora() {
		return dataHoraPluviometro;
	}
	public void setDataHora(Date dataHora) {
		this.dataHoraPluviometro = dataHora;
	}
	public List<PluviometroHistoricoLeitura> getPluviometroHistoricoLeitura() {
		return pluviometroHistoricoLeitura;
	}
	public void setPluviometroHistoricoLeitura(
			List<PluviometroHistoricoLeitura> pluviometroHistoricoLeitura) {
		this.pluviometroHistoricoLeitura = pluviometroHistoricoLeitura;
	}
	public Estacao getEstacaop() {
		return estacaop;
	}
	public void setEstacaop(Estacao estacaop) {
		this.estacaop = estacaop;
	}
	public Integer getIdPluviometro() {
		return idPluviometro;
	}
	public void setIdPluviometro(Integer idPluviometro) {
		this.idPluviometro = idPluviometro;
	}
	public Float getTempo15minutos() {
		return tempo15minutos;
	}
	public void setTempo15minutos(Float tempo15minutos) {
		this.tempo15minutos = tempo15minutos;
	}
	public Float getTempo30minutos() {
		return tempo30minutos;
	}
	public void setTempo30minutos(Float tempo30minutos) {
		this.tempo30minutos = tempo30minutos;
	}
	public Float getTempo45minutos() {
		return tempo45minutos;
	}
	public void setTempo45minutos(Float tempo45minutos) {
		this.tempo45minutos = tempo45minutos;
	}
	public Float getTempo60minutos() {
		return tempo60minutos;
	}
	public void setTempo60minutos(Float tempo60minutos) {
		this.tempo60minutos = tempo60minutos;
	}
	public Float getTempo120minutos() {
		return tempo120minutos;
	}
	public void setTempo120minutos(Float tempo120minutos) {
		this.tempo120minutos = tempo120minutos;
	}
	public Float getTempo180minutos() {
		return tempo180minutos;
	}
	public void setTempo180minutos(Float tempo180minutos) {
		this.tempo180minutos = tempo180minutos;
	}
	public Float getTempo240minutos() {
		return tempo240minutos;
	}
	public void setTempo240minutos(Float tempo240minutos) {
		this.tempo240minutos = tempo240minutos;
	}
	public Float getTempo1440minutos() {
		return tempo1440minutos;
	}
	public void setTempo1440minutos(Float tempo1440minutos) {
		this.tempo1440minutos = tempo1440minutos;
	}
	public Float getTempo2880minutos() {
		return tempo2880minutos;
	}
	public void setTempo2880minutos(Float tempo2880minutos) {
		this.tempo2880minutos = tempo2880minutos;
	}
	public Float getTempo4320minutos() {
		return tempo4320minutos;
	}
	public void setTempo4320minutos(Float tempo4320minutos) {
		this.tempo4320minutos = tempo4320minutos;
	}
	public Float getTempo5760minutos() {
		return tempo5760minutos;
	}
	public void setTempo5760minutos(Float tempo5760minutos) {
		this.tempo5760minutos = tempo5760minutos;
	}
	public Float getTempo43200minutos() {
		return tempo43200minutos;
	}
	public void setTempo43200minutos(Float tempo43200minutos) {
		this.tempo43200minutos = tempo43200minutos;
	}
	public Float getTempo525600minutos() {
		return tempo525600minutos;
	}
	public void setTempo525600minutos(Float tempo525600minutos) {
		this.tempo525600minutos = tempo525600minutos;
	}
	public Float getMultiplicador() {
		return multiplicador;
	}
	public void setMultiplicador(Float multiplicador) {
		this.multiplicador = multiplicador;
	}
	public Pluviometro(Integer idPluviometro, Float tempo15minutos,
			Float tempo30minutos, Float tempo45minutos, Float tempo60minutos,
			Float tempo120minutos, Float tempo180minutos,
			Float tempo240minutos, Float tempo1440minutos,
			Float tempo2880minutos, Float tempo4320minutos,
			Float tempo5760minutos, Float tempo43200minutos,
			Float tempo525600minutos, Float multiplicador, Date dataHora) {
		super();
		this.idPluviometro = idPluviometro;
		this.tempo15minutos = tempo15minutos;
		this.tempo30minutos = tempo30minutos;
		this.tempo45minutos = tempo45minutos;
		this.tempo60minutos = tempo60minutos;
		this.tempo120minutos = tempo120minutos;
		this.tempo180minutos = tempo180minutos;
		this.tempo240minutos = tempo240minutos;
		this.tempo1440minutos = tempo1440minutos;
		this.tempo2880minutos = tempo2880minutos;
		this.tempo4320minutos = tempo4320minutos;
		this.tempo5760minutos = tempo5760minutos;
		this.tempo43200minutos = tempo43200minutos;
		this.tempo525600minutos = tempo525600minutos;
		this.multiplicador = multiplicador;
		this.dataHoraPluviometro = dataHora;
	}
	public Pluviometro() {
		super();
	}
	
	

}
