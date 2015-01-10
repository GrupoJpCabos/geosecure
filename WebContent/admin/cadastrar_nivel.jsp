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
	<rich:panel header="Cadastrar Login">
		<a4j:form id="forml">
		
		
			<h:panelGrid>
				<h:outputText value="Nome do Nivel"/>
				<h:inputText value="#{nvBean.nivelUsuario.nivel}"/>						
			</h:panelGrid>
			
			<a4j:commandButton reRender="forml" action="#{nvBean.cadastrar }" value="Cadastrar Login"/>
			<h:messages/>
			<br />
			<a href="cadastrar_login.jsf">Voltar</a>
	
		</a4j:form>
	</rich:panel>
</f:view>
</body>
</html>