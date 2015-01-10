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
  height: 600px;  
  position: center;  
  top:50%;  
  left:50%;  
   
  margin: 0 auto; 
} 
#conteudo {  

  width: 400px;  
  height: 500px;  
  margin: 0 auto; 
  
}  
  
</style>  

</head>
<body>

<img align="top" src="imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>

<f:view>

<div>
	
	<rich:separator/>
</div>	
<div id="tudo">
	
	<div id="conteudo">
		<rich:panel header="LOGIN NO SISTEMA" >
	
		<a4j:form id="forml">
			<h:panelGrid columns="2" width="100%">
			
				<h:outputText value="Informe o login: " />
				<h:inputText value="#{uBean.usuario.loginUsuario }" />
				
				<h:outputText value="Informe a senha: " />
				<h:inputSecret value="#{uBean.usuario.senhaUsuario }" />
			
			</h:panelGrid>
			<a4j:commandButton reRender="forml" value="Efetuar Login" action="#{uBean.logar }" />
			<h:messages />
			<br />
		</a4j:form>

	</rich:panel>
	
  </div>
  </div>
</f:view>
</body>
</html>