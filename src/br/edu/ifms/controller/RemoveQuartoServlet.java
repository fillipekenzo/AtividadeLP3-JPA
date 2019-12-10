package br.edu.ifms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.dao.QuartoDAO;
import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.model.Pessoa;
import br.edu.ifms.model.Quarto;

/**
 * Servlet implementation class RemoveQuartoServlet
 */
@WebServlet("/removeQuarto")
public class RemoveQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuartoDAO dao = new QuartoDAO();

		Long codigo = Long.parseLong(request.getParameter("codigo"));

		// remover o acessorio do BD
		try {
			dao.excluir(codigo);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// busca todos acessorios
		List<Quarto> listaQuartos = dao.buscarTodos();
		List<Quarto> listaQuartosComComodidades = new ArrayList<Quarto>();

		for (Quarto quarto2 : listaQuartos) {
			listaQuartosComComodidades.add(dao.buscarQuartoComComodidades(quarto2.getCodigo()));
		}

		RequestDispatcher rd = request.getRequestDispatcher("listaQuartos.jsp");
		request.setAttribute("quartosComodidades", listaQuartosComComodidades);
		rd.forward(request, response);
	}

}
