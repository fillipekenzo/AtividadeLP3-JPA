package br.edu.ifms.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import br.edu.ifms.model.Disponibilidade;
import br.edu.ifms.model.Hospedagem;
import br.edu.ifms.model.Status;

/**
 * Servlet implementation class AlteraHospedagemServlet
 */
@WebServlet("/alteraHospedagem")
public class AlteraHospedagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		QuartoDAO quartoDAO = new QuartoDAO();
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		
		Hospedagem hospedagem = hospedagemDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));
		
		Long codigoPessoa = Long.parseLong(request.getParameter("pessoa"));

		Long codigoQuarto = Long.parseLong(request.getParameter("quarto"));

		hospedagem.setPessoa(pessoaDAO.buscarPeloCodigo(codigoPessoa));
		hospedagem.setQuarto(quartoDAO.buscarPeloCodigo(codigoQuarto));
		hospedagem.setStatus(Status.valueOf
				 (request.getParameter("status")));
		String dataConv = request.getParameter("dataEntrada");
		String dataConv2 = request.getParameter("dataSaida");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataEnt, dataSaida;
		try {
			dataSaida = sdf.parse(dataConv2);
			dataEnt = sdf.parse(dataConv);
			hospedagem.setDataEntrada(dataEnt);
			hospedagem.setDataSaida(dataSaida);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal bd = new BigDecimal(request.getParameter("valorDiaria"));
		hospedagem.setValorDiaria(bd);
		hospedagem.setStatus(Status.valueOf(request.getParameter("status")));

		// salvar o modeloCarro no BD
		hospedagemDAO.alterar(hospedagem);

		// buscar os modelos no BD
		List<Hospedagem> listaHospedagem = hospedagemDAO.buscarTodos();

		// O sistema é direcionado para a página
		// listaModeloCarro.jsp
		RequestDispatcher rd = request.getRequestDispatcher("listaHospedagens.jsp");
		request.setAttribute("hospedagens", listaHospedagem);
		rd.forward(request, response);
	}
}
