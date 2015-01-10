package br.com.geosecure.persistence;

import java.util.List;



import br.com.geosecure.entity.TipoEstacao;

public class TipoEstacaoDao extends GenericDao<TipoEstacao, Integer, String> {

	public TipoEstacaoDao(){
		super(new TipoEstacao());
	}

	
	public List<TipoEstacao> listaTe() throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("tipoestacaoAll");
		List<TipoEstacao> lista = query.list();
		session.close();
		return lista;
	}

	
	
	
}
