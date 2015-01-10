<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j"  uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<img align="top" src="../imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>
	<a4j:include viewId="menu.jsp"/>
	
	<a4j:form id="formRelatorio">
	
		<rich:panel header="Relatório de Disponibilidades">
			<h:panelGrid>
				<h:outputText value="Escolha os Pluviômetros abaixo:"/>
				<h:selectManyMenu  value="#{rdBean.lista }"  style="width: 300px; height:300px ; ">
					<f:selectItems value="#{rdBean.selectEstacao}"   />
				</h:selectManyMenu>
			</h:panelGrid>
			<a4j:commandButton   id="consultar"  value="Consultar" action="#{rdBean.disponibilidade }" reRender="formRelatorio"   >
							<rich:componentControl attachTo="consultar" operation="show" for="painelconsultar" event="onclick"/>
					</a4j:commandButton>
		
		
			<rich:modalPanel id="painelconsultar" autosized="true" width="500">
				<f:facet name="header">
					<h:outputText value="ATENÇÃO" />
				</f:facet>	
					<h3>Espere isso deve demorar alguns segundos !</h3>
			</rich:modalPanel>
		
		
		
			<rich:messages/>
		
		
		
		
		<rich:separator/>
	<!-- 		  	----------------------------------------------------------------------------------------- -->
		  <h2>Relatório do(s) Pluviômetro(s) </h2>
		  <rich:dataTable value="#{rdBean.listaRelatorio }" var="listao" reRender="formRelatorio">
		  	<rich:column>
		  		<f:facet name="header">
		  			<h:outputText value="Nome"/>
		  		</f:facet>
		  		<h:outputText value="#{listao.nome }"></h:outputText>
		  	</rich:column>		
		  	
		  	<rich:column>
		  		<f:facet name="header">
		  			<h:outputText value="Tempo Mensal Disponivel"/>
		  		</f:facet>
		  		<h:outputText value="#{listao.tempoMensalDisponivel }"></h:outputText>
		  	</rich:column>	
		  	
		  	<rich:column>
		  		<f:facet name="header">
		  			<h:outputText value="Tempo Anual Disponivel"/>
		  		</f:facet>
		  		<h:outputText value="#{listao.tempoAnualDisponivel }"></h:outputText>
		  	</rich:column>	
		  	
		  	<rich:column>
		  		<f:facet name="header">
			  			<h:outputText value="Porcentual de Inatividades">
					<f:convertNumber maxFractionDigits="1" currencySymbol="%" currencyCode="%"/>
					</h:outputText>
			  		</f:facet>
			  		<h:outputText value="#{listao.porcentual }"/>
			  	</rich:column>	
		</rich:dataTable>
		<rich:separator/>
		
<!-- 		  	----------------------------------------------------------------------------------------- -->
		
			<h2>Falhas dos últimos 30 dias </h2>	
			<h:commandLink action="#{rdBean.relatorio30}" value="Gerar Relatório" target=" blank"/> 	
		  <rich:dataTable value="#{rdBean.lista30 }" var="listaFalhas30" reRender="formRelatorio">
		  		<rich:column>
		  		<f:facet name="header">
		  			<h:outputText value="Nome"/>
		  		</f:facet>
		  		<h:outputText value="#{listaFalhas30.disponibilidadeRelatorio.nome }"></h:outputText>
		  	</rich:column>
			  	<rich:column>
			  		<f:facet name="header">
			  			<h:outputText value="Data Inicial"/>
			  		</f:facet>
			  		<h:outputText value="#{listaFalhas30.dataInicio30 }">
			  		<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
			  		</h:outputText>
			  	</rich:column>	
			  	<rich:column>
			  		<f:facet name="header">
			  			<h:outputText value="Data Final"/>
			  		</f:facet>
			  		<h:outputText value="#{listaFalhas30.dataFim30 }">
			  		<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
			  		</h:outputText>
			  	</rich:column>	
			  	<rich:column>
			  		<f:facet name="header">
			  			<h:outputText value="Modo Status"/>
			  		</f:facet>
			  		<h:outputText value="#{listaFalhas30.modo30 }"/>
			  	</rich:column>	
			  	
			  	<rich:column>
			  		<f:facet name="header">
			  			<h:outputText value="Total"/>
			  		</f:facet>
			  		<h:outputText value="#{listaFalhas30.total30 }"/>
			  	</rich:column>	
		  
		  
		  </rich:dataTable>
		  <rich:separator/>
		 
		  
<!-- 		  -------------------------------------------------------------------------- -->		


  			<h2>Falhas dos últimos 365 dias </h2>
  			<h:commandLink action="#{rdBean.relatorio365}" value="Gerar Relatório" target=" blank"/> 
		  <rich:dataTable value="#{rdBean.lista365 }" var="listaFalhas365" reRender="formRelatorio">
				 
				 
				 <rich:column>
			  		<f:facet name="header">
			  			<h:outputText value="Nome"/>
			  		</f:facet>
			  		<h:outputText value="#{listaFalhas365.disponibilidadeRelatorio2.nome }"></h:outputText>
			  	</rich:column>
				 
				 
				  <rich:column>
				  		<f:facet name="header">
				  			<h:outputText value="Data Inicial"/>
				  		</f:facet>
				  		<h:outputText value="#{listaFalhas365.dataInicio365 }">
			  		<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
			  		</h:outputText>
				  	</rich:column>	
				  	<rich:column>
				  		<f:facet name="header">
				  			<h:outputText value="Data Final"/>
				  		</f:facet>
				  		<h:outputText value="#{listaFalhas365.dataFim365 }">
			  		<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
			  		</h:outputText>
				  	</rich:column>	
				  	<rich:column>
				  		<f:facet name="header">
				  			<h:outputText value="Modo Status"/>
				  		</f:facet>
				  		<h:outputText value="#{listaFalhas365.modo365 }"/>
				  	</rich:column>	
				  	
				  	<rich:column>
				  		<f:facet name="header">
				  			<h:outputText value="Total"/>
				  		</f:facet>
				  		<h:outputText value="#{listaFalhas365.total365 }"/>
				  	</rich:column>	
		  </rich:dataTable>
<!-- 		  -------------------------------------------------------------------------- -->	  
		  
		  
		  		
		</rich:panel>
	</a4j:form>
	
	
</f:view>
</body>
</html>