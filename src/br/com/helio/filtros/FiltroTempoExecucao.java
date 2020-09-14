package br.com.helio.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		long tempoFinal = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");
		
		String serverName =  request.getServerName();
		int serverPort = request.getServerPort();
		
		String nomeAcaoCompleto = serverName + ":" + serverPort + uri + "?logica=" + parametros;
		
		System.out.println("Tempo da requisição de " + nomeAcaoCompleto + " demorou (ms): " + (tempoFinal - tempoInicial));
//		System.out.println("Tempo da requisição de " + uri + "?logica=" + parametros
//				+ " demorou (ms): " + (tempoFinal - tempoInicial));
	}

}
