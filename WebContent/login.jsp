<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>SGUSR_V2 - Sistema de Gerenciamento de Usuários</title>
	</head>
	<body>
		<jsp:include page="cabecalho.jsp" />
		<!--<c:import url="cabecalho.jsp" />-->
		<h4>Faça login para entrar no sistema</h4>
		<div>
			<c:if test="${not empty usrNFnd}">
				<label style="color: red">Usuário não encontrado!</label>
			</c:if>
		</div>
		<form action="validaLogin" method="post">
			<label for="usuario"><b>Usuário: </b></label>
			<input type="text" id="usuario" name="usuario" required="true" />
			<br />
			<label for="senha"><b>Senha: </b></label>
			<input type="password" id="senha" name="senha" required="true" />
			<br />
			<input type="submit" value="Fazer Login" />
		</form>
		
		<!--<c:import url="rodape.jsp" />-->
		<jsp:include page="rodape.jsp" />
	</body>
</html>