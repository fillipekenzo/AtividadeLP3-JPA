package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.jpa.EntityManagerUtil;
import br.edu.ifms.model.Hospedagem;

public class HospedagemDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public HospedagemDAO() {
		em = EntityManagerUtil.getEntityManager();
	}

	public Hospedagem buscarPeloCodigo(Long codigo) {
		return em.find(Hospedagem.class, codigo);
	}

	public void salvar(Hospedagem hospedagem) {
		em.getTransaction().begin();
		em.persist(hospedagem);
		em.getTransaction().commit();

	}

	public List<Hospedagem> buscarTodos() {
		return em.createQuery("from Hospedagem", Hospedagem.class).getResultList();
	}

	public void excluir(Long codigo) throws NegocioException {
		try {
			Hospedagem hospedagemTemp = em.find(Hospedagem.class, codigo);
			em.getTransaction().begin();
			em.remove(hospedagemTemp);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new NegocioException("Hospedagem não pode ser excluido.");
		}
	}

	public void alterar(Hospedagem hospedagem) {
		em.getTransaction().begin();
		em.merge(hospedagem);
		em.getTransaction().commit();
	}

}
