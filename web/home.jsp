<%-- 
    Document   : home
    Created on : Dec 22, 2015, 9:24:22 PM
    Author     : Delaney
--%>

<%@page import="guipackage.GUI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            GUI gui = new GUI( );
            
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                System.out.println("hello");
            }
        %>  
    </body>
</html>
