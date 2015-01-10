package br.com.geosecure.managed;

import java.io.InputStream;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;
import br.com.geosecure.entity.PdfPluviometrico;
import br.com.geosecure.persistence.PdfPluviometricoDao;
import br.com.geosecure.relatorio.RelatorioPluviometro;

public class RelatorioPluviometroBean {

	private PdfPluviometrico modeloEntidade;
	private List<PdfPluviometrico> listaModelo;
	
	
	public PdfPluviometrico getModeloEntidade() {
		return modeloEntidade;
	}
	public void setModeloEntidade(PdfPluviometrico modeloEntidade) {
		this.modeloEntidade = modeloEntidade;
	}
	public List<PdfPluviometrico> getListaModelo() {
		try {
			listaModelo = new PdfPluviometricoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaModelo;
	}
	public void setListaModelo(List<PdfPluviometrico> listaModelo) {
		this.listaModelo = listaModelo;
	}
	public String relatorio(){
		try{
			
			List<PdfPluviometrico> lista = new PdfPluviometricoDao().findAll();
			RelatorioPluviometro ds = new RelatorioPluviometro(lista);
			InputStream arquivo = FacesContext.getCurrentInstance()
						.getExternalContext().getResourceAsStream("/relatorioPluviometro.jasper");
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
	
	

