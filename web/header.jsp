<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 21/04/2020
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav>
        <ul>
            <li><a href="FilmInfo?command=home">Home</a></li>
            <li ${param.actual eq 'voegToe' ? "id=actual" : "" }>
                <a href="voegToe.jsp">Voeg toe</a></li>
            <li ${param.actual eq 'overzicht' ? "id=actual" : "" }>
                <a href="FilmInfo?command=overview">Overzicht</a></li>
            <li ${param.actual eq 'zoek' ? "id=actual" : "" }>
                <a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
    <h1>${param.head}</h1>
</header>
