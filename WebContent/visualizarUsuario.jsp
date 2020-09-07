<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SGUSR_V2 - Lista de Usu�rios Cadastrados</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>P�gina de Detalhes do Usu�rio</h3>
		
		<label for="id"><b>- ID: </b></label>
		<c:out value="${visualizarUsuario.id}" />
		<br />
		
		<label for="id"><b>- Nome: </b></label>
		<c:out value="${visualizarUsuario.nome}" />
		<br />
		
		<label for="id"><b>- E-mail: </b></label>
		<c:out value="${visualizarUsuario.email}" />
		<br />
		
		<label for="id"><b>- Data de Nascimento: </b></label>
		<fmt:formatDate value="${visualizarUsuario.dataNascimento.time}" pattern="dd/MM/yyyy" />
		<br />
		
		<label for="id"><b>- Status: </b></label>
		<c:out value="${visualizarUsuario.status}" />
		<br />
		
		<label for="id"><b>- Data de Inclus�o: </b></label>
		<fmt:formatDate value="${visualizarUsuario.dataInclusao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
		<br />
		
		<label for="id"><b>- �ltima Modifica��o: </b></label>
		<fmt:formatDate value="${visualizarUsuario.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
		<br />
		
		<label for="id"><b>- Descri��o da �ltima Modifica��o: </b></label>
		<c:out value="${visualizarUsuario.motivoAlteracao}" />
		<br />
		
		<label for="id"><b>- Senha: </b></label>
		<c:out value="${visualizarUsuario.senha}" />
		<br />
		
		<label for="id"><b>- Perfil: </b></label>
		<c:out value="${visualizarUsuario.perfil}" />
		<br />
		
		<hr color="#000000" />
		
		<c:if test="${visualizarUsuario.status == 'bloqueado'}">
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=ativarUsuario">Ativar Usu�rio</a>
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=inativarUsuario">Inativar Usu�rio</a>
		</c:if>
		<c:if test="${visualizarUsuario.status == 'ativo'}">
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=bloquearUsuario">Bloquear Usu�rio</a>
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=inativarUsuario">Inativar Usu�rio</a>
		</c:if>
		<c:if test="${visualizarUsuario.status == 'inativo'}">
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=ativarUsuario">Ativar Usu�rio</a>
			<a href="mvc?logica=AlteraUsuarioLogica&id=${visualizarUsuario.id}&acao=bloquearUsuario">Bloquear Usu�rio</a>
		</c:if>
		<a href="carregaUsuarioParaAlteracao?id=${visualizarUsuario.id}">Alterar Usu�rio</a>
		<br />
		
		<hr color="#000000" />
		
		<a href="carregaUsuarioParaAlteracao?id=${visualizarUsuario.id}&acao=alterarSenhaUsuario">Alterar Senha</a>
		<a href="carregaUsuarioParaAlteracao?id=${visualizarUsuario.id}&acao=alterarPerfilUsuario">Alterar Perfil</a>
		
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>