package br.com.geosecure.entity;



import javax.persistence.*;


@Entity
@Table(name="pdfacionamentousuario")
public class PdfAcionamentoUsuario {
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer idPdfAcionamentoUsuario;
	@Column
	private String nome;
	@Column
	private String estacao;
	@Column
	private String toque;
	@Column
	private String data;
	public Integer getIdPdfAcionamentoUsuario() {
		return idPdfAcionamentoUsuario;
	}
	public void setIdPdfAcionamentoUsuario(Integer idPdfAcionamentoUsuario) {
		this.idPdfAcionamentoUsuario = idPdfAcionamentoUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstacao() {
		return estacao;
	}
	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}
	public String getToque() {
		return toque;
	}
	public void setToque(String toque) {
		this.toque = toque;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public PdfAcionamentoUsuario(Integer idPdfAcionamentoUsuario, String nome,
			String estacao, String toque, String data) {
		super();
		this.idPdfAcionamentoUsuario = idPdfAcionamentoUsuario;
		this.nome = nome;
		this.estacao = estacao;
		this.toque = toque;
		this.data = data;
	}
	public PdfAcionamentoUsuario() {
		super();
	}

	
	
}
