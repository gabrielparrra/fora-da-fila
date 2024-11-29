<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Dashboard de usuarios</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<div>
    <h1>Dashboard de Usuarios</h1>
    <a href="../index.html">
        <button class="buttons">Home</button>
    </a>
    <table>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Senha</th>
            <th>Tipo</th>
            <th>Funcionalidades</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.email}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.password}</td>
                <td>${usuario.tipo}</td>
                <td>
                    <form action="/delete-usuario" method="post">
                        <input type="hidden" id="id" name="id" value="${usuario.id}">
                        <button type="submit" class="buttons-events">Excluir</button>
                        <span>|</span>
                        <a style="" href="/telas/update.jsp?id=${usuario.id}&email=${usuario.email}&nome=${usuario.nome}&cpf=${usuario.cpf}&password=${usuario.password}&tipo=${usuario.tipo}">Editar</a>

                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
