package br.com.helio.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

public class ListaUsuariosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean usuarioNaoEstaLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		if (usuarioNaoEstaLogado) {
			System.out.println("Não existe usuário logado. Redirecionando para a página de login...");
			return "login.jsp";
		}
		
		Connection connection = (Connection) request.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(connection);
		
		List<Usuario> usuarios = dao.getListUsers();
		request.setAttribute("usuarios", usuarios);
		
		//request.getAttribute("usuarioLogado");
		
		return "listaUsuarios.jsp";
	}

}
