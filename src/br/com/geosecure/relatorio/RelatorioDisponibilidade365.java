package br.com.geosecure.relatorio;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import br.com.geosecure.entity.PdfDisponibilidade365;

public class RelatorioDisponibilidade365 implements JRDataSource {

	private Iterator<PdfDisponibilidade365> interatorPdf365;
	private PdfDisponibilidade365 pdf365;

	public RelatorioDisponibilidade365(List<PdfDisponibilidade365> lista){

		interatorPdf365 = lista.iterator();

	}
	
	public Object getFieldValue(JRField field) throws JRException {
		
		if(field.getName().equalsIgnoreCase("idPdfDisponibilidade"))
			return pdf365.getDisponibilidadeRelatorio2().getIdPdfDisponibilidade();
		
		if(field.getName().equalsIgnoreCase("nome"))
			return pdf365.getDisponibilidadeRelatorio2().getNome();
		
		if(field.getName().equalsIgnoreCase("tempoAnualDisponivel"))
			return pdf365.getDisponibilidadeRelatorio2().getTempoAnualDisponivel();
		
		if(field.getName().equalsIgnoreCase("tempoMensalDisponivel"))
			return pdf365.getDisponibilidadeRelatorio2().getTempoMensalDisponivel();
		
		if(field.getName().equalsIgnoreCase("porcentual"))
			return pdf365.getDisponibilidadeRelatorio2().getPorcentual();
		
		if(field.getName().equalsIgnoreCase("dataInicio365"))
			return pdf365.getDataInicio365();
		
	
		if(field.getName().equalsIgnoreCase("dataFim365"))
			return pdf365.getDataFim365();


		if(field.getName().equalsIgnoreCase("modo365"))
			return pdf365.getModo365();
	
		if(field.getName().equalsIgnoreCase("total365"))
			return pdf365.getTotal365();
	  
	
		
	
		return null;
		
	}
	
	
		public boolean next()throws JRException{
			if(interatorPdf365.hasNext()){
				pdf365 = interatorPdf365.next();	
				return true;
			}
		
			return false;
		}
}


