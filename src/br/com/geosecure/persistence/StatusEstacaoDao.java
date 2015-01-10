package br.com.geosecure.persistence;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.entity.ToqueStatusEstacao;

public class StatusEstacaoDao extends GenericDao<StatusEstacao, Integer, String> {
	
	public StatusEstacaoDao(){
		super(new StatusEstacao());
	}

	public Integer findByIdEstacao(Integer id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select idStatusEstacao From StatusEstacao WHERE idEstacao=:param");
		query.setInteger("param", id);
		Integer statusEstacao = (Integer)  query.uniqueResult();
		session.close();
		return statusEstacao;
	}
	
	
	public ToqueStatusEstacao findByIdToqueStatus(Integer id)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select ToqueStatusEstacao From ToqueStatusEstacao where idToqueStatusEstacao=:param");
		query.setInteger("param", id);
		ToqueStatusEstacao mse = (ToqueStatusEstacao) query.uniqueResult();
		session.close();
		return mse;
	}
	public List<StatusEstacao> findByModoStatus(Integer on)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query =session.createQuery("Select se From StatusEstacao se where se.modostatusestacao.idModoStatusEstacao=:param9");
		query.setInteger("param9", on);
		List<StatusEstacao> lista = query.list();
		session.close();		
		
		return lista;
	}
	public Double findByDataHora(Integer idEstacao)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select x.dataHoraStatusEstacao from StatusEstacao x where idEstacao=:param1 ");
		query.setInteger("param1", idEstacao);
		
		//PEGANDO AS DATAS 
		//TRANSFORMA A DATA
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dataAntes = sdf.parse(sdf.format((Date) query.uniqueResult()));
		// System.out.println("Data do data Anterior : "+dataAntes);
		
		Date dataAgora = sdf.parse(sdf.format(new Date()));
		// System.out.println("Data do data agora: "+dataAgora);
		
		
		long diferenca = dataAgora.getTime() - dataAntes.getTime();
		
		// System.out.println("TOTAL DA DIFERENCA EM HORA: "+(double) (diferenca/1000/60/60));
		
		session.close();
		return (double) (diferenca/1000/60/60);
	}
	public Integer findLastStatus(Integer idContinuo)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select se.modostatusestacao.idModoStatusEstacao from StatusEstacao se where se.continuoStatusEstacao.idContinuoStatusEstacao=:param");
		query.setInteger("param", idContinuo);
		Integer modo = (Integer) query.uniqueResult();
		session.close();
		return modo;
	}
	public Integer howManyInativas()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select se from StatusEstacao se where se.modostatusestacao.idModoStatusEstacao=2 or se.modostatusestacao.idModoStatusEstacao=3 ");
		List<StatusEstacao> lista = query.list();
		session.close();
		return lista.size();
	}
	
	
	
	
	
	
	
	
	
	
}
