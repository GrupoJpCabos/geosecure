package br.com.geosecure.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.PluviometroHistoricoLeituraCrescente;

public class PluviometroHistoricoLeituraCrescenteDao extends GenericDao<PluviometroHistoricoLeituraCrescente, Integer, String> {
	
	public PluviometroHistoricoLeituraCrescenteDao(){
		super(new PluviometroHistoricoLeituraCrescente());
	} 
	public List<PluviometroHistoricoLeituraCrescente> findDateforDate(Date dataInicio, Date dataFim)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(PluviometroHistoricoLeituraCrescente.class);
		criteria.add(Restrictions.between("dataHoraPluviometroHistoricoLeituraCrescente", dataInicio, dataFim));
		List<PluviometroHistoricoLeituraCrescente> lista = criteria.list();
		session.close();
		return lista;
		
	}
	
	public Double findLastLeituraById(Integer idPluviometro)throws Exception{
		
		open();
		
		stmt = con.prepareStatement("select leituraPluviometroHistoricoLeituraCrescente from PluviometroHistoricoLeituraCrescente where idPluviometro=? order by dataHoraPluviometroHistoricoLeituraCrescente desc limit 1");
		stmt.setInt(1, idPluviometro);
		rs = stmt.executeQuery();
		Double lastLeitura=null;
		
		if(rs.next()){
			
			
		lastLeitura = rs.getDouble("leituraPluviometroHistoricoLeituraCrescente");
			
			
		}
		
		close();
		return lastLeitura;
		
	}
}
	

