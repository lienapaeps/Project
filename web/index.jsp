<%@ page import="domain.model.Film" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="style/style.css">
  <title>Home</title>
</head>
  <body>
  <header id="index">
    <nav id="indexNav">
      <ul>
        <li><a id="current" href="FilmInfo?command=home">Home</a></li>
        <li><a href="voegToe.jsp">Voeg toe</a></li>
        <li><a href="FilmInfo?command=overview">Overzicht</a></li>
        <li><a href="zoek.jsp">Zoek</a></li>
      </ul>
    </nav>
    <h1 class="titel">Film bibliotheek</h1>
  </header>

  <main>
    <h2 id="welkom">Welkom</h2>
    <p>Beste filmliefhebbers! Hier kunnen jullie je favoriete films toevoegen en beoordelen.</p>
    <p>De film met de langste speelduur is <strong>${langsteSpeelduur.titel}</strong>.</p>
  </main>

  <jsp:include page="footer.jsp"/>
  </body>
</html>