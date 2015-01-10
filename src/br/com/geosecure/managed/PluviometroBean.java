package br.com.geosecure.managed;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;


import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.PdfPluviometrico;
import br.com.geosecure.entity.Pluviometro;
import br.com.geosecure.entity.PluviometroHistoricoConvertido;
import br.com.geosecure.entity.PluviometroHistoricoLeituraCrescente;
import br.com.geosecure.entity.Usuario;
import br.com.geosecure.persistence.EstacaoDao;
import br.com.geosecure.persistence.PdfPluviometricoDao;
import br.com.geosecure.persistence.PluviometroDao;
import br.com.geosecure.persistence.PluviometroHistoricoConvertidoDao;
import br.com.geosecure.persistence.PluviometroHistoricoLeituraCrescenteDao;

public class PluviometroBean {

	private Pluviometro pluviometro;
	private List<Pluviometro> listarPluviometro;
	private PluviometroHistoricoLeituraCrescente crescente;
	private List<PluviometroHistoricoLeituraCrescente> listarPluviometroCrescente;
	private Date dataInicio;
	private Date dataFim;
	private List<SelectItem> listarEstacao;
	private Estacao estacao;
	private Float totalLeitura;
	private String nome;
	private PluviometroHistoricoConvertido pluviometroHistoricoConvertido;
	private List<SelectItem> acao;
	private String opcao;
	private List<PdfPluviometrico> listaMenu;
	private PdfPluviometrico listaLeituraModelo;
	private Usuario usuario;

