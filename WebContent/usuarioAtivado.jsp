<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>SGUSR_V2 - Usu�rio Ativado com Sucesso!</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Usu�rio Ativado com Sucesso!</h3>
		<table border="1">
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Nome: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.nome}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7"  align="center"><b>E-mail: <b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.email}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Nascimento: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioAtivacao.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Status: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.status}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Inclus�o: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioAtivacao.dataInclusao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>�ltima Modifica��o: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioAtivacao.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Descri��o da �ltima Modifica��o: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.motivoAlteracao}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Senha: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.senha}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Perfil: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioAtivacao.perfil}</td>
			</tr>
		</table>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioAtivacao.id}&acao=visualizarUsuario">
			Ir para a tela de Detalhe
		</a>
		<!--<hr color="#000000" />
		<a href="mvc?logica=ListaUsuariosLogica">Voltar para a Lista de Usu�rios</a>
		<a href="index.html">Voltar para a Home</a>-->
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>