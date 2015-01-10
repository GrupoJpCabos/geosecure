package br.com.geosecure.persistence;

import br.com.geosecure.entity.AcessoEstacao;

public class AcessoEstacaoDao extends GenericDao<AcessoEstacao, Integer, String> {
	public AcessoEstacaoDao (){
		super(new AcessoEstacao());
	}
}
