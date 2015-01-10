package br.com.geosecure.persistence;

import java.util.List;

import br.com.geosecure.entity.DisponibilidadeStatusEstacao;
import br.com.geosecure.entity.StatusEstacaoHistorico;

public class DisponibilidadeStatusEstacaoDao extends GenericDao<DisponibilidadeStatusEstacao, Integer, String> {

	public DisponibilidadeStatusEstacaoDao() {
		super(new DisponibilidadeStatusEstacao());
		// TODO Auto-generated constructor stub
	}
	
	public Integer findByIdForStatus(Integer idStatus)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("Select s.disponibilidadeStatusEstacao.idDisponibilidadeStatusEstacao From StatusEstacao s where s.idStatusEstacao=:param1");
		query.setInteger("param1", idStatus);
		Integer idDisponibilidade = (Integer) query.uniqueResult();
		session.close();
		return idDisponibilidade;
		
	}
	public Double indisponibilidadeAnualEstacao(Integer idEstacao ,Integer status)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select se from StatusEstacaoHistorico se where dataHoraStatusEstacaoHistorico between '2013-01-01 00:00:00' and '2014-01-01 00:00:00' and se.idModoStatusEstacao=:param1 and se.idEstacao=:param2");
		query.setInteger("param1", status);
		query.setInteger("param2", idEstacao);
		List<StatusEstacaoHistorico> lista = query.list();
		Integer tamanhoLista = lista.size();
		Double soma = (tamanhoLista * 3.0)/60.0;
		session.close();
		
		// System.out.println("Indisponibilidade CADA ESTACAO: "+soma);
		

		return soma;
	}
	
	public Double indisponibilidadeAnualGlobal()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select se from StatusEstacaoHistorico se where dataHoraStatusEstacaoHistorico between '2013-01-01 00:00:00' and '2014-01-01 00:00:00' and se.idModoStatusEstacao=2");
		List<StatusEstacaoHistorico> lista = query.list();
		Integer tamanhoLista = lista.size();
		Double soma = (tamanhoLista * 3.0)/60.0;
		session.close();
		
		// System.out.println("Indisponibilidade GLOBAL: "+soma);
		

		return soma;
	}
	public Double disponibilidadeAnualEstacao(Integer idEstacao ,Integer status)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select se from StatusEstacaoHistorico se where dataHoraStatusEstacaoHistorico between '2013-01-01 00:00:00' and '2014-01-01 00:00:00' and se.idModoStatusEstacao=:param1 and se.idEstacao=:param2");
		query.setInteger("param1", status);
		query.setInteger("param2", idEstacao);
		List<StatusEstacaoHistorico> lista = query.list();
		Integer tamanhoLista = lista.size();
		Double soma = (tamanhoLista * 3.0)/60.0;
		session.close();
		
		// System.out.println("Disponibilidade CADA ESTACAO: "+soma);
		

		return soma;
	}

}
