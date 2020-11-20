<%-- 
    Document   : error
    Created on : 21/08/2020, 09:52:03 AM
    Author     : brayan
--%>
<%
    String error = (String) request.getSession().getAttribute("error");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Ha ocurrido un error: <%=error%></h1>
    </body>
</html>
