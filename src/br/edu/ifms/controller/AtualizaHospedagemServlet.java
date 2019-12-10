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
import br.edu.ifms.model.Status;

/**
 * Servlet implementation class AtulizaHospedagemServlet
 */
@WebServlet("/atualizaHospedagem")
public class AtualizaHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HospedagemDAO hospedagemDAO = new HospedagemDAO();

		Hospedagem hospedagem = hospedagemDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));

		QuartoDAO quartoDAO = new QuartoDAO();
		List<Quarto> quartos = quartoDAO.buscarTodos();

		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> pessoas = pessoaDAO.buscarTodos();

		List<Status> status = Arrays.asList(Status.values());

		RequestDispatcher rd = request.getRequestDispatcher("formAlteraHospedagem.jsp");

		// colocar objeto modelo em memoria
		request.setAttribute("hospedagem", hospedagem);

		// setando as listas na requisição
		request.setAttribute("quartos", quartos);
		request.setAttribute("pessoas", pessoas);
		request.setAttribute("status", status);

		rd.forward(request, response);
	}

}
