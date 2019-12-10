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
import br.edu.ifms.model.Status;
import br.edu.ifms.model.TipoQuarto;

/**
 * Servlet implementation class IniciaCadastroQuartoServlet
 */
@WebServlet("/iniciaCadastroQuarto")
public class IniciaCadastroQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
		List<Comodidades> comodidades = comodidadesDAO.buscarTodos();

		List<TipoQuarto> tipoQuartos = Arrays.asList(TipoQuarto.values());
		
		List<Disponibilidade> disponibilidades = Arrays.asList(Disponibilidade.values());
		
		RequestDispatcher rd = request.getRequestDispatcher("quarto.jsp");
		// setando as listas na requisição
		request.setAttribute("comodidades", comodidades);
		request.setAttribute("tipoQuartos", tipoQuartos);
		request.setAttribute("disponibilidades", disponibilidades);
		rd.forward(request, response);
	
	}

}
