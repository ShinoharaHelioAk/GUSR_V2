<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>SGUSR_V2 - Alteração de Dados do Usuário</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<h3>Página de Alteração de Usuários</h3>
		<form action="mvc?logica=AlteraUsuarioLogica&id=${usuarioAlteracao.id}&acao=alterarUsuario">
			<input type="hidden" name="id" value="${usuarioAlteracao.id}" />
			
			Nome: <input required="true" type="text" name="nome" value="${usuarioAlteracao.nome}" /></br>
			
			E-mail: <input type="email" name="email" value="${usuarioAlteracao.email}" /></br>
			
			Data de Nascimento (<fmt:formatDate value="${usuarioAlteracao.dataNascimento.time}" pattern="dd/MM/yyyy" />): 
			
			<input type="date" name="dataNascimento" /> (Selecione uma nova data se for alterar o campo Data de Nascimento)</br>
			
			<input type="submit" value="Gravar">
		</form>
		<c:import url="linksVoltarParaListaEVoltarParaHome.jsp" />
		<c:import url="rodape.jsp" />
	</body>
</html>