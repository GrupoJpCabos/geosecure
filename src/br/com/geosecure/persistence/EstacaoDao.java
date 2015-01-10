package br.com.geosecure.persistence;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;


import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.Pluviometro;

public class EstacaoDao extends GenericDao<Estacao, Integer, String> {

	public EstacaoDao(){
		super(new Estacao());
	}
	public String converteDataHora(Long time) throws Exception{
		

		Timestamp t = new Timestamp(time); 
		Date d = new Date(t.getTime());
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
		String dataHoraFormatada = formatador.format(d);	

		String dataHora =  dataHoraFormatada;
		// System.out.println("Data após a conversão= " + dataHora);
		return dataHora;
				
	}
	
	public List<Integer> findAllId()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select idEstacao From Estacao");
		List<Integer> lista = query.list();
		return lista;
	}
	public Estacao findByIdPluviometro(Integer id)throws Exception{
		session =HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Estacao.class);
		criteria.add(Restrictions.ilike("idPluviometro", id));
		Estacao estacao = (Estacao) criteria.uniqueResult();
		session.close();
		return estacao;
	}
	public String findByIdTheNome(Integer id)throws Exception{
		session =HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select nomeEstacao from Estacao where idEstacao=:param1");
		query.setInteger("param1", id);
		String nomeEstacao = (String) query.uniqueResult();
		session.close();
		return nomeEstacao;
	}
	public List<Pluviometro> findByLeituraMenor10()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select e from Estacao e where e.pluviometroe.tempo60minutos  BETWEEN '0.0 ' and  '10.0 '");
		List<Pluviometro> lista = query.list();
		session.close();
		return lista;
	}
	public List<Pluviometro> findByLeituraEntre10e20()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select e from Estacao e where e.pluviometroe.tempo60minutos  BETWEEN '10.1 ' and  '20.0 '");
		List<Pluviometro> lista = query.list();
		session.close();
		return lista;
	}
	public List<Pluviometro> findByLeituraAcima20()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select e from Estacao e where e.pluviometroe.tempo60minutos  BETWEEN '20.0 ' and  '900.0 '");
		List<Pluviometro> lista = query.list();
		session.close();
		return lista;
	}
	public List<Estacao> findAllPluviometrica()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select e from Estacao e where e.tipoestacao.idTipoEstacao=2");
		List<Estacao> lista = query.list();
		session.close();
		return lista;
	}

}
