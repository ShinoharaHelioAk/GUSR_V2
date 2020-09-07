package br.com.helio.mvc.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.helio.dao.UsuarioDAO;
import br.com.helio.model.Usuario;

public class AdicionaUsuarioLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dataNascimentoEmTexto = request.getParameter("dataNascimento");
		String senha = request.getParameter("senha");
		String perfil = request.getParameter("perfil");
		
		Calendar dataNascimento = null;
		
		if (!dataNascimentoEmTexto.isEmpty()) {
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimentoEmTexto);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
			} catch (ParseException e) {
				out.println("Erro na conversão da data.\n\n\n");
				//out.println("Detalhes do Erro: \n"+e);
				return null;
			}
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setDataNascimento(dataNascimento);
		usuario.setSenha(senha);
		usuario.setPerfil(perfil);
		
		UsuarioDAO dao = new UsuarioDAO((Connection) request.getAttribute("conexao"));
		dao.adicionaUsuario(usuario);
		
		return "usuarioAdicionado.jsp";
	}

}
