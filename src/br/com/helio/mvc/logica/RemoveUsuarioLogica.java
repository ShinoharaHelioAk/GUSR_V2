package br.com.helio.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;

public class RemoveUsuarioLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean usuarioNaoEstaLogado = (request.getSession().getAttribute("usuarioLogado") == null);
		if (usuarioNaoEstaLogado) {
			return "login.jsp";
		}
		
		System.out.println("Buscando os dados do Usuário pelo ID...");
		Long id = Long.parseLong(request.getParameter("id"));
		
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		dao.removeUser(id);
		System.out.println("Redirecionando para a página usuarioRemovido.jsp");
		return "usuarioRemovido.jsp";
	}

}
