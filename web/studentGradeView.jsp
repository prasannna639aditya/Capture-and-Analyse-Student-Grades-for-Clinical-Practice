<%-- 
    Document   : studentGradeView
    Created on : Feb 3, 2016, 10:12:04 PM
    Author     : Delaney
--%>

<%@page import="application.StudentGrades"%>
<%@page import="guipackage.GUI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>View your current grades</title>
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          StudentGrades grades = new StudentGrades(); 
          
                String StudentID = (String) session.getAttribute( "StudentID" );
                grades.fetchTreatments(StudentID); 
          
        %>
    </body>
</html>
