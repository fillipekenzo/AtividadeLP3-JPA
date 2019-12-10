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

import br.edu.ifms.dao.ComodidadesDAO;
import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.dao.QuartoDAO;
import br.edu.ifms.model.Comodidades;
import br.edu.ifms.model.Disponibilidade;
import br.edu.ifms.model.Pessoa;
import br.edu.ifms.model.Quarto;
import br.edu.ifms.model.Sexo;
import br.edu.ifms.model.Status;
import br.edu.ifms.model.TipoQuarto;

/**
 * Servlet implementation class AtualizaQuartoServlet
 */
@WebServlet("/atualizaQuarto")
public class AtualizaQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuartoDAO quartoDAO = new QuartoDAO();

		Quarto quarto = quartoDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));

		List<Disponibilidade> disponibilidades = Arrays.asList(Disponibilidade.values());
		List<TipoQuarto> tipoQuartos = Arrays.asList(TipoQuarto.values());

		RequestDispatcher rd = request.getRequestDispatcher("formAlteraQuarto.jsp");

		// colocar objeto modelo em memoria
		request.setAttribute("quarto", quarto);

		// setando as listas na requisição
		
		request.setAttribute("disponibilidades", disponibilidades);
		request.setAttribute("tipoQuartos", tipoQuartos);

		rd.forward(request, response);
	}

}
