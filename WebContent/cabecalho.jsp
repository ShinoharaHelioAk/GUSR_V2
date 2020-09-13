<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>SGUSR_V2 - Sistema de Gerenciamento de Usuários</h3>
<c:if test="${not empty usuarioLogado}">
	<b>Usuário Logado: </b>${usuarioLogado.nome}
	<a href="validaLogout">Sair</a>
</c:if>
<hr color="#000000" />