<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="UTF-8">
  <title>Dashboard de ingressos</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>

<div>
  <h1>Dashboard de Ingresssos</h1>
  <button class="buttons"><a href="../index.html">Home</a></button>
  <table>
    <tr>
      <th>Id</th>
      <th>Evento</th>
      <th>Data</th>
      <th>Local</th>
      <th>Assento</th>
      <th>Valor</th>
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
          <form action="/delete-ingresso" method="post">
            <input type="hidden" id="id" name="id" value="${ingresso.id}">
            <button type="submit">Excluir</button>
            <span>|</span>
            <a href="/telas/update.jsp?id=${ingresso.id}&evento=${ingresso.evento}&data=${ingresso.data}&local=${ingresso.local}&assento=${ingresso.assento}&valor=${ingresso.valor}">Editar</a>

          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
