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
		System.out.println("Ação a ser efetivada: " + acao);
		
		System.out.println("Recuperando a conexão guardada no Request...");
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		Usuario usuario = new Usuario();
		
		System.out.println("Atualizando os dados desse Usuário de acordo com a ação...");
		if (acao.equals("ativarUsuario")) {
			System.out.println("Ativando usuário...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.ATIVO.getStatusUsuario(), id);
			
		} else if (acao.equals("bloquearUsuario")) {
			System.out.println("Bloqueando usuário...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.BLOQUEADO.getStatusUsuario(), id);
			
		} else if (acao.equals("inativarUsuario")) {
			System.out.println("Inativando usuário...");
			dao.alteraStatusUsuario(StatusUsuarioEnum.INATIVO.getStatusUsuario(), id);
			
		} else if (acao.equals("alterarSenhaUsuario")) {
			System.out.println("Alteração de senha do usuário...");
			
			
		} else if (acao.equals("alterarPerfilUsuario")) {
			System.out.println("Alteração de perfil do usuário...");
			
		}
		
		System.out.println("Buscando os dados do Usuário pelo ID...");
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
		
		System.out.println("Direcionando para a página " + redirecionamento);
		return redirecionamento;
	}

}
