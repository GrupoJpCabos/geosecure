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
	
	
	<rich:panel header="Editar Tipo">
		<a4j:form id="formte">
		
			<h:panelGrid>
				<h:outputText value="Nome do Tipo da Estacao: "/>
				<h:inputText value="#{teBean.tipoestacao.nomeTipoEstacao}"/>
			</h:panelGrid>
			
			<a4j:commandButton value="Editar" action="#{teBean.editar2}" />
			<h:inputHidden value="#{teBean.tipoestacao.idTipoEstacao}"/>
			<rich:messages for="formte"/>			
		</a4j:form>
		<a href="listar_tipo.jsf">Voltar</a>
	</rich:panel>

</f:view>
</body>
</html>