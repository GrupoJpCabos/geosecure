package br.com.geosecure.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.PluviometroHistoricoLeitura;
import br.com.geosecure.entity.PluviometroHistoricoLeituraCrescente;

public class PluviometroHistoricoLeituraDao extends GenericDao<PluviometroHistoricoLeitura, Integer, String> {

	public PluviometroHistoricoLeituraDao(){
		super(new PluviometroHistoricoLeitura());
	}
	
	
	public Double findLastLeitura(Integer id) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT leituraPluviometroHistoricoLeitura FROM PluviometroHistoricoLeitura WHERE idPluviometro=:param1 ORDER BY dataHoraPluviometroHistoricoLeitura DESC limit 1;");
		query.setFloat("param1", id);
		Double leitura = (Double) query.uniqueResult();
		session.close();
		// System.out.println("FOI !");
		return leitura;
		
	}
	public List<PluviometroHistoricoLeitura> findUltimoRegistroPluvByFk(Integer id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT idPluviometroHistoricoLeitura FROM PluviometroHistoricoLeitura WHERE idPluviometro= :param1" +
				" ORDER BY idPluviometroHistoricoLeitura DESC LIMITE 1;");
		query.setInteger("param1", id);
		List<PluviometroHistoricoLeitura> phl =  query.list();
		if(phl == null){
			// System.out.println("Deu ruim ! NULL");
		}
		session.close();
		return phl;
	}
	

	public PluviometroHistoricoLeitura findLastLeituras3()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PluviometroHistoricoLeitura.class);  
        criteria.addOrder(Order.desc(("idPluviometroHistoricoLeitura")));  
        return (PluviometroHistoricoLeitura)criteria.list().get(0);  
	}
	
	public List<Integer> findLeiturasCrescente(Integer idPluviometro, Integer minutos)
			throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT leituraPluviometroHistoricoLeituraCrescente FROM PluviometroHistoricoLeituraCrescente WHERE idPluviometro=:parame1 AND dataHoraPluviometroHistoricoLeituraCrescente BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -:parame2MINUTE)) AND NOW() ORDER BY dataHoraPluviometroHistoricoLeituraCrescente");
		query.setInteger("parame1", idPluviometro);
		query.setInteger("parame2", minutos);
		List<Integer> lista = query.list();
		session.close();
		return lista;
		

	}
	
	public List<Integer> findLeiturasCrescente2(Date inicio, Date fim)
			throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PluviometroHistoricoLeituraCrescente.class);
		criteria.add(Restrictions.between("dataHoraPluviometroHistoricoLeituraCrescente", inicio, fim));		
		List<Integer> lista = criteria.list();
		// System.out.println("Lista DAta" + lista);
		session.close();
		return lista;
		

	}
	
	public List<Integer> findLeiturasCrescente1(Integer idPluviometro, Integer minutos)throws Exception{
		open();
		stmt = con.prepareStatement("SELECT leituraPluviometroHistoricoLeituraCrescente FROM PluviometroHistoricoLeituraCrescente WHERE idPluviometro=? AND dataHoraPluviometroHistoricoLeituraCrescente BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -? MINUTE)) AND NOW() ORDER BY dataHoraPluviometroHistoricoLeituraCrescente");
		stmt.setInt(1, idPluviometro);
		stmt.setInt(2, minutos);
		rs = stmt.executeQuery();
		List<Integer> listaLeituras = new ArrayList<Integer>();
		while (rs.next()) {
			Integer leitura = rs.getInt("leituraPluviometroHistoricoLeituraCrescente");
			listaLeituras.add(leitura);
			
		}
		close();
		return listaLeituras;
		
	}
	
	
	public Double findLastLeituraById(Integer idPluviometro)throws Exception{
		
		open();
		
		stmt = con.prepareStatement("select leituraPluviometroHistoricoLeitura from PluviometroHistoricoLeitura where idPluviometro=? order by dataHoraPluviometroHistoricoLeitura desc limit 1");
		stmt.setInt(1, idPluviometro);
		rs = stmt.executeQuery();
		Double lastLeitura=null;
		
		if(rs.next()){
			
			
		lastLeitura = rs.getDouble("leituraPluviometroHistoricoLeitura");
			
			
		}
		
		close();
		return lastLeitura;
		
	}
}
	
	
	

