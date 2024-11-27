<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="UTF-8">
  <title>Dashboard de Ingressos</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<div>
  <h1>Dashboard de Ingressos</h1>
  <button class="buttons"><a href="../index.html">Home</a></button>
  <table>
    <tr>
      <th>Id</th>
      <th>Evento</th>
      <th>Data</th>
      <th>Local</th>
      <th>Assento</th>
      <th>Valor</th>
      <th>Ações</th>
    </tr>
    <c:forEach var="ingresso" items="${ingresso}">
      <tr>
        <td>${ingresso.id}</td>
        <td>${ingresso.evento}</td>
        <td>${ingresso.data}</td>
        <td>${ingresso.local}</td>
        <td>${ingresso.assento}</td>
        <td>${ingresso.valor}</td>
        <td>
          <form action="/delete-ingresso" method="post" style="display: inline;">
            <input type="hidden" id="id" name="id" value="${ingresso.id}">
            <button type="submit" class="buttons">Excluir</button>
          </form>
          <span>|</span>
          <a href="/telas/update-ingresso.jsp?id=${ingresso.id}&evento=${ingresso.evento}&data=${ingresso.data}&local=${ingresso.local}&assento=${ingresso.assento}&valor=${ingresso.valor}" class="buttons">Editar</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
