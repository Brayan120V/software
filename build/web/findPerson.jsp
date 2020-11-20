<%-- 
    Document   : findPerson
    Created on : 18/11/2020, 05:59:34 PM
    Author     : brayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar persona</h1>
        <form action="person" method="get">
            <input name="cardid" placeholder="Identificación" > </input>
            <input type="submit" value="Buscar" />
        </form>
    </body>
</html>
