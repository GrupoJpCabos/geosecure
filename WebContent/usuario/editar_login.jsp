<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j"  uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<f:view>
		<img align="top" src="../imagens/tag.png" width="100%" height="100%" alt="GeoSeCuRe"/>
		<a4j:include viewId="menu.jsp" />
	<rich:panel header="Cadastrar Login">
		<a4j:form id="forml">
		
		
			<h:panelGrid >
			
				<h:outputText value="Nova Senha"/>
				<h:inputSecret value="#{uBean.usuario.senhaUsuario }"/>	
				
				<h:outputText value="Confirmar a Nova Senha"/>
				<h:inputSecret value="#{uBean.confirmarSenha }"/>
						
			</h:panelGrid>
			
			<a4j:commandButton reRender="forml" action="#{uBean.editarUsuario}" value="Editar Login"/>
			<h:messages/>
			<br />
			<h:outputLink value="listar_status.jsf"> Voltar </h:outputLink>
	
		</a4j:form>
	</rich:panel>
</f:view>
</body>
</html>