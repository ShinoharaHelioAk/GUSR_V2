<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Sistema de Gerenciamento de Usuários</title>
	</head>
	<body>
		<jsp:include page="cabecalho.jsp" />
		<h3>Perfil do usuário (${usuarioPerfilAtualizado.nome}) atualizado com sucesso!</h3>
		<hr color="#000000" />
		<a href="mvc?logica=DetalharUsuarioLogica&id=${usuarioPerfilAtualizado.id}&acao=visualizarUsuario">
			Voltar para a tela de Detalhe
		</a>
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp" />
		<jsp:include page="rodape.jsp" />
	</body>
</html>