<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich"  uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j"  uri="http://richfaces.org/a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="30">
<title>Insert title here</title>
<style type="text/css">
.a{
width: ;
height: ;
z-index: ;
position: absolute;
}

#tudo{
width: 1500px;

}

</style>

</head>
<body>
<f:view>

	
	<img align="top" src="../imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>
	<div id="tudo">
	<a4j:include viewId="menu.jsp" />
	</div>
	<a4j:form id="formula">
				<rich:panel header="Acionamento"
		style=" 
		width: 400px;
		margin-left: 14.7cm;
		margin-top: 0 auto;
		z-index: 5;
		position: absolute;
		">	
			<h:panelGrid columns="2">
				
				<h:selectManyMenu  value="#{acBean.lista }" style="width: 300px; height:300px ; ">
					<f:selectItems value="#{acBean.listaSelect}"   />
				</h:selectManyMenu>
				
			</h:panelGrid>
			<rich:separator/>
		
			
				<a4j:commandButton id="mobilizar" value="Mobilizar">
					<rich:componentControl attachTo="mobilizar" operation="show" for="buttonmobilizar" event="onclick"/>	
				</a4j:commandButton>
				
				
				<a4j:commandButton id="desmobilizar" value="Desmobilizar">
					<rich:componentControl attachTo="desmobilizar" operation="show" for="buttondesmobilizar" event="onclick"/>
				</a4j:commandButton>
				
				
				<a4j:commandButton id="testar" value="Testar">
					<rich:componentControl attachTo="testar" operation="show" for="buttontestar" event="onclick"/>
				</a4j:commandButton>
			
			
				<a4j:commandButton id="avisarteste" value="Avisar o Teste">
					<rich:componentControl attachTo="avisarteste" operation="show" for="buttonavisarteste" event="onclick"/>
				</a4j:commandButton>
				
				<a4j:commandButton id="desligar" value="Desligar">
					<rich:componentControl attachTo="desligar" operation="show" for="buttondesligar" event="onclick"/>
				</a4j:commandButton>
				
				<a4j:commandButton id="manutencao" value="Por em Manutenção">
					<rich:componentControl attachTo="manutencao" operation="show" for="buttonmanutencao" event="onclick"/>
				</a4j:commandButton>
				
				
				<a4j:commandButton id="desmanutencao" value="Tirar de Manutenção">
					<rich:componentControl attachTo="desmanutencao" operation="show" for="buttondesmanutencao" event="onclick"/>
				</a4j:commandButton>
	
		
	
	<rich:modalPanel id="buttonmobilizar" autosized="true" width="350">
		<f:facet name="header">
			<h:outputText value="ATENÇÃO" />
		</f:facet>
		
		<f:facet name="controls">
			<a4j:commandLink id="fecharmobilizar" value=" X ">
			<rich:componentControl attachTo="fecharmobilizar" operation="hide" for="painelcadastro" event="onclick"/>
			</a4j:commandLink>
		</f:facet>
					
				<h:outputText value="Você deseja MOBILIZAR essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton  value="Aceitar" action="#{acBean.mobilizar }" reRender="formula" id="consultar">
					<rich:componentControl attachTo="consultar" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
		
	</rich:modalPanel>
	
	
	<rich:modalPanel id="buttondesmobilizar" autosized="true" width="350">
		<f:facet name="header">
			<h:outputText value="ATENÇÃO" />
		</f:facet>
		
		<f:facet name="controls">
			<a4j:commandLink id="fechardesmobilizar" value=" X ">
			<rich:componentControl attachTo="fechardesmobilizar" operation="hide" for="buttondesmobilizar" event="onclick"/>
			</a4j:commandLink>
		</f:facet>
					
				<h:outputText value="Você deseja DESMOBILIZAR essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton value="Aceitar" action="#{acBean.desmobilizar }" reRender="formula" id="consultardes">
					<rich:componentControl attachTo="consultardes" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
		
	<rich:modalPanel id="buttontestar" autosized="true" width="350">
			<f:facet name="header">
				<h:outputText value="ATENÇÃO" />
			</f:facet>
			
			<f:facet name="controls">
				<a4j:commandLink id="fechartestar" value=" X ">
				<rich:componentControl attachTo="fechartestar" operation="hide" for="buttontestar" event="onclick"/>
				</a4j:commandLink>
			</f:facet>
					
				<h:outputText value="Você deseja TESTAR essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton value="Aceitar" action="#{acBean.testar }" reRender="formula" id="consultarteste">
					<rich:componentControl attachTo="consultarteste" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
	<rich:modalPanel id="buttonavisarteste" autosized="true" width="350">
			<f:facet name="header">
				<h:outputText value="ATENÇÃO" />
			</f:facet>
			
			<f:facet name="controls">
				<a4j:commandLink id="fecharavisarteste" value=" X ">
				<rich:componentControl attachTo="fecharavisarteste" operation="hide" for="buttonavisarteste" event="onclick"/>
				</a4j:commandLink>
			</f:facet>
					
				<h:outputText value="Você deseja AVISAR TESTAR essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton  id="consultaravisarteste"  value="Aceitar" action="#{acBean.avisoTeste }" reRender="formula" >
					<rich:componentControl attachTo="consultaravisarteste" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
	
	<rich:modalPanel id="buttondesligar" autosized="true" width="350">
			<f:facet name="header">
				<h:outputText value="ATENÇÃO" />
			</f:facet>
			
			<f:facet name="controls">
				<a4j:commandLink id="fechardesligar" value=" X ">
				<rich:componentControl attachTo="fechardesligar" operation="hide" for="buttondesligar" event="onclick"/>
				</a4j:commandLink>
			</f:facet>
					
				<h:outputText value="Você deseja DESLIGAR essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton value="Aceitar" action="#{acBean.desligar }" reRender="formula"  id="consultardesligar">
					<rich:componentControl attachTo="consultardesligar" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
	
	<rich:modalPanel id="buttonmanutencao" autosized="true" width="350">
			<f:facet name="header">
				<h:outputText value="ATENÇÃO" />
			</f:facet>
			
			<f:facet name="controls">
				<a4j:commandLink id="fecharmanutencao" value=" X ">
				<rich:componentControl attachTo="fecharmanutencao" operation="hide" for="buttonmanutencao" event="onclick"/>
				</a4j:commandLink>
			</f:facet>
					
				<h:outputText value="Você deseja COLOCAR EM MANUTENÇÃO essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton value="Aceitar" action="#{acBean.manutencao }" reRender="formula" id="consultarmanutencao">
					<rich:componentControl attachTo="consultarmanutencao" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
	<rich:modalPanel id="buttondesmanutencao" autosized="true" width="350">
			<f:facet name="header">
				<h:outputText value="ATENÇÃO" />
			</f:facet>
			
			<f:facet name="controls">
				<a4j:commandLink id="fechardesmanutencao" value=" X ">
				<rich:componentControl attachTo="fechardesmanutencao" operation="hide" for="buttondesmanutencao" event="onclick"/>
				</a4j:commandLink>
			</f:facet>
					
				<h:outputText value="Você deseja RETIRAR DE MANUTENÇÃO essa(s) estação(ões) ?"/><br /><br />
				<a4j:commandButton value="Aceitar" action="#{acBean.retirarManutencao }" reRender="formula"  id="consultardesmanutencao">
					<rich:componentControl attachTo="consultardesmanutencao" operation="show" for="painelloading" event="onclick"/>
				</a4j:commandButton>
				<a4j:commandButton value="Cancelar" action="#{acBean.cancelar}" reRender="formula"/>
	</rich:modalPanel>
	
		
		
		
		
			<rich:modalPanel id="painelloading" autosized="true" width="500">
				<f:facet name="header">
					<h:outputText value="ATENÇÃO" />
				</f:facet>
					
					<h3>Espere isso deve demorar alguns segundos !</h3>
			</rich:modalPanel>
		
		
			
			
