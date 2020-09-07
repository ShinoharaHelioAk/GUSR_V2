package br.com.helio.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

@WebServlet(name = "alteraSenhaServlet", urlPatterns = "/alteraSenhaUsuario")
public class AlteraSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = -4129999156529281604L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (getServletContext().getAttribute("erroSenhaAtual") != null) {
			System.out.println("Mensagem de erro encontrada na sessão. Removendo...");
			getServletContext().removeAttribute("erroSenhaAtual");
		}
		
		Long id = Long.parseLong(req.getParameter("id"));
		String senhaAtual = req.getParameter("senhaAtual");
		String senhaNova = req.getParameter("senhaNova");
		System.out.println("ID: " + id);
		System.out.println("Senha atual: " + senhaAtual);
		System.out.println("Senha nova: " + senhaNova);
		
		System.out.println("Recuperando a conexão guardada no Request...");
		UsuarioDAO dao = new UsuarioDAO((Connection) req.getAttribute("conexao"));
		Usuario usuario = new Usuario();
		String redirecionamento = null;
		
		//Validar se a senha atual digitada é a mesma que consta na base de dados.
		System.out.println("Buscando os dados do Usuário pelo ID...");
		usuario = dao.getUserById(id);
		System.out.println("Validando se a senha atual digitada é a mesma que consta na base de dados...");
		if (usuario.getSenha().equals(senhaAtual)) {
			System.out.println("Validado. A senha atual digitada é a mesma que consta na base de dados...");
			System.out.println("Atualizando a nova senha na base de dados...");
			dao.alteraSenhaUsuario(id, senhaNova);
			System.out.println("Nova senha atualizada na base de dados...");
			System.out.println("Novamente buscando os dados do Usuário pelo ID...");
			usuario = dao.getUserById(id);
			System.out.println("Pendurando o objeto usuário atualizado no request...");
			req.setAttribute("usuarioSenhaAtualizada", usuario);
			redirecionamento = "senhaAtualizada.jsp";
			
		} else {
			System.out.println("A senha atual digitada é diferente da que consta na base de dados...");
			System.out.println("Pendurando na sessão mensagem de erro...");
			getServletContext().setAttribute("erroSenhaAtual", "Senha Atual digitada não bate com a senha cadastrada!");
			redirecionamento = "alteraSenhaUsuario.jsp";
			
		}
		
		System.out.println("Redirecionando para a página " + redirecionamento);
		RequestDispatcher rd = req.getRequestDispatcher(redirecionamento);
		rd.forward(req, resp);
	}
}
