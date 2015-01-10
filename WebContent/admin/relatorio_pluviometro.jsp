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
	<td><a4j:include viewId="menu.jsp"/></td> 
	
	<a4j:form id="formcons">
	<rich:panel header="Fazer consulta por datas" style="font-size: 500px;"  >
		<h:panelGrid columns="2">
			<h:outputText value="Nome da Estação"/>
			
			<h:selectOneMenu value="#{pBean.estacao.idEstacao }">
					<f:selectItems value="#{pBean.listarEstacao}"/>
				</h:selectOneMenu>
		
		
			<h:outputText value="Escolha a primeira data"/>
			<rich:calendar value="#{pBean.dataInicio }" datePattern="dd-MM-yyyy"/>
			
			<h:outputText value="Escolha a segunda data"/>
			<rich:calendar value="#{pBean.dataFim }"  datePattern="dd-MM-yyyy"/>
			
			<h:outputText value="Selecione"/>
			<h:selectOneMenu value="#{pBean.opcao }">
					<f:selectItems value="#{pBean.acao }"/>
			</h:selectOneMenu>
			
			<a4j:commandButton  value="Consultar" action="#{pBean.consultar}" reRender="formcons"  id="consultar" >
				<rich:componentControl attachTo="consultar" operation="show" for="painelconsultar" event="onclick"/>
			</a4j:commandButton>
			<h:commandLink action="#{rpBean.relatorio}" value="Gerar Relatório" target="blank" /> 
			<rich:messages for="formcons"/>
			
			
			
			<rich:modalPanel id="painelconsultar" autosized="true" width="500">
				<f:facet name="header">
					<h:outputText value="ATENÇÃO" />
				</f:facet>
					
					<h3>Espere isso deve demorar alguns segundos !</h3>
			</rich:modalPanel>
			
			
			
		</h:panelGrid>
		
		<rich:dataTable value="#{pBean.listaMenu}"  var="p"  id="datatable" reRender="formcons" >
			
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Nome"/>
				</f:facet>
				<h:outputText value="#{p.nome}" />
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Leitura"/>
				</f:facet>
				<h:outputText value="#{p.leitura}" >
				<f:convertNumber minFractionDigits="1"/>
				</h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Data / Hora"/>
				</f:facet>
				<h:outputText value="#{p.dataInicial}">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
				</h:outputText>			
			</rich:column>
			
		</rich:dataTable>
		
		
<%-- 		<rich:datascroller for="datatable" maxPages="20" reRender="formcons"></rich:datascroller> --%>
		</rich:panel>
	</a4j:form>
	<rich:separator/>
</f:view>
</body>
</html>