package com.daniel.dao;

import java.util.List;
import java.util.Optional;

import com.daniel.db.DBFactory;
import com.daniel.entities.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CursoDaoImpl implements GenericDAO<Curso, Long> {

    @Override
    public Curso salvar(Curso entidade) {
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
    public Optional<Curso> buscarPorId(Long id) {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            Curso curso = em.find(Curso.class, id);
            return Optional.ofNullable(curso);
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Curso> buscarTodos() {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            String jpql = "SELECT c FROM Curso c";
            TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);

            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Curso atualizar(Curso entidade) {
        EntityManager em = DBFactory.criarEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Curso cursoAtualizado = em.merge(entidade);
            tx.commit();

            return cursoAtualizado;
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

            Curso curso = em.find(Curso.class, id);

            if (curso != null) {
                em.remove(curso);
            } else {
                System.out.println("Curso não encontrado para remoção.");
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

    public List<Curso> buscarPorTitulo(String titulo) {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            String jpql = "SELECT c FROM Curso c WHERE c.titulo LIKE :titulo";

            TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
            query.setParameter("titulo", "%" + titulo + "%");

            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}