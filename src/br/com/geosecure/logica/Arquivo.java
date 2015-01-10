package br.com.geosecure.logica;


import java.io.RandomAccessFile;


public class Arquivo  {

	/*
	 * UMA DAS Classes responsaveis pela manipulação de arquivo
	 */
	RandomAccessFile raf;
	
	
	public void abrirArquivo(String caminho) throws Exception {
		raf = new RandomAccessFile(caminho, "rw");
	}

	
	public void escrever(String texto) throws Exception {
		/*
		 * raf.seek -> Posicionar o cursor
		 * raf.length() -> Pegar o tamanho do arquivo
		 */
		raf.seek(0);
		/*
		 * Escrever no arquivo
		 */
		raf.writeBytes(texto);
	}

	
	public void fechar() throws Exception {
		raf.close();
	}

	
	public String lerArquivo() throws Exception {
		String resp;
		/*
		 * Classe utilizada para manipular String
		 */
		StringBuilder sb = new StringBuilder();
		while((resp = raf.readLine()) != null){
			sb.append(resp);
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
