package com.atividade3.form_login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nome = req.getParameter("usuario");
       String senha = req.getParameter("senha");

       if (nome == "" || nome.isEmpty() || senha == "" || senha.isEmpty()) {
        resp.setContentType(("text/html; charset=UTF-8"));
        resp.getWriter().print("Crendenciais estão vazias, tente novamente!");
       } else {
        if ("admin".equals(nome) && "admin123".equals(senha)) {
            req.setAttribute("userName", nome);
            req.setAttribute("senha", senha);
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.jsp");
            resp.getWriter().print("usuario ou senha invalidos");
        }
       }
    }
}
