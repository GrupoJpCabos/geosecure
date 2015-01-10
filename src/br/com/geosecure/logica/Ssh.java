package br.com.geosecure.logica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class Ssh {
	public void connect() {

	}

	// Mobiliza uma Estação de cada vez
	 public String mobilizaSsh(String hostname, Integer porta, String username,
			   String password) throws Exception {

			  String retorno = "ok";
			  Connection connEscrever = null;
			  Connection connTocar = null;
			  Session sessEscrever = null;
			  Session sessTocar = null;

			  try {

			   connEscrever = new Connection(hostname, porta);
			   connEscrever.connect(null, 30000, 30000);
			   connEscrever.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   
			   sessEscrever = connEscrever.openSession();
			   sessEscrever.execCommand("rm /home/var/toque.txt; echo Mobilizacao >>  /home/var/toque.txt");
			   InputStream stdout2 = new StreamGobbler(sessEscrever.getStdout());

			   BufferedReader br2 = new BufferedReader(
			     new InputStreamReader(stdout2));


			   while (true) {
			    String line = br2.readLine();
			    if (line == null)
			     break;

			    // // System.out.println(line);

			   }

			   sessEscrever.close();

			   // // System.out.println("Escrevendo Mobilizar");
			   connEscrever.close();
			   
			   
			   
			   
// // System.out.println("==========================================================================================================");


			   connTocar = new Connection(hostname, porta);
			   connTocar.connect(null, 30000, 30000);
			   connTocar.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   sessTocar= connTocar.openSession();
			   // // System.out.println("Sessao Aberta");
			   String cmd = "java -jar /home/protocolo.jar";
			   sessTocar.execCommand(cmd);

			   InputStream stdout = new StreamGobbler(sessTocar.getStdout());

			   BufferedReader br = new BufferedReader(
			     new InputStreamReader(stdout));

			   br.readLine();

			   // while (true) {
			   // String line = br.readLine();
			   // if (line == null)
			   // break;
			   // acao = line;
			   //
			   // // // System.out.println(acao);
			   //
			   // }

			   sessTocar.close();

			   // // System.out.println("Executado o Mobilizar");
			   

			  
			  } catch (Exception e) {

			   retorno = "fail";
			   e.printStackTrace();

			  }

			  connTocar.close();
			  return retorno;

			 }
	 public String desmobilizaSsh(String hostname, Integer porta, String username,
			   String password) throws Exception {

			  String retorno = "ok";
			  Connection connEscrever = null;
			  Connection connTocar = null;
			  Session sessEscrever = null;
			  Session sessTocar = null;

			  try {

			   connEscrever = new Connection(hostname, porta);
			   connEscrever.connect(null, 30000, 30000);
			   connEscrever.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   
			   sessEscrever = connEscrever.openSession();
			   sessEscrever.execCommand("rm /home/var/toque.txt; echo Desmobilizacao >>  /home/var/toque.txt");
			   InputStream stdout2 = new StreamGobbler(sessEscrever.getStdout());

			   BufferedReader br2 = new BufferedReader(
			     new InputStreamReader(stdout2));


			   while (true) {
			    String line = br2.readLine();
			    if (line == null)
			     break;

			    // // System.out.println(line);

			   }

			   sessEscrever.close();

			   // // System.out.println("Escrevendo Desmobilizacao");
			   connEscrever.close();
			   
			   
			   
			   
// // System.out.println("==========================================================================================================");


			   connTocar = new Connection(hostname, porta);
			   connTocar.connect(null, 30000, 30000);
			   connTocar.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   sessTocar= connTocar.openSession();
			   // // System.out.println("Sessao Aberta");
			   String cmd = "java -jar /home/protocolo.jar";
			   sessTocar.execCommand(cmd);

			   InputStream stdout = new StreamGobbler(sessTocar.getStdout());

			   BufferedReader br = new BufferedReader(
			     new InputStreamReader(stdout));

			   br.readLine();

			   // while (true) {
			   // String line = br.readLine();
			   // if (line == null)
			   // break;
			   // acao = line;
			   //
			   // // // System.out.println(acao);
			   //
			   // }

			   sessTocar.close();

			   // // System.out.println("Executado o Desmobilizacao");
			   

			  
			  } catch (Exception e) {

			   retorno = "fail";
			   e.printStackTrace();

			  }

			  connTocar.close();
			  return retorno;

			 }

	 public String avisoTeste(String hostname, Integer porta, String username,
			   String password) throws Exception {

			  String retorno = "ok";
			  Connection connEscrever = null;
			  Connection connTocar = null;
			  Session sessEscrever = null;
			  Session sessTocar = null;

			  try {

			   connEscrever = new Connection(hostname, porta);
			   connEscrever.connect(null, 30000, 30000);
			   connEscrever.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   
			   sessEscrever = connEscrever.openSession();
			   sessEscrever.execCommand("rm /home/var/toque.txt; echo Teste >>  /home/var/toque.txt");
			   InputStream stdout2 = new StreamGobbler(sessEscrever.getStdout());

			   BufferedReader br2 = new BufferedReader(
			     new InputStreamReader(stdout2));


			   while (true) {
			    String line = br2.readLine();
			    if (line == null)
			     break;

			    // // System.out.println(line);

			   }

			   sessEscrever.close();

			   // // System.out.println("Escrevendo Teste");
			   connEscrever.close();
			   
			   
			   
			   
// // System.out.println("==========================================================================================================");


			   connTocar = new Connection(hostname, porta);
			   connTocar.connect(null, 30000, 30000);
			   connTocar.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   sessTocar= connTocar.openSession();
			   // // System.out.println("Sessao Aberta");
			   String cmd = "java -jar /home/protocolo.jar";
			   sessTocar.execCommand(cmd);

			   InputStream stdout = new StreamGobbler(sessTocar.getStdout());

			   BufferedReader br = new BufferedReader(
			     new InputStreamReader(stdout));

			   br.readLine();

			   // while (true) {
			   // String line = br.readLine();
			   // if (line == null)
			   // break;
			   // acao = line;
			   //
			   // // // System.out.println(acao);
			   //
			   // }

			   sessTocar.close();

			   // // System.out.println("Executado o Teste");
			   

			  
			  } catch (Exception e) {

			   retorno = "fail";
			   e.printStackTrace();

			  }

			  connTocar.close();
			  return retorno;

			 }
	 public String TesteSsh(String hostname, Integer porta, String username,
			   String password) throws Exception {

			  String retorno = "ok";
			  Connection connEscrever = null;
			  Connection connTocar = null;
			  Session sessEscrever = null;
			  Session sessTocar = null;

			  try {

			   connEscrever = new Connection(hostname, porta);
			   connEscrever.connect(null, 30000, 30000);
			   connEscrever.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   
			   sessEscrever = connEscrever.openSession();
			   sessEscrever.execCommand("rm /home/var/toque.txt; echo Manutencao >>  /home/var/toque.txt");
			   InputStream stdout2 = new StreamGobbler(sessEscrever.getStdout());

			   BufferedReader br2 = new BufferedReader(
			     new InputStreamReader(stdout2));


			   while (true) {
			    String line = br2.readLine();
			    if (line == null)
			     break;

			    // // System.out.println(line);

			   }

			   sessEscrever.close();

			   // // System.out.println("Escrevendo Manutencao");
			   connEscrever.close();
			   
			   
			   
			   
// // System.out.println("==========================================================================================================");


			   connTocar = new Connection(hostname, porta);
			   connTocar.connect(null, 30000, 30000);
			   connTocar.authenticateWithPassword(username, password);
			   // // System.out.println("Conectado");
			   sessTocar= connTocar.openSession();
			   // // System.out.println("Sessao Aberta");
			   String cmd = "java -jar /home/protocolo.jar";
			   sessTocar.execCommand(cmd);

			   InputStream stdout = new StreamGobbler(sessTocar.getStdout());

			   BufferedReader br = new BufferedReader(
			     new InputStreamReader(stdout));

			   br.readLine();

			   // while (true) {
			   // String line = br.readLine();
			   // if (line == null)
			   // break;
			   // acao = line;
			   //
			   // // // System.out.println(acao);
			   //
			   // }

			   sessTocar.close();

			   // // System.out.println("Executado o Teste");
			   

			  
			  } catch (Exception e) {

			   retorno = "fail";
			   e.printStackTrace();

			  }

			  connTocar.close();
			  return retorno;

			 }

	public String desligaSsh(String hostname, Integer porta, String username,
			String password) throws Exception {

		String retorno = "ok";
		Connection conn = null;
		Session sess = null;
		String cmd = null;

		try {

			conn = new Connection(hostname, porta);
			conn.connect(null, 30000, 30000);
			conn.authenticateWithPassword(username, password);
			// // System.out.println("Conectado");

			sess = conn.openSession();
			// // System.out.println("Sessao Aberta");
			cmd = "java -jar /home/desligar.jar";
			sess.execCommand(cmd);

			// // System.out.println("Executado o Desligar");

			sess.close();
			conn.close();
		} catch (Exception e) {
			retorno = "fail";
		}
		conn.close();
		return retorno;

	}

	public String verificaOnOff(String hostname, Integer porta) {

		String retorno = "online";
		Connection conn = new Connection(hostname, porta);

		try {

			conn.connect(null, 30000, 30000);
			// conn.connect();

		} catch (Exception e) {

			retorno = "offline";
			// e.printStackTrace();

		}
		conn.close();
		return retorno;
	}

	public Integer verificaStatusAcaoEstacao(String hostname, Integer porta, String username,
			   String password) throws Exception { 

			  String retorno = "ok";
			  Connection conn = null;
			  Session sess = null;
			  String line = null;
			  Integer resultado =null;

			  try {

			   conn = new Connection(hostname, porta);
			   conn.connect(null, 30000, 30000);
			   conn.authenticateWithPassword(username, password);
			  // // // System.out.println("Conectado");

			   sess = conn.openSession();

			   //// // System.out.println("Sessao Aberta");

			   sess = conn.openSession();
			   sess.execCommand("cat /home/var/toque.txt");
			   InputStream stdout = new StreamGobbler(sess.getStdout());

			   BufferedReader br = new BufferedReader(
			     new InputStreamReader(stdout));

			   while (true) {
			    line = br.readLine();
			    if (line == null){
			     break;
			     }
			    // // System.out.println(line);
				
			    
			   
			   line = line.trim();
			   // // System.out.println("OQUE ESTA NO TOQUE.TXT>>"+line);
			   
			   if(line.equalsIgnoreCase("Mobilizacao")){
				   resultado=1;
			   }else if(line.equalsIgnoreCase("Desmobilizacao")){
				   resultado=2;
			   }else if(line.equalsIgnoreCase("Manutencao")){
				   resultado=3;
			   }else if(line.equalsIgnoreCase("Desligado")){
				   resultado=4;
			   }else if(line.equalsIgnoreCase("Teste")){
				   resultado=5;
			   }else{
				   // // System.out.println("OUTRO TOQUE !");
			   }
			   
			   }
			   
			   sess.close();
			   conn.close();
			   

			  } catch (Exception e) {
				  retorno = "fail";
			  }
			 // // // System.out.println("O RETORNO TA SENDO:::" +resultado);
			 return resultado;
			  
		}
	public String verificarPausetxt(String hostname, Integer porta, String username,
			   String password){
		  String retorno = "ok";
		  Connection conn = null;
		  Session sess = null;
		  String line = null;
		  String resultado =null;

		  try {

		   conn = new Connection(hostname, porta);
		   conn.connect(null, 30000, 30000);
		   conn.authenticateWithPassword(username, password);
		  // // // System.out.println("Conectado");

		   sess = conn.openSession();

		 //  // // System.out.println("Sessao Aberta");

		   sess = conn.openSession();
		   sess.execCommand("cat /home/var/pause.txt");
		   InputStream stdout = new StreamGobbler(sess.getStdout());

		   BufferedReader br = new BufferedReader(
		     new InputStreamReader(stdout));

		   while (true) {
		    line = br.readLine();
		    if (line == null){
		     break;
		     }
		    
		    line = line.trim();
		  //  // // System.out.println("OQUE ESTA NO PAUSE.TXT DENTRO DO RASP>>"+line);
		    
			if(line.equalsIgnoreCase("1")){
				resultado = "On";
			}else if(line.equalsIgnoreCase("0")){
				resultado = "Off";
			}else{
				resultado= "Problema!";
			}
		    
		  
		   
		   }
		   
		   sess.close();
		   conn.close();
		   
		   sess = conn.openSession();
		   
		   

		  } catch (Exception e) {
			  retorno = "fail";
		  }
		  // // // System.out.println("O RETORNO TA SENDO DA VERIFICAÇÃO DA PAUSA:::" +resultado);
		
		 return resultado;
			
	}
	public String verificarAmplificadortxt(String hostname, Integer porta, String username,
			   String password){
		  String retorno = "ok";
		  Connection conn = null;
		  Session sess = null;
		  String line = null;
		  String resultado =null;

		  try {

		   conn = new Connection(hostname, porta);
		   conn.connect(null, 30000, 30000);
		   conn.authenticateWithPassword(username, password);
		   // // // System.out.println("Conectado");

		   sess = conn.openSession();

		   // // // System.out.println("Sessao Aberta");

		   sess = conn.openSession();
		   sess.execCommand("cat /home/var/amplificador.txt");
		   InputStream stdout = new StreamGobbler(sess.getStdout());

		   BufferedReader br = new BufferedReader(
		     new InputStreamReader(stdout));

		   while (true) {
		    line = br.readLine();
		    if (line == null){
		     break;
		     }
		    
		    line = line.trim();
		    // // // System.out.println("OQUE ESTA NO AMPLIFICADOR.TXT DENTRO DO RASP>>"+line);
		    
			if(line.equalsIgnoreCase("1")){
				resultado = "On";
			}else if(line.equalsIgnoreCase("0")){
				resultado = "Off";
			}else{
				resultado= "Problema!";
			}
		    
		  
		   
		   }
		   
		   sess.close();
		   conn.close();
		   

		  } catch (Exception e) {
			  retorno = "fail";
		  }
		  // // // System.out.println("O RETORNO TA SENDO DA VERIFICAÇÃO DO AMPLIFICADOR:::" +resultado);
		
		 return resultado;
			
	}
	public String verificarPortatxt(String hostname, Integer porta, String username,
			   String password){
		  String retorno = "ok";
		  Connection conn = null;
		  Session sess = null;
		  String line = null;
		  String resultado =null;

		  try {

		   conn = new Connection(hostname, porta);
		   conn.connect(null, 30000, 30000);
		   conn.authenticateWithPassword(username, password);
		   // // // System.out.println("Conectado");

		   sess = conn.openSession();

		   // // // System.out.println("Sessao Aberta");

		   sess = conn.openSession();
		   sess.execCommand("cat /home/var/porta.txt");
		   InputStream stdout = new StreamGobbler(sess.getStdout());

		   BufferedReader br = new BufferedReader(
		     new InputStreamReader(stdout));

		   while (true) {
		    line = br.readLine();
		    if (line == null){
		     break;
		     }
		    
		    line = line.trim();
		    // // // System.out.println("OQUE ESTA NO PORTA.TXT DENTRO DO RASP>>"+line);
		    
			resultado = line;
		    
		  
		   
		   }
		   
		   sess.close();
		   conn.close();
		   
		   sess = conn.openSession();
		   
		   

		  } catch (Exception e) {
			  retorno = "fail";
		  }
		  // // System.out.println("O RETORNO TA SENDO DA VERIFICAÇÃO DA PORTA:::" +resultado);
		
		 return resultado;
			
	}
public void uploadToque(String usuarioEstacao, String senhaEstacao, String ipEstacao, Integer portaEstacao, String path) throws Exception{

		
		Connection conn = null;
		SCPClient scp = null;
					
			
		conn = new Connection(ipEstacao, portaEstacao);
		conn.connect(null, 30000, 30000);
		conn.authenticateWithPassword(usuarioEstacao, senhaEstacao);
		
		// // System.out.println("Conectado");
		
		
		scp = conn.createSCPClient();

		// // System.out.println("Conexao Aberta");
		
		//scp.get("/home", path);
		
		//scp.get(path, "/home");
		
		scp.put(path, "/home");
		
		
		// // System.out.println("Arquivo Transferido");
		
		conn.close();
		
		}
	
		
		
}
