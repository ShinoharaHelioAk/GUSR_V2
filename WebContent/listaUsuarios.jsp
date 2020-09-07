<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SGUSR_V2 - Lista de Usuários Cadastrados</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Lista de Usuários Cadastrados</h3>
		<table style="width: 100%" border="1">
			<tr bgcolor="lightblue">
				<%-- <th>ID</th> --%>
				<th>Nome</th>
				<th>E-mail</th>
				<%-- <th>Data de Nascimento</th> --%>
				<th>Status</th>
				<%-- <th>Data de Inclusão</th> --%>
				<%-- <th>Última Modificação</th> --%>
				<%-- <th>Descrição da Última Modificação</th> --%>
				<%-- <th>Senha</th> --%>
				<th>Perfil</th>
				<th></th>
				<th></th>
				<th></th>
				<%-- <th></th> --%>
			</tr>
			
			<c:if test="${empty usuarios}">
				<c:redirect url="mvc?logica=ListaUsuariosLogica" />
			</c:if>
			<c:forEach var="usuario" items="${usuarios}" varStatus="contador">
				<tr bgcolor="#${contador.count % 2 == 0 ? 'ACFA58' : 'FFFFFF'}">
					<%-- <td align="center">${usuario.id}</td> --%>
					<td align="center">${usuario.nome}</td>
					<td align="center">
						<!--<c:choose>
							<c:when test="${not empty usuario.email}">
								<a href="mailto:${usuario.email}">${usuario.email}</a>
							</c:when>
							<c:when test="${empty usuario.email}">
								E-mail não informado
							</c:when>
						</c:choose>-->
						${usuario.email}
					</td>
					<%-- <td align="center">
						<fmt:formatDate value="${usuario.dataNascimento.time}" pattern="dd/MM/yyyy" />
					</td> --%>
					<td align="center">${usuario.status}</td>
					<%-- <td align="center">
						<fmt:formatDate value="${usuario.dataInclusao.time}" pattern="dd/MM/yyyy" />
					</td> --%>
					<%-- <td align="center">
						<fmt:formatDate value="${usuario.dataModificacao.time}" pattern="dd/MM/yyyy" />
					</td> --%>
					<%-- <td align="center">${usuario.motivoAlteracao}</td> --%>
					<%-- <td align="center">${usuario.senha}</td> --%>
					<td align="center">${usuario.perfil}</td>
					
					
					<!-- Links para Ativar, Inativar, Bloquear e Alterar Informações -->
					<c:if test="${usuario.status == 'bloqueado'}">
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=ativarUsuario">Ativar Usuário</a>
						</td>
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=inativarUsuario">Inativar Usuário</a>
						</td>
					</c:if>
					<c:if test="${usuario.status == 'ativo'}">
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=bloquearUsuario">Bloquear Usuário</a>
						</td>
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=inativarUsuario">Inativar Usuário</a>
						</td>
					</c:if>
					<c:if test="${usuario.status == 'inativo'}">
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=ativarUsuario">Ativar Usuário</a>
						</td>
						<td align="center">
							<a href="mvc?logica=AlteraUsuarioLogica&id=${usuario.id}&acao=bloquearUsuario">Bloquear Usuário</a>
						</td>
					</c:if>
					<%-- <td align="center">
						<!--<a href="mvc?logica=CarregaUsuarioParaAlteracaoLogica&id=${usuario.id}">Alterar Usuário</a>-->
						<a href="carregaUsuarioParaAlteracao?id=${usuario.id}">Alterar Usuário</a>
					</td> --%>
					<%-- <td align="center">
						<a href="mvc?logica=DetalharUsuarioLogica&id=${usuario.id}&acao=removerUsuario">Remover Usuário</a>
					</td> --%>
					<td align="center">
						<a href="mvc?logica=DetalharUsuarioLogica&id=${usuario.id}&acao=visualizarUsuario">Visualizar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<hr color="#000000" />
		<form action="cadastraUsuarios.jsp">
			<input type="submit" value="Cadastrar Novo Usuário">
			<a href="index.jsp">Voltar para a Home</a>
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>