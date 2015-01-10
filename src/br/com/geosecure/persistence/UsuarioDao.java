package br.com.geosecure.persistence;


import org.hibernate.criterion.Restrictions;

import br.com.geosecure.entity.Usuario;

	

public class UsuarioDao extends GenericDao<Usuario, Integer, String> {
	
	public UsuarioDao(){
		super(new Usuario());
	}
	
	public Usuario findbyLogin(String login)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("loginUsuario", login));
		Usuario u = (Usuario) criteria.uniqueResult();
		session.close();
		return u;
	}
	
	public Usuario efetuarLogin(Usuario usuario)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria= session.createCriteria(Usuario.class);
		criteria.add(Restrictions.and(
				Restrictions.eq("loginUsuario", usuario.getLoginUsuario()),
				Restrictions.eq("senhaUsuario", usuario.getSenhaUsuario())
				));
		Usuario u = (Usuario) criteria.uniqueResult();
		session.close();
		return u;
	}
	
	public Usuario efetuarLogin2(Usuario usuario)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query= session.createQuery("FROM Login l WHERE u.login=:param1 AND l.senha=:param2");
		query.setString("param1", usuario.getLoginUsuario());
		query.setString("param2", usuario.getSenhaUsuario());
		Usuario u = (Usuario) query.uniqueResult();
		session.close();
		return u;
	}
}
