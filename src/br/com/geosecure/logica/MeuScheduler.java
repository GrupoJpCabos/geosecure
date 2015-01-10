package br.com.geosecure.logica;

import java.util.Date;  

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  

import org.apache.log4j.Logger;  
import org.quartz.JobDetail;  
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;  
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;  


	public class MeuScheduler implements ServletContextListener {
		 public static Scheduler sched;
		 private Logger log;

		 @SuppressWarnings("static-access")
		 protected void init() throws ObjectAlreadyExistsException {

		  try {
		   /* Fábrica para criar instância de Scheduler */
		   StdSchedulerFactory schedFactory = new StdSchedulerFactory();

		   getLog().info("---------------- Criar Agendador ----------------");
		   MeuScheduler.sched = schedFactory.getScheduler();


		   /* ************************Inicio Job Hora *****************************/
		   getLog().info("---------------- Criando Tarefa: JobHora para ser executada a cada 60 minutos ----------------");
		   JobDetail jobHora = new JobDetail("JobIntegraBysoft",Scheduler.DEFAULT_GROUP, JobHora.class);

		   getLog().info("---------------- Criar Gatilho Job Hora  ----------------");
		   SimpleTrigger sptJobHora = new SimpleTrigger("JobHora", sched.DEFAULT_GROUP, new Date(), null, SimpleTrigger.REPEAT_INDEFINITELY, 180L * 1000L);

		   getLog().info("---------------- Faz o Agendamento de JobHora ----------------");
		    sched.scheduleJob(jobHora, sptJobHora);

		   
		   /* ************************ Fim Job Hora *******************************/


		   /* Iniciar execução do Scheduler */
		   MeuScheduler.sched.start();   


		  } catch (Exception e) {
		   System.out.println("\n\nErro ao tentar iniciar Scheduler .\n\n");
		   e.printStackTrace();
		  }
		 }


		 public void contextInitialized(ServletContextEvent ce) {
		  try{
		   init();
		  }catch (Exception ex) {
		   ex.getStackTrace();
		  }
		 }


		 public void contextDestroyed(ServletContextEvent arg0) {
		  // Finaliza o schedule
		  restart();
		 }


		 public void restart() {
		  try {
			  MeuScheduler.sched.shutdown(true);
		  } catch (Exception ex) {
		   getLog().error("Erro ao tentar reiniciar as tarefas");
		   getLog().error(ex.getMessage(), ex);
		  }
		 }


		 protected Logger getLog() {
		  if (this.log == null) {
		   this.log = Logger.getLogger("AÇÃO : ");
		  }
		  return this.log;
		 }
		 
		}