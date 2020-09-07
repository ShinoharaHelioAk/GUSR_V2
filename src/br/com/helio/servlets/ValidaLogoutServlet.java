package br.com.helio.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="validaLogoutServlet", urlPatterns = "/validaLogout")
public class ValidaLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 4558201493621926584L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().removeAttribute("usuarioLogado");
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
}
