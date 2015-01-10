<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j"  uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<rich:panel header="Editar Login">
		<a4j:form id="formu">
		
		
			<h:panelGrid>
			
				<h:outputText id="nome" value="Nome"/>
				<h:inputText value="#{uBean.usuario.nomeUsuario }" disabled="false" />
				
				
				<h:outputText id="login" value="Login"/>
				<h:inputText value="#{uBean.usuario.loginUsuario }"  disabled="false"/>
				<br /><br />
				
				<h:outputText id="nivel" value="Nivel de Acesso"/>
				<h:selectOneMenu value="#{uBean.nivelUsuario.idNivelUsuario }">
					<f:selectItems value="#{uBean.listarNivel }"/>
				</h:selectOneMenu>
				<rich:message for="nivel"/>
<!-- 				<a href="cadastrar_nivel.jsf">Cadastrar Nivel click aqui !</a> -->
				
				
				<h:outputText value="Senha"/>
				<h:inputSecret value="#{uBean.usuario.senhaUsuario }"/>	
				
				<h:outputText value="Confirmar senha"/>
				<h:inputSecret value="#{uBean.confirmarSenha }"/>
						
			</h:panelGrid>
			
			<a4j:commandButton reRender="formu" action="#{uBean.editar2 }" value="Editar Login"/>
			<h:inputHidden value="#{uBean.usuario.idUsuario }"/>
			<h:messages/>
			<br />
			<a href="listar_usuario.jsf">Voltar</a>			
			
		</a4j:form>
	</rich:panel>
</f:view>

	


</body>
</html>