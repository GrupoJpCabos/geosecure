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
<style type="text/css">  
#tudo {  
  width: 788px;  
  height: 0 auto;  
  position: center;  
  top:50%;  
  left:50%;  
   
  margin: 0 auto; 
} 
#separation {  
  width: 788px;  
  height: 0 auto;  
  position: center;  
  top:50%;  
  left:50%;  
   
  margin: 0 auto; 
} 
#conteudo {  

  width: 400px;  
  height: 500px;  
  margin-left: 269px;
  margin-top: 1px;
  top:50%;  
  left:50%;
  
}  
  
</style>  
</head>
<body>
<f:view>

		<img align="top" src="../imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>
		<a4j:include viewId="menu.jsp" />

<div id="separation">
<rich:separator></rich:separator>
</div>
<div id="conteudo">	
	<rich:panel header="Cadastrar Login">
		<a4j:form id="forml">
		
		
			<h:panelGrid>
			
				<h:outputText value="Nome"/>
				<h:inputText value="#{uBean.usuario.nomeUsuario }"/>
				
				<h:outputText value="Login"/>
				<h:inputText value="#{uBean.usuario.loginUsuario }"/>
				
				<h:outputText id="nivel" value="Nível de Acesso"/>
				<h:selectOneMenu value="#{uBean.nivelUsuario.idNivelUsuario }">
					<f:selectItems value="#{uBean.listarNivel }"/>
				</h:selectOneMenu>
				<rich:message for="nivel"/>
<!-- 				<a href="cadastrar_nivel.jsf">Cadastrar Nível click aqui !</a> -->
				
				<h:outputText value="Senha"/>
				<h:inputSecret value="#{uBean.usuario.senhaUsuario }"/>	
				
				<h:outputText value="Confirmar senha"/>
				<h:inputSecret value="#{uBean.confirmarSenha }"/>
						
			</h:panelGrid>
			
			<a4j:commandButton reRender="forml" action="#{uBean.cadastrar }" value="Cadastrar Login"/>
			<h:messages/>
			<br />
			<h:outputLink value="listar_status.jsf"> Voltar </h:outputLink>
	
		</a4j:form>
	</rich:panel>
</div>
</f:view>
</body>
</html>