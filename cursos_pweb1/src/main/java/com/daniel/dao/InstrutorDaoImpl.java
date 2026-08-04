package com.daniel.dao;

import java.util.List;
import java.util.Optional;

import com.daniel.entities.Instrutor;

public class InstrutorDAOImpl implements GenericDAO<Instrutor, Long> {

  @Override
  public Instrutor salvar(Instrutor entidade) {
    // Implementação do método salvar utilizando o EntityManager
  }

  @Override
  public Optional<Instrutor> buscarPorId(Long id) {
    // Implementação do método buscarPorId utilizando o EntityManager
  }

  @Override
  public List<Instrutor> buscarTodos() {
    // Implementação do método buscarTodos utilizando o EntityManager
  }

  @Override
  public Instrutor atualizar(Instrutor entidade) {
    // Implementação do método atualizar utilizando o EntityManager
  }

  @Override
  public void remover(Long id) {
    // Implementação do método remover utilizando o EntityManager
  }

}
