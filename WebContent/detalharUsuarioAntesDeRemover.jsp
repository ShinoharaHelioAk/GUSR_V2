<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>SGUSR_V2 - Usuário Ativado com Sucesso!</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Confirmação de Exclusão de Usuário</h3>
		<table border="1">
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Nome: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioRemocao.nome}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7"  align="center"><b>E-mail: <b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioRemocao.email}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Nascimento: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioRemocao.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Status: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioRemocao.status}</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Data de Inclusão: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioRemocao.dataInclusao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Última Modificação: </b></td>
				<td bgcolor="EBEFEF" align="center">
					<fmt:formatDate value="${usuarioRemocao.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#DAF9F7" align="center"><b>Descrição da Última Modificação: </b></td>
				<td bgcolor="EBEFEF" align="center">${usuarioRemocao.motivoAlteracao}</td>
			</tr>
		</table>
		
		<br />
		<br />
		<p>Deseja excluir esse usuário?</p>
		<a href="mvc?logica=RemoveUsuarioLogica&id=${usuarioRemocao.id}">Sim</a>
		<br />
		<br />
		
		<!--<hr color="#000000" />
		<a href="mvc?logica=ListaUsuariosLogica">Voltar para a Lista de Usuários</a>
		<a href="index.html">Voltar para a Home</a>-->
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>