<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<f:view>


		<img align="top" src="../imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>
		<a4j:include viewId="menu.jsp" />

<a4j:form id="forme">

		<rich:panel id="painel" header="Consultando Estações">
			
			<rich:dataTable id="dt" value="#{eBean.listaEstacao}" var="estacao">
			
				<rich:column sortBy="#{estacao.pluviometroe.idPluviometro}" headerClass="Grupo">
					<f:facet name="header">
						<h:outputText value="Id Pluviômetro" />
					</f:facet>
					<h:outputText value="#{estacao.pluviometroe.idPluviometro }" />
				</rich:column>
			
			
			
				<rich:column sortBy="#{estacao.grupoestacao.nomeGrupoEstacao}" headerClass="Grupo">
					<f:facet name="header">
						<h:outputText value="Grupo" />
					</f:facet>
					<h:outputText value="#{estacao.grupoestacao.nomeGrupoEstacao }" />
				</rich:column>

				<rich:column sortBy="#{estacao.nomeEstacao}">
					<f:facet name="header">
						<h:outputText value="Estação" />
					</f:facet>
					<h:outputText value="#{estacao.nomeEstacao }" />
				</rich:column>



				<rich:column sortBy="#{estacao.tipoestacao.nomeTipoEstacao}">
					<f:facet name="header">
						<h:outputText value="Tipo" />
					</f:facet>
					<h:outputText value="#{estacao.tipoestacao.nomeTipoEstacao }" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Rua" />
					</f:facet>
					<h:outputText value="#{estacao.enderecoestacao.ruaEnderecoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Número" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.numeroEnderecoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Bairro" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.bairroEnderecoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Estado" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.estadoEnderecoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Cidade" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.cidadeEnderecoEstacao}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Latitude" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.latitudeEnderecoEstacao}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Longitude" />
					</f:facet>
					<h:outputText
						value="#{estacao.enderecoestacao.longitudeEnderecoEstacao}" />
				</rich:column>


				<rich:column>

					<f:facet name="header">
						<h:outputText value="DNS" />
					</f:facet>
					<h:outputText value="#{estacao.acessoestacao.dnsAcessoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Porta" />
					</f:facet>
					<h:outputText value="#{estacao.acessoestacao.portaAcessoEstacao}" />
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="Usuário" />
					</f:facet>
					<h:outputText value="#{estacao.acessoestacao.usuarioAcessoEstacao}" />
				</rich:column>

				<rich:column>
					<f:facet name="header">
						<h:outputText value="Senha" />
					</f:facet>
					<h:outputText value="#{estacao.acessoestacao.senhaAcessoEstacao}" />
				</rich:column>


				<rich:column>
					<f:facet name="header">
						<h:outputText value="Excluir" />
					</f:facet>
					<a4j:commandButton value="Excluir" reRender="forme" action="#{eBean.excluir}">
						<f:setPropertyActionListener value="#{estacao}" target="#{eBean.estacao}" />
					</a4j:commandButton>
				</rich:column>


				<rich:column>
					<f:facet name="header">
						<h:outputText value="Editar" />
					</f:facet>
					<a4j:commandButton value="Editar" reRender="forme" action="#{eBean.editar}">
					
					
						<f:setPropertyActionListener value="#{estacao}" target="#{eBean.estacao}" />
						<f:setPropertyActionListener value="#{estacao.acessoestacao}" target="#{eBean.acessoEstacao}" />
						<f:setPropertyActionListener value="#{estacao.enderecoestacao}" target="#{eBean.enderecoEstacao}" />
						<f:setPropertyActionListener value="#{estacao.grupoestacao}" target="#{eBean.grupoEstacao}" />
						<f:setPropertyActionListener value="#{estacao.tipoestacao}" target="#{eBean.tipoEstacao}" />
						<f:setPropertyActionListener value="#{estacao.pluviometroe}" target="#{eBean.pluviometro}" />
						
						
					</a4j:commandButton>
				</rich:column>


			</rich:dataTable>
		</rich:panel>

</a4j:form>

	</f:view>
</body>
</html>