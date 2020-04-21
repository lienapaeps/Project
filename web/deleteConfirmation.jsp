<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 15:55
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
    <title>Bevestiging</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="head" value="Verwijder bevestiging"/>
</jsp:include>
<main>
    <p>Ben je zeker dat je de film <strong>${param.titel}</strong> wilt verwijderen?</p>
    <form action="FilmInfo?command=deleteConfirmation" method="POST" novalidate>
        <input type="hidden" name="titel" value="${param.titel}">
        <input type="submit" name="submit" value="Zeker">
        <input type="submit" name="submit" value="Toch niet">
    </form>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>
