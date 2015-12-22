<%-- 
    Document   : index
    Created on : Dec 22, 2015, 2:28:28 PM
    Author     : Delaney
--%>
<%@ page import="guipackage.GUI;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Dental School Grading System</title>
    </head>
   
    <body>
        <%
          GUI loginHeader = new GUI( );  
          out.print( loginHeader.loginHeader( ) );
        %>
    </body>
</html>
