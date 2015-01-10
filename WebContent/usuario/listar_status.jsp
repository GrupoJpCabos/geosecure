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
#tudo{
width: 1500px;
}

</style>

</head>
<body>
<f:view>

	
	<img align="top" src="../imagens/tag.png" width="100%" height="100%" alt="GeoSeCuRe"/>
	<a4j:include viewId="menu.jsp" />
	
	
<a4j:form id="formula">
		<rich:panel header="Status das Estações">	
		
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
	
	
	
<!-- 	------------------------------------------------------------- -->

		
	
		
	
	</a4j:form>
</f:view>
</body>
</html>