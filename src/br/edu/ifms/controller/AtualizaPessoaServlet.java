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

import br.edu.ifms.dao.HospedagemDAO;
import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.dao.QuartoDAO;
import br.edu.ifms.model.Hospedagem;
import br.edu.ifms.model.Pessoa;
import br.edu.ifms.model.Quarto;
import br.edu.ifms.model.Sexo;
import br.edu.ifms.model.Status;

/**
 * Servlet implementation class AtualizaPessoaServlet
 */
@WebServlet("/atualizaPessoa")
public class AtualizaPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaDAO pessoaDAO = new PessoaDAO();

		Pessoa pessoa = pessoaDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));

		List<Status> status = Arrays.asList(Status.values());
		List<Sexo> sexos = Arrays.asList(Sexo.values());

		RequestDispatcher rd = request.getRequestDispatcher("formAlteraPessoa.jsp");

		// colocar objeto modelo em memoria
		request.setAttribute("pessoa", pessoa);

		// setando as listas na requisição
		
		request.setAttribute("sexos", sexos);
		request.setAttribute("status", status);

		rd.forward(request, response);
	}

}
