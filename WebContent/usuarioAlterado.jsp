<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>SGUSR_V2 - Sistema de Gerenciamento de Usu�rios</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Dados do Usu�rio alterados com sucesso!</h3>
			<table border="1">
				<tr>
					<td bgcolor="#DAF9F7" align="center">Nome: </td>
					<td bgcolor="EBEFEF" align="center">${usuarioAlteracao.nome}</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">E-mail: </td>
					<td bgcolor="EBEFEF" align="center">${usuarioAlteracao.email}</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">Data de Nascimento: </td>
					<td bgcolor="EBEFEF" align="center">
						<fmt:formatDate value="${usuarioAlteracao.dataNascimento.time}" pattern="dd/MM/yyyy" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">Status: </td>
					<td bgcolor="EBEFEF" align="center">${usuarioAlteracao.status}</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">Data de Inclus�o: </td>
					<td bgcolor="EBEFEF" align="center">
						<fmt:formatDate value="${usuarioAlteracao.dataInclusao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">�ltima Modifica��o: </td>
					<td bgcolor="EBEFEF" align="center">
						<fmt:formatDate value="${usuarioAlteracao.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#DAF9F7" align="center">Descri��o da �ltima Modifica��o: </td>
					<td bgcolor="EBEFEF" align="center">${usuarioAlteracao.motivoAlteracao}</td>
				</tr>
		</table>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioAlteracao.id}&acao=visualizarUsuario">
			Ir para a tela de Detalhe
		</a>
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>