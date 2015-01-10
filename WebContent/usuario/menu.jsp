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
		<h:form>
			<h:commandLink style="color: white;" value="Alterar Senha" action="#{uBean.editarUsuario1 }" />
		</h:form>
		</f:facet>
	</rich:dropDownMenu>

		

	<rich:dropDownMenu submitMode="none">
		<f:facet name="label">
			<h:outputText value="CONSULTAR" />
		</f:facet>
		
		<rich:menuItem>
			<h:outputLink value="listar_pluviometro.jsf">Consultar Pluviômetros</h:outputLink>
		</rich:menuItem>
		

		<rich:menuItem>
			<h:outputLink value="listar_status.jsf">Consultar Status das Estações</h:outputLink>
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