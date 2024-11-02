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
    <table>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
            <th>Senha</th>
            <th>Tipo</th>
            <th>Excluir</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.email}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.nascimento}</td>
                <td>${usuario.password}</td>
                <td>${usuario.tipo}</td>
                <td>
                    <form action="/delete-usuario" method="post">
                        <input type="hidden" id="id" name="id" value="${usuario.id}">
                        <button type="submit">Excluir</button>
                        <span>|</span>
                        <a href="cadastro.jsp">Update</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
