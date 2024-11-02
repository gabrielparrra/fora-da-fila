<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<header>
    <a href="../index.html">
        <div class="logo">
            <img src="../img/logo.png" alt="Fora da Fila" class="logo-img">
        </div>
    </a>
    <nav>
        <ul class="menu-cabecalho">
            <li><a href="#">Shows</a></li>
            <li><a href="#">Teatro</a></li>
            <li><a href="#">Esportes</a></li>
            <li><a href="#">Eventos</a></li>
        </ul>

    </nav>
</header>
<div class="card-login">
    <section class="login-section">
        <h2 class="text-card">Cadastro</h2>
        <form action="/createUsuarioServlet" method="post">

                <!-- Campo do email -->
            <div class="form-group">
                <label for="email"></label>
                <input type="text" name="email" id="email" class="input" placeholder="Email" required>
            </div>

            <!-- Campo do nome -->
            <div class="form-group">
                <label for="nome"></label>
                <input type="text" name="nome" id="nome" class="input" placeholder="Nome" required >
            </div>

            <!-- Campo do CPF -->
            <div class="form-group">
                <label for="cpf"></label>
                <input type="text" name="cpf" id="cpf" class="input" placeholder="CPF" required >
            </div>

            <!-- Campo do nascimento -->
            <div class="form-group">
                <label for="nascimento"></label>
                <input type="text" name="nascimento" id="nascimento" class="input"
                       placeholder="Data de nascimento" required onfocus="(this.type='date')">
            </div>



            <!-- Campo da senha -->
            <div class="form-group">
                <label for="password"></label>
                <input type="password" name="password" id="password" class="input" placeholder="Senha" required >
            </div>

            <!-- Campo confirme a senha -->
            <div class="form-group">
                <label for="password_confirm"></label>
                <input type="password" name="password_confirm" id="password_confirm" class="input" placeholder="Confirme a senha" required>
            </div>

            <!-- Campo tipo de model.Cadastro -->
            <div class="form-group">
                <label for="tipo">Tipo de cadastro</label>
                <select name="tipo" id="tipo" class="select">
                    <option value="padrao" id="padrao"> </option>
                    <option value="usuario" id="usuario">Usuário</option>
                    <option value="admin" id="admin">Admin</option>
                </select>
            </div>

            <button type="submit" class="buttons">Cadastrar</button>

        </form>
    </section>
</div>

<footer>
    <p></p>
</footer>
</body>
</html>