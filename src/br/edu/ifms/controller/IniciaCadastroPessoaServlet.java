package br.edu.ifms.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.dao.QuartoDAO;

import br.edu.ifms.model.Pessoa;
import br.edu.ifms.model.Quarto;
import br.edu.ifms.model.Sexo;
import br.edu.ifms.model.Status;

/**
 * Servlet implementation class IniciaCadastroPessoaServlet
 */
@WebServlet("/iniciaCadastroPessoa")
public class IniciaCadastroPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Sexo> sexos = Arrays.asList(Sexo.values());

		List<Status> status = Arrays.asList(Status.values());

		RequestDispatcher rd = request.getRequestDispatcher("pessoa.jsp");
		// setando as listas na requisição
		request.setAttribute("sexos", sexos);
		request.setAttribute("status", status);

		rd.forward(request, response);
	}

}
