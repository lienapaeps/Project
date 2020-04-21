<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Film" %>
<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
    <title>Film overzicht</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value="overzicht"/>
    <jsp:param name="head" value="Film bibliotheek"/>
</jsp:include>

<main>
    <table>
        <thead>
        <tr>
            <th>Titel</th>
            <th>Genre</th>
            <th>Speelduur</th>
            <th>Rating (/10)</th>
            <th>Verwijder</th>
        </tr>
        </thead>
        <tbody>

        <c:choose>
            <c:when test="${not empty alleFilms}">
                <c:forEach var="film" items="${alleFilms}">

        <tr>
            <td>${film.titel}</td>
            <td>${film.genre}</td>
            <td>${film.speelduur}</td>
            <td>${film.rating}</td>
            <td><a href="FilmInfo?command=delete&titel=${film.titel}&genre=${film.genre}&speelduur=${film.speelduur}&rating=${film.rating}">Verwijder</a></td>
        </tr>
                </c:forEach>
        </tbody>
    </table>

    </c:when>
    <c:otherwise>
        <p>Er zijn nog geen films toegevoegd.</p>
    </c:otherwise>
    </c:choose>

    <br>
    <a id="voegtoe" href="voegToe.jsp">Voeg een nieuwe film toe</a>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>
