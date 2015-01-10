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
	
	<a4j:form id="formRela">
	<rich:panel header="Relatório de Acionamento">
	
	
			
			
			
			<h:panelGrid columns="2">

					<h:outputText value="Escolha a primeira data"/>
					<rich:calendar value="#{ruBean.dataInicio }" datePattern="dd-MM-yyyy"/>
					
					<h:outputText value="Escolha a segunda data"/>
					<rich:calendar value="#{ruBean.dataFim }"  datePattern="dd-MM-yyyy"/>
					<a4j:commandButton id="consultar"  value="Consultar" action="#{ruBean.consultar}" reRender="formRela"  >
							<rich:componentControl attachTo="consultar" operation="show" for="painelconsultar" event="onclick"/>
					</a4j:commandButton>
					<h:commandLink action="#{ruBean.relatorio}" value="Gerar Relatório" target="blank" /> 
			</h:panelGrid>
			
			
			<rich:modalPanel id="painelconsultar" autosized="true" width="500">
				<f:facet name="header">
					<h:outputText value="ATENÇÃO" />
				</f:facet>
							
					<h3>Espere isso deve demorar alguns segundos !</h3>
			</rich:modalPanel>
			
			
			
			
			
		<rich:dataTable id="dt" value="#{ruBean.listaPdf}" var="acao" rows="10" >

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Nome usuário" />
					</f:facet>
					<h:outputText value="#{acao.nome}" />
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Estação" />
					</f:facet>
					<h:outputText value="#{acao.estacao}" />
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Toque" />
					</f:facet>
					<h:outputText value="#{acao.toque}" />
				</rich:column>
				
				<rich:column >
					<f:facet name="header">
						<h:outputText value="Data" />
					</f:facet>
					<h:outputText value="#{acao.data}">
							<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
					</h:outputText>			
				</rich:column>
	
		</rich:dataTable>
		
		<rich:messages/>
	</rich:panel>
</a4j:form>
</f:view>
</body>
</html>