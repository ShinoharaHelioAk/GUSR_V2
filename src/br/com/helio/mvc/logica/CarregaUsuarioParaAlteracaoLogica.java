package br.com.helio.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

public class CarregaUsuarioParaAlteracaoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Buscando os dados do Usuário pelo ID...");
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = new Usuario();
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		usuario = dao.getUserById(id);
		request.setAttribute("usuarioAlteracao", usuario);
		System.out.println("Redirecionando para a página alteraUsuario.jsp");
		return "alteraUsuario.jsp";
	}

}
