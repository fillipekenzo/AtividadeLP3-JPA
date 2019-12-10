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
 * Servlet implementation class ComodidadesServlet
 */
@WebServlet("/cadastroComodidades")
public class CadastroComodidadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comodidades comodidades = new Comodidades();
		ComodidadesDAO comodidadesDAO = new ComodidadesDAO();
		
		comodidades.setDescricao(request.getParameter("descricao"));
		
		comodidadesDAO.salvar(comodidades);
		
		List<Comodidades> listaComodidades = comodidadesDAO.buscarTodos();
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("listaComodidades.jsp");
		request.setAttribute("comodidades", listaComodidades);
		rd.forward(request, response);
	}

}
