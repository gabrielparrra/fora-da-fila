<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Evento</title>
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
    <h2 class="text-card">Cadastro de Evento</h2>
    <form action="/createEventoServlet" method="post">

      <!-- Campo do nome do evento -->
      <div class="form-group">
        <label for="evento"></label>
        <input type="text" name="evento" id="evento" class="input" placeholder="Nome do Evento" required>
      </div>

      <!-- Campo da data -->
      <div class="form-group">
        <label for="data"></label>
        <input type="date" name="data" id="data" class="input" placeholder="Data" required>
      </div>

      <!-- Campo do local -->
      <div class="form-group">
        <label for="local"></label>
        <input type="text" name="local" id="local" class="input" placeholder="Local" required>
      </div>

      <!-- Campo do assento -->
      <div class="form-group">
        <label for="assento"></label>
        <input type="text" name="assento" id="assento" class="input" placeholder="Assento" required>
      </div>

      <!-- Campo do valor -->
      <div class="form-group">
        <label for="valor"></label>
        <input type="text" name="valor" id="valor" class="input" placeholder="Valor" required>
      </div>

      <button type="submit" class="buttons">Cadastrar Evento</button>

    </form>
  </section>
</div>

<footer>
  <p></p>
</footer>
</body>
</html>
