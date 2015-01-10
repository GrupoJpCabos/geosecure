package br.com.geosecure.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.StatusEstacaoHistorico;

public class StatusEstacaoHistoricoDao extends GenericDao<StatusEstacaoHistorico, Integer, String>{

	public StatusEstacaoHistoricoDao() {
		super(new StatusEstacaoHistorico());
	}
	
	public StatusEstacaoHistorico findLastID(Integer id)throws Exception{
		
		List<StatusEstacaoHistorico> lista = findAll();
		Integer tam = lista.size() - 1;
		if(tam == null){
			tam = lista.size();
			// System.out.println("Tem nada na TABELA: " +tam);
		}
		// System.out.println("Tamanho de gravação: " + tam);
		StatusEstacaoHistorico seh = lista.get(tam);
		// System.out.println("Ultimo ID da Tabela : " + seh.getIdStatusEstacaoHistorico());
		// System.out.println("Ultimo MODO da Tabela : " + seh.getIdModoStatusEstacao());
		// System.out.println("Ultimo DATA da Tabela : " + seh.getDataHoraStatusEstacaoHistorico());
		// System.out.println("Ultimo TOQUE da Tabela : " + seh.getIdToqueStatusEstacao());
		return seh;
		
		
	}
	public List<StatusEstacaoHistorico> findAllStatusAnual()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(StatusEstacaoHistorico.class);
		
		@SuppressWarnings("deprecation")
		Date datainicio=  new Date(113,0,01,0,0,0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataHora = sdf.format(datainicio);
		Date date =(Date) sdf.parse(dataHora);
		// System.out.println("data incio = "+datainicio);
		
		Date datafim = new Date();
		String dataHora2 = sdf.format(datafim);
		Date date2 = (Date) sdf.parse(dataHora2);
		// System.out.println("data fim = "+date2);
		
		
		criteria.add(Restrictions.between("dataHoraStatusEstacaoHistorico", date, date2));
		List<StatusEstacaoHistorico> status = criteria.list();
		// System.out.println("Lista criteria"+criteria.list().size());
		session.close();
		return status;
	}
	public List<StatusEstacaoHistorico> findByModoStatus(Integer modo, Integer idEstacao)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("SELECT seh FROM StatusEstacaoHistorico seh WHERE seh.idEstacao=:param1 AND seh.idModoStatusEstacao=:param2");
		query.setInteger("param1", idEstacao);
		query.setInteger("param2", modo);
		List<StatusEstacaoHistorico> lista = query.list();
		session.close();
		return lista;
		
	}
	public Double TempoDisponivelEm365Dias(Integer idEstacao)throws Exception{

		open();
		stmt = con.prepareStatement("SELECT * FROM StatusEstacaoHistorico WHERE idEstacao=? AND idModoStatusEstacao=1  AND dataHoraStatusEstacaoHistorico BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -525600 MINUTE)) AND NOW() ORDER BY dataHoraStatusEstacaoHistorico");
		stmt.setInt(1, idEstacao);
		rs = stmt.executeQuery();
		List<StatusEstacaoHistorico> lista = new ArrayList<StatusEstacaoHistorico>();
		
		while(rs.next()){
			StatusEstacaoHistorico seh = new StatusEstacaoHistorico(rs.getInt("idStatusEstacaoHistorico"),
					rs.getDate("dataHoraStatusEstacaoHistorico"), rs.getInt("idEstacao"),
					rs.getInt("idModoStatusEstacao"), rs.getInt("idToqueStatusEstacao"));
			lista.add(seh);
		}
		// System.out.println("TAMANHO DA LISTA DOS DISPONIVEIS DE 365 DIAS : "+ lista.size());
		
		
	
		Double valor = ((double)lista.size()) * 3.0;
		close();
		return valor/60;
	}
	public Double TempoDisponivelEm30Dias(Integer idEstacao)throws Exception{
			open();
			stmt = con.prepareStatement("SELECT * FROM StatusEstacaoHistorico WHERE idEstacao=? AND idModoStatusEstacao=1  AND dataHoraStatusEstacaoHistorico BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -43200 MINUTE)) AND NOW() ORDER BY dataHoraStatusEstacaoHistorico");
			stmt.setInt(1, idEstacao);
			rs = stmt.executeQuery();
			List<StatusEstacaoHistorico> lista = new ArrayList<StatusEstacaoHistorico>();			
		
			while(rs.next()){
				StatusEstacaoHistorico seh = new StatusEstacaoHistorico(rs.getInt("idStatusEstacaoHistorico"),
						rs.getDate("dataHoraStatusEstacaoHistorico"), rs.getInt("idEstacao"),
						rs.getInt("idModoStatusEstacao"), rs.getInt("idToqueStatusEstacao"));
				lista.add(seh);
			}
			// System.out.println("TAMANHO DA LISTA DOS DISPONIVEIS DE 30 DIAS : "+ lista.size());
			
			
		
			Double valor = ((double)lista.size()) * 3.0;
			close();
			return valor/60;
	}
	
	
}