	public PluviometroBean() {
		pluviometro = new Pluviometro();
		crescente = new PluviometroHistoricoLeituraCrescente();
		listarPluviometroCrescente = new ArrayList<PluviometroHistoricoLeituraCrescente>();
		estacao = new Estacao();
		totalLeitura = null;
		nome = null;
		pluviometroHistoricoConvertido = new PluviometroHistoricoConvertido();
		acao = new ArrayList<SelectItem>();
		opcao = new String();
		listaLeituraModelo = new PdfPluviometrico();
		listaMenu = new ArrayList<PdfPluviometrico>();

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PdfPluviometrico getListaLeituraModelo() {

		return listaLeituraModelo;
	}

	public void setListaLeituraModelo(PdfPluviometrico listaLeituraModelo) {
		this.listaLeituraModelo = listaLeituraModelo;
	}

	public List<PdfPluviometrico> getListaMenu() {

		return listaMenu;
	}

	public void setListaMenu(List<PdfPluviometrico> listaMenu) {
		this.listaMenu = listaMenu;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public List<SelectItem> getAcao() {
		try {
			acao = new ArrayList<SelectItem>();
			acao.add(new SelectItem("Total"));
			acao.add(new SelectItem("de 15 em 15 minutos"));
			acao.add(new SelectItem("de 1 em 1 hora"));
			acao.add(new SelectItem("de 1 em 1 dia"));


		} catch (Exception e) {
			e.printStackTrace();
		}

		return acao;
	}

	public void setAcao(List<SelectItem> acao) {
		this.acao = acao;
	}

	public PluviometroHistoricoConvertido getPluviometroHistoricoConvertido() {
		return pluviometroHistoricoConvertido;
	}

	public void setPluviometroHistoricoConvertido(
			PluviometroHistoricoConvertido pluviometroHistoricoConvertido) {
		this.pluviometroHistoricoConvertido = pluviometroHistoricoConvertido;
	}

	public List<SelectItem> getListarEstacao() {
		try {
			listarEstacao = new ArrayList<SelectItem>();
			for (Estacao es : new EstacaoDao().findAllPluviometrica())
				listarEstacao.add(new SelectItem(es.getIdEstacao(), es
						.getNomeEstacao()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarEstacao;
	}

	public Float getTotalLeitura() {
		return totalLeitura;
	}

	public void setTotalLeitura(Float totalLeitura) {
		this.totalLeitura = totalLeitura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListarEstacao(List<SelectItem> listarEstacao) {
		this.listarEstacao = listarEstacao;
	}

	public List<PluviometroHistoricoLeituraCrescente> getListarPluviometroCrescente() {
		return listarPluviometroCrescente;
	}

	public void setListarPluviometroCrescente(
			List<PluviometroHistoricoLeituraCrescente> listarPluviometroCrescente) {
		this.listarPluviometroCrescente = listarPluviometroCrescente;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public PluviometroHistoricoLeituraCrescente getCrescente() {
		return crescente;
	}

	public void setCrescente(PluviometroHistoricoLeituraCrescente crescente) {
		this.crescente = crescente;
	}

	public Pluviometro getPluviometro() {

		return pluviometro;
	}

	public void setPluviometro(Pluviometro pluviometro) {
		this.pluviometro = pluviometro;
	}

	public List<Pluviometro> getListarPluviometro() {

		try {
			listarPluviometro = new PluviometroDao().findAll();
			for (Pluviometro p : listarPluviometro) {
				// System.out.println("Pluviometro: " + p.getIdPluviometro());
				// System.out.println("Estacao: "	+ p.getEstacaop().getNomeEstacao());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarPluviometro;
	}

	public void setListarPluviometro(List<Pluviometro> listarPluviometro) {
		this.listarPluviometro = listarPluviometro;
	}
	
	// GERAR RELATORIO
	@SuppressWarnings("deprecation")
	public String consultar() {
		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		String acesso = (String) session.getAttribute("nome");
		//// System.out.println("INTRUJAO NO RELATORIO: "+ acesso);
		// System.out.println(new Date());
		PluviometroHistoricoLeituraCrescenteDao pd = new PluviometroHistoricoLeituraCrescenteDao();
		
		PdfPluviometricoDao pdfDao = new PdfPluviometricoDao();
		PdfPluviometrico pdf = new PdfPluviometrico();
		
		
		
		
		try {
			// System.out.println("OPCAO: " + opcao);
			pdfDao.deleteAll();
			
			
			if (opcao.equalsIgnoreCase("Total")) {
				
				
				

				// Pegando o id da Estação
				int id = estacao.getIdEstacao();

				// Pegando o id do Pluviometro
				estacao = new EstacaoDao().findById(id);
				Integer idPluviometro = estacao.getPluviometroe()
						.getIdPluviometro();


				// Pegando o multiplicador
				Float multiplicador = estacao.getPluviometroe()
						.getMultiplicador();


				// Pegando o nome da Estacao
				nome = estacao.getNomeEstacao();


				// Pegando a data de inicio e a data do fim
			

				List<PluviometroHistoricoLeituraCrescente> lista = pd
						.findDateforDate(dataInicio, dataFim);

				int tamanhoLista = lista.size();
				System.out
						.println("Tamanho da Lista de Todos: " + tamanhoLista);

				List<PluviometroHistoricoLeituraCrescente> listaCerta = new ArrayList<PluviometroHistoricoLeituraCrescente>();
				
				
				
				for (int i = 0; i < tamanhoLista; i++) {

					int IdPluv = lista.get(i).getPluviometroCrescente()
							.getIdPluviometro();

					if (idPluviometro == IdPluv) {

						listaCerta.add(lista.get(i));
					}

				}
				Double primeiraLeitura = listaCerta.get(0)
						.getLeituraPluviometroHistoricoLeituraCrescente();
				Double ultimaLeitura = listaCerta.get(listaCerta.size() - 1)
						.getLeituraPluviometroHistoricoLeituraCrescente();



				totalLeitura = (float) (multiplicador * (ultimaLeitura - primeiraLeitura));
				listaMenu = new ArrayList<PdfPluviometrico>();
				listaMenu.add(new PdfPluviometrico(null,nome, totalLeitura,
						dataInicio, dataFim));
				
			
				
					


			} else if (opcao.equalsIgnoreCase("de 15 em 15 minutos")) {


				// Pegando o id da Estação
				int id = estacao.getIdEstacao();
//				// System.out.println("ID ESTACAO: " + id);
				// Pegando o id do Pluviometro
				estacao = new EstacaoDao().findById(id);
				Integer idPluviometro = estacao.getPluviometroe().getIdPluviometro();


				// Pegando o nome da Estacao
				nome = estacao.getNomeEstacao();
//				// System.out.println("Estacao: " + nome);

				List<PluviometroHistoricoConvertido> lista = new PluviometroHistoricoConvertidoDao().findDateforDate(dataInicio, dataFim, idPluviometro);
				int tamanhoLista = lista.size() - 1;

				for (int i = 0; tamanhoLista > i; i++) {

					float leitura = lista.get(i).getTempo15minutos()
							.floatValue();
					Date data = lista.get(i)
							.getDataHoraPluviometroHistoricoConvertido();

					int minutos = lista.get(i)
							.getDataHoraPluviometroHistoricoConvertido()
							.getMinutes();

					
					int tamanho = listaMenu.size();
					
					if(tamanho==0){
						
						listaMenu.add(new PdfPluviometrico(null, nome, leitura,
								data, null));
						
					}else{
					
					int minutoAnterior = listaMenu.get(tamanho-1).getDataInicial().getMinutes();
					
					// SE MINUTO ANTERIOR FOR 00 01 OU 02 NAO FAZ NADA
					
					if (minutos == 00 || minutos == 01 || minutos == 02 || minutos == 03) {
						
						
						if(minutoAnterior==00 || minutoAnterior==01 || minutoAnterior==02 || minutoAnterior==03){
							
							
						}else{
							
							
							listaMenu.add(new PdfPluviometrico(null,nome, leitura,
									data, null));
							
							
						}
					} else if (minutos == 15 || minutos == 16 || minutos == 17 || minutos == 18) {
						
						if(minutoAnterior==15 || minutoAnterior==16|| minutoAnterior==17 || minutoAnterior==18){
								
						}else{
							listaMenu.add(new PdfPluviometrico(null,nome, leitura,
									data, null));
						}
					}  else if (minutos == 30 || minutos == 31 || minutos ==32 || minutos == 33) {
						
						if(minutoAnterior==30 || minutoAnterior==31|| minutoAnterior==32 || minutoAnterior==33){
						
						}else{
							listaMenu.add(new PdfPluviometrico(null,nome, leitura,
									data, null));		
						}
					
					} else if (minutos == 45 || minutos == 46 || minutos ==47 || minutos == 48) {
						
						
						if(minutoAnterior==45 || minutoAnterior==46|| minutoAnterior==47 || minutoAnterior==48){
						
							}else{	
								listaMenu.add(new PdfPluviometrico(null,nome, leitura,
										data, null));
							}
	
						}

					}
				
				}
				
			}else if (opcao.equalsIgnoreCase("de 1 em 1 hora")) {


				
		
					// Pegando o id da Estação
					int id = estacao.getIdEstacao();

					// Pegando o id do Pluviometro
					estacao = new EstacaoDao().findById(id);
					Integer idPluviometro = estacao.getPluviometroe().getIdPluviometro();



					// Pegando o nome da Estacao
					nome = estacao.getNomeEstacao();


					List<PluviometroHistoricoConvertido> lista = new PluviometroHistoricoConvertidoDao()
							.findDateforDate(dataInicio, dataFim, idPluviometro);

					int tamanhoLista = lista.size() - 1;

					int h = 00;
					Date date = new Date();
					// System.out.println("data agora");
					h = date.getHours();
					for (int i = 0; tamanhoLista > i; i++) {

						float leitura = lista.get(i).getTempo60minutos().floatValue();
						Date data = lista.get(i).getDataHoraPluviometroHistoricoConvertido();

						int hora = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getHours();
						int minutos = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getMinutes();
						
						// System.out.println("Horas= "+hora+" Minutos= "+minutos);
						if (minutos==00) {
							listaMenu.add(new PdfPluviometrico(null,nome, leitura,
									data, data));
							h++;
						}


					}
					

			} else if (opcao.equalsIgnoreCase("de 1 em 1 dia")) {

//				// System.out.println("Entro na Opcao de 1 Dia");

				// Pegando o id da Estação
				int id = estacao.getIdEstacao();
//				// System.out.println("ID ESTACAO: " + id);
				// Pegando o id do Pluviometro
				estacao = new EstacaoDao().findById(id);
				Integer idPluviometro = estacao.getPluviometroe()
						.getIdPluviometro();


				// Pegando o multiplicador
				Float multiplicador = estacao.getPluviometroe()
						.getMultiplicador();


				// Pegando o nome da Estacao
				nome = estacao.getNomeEstacao();


				List<PluviometroHistoricoConvertido> lista = new PluviometroHistoricoConvertidoDao().findDateforDate(dataInicio, dataFim, idPluviometro);
				int tamanhoLista = lista.size() - 1;

				int d = 00;

				for (int i = 0; tamanhoLista > i; i++) {

					float leitura = lista.get(i).getTempo1440minutos().floatValue();
					Date data = lista.get(i).getDataHoraPluviometroHistoricoConvertido();

					int dia = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getDay();
					int mes = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getMonth();
					int hora = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getHours();
					int minuto = lista.get(i).getDataHoraPluviometroHistoricoConvertido().getMinutes();

					d = dia;

					if ((hora == 00 && dia == d && minuto == 00)
							|| (hora == 00 && dia == d && minuto == 01)
							|| (hora == 00 && dia == d && minuto == 02)
							|| (hora == 00 && dia == d && minuto == 03)) {

						int tamanho = listaMenu.size();


						if (tamanho == 0) {

							listaMenu.add(new PdfPluviometrico(null,nome, leitura,
									data, null));

						} else {

							int dia2 = listaMenu.get(tamanho - 1)
									.getDataInicial().getDay();

							if (dia2 != dia) {

								listaMenu.add(new PdfPluviometrico(null,nome, leitura,
										data, data));

							}

						}
					}

					if (mes == 1 || mes == 3 || mes == 5 || mes == 7
							|| mes == 8 || mes == 10 || mes == 12) {
						if (d == 31) {
							d = 0;
						}
					} else if (mes == 2) {
						if (d == 28) {
							d = 0;
						}
					} else {
						if (d == 30) {
							d = 0;
						}
					}

				}
				

			} 
			int tam = listaMenu.size();
			   for(int i=0; tam>i;i++){
				   
				   DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				   String dataIn = df.format(listaMenu.get(i).getDataInicial());
				   String dataFi = df.format(listaMenu.get(i).getDataFinal());
				   
			    pdf.setDataInicial(df.parse(dataIn));
			    pdf.setDataFinal(df.parse(dataFi));
			    pdf.setLeitura(listaMenu.get(i).getLeitura());
			    pdf.setNome(listaMenu.get(i).getNome());
			    pdfDao.save(pdf);
			   }
			
			
		} catch (Exception e) {
			fc.addMessage("formcons",
					new FacesMessage("Erro: " + e.getMessage()));
			e.printStackTrace();
		}
		return null;
	}

}
