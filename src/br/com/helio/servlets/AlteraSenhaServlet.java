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
		boolean usuarioNaoEstaLogado = (req.getSession().getAttribute("usuarioLogado") == null);
		if (usuarioNaoEstaLogado) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		if (getServletContext().getAttribute("erroSenhaAtual") != null) {
			System.out.println("Mensagem de erro encontrada na sess�o. Removendo...");
			getServletContext().removeAttribute("erroSenhaAtual");
		}
		
		Long id = Long.parseLong(req.getParameter("id"));
		String senhaAtual = req.getParameter("senhaAtual");
		String senhaNova = req.getParameter("senhaNova");
		System.out.println("ID: " + id);
		System.out.println("Senha atual: " + senhaAtual);
		System.out.println("Senha nova: " + senhaNova);
		
		System.out.println("Recuperando a conex�o guardada no Request...");
		UsuarioDAO dao = new UsuarioDAO((Connection) req.getAttribute("conexao"));
		Usuario usuario = new Usuario();
		String redirecionamento = null;
		
		//Validar se a senha atual digitada � a mesma que consta na base de dados.
		System.out.println("Buscando os dados do Usu�rio pelo ID...");
		usuario = dao.getUserById(id);
		System.out.println("Validando se a senha atual digitada � a mesma que consta na base de dados...");
		if (usuario.getSenha().equals(senhaAtual)) {
			System.out.println("Validado. A senha atual digitada � a mesma que consta na base de dados...");
			System.out.println("Atualizando a nova senha na base de dados...");
			dao.alteraSenhaUsuario(id, senhaNova);
			System.out.println("Nova senha atualizada na base de dados...");
			System.out.println("Novamente buscando os dados do Usu�rio pelo ID...");
			usuario = dao.getUserById(id);
			System.out.println("Pendurando o objeto usu�rio atualizado no request...");
			req.setAttribute("usuarioSenhaAtualizada", usuario);
			redirecionamento = "senhaAtualizada.jsp";
			
		} else {
			System.out.println("A senha atual digitada � diferente da que consta na base de dados...");
			System.out.println("Pendurando na sess�o mensagem de erro...");
			getServletContext().setAttribute("erroSenhaAtual", "Senha Atual digitada n�o bate com a senha cadastrada!");
			redirecionamento = "alteraSenhaUsuario.jsp";
			
		}
		
		System.out.println("Redirecionando para a p�gina " + redirecionamento);
		RequestDispatcher rd = req.getRequestDispatcher(redirecionamento);
		rd.forward(req, resp);
	}
}
