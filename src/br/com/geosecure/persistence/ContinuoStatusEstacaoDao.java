package br.com.geosecure.persistence;

import java.util.Date;


import br.com.geosecure.entity.ContinuoStatusEstacao;
import br.com.geosecure.entity.StatusEstacao;

public class ContinuoStatusEstacaoDao extends GenericDao<ContinuoStatusEstacao, Integer, String>{
	
	public ContinuoStatusEstacaoDao() {
		super(new ContinuoStatusEstacao());
	}
	
	
	public Integer findByIdEstacao(Integer idEstacao)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query= session.createQuery("select idContinuoStatusEstacao from ContinuoStatusEstacao where idestacao=:param");
		query.setInteger("param",idEstacao);
		Integer c = (Integer) query.uniqueResult();
		session.close();
		return c ;
		
	}
	public StatusEstacao lastDateOffStatusEstacao(Integer idEstacao)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query=  session.createQuery("select se from StatusEstacao se where se.modostatusestacao.idModoStatusEstacao=2  and se.estacaose.idEstacao=:param");
		query.setInteger("param", idEstacao);
		StatusEstacao se = (StatusEstacao) query.uniqueResult();
		session.close();
		return se;
	}
	public StatusEstacao lastDateManuStatusEstacao(Integer idEstacao)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query=  session.createQuery("select se from StatusEstacao se where se.modostatusestacao.idModoStatusEstacao=3  and se.estacaose.idEstacao=:param");
		query.setInteger("param", idEstacao);
		StatusEstacao se = (StatusEstacao) query.uniqueResult();
		session.close();
		return se;
	}
	public Date lastDateContinuoIndividual()throws Exception{
		open();
		stmt = con.prepareStatement("select dataInicio from ContinuoStatusEstacao where cont=1 order by dataInicio asc limit 1");
		rs = stmt.executeQuery();
		Date data = null;
		if(rs.next()){
			data = rs.getTimestamp("dataInicio");
		}
		stmt.close();
		close();
		// System.out.println("Ultima data Continuo Individual:  "+data);
		return data;
		
	}
	
	

}
