<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Saudação</title>
  </head>
  <body>
    <h1>Seja bem vindo esta é uma pagina que apenas funciona se o usuario e a senham foram validos!</h1>
    <p>Olá <%= request.getAttribute("userName") %> vc é valido</p>
    <p>Credenciais</p>
    <p>Usuario: <%= request.getAttribute("userName") %></p>
    <p>Senha: <%= request.getAttribute("senha") %></p>
  </body>
</html>