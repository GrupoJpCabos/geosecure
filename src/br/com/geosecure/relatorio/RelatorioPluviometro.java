package br.com.geosecure.relatorio;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import br.com.geosecure.entity.PdfPluviometrico;

public class RelatorioPluviometro implements JRDataSource{
	
	private Iterator<PdfPluviometrico> dados;
	private PdfPluviometrico linha;
	
	public RelatorioPluviometro(List<PdfPluviometrico> lista){
		dados = lista.iterator();
	}
	public Object getFieldValue(JRField field) throws JRException {
		if(field.getName().equalsIgnoreCase("idListLeituraModelo"))
			return linha.getIdListLeituraModelo();
		
		if(field.getName().equalsIgnoreCase("nome"))
			return linha.getNome();
		
		if(field.getName().equalsIgnoreCase("leitura"))
			return linha.getLeitura();
		
		if(field.getName().equalsIgnoreCase("dataInicial"))
			return linha.getDataInicial();
		
		if(field.getName().equalsIgnoreCase("dataFinal"))
			return linha.getDataFinal();
		
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
