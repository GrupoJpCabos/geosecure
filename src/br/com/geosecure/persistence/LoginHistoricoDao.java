package br.com.geosecure.persistence;

import br.com.geosecure.entity.LoginHistorico;

public class LoginHistoricoDao extends GenericDao<LoginHistorico, Integer, String> {
	public LoginHistoricoDao() {
		super(new LoginHistorico());
	}
}
