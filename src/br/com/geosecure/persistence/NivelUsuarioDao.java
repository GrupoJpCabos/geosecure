package br.com.geosecure.persistence;

import br.com.geosecure.entity.NivelUsuario;

public class NivelUsuarioDao extends GenericDao<NivelUsuario, Integer, String> {
	
	public NivelUsuarioDao() {
		super(new NivelUsuario());
	}

}
