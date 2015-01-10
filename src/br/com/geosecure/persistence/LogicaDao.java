package br.com.geosecure.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import br.com.geosecure.entity.ContinuoGlobalStatusEstacao;
import br.com.geosecure.entity.ContinuoStatusEstacao;
import br.com.geosecure.entity.ContinuoStatusEstacaoHistorico;
import br.com.geosecure.entity.DisponibilidadeStatusEstacao;
import br.com.geosecure.entity.Estacao;
import br.com.geosecure.entity.ModoStatusEstacao;
import br.com.geosecure.entity.PdfDisponibilidadeRelatorio;
import br.com.geosecure.entity.StatusEstacao;
import br.com.geosecure.entity.StatusEstacaoHistorico;
import br.com.geosecure.entity.ToqueStatusEstacao;
import br.com.geosecure.logica.Ssh;

public class LogicaDao extends HttpServlet implements Runnable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	public LogicaDao() {
	}

	public LogicaDao(Integer id) {
		this.id = id;
	}

	public void run() {

		EstacaoDao estacaoDao = new EstacaoDao();

		String dns = null;
		String porta = null;

		StatusEstacaoHistoricoDao statusEstacaoHistoricoDao = new StatusEstacaoHistoricoDao();
		StatusEstacaoDao statusEstacaoDao = new StatusEstacaoDao();
		StatusEstacao statusEstacao = new StatusEstacao();
		StatusEstacaoHistorico statusEstacaoHistorico = new StatusEstacaoHistorico();
		Estacao estacao = new Estacao();
		ModoStatusEstacao modoStatusEstacao = new ModoStatusEstacao();
		ModoStatusEstacaoDao modoStatusEstacaoDao = new ModoStatusEstacaoDao();
		ToqueStatusEstacao toqueStatusEstacao = new ToqueStatusEstacao();
		ToqueStatusEstacaoDao toqueStatusEstacaoDao = new ToqueStatusEstacaoDao();
		ContinuoStatusEstacao conti = new ContinuoStatusEstacao();
		ContinuoStatusEstacaoDao contiDao = new ContinuoStatusEstacaoDao();
		DisponibilidadeStatusEstacao dispo = new DisponibilidadeStatusEstacao();
		ContinuoStatusEstacaoHistorico contiHistorico = new ContinuoStatusEstacaoHistorico();
		ContinuoStatusEstacaoHistoricoDao contiHistoricoDao = new ContinuoStatusEstacaoHistoricoDao();
		ContinuoGlobalStatusEstacao contiGlobal = new ContinuoGlobalStatusEstacao();
		ContinuoGlobalStatusEstacaoDao contiGlobalDao = new ContinuoGlobalStatusEstacaoDao();

		Ssh ssh = new Ssh();

		System.out.println("ENTRANDO NO LOGICADAO");
		System.out.println("------------------------------");
		System.out.println("-----DADOS--DA--PLAQUINHA-----");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("-ENTRANDO NO CHECK IN 3 MIN---");
		System.out.println("------------------------------");

		try {

			// PEGANDO A DATA ATUAL
			Date data = new Date();
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String dataHora = sdf.format(data);
			Date date = (Date) sdf.parse(dataHora);
			//System.out.println("DATA FORMATADA: " + date);

			estacao = estacaoDao.findById(id);

			// PEGANDO O ID DA StatusEstacao COM O ID DA ESTACAO
			Integer idStatusEstacao = statusEstacaoDao.findByIdEstacao(id);
			//System.out.println("ID Status Estação: " + idStatusEstacao);

			if (idStatusEstacao == null) {

				System.out.println("NAO EXISTE STATUS PARA ESTA ESTACAO");
				modoStatusEstacao.setIdModoStatusEstacao(1);
				toqueStatusEstacao.setIdToqueStatusEstacao(4);

				dispo.setIdDisponibilidadeStatusEstacao(null);
				dispo.setIndisponibilidadeAnual(0.0);

				conti.setCont(1);
				conti.setIdEstacao(id);
				conti.setIdContinuoStatusEstacao(null);
				conti.setTotalEstacao(0.0);

//				contiGlobal.setIdContinuoGlobalStatusEstacao(null);
//				contiGlobal.setDataHoraIncial(null);
//				contiGlobal.setTotalGlobal(0.0);
//				contiGlobalDao.save(contiGlobal);

				contiHistorico.setDataFinalHistorico(date);
				contiHistorico.setDataInicioHistorico(date);
				contiHistorico.setIdEstacao(id);
				contiHistoricoDao.save(contiHistorico);
				
				statusEstacao.setPorta(null);
				statusEstacao.setPause(null);
				statusEstacao.setAmplificador(null);
				statusEstacao.setContinuoStatusEstacao(conti);
				statusEstacao.setDisponibilidadeStatusEstacao(dispo);
				statusEstacao.setDataHoraStatusEstacao(date);
				statusEstacao.setEstacaose(estacao);
				statusEstacao.setModostatusestacao(modoStatusEstacao);
				statusEstacao.setToquestatusestacao(toqueStatusEstacao);

				new PdfDisponibilidadeRelatorioDao()
						.save(new PdfDisponibilidadeRelatorio(null, estacao
								.getNomeEstacao(), null, null, null));

				
				statusEstacaoDao.save(statusEstacao);

				statusEstacao = null;
			}

			// PEGANDO O ID DA Estacao
			idStatusEstacao = statusEstacaoDao.findByIdEstacao(id);
			statusEstacao = statusEstacaoDao.findById(idStatusEstacao);
			//System.out.println("ID Status" + idStatusEstacao);

			
			Integer idEstacao = statusEstacao.getEstacaose().getIdEstacao();
			//System.out.println("ID Estação: " + idEstacao);

			// BUSCANDO A CLASSE COM O ID DA ESTACAO
			// TRAZENDO A PORTA / DNS
			estacao = estacaoDao.findById(id);
			porta = estacao.getAcessoestacao().getPortaAcessoEstacao();
			dns = estacao.getAcessoestacao().getDnsAcessoEstacao();
			String usuario = estacao.getAcessoestacao().getUsuarioAcessoEstacao();
			String senha = estacao.getAcessoestacao().getSenhaAcessoEstacao();

			//System.out.println("PORTA : "+ estacao.getAcessoestacao().getPortaAcessoEstacao());
			//System.out.println("DNS: "+ estacao.getAcessoestacao().getDnsAcessoEstacao());

			// VERIFICANDO SE ESTAR ON ou OFF
			Integer portaInt = new Integer(porta);

			String OnOff = ssh.verificaOnOff(dns, portaInt);
			//System.out.println("Status da Estação" + OnOff);

			statusEstacao = statusEstacaoDao.findById(idStatusEstacao);

			String modoString = statusEstacao.getModostatusestacao().getModoStatusEstacao();
			
			Integer modoInt = statusEstacao.getModostatusestacao().getIdModoStatusEstacao();
			
			//System.out.println("ModoStatus tem o ID: " + modoInt+ " e o Nome de : " + modoString);

			String toqueString = statusEstacao.getToquestatusestacao().getTipoToqueStatusEstacao();
			Integer toqueInt = statusEstacao.getToquestatusestacao().getIdToqueStatusEstacao();
			//System.out.println("ToqueStatus tem o ID: " + toqueInt	+ " e o Nome de : " + toqueString);

			Integer tocando = ssh.verificaStatusAcaoEstacao(dns, portaInt,	usuario, senha);
			//System.out.println("OQ ESTAR TOCANDO : " + tocando);
			
			String pause = ssh.verificarPausetxt(dns, portaInt, usuario, senha);
			//System.out.println("NO ARQUIVO PAUSE.TXT>> "+pause);
			
			String portatxt = ssh.verificarPortatxt(dns, portaInt, usuario, senha);
			
			String amplificador =ssh.verificarAmplificadortxt(dns, portaInt, usuario, senha);
			
			
			
			
			
			
			

			if (tocando == null) {
				tocando = toqueInt;
			}

			if (modoInt == 3) {

				System.out.println(" -------¬");
				System.out.println(" ESTA EM MANUNTENÇÃO ");
				System.out.println("--------- ");

				/***
				 * 
				 * Disponibilidade Anual.
				 * 
				 * **/

				// PEGANDO A CLASSE TODA DOS TOQUES PARA O RELACIONAMENTO
				toqueStatusEstacao = toqueStatusEstacaoDao.findById(tocando);
				modoStatusEstacao = modoStatusEstacaoDao.findById(3);
				statusEstacao.setPause(pause);
				statusEstacao.setPorta(portatxt);
				statusEstacao.setAmplificador(amplificador);
				statusEstacao.setIdStatusEstacao(idStatusEstacao);
				statusEstacao.setDataHoraStatusEstacao(date);
				// RELACIONAMENTO
				
				statusEstacao.setToquestatusestacao(toqueStatusEstacao);
				statusEstacao.setModostatusestacao(modoStatusEstacao);
				statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
				statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
				// UPDATE NO BANCO STATUSESTACAO
				
				statusEstacaoDao.update(statusEstacao);

				statusEstacaoHistorico.setIdToqueStatusEstacao(statusEstacao.getToquestatusestacao().getIdToqueStatusEstacao());
				statusEstacaoHistorico.setIdModoStatusEstacao(toqueInt);
				statusEstacaoHistorico.setIdStatusEstacaoHistorico(null);
				statusEstacaoHistorico.setIdEstacao(idEstacao);
				statusEstacaoHistorico.setDataHoraStatusEstacaoHistorico(date);
				statusEstacaoHistoricoDao.save(statusEstacaoHistorico);
			} else {
				int status = 0;
				if (OnOff.equalsIgnoreCase("offline")) {
					status = 2;
					//System.out.println("STATUS 2");
				} else if (OnOff.equalsIgnoreCase("online")) {
					status = 1;
					//System.out.println("STATUS 1");
				} else {
					status = 3;
					//System.out.println("STATUS 3");
				}
				
				
				/************************************
				 * 
				 * Mudanças depois do Pause e Amplificador
				 * 
				 * ************************************************/
				
				//Setando tudo no StatusEstacao..
				// PEGANDO A CLASSE TODA DOS TOQUES PARA O RELACIONAMENTO
				toqueStatusEstacao = toqueStatusEstacaoDao.findById(tocando);
				modoStatusEstacao = modoStatusEstacaoDao.findById(status);
				statusEstacao.setIdStatusEstacao(idStatusEstacao);
				statusEstacao.setDataHoraStatusEstacao(date);
				// RELACIONAMENTO
				statusEstacao.setPorta(portatxt);
				statusEstacao.setPause(pause);
				statusEstacao.setAmplificador(amplificador);
				statusEstacao.setToquestatusestacao(toqueStatusEstacao);
				statusEstacao.setModostatusestacao(modoStatusEstacao);
				statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
				statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
				// UPDATE NO BANCO STATUSESTACAO
				statusEstacaoDao.update(statusEstacao);
				
				
				
				
				

				if (status == 1) {
					System.out.println("------¬");
					System.out.println("ONLINE");
					System.out.println("------");

					// SALVANDO NO HISTORICO
					statusEstacaoHistorico.setDataHoraStatusEstacaoHistorico(date);
					statusEstacaoHistorico.setIdModoStatusEstacao(1);
					statusEstacaoHistorico.setIdToqueStatusEstacao(tocando);
					statusEstacaoHistorico.setIdEstacao(idEstacao);
					statusEstacaoHistoricoDao.save(statusEstacaoHistorico);

					if (modoInt != status) {
						
						// PEGANDO A CLASSE TODA DOS TOQUES PARA O
						// RELACIONAMENTO
						toqueStatusEstacao = toqueStatusEstacaoDao.findById(tocando);
						modoStatusEstacao = modoStatusEstacaoDao.findById(1);
						statusEstacao.setPorta(portatxt);
						statusEstacao.setPause(pause);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao.setDataHoraStatusEstacao(date);
						// RELACIONAMENTO
						
						statusEstacao.setToquestatusestacao(toqueStatusEstacao);
						statusEstacao.setModostatusestacao(modoStatusEstacao);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						// UPDATE NO BANCO STATUSESTACAO
						
						statusEstacaoDao.update(statusEstacao);
					}

				} else if (status == 2) {

					System.out.println("------¬");
					System.out.println("OFFLINE");
					System.out.println("------");

					// Salvando no historico
					statusEstacaoHistorico.setDataHoraStatusEstacaoHistorico(date);
					statusEstacaoHistorico.setIdModoStatusEstacao(2);
					statusEstacaoHistorico.setIdToqueStatusEstacao(2);
					statusEstacaoHistorico.setIdEstacao(idEstacao);
					statusEstacaoHistoricoDao.save(statusEstacaoHistorico);

					if (toqueInt != 4) {
						// Salvando no historico
						statusEstacaoHistorico.setDataHoraStatusEstacaoHistorico(date);
						statusEstacaoHistorico.setIdModoStatusEstacao(6);
						statusEstacaoHistorico.setIdToqueStatusEstacao(2);
						statusEstacaoHistorico.setIdEstacao(idEstacao);
						statusEstacaoHistoricoDao.save(statusEstacaoHistorico);

						// PEGANDO A CLASSE TODA DOS TOQUES PARA O
						// RELACIONAMENTO
						toqueStatusEstacao = toqueStatusEstacaoDao.findById(6);
						modoStatusEstacao = modoStatusEstacaoDao.findById(2);
						statusEstacao.setPorta(portatxt);
						statusEstacao.setPause(pause);
						statusEstacao.setAmplificador(amplificador);
						statusEstacao.setIdStatusEstacao(idStatusEstacao);
						statusEstacao.setDataHoraStatusEstacao(date);

						// RELACIONAMENTO
						
						statusEstacao.setToquestatusestacao(toqueStatusEstacao);
						statusEstacao.setModostatusestacao(modoStatusEstacao);
						statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
						statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());
						// UPDATE NO BANCO STATUSESTACAO
						
						statusEstacaoDao.update(statusEstacao);

					} else {
						if (modoInt != status) {

							// PEGANDO A CLASSE TODA DOS TOQUES PARA O
							// RELACIONAMENTO
							toqueStatusEstacao = toqueStatusEstacaoDao.findById(tocando);
							modoStatusEstacao = modoStatusEstacaoDao.findById(2);
							statusEstacao.setPorta(portatxt);
							statusEstacao.setPause(pause);
							statusEstacao.setAmplificador(amplificador);
							statusEstacao.setIdStatusEstacao(idStatusEstacao);
							statusEstacao.setDataHoraStatusEstacao(date);

							// RELACIONAMENTO;
							
							statusEstacao.setToquestatusestacao(toqueStatusEstacao);
							statusEstacao.setModostatusestacao(modoStatusEstacao);
							statusEstacao.setContinuoStatusEstacao(statusEstacao.getContinuoStatusEstacao());
							statusEstacao.setDisponibilidadeStatusEstacao(statusEstacao.getDisponibilidadeStatusEstacao());

							// UPDATE NO BANCO STATUSESTACAO
							
							statusEstacaoDao.update(statusEstacao);
						}
					}

				} else {
					System.out.println("ERRO, DEU ALGO INDIFERENTE DE ON E OFF, QUE NÃO É MANUTENÇÃO");
				}

				/***
				 * 
				 * lOGICA DA INDISPONIBILIDADES
				 * 
				 * ***/
				System.out.println("INDISPONIBILIDADE");

				// DISPONIBILIDADE ANUAL
				DisponibilidadeStatusEstacao disp = new DisponibilidadeStatusEstacao();
				DisponibilidadeStatusEstacaoDao dispDao = new DisponibilidadeStatusEstacaoDao();
				// PEGANDO O ID DISPONIBILIDADE, PELA DO STATUS
				Integer idDisp = statusEstacao.getDisponibilidadeStatusEstacao().getIdDisponibilidadeStatusEstacao();
				disp = dispDao.findById(idDisp);

				// Resgatando o ID ESTACAO
				Integer idestacao = statusEstacao.getEstacaose().getIdEstacao();
				Double indisp = dispDao.indisponibilidadeAnualEstacao(idestacao, 2);

				// Setando os valores para o disp
				disp.setIndisponibilidadeAnual(indisp);
				disp.setIdDisponibilidadeStatusEstacao(idDisp);
				disp.setDisponibilidadeAnual(disp.getDisponibilidadeAnual());
				dispDao.update(disp);

				disp = new DisponibilidadeStatusEstacao();
				dispDao = new DisponibilidadeStatusEstacaoDao();

				/***
				 * 
				 * lOGICA DO CONTINUO
				 * 
				 * ***/
				System.out.println("CONTINUO");
				if (status == 2) {

					Integer idConti = contiDao.findByIdEstacao(idEstacao);
					conti = contiDao.findById(idConti);
					//System.out.println("ID CONT OFF : " + idConti);

					statusEstacao = contiDao.lastDateOffStatusEstacao(conti.getIdEstacao());

					Date dataLastStatus = statusEstacao.getDataHoraStatusEstacao();
					long diferencaHora = date.getTime()	- dataLastStatus.getTime();

					Double difHoraContinuo = diferencaHora / 1000.0 / 60.0 / 60.0;
					//System.out.println("Ultima data : " + dataLastStatus);
					//System.out.println("Data agora : " + date);
					//System.out.println("DIFERENCA DO CONT OFF INDIVIDUAL: "
							//+ difHoraContinuo);

					conti.setIdContinuoStatusEstacao(idConti);
					conti.setTotalEstacao(difHoraContinuo);
					conti.setCont(1);
					conti.setModoStatusEstacao(2);
					conti.setDataFinal(date);
					conti.setDataInicio(dataLastStatus);
					conti.setIdEstacao(id);
					contiDao.update(conti);

				} else if (status == 3) {

					Integer idConti = contiDao.findByIdEstacao(idEstacao);
					conti = contiDao.findById(idConti);
					//System.out.println("ID CONT MANU : " + idConti);

					statusEstacao = contiDao.lastDateManuStatusEstacao(conti
							.getIdEstacao());

					Date dataLastStatus = statusEstacao
							.getDataHoraStatusEstacao();
					long diferencaHora = date.getTime()
							- dataLastStatus.getTime();

					Double difHoraContinuo = diferencaHora / 1000.0 / 60.0 / 60.0;
					//System.out.println("Ultima data : " + dataLastStatus);
					//System.out.println("Data agora : " + date);
					//System.out.println("DIFERENCA DO CONT MANU INDIVIDUAL: "
							//+ difHoraContinuo);

					conti.setTotalEstacao(difHoraContinuo);
					conti.setCont(1);
					conti.setModoStatusEstacao(3);
					conti.setDataFinal(date);
					conti.setDataInicio(dataLastStatus);
					conti.setIdContinuoStatusEstacao(idConti);
					conti.setIdEstacao(id);
					contiDao.update(conti);

				} else {

					Integer idConti = contiDao.findByIdEstacao(idEstacao);
					conti = contiDao.findById(idConti);
					//System.out.println("ID CONT ON : " + idConti);

					// SALVANDO NA HISTORICO DO CONTINUO
					contiHistorico.setDataFinalHistorico(conti.getDataFinal());
					contiHistorico
							.setDataInicioHistorico(conti.getDataInicio());
					contiHistorico.setIdEstacao(conti.getIdEstacao());
					contiHistorico.setModoStatusEstacao(conti
							.getModoStatusEstacao());
					contiHistorico.setTotalEstacaoHistorico(conti
							.getTotalEstacao());
					contiHistoricoDao.save(contiHistorico);

					// UPDATE DO ON
					conti.setTotalEstacao(0.0);
					conti.setCont(0);
					conti.setDataFinal(conti.getDataFinal());
					conti.setDataInicio(conti.getDataInicio());
					conti.setIdContinuoStatusEstacao(idConti);
					contiDao.update(conti);
				}

				/***
				 * 
				 * lOGICA DO CONTINUO GLOBAL
				 * 
				 * ***/

				contiGlobal = contiGlobalDao.continuoGlobal();
			
				Date lastDataIndividual = contiDao.lastDateContinuoIndividual();
				Date lastDataGlobal = contiGlobalDao.lastDateContinuoGlobal();
				//System.out.println("ULTIMA DATA INDIVIDUAL:  "
				//		+ lastDataIndividual);
				//System.out.println("ULTIMA DATA GLOBAL:  " + lastDataGlobal);
				if (lastDataGlobal == null) {
					System.out
							.println("ENTRO DO IF DA ULTIMA DATA GLOBAL == NULL");
					contiGlobal.setIdContinuoGlobalStatusEstacao(1);
					contiGlobal.setTotalGlobal(0.0);
					contiGlobal.setDataHoraIncial(lastDataIndividual);
					contiGlobalDao.update(contiGlobal);
				//	System.out.println("DEU UPDATE NA ULTIMA DATA INDIVIDUAL");
				} else {
					if (lastDataIndividual != null) {
						System.out
								.println("ENTRO NO IF DA ULTIMA DATA INDIVIDUAL == NULL");
						long diferencaHora = date.getTime()
								- lastDataGlobal.getTime();
						Double difHoraContinuo = diferencaHora / 1000.0 / 60.0 / 60.0;
					//	System.out.println("DATA AGORA : " + date);
					//	System.out.println("(-)");
					//	System.out.println("DATA ULTIMA DATA GLOBAL:  "	+ lastDataGlobal);
					//	System.out.println("____________________________________________");
					//	System.out.println("DIFERENCA DE DATAS :  "	+ difHoraContinuo);
						contiGlobal.setIdContinuoGlobalStatusEstacao(1);
						contiGlobal.setTotalGlobal(difHoraContinuo);
						contiGlobal.setDataHoraIncial(contiGlobal.getDataHoraIncial());
						contiGlobalDao.update(contiGlobal);
					//	System.out.println("UPDATE -> DIFERENCA NO TOTAL");
					} else {
					//	System.out.println("ULTIMO ELSE");
						contiGlobal.setIdContinuoGlobalStatusEstacao(1);
						contiGlobal.setTotalGlobal(0.0);
						contiGlobal.setDataHoraIncial(null);
						contiGlobalDao.update(contiGlobal);
					//	System.out.println("ZERANDO O TOTAL e DANDO NULL A DATA");
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu blau!");
		} finally {
			statusEstacaoHistorico = new StatusEstacaoHistorico();
			statusEstacao = new StatusEstacao();
			modoStatusEstacao = new ModoStatusEstacao();
			modoStatusEstacaoDao = new ModoStatusEstacaoDao();
			toqueStatusEstacao = new ToqueStatusEstacao();
			toqueStatusEstacaoDao = new ToqueStatusEstacaoDao();
			conti = new ContinuoStatusEstacao();
			contiDao = new ContinuoStatusEstacaoDao();
			contiGlobal = new ContinuoGlobalStatusEstacao();
			contiGlobalDao = new ContinuoGlobalStatusEstacaoDao();
		}

	}

}
