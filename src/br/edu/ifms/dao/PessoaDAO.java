package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.jpa.EntityManagerUtil;
import br.edu.ifms.model.Pessoa;


public class PessoaDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public PessoaDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public Pessoa buscarPeloCodigo(Long codigo) {
		return em.find(Pessoa.class, codigo);
	}
	
	
	public void salvar(Pessoa pessoa) {
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
	}

	public List<Pessoa> buscarTodos() {
		return em.createQuery("from Pessoa", Pessoa.class).getResultList();
	}
	
	
	public void excluir(Long codigo) throws NegocioException {
		try {
			Pessoa pessoaTemp = em.find(Pessoa.class, codigo);
			em.getTransaction().begin();
			em.remove(pessoaTemp);
			em.getTransaction().commit();		
			} catch (PersistenceException e) {
			throw new NegocioException("Pessoa não pode ser excluido.");
		}
	}
	
	public void alterar(Pessoa pessoa) {
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
	}

}
