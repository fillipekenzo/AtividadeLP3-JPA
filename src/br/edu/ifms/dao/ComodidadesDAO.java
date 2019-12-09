package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.exception.NegocioException;
import br.edu.ifms.jpa.EntityManagerUtil;
import br.edu.ifms.model.Comodidades;


public class ComodidadesDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public ComodidadesDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	public void salvar(Comodidades comodidades) {
		em.getTransaction().begin();
		em.persist(comodidades);
		em.getTransaction().commit();
	}
	
	public void alterar(Comodidades comodidades) {
		em.getTransaction().begin();
		em.merge(comodidades);
		em.getTransaction().commit();
	}

	public List<Comodidades> buscarTodos() {
		return em.createQuery("from Comodidades", 
				Comodidades.class).getResultList();
	}

	public void excluir(Long codigo) throws NegocioException {
		try {
			
			Comodidades comodidadesTemp = em.find(Comodidades.class, codigo);
			em.getTransaction().begin();
			em.remove(comodidadesTemp);
			em.getTransaction().commit();		
			} catch (PersistenceException e) {
			throw new NegocioException("Comodidade não pode ser excluido.");
		}
	}

	public Comodidades buscarPeloCodigo(Long codigo) {
		return em.find(Comodidades.class, codigo);
	}
}
