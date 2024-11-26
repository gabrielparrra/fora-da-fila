<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Usuário</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<div class="card-login">
<h1 class="text-card">Atualizar Usuário</h1>
<form action="/updateUsuarioServlet" method="post">

    <div class="form-group">
    <input type="hidden" name="id" value="${param.id}" class="input">
    <label for="email">Email:</label>
    <input type="text" name="email" id="email" value="${param.email}" required class="input" style="width: 350px;><br>
    </div>

    <div class="form-group">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" value="${param.nome}" required class="input" style="width: 350px;><br>
    </div>

    <div class="form-group">
    <label for="cpf">CPF:</label>
    <input type="text" name="cpf" id="cpf" value="${param.cpf}" required class="input" style="width: 350px;><br>
    </div>

    <div class="form-group">
    <label for="password">Senha:</label>
    <input type="password" name="password" id="password" value="${usuario.password}" required class="input" style="width: 350px;><br>
    </div>

    <div class="form-group">
    <label for="tipo">Tipo:</label>
    <select name="tipo" id="tipo">
        <option value="usuario" ${usuario.tipo == 'usuario' ? 'selected' : ''}>Usuário</option>
        <option value="admin" ${usuario.tipo == 'admin' ? 'selected' : ''}>Admin</option>
    </select><br>
        <div class="form-group">

    <button type="submit" class="buttons" style="margin-top: 20px;">Atualizar</button>

</form>
</div>
</body>
</html>
