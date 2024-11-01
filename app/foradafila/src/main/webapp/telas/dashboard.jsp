<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
<div>
    <h1>Usuarios</h1>
    <table>
        <tr>
            <th>Email</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.email}</td>
            </tr>
            <tr>
                <th>Nome</th>
            </tr>
            <tr>
                <td>${usuario.nome}</td>
            </tr>
            <tr>
                <th>CPF</th>
            </tr>
            <tr>
                <td>${usuario.cpf}</td>
            </tr>
            <tr>
                <th>Data de Nascimento</th>
            </tr>
            <tr>
                <td>${usuario.nascimento}</td>
            </tr>
            <tr>
                <th>Senha</th>
            </tr>
            <tr>
                <td>${usuario.password}</td>
            </tr>
            <tr>
                <th>Tipo</th>
            </tr>
            <tr>
                <td>${usuario.tipo}</td>
            </tr>







        </c:forEach>
    </table>
</div>
</body>
</html>
