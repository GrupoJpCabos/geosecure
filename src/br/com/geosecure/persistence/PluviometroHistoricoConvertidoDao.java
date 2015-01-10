package br.com.geosecure.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.PluviometroHistoricoConvertido;
import br.com.geosecure.entity.PluviometroHistoricoLeitura;

public class PluviometroHistoricoConvertidoDao extends GenericDao<PluviometroHistoricoConvertido, Integer, String>{
	
	public PluviometroHistoricoConvertidoDao(){
		super(new PluviometroHistoricoConvertido());
	}
	
	
	public PluviometroHistoricoLeitura findUltimoRegistroPluvByFk(Integer id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT idPluviometroHistoricoLeitura from PluviometroHistoricoLeitura WHERE idPluviometro= :param1" +
				"ORDER BY idPluviometroHistoricoLeitura desc limit 1");
		query.setInteger("param1", id);
		PluviometroHistoricoLeitura phl = (PluviometroHistoricoLeitura) query.uniqueResult();
		session.close();
		return phl;
	}
	public void save2(PluviometroHistoricoConvertido p)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
	}
	public PluviometroHistoricoConvertido findByDate(Date date)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PluviometroHistoricoConvertido.class);
		criteria.add(Restrictions.ilike("dataHoraPluviometroHistoricoConvertido", date));
		PluviometroHistoricoConvertido pluv = (PluviometroHistoricoConvertido) criteria.uniqueResult();
		session.close();
		
		return pluv;
	}
	public List<PluviometroHistoricoConvertido> findDateforDate(Date dataInicio, Date dataFim)throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PluviometroHistoricoConvertido.class);
		criteria.add(Restrictions.between("dataHoraPluviometroHistoricoConvertido", dataInicio, dataFim));
		List<PluviometroHistoricoConvertido> lista = criteria.list();
		session.close();
		return lista;
		
		
	}
	public List<PluviometroHistoricoConvertido> findDateforDate(Date dataInicio, Date dataFim, Integer idPluviometro)throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query= session.createQuery("Select p From PluviometroHistoricoConvertido p where p.dataHoraPluviometroHistoricoConvertido Between :param6 and :param7 and p.idPluviometro=:param8 order by p.dataHoraPluviometroHistoricoConvertido asc");
		query.setDate("param6", dataInicio);
		query.setDate("param7", dataFim);
		query.setInteger("param8", idPluviometro);
		List<PluviometroHistoricoConvertido> lista = query.list();
		session.close();
		return lista;
		
	}
}
