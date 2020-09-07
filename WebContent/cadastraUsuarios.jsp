<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SGUSR_V2 - Cadastro de Usuários</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h3>Página de Cadastro de Usuários</h3>
		<form action="mvc?logica=AdicionaUsuarioLogica" method="post">
			Nome: <input required="true" type="text" name="nome" />
			E-mail: <input type="email" name="email" /></br>
			Data de Nascimento: <input type="date" name="dataNascimento" />
			Senha: <input required="true" type="password" name="senha" /></br>
			<label for="perfil">Perfil: </label>
			<select name="perfil" id="perfil">
				<option selected="selected" value="usuario">Usuário</option>
				<option value="administrador">Administrador</option>
			</select> 
			<hr color="#000000" />
			<input type="submit" value="Gravar">
			<a href="index.jsp">Voltar para a Home</a>
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>