package br.com.helio.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

@WebServlet(
		name = "validaLoginServlet",
		urlPatterns = "/validaLogin"
	)
public class ValidaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = -7377102283127505317L;
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		System.out.println("Usu�rio: "+usuario+" e Senha: "+senha+".");
		
		RequestDispatcher rd = request.getRequestDispatcher("/usuarioLogado.jsp");
		rd.forward(request, response);
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Se encontrar a mensagem de "Usu�rio n�o encontrado!" no Contexto da aplica��o, remove.
		//System.out.println("linha 39: " + getServletContext().getAttribute("usrNFnd"));
		if (getServletContext().getAttribute("usrNFnd") != null) {
			getServletContext().removeAttribute("usrNFnd");
		}
		//System.out.println("linha 43: " + getServletContext().getAttribute("usrNFnd"));
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		//System.out.println("Usu�rio: "+usuario+" e Senha: "+senha+".");
		
		// Aqui vou incluir algumas valida��es...
		//select * from usuarios where nome = usuario, senha = senha, status = ativo, perfil = administrador
		Connection connection = (Connection) req.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(connection);
		Usuario usuarioLogado = new Usuario();
		usuarioLogado = dao.getUserByNameAndPassword(usuario, senha);
		//System.out.println("Usu�rio Logado: "+usuarioLogado);
		
		String requestDispatcher = null;
		//Verifica se a busca retornou um usu�rio.
		if (usuarioLogado == null) {
			getServletContext().setAttribute("usrNFnd", "usuario_nao_encontrado");
			requestDispatcher = "/login.jsp";
		} else {
			//getServletContext().setAttribute("usuarioLogado", usuarioLogado.getNome());
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuarioLogado);
			requestDispatcher = "/index.jsp";
		}
		//System.out.println("linha 65: " + getServletContext().getAttribute("usrNFnd"));
		
		//req.setAttribute("usuarioLogado", usuario);
		//String usuario2 = (String) req.getAttribute("usuarioLogado");
		//System.out.println("Verificando se o usu�rio est� pendurado no contexto do request: " + usuario2);
		
		RequestDispatcher rd = req.getRequestDispatcher(requestDispatcher);
		rd.forward(req, resp);
	}
}
