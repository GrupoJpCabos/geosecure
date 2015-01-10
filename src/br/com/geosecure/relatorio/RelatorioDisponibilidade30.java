package br.com.geosecure.relatorio;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import br.com.geosecure.entity.PdfDisponibilidade30;


public class RelatorioDisponibilidade30 implements JRDataSource {

	private Iterator<PdfDisponibilidade30> interatorPdf30;
	private PdfDisponibilidade30 pdf30;

	public RelatorioDisponibilidade30(List<PdfDisponibilidade30> lista){

		interatorPdf30 = lista.iterator();

	}
	
	public Object getFieldValue(JRField field) throws JRException {
		
		if(field.getName().equalsIgnoreCase("idPdfDisponibilidade"))
			return pdf30.getDisponibilidadeRelatorio().getIdPdfDisponibilidade();
		
		if(field.getName().equalsIgnoreCase("nome"))
			return pdf30.getDisponibilidadeRelatorio().getNome();
		
		if(field.getName().equalsIgnoreCase("tempoAnualDisponivel"))
			return pdf30.getDisponibilidadeRelatorio().getTempoAnualDisponivel();
		
		if(field.getName().equalsIgnoreCase("tempoMensalDisponivel"))
			return pdf30.getDisponibilidadeRelatorio().getTempoMensalDisponivel();
		
		if(field.getName().equalsIgnoreCase("porcentual"))
			return pdf30.getDisponibilidadeRelatorio().getPorcentual();
		
		if(field.getName().equalsIgnoreCase("dataInicio30"))
			return pdf30.getDataInicio30();
		
	
		if(field.getName().equalsIgnoreCase("dataFim30"))
			return pdf30.getDataFim30();


		if(field.getName().equalsIgnoreCase("modo30"))
			return pdf30.getModo30();
	
		if(field.getName().equalsIgnoreCase("total30"))
			return pdf30.getTotal30();
	  
	
		
	
		return null;
		
	}
	
	
		public boolean next()throws JRException{
			if(interatorPdf30.hasNext()){
				pdf30 = interatorPdf30.next();	
				return true;
			}
		
			return false;
		}
}



//		if(dados3.hasNext()){
//			linha3 = dados3.next();
//			
//			
//			if(interatorPdf30.hasNext()){
//				pdf30 = interatorPdf30.next();
//				}
//			
//			
//			if(dados.hasNext())
//				linha = dados.next();
//				
//			return true;
//		}
//			
//			return false;
//			
//		}
	
	

