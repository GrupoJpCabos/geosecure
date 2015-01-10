package br.com.geosecure.persistence;

import br.com.geosecure.entity.ToqueStatusEstacao;

public class ToqueStatusEstacaoDao extends GenericDao<ToqueStatusEstacao, Integer, String>{
	public ToqueStatusEstacaoDao() {
		super(new ToqueStatusEstacao());
	}
	public String findToque(Integer idToque)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select t.tipoToqueStatusEstacao from ToqueStatusEstacao t where t.idToqueStatusEstacao=:param");
		query.setInteger("param", idToque);
		String toque = (String) query.uniqueResult();
		session.close();
		return toque;
	}


}
