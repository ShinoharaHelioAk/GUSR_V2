<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>SGUSR_V2 - Usuário Inativado com Sucesso!</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Usuário Inativado com Sucesso!</h3>
		<table border="1">
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Nome: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.nome}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7"  align="center"><b>E-mail: <b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.email}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Nascimento: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioInativacao.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Status: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.status}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Inclusão: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioInativacao.dataInclusao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Última Modificação: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioInativacao.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Descrição da Última Modificação: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.motivoAlteracao}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Senha: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.senha}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Perfil: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioInativacao.perfil}</td>
			</tr>
		</table>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioInativacao.id}&acao=visualizarUsuario">
			Ir para a tela de Detalhe
		</a>
		<!--<hr color="#000000" />
		<a href="mvc?logica=ListaUsuariosLogica">Voltar para a Lista de Usuários</a>
		<a href="index.html">Voltar para a Home</a>-->
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>