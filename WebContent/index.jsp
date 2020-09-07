<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SGUSR_V2 - Sistema de Gerenciamento de Usu�rios</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h3>Bem-vindo ao Sistema</h3>
		<hr color="#000000" />
		<!-- <a href="cadastraUsuarios.html">Clique aqui para cadastrar usu�rios.</a> -->
		<form action="cadastraUsuarios.jsp">
			<input type="submit" value="Cadastrar Usu�rio">
			<a href="mvc?logica=ListaUsuariosLogica">Listar Usu�rios</a>
		</form>
		
		
		<!--<form action="listaUsuario.jsp">
			<input type="submit" value="Listar Usu�rios">
		</form>-->
		
		<c:import url="rodape.jsp"/>
	</body>
</html>