<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>SGUSR_V2 - Sistema de Gerenciamento de Usu�rios</h3>
<c:if test="${not empty usuarioLogado}">
	<b>Usu�rio Logado: </b>${usuarioLogado.nome}
	<a href="validaLogout">Sair</a>
</c:if>
<hr color="#000000" />