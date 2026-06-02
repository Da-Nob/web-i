package com.example.cadastro.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.example.cadastro.model.Usuario;
import com.example.cadastro.model.UsuarioService;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    private static final UsuarioService service = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");

        if (nome == "" || nome.isEmpty() || email == "" || email.isEmpty()) {
            // resp.setContentType(("text/html; charset=UTF-8"));
            // resp.getWriter().print("As credenciais estão vazias");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.setAttribute("mensagem", "Nome e email são obrigatórios.");
            // req.getRequestDispatcher("/erro.jsp").forward(req, resp);

        } else if (service.jaExiste(nome, email)) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            req.getRequestDispatcher("/erro.jsp").forward(req, resp);

        } else {
            Usuario novoUsuario = service.cadastrar(nome, email);
            req.setAttribute("usuarios", service.listar());

            req.getRequestDispatcher("/listar.jsp").forward(req, resp);
        }
            
    }
        
}
