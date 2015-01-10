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
	
	<a4j:form id="forme">
		<rich:panel id="painel">
			
			
			Informe o nome:<h:inputText value="#{eBean.estacao.nomeEstacao }"/> 
			<a4j:commandButton action="#{eBean.consultar }" reRender="forme" value="Buscar"/>
			
			<rich:separator/><br />
			
			<rich:dataTable value="#{eb.listaBuscar}" var="estacao">
				<rich:column >
					<f:facet name="header">
						<h:outputText value="nome"/>
					</f:facet>
					<h:outputText value="#{estacao.nomeEstacao }"/>				
				</rich:column>
				
				<rich:column >
					<f:facet name="header">
						<h:outputText value="grupo"/>
					</f:facet>
					<h:outputText value="#{estacao.grupoestacao.nomeGrupoEstacao }"/>				
				</rich:column>
				
				<rich:column >
					<f:facet name="header">
						<h:outputText value="Tipo"/>
					</f:facet>
					<h:outputText value="#{estacao.tipoestacao.nomeTipoEstacao }"/>				
				</rich:column>
				
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Excluir"/>
					</f:facet>
					<a4j:commandButton value="Excluir" reRender="forme"
					action="#{eBean.excluir}">
					<f:setPropertyActionListener value="#{estacao}" target="#{eBean.estacao}"/>			
					</a4j:commandButton>
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar"/>
					</f:facet>
					<a4j:commandButton value="Editar" reRender="form1"
					action="#{eBean.editar }">
					<f:setPropertyActionListener value="#{estacao}" target="#{eBean.estacao }"/>
					</a4j:commandButton>
				</rich:column>	
				
			</rich:dataTable>
		</rich:panel>
	</a4j:form>
</f:view>
</body>
</html>