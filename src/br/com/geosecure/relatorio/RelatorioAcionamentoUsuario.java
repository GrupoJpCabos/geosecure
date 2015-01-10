package br.com.geosecure.relatorio;


import java.util.Iterator;
import java.util.List;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import br.com.geosecure.entity.PdfAcionamentoUsuario;



public class RelatorioAcionamentoUsuario implements JRDataSource{
	
	private Iterator<PdfAcionamentoUsuario> dados;
	private PdfAcionamentoUsuario linha;
	
	public RelatorioAcionamentoUsuario(List<PdfAcionamentoUsuario> lista){
		dados = lista.iterator();
	}
	public Object getFieldValue(JRField field) throws JRException {
		if(field.getName().equalsIgnoreCase("idPdfAcionamentoUsuario"))
			return linha.getIdPdfAcionamentoUsuario();
		
		if(field.getName().equalsIgnoreCase("nome"))
			return linha.getNome();
		
		if(field.getName().equalsIgnoreCase("estacao"))
			return linha.getEstacao();
		
		if(field.getName().equalsIgnoreCase("toque"))
			return linha.getToque();
		
		if(field.getName().equalsIgnoreCase("data"))
			return linha.getData();
		
		
		return null;
	}
	public boolean next()throws JRException{
		if(dados.hasNext()){
			linha = dados.next();
			return true;
		}
		return false;
	}
	
}
