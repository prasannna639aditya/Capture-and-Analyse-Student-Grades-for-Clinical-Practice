<%-- 
    Document   : studentLogin
    Created on : Dec 22, 2015, 8:05:47 PM
    Author     : Delaney
--%>
<%@page import="application.StudentLogin"%>
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
        <title>Dental School Student Login</title>
    </head>
   
    <body>

        
        
        <%
                StudentLogin login = new StudentLogin();
                
                if( request.getParameter( "submit" ) == null ){
                    out.print( login.studentLoginForm() );
                }
                else{
                    if( login.loginStudent( request )) {
                        session.setAttribute( "Authenticated", login.getStudentID( ) );
                        session.setAttribute("firstName", login.getFirstName( ) );
                        session.setAttribute("lastName", login.getLastName( ) );
                        response.sendRedirect( "studentWelcome.jsp" );
                    }
                    out.print( login.studentLoginForm( ) );
                    out.print( "Student ID or Password incorrect, pleasetry again!" );
                }
         %>
    </body>
</html>
