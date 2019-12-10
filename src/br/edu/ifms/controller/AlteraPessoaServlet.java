package br.edu.ifms.controller;

import java.io.IOException;
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

import br.edu.ifms.dao.PessoaDAO;
import br.edu.ifms.model.Pessoa;
import br.edu.ifms.model.Sexo;
import br.edu.ifms.model.Status;

/**
 * Servlet implementation class AlteraPessoaServlet
 */
@WebServlet("/alteraPessoa")
public class AlteraPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscarPeloCodigo(Long.parseLong(request.getParameter("codigo")));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setCpf(request.getParameter("cpf"));
		pessoa.setTelefone(request.getParameter("telefone"));

		String dataConv = request.getParameter("dataNascimento");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNasc;
		try {
			dataNasc = sdf.parse(dataConv);
			pessoa.setDataNascimento(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pessoa.setSexo(Sexo.valueOf(request.getParameter("sexo")));
		System.out.println("atributo sexo: " + request.getParameter("sexo"));
		System.out.println("atributo sexo objeto: " + pessoa.getSexo().getDescricao());

		pessoa.setStatus(Status.valueOf(request.getParameter("status")));
		System.out.println("atributo status: " + request.getParameter("status"));
		System.out.println("atributo status objeto: " + pessoa.getStatus().getDescricao());

		// salvar o no BD
		pessoaDAO.alterar(pessoa);

		// buscar os modelos no BD
		List<Pessoa> listaPessoas = pessoaDAO.buscarTodos();

		RequestDispatcher rd = request.getRequestDispatcher("listaPessoas.jsp");
		request.setAttribute("pessoas", listaPessoas);
		rd.forward(request, response);
	}

}
