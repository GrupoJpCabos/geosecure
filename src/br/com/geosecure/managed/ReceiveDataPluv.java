package br.com.geosecure.managed;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.geosecure.entity.Pluviometro;
import br.com.geosecure.entity.PluviometroHistoricoConvertido;
import br.com.geosecure.entity.PluviometroHistoricoLeitura;
import br.com.geosecure.entity.PluviometroHistoricoLeituraCrescente;
import br.com.geosecure.persistence.PluviometroDao;
import br.com.geosecure.persistence.PluviometroHistoricoConvertidoDao;
import br.com.geosecure.persistence.PluviometroHistoricoLeituraCrescenteDao;
import br.com.geosecure.persistence.PluviometroHistoricoLeituraDao;

/**
 * Servlet implementation class ReceiveDataPluv
 */
public class ReceiveDataPluv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PluviometroHistoricoLeitura phl;
	private PluviometroHistoricoConvertido phc;
    private Pluviometro p;
    private PluviometroHistoricoLeituraCrescente pluviometroCrescente;
   
    
    
    
    public ReceiveDataPluv() {
        super();
        phl = new PluviometroHistoricoLeitura();
        p = new Pluviometro();
        phc = new PluviometroHistoricoConvertido();
        pluviometroCrescente = new PluviometroHistoricoLeituraCrescente();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			System.out.println("------------------------------");
			System.out.println("-----DADOS--DA--PLAQUINHA-----");
			System.out.println("------------------------------");
			System.out.println("------------------------------");
			System.out.println("-----RECEVE--DATA--PLUV-------");
			System.out.println("------------------------------");
			// RESGATO OS PARAMETROS QUE SERÃO PASSADOS VIA doGET
			
			
			System.out.println(request.getParameter("es"));
			
			Integer id = new Integer(request.getParameter("es"));
			
			System.out.println("Resgatando o ID(es): "+id);
			
			//Long time = Long.parseLong(request.getParameter("dh"));
			//System.out.println("Resgatando Data em Unixtime= " + time);
			
			
			String dataHora = request.getParameter("dh");
			System.out.println("Datahora(dh) " + dataHora);
			
			Double leitura = Double.parseDouble(request.getParameter("PV"));
			System.out.println("Resgatando leitura(PV) = " + leitura);
			
			
	
			dataHora = dataHora.replace("R"," ");
					
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date datinha = sdf.parse(dataHora);
			
			//System.out.println("Data Convertida ==>  "+datinha);
			
			//TESTANDO O PARAMETROS VIA GET NO BANCO
			
			PluviometroDao pd = new PluviometroDao();
			PluviometroHistoricoLeituraDao phld = new PluviometroHistoricoLeituraDao();
			PluviometroHistoricoConvertidoDao phcd = new PluviometroHistoricoConvertidoDao();	
			PluviometroHistoricoLeituraCrescenteDao phlcd = new PluviometroHistoricoLeituraCrescenteDao();
			
			/**
			 * 
			 *  COMEÇANDO A LOGICA 
			 *  
			**/
			
			
//			System.out.println("------------------COMEÇO A MANDAR DADOS---------------");
			Integer idPlaca = id;
			
			// Pegar o pluviometro que tenha esse ID 
			//Ultima Leitura
			p = pd.findById(id);
						
			Double lastLeituraDoida =  phld.findLastLeituraById(idPlaca);
//			System.out.println("ULTIMA LEITURA Doida: "+lastLeituraDoida);
			
			
			
			
			Double leituraAgoraDoida = leitura;
//			System.out.println("LEITURA AGORA: " +leituraAgoraDoida);
			
			
			Double lastLeituraCerta = phlcd.findLastLeituraById(idPlaca);
//			System.out.println("ULTIMA LEITURA CERTA: "+lastLeituraCerta);
		
			
			if(lastLeituraDoida == null){
				//INSERINDO NA TABELA PHL
				phl.setDataHoraPluviometroHistoricoLeitura(datinha);
				Double x = leitura*1.0;
				phl.setLeituraPluviometroHistoricoLeitura(x);
				phl.setPluviometro(p);
				phld.save(phl);
     			System.out.println("SALVO NA TABELA HISTORICO LEITURA");
//				System.out.println("A DOIDA");
				
				
				pluviometroCrescente.setDataHoraPluviometroHistoricoLeituraCrescente(datinha);
				pluviometroCrescente.setLeituraPluviometroHistoricoLeituraCrescente(x);
				pluviometroCrescente.setPluviometroCrescente(p);
				phlcd.save(pluviometroCrescente);
//				System.out.println("SALVO NA TABELA HISTORICO LEITURA CRESCENTE");
//				System.out.println("A CERTA");
					
				
	
			}else{
				//INSERINDO NA TABELA PHL
				Double x = leitura*1.0;
				phl.setDataHoraPluviometroHistoricoLeitura(datinha);
				phl.setLeituraPluviometroHistoricoLeitura(x);
				phl.setPluviometro(p);
				phld.save(phl);
//				System.out.println("SALVO NA TABELA HISTORICO LEITURA");
//				System.out.println("A DOIDA");
			
			
			// COMEÇO COM A LOGICA DE ATUALIZAÇÃO DOS DADOS DO
			// PLUVIOMETRO PARA EXIBIÇÃO

			// BUSCO O MULTIPLICADOR CORRESPONDENTE A ESTAÇÃO
			Float multiplicador = p.getMultiplicador();
//			System.out.println("Resgatando multiplicador= "	+ multiplicador);

			
			/**
			 * Logica das Tabelas Louca e Doidas !
			 * **/
			
//			System.out.println("leituraAgoraDoida: "+ leituraAgoraDoida);
//			System.out.println("lastLeituraDoida: "+lastLeituraDoida);
			
			
			
			if(leituraAgoraDoida.equals(lastLeituraDoida)){
//				System.out.println("Entrei no if do IGUAL");
				pluviometroCrescente.setLeituraPluviometroHistoricoLeituraCrescente(lastLeituraDoida);
				pluviometroCrescente.setDataHoraPluviometroHistoricoLeituraCrescente(datinha);
				pluviometroCrescente.setPluviometroCrescente(p);
				phlcd.save(pluviometroCrescente);
//				System.out.println("Dados Atualizados!");
//				System.out.println("LEITURA: "+pluviometroCrescente.getLeituraPluviometroHistoricoLeituraCrescente());
				
			}
			else if(leituraAgoraDoida > lastLeituraDoida){
//				System.out.println("Entro no if do ++");
				Double var = leituraAgoraDoida - lastLeituraDoida;
//				System.out.println("VAR : "+var);
				Double var2 = var + lastLeituraCerta;
//				System.out.println("VAR2 : "+var2);
				pluviometroCrescente.setLeituraPluviometroHistoricoLeituraCrescente(var2);
				pluviometroCrescente.setDataHoraPluviometroHistoricoLeituraCrescente(datinha);
				pluviometroCrescente.setPluviometroCrescente(p);
				phlcd.save(pluviometroCrescente);
	//			System.out.println("Dados Atualizados!");
//				System.out.println("LEITURA: "+var2);
			}
			else if(leituraAgoraDoida < lastLeituraDoida){
	//			System.out.println("Entrando no if --");
				Double var = leituraAgoraDoida + lastLeituraDoida;
//				System.out.println("VAR : "+var);
				
				pluviometroCrescente.setLeituraPluviometroHistoricoLeituraCrescente(var);
				pluviometroCrescente.setDataHoraPluviometroHistoricoLeituraCrescente(datinha);
				pluviometroCrescente.setPluviometroCrescente(p);
				phlcd.save(pluviometroCrescente);
//				System.out.println("Dados Atualizados!");
	//			System.out.println("LEITURA: "+var);
			}else if(leituraAgoraDoida == 0.00){
				pluviometroCrescente.setLeituraPluviometroHistoricoLeituraCrescente(lastLeituraCerta);
				pluviometroCrescente.setDataHoraPluviometroHistoricoLeituraCrescente(datinha);
				pluviometroCrescente.setPluviometroCrescente(p);
				phlcd.save(pluviometroCrescente);
	//			System.out.println("Dados Atualizados!");
			
				
			}else{
				System.out.println("Erro! Nos IFS");
			}
			// PEGO QUANTOS TOCS OCORRERAM NOS TEMPOS DE 15MIN, 1H, 24H
			// 96H
			 
			 
			 Calendar c = Calendar.getInstance();  
			 c.add(Calendar.MINUTE, -15); 
			 

			List<Integer> listaLeituras15min = phld.findLeiturasCrescente1(idPlaca, 20);
//			System.out.println("Resgatando leituras de 15 minutos atrás= "+ listaLeituras15min);

			List<Integer> listaLeituras30min = phld.findLeiturasCrescente1(idPlaca, 35);
//			System.out.println("Resgatando leituras de 30 minutos atrás= "+ listaLeituras30min);
			
			List<Integer> listaLeituras45min = phld.findLeiturasCrescente1(idPlaca, 50);
//			System.out.println("Resgatando leituras de 45 minutos atrás= "+ listaLeituras45min);
			
			List<Integer> listaLeituras1hora = phld.findLeiturasCrescente1(idPlaca, 65);
	//		System.out.println("Resgatando leituras de 1 hora atrás= "+ listaLeituras1hora);

			List<Integer> listaLeituras2hora = phld.findLeiturasCrescente1(idPlaca, 125);
//			System.out.println("Resgatando leituras de 2 horas atrás= "+ listaLeituras2hora);
			
			List<Integer> listaLeituras3hora = phld.findLeiturasCrescente1(idPlaca, 185);
	//		System.out.println("Resgatando leituras de 3 horas atrás= "+ listaLeituras3hora);
			
			List<Integer> listaLeituras4hora = phld.findLeiturasCrescente1(idPlaca, 245);
	//		System.out.println("Resgatando leituras de 4 horas atrás= "+ listaLeituras4hora);
			
			List<Integer> listaLeituras1dia = phld.findLeiturasCrescente1(idPlaca, 1445);
	//		System.out.println("Resgatando leituras de 1 dia atrás= "+ listaLeituras1dia);
			
			List<Integer> listaLeituras2dias = phld.findLeiturasCrescente1(idPlaca, 2885);
	//		System.out.println("Resgatando leituras de 2 dias atrás= "+ listaLeituras2dias);

			List<Integer> listaLeituras3dias = phld.findLeiturasCrescente1(idPlaca, 4325);
	//		System.out.println("Resgatando leituras de 3 dias atrás= "+ listaLeituras3dias);
			
			List<Integer> listaLeituras4dias = phld.findLeiturasCrescente1(idPlaca, 5765);
		//	System.out.println("Resgatando leituras de 4 dias atrás= "+ listaLeituras4dias);
			
			List<Integer> listaLeituras1mes = phld.findLeiturasCrescente1(idPlaca, 432005);
		//	System.out.println("Resgatando leituras de 1 mes atrás= "+ listaLeituras1mes);
			
			List<Integer> listaLeituras1ano = phld.findLeiturasCrescente1(idPlaca, 5256005);
	//		System.out.println("Resgatando leituras de 1 ano atrás= "+ listaLeituras1ano);
			
			// DIMINUO A ULTIMA LEITURA PELA PRIMEIRA LEITURA, PARA
			// OBTER A LEITURA NAQUELE TEMPO, POIS A LEITURA QUE RECEBO
			// É CUMULATIVA

			Integer leituraExtata15min = pd.findLeituraExata(listaLeituras15min);
			
			Integer leituraExtata30min = pd.findLeituraExata(listaLeituras30min);

			Integer leituraExtata45min = pd.findLeituraExata(listaLeituras45min);
			
			Integer leituraExtata1hora = pd.findLeituraExata(listaLeituras1hora);

			Integer leituraExtata2horas = pd.findLeituraExata(listaLeituras2hora);
			
			Integer leituraExtata3horas = pd.findLeituraExata(listaLeituras3hora);
			
			Integer leituraExtata4horas = pd.findLeituraExata(listaLeituras4hora);
			
			Integer leituraExtata1dia= pd.findLeituraExata(listaLeituras1dia);

			Integer leituraExtata2dias = pd.findLeituraExata(listaLeituras2dias);
			
			Integer leituraExtata3dias = pd.findLeituraExata(listaLeituras3dias);
			
			Integer leituraExtata4dias= pd.findLeituraExata(listaLeituras4dias);
			
			Integer leituraExtata1mes = pd.findLeituraExata(listaLeituras1mes);
			
			Integer leituraExtata1ano = pd.findLeituraExata(listaLeituras1ano);
			
			// MULTIPLICO a LEITURA EXATA PELO MULTIPLICADOR DO
			// PLUVIOMETRO DESTA ESTAÇÃO E OBTENHO O RESULTADO EM MM
			Float tempo15min = leituraExtata15min * multiplicador;
//			System.out.println("Leitura exata de 15 minutos vezes o multiplicador= "+ tempo15min);

			Float tempo30min = leituraExtata30min * multiplicador;
//			System.out.println("Leitura exata de 30 minutos vezes o multiplicador= "+ tempo30min);
			
			Float tempo45min = leituraExtata45min * multiplicador;
//			System.out.println("Leitura exata de 45 minutos vezes o multiplicador= "+ tempo45min);
			
			Float tempo1hora = leituraExtata1hora * multiplicador;
//			System.out.println("Leitura exata de 1 horas vezes o multiplicador= "+ tempo1hora);
			
			Float tempo2horas = leituraExtata2horas * multiplicador;
//			System.out.println("Leitura exata de 2 horas vezes o multiplicador= "+ tempo2horas);
			
			Float tempo3horas = leituraExtata3horas * multiplicador;
//			System.out.println("Leitura exata de 3 horas vezes o multiplicador= "+ tempo3horas);
			
			Float tempo4horas = leituraExtata4horas * multiplicador;
//			System.out.println("Leitura exata de 4 horas vezes o multiplicador= "+ tempo4horas);
			
			Float tempo1dia = leituraExtata1dia * multiplicador;
//			System.out.println("Leitura exata de 1 dia vezes o multiplicador= "	+ tempo1dia);

			Float tempo2dias = leituraExtata2dias * multiplicador;
//	/		System.out.println("Leitura exata de 2 dias vezes o multiplicador= "	+ tempo2dias);
			
			Float tempo3dias = leituraExtata3dias * multiplicador;
//			System.out.println("Leitura exata de 3 dias vezes o multiplicador= "	+ tempo3dias);
			
			Float tempo4dias = leituraExtata4dias * multiplicador;
//			System.out.println("Leitura exata de 4 dias vezes o multiplicador= "	+ tempo4dias);
			
			Float tempo1mes = leituraExtata1mes * multiplicador;
//			System.out.println("Leitura exata de 1 mes vezes o multiplicador= "	+ tempo1mes);
			
			Float tempo1ano = leituraExtata1ano * multiplicador;
//			System.out.println("Leitura exata de 1 ano vezes o multiplicador= "	+ tempo1ano);
						
			
			// FAÇO O UPDATE DOS DADOS NA TABELA PLUVIOMETRO

			// DATA NO FORMATO DE EXIBIÇÃO
		
			
			//CONSULTANDO ID
			p = pd.findById(idPlaca); 
//			System.out.println("Check de ID PLACA: " +p.getIdPluviometro());
//			System.out.println("Deletando a Pluviometro");
			
				
			p.setIdPluviometro(idPlaca); 
			p.setDataHora(datinha);
			p.setMultiplicador(multiplicador);
			p.setTempo15minutos(tempo15min);
			p.setTempo30minutos(tempo30min);
			p.setTempo45minutos(tempo45min);
			p.setTempo60minutos(tempo1hora);
			p.setTempo120minutos(tempo2horas);
			p.setTempo180minutos(tempo3horas);
			p.setTempo240minutos(tempo4horas);
			p.setTempo1440minutos(tempo1dia);
			p.setTempo2880minutos(tempo2dias);
			p.setTempo4320minutos(tempo3dias);
			p.setTempo5760minutos(tempo4dias);
			p.setTempo43200minutos(tempo1mes);
			p.setTempo525600minutos(tempo1ano);
			pd.update(p); 
			System.out.println("Salvando os Pluviometros");
				//Salvando o phc 
			phc.setIdPluviometro(id);
			phc.setDataHoraPluviometroHistoricoConvertido(datinha);
			phc.setIdPluviometroHistoricoConvertido(null);
			phc.setMultiplicador(multiplicador);
			phc.setTempo15minutos(tempo15min);
			phc.setTempo30minutos(tempo30min);
			phc.setTempo45minutos(tempo45min);
			phc.setTempo60minutos(tempo1hora);
			phc.setTempo120minutos(tempo2horas);
			phc.setTempo180minutos(tempo3horas);
			phc.setTempo240minutos(tempo4horas);
			phc.setTempo1440minutos(tempo1dia);
			phc.setTempo2880minutos(tempo2dias);
			phc.setTempo4320minutos(tempo3dias);
			phc.setTempo5760minutos(tempo4dias);
			phc.setTempo43200minutos(tempo1mes);
			phc.setTempo525600minutos(tempo1ano);
			
			phcd.save2(phc); 
			System.out.println("Tabela Pluviometro Historico Convertido GRAVADO !");
				
				
				// CASO TIVER O ID, ATUALIZAR O ID NO BANCO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("Saindo do ReceiveDataPluv");
			p = new Pluviometro();
			phc= new PluviometroHistoricoConvertido();
			phl = new PluviometroHistoricoLeitura();
			pluviometroCrescente = new PluviometroHistoricoLeituraCrescente();
			
		}
		
	}

}
