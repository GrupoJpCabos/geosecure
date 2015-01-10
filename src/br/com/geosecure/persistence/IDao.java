package br.com.geosecure.persistence;

import java.util.List;

public interface IDao<E, ID, STRING> {
	
	void save(E obj)throws Exception;
	void update(E obj)throws Exception;
	void delete(E obj)throws Exception;
	
	List<E> findAll()throws Exception;
	E findById(ID cod)throws Exception;

}
