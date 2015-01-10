package br.com.geosecure.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;

import br.com.geosecure.entity.AcaoHistorico;


public class AcaoHistoricoDao extends GenericDao<AcaoHistorico, Integer, String> {
	
	public AcaoHistoricoDao() {
		super(new AcaoHistorico());
	}
	public List<AcaoHistorico> findAllASCDATE()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(AcaoHistorico.class);
		criteria.addOrder(Order.desc("dataHoraAcaoHistorico"));
		List<AcaoHistorico> lista = criteria.list();
		session.close();
		return lista;
	}
	public List<AcaoHistorico> findDateBetweenDate(Date dataInicio, Date dataFim)throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query= session.createQuery("Select a From AcaoHistorico a where a.dataHoraAcaoHistorico Between :param6 and :param7 order by a.dataHoraAcaoHistorico asc");
		query.setDate("param6", dataInicio);
		query.setDate("param7", dataFim);
		List<AcaoHistorico> lista = query.list();
		session.close();
		return lista;
		
	}

}
