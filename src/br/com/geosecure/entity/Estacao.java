package br.com.geosecure.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="estacao")
public class Estacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idEstacao;
	
	@Column
	private String nomeEstacao;
	
	@ManyToOne
	@JoinColumn(name="idTipoEstacao")
	private TipoEstacao tipoestacao;
	
	@OneToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="idEnderecoEstacao", unique=true)
	private EnderecoEstacao enderecoestacao;
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="idAcessoEstacao", unique=true)
	private AcessoEstacao acessoestacao;
	
	@ManyToOne
	@JoinColumn(name="idGrupoEstacao")
	private GrupoEstacao grupoestacao;
	
	@OneToOne(mappedBy="estacaose", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private StatusEstacao statusestacao;
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="idPluviometro", unique=true)
	private Pluviometro pluviometroe;

	@OneToMany(mappedBy="estacaoah")
	private List<AcaoHistorico> acaoHistorico;
	
	
	
	
	
	
	
	

	
	
	public List<AcaoHistorico> getAcaoHistorico() {
		return acaoHistorico;
	}
	public void setAcaoHistorico(List<AcaoHistorico> acaoHistorico) {
		this.acaoHistorico = acaoHistorico;
	}
	public Pluviometro getPluviometroe() {
		return pluviometroe;
	}
	public void setPluviometroe(Pluviometro pluviometroe) {
		this.pluviometroe = pluviometroe;
	}
	public StatusEstacao getStatusestacao() {
		return statusestacao;
	}
	public void setStatusestacao(StatusEstacao statusestacao) {
		this.statusestacao = statusestacao;
	}
	public GrupoEstacao getGrupoestacao() {
		return grupoestacao;
	}
	public void setGrupoestacao(GrupoEstacao grupoestacao) {
		this.grupoestacao = grupoestacao;
	}
	public AcessoEstacao getAcessoestacao() {
		return acessoestacao;
	}
	public void setAcessoestacao(AcessoEstacao acessoestacao) {
		this.acessoestacao = acessoestacao;
	}
	public EnderecoEstacao getEnderecoestacao() {
		return enderecoestacao;
	}
	public void setEnderecoestacao(EnderecoEstacao enderecoestacao) {
		this.enderecoestacao = enderecoestacao;
	}
	public TipoEstacao getTipoestacao() {
		return tipoestacao;
	}
	public void setTipoestacao(TipoEstacao tipoestacao) {
		this.tipoestacao = tipoestacao;
	}
	public Integer getIdEstacao() {
		return idEstacao;
	}
	public void setIdEstacao(Integer idEstacao) {
		this.idEstacao = idEstacao;
	}
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
	public Estacao(Integer idEstacao, String nomeEstacao) {
		super();
		this.idEstacao = idEstacao;
		this.nomeEstacao = nomeEstacao;
	}
	public Estacao() {
		super();
	}
	
	

}
