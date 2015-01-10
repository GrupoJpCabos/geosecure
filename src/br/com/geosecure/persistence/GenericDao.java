package br.com.geosecure.persistence;

import java.io.Serializable;
import java.util.List;
import java.sql.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GenericDao<E, ID extends Serializable, STRING extends Serializable>implements IDao<E, ID, STRING> {
	
	Session session;
	Criteria criteria;
	Transaction transaction;
	Query query;
	
	E entity;
	
	public GenericDao(E entity){
		this.entity = entity;
	}
	
	public void save(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		session.close();
		System.out.println("Salvo com Sucesso!");
		
	}

	public void update(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		session.close();
		System.out.println("Editado com Sucesso!");
		
	}

	public void delete(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();
		System.out.println("Deletado com Sucesso!");
	}
	public List<E> findAll()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(entity.getClass());
		@SuppressWarnings("unchecked")
		List<E> lista = criteria.list();
		session.close();
		return lista;
	}
	@SuppressWarnings("unchecked")
	public E findById(ID cod)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		E obj = (E) session.get(entity.getClass(), cod);
		session.close();
		return obj;
	}
	public List<E> findByObj(STRING cod)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(entity.getClass());
		criteria.add(Restrictions.ilike("cod",cod));
		@SuppressWarnings("unchecked")
		List<E> lista = criteria.list();
		session.close();
		return lista;
	}
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	
	public void open() throws Exception{
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
		//Class.forName("com.mysql.jdbc.Driver");
		
 // con = DriverManager.getConnection("jdbc:mysql://192.168.10.241:3306/geo2","root","tatancas"); //Usando a DB do Banco
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geosecure","root",""); // Usando a db daqui
 // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geosecureteresopolis","root",""); // Quando Subir o projeto Região Serrana
		
		
	}
	
	
	public void close() throws Exception{
		
		con.close();
		
	

}
	
}
