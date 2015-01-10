package br.com.geosecure.persistence;

import br.com.geosecure.entity.PdfPluviometrico;

public class PdfPluviometricoDao extends GenericDao<PdfPluviometrico, Integer, String>{

	public PdfPluviometricoDao() {
		super(new PdfPluviometrico());
	}
	public void deleteAll()throws Exception{
		open();
		
		stmt = con.prepareStatement("TRUNCATE pdfpluviometrico");
		stmt.execute();
		
		close();
	
	}

}
