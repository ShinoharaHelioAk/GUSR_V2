package br.com.helio.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

public class DetalharUsuarioLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean usuarioNaoEstaLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		if (usuarioNaoEstaLogado) {
			return "login.jsp";
		}
		
		System.out.println("Buscando os dados do Usuário pelo ID...");
		Long id = Long.parseLong(request.getParameter("id"));
		String acao = request.getParameter("acao");
		String redirecionamento = null;
		
		Usuario usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		usuario = dao.getUserById(id);
		
		if (acao.equals("removerUsuario")) {
			request.setAttribute("usuarioRemocao", usuario);
			redirecionamento = "detalharUsuarioAntesDeRemover.jsp";
		} else if (acao.equals("visualizarUsuario")) {
			request.setAttribute("visualizarUsuario", usuario);
			redirecionamento = "visualizarUsuario.jsp";
		}
		System.out.println("Redirecionando para a página "+redirecionamento);
		return redirecionamento;
	}

}
