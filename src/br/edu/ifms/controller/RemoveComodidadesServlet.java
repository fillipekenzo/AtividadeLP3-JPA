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
import br.edu.ifms.exception.NegocioException;

import br.edu.ifms.model.Comodidades;

/**
 * Servlet implementation class RemoveComodidadesServlet
 */
@WebServlet("/removeComodidades")
public class RemoveComodidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ComodidadesDAO dao = new ComodidadesDAO();

		Long codigo = Long.parseLong(request.getParameter("codigo"));

		// remover o acessorio do BD
		try {
			dao.excluir(codigo);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// busca todos acessorios
		List<Comodidades> listaComodidades = dao.buscarTodos();

		RequestDispatcher rd = request.getRequestDispatcher("listaComodidades.jsp");
		request.setAttribute("comodidades", listaComodidades);
		rd.forward(request, response);
	}

}
