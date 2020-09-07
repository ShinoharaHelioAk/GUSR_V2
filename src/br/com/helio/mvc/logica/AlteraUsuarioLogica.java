package br.com.helio.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.enums.StatusUsuarioEnum;
import br.com.helio.model.Usuario;

public class AlteraUsuarioLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String redirecionamento = null;
		
		Long id = Long.parseLong(request.getParameter("id"));
		String acao = request.getParameter("acao");
		System.out.println("A��o a ser efetivada: " + acao);
		
		System.out.println("Recuperando a conex�o guardada no Request...");
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		Usuario usuario = new Usuario();
		
		System.out.println("Atualizando os dados desse Usu�rio de acordo com a a��o...");
		if (acao.equals("ativarUsuario")) {
			System.out.println("Ativando usu�rio...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.ATIVO.getStatusUsuario(), id);
			
		} else if (acao.equals("bloquearUsuario")) {
			System.out.println("Bloqueando usu�rio...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.BLOQUEADO.getStatusUsuario(), id);
			
		} else if (acao.equals("inativarUsuario")) {
			System.out.println("Inativando usu�rio...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.INATIVO.getStatusUsuario(), id);
			
		} else if (acao.equals("alterarSenhaUsuario")) {
			System.out.println("Altera��o de senha do usu�rio...");
			
			
		} else if (acao.equals("alterarPerfilUsuario")) {
			System.out.println("Altera��o de perfil do usu�rio...");
			
		}
		
		System.out.println("Buscando os dados do Usu�rio pelo ID...");
		usuario = dao.getUserById(id);
		
		if (acao.equals("ativarUsuario")) {
			redirecionamento = "usuarioAtivado.jsp";
			request.setAttribute("usuarioAtivacao", usuario);
			
		} else if (acao.equals("bloquearUsuario")) {
			redirecionamento = "usuarioBloqueado.jsp";
			request.setAttribute("usuarioBloqueio", usuario);
			
		} else if (acao.equals("inativarUsuario")) {
			redirecionamento = "usuarioInativado.jsp";
			request.setAttribute("usuarioInativacao", usuario);
			
		} else if (acao.equals("alterarSenhaUsuario")) {
			request.setAttribute("usuarioAltS", usuario);
			redirecionamento = "senhaAlterada.jsp";
			
		}
		
		System.out.println("Direcionando para a p�gina " + redirecionamento);
		return redirecionamento;
	}

}
