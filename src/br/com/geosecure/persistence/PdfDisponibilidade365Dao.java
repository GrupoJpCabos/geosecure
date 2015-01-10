package br.com.geosecure.persistence;

import br.com.geosecure.entity.PdfDisponibilidade365;

public class PdfDisponibilidade365Dao extends GenericDao<PdfDisponibilidade365, Integer, String>	{
	public PdfDisponibilidade365Dao() {
		super(new PdfDisponibilidade365());
	}
	public void deleteAll()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("delete from PdfDisponibilidade365");
		query.executeUpdate();
		session.close();
	}
}
