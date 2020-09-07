package br.com.helio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

@WebServlet(name = "carregaUsuarioParaAlteracaoServlet", urlPatterns = "/carregaUsuarioParaAlteracao")
public class CarregaUsuarioParaAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = -5336590577465217288L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idRequestParam = req.getParameter("id");
		//System.out.println(idRequestParam);
		Long id = Long.parseLong(idRequestParam);
		String acaoRequestParam = req.getParameter("acao");
		if (acaoRequestParam == null)
			acaoRequestParam = "alterarDadosUsuario";
		System.out.println("Ação a ser efetivada: " + acaoRequestParam);
		String redirecionamento = null;
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		//Buscar na base os dados do usuário usando o id
		usuario = dao.getUserById(id);
		
		if (acaoRequestParam.equals("alterarSenhaUsuario")) {
			getServletContext().setAttribute("usuarioAlteraSenha", usuario);
			redirecionamento = "alteraSenhaUsuario.jsp";
			System.out.println("Direcionando para a página " + redirecionamento);
			RequestDispatcher rd = req.getRequestDispatcher(redirecionamento);
			rd.forward(req, resp);
			
			
			
		} else if (acaoRequestParam.equals("alterarPerfilUsuario")) {
			req.setAttribute("usuarioAlteraPerfil", usuario);
			redirecionamento = "alteraPerfilUsuario.jsp";
			System.out.println("Direcionando para a página " + redirecionamento);
			RequestDispatcher rd = req.getRequestDispatcher(redirecionamento);
			rd.forward(req, resp);
			
			
			
		} else {
			PrintWriter out = resp.getWriter();
			//out.println("Testando o Servlet " + getServletName() + ".");
			//out.println("Passando o ID " + id + ".");
			
			out.println("<html>");
			out.println("<head><title>SGUSR_V2 - Alteração de Dados do Usuário</title></head>");
			out.println("<body>");
			
			// Conteúdo do arquivo "cabecalho.jsp"
			out.println("<h3>SGUSR_V2 - Sistema de Gerenciamento de Usuários</h3>");
			if (getServletContext().getAttribute("usuarioLogado").toString() != null &&
					! getServletContext().getAttribute("usuarioLogado").toString().isEmpty()) {
				out.println("<b>Usuário Logado: </b>" + getServletContext().getAttribute("usuarioLogado").toString());
				out.println("<a href=\"validaLogout\">Sair</a>");
			}
			out.println("<hr color=\"#000000\" />");
			
			out.println("<h3>Página de Alteração de Usuários</h3>");
			//Popular os campos da Servlet
			out.println("<form action=\"alteraUsuario\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\"" + usuario.getId() + "\">");
			out.println("Nome: <input required=\"true\" type=\"text\" name=\"nome\" value=\"" + usuario.getNome() + "\"></br>");
			
			out.println("E-mail: <input type=\"email\" name=\"email\" value=\"" + usuario.getEmail() + "\"></br>");
			
			if (usuario.getDataNascimento() == null)
				out.println("Data de Nascimento: <input type=\"date\" name=\"dataNascimento\" value=\"" + 
						usuario.getDataNascimento() + "\"></br>");
			else
				out.println("Data de Nascimento: <input type=\"date\" name=\"dataNascimento\" value=\"" + 
						new SimpleDateFormat("yyyy-MM-dd").format(usuario.getDataNascimento().getTime()) + "\"></br>");
			
			out.println("<input type=\"submit\" value=\"Gravar\">");
			
			//out.println("<hr color=\"#000000\" />");
			//out.println("<a href=\"mvc?logica=ListaUsuariosLogica\">Voltar para a Lista de Usuários</a>");
			//out.println("<a href=\"index.jsp\">Voltar para a Home</a>");
			out.println("</form>");
			
			out.println("<hr color=\"#000000\" />");
			out.println("<form action=\"cadastraUsuarios.jsp\">");
			out.println("<input type=\"submit\" value=\"Cadastrar Novo Usuário\">");
			out.println("<a href=\"mvc?logica=ListaUsuariosLogica\">Voltar para a Lista de Usuários</a>");
			out.println("<a href=\"index.jsp\">Voltar para a Home</a>");
			out.println("</form>");
			
			// Conteúdo do arquivo "rodape.jsp"
			out.println("<hr color=\"#000000\" />");
			out.println("<p>2020 - Site construído por Hélio Shinohara.</p>");
			
			out.println("</body>");
			out.println("</html>");
			
			out.close();
		}
		
		
	}

}
