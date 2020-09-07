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

@WebServlet(name = "alteraPerfilServlet", urlPatterns = "/alteraPerfilUsuario")
public class AlteraPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = -1985326171538306403L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String perfil = req.getParameter("perfil");
		
		System.out.println("Recuperando a conex�o guardada no Request...");
		UsuarioDAO dao = new UsuarioDAO((Connection) req.getAttribute("conexao"));
		Usuario usuario = new Usuario();
		
		//Validar se houve altera��o no Perfil do usu�rio.
		//Se n�o houve, n�o vai atualizar a base de dados.
		//System.out.println("Buscando os dados do Usu�rio pelo ID...");
		//usuario = dao.getUserById(id);
		//System.out.println("Perfil da tela: "+perfil);
		//System.out.println("Perfil da base: "+usuario.getPerfil());
		
		//System.out.println("Validando se o perfil escolhido na tela � o mesmo que consta na base de dados...");
		//if (perfil.equals(usuario.getPerfil())) {
			//System.out.println("Perfil escolhido na tela � igual ao perfil na base. N�o vai atualizar a base de dados...");
		//} else {
			//System.out.println("Perfil escolhido na tela � diferente do perfil na base...");
			System.out.println("Atualizando o novo perfil na base de dados...");
			dao.alteraPerfilUsuario(id, perfil);
			System.out.println("Novo perfil atualizado na base de dados...");
		//}
		
		//System.out.println("Novamente buscando os dados do Usu�rio pelo ID...");
		System.out.println("Buscando os dados do Usu�rio pelo ID...");
		usuario = dao.getUserById(id);
		System.out.println("Pendurando o objeto usu�rio atualizado no request...");
		req.setAttribute("usuarioPerfilAtualizado", usuario);
		
		RequestDispatcher rd = req.getRequestDispatcher("perfilAtualizado.jsp");
		rd.forward(req, resp);
	}
}