<%-- 			<a4j:commandButton value="Desmobilizar" action="#{acBean.desmobilizar }" reRender="formula"/> --%>
<%-- 			<a4j:commandButton value="Testar" action="#{acBean.testar }" reRender="formula"/> --%>
<%-- 			<a4j:commandButton value="Avisar Teste" action="#{acBean.avisoTeste }" reRender="formula"/> --%>
<%-- 			<a4j:commandButton value="Desligar" action="#{acBean.desligar }" reRender="formula"/> --%>
<%-- 			<a4j:commandButton value="Por em Manutenção" action="#{acBean.manutencao }" reRender="formula"/> --%>
<%-- 			<a4j:commandButton value="Tirar de Manutenção" action="#{acBean.retirarManutencao }" reRender="formula"/> --%>
			<rich:messages/>
			<rich:separator/>
			
			<rich:dataTable value="#{acBean.listaToques}" var="tocando" reRender="formula"> 
			
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Estação"/>
					</f:facet>
					<h:outputText value="#{tocando.nomeEstacao}"/>
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Toque"/>
					</f:facet>
					<h:outputText value="#{tocando.statusestacao.toquestatusestacao.tipoToqueStatusEstacao}"/>
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Pause"/>
					</f:facet>
					<h:outputText value="#{tocando.statusestacao.pause}"/>
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Amplificador"/>
					</f:facet>
					<h:outputText value="#{tocando.statusestacao.amplificador}"/>
				</rich:column>
				
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Porta do Gabinete"/>
					</f:facet>
					<h:outputText value="#{tocando.statusestacao.porta}"/> 
				</rich:column>

			</rich:dataTable>
			
		</rich:panel>
		

