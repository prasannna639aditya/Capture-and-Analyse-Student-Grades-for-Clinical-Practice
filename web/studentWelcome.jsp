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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Welcome to your Student Portal</title>
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String username = (String) session.getAttribute( "Authenticated" );
                String firstName = (String) session.getAttribute( "firstName" );
                String lastName = (String) session.getAttribute( "lastName" );
                out.print(gui.header(true, firstName, lastName));
          }
        %>
    </body>
</html>
