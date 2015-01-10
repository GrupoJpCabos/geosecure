package br.com.geosecure.persistence;

import br.com.geosecure.entity.ModoStatusEstacao;

public class ModoStatusEstacaoDao extends GenericDao<ModoStatusEstacao, Integer, String> {
	public ModoStatusEstacaoDao(){
		super(new ModoStatusEstacao());
	}
}
