package br.com.geosecure.persistence;

import br.com.geosecure.entity.EnderecoEstacao;

public class EnderecoEstacaoDao extends GenericDao<EnderecoEstacao, Integer, String> {

	public EnderecoEstacaoDao() {
		super(new EnderecoEstacao());
	}
}
