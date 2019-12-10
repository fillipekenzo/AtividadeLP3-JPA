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

import br.edu.ifms.dao.ComodidadesDAO;
import br.edu.ifms.dao.QuartoDAO;
import br.edu.ifms.model.Comodidades;
import br.edu.ifms.model.Disponibilidade;
import br.edu.ifms.model.Quarto;
import br.edu.ifms.model.TipoQuarto;

/**
 * Servlet implementation class AlteraQuartoServlet
 */
@WebServlet("/alteraQuarto")
public class AlteraQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		QuartoDAO quartoDAO = new QuartoDAO();
		Quarto quarto = quartoDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));
		quarto.setCapacidade(Long.parseLong(request.getParameter("capacidade")));
		quarto.setNumero(Long.parseLong(request.getParameter("numero")));
		
		/*String[] listaComodidades = request.getParameterValues("com");

		List<Comodidades> comodidades = new ArrayList<Comodidades>();
		Comodidades coms = new Comodidades();
		ComodidadesDAO comDAO = new ComodidadesDAO();

		for (String comodidade : listaComodidades) {
			coms = comDAO.buscarPeloCodigo(Long.parseLong(comodidade));
			comodidades.add(coms);
		}

		quarto.setComodidades(comodidades);
		*/
		quarto.setDisponibilidade(Disponibilidade.valueOf
				 (request.getParameter("disponibilidade")));
		 System.out.println("atributo disponibilidade: " + request.getParameter("disponibilidade") );
		 System.out.println("atributo disponibilidade objeto: " 
		 + quarto.getDisponibilidade().getDescricao() );
		
		 quarto.setTipoQuarto(TipoQuarto.valueOf
				 (request.getParameter("tipoQuarto")));
	
		 quartoDAO.alterar(quarto);
		 
		 List<Quarto> listaQuartos = quartoDAO.buscarTodos();
		 
		 List<Quarto> listaQuartosComComodidades = new ArrayList<Quarto>();
		 
		 for (Quarto quarto2 : listaQuartos) {
			 listaQuartosComComodidades.add
			(quartoDAO.buscarQuartoComComodidades(quarto2.getCodigo()));
		}
		 
		RequestDispatcher rd = request.getRequestDispatcher("listaQuartos.jsp");
		request.setAttribute("quartosComodidades", listaQuartosComComodidades);
		rd.forward(request, response);
	}

}
