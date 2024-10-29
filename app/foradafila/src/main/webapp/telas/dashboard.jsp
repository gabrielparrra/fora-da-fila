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
        <c:forEach var="Cadastro" items="${usuarios}">
            <tr>
                <td>${usuarios.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