<!-- 		--------------------------------------------------------------------------------------------- -->
	



			<rich:panel header="Status Pluviometricos"
			style=" 
					width: 400px ;
					margin-left: 25.5cm;
					margin-top: 0auto;
					z-index: 6;
					position: absolute;
				"
			
			>
			<h3><font color="blue">Nível crítico - Acima 20mm na última hora</font></h3>
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
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo60minutos }" style="color: white;">
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
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{Acima20.pluviometroe.tempo5760minutos }" style="color: white;">
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
			
			
			<h3><font color="blue">Nível de atenção - Entre 10mm e 20mm na última hora</font></h3>
			
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
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo60minutos }" >
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
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{entre10e20.pluviometroe.tempo5760minutos }" >
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
			
			<h3><font color="blue">Nível tolerável - Abaixo 10mm na última hora</font></h3>
			
				<rich:dataTable value="#{eBean.listaAbaixo10 }" var="abaixo10" styleClass="tabela" headerClass="cabecalho">
			
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
					<h:outputText value="1 Hora"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo60minutos }" style="color: white;">
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
					<h:outputText value="4 Dias"/>
				</f:facet>
				<h:outputText value="#{abaixo10.pluviometroe.tempo5760minutos }" style="color: white;">
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
<!-- 	----------------------------------------------------------------------------------------------------------- -->

		<rich:panel header="Status das Estações"
		style=" 
		width: 550px ;
		z-index: 1;
		
		">	
		
			<font color="red" size="5px">Off-lines</font>
			<rich:dataTable value="#{seBean.listaStatusOff }" var="status" reRender="formula">
			
				<rich:column   style="background-color:red">
					<f:facet name="header">
						<h:outputText value="Nome"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.estacaose.nomeEstacao }"  />
				</rich:column>
				
				<rich:column  style="background-color:red">
					<f:facet name="header">
						<h:outputText value="Data"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.dataHoraStatusEstacao}">
					<f:convertDateTime  pattern="dd/MM/yyyy HH:mm:ss"/>
					</h:outputText>
				</rich:column>
				
				<rich:column  style="background-color:red">
					<f:facet name="header">
						<h:outputText value="Status"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.modostatusestacao.modoStatusEstacao }"/>
				</rich:column>
				
				<rich:column style="background-color:red">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Anual"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.disponibilidadeStatusEstacao.indisponibilidadeAnual }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
				
				<rich:column style="background-color:red">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Contínua"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.continuoStatusEstacao.totalEstacao }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
			</rich:dataTable>
			<rich:separator/>
			
			<br /><br />
			
			<font color="gray" size="5px">Manutenções</font>
			<rich:dataTable value="#{seBean.listaStatusManuntencao }" var="manuntencao" reRender="formula">
			
				<rich:column   style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Nome"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{manuntencao.estacaose.nomeEstacao }"  />
				</rich:column>
				
				<rich:column  style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Data"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{manuntencao.dataHoraStatusEstacao}">
					<f:convertDateTime  pattern="dd/MM/yyyy HH:mm:ss"/>
					</h:outputText>
				</rich:column>
				
				<rich:column  style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Status"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{manuntencao.modostatusestacao.modoStatusEstacao }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>

				<rich:column style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Anual"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{manuntencao.disponibilidadeStatusEstacao.indisponibilidadeAnual }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
				
				<rich:column style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Contínua"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{status.continuoStatusEstacao.totalEstacao }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
			</rich:dataTable>
			<rich:separator/>
			
			<br /><br />
			
			
			<font color="green" size="5px">On-lines </font>
			<rich:dataTable value="#{seBean.listaStatusOn }" var="statusOn" reRender="formula">
			
				<rich:column  style="background-color:green">
					<f:facet name="header">
						<h:outputText value="Nome"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{statusOn.estacaose.nomeEstacao}"/>
				</rich:column>
				
				<rich:column style="background-color:green">
					<f:facet name="header">
						<h:outputText value="Data"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{statusOn.dataHoraStatusEstacao}">
					<f:convertDateTime  pattern="dd/MM/yyyy HH:mm:ss"/>
					</h:outputText>
				</rich:column>
				
				<rich:column style="background-color:green">
					<f:facet name="header">
						<h:outputText value="Status" style="color: write;"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{statusOn.modostatusestacao.modoStatusEstacao }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>

				<rich:column style="background-color:green">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Anual" style="color: write;"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{statusOn.disponibilidadeStatusEstacao.indisponibilidadeAnual }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
				
				<rich:column style="background-color:green">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Contínua"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{statusOn.continuoStatusEstacao.totalEstacao }">
						<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
			</rich:dataTable>
			
			<br /><br />
			
			<font color="black" size="5px">Outras Informações </font>
			<rich:dataTable value="#{seBean.listaInfomarcoes }" var="informacao" reRender="formula"> 
			
				<rich:column  style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Último Check"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{informacao.ultimoCheck}">
					<f:convertDateTime pattern="dd/MM/yyyy HH:mm:ss"/>
					</h:outputText>
				</rich:column>
				
				
				<rich:column  style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Indisponibilidade Global"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{informacao.totalIndisponibilidadeAnual}">
					</h:outputText>
				</rich:column>
				
				<rich:column  style="background-color:gray">
					<f:facet name="header">
						<h:outputText value="Continuidade Global"/>
					</f:facet>
					<h:outputText style="color: white;" value="#{informacao.totalContinuo}">
					<f:convertNumber maxFractionDigits="2"/>
					</h:outputText>
				</rich:column>
			</rich:dataTable>
			

	</rich:panel>


		
<!-- 		----------------------------------------------------------------------------------------------------- -->


		
	
		
	
	</a4j:form>
</f:view>
</body>
</html>