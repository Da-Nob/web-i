package com.daniel;

import com.daniel.entities.Aula;
import com.daniel.entities.Curso;
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

        // Suponha que você tenha uma entidade Instrutor desanexada (detached)
        Instrutor instrutorDetached = new Instrutor();
        instrutorDetached.setId(1L); // ID da entidade que você deseja atualizar
        instrutorDetached.setNome("Maria da Silva");
        instrutorDetached.setEmail("maria.silva@example.com");

        em.getTransaction().begin(); // Iniciando uma transação

        // Chamando merge() para atualizar a entidade
        Instrutor instrutorAtualizado = em.merge(instrutorDetached);

        em.getTransaction().commit();

        // Buscando uma entidade Instrutor pelo ID
        Instrutor instrutorEncontrado = em.find(Instrutor.class, 1L); // Substitua 1L pelo ID do instrutor que deseja buscar
        if (instrutorEncontrado != null) {
            System.out.println("Instrutor encontrado: " + instrutorEncontrado.getNome());
        } else {
            System.out.println("Instrutor não encontrado.");
        }


        try {
    em.getTransaction().begin();

    // Buscando o instrutor que será associado ao curso
    Instrutor instrutorEncontrado1 = em.find(Instrutor.class, 1L);

    // Criando uma nova instância da entidade Curso
    Curso curso = new Curso();
    curso.setTitulo("Java Avançado");
    curso.setDescricao("Curso avançado de Java para desenvolvedores experientes.");
    curso.setCargaHoraria(40.0);
    curso.setPreco(499.99);
    curso.setNivel("Avançado");
    curso.setUrl("https://www.example.com/java-avancado");
    curso.setStatus("Ativo");
    // Supondo que instrutorEncontrado seja uma entidade Instrutor previamente buscada
    curso.setInstrutor(instrutorEncontrado1);

    // Persistindo o curso
    em.persist(curso);

    // Criando e persistindo aulas associadas ao curso
    Aula aula1 = new Aula();
    aula1.setTitulo("Aula 1 - Introdução ao Java Avançado");
    aula1.setDescricao("Nesta aula, vamos explorar conceitos avançados de Java.");
    aula1.setDuracaoMinutos(30);
    aula1.setOrdem(1);
    aula1.setUrlVideo("https://www.example.com/java-avancado/aula1");
    aula1.setCurso(curso);

    em.persist(aula1);

    Aula aula2 = new Aula();
    aula2.setTitulo("Aula 2 - Generics e Collections");
    aula2.setDescricao("Nesta aula, vamos explorar os conceitos de Generics e Collections em Java.");
    aula2.setDuracaoMinutos(45);
    aula2.setOrdem(2);
    aula2.setUrlVideo("https://www.example.com/java-avancado/aula2");
    aula2.setCurso(curso);

    em.persist(aula2);

    // Confirmando a transação
    em.getTransaction().commit();
} catch (Exception e) {
    // Em caso de erro, reverter a transação
    em.getTransaction().rollback();
    System.out.println("Erro ao persistir o curso e suas aulas: " + e.getMessage());
}

        em.close();
        emf.close();
    }
}