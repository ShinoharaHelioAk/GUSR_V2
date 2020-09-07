<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Sistema de Gerenciamento de Usuários</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		<h3>Usuário (${param.nome}) cadastrado com sucesso!</h3>
		<br />
		<!--<a href="cadastraUsuarios.jsp">Cadastrar Novo Usuário</a>
		<a href="mvc?logica=ListaUsuariosLogica">Listar Usuários</a>
		<a href="index.jsp">Voltar para a Home</a>-->
		<c:import url="linksCadastrarNovoUsuarioEVoltarParaListaEVoltarParaHome.jsp"></c:import>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>