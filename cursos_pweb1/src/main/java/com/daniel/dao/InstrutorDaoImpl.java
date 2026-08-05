package com.daniel.dao;

import java.util.List;
import java.util.Optional;

import com.daniel.db.DBFactory;
import com.daniel.entities.Instrutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class InstrutorDaoImpl implements GenericDAO<Instrutor, Long> {

  @Override
  public Instrutor salvar(Instrutor entidade) {
     EntityManager em = DBFactory.criarEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        
        tx.begin();
        em.persist(entidade);
        tx.commit();

        
        return entidade;
    } catch (Exception e) { 
        if (tx.isActive()) {
            tx.rollback();
        }
        throw e;
    } finally { 
        em.close();
    }
}

  @Override
  public Optional<Instrutor> buscarPorId(Long id) {
    EntityManager em = DBFactory.criarEntityManager(); 

    try {
        // Buscando a entidade Instrutor pelo ID
        Instrutor instrutor = em.find(Instrutor.class, id);
        return Optional.ofNullable(instrutor); 
    } catch (Exception e) {
        throw e;
    } finally { 
        em.close();
    }
}

  @Override
  public List<Instrutor> buscarTodos() {
    EntityManager em = DBFactory.criarEntityManager(); 

    try {
        
        String jpql = "SELECT i FROM Instrutor i";
        TypedQuery<Instrutor> query = em.createQuery(jpql, Instrutor.class);

        
        return query.getResultList();
    } catch (Exception e) {
        throw e;
    } finally { 
        em.close();
    }
}

  @Override
  public Instrutor atualizar(Instrutor entidade) {
    EntityManager em = DBFactory.criarEntityManager(); 
    EntityTransaction tx = em.getTransaction(); 

    try {
        
        tx.begin();
        Instrutor instrutorAtualizado = em.merge(entidade);
        tx.commit();

        
        return instrutorAtualizado;
    } catch (Exception e) { 
        if (tx.isActive()) {
            tx.rollback();
        }
        throw e;
    } finally { 
        em.close();
    }
}

  @Override
  public void remover(Long id) {
    EntityManager em = DBFactory.criarEntityManager(); 
    EntityTransaction tx = em.getTransaction(); 

    try {
        tx.begin();

        
        Instrutor instrutorParaRemover = em.find(Instrutor.class, id);
        if (instrutorParaRemover != null) {
            
            em.remove(instrutorParaRemover);
        } else {
            System.out.println("Instrutor não encontrado para remoção.");
        }

        
        tx.commit();
    } catch (Exception e) { 
        if (tx.isActive()) {
            tx.rollback();
        }
        throw e;
    } finally { 
        em.close();
    }
  }

  public List<Instrutor> buscarPorNome(String nome) {
    EntityManager em = DBFactory.criarEntityManager(); 

    try {
        
        String jpql = "SELECT i FROM Instrutor i WHERE i.nome LIKE :nome";
        TypedQuery<Instrutor> query = em.createQuery(jpql, Instrutor.class);
        query.setParameter("nome", "%" + nome + "%"); 
        return query.getResultList();
    } catch (Exception e) {
        throw e;
    } finally { 
        em.close();
    }
}

}
