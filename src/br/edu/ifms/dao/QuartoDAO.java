package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.jpa.EntityManagerUtil;
import br.edu.ifms.model.Hospedagem;
import br.edu.ifms.model.Quarto;

public class QuartoDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	public QuartoDAO() {
		em = EntityManagerUtil.getEntityManager();
	}

	public Quarto buscarPeloCodigo(Long codigo) {
		return em.find(Quarto.class, codigo);
	}

	public void salvar(Quarto quarto) {
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();

	}

	public List<Quarto> buscarTodos() {
		return em.createQuery("from Quarto", Quarto.class).getResultList();
	}

	public void excluir(Long codigo) throws NegocioException {
		try {
			Quarto quartoTemp = em.find(Quarto.class, codigo);
			em.getTransaction().begin();
			em.remove(quartoTemp);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new NegocioException("Quarto não pode ser excluido.");
		}
	}

	public void alterar(Quarto quarto) {
		em.getTransaction().begin();
		em.merge(quarto);
		em.getTransaction().commit();
	}

	public Quarto buscarQuartoComComodidades(Long codigo) {
		return em.createNamedQuery("Quarto.buscarQuartoComComodidades", Quarto.class)
				.setParameter("codigo", codigo).getSingleResult();
	}
}
