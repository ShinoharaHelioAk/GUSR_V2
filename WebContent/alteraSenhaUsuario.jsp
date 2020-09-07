<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Alteração de Dados do Usuário</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Página de Alteração de Senha do Usuário</h3>
		<div>
			<c:if test="${not empty erroSenhaAtual}">
				<label style="color: red">${erroSenhaAtual}</label>
			</c:if>
		</div>
		<form action="alteraSenhaUsuario" method="post">
			<input type="hidden" name="id" value="${usuarioAlteraSenha.id}" />
			
			Digite a senha atual: <input required="true" type="password" name="senhaAtual" /></br>
			
			Digite a nova senha: <input required="true" type="password" name="senhaNova" /></br>
			
			<input type="submit" value="Gravar">
		</form>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioAlteraSenha.id}&acao=visualizarUsuario">
			Voltar para a tela de Detalhe
		</a>
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>