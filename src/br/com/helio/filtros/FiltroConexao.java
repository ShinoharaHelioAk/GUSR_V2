package br.com.helio.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.helio.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			// pendurando a conex�o na requisi��o
			request.setAttribute("conexao", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
