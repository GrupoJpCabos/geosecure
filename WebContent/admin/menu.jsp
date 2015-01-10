<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j"  uri="http://richfaces.org/a4j"%>






<rich:toolBar width="100%">

	<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
			<h:outputLink value="listar_status.jsf"><font color="white">HOME</font></h:outputLink>
		</f:facet>
	</rich:dropDownMenu>
	
	<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
			<h:outputText  value="CADASTRO"/>
		</f:facet>
		
		<rich:menuItem submitMode="none">
			<h:outputLink value="cadastrar_login.jsf"> Cadastrar Usuário </h:outputLink>
		</rich:menuItem>
		
		<rich:menuItem submitMode="none">
			<h:outputLink value="cadastrar_estacao.jsf"> Cadastrar Estação </h:outputLink>
		</rich:menuItem>
		
		<rich:menuItem submitMode="none">
			<h:outputLink value="cadastrar_grupo.jsf"> Cadastrar Grupo</h:outputLink>
		</rich:menuItem>
		
<%-- 		<rich:menuItem submitMode="none"> --%>
<%-- 			<h:outputLink value="cadastrar_tipo.jsf"> Cadastrar Tipo da Estação</h:outputLink> --%>
<%-- 		</rich:menuItem> --%>
	</rich:dropDownMenu>

	<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
			<h:outputText value="CONSULTAR" />
		</f:facet>
		
		<rich:menuItem>
			<h:outputLink value="listar_estacao.jsf">Consultar Estação</h:outputLink>
		</rich:menuItem>
		
		<rich:menuItem>
			<h:outputLink value="listar_usuario.jsf">Consultar Usuário</h:outputLink>
		</rich:menuItem>
		
<%-- 		<rich:menuItem> --%>
<%-- 			<h:outputLink value="listar_tipo.jsf">Consultar Tipos</h:outputLink> --%>
<%-- 		</rich:menuItem> --%>
		
		<rich:menuItem>
			<h:outputLink value="listar_grupo.jsf">Consultar Grupos</h:outputLink>
		</rich:menuItem>
		
		<rich:menuItem>
			<h:outputLink value="listar_pluviometro.jsf">Consultar Pluviômetros</h:outputLink>
		</rich:menuItem>
		
		
		
		
		<rich:menuItem>
			<h:outputLink value="listar_status.jsf">Consultar Status das Estações</h:outputLink>
		</rich:menuItem>
	</rich:dropDownMenu>
	

	
	
	
	
		<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
			<h:outputText value="RELATÓRIOS" />
		</f:facet>
		
		<rich:menuItem>
			<h:outputLink value="relatorio_pluviometro.jsf">Pluviômetro</h:outputLink>
		</rich:menuItem>

		<rich:menuItem>
			<h:outputLink value="relatorio_usuario.jsf">Acionamento do Usuário</h:outputLink>
		</rich:menuItem>
		
		<rich:menuItem>
			<h:outputLink value="relatorio_disponibilidade.jsf">Disponibilidade</h:outputLink>
		</rich:menuItem>
	</rich:dropDownMenu>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
		<h:form>
			<h:commandLink style="color: white;" value="Sair do Sistema" action="#{admBean.logout }" />
		</h:form>
		</f:facet>
	</rich:dropDownMenu>

	

</rich:toolBar>