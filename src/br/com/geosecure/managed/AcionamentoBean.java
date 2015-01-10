package br.com.geosecure.managed;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.com.geosecure.entity.AcaoHistorico;
import br.com.geosecure.entity.AcessoEstacao;
import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.entity.Usuario;
import br.com.geosecure.logica.Ssh;
import br.com.geosecure.persistence.AcaoHistoricoDao;
import br.com.geosecure.persistence.EstacaoDao;
import br.com.geosecure.persistence.StatusEstacaoDao;
import br.com.geosecure.persistence.UsuarioDao;


public class AcionamentoBean {
	private Estacao estacao;
	private StatusEstacao statusEstacao;
	private AcaoHistorico acaoHistorico;
	private Usuario usuario;
	private Ssh ssh;
	private AcessoEstacao acessoEstacao;
	private List<String> lista;
	private List<Estacao> listaItems;
	private List<SelectItem> listaSelect;
	private List<Estacao> listaToques;

	
	public AcionamentoBean() {
		estacao = new Estacao();
		listaItems = new ArrayList<Estacao>();
		statusEstacao = new StatusEstacao();
		acaoHistorico = new AcaoHistorico();
		ssh = new Ssh();
		acessoEstacao= new AcessoEstacao();
	}
	
	public Ssh getSsh() {
		return ssh;
	}

	public void setSsh(Ssh ssh) {
		this.ssh = ssh;
	}

	public AcessoEstacao getAcessoEstacao() {
		return acessoEstacao;
	}

