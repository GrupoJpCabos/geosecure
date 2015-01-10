package br.com.geosecure.managed;

import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;

import net.sf.jasperreports.engine.JasperRunManager;
import br.com.geosecure.entity.ContinuoStatusEstacaoHistorico;
import br.com.geosecure.entity.DisponibilidadeStatusEstacao;
import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.PdfDisponibilidade30;
import br.com.geosecure.entity.PdfDisponibilidade365;
import br.com.geosecure.entity.PdfDisponibilidadeRelatorio;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.persistence.ContinuoStatusEstacaoHistoricoDao;
import br.com.geosecure.persistence.DisponibilidadeStatusEstacaoDao;
import br.com.geosecure.persistence.EstacaoDao;
import br.com.geosecure.persistence.PdfDisponibilidade30Dao;
import br.com.geosecure.persistence.PdfDisponibilidade365Dao;
import br.com.geosecure.persistence.PdfDisponibilidadeRelatorioDao;
import br.com.geosecure.persistence.StatusEstacaoDao;
import br.com.geosecure.persistence.StatusEstacaoHistoricoDao;
import br.com.geosecure.relatorio.RelatorioDisponibilidade30;
import br.com.geosecure.relatorio.RelatorioDisponibilidade365;

public class RelatorioDisponibilidadeBean {
	
	
	private PdfDisponibilidadeRelatorio pdfRelatorio;
	private PdfDisponibilidade30 pdf30;
	private PdfDisponibilidade365 pdf365;
	
	
	
	private List<PdfDisponibilidadeRelatorio> listaRelatorio;
	private List<PdfDisponibilidade30> lista30;
	private List<PdfDisponibilidade365> lista365;
	
	private Double porcertagem;
	private StatusEstacao statusEstacao;
	private DisponibilidadeStatusEstacao disponibilidade;
	private Estacao estacao;
	private Double totalDisponiveis365;
	private Double totalDisponiveis30;
	private Double somaIndisponiveis;
	private Integer totalIndisponiveis;
	

	private List<SelectItem> selectEstacao;
	private ContinuoStatusEstacaoHistorico continuoHistorico;
	private List<String> lista;
	

	
	public RelatorioDisponibilidadeBean() {
		statusEstacao = new StatusEstacao();
		disponibilidade = new DisponibilidadeStatusEstacao();
		estacao = new Estacao();
		totalDisponiveis365=null;
		totalDisponiveis30=null;
		somaIndisponiveis=null;
		continuoHistorico = null;
		pdf30 = new PdfDisponibilidade30();
		pdf365 = new PdfDisponibilidade365();
		pdfRelatorio = new PdfDisponibilidadeRelatorio();
		listaRelatorio = new ArrayList<PdfDisponibilidadeRelatorio>();
		lista365 = new ArrayList<PdfDisponibilidade365>();
		lista30 = new ArrayList<PdfDisponibilidade30>();
		


	}
	
	
	
