package br.com.geosecure.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.geosecure.entity.UltimoCheck;
import br.com.geosecure.persistence.EstacaoDao;
import br.com.geosecure.persistence.LogicaDao;
import br.com.geosecure.persistence.UltimoCheckDao;

public class JobHora implements Job {
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<Integer> listaIdsEstacoes = new ArrayList<Integer>();
		EstacaoDao ed = new EstacaoDao();
		UltimoCheck ultimoCheck = new UltimoCheck();
		UltimoCheckDao ultimoCheckDao = new UltimoCheckDao();
		
		try {

			listaIdsEstacoes = ed.findAllId();
			for (Integer id : listaIdsEstacoes) {
				System.out.println("id:" +id);
				Thread thread = new Thread(new LogicaDao(id));
				thread.start();

			}	
			
			
			Date data = new Date();
			System.out.println("Imprimindo data "+data);
			Date data2 = new Date(ultimoCheckDao.converteDataHora(data));
			System.out.println("Imprimindo data nova "+data2);
			
			ultimoCheck.setDataHoraUltimoCheck(data2);
			ultimoCheckDao.save(ultimoCheck);
			System.out.println("Hora do check cadastrada");

		} catch(Exception e) {
			e.printStackTrace();
		}


	}

}