	public void setAcessoEstacao(AcessoEstacao acessoEstacao) {
		this.acessoEstacao = acessoEstacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AcaoHistorico getAcaoHistorico() {
		return acaoHistorico;
	}

	public void setAcaoHistorico(AcaoHistorico acaoHistorico) {
		this.acaoHistorico = acaoHistorico;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	
	public StatusEstacao getStatusEstacao() {
		return statusEstacao;
	}

	public void setStatusEstacao(StatusEstacao statusEstacao) {
		this.statusEstacao = statusEstacao;
	}
	
	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public List<Estacao> getListaItems() {
		try {
			listaItems = new EstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaItems;
	}

	public void setListaItems(List<Estacao> listaItems) {
		
		this.listaItems = listaItems;
	}
	
	

	public List<SelectItem> getListaSelect() {
		try {
			listaSelect = new ArrayList<SelectItem>();
			for(Estacao ge : new EstacaoDao().findAll()){
				listaSelect.add(new SelectItem(ge.getIdEstacao(),ge.getNomeEstacao()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaSelect;
	}

	public void setListaSelect(List<SelectItem> listaSelect) {
		this.listaSelect = listaSelect;
	}
	
	public List<Estacao> getListaToques() {
		try {
			listaToques = new EstacaoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaToques;
	}

	public void setListaToques(List<Estacao> listaToques) {
		this.listaToques = listaToques;
	}

	public String mobilizar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// // System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				
				
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// // System.out.println("Mobilizando : "+idEstacao);
				
				Date data = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String dataHora = sdf.format(data);
				Date date = (Date) sdf.parse(dataHora);
				
				
				
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

				Integer idUsuario = (Integer) session.getAttribute("id");
				
				// // System.out.println("ID DO USUARIO "+idUsuario);
				
				estacao = new EstacaoDao().findById(idEstacao);
				usuario = new UsuarioDao().findById(idUsuario);
				
				// // System.out.println("NOME DA ESTACAO: " +estacao.getNomeEstacao());
				// System.out.println("NOME DO USUARIO: "+ usuario.getNomeUsuario());
				
				
				//levando para o pluviometro
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				// System.out.println("PORTA: " +acessoEstacao.getPortaAcessoEstacao());
				// System.out.println("IP : "+acessoEstacao.getDnsAcessoEstacao());
				
				String hostname = acessoEstacao.getDnsAcessoEstacao();
				Integer porta = new Integer(acessoEstacao.getPortaAcessoEstacao());
				String username = acessoEstacao.getUsuarioAcessoEstacao();
				String password = acessoEstacao.getSenhaAcessoEstacao();
				
				String result = ssh.mobilizaSsh(hostname, porta, username, password);
				Thread.sleep(3000);
				String pause = ssh.verificarPausetxt(hostname, porta, username, password);
				String amplificador=ssh.verificarAmplificadortxt(hostname, porta, username, password);
				
				//// System.out.println("RETORNO DO PAUSE PARA O BEAN >>>"+pause);
				//// System.out.println("RETORNO DO RESULT DO TOQUE PARA O BEAN >>>"+result);
				//// System.out.println("RETORNO DO AMPLIFICADOR PARA O BEAN >>>"+amplificador);
				if(result.equalsIgnoreCase("ok")){
					Integer oqToca = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
					if(oqToca == 1){
						
						//PEGANDO QUEM ESTAR ACIONANDO 
						acaoHistorico.setIdAcaoHistorico(null);
						acaoHistorico.setEstacaoah(estacao);
						acaoHistorico.setDataHoraAcaoHistorico(date);
						acaoHistorico.setToqueStatusEstacao(1);
						acaoHistorico.setUsuario(usuario);
						new AcaoHistoricoDao().save(acaoHistorico);
						
						//SALVANDO NO BANCO O TOQUE DA ESTACOES
						Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
						statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setPause(pause);
						 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(1);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						statusEstacao.setEstacaose(statusEstacao.getEstacaose());
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao .setModostatusestacao(statusEstacao.getModostatusestacao());
						
						new StatusEstacaoDao().update(statusEstacao);
						
						fc.addMessage("form", new FacesMessage("MOBILIZANDO COM SUCESSO :    "+estacao.getNomeEstacao()));
					}else{
						fc.addMessage("formula", new FacesMessage("Está tocando outra parada!"));
					}
				}else{
					fc.addMessage("formula", new FacesMessage("A Estação "+estacao.getNomeEstacao()+" não está Online"));
				}

				
			}
		} catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("formula", new FacesMessage("Erro ao Conectar na " +estacao.getNomeEstacao()+" !!!"));
		}
		return null;
	}
	public String desmobilizar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// System.out.println("Desmobilizar : "+idEstacao);
				
				
				
				//PEGANDO QUEM ESTAR ACIONANDO 
				Date data = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String dataHora = sdf.format(data);
				Date date = (Date) sdf.parse(dataHora);
				
				
				//PEGANDO QUEM ESTAR ACIONANDO 
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
				Integer idUsuario = (Integer) session.getAttribute("id");
				
				// System.out.println("ID DO USUARIO "+idUsuario);
				
				estacao = new EstacaoDao().findById(idEstacao);
				usuario = new UsuarioDao().findById(idUsuario);
				
				// System.out.println("NOME DA ESTACAO: " +estacao.getNomeEstacao());
				// System.out.println("NOME DO USUARIO: "+ usuario.getNomeUsuario());
				
				//levando para o pluviometro
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				// System.out.println("PORTA: " +acessoEstacao.getPortaAcessoEstacao());
				// System.out.println("IP : "+acessoEstacao.getDnsAcessoEstacao());
				
				String hostname = acessoEstacao.getDnsAcessoEstacao();
				Integer porta = new Integer(acessoEstacao.getPortaAcessoEstacao());
				String username = acessoEstacao.getUsuarioAcessoEstacao();
				String password = acessoEstacao.getSenhaAcessoEstacao();
				
				String result = ssh.desmobilizaSsh(hostname, porta, username, password);
				Thread.sleep(3000);
				String pause = ssh.verificarPausetxt(hostname, porta, username, password);
				String amplificador=ssh.verificarAmplificadortxt(hostname, porta, username, password);
				
				//// System.out.println("RETORNO DO PAUSE PARA O BEAN >>>"+pause);
				//// System.out.println("RETORNO DO RESULT DO TOQUE PARA O BEAN >>>"+result);
				//// System.out.println("RETORNO DO AMPLIFICADOR PARA O BEAN >>>"+amplificador);
				if(result.equalsIgnoreCase("ok")){
					Integer oqToca = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
					if(oqToca == 2){
						
						//PEGANDO QUEM ESTAR ACIONANDO 
						acaoHistorico.setIdAcaoHistorico(null);
						acaoHistorico.setEstacaoah(estacao);
						acaoHistorico.setDataHoraAcaoHistorico(date);
						acaoHistorico.setToqueStatusEstacao(2);
						acaoHistorico.setUsuario(usuario);
						new AcaoHistoricoDao().save(acaoHistorico);
						
						//SALVANDO NO BANCO O TOQUE DA ESTACOES
						Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
						statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setPause(pause);
						 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(2);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						statusEstacao.setEstacaose(statusEstacao.getEstacaose());
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao .setModostatusestacao(statusEstacao.getModostatusestacao());
						
						new StatusEstacaoDao().update(statusEstacao);
						
						fc.addMessage("formula", new FacesMessage("DESMOBILIZANDO COM SUCESSO :    "+estacao.getNomeEstacao()));
					}else{
						fc.addMessage("formula", new FacesMessage("NÂO FOI POSSIVEL ACIONAR, TESTE NOVAMENTE A ESTAÇÃO: "+estacao.getNomeEstacao()));
					}
				}else{
					fc.addMessage("formula", new FacesMessage("A Estação "+estacao.getNomeEstacao()+" não está Online"));
				}

				
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro ao Conectar na " +estacao.getNomeEstacao()+" !!!"));
		}
		return null;
	}
	public String testar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// System.out.println("Testar : "+idEstacao);
				
				//PEGANDO QUEM ESTAR ACIONANDO 
				Date data = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String dataHora = sdf.format(data);
				Date date = (Date) sdf.parse(dataHora);
				
				
				
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

				Integer idUsuario = (Integer) session.getAttribute("id");
				
				// System.out.println("ID DO USUARIO "+idUsuario);
				
				estacao = new EstacaoDao().findById(idEstacao);
				usuario = new UsuarioDao().findById(idUsuario);
				
				// System.out.println("NOME DA ESTACAO: " +estacao.getNomeEstacao());
				// System.out.println("NOME DO USUARIO: "+ usuario.getNomeUsuario());

				
				//levando para o pluviometro
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				// System.out.println("PORTA: " +acessoEstacao.getPortaAcessoEstacao());
				// System.out.println("IP : "+acessoEstacao.getDnsAcessoEstacao());
				
				String hostname = acessoEstacao.getDnsAcessoEstacao();
				Integer porta = new Integer(acessoEstacao.getPortaAcessoEstacao());
				String username = acessoEstacao.getUsuarioAcessoEstacao();
				String password = acessoEstacao.getSenhaAcessoEstacao();
				
				
				
				
				String result = ssh.TesteSsh(hostname, porta, username, password);
				Thread.sleep(3000);
				String pause = ssh.verificarPausetxt(hostname, porta, username, password);
				String amplificador=ssh.verificarAmplificadortxt(hostname, porta, username, password);
				
				//// System.out.println("RETORNO DO PAUSE PARA O BEAN >>>"+pause);
				//// System.out.println("RETORNO DO RESULT DO TOQUE PARA O BEAN >>>"+result);
				//// System.out.println("RETORNO DO AMPLIFICADOR PARA O BEAN >>>"+amplificador);
				
				
				
				
				if(result.equalsIgnoreCase("ok")){
					Integer oqToca = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
					// System.out.println("Verifica o que toca");
					if(oqToca == 5){
						// System.out.println("Estar tocando Teste");
						//PEGANDO QUEM ESTAR ACIONANDO 
						acaoHistorico.setIdAcaoHistorico(null);
						acaoHistorico.setEstacaoah(estacao);
						acaoHistorico.setDataHoraAcaoHistorico(date);
						acaoHistorico.setToqueStatusEstacao(3);
						acaoHistorico.setUsuario(usuario);
						new AcaoHistoricoDao().save(acaoHistorico);
						
						//SALVANDO NO BANCO O TOQUE DA ESTACOES
						Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
						statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setPause(pause);
						 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(3);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						statusEstacao.setEstacaose(statusEstacao.getEstacaose());
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao .setModostatusestacao(statusEstacao.getModostatusestacao());
						
						new StatusEstacaoDao().update(statusEstacao);
						
						fc.addMessage("formula", new FacesMessage("TESTANDO COM SUCESSO :    "+estacao.getNomeEstacao()));
					}else{
						fc.addMessage("formula", new FacesMessage("NÃO FOI POSSIVEL ACIONAR, TESTE NOVAMENTE A ESTAÇÃO: "+estacao.getNomeEstacao()));
					}
				}else{
					fc.addMessage("formula", new FacesMessage("A Estação "+estacao.getNomeEstacao()+" não está Online"));
				}

				
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro ao Conectar na " +estacao.getNomeEstacao()+" !!!"));
		}
		return null;
	}
	public String avisoTeste(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			//// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				//// System.out.println("avisando Teste : "+idEstacao);
				
				
				Date data = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String dataHora = sdf.format(data);
				Date date = (Date) sdf.parse(dataHora);
				
				
				//PEGANDO QUEM ESTAR ACIONANDO 
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
				Integer idUsuario = (Integer) session.getAttribute("id");
				
				//// System.out.println("ID DO USUARIO "+idUsuario);
				
				estacao = new EstacaoDao().findById(idEstacao);
				usuario = new UsuarioDao().findById(idUsuario);
				
				// System.out.println("NOME DA ESTACAO: " +estacao.getNomeEstacao());
				// System.out.println("NOME DO USUARIO: "+ usuario.getNomeUsuario());
				
                 //levando para o pluviometro
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				//// System.out.println("PORTA: " +acessoEstacao.getPortaAcessoEstacao());
				//// System.out.println("IP : "+acessoEstacao.getDnsAcessoEstacao());
				
				String hostname = acessoEstacao.getDnsAcessoEstacao();
				Integer porta = new Integer(acessoEstacao.getPortaAcessoEstacao());
				String username = acessoEstacao.getUsuarioAcessoEstacao();
				String password = acessoEstacao.getSenhaAcessoEstacao();
				
				
				String result = ssh.avisoTeste(hostname, porta, username, password);
				Thread.sleep(3000);
				String pause = ssh.verificarPausetxt(hostname, porta, username, password);
				String amplificador=ssh.verificarAmplificadortxt(hostname, porta, username, password);
				
				//// System.out.println("RETORNO DO PAUSE PARA O BEAN >>>"+pause);
				//// System.out.println("RETORNO DO RESULT DO TOQUE PARA O BEAN >>>"+result);
				//// System.out.println("RETORNO DO AMPLIFICADOR PARA O BEAN >>>"+amplificador);
				if(result.equalsIgnoreCase("ok")){
					Integer oqToca = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
					if(oqToca == 5){
						
						//PEGANDO QUEM ESTAR ACIONANDO 
						acaoHistorico.setIdAcaoHistorico(null);
						acaoHistorico.setEstacaoah(estacao);
						acaoHistorico.setDataHoraAcaoHistorico(date);
						acaoHistorico.setToqueStatusEstacao(5);
						acaoHistorico.setUsuario(usuario);
						new AcaoHistoricoDao().save(acaoHistorico);
						
						//SALVANDO NO BANCO O TOQUE DA ESTACOES
						Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
						statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setPause(pause);
						 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(5);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						statusEstacao.setEstacaose(statusEstacao.getEstacaose());
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao .setModostatusestacao(statusEstacao.getModostatusestacao());
						
						new StatusEstacaoDao().update(statusEstacao);
						
						fc.addMessage("formula", new FacesMessage("FOI AVISADO COM SUCESSO :    "+estacao.getNomeEstacao()));
					}else{
						fc.addMessage("formula", new FacesMessage("NÂO FOI POSSIVEL ACIONAR, TESTE NOVAMENTE A ESTAÇÃO: "+estacao.getNomeEstacao()));
					}
				}else{
					fc.addMessage("formula", new FacesMessage("A Estação "+estacao.getNomeEstacao()+" não está Online"));
				}

				
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro ao Conectar na " +estacao.getNomeEstacao()+" !!!"));
		}
		return null;
	}
	public String desligar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// System.out.println("Desligando : "+idEstacao);
				
				Date data = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				
				String dataHora = sdf.format(data);
				Date date = (Date) sdf.parse(dataHora);
				
				
				//PEGANDO QUEM ESTAR ACIONANDO 
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

				Integer idUsuario = (Integer) session.getAttribute("id");
				
				// System.out.println("ID DO USUARIO "+idUsuario);
				
				estacao = new EstacaoDao().findById(idEstacao);
				usuario = new UsuarioDao().findById(idUsuario);
				
				// System.out.println("NOME DA ESTACAO: " +estacao.getNomeEstacao());
				// System.out.println("NOME DO USUARIO: "+ usuario.getNomeUsuario());
				
				//levando para o pluviometro
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				// System.out.println("PORTA: " +acessoEstacao.getPortaAcessoEstacao());
				// System.out.println("IP : "+acessoEstacao.getDnsAcessoEstacao());
				
				String hostname = acessoEstacao.getDnsAcessoEstacao();
				Integer porta = new Integer(acessoEstacao.getPortaAcessoEstacao());
				String username = acessoEstacao.getUsuarioAcessoEstacao();
				String password = acessoEstacao.getSenhaAcessoEstacao();
				
				
				
			
				
				
					Integer oqToca = ssh.verificaStatusAcaoEstacao(hostname, porta, username, password);
					if(oqToca != 1||oqToca != 2 || oqToca != 3 || oqToca !=4 || oqToca!=5){
						@SuppressWarnings("unused")
						String result = ssh.desligaSsh(hostname, porta, username, password);
						String pause = ssh.verificarPausetxt(hostname, porta, username, password);
						String amplificador=ssh.verificarAmplificadortxt(hostname, porta, username, password);
						//PEGANDO QUEM ESTAR ACIONANDO 
						acaoHistorico.setIdAcaoHistorico(null);
						acaoHistorico.setEstacaoah(estacao);
						acaoHistorico.setDataHoraAcaoHistorico(date);
						acaoHistorico.setToqueStatusEstacao(4);
						acaoHistorico.setUsuario(usuario);
						new AcaoHistoricoDao().save(acaoHistorico);
						
						//SALVANDO NO BANCO O TOQUE DA ESTACOES
						Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
						statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setPause(pause);
						 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(4);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						statusEstacao.setEstacaose(statusEstacao.getEstacaose());
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao .setModostatusestacao(statusEstacao.getModostatusestacao());
						
						new StatusEstacaoDao().update(statusEstacao);
						
						fc.addMessage("formula", new FacesMessage("DESLIGADO COM SUCESSO :    "+estacao.getNomeEstacao()));
					}else{
						fc.addMessage("formula", new FacesMessage("NÂO FOI POSSIVEL ACIONAR, TESTE NOVAMENTE A ESTAÇÃO: "+estacao.getNomeEstacao()));
					}
				

				
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro ao Conectar na " +estacao.getNomeEstacao()+" !!!"));
		}
		return null;
	}
	public String manutencao(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// System.out.println("Desligando : "+idEstacao);
				
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				//SALVANDO NO BANCO O TOQUE DA ESTACOES
				Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
				statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
				
				 statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(4);
				statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
				statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
				statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
				statusEstacao.setEstacaose(statusEstacao.getEstacaose());
				statusEstacao.setIdStatusEstacao(idStatusEstacao);
				statusEstacao .getModostatusestacao().setIdModoStatusEstacao(3);
				
				new StatusEstacaoDao().update(statusEstacao);
				fc.addMessage("formula", new FacesMessage("A ESTAÇÃO: "+estacao.getNomeEstacao()+ "  FOI PARA MANUNTENÇÃO"));
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro: "+e.getMessage()));
			e.printStackTrace();
		}
		
		
		return null;
	}
	public String retirarManutencao(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			int tam = lista.size();
			// System.out.println("Tamanho da lista "+tam);
			for(int i=0; i<tam;i++){
				String idString = lista.get(i);
				Integer idEstacao = new Integer(idString);
				// System.out.println("Desligando : "+idEstacao);
				
				estacao = new EstacaoDao().findById(idEstacao);
				acessoEstacao = estacao.getAcessoestacao();
				//SALVANDO NO BANCO O TOQUE DA ESTACOES
				Integer idStatusEstacao = new StatusEstacaoDao().findByIdEstacao(idEstacao);
				statusEstacao = new StatusEstacaoDao().findById(idStatusEstacao);
				
				statusEstacao.getToquestatusestacao().setIdToqueStatusEstacao(4);
				statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
				statusEstacao.setDataHoraStatusEstacao(statusEstacao.getDataHoraStatusEstacao());
				statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
				statusEstacao.setEstacaose(statusEstacao.getEstacaose());
				statusEstacao.setIdStatusEstacao(idStatusEstacao);
				statusEstacao .getModostatusestacao().setIdModoStatusEstacao(1);
				
				new StatusEstacaoDao().update(statusEstacao);
				fc.addMessage("formula", new FacesMessage("A ESTAÇÃO: "+estacao.getNomeEstacao()+ "  FOI RETIRADA DA MANUNTENÇÃO"));
			}
		} catch (Exception e) {
			fc.addMessage("formula", new FacesMessage("Erro: "+e.getMessage()));
		}
		
		
		return null;
	}
	public String cancelar(){
		return "listar_status";
	}
	
}
