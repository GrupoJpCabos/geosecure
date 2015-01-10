package br.com.geosecure.persistence;

import java.util.List;
import java.util.Collections;



import br.com.geosecure.entity.Pluviometro;


public class PluviometroDao extends GenericDao<Pluviometro, Integer, String>{
	
	public PluviometroDao(){
		super(new Pluviometro());
	}
	public Pluviometro findById2(Integer cod)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select idPluviometro from pluviometro where idPluviometro=:param1");
		query.setInteger("param1", cod);
		Pluviometro p = (Pluviometro) query.uniqueResult();
		
		session.close();
		return p;
	}
	
	public Integer findLeituraExata(List<Integer> listaLeituras)throws Exception{
		//é menor, pois o pluviometer vai somando as leituras, então a primeira é menor
		Integer primeiraLeitura  = Collections.min(listaLeituras);
		
		//é MAIOR, pois o pluviometer vai somando as leituras, então a ultima é sempre maior
		Integer ultimaLeitura = Collections.max(listaLeituras);
		
		
		// // System.out.println("Ultima leitura= "+ultimaLeitura);
		// // System.out.println("Primeira leitura= "+primeiraLeitura);
		
		
		Integer leituraExata = ultimaLeitura - primeiraLeitura;
		
		// // System.out.println("Leitura Exata= "+leituraExata);
		
		Integer listaLeiturasTamanho = listaLeituras.size();
		
		
		if(listaLeiturasTamanho==1){
			
			leituraExata = 0;
			
		}
		
		return leituraExata;
		 
	}

	
	


		
	
	
}
