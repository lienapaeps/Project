<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 16:32
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
    <title>Zoek een film</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="zoek"/>
    <jsp:param name="head" value="Zoek film"/>
</jsp:include>
<main>

    <form method="GET" action="FilmInfo" novalidate>
        <p class="vraag">Welke film zoek je?</p>
        <label for="titel">Titel:</label>
        <input type="text" id="titel" name="titel" value="" required>

        <input type="hidden" name="command" value="zoek">

        <label for="zoek"></label>
        <input type="submit" id="zoek" value="Zoek Film">
    </form>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>
