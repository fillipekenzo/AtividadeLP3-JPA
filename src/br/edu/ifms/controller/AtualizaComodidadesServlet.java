package br.edu.ifms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifms.dao.ComodidadesDAO;
import br.edu.ifms.model.Comodidades;

/**
 * Servlet implementation class AtualizaComodidadesServlet
 */
@WebServlet("/atualizaComodidades")
public class AtualizaComodidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
		
		Comodidades comodidades = comodidadesDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));
		RequestDispatcher rd = 
				request.getRequestDispatcher("formAlteraComodidades.jsp");
		
		//colocar objeto acessorio em memoria
		request.setAttribute("comodidade", comodidades);
		
		rd.forward(request, response);
	}

}
