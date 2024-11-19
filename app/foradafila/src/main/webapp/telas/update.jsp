<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Usuário</title>
</head>
<body>
<h1>Atualizar Usuário</h1>
<form action="/updateUsuarioServlet" method="post">
    <input type="hidden" name="id" value="${usuario.id}">
    <label for="email">Email:</label>
    <input type="text" name="email" id="email" value="${usuario.email}" required><br>

    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" value="${usuario.nome}" required><br>

    <label for="cpf">CPF:</label>
    <input type="text" name="cpf" id="cpf" value="${usuario.cpf}" required><br>

    <label for="nascimento">Data de Nascimento:</label>
    <input type="date" name="nascimento" id="nascimento" value="${usuario.nascimento}" required>


    <label for="password">Senha:</label>
    <input type="password" name="password" id="password" value="${usuario.password}" required><br>

    <label for="tipo">Tipo:</label>
    <select name="tipo" id="tipo">
        <option value="usuario" ${usuario.tipo == 'usuario' ? 'selected' : ''}>Usuário</option>
        <option value="admin" ${usuario.tipo == 'admin' ? 'selected' : ''}>Admin</option>
    </select><br>

    <button type="submit">Atualizar</button>
</form>
</body>
</html>
