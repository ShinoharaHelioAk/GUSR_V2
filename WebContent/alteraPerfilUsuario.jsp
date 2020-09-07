<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Altera��o de Dados do Usu�rio</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>P�gina de Altera��o de Perfil do Usu�rio</h3>
		<form action="alteraPerfilUsuario" method="post">
			<input type="hidden" name="id" value="${usuarioAlteraPerfil.id}" />
			<label for="perfil">Selecione um Perfil: </label>
			<select name="perfil" id="perfil">
				<c:if test="${usuarioAlteraPerfil.perfil eq 'usuario'}">
					<option selected="selected" value="usuario">Usu�rio</option>
					<option value="administrador">Administrador</option>
				</c:if>
				<c:if test="${usuarioAlteraPerfil.perfil eq 'administrador'}">
					<option value="usuario">Usu�rio</option>
					<option selected="selected" value="administrador">Administrador</option>
				</c:if>
			</select>
			<br />
			<input type="submit" value="Gravar">
		</form>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioAlteraPerfil.id}&acao=visualizarUsuario">
			Voltar para a tela de Detalhe
		</a>
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>