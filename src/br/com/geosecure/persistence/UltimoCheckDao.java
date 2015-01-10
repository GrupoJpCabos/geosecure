package br.com.geosecure.persistence;


import java.text.SimpleDateFormat;
import java.util.Date;


import br.com.geosecure.entity.UltimoCheck;

public class UltimoCheckDao extends GenericDao<UltimoCheck, Integer, String> {
	
	public UltimoCheckDao() {
		super(new UltimoCheck());
	}
	
	
	
	public String converteDataHora(Date date) throws Exception{
		

		SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
		String dataHoraFormatada = formatador.format(date);	

		String dataHora =  dataHoraFormatada;
	//	System.out.println("Data após a conversão= " + dataHora);
		return dataHora;
				
	}
	
	public Date findByUltimoCheck()throws Exception{
		open();
		stmt = con.prepareStatement("select dataHoraUltimoCheck from UltimoCheck order by dataHoraUltimoCheck desc limit 1");
		rs = stmt.executeQuery();
		
		Date data = new Date();
		if(rs.next()){
			
			data = rs.getTimestamp("dataHoraUltimoCheck");
		
		}
		close();
		return data;
	}
	
	
}
