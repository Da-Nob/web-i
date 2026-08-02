package com.daniel.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo", nullable = false, length = 100)
  private String titulo;

  @Column(name = "descricao", nullable = false, length = 500)
  private String descricao;

  @Column(name = "carga_horaria", nullable = false)
  private Double cargaHoraria;

  @Column(name = "preco", nullable = false)
  private Double preco;

  @Column(name = "nivel", nullable = false, length = 50)
  private String nivel;

  @Column(name = "url", nullable = false, length = 200)
  private String url;

  @Column(name = "status", nullable = false, length = 50)
  private String status;

  @ManyToOne
  @JoinColumn(name = "instrutor_id", nullable = false)
  private Instrutor instrutor;

  
  @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Aula> aulas = new ArrayList<>();

  public Curso() {
  }

  

}
