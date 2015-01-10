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
	
	
		<rich:panel header="Cadastrar Grupo">
		<a4j:form id="formGE">
			
			<h:panelGrid>
				<h:outputText value="Nome do Grupo"/>
				<h:inputText value="#{geBean.grupoestacao.nomeGrupoEstacao}"/>
			</h:panelGrid>
			
			<a4j:commandButton value="Cadastrar" action="#{geBean.cadastrar}" reRender="formGE"/>
			<rich:message for="formGE"/>
			
			<rich:separator/><rich:separator/><br />
			
			<rich:dataTable value="#{geBean.listaGrupoEstacao }" var="grupo">

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Nome" />
					</f:facet>
					<h:outputText value="#{grupo.nomeGrupoEstacao}" />
				</rich:column>
			
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Excluir" />
					</f:facet>
					<a4j:commandButton value="Excluir" reRender="formGE" action="#{geBean.excluir}">
						<f:setPropertyActionListener value="#{grupo}" target="#{geBean.grupoestacao}" />
					</a4j:commandButton>
				</rich:column>
			
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandButton value="Editar" 
						action="#{geBean.editar}">
						<f:setPropertyActionListener value="#{grupo}" target="#{geBean.grupoestacao }" />
					</a4j:commandButton>
			
				</rich:column>

			</rich:dataTable>
		
			
		</a4j:form>
		<h:outputLink value="painel.jsf"> Voltar </h:outputLink>
	</rich:panel>
</f:view>
</body>
</html>
