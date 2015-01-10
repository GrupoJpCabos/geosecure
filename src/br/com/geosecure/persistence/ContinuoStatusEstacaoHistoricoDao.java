package br.com.geosecure.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.geosecure.entity.ContinuoStatusEstacaoHistorico;


public class ContinuoStatusEstacaoHistoricoDao extends GenericDao<ContinuoStatusEstacaoHistorico, Integer, String> {
	
	public ContinuoStatusEstacaoHistoricoDao() {
		super(new ContinuoStatusEstacaoHistorico());
	}

	public List<ContinuoStatusEstacaoHistorico> failIn1Ano(Integer idEstacao)throws Exception{
		

			open();
			stmt = con.prepareStatement("SELECT * FROM ContinuoStatusEstacaoHistorico WHERE idEstacao=? AND dataInicioHistorico BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -525600 MINUTE)) AND NOW() ORDER BY dataInicioHistorico");
			stmt.setInt(1, idEstacao);
			rs = stmt.executeQuery();
			List<ContinuoStatusEstacaoHistorico> lista = new ArrayList<ContinuoStatusEstacaoHistorico>();
			
			while(rs.next()){
				ContinuoStatusEstacaoHistorico seh = new ContinuoStatusEstacaoHistorico(rs.getInt("idContinuoStatusEstacaoHistorico"),
						rs.getInt("idEstacao"), rs.getDouble("totalEstacaoHistorico"), rs.getTimestamp("dataInicioHistorico"),
						rs.getTimestamp("dataFinalHistorico"), rs.getInt("modoStatusEstacao"));
				lista.add(seh);
			}
			// System.out.println("TAMANHO DA LISTA DAS FALHAS DE 365 DIAS : "+ lista.size());

			close();
			return lista;
		}
		public List<ContinuoStatusEstacaoHistorico> failIn1Mes(Integer idEstacao)throws Exception{
		

		open();
		stmt = con.prepareStatement("SELECT * FROM ContinuoStatusEstacaoHistorico WHERE idEstacao=? AND dataInicioHistorico BETWEEN (SELECT DATE_ADD(NOW(), INTERVAL -43200 MINUTE)) AND NOW() ORDER BY dataInicioHistorico");
		stmt.setInt(1, idEstacao);
		rs = stmt.executeQuery();
		List<ContinuoStatusEstacaoHistorico> lista = new ArrayList<ContinuoStatusEstacaoHistorico>();
		
		while(rs.next()){
			ContinuoStatusEstacaoHistorico seh = new ContinuoStatusEstacaoHistorico(rs.getInt("idContinuoStatusEstacaoHistorico"),
					rs.getInt("idEstacao"), rs.getDouble("totalEstacaoHistorico"), rs.getTimestamp("dataInicioHistorico"),
					rs.getTimestamp("dataFinalHistorico"), rs.getInt("modoStatusEstacao"));
			lista.add(seh);
		}
		// System.out.println("TAMANHO DA LISTA DAS FALHAS DE 365 DIAS : "+ lista.size());

		close();
		return lista;
	}
	}

