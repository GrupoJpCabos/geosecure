package br.com.geosecure.persistence;


import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.PdfDisponibilidadeRelatorio;

public class PdfDisponibilidadeRelatorioDao extends GenericDao<PdfDisponibilidadeRelatorio, Integer, String>	{
	public PdfDisponibilidadeRelatorioDao() {
		super(new PdfDisponibilidadeRelatorio());
	}
	public PdfDisponibilidadeRelatorio takeIdByNomeEstacao(String nome)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PdfDisponibilidadeRelatorio.class);
		criteria.add(Restrictions.ilike("nome",nome));
		PdfDisponibilidadeRelatorio lista = (PdfDisponibilidadeRelatorio) criteria.uniqueResult();
		session.close();
		return lista;
	}
	
	public void deleteAll()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("delete from PdfDisponibilidadeRelatorio");
		query.executeUpdate();
		session.close();
	}
	
}
