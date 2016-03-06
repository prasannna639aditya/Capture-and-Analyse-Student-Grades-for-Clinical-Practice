<%-- 
    Document   : test
    Created on : 05-Mar-2016, 21:31:35
    Author     : Delaney
--%>

<%@page import="guipackage.GUI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">

    <title>Admin Side Menu  - Bootsnipp.com</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/sidebar.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/sidebar.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
</head>
<body>
	<%
          GUI gui = new GUI( );
          if( session.getAttribute( "Authenticated" ) != null ) {
                out.println(gui.tutorNavigation());
          }
        %>
</body>
</html>