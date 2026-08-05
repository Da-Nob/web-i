package com.daniel;

import java.util.List;
import java.util.Optional;

import com.daniel.dao.AulaDaoImpl;
import com.daniel.dao.CursoDaoImpl;
import com.daniel.dao.InstrutorDaoImpl;
import com.daniel.db.DBFactory;
import com.daniel.entities.Aula;
import com.daniel.entities.Curso;
import com.daniel.entities.Instrutor;

public class Main {

    public static void main(String[] args) {

        InstrutorDaoImpl instrutorDAO = new InstrutorDaoImpl();
        CursoDaoImpl cursoDAO = new CursoDaoImpl();
        AulaDaoImpl aulaDAO = new AulaDaoImpl();

        // ==========================
        // INSTRUTOR
        // ==========================

        Instrutor instrutor = new Instrutor();
        instrutor.setNome("Carlos Eduardo");
        instrutor.setEmail("carlos.eduardo@example.com");
        instrutor.setBiografia("Especialista em Java.");

        instrutorDAO.salvar(instrutor);

        Optional<Instrutor> instrutorEncontrado =
                instrutorDAO.buscarPorId(instrutor.getId());

        instrutorEncontrado.ifPresent(i ->
                System.out.println("Instrutor: " + i.getNome()));

        // ==========================
        // CURSO
        // ==========================

        Curso curso = new Curso();
        curso.setTitulo("Java Avançado");
        curso.setDescricao("Curso completo de Java");
        curso.setCargaHoraria(40.0);
        curso.setPreco(399.90);
        curso.setNivel("Avançado");
        curso.setStatus("Ativo");
        curso.setUrl("https://curso.com/java");
        curso.setInstrutor(instrutor);

        cursoDAO.salvar(curso);

        Optional<Curso> cursoEncontrado =
                cursoDAO.buscarPorId(curso.getId());

        cursoEncontrado.ifPresent(c ->
                System.out.println("Curso: " + c.getTitulo()));

        // ==========================
        // AULA 1
        // ==========================

        Aula aula1 = new Aula();
        aula1.setTitulo("Introdução");
        aula1.setDescricao("Primeira aula");
        aula1.setDuracaoMinutos(30);
        aula1.setOrdem(1);
        aula1.setUrlVideo("https://video1.com");
        aula1.setCurso(curso);

        aulaDAO.salvar(aula1);

        // ==========================
        // AULA 2
        // ==========================

        Aula aula2 = new Aula();
        aula2.setTitulo("POO");
        aula2.setDescricao("Programação Orientada a Objetos");
        aula2.setDuracaoMinutos(45);
        aula2.setOrdem(2);
        aula2.setUrlVideo("https://video2.com");
        aula2.setCurso(curso);

        aulaDAO.salvar(aula2);

        // ==========================
        // BUSCAS
        // ==========================

        List<Curso> cursos =
                cursoDAO.buscarPorTitulo("Java");

        System.out.println("\nCursos encontrados:");

        cursos.forEach(c ->
                System.out.println(c.getTitulo()));

        List<Aula> aulas =
                aulaDAO.buscarPorOrdem(1);

        System.out.println("\nAulas encontradas:");

        aulas.forEach(a ->
                System.out.println(a.getTitulo()));

        // ==========================
        // ATUALIZAÇÃO
        // ==========================

        curso.setPreco(299.90);
        cursoDAO.atualizar(curso);

        System.out.println("\nCurso atualizado!");

        // ==========================
        // REMOÇÃO
        // ==========================

        aulaDAO.remover(aula1.getId());
        aulaDAO.remover(aula2.getId());

        cursoDAO.remover(curso.getId());

        instrutorDAO.remover(instrutor.getId());

        System.out.println("\nDados removidos com sucesso!");

        DBFactory.fechar();
    }
}