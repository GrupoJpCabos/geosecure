package br.com.geosecure.persistence;

import br.com.geosecure.entity.PdfAcionamentoUsuario;


public class PdfAcionamentoUsuarioDao extends GenericDao<PdfAcionamentoUsuario, Integer, String>{
	public PdfAcionamentoUsuarioDao() {
		super(new PdfAcionamentoUsuario());
		// TODO Auto-generated constructor stub
	}
	public void deleteAll()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("delete from PdfAcionamentoUsuario");
		query.executeUpdate();
		session.close();
	}


}
