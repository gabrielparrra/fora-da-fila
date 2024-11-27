<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Atualizar Evento</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<div class="card-login">
  <h1 class="text-card">Atualizar Evento</h1>
  <form action="/update-evento" method="post">

    <!-- Campo oculto para o ID do evento -->
    <div class="form-group">
      <input type="hidden" name="id" value="${param.id}" class="input">
    </div>

    <!-- Campo para o nome do evento -->
    <div class="form-group">
      <label for="evento">Nome do Evento:</label>
      <input type="text" name="evento" id="evento" value="${param.evento}" required class="input" style="width: 350px;"><br>
    </div>

    <!-- Campo para a data -->
    <div class="form-group">
      <label for="data">Data:</label>
      <input type="date" name="data" id="data" value="${param.data}" required class="input" style="width: 350px;"><br>
    </div>

    <!-- Campo para o local -->
    <div class="form-group">
      <label for="local">Local:</label>
      <input type="text" name="local" id="local" value="${param.local}" required class="input" style="width: 350px;"><br>
    </div>

    <!-- Campo para o assento -->
    <div class="form-group">
      <label for="assento">Assento:</label>
      <input type="text" name="assento" id="assento" value="${param.assento}" required class="input" style="width: 350px;"><br>
    </div>

    <!-- Campo para o valor -->
    <div class="form-group">
      <label for="valor">Valor:</label>
      <input type="text" name="valor" id="valor" value="${param.valor}" required class="input" style="width: 350px;"><br>
    </div>

    <!-- Botão para atualizar -->
    <div class="form-group">
      <button type="submit" class="buttons" style="margin-top: 20px;">Atualizar</button>
    </div>

  </form>
</div>

</body>
</html>
