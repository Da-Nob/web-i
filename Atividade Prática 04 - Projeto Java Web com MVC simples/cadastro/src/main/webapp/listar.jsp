<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="pt-BR">
<head>
    <title>Listagem de usuários</title>
</head>
<body>

    <table border="1px solid #ccc">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </tr>
        
   
    
    <c:forEach var="usuario" items="${usuarios}" >
        <tr>
            <td> ${usuario.getId()} </td>
            <td> ${usuario.getNome()} </td>
            <td> ${usuario.getEmail()} </td>
        </tr>
    </c:forEach>

    </table>

    

    <a href="index.html">Voltar para o formulário</a>

</body>
</html>