	public List<PdfDisponibilidadeRelatorio> getListaRelatorio() {
		try {
			listaRelatorio = new PdfDisponibilidadeRelatorioDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaRelatorio;
	}



	public void setListaRelatorio(List<PdfDisponibilidadeRelatorio> listaRelatorio) {
		this.listaRelatorio = listaRelatorio;
	}



	public List<PdfDisponibilidade30> getLista30() {
		try {
			lista30 = new PdfDisponibilidade30Dao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista30;
	}



	public void setLista30(List<PdfDisponibilidade30> lista30) {
		this.lista30 = lista30;
	}



	public List<PdfDisponibilidade365> getLista365() {
		try {
			lista365 = new PdfDisponibilidade365Dao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista365;
	}



	public void setLista365(List<PdfDisponibilidade365> lista365) {
		this.lista365 = lista365;
	}





	public Double getPorcertagem() {
		return porcertagem;
	}



	public void setPorcertagem(Double porcertagem) {
		this.porcertagem = porcertagem;
	}



	public Double getTotalDisponiveis365() {
		return totalDisponiveis365;
	}



	public void setTotalDisponiveis365(Double totalDisponiveis365) {
		this.totalDisponiveis365 = totalDisponiveis365;
	}



	public Double getTotalDisponiveis30() {
		return totalDisponiveis30;
	}



	public void setTotalDisponiveis30(Double totalDisponiveis30) {
		this.totalDisponiveis30 = totalDisponiveis30;
	}



	public PdfDisponibilidadeRelatorio getPdfRelatorio() {
		return pdfRelatorio;
	}



	public void setPdfRelatorio(PdfDisponibilidadeRelatorio pdfRelatorio) {
		this.pdfRelatorio = pdfRelatorio;
	}



	public PdfDisponibilidade30 getPdf30() {
		return pdf30;
	}



	public void setPdf30(PdfDisponibilidade30 pdf30) {
		this.pdf30 = pdf30;
	}



	public PdfDisponibilidade365 getPdf365() {
		return pdf365;
	}



	public void setPdf365(PdfDisponibilidade365 pdf365) {
		this.pdf365 = pdf365;
	}



	public Double getSomaDisponiveis365() {
		return totalDisponiveis365;
	}

	public void setSomaDisponiveis365(Double somaDisponiveis365) {
		this.totalDisponiveis365 = somaDisponiveis365;
	}

	public Double getSomaDisponiveis30() {
		return totalDisponiveis30;
	}

	public void setSomaDisponiveis30(Double somaDisponiveis30) {
		this.totalDisponiveis30 = somaDisponiveis30;
	}

	

	public ContinuoStatusEstacaoHistorico getContinuoHistorico() {
		return continuoHistorico;
	}

	public void setContinuoHistorico(
			ContinuoStatusEstacaoHistorico continuoHistorico) {
		this.continuoHistorico = continuoHistorico;
	}

	public Integer getTotalIndisponiveis() {
		return totalIndisponiveis;
	}

	public void setTotalIndisponiveis(Integer totalIndisponiveis) {
		this.totalIndisponiveis = totalIndisponiveis;
	}
	public Double getSomaIndisponiveis() {
		return somaIndisponiveis;
	}

	public void setSomaIndisponiveis(Double somaIndisponiveis) {
		this.somaIndisponiveis = somaIndisponiveis;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}

	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}

	public DisponibilidadeStatusEstacao getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadeStatusEstacao disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	

	public List<SelectItem> getSelectEstacao() {
		
		try {
			selectEstacao = new ArrayList<SelectItem>();
			for(Estacao ge : new EstacaoDao().findAll()){
				selectEstacao.add(new SelectItem(ge.getIdEstacao(),ge.getNomeEstacao()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectEstacao;
	}

	public void setSelectEstacao(List<SelectItem> selectEstacao) {
		this.selectEstacao = selectEstacao;
	}

	public String disponibilidade(){
		FacesContext fc = FacesContext.getCurrentInstance();
//		fc.addMessage("formRelatorio", new FacesMessage("Aguarde enquanto carregamos o processo!"));
		try {
			
			PdfDisponibilidadeRelatorioDao pdfRelatorioDao = new PdfDisponibilidadeRelatorioDao();
			PdfDisponibilidade30Dao pdf30Dao = new PdfDisponibilidade30Dao();
			PdfDisponibilidade365Dao pdf365Dao =  new PdfDisponibilidade365Dao();
			DisponibilidadeStatusEstacaoDao dispDao = new DisponibilidadeStatusEstacaoDao();
			int tam = lista.size();
	//		System.out.println("Tamanho da lista "+tam);

			totalDisponiveis365 = 0.0;
			totalIndisponiveis = 0;
//			listaRelatorio = new ArrayList<ListaRelatorioDisponibilidade>();
			porcertagem = 0.0;
			pdf30Dao.deleteAll();
			pdf365Dao.deleteAll();
			pdfRelatorioDao.deleteAll();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for(int i=0; i<tam;i++){
				
				
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
								
				Date data = new Date();
				String dataHora = sdf.format(data);
				Date date = sdf.parse(dataHora);
			
				estacao = new EstacaoDao().findById(idEstacao);
				Integer idStatusEstacao =  new StatusEstacaoDao().findByIdEstacao(idEstacao);
				statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
				
				
				//PEGANDO O ID DISPONIBILIDADE, PELA DO STATUS
				Integer idDisp = statusEstacao.getDisponibilidadeStatusEstacao().getIdDisponibilidadeStatusEstacao();
				disponibilidade = dispDao.findById(idDisp);
				Double dispAnual = dispDao.indisponibilidadeAnualEstacao(idEstacao, 1);
			
				//Setando os valores para o disp
				disponibilidade.setIndisponibilidadeAnual(disponibilidade.getIndisponibilidadeAnual());
				disponibilidade.setDisponibilidadeAnual(dispAnual);
				disponibilidade.setIdDisponibilidadeStatusEstacao(idDisp);
				disponibilidade.setIndisponibilidadeAnual(disponibilidade.getIndisponibilidadeAnual());
				dispDao.update(disponibilidade);
			

				// Equipamento fora da consulta
				
				totalIndisponiveis = new StatusEstacaoDao().howManyInativas();
				
				// Porcentagem de Estacao off
				List<Estacao> listaTotal = new EstacaoDao().findAll();
				Integer totalEstacao = listaTotal.size();
				double valor1 =  ((double)totalIndisponiveis) / ((double)totalEstacao);
				porcertagem = valor1 * 100;
				
				
				
	//			System.out.println("PORCENTAGEM DE INDISPONIVEIS NA CONSULTA: " +porcertagem+"%");
	//			System.out.println("SOMA DELAS DISPONIVEL: " + totalDisponiveis365);
		//		System.out.println("ESTACAO: "+estacao.getNomeEstacao());
				
				totalDisponiveis30 = new StatusEstacaoHistoricoDao().TempoDisponivelEm30Dias(idEstacao);
				totalDisponiveis365 = new StatusEstacaoHistoricoDao().TempoDisponivelEm365Dias(idEstacao);
				

				
		//		System.out.println(estacao.getNomeEstacao());
				
				pdfRelatorio.setNome(estacao.getNomeEstacao());
				pdfRelatorio.setPorcentual(porcertagem);
				pdfRelatorio.setTempoAnualDisponivel(totalDisponiveis365);
				pdfRelatorio.setTempoMensalDisponivel(totalDisponiveis30);
				pdfRelatorioDao.save(pdfRelatorio);
				
				
				/**
				 * Falhas das Estações 
				 * **/
				
								// 365 Dias //
				
				
				List<ContinuoStatusEstacaoHistorico> listafalhas365 = new ContinuoStatusEstacaoHistoricoDao().failIn1Ano(idEstacao);
				int tamanho = listafalhas365.size();
	//			System.out.println("TAMANHO DO FALHA: " +tamanho);
				
				for(int a=0; tamanho>a; a++){
					
					String modo365 ="on";
					if(listafalhas365.get(a).getModoStatusEstacao() == 2){
						modo365 = "off";
					}else{
						modo365= "manutenção";
					}
					
					
					
					pdf365.setDataInicio365(listafalhas365.get(a).getDataInicioHistorico());
					pdf365.setDataFim365(listafalhas365.get(a).getDataFinalHistorico());
					pdf365.setModo365(modo365);
					pdf365.setTotal365(listafalhas365.get(a).getTotalEstacaoHistorico());
					pdf365.setDisponibilidadeRelatorio2(pdfRelatorio);
					pdf365Dao.save(pdf365);

				}
				
				
				                                          // 30 Dias //
				
				
				List<ContinuoStatusEstacaoHistorico> listafalhas30 = new ContinuoStatusEstacaoHistoricoDao().failIn1Mes(idEstacao);
				int tamanho2 = listafalhas30.size();
	//			System.out.println("TAMANHO DO FALHA: " +tamanho2);
				for(int a=0; tamanho2>a; a++){
					
				
					String modo ="on";
					if(listafalhas30.get(a).getModoStatusEstacao() == 2){
						modo = "off";
					}else{
						modo= "manutenção";
					}
					
				
					
					pdf30.setDataInicio30(listafalhas30.get(a).getDataInicioHistorico());
					pdf30.setDataFim30(listafalhas30.get(a).getDataFinalHistorico());
					pdf30.setModo30(modo);
					pdf30.setTotal30(listafalhas30.get(a).getTotalEstacaoHistorico());
					pdf30.setDisponibilidadeRelatorio(pdfRelatorio);
					pdf30Dao.save(pdf30);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String relatorio30(){
		try{
			
			
			List<PdfDisponibilidade30> lista2 = new PdfDisponibilidade30Dao().findAll();
			RelatorioDisponibilidade30 ds = new RelatorioDisponibilidade30(lista2);
			
			InputStream arquivo = FacesContext.getCurrentInstance()
						.getExternalContext().getResourceAsStream("/relatorioDisponibilidade30.jasper");
			byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
			HttpServletResponse response = (HttpServletResponse)
					FacesContext.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream out = response.getOutputStream();
			
			out.write(pdf);
			out.flush();
			
			FacesContext.getCurrentInstance().responseComplete();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public String relatorio365(){
		try{
			
			
			List<PdfDisponibilidade365> lista2 = new PdfDisponibilidade365Dao().findAll();
			RelatorioDisponibilidade365 ds = new RelatorioDisponibilidade365(lista2);
			
			InputStream arquivo = FacesContext.getCurrentInstance()
						.getExternalContext().getResourceAsStream("/relatorioDisponibilidade365.jasper");
			byte[] pdf = JasperRunManager.runReportToPdf(arquivo, null, ds);
			HttpServletResponse response = (HttpServletResponse)
					FacesContext.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream out = response.getOutputStream();
			
			out.write(pdf);
			out.flush();
			
			FacesContext.getCurrentInstance().responseComplete();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
