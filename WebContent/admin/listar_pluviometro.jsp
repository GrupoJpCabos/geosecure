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
	
	<a4j:form id="formulario">
		
				<rich:panel header="Nível crítico - Acima 20mm na última hora">
			<rich:dataTable value="#{eBean.listaAcima20 }" var="Acima20" styleClass="tabela"   headerClass="cabecalho"
			  >
			
				<rich:column style="background-color:red">
			<f:facet name="header">
				<h:outputText value="Nome"/>
			</f:facet>
			<h:outputText value="#{Acima20.nomeEstacao}" style="color: white;">
			
			</h:outputText>
			</rich:column>
						
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="15 Minutos"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo15minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="30 Minutos"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo30minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="45 Minutos"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo45minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo60minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="2 Horas"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo120minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="3 Horas"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo180minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="4 Horas"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo240minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="1 Dia"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo1440minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="2 Dias"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo2880minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="3 Dias"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo4320minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo5760minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="1 Mês"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo43200minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:red">
				<f:facet name="header">
					<h:outputText value="1 Ano"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo525600minutos }" style="color: white;"> 
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			
			<rich:column style="background-color:red">
			<f:facet name="header">
				<h:outputText value="Data"/>
			</f:facet>
			<h:outputText value="#{Acima20.pluviometroe.dataHora }" style="color: white;">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
			</h:outputText>
			</rich:column>
			
			</rich:dataTable>
		</rich:panel>
	
	
<!-- 	------------------------------------------------------------- -->
	
	
		<rich:panel header="Nível atenção - Entre de 10mm e 20mm na última hora" >
			<rich:dataTable value="#{eBean.listaEntre10e20 }" var="entre10e20" styleClass="tabela"   headerClass="cabecalho">
			
				<rich:column style="background-color:yellow">
			<f:facet name="header">
				<h:outputText value="Nome" />
			</f:facet>
			<h:outputText value="#{entre10e20.nomeEstacao}" />
			</rich:column>
						
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="15 Minutos"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo15minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="30 Minutos"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo30minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="45 Minutos"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo45minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo60minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="2 Horas"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo120minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="3 Horas"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo180minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="4 Horas"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo240minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="1 Dia"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo1440minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="2 Dias"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo2880minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="3 Dias"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo4320minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo5760minutos }" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="1 Mês"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo43200minutos }">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:yellow">
				<f:facet name="header">
					<h:outputText value="1 Ano"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo525600minutos }"> 
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			
			<rich:column style="background-color:yellow">
			<f:facet name="header">
				<h:outputText value="Data"/>
			</f:facet>
			<h:outputText value="#{entre10e20.pluviometroe.dataHora }">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
			</h:outputText>
			</rich:column>
			
			</rich:dataTable>
		</rich:panel>
	
	
<!-- 	------------------------------------------------------------- -->
	
	
		<rich:panel header="Nível tolerável - Abaixo de 10mm na última hora">
			<rich:dataTable value="#{eBean.listaAbaixo10 }" var="abaixo10" styleClass="tabela"   headerClass="cabecalho">
			
				<rich:column style="background-color:green">
			<f:facet name="header">
				<h:outputText value="Nome" />
			</f:facet>
			<h:outputText value="#{abaixo10.nomeEstacao}" style="color: white;"/>
			</rich:column>
						
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="15 Minutos" />
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo15minutos }" style="color: white;" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="30 Minutos"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo30minutos }" style="color: white;" >
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="45 Minutos"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo45minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo60minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="2 Horas"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo120minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="3 Horas"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo180minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="4 Horas"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo240minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="1 Dia"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo1440minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="2 Dias"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo2880minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="3 Dias"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo4320minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo5760minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="1 Mês"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo43200minutos }" style="color: white;">
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			<rich:column style="background-color:green">
				<f:facet name="header">
					<h:outputText value="1 Ano" />
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo525600minutos }" style="color: white;"> 
					<f:convertNumber maxFractionDigits="2"/>
				</h:outputText>
			</rich:column>
			
			<rich:column style="background-color:green">
			<f:facet name="header">
				<h:outputText value="Data"/>
			</f:facet>
			<h:outputText value="#{abaixo10.pluviometroe.dataHora }" style="color: white;">
				<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss" />
			</h:outputText>
			</rich:column>
			
			</rich:dataTable>
		</rich:panel>
	</a4j:form>
	
<!-- 	------------------------------------------------------------- -->
	

</f:view>
</body>
</html>