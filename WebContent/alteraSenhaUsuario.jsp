<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Altera��o de Dados do Usu�rio</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>P�gina de Altera��o de Senha do Usu�rio</h3>
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