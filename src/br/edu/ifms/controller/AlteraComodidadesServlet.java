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
import br.edu.ifms.model.Comodidades;

/**
 * Servlet implementation class AlteraComodidadesServlet
 */
@WebServlet("/alteraComodidades")
public class AlteraComodidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
		Comodidades comodidades = comodidadesDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));
		comodidades.setDescricao(request.getParameter("descricao"));
		
		comodidadesDAO.alterar(comodidades);
		
		List<Comodidades> listaComodidades = comodidadesDAO.buscarTodos();
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("listaComodidades.jsp");
		request.setAttribute("comodidades", listaComodidades);
		rd.forward(request, response);
	}

}
