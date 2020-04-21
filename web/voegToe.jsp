<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Film toevoegen</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value="voegToe"/>
    <jsp:param name="head" value="Voeg een film toe"/>
</jsp:include>

<main>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <form method="POST" action="FilmInfo?command=add" novalidate>
        <label for="titel">Titel: *</label>
        <input type="text" name="titel" id="titel" value="${titelPreviousValue}" required>

        <label for="genre">Genre: *</label>
        <select id="genre" name="genre" value="${genrePreviousValue}" required>
            <option hidden disabled selected value>Selecteer genre</option>
            <option value="Actie">Actie</option>
            <option value="Animatie">Animatie</option>
            <option value="Avontuur">Avontuur</option>
            <option value="Doc">Documentaire</option>
            <option value="Drama">Drama</option>
            <option value="Fantasy">Fantasy</option>
            <option value="Historisch">Historisch</option>
            <option value="Horror">Horror</option>
            <option value="Kind">Kind</option>
            <option value="Komedie">Komedie</option>
            <option value="Misdaad">Misdaad</option>
            <option value="Mysterie">Mysterie</option>
            <option value="Oorlog">Oorlog</option>
            <option value="Sf">Sciencefiction</option>
            <option value="Thriller">Thriller</option>
        </select>

        <label for="speelduur">Speelduur: *</label>
        <input type="number" name="speelduur" value="${speelduurPreviousValue}" id="speelduur" required>

        <label for="rating">Rating: * (tussen 0 en 10)</label>
        <input type="number" id="rating" name="rating" value="${ratingPreviousValue}" required>

        <input type="submit" id="submit" value="Voeg toe">
    </form>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>
