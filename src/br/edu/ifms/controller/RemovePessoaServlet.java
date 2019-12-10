package br.edu.ifms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.ComodidadesDAO;
import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.model.Comodidades;
import br.edu.ifms.model.Pessoa;

/**
 * Servlet implementation class RemovePessoaServlet
 */
@WebServlet("/removePessoa")
public class RemovePessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PessoaDAO dao = new PessoaDAO();

		Long codigo = Long.parseLong(request.getParameter("codigo"));

		// remover o acessorio do BD
		try {
			dao.excluir(codigo);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// busca todos acessorios
		List<Pessoa> listaPessoas = dao.buscarTodos();

		RequestDispatcher rd = request.getRequestDispatcher("listaPessoas.jsp");
		request.setAttribute("pessoas", listaPessoas);
		rd.forward(request, response);
	}

}
