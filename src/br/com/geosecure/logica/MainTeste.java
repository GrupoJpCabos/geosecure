package br.com.geosecure.logica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;


public class MainTeste {
	
	
	public static void main(String[] args) {
		String hostname = "192.168.10.19";
		Integer porta = 22;
		String username="root";
		String password="tatancas" ;
		try {
			Ssh ssh = new Ssh();
			
			
			//String retorno = ssh.verificaOnOff("192.168.10.19", 22);
			//System.out.println(retorno);
			 
			
			
			//Integer verificou = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
			//System.out.println(verificou);
			
			
			
			
			
			//String n =ssh.verificarPausetxt(hostname, porta, username, password);
			//System.out.println("Pause.txt = " +n);
			
			//String nn =ssh.verificarAmplificadortxt(hostname, porta, username, password);
			//System.out.println("Amplificador.txt = " +nn);
			
			
			
			//ssh.desligaSsh(hostname, porta, username, password);
			
			String retorna = ssh.verificaOnOff("192.168.10.10", porta);
			System.out.println(retorna);
			
			//ssh.mobilizaSsh(hostname, porta, username, password);
			//ssh.desmobilizaSsh(hostname, porta, username, password);
			//ssh.avisoTeste(hostname, porta, username, password);
		
					
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		

	}

}
