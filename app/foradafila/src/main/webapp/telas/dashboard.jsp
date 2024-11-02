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
            <th>Email</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
            <th>Senha</th>
            <th>Tipo</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.email}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.nascimento}</td>
                <td>${usuario.password}</td>
                <td>${usuario.tipo}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
