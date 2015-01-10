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
<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-v0.2.js"></script> 
<script type="text/javascript">
    window.onload = function() {
        new dgCidadesEstados( 
            document.getElementById('estado'), 
            document.getElementById('cidade'), 
            true
        );
    }
</script>
</head>
<body>
<f:view>

	<img align="top" src="../imagens/Banner.gif" width="100%" height="100%" alt="GeoSeCuRe"/>
	<td><a4j:include viewId="menu.jsp"/></td>

	<rich:panel header="Cadastrar Estação">
		<a4j:form id="forme">
		
		<h:panelGrid>
		
				<h:outputText id="nome" value="Nome Estação: "  />
				<h:inputText  value="#{eBean.estacao.nomeEstacao }"
				 />
				<rich:message for="nome"/>
								
				<h:outputText id="grupo" value="Grupo"/>
				<h:selectOneMenu value="#{eBean.grupoEstacaoBean.grupoestacao.idGrupoEstacao }">
					<f:selectItems value="#{eBean.grupoEstacaoBean.selectGrupo }"/>
				</h:selectOneMenu>
				<rich:message for="grupo"/>
				<a href="cadastrar_grupo.jsf">Cadastrar Grupo click aqui !</a>
				
				<h:outputText id="tipoestacao" value="Tipo da Estação"/>
				<h:selectOneMenu  value="#{eBean.tipoEstacaoBean.tipoestacao.idTipoEstacao }">
					<f:selectItems value="#{eBean.tipoEstacaoBean.selectTipoEstacao }"/>
				</h:selectOneMenu>
				<rich:message for="tipoestacao"/>
				
				
				<h:outputText id="rua" value="Logradouro"  />
				<h:inputText  value="#{eBean.enderecoEstacao.ruaEnderecoEstacao}"/>
				<rich:message for="rua"/>
				
				<h:outputText id="numero" value="Número: "  />
				<h:inputText  value="#{eBean.enderecoEstacao.numeroEnderecoEstacao}"/>
				<rich:message for="numero"/>
				
				<h:outputText id="bairro" value="Bairro: "  />
				<h:inputText  value="#{eBean.enderecoEstacao.bairroEnderecoEstacao}"/>
				<rich:message for="bairro"/>
				
				<h:outputText id="latitude" value="Latitude: "  />
				<h:inputText  value="#{eBean.enderecoEstacao.latitudeEnderecoEstacao}"
				 />
				<rich:message for="latitude"/>
				
				<h:outputText id="longitude" value="Longitude: "  />
				<h:inputText  value="#{eBean.enderecoEstacao.longitudeEnderecoEstacao}"
				  />
				<rich:message for="longitude"/>								
		
				
				<label>Estado</label>:<select id="estado" name="estado"></select> 
				<label>Cidade</label>:<select id="cidade" name="cidade"></select> 
				
				<h:outputText id="id" value="Informe o id do Pluviômetro"/>
				<h:inputText value="#{eBean.pluviometro.idPluviometro }"
				/>
				<rich:message for="id"/>
				
				<h:outputText id="multiplicador" value="Informe o Multiplicador"/>
				<h:inputText value="#{eBean.pluviometro.multiplicador }"
				/>
				<rich:message for="multiplicador"/>
				
				<h:outputText id="dns" value="DNS da Estação"/>
				<h:inputText  value="#{eBean.acessoEstacao.dnsAcessoEstacao }"
				/>
				<rich:message for="dns"/>
				
				<h:outputText value="Porta da Estação"/> 
				<h:inputText  value="#{eBean.acessoEstacao.portaAcessoEstacao }"
				/>
				<rich:message for="porta"/>
				
				<h:outputText value="Usuário da Estação"/>
				<h:inputText value="#{eBean.acessoEstacao.usuarioAcessoEstacao }"
				/>
				<rich:message for="usuario"/>
				
				<h:outputText value="Senha da Estação"/>
				<h:inputText value="#{eBean.acessoEstacao.senhaAcessoEstacao}"
				/>
				<rich:message for="senha"/>
				
			</h:panelGrid>
			<a4j:commandButton value="Cadastrar" action="#{eBean.cadastrar}" reRender="forme"/>
			<rich:message for="forme"/>
			
		</a4j:form>
	</rich:panel>

</f:view>
</body>
</html>