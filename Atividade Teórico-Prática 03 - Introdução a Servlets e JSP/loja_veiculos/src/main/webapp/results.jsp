<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Loja veiculo</title>
  </head>
  <body>
    <h1> Valores pos calculos</h1>
    <p>Valor Veiculo <%= request.getAttribute("valor") %></p>
    <p>Entrada <%= request.getAttribute("entrada") %></p>
    <p>juros <%= request.getAttribute("juros") %>%</p>
    <p>prazo <%= request.getAttribute("prazo") %></p>
    <p>Financiamento <%= request.getAttribute("financiamento") %></p>
    <p>PMT <%= request.getAttribute("pgto_mensal") %></p>

  </body>
</html>