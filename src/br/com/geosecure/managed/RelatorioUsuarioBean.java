package br.com.geosecure.managed;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;
import br.com.geosecure.entity.AcaoHistorico;
import br.com.geosecure.entity.PdfAcionamentoUsuario;
import br.com.geosecure.persistence.AcaoHistoricoDao;
import br.com.geosecure.persistence.PdfAcionamentoUsuarioDao;
import br.com.geosecure.persistence.ToqueStatusEstacaoDao;
import br.com.geosecure.relatorio.RelatorioAcionamentoUsuario;

public class RelatorioUsuarioBean {

	private List<PdfAcionamentoUsuario> listaPdf;
	private List<AcaoHistorico> listaHistorico;
	private AcaoHistorico acao;
	private Date dataInicio;
	private Date dataFim;
	
	
	public RelatorioUsuarioBean() {
		dataInicio = new Date();
		dataFim= new Date();
		acao = new AcaoHistorico();
	}

	public List<PdfAcionamentoUsuario> getListaPdf() {
		return listaPdf;
	}

	public void setListaPdf(List<PdfAcionamentoUsuario> listaPdf) {
		this.listaPdf = listaPdf;
	}

	public List<AcaoHistorico> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(List<AcaoHistorico> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}

	public AcaoHistorico getAcao() {
		return acao;
	}

	public void setAcao(AcaoHistorico acao) {
		this.acao = acao;
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

	
	public String consultar(){

		try {
//			System.out.println("DATA INICIAL: "+ dataInicio);
//			System.out.println("DATA FINAL : "+ dataFim);
			
			listaHistorico = new AcaoHistoricoDao().findDateBetweenDate(dataInicio, dataFim);
			PdfAcionamentoUsuarioDao pdfUsuarioDao= new PdfAcionamentoUsuarioDao();
			pdfUsuarioDao.deleteAll();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			for(AcaoHistorico ah : listaHistorico){
				
				String nomeUsuario = ah.getUsuario().getNomeUsuario();
				String nomeEstacao = ah.getEstacaoah().getNomeEstacao();
				String toque = new ToqueStatusEstacaoDao().findToque(ah.getToqueStatusEstacao());
//				System.out.println("Toque: "+toque);
				String data = sdf.format(ah.getDataHoraAcaoHistorico());
				
				pdfUsuarioDao.save(new PdfAcionamentoUsuario(null, nomeUsuario, nomeEstacao, toque, data));
				
			}
			listaPdf = pdfUsuarioDao.findAll();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String relatorio(){
		try{
			
			List<PdfAcionamentoUsuario> lista = new PdfAcionamentoUsuarioDao().findAll();
			RelatorioAcionamentoUsuario ds = new RelatorioAcionamentoUsuario(lista);
			InputStream arquivo = FacesContext.getCurrentInstance()
						.getExternalContext().getResourceAsStream("/relatorioAcionamentoUsuario.jasper");
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
