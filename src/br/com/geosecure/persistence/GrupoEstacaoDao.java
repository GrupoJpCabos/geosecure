package br.com.geosecure.persistence;

import java.util.List;


import br.com.geosecure.entity.GrupoEstacao;


public class GrupoEstacaoDao extends GenericDao<GrupoEstacao, Integer, String>{
	
	public GrupoEstacaoDao(){
		super(new GrupoEstacao());
	}
	
	public List<GrupoEstacao> listargrupo() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("grupoestacaoAll");
		List<GrupoEstacao> lista = query.list();
		session.close();
		return lista;
	}
}
