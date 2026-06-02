package com.example.cadastro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UsuarioService {
    private static final List<Usuario> usuarios = new ArrayList<>();

    private static final AtomicLong CONTADOR_ID = new AtomicLong(1);

    public Usuario cadastrar(String nome, String email) {
        Usuario novoUsuario = new Usuario(nome, email);
        long id = CONTADOR_ID.getAndIncrement();

        novoUsuario.setId(id);

        usuarios.add(novoUsuario);

        return novoUsuario;
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public boolean jaExiste(String nome, String email) {
        for (Usuario usuario: usuarios) {
            if (usuario.getNome().contains(nome) || usuario.getEmail().contains(email)) {
                return true;
            }
        }
        return false;
    }

}
