<%@ page import="domain.model.Film" %><%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Film film = (Film) request.getAttribute("film"); %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
    <title>Gevonden</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="head" value="Zoek resultaten"/>
</jsp:include>
<main>
    <p>Je vroeg naar volgende gegevens: <%= film.getInfo()%></p>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>
