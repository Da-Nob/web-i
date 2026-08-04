package com.daniel;

import com.daniel.entities.Instrutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursosPU");
        EntityManager em = emf.createEntityManager();

        // // Criando uma nova instância da entidade Instrutor
        // Instrutor instrutor = new Instrutor();
        // instrutor.setNome("João Silva");
        // instrutor.setEmail("joao.silva@example.com");
        // instrutor.setBiografia("Especialista em Java e desenvolvimento web.");

        // // Iniciando uma transação
        // em.getTransaction().begin();

        // // Persistindo a entidade
        // em.persist(instrutor);

        // instrutor.setEmail("silva.joao@example.com"); // Alterando o email do instrutor antes de confirmar a transação

        // // Confirmando a transação
        // em.getTransaction().commit();

        // Buscando uma entidade Instrutor pelo ID
        Instrutor instrutorEncontrado = em.find(Instrutor.class, 1L); // Substitua 1L pelo ID do instrutor que deseja buscar
        if (instrutorEncontrado != null) {
            System.out.println("Instrutor encontrado: " + instrutorEncontrado.getNome());
        } else {
            System.out.println("Instrutor não encontrado.");
        }

        em.close();
        emf.close();
    }
}