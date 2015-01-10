package br.com.geosecure.persistence;

import java.util.Date;

import br.com.geosecure.entity.ContinuoGlobalStatusEstacao;

public class ContinuoGlobalStatusEstacaoDao extends GenericDao<ContinuoGlobalStatusEstacao, Integer, String> {

	public ContinuoGlobalStatusEstacaoDao() {
		super(new ContinuoGlobalStatusEstacao());
	}	
	public Date lastDateContinuoGlobal ()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select dataHoraIncial from ContinuoGlobalStatusEstacao");
		Date data = (Date) query.uniqueResult();
		session.close();
		return data;
		
	}
	public Double totalContinuoGlobal()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select totalGlobal from ContinuoGlobalStatusEstacao");
		Double total = (Double) query.uniqueResult();
		session.close();
		return total;
	}
	public ContinuoGlobalStatusEstacao continuoGlobal()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select con from ContinuoGlobalStatusEstacao con");
		ContinuoGlobalStatusEstacao con = (ContinuoGlobalStatusEstacao) query.uniqueResult();
		session.close();
		return con;
	}

}
