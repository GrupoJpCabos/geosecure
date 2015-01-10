package br.com.geosecure.persistence;

import br.com.geosecure.entity.PdfDisponibilidade30;

public class PdfDisponibilidade30Dao extends GenericDao<PdfDisponibilidade30, Integer, String>	{
	public PdfDisponibilidade30Dao() {
		super(new PdfDisponibilidade30());
	}
	public void deleteAll()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("delete from PdfDisponibilidade30");
		query.executeUpdate();
		session.close();
	}

}
