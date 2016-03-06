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
        <meta charset="utf-8">
        <meta name="robots" content="noindex">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/sidebar.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>View your current grades</title>
    </head>
    <body>
        
        <jsp:useBean id="treatmentItem" class="application.TreatmentItems" scope="request" />
        <jsp:setProperty name="treatmentItem" property="*" />
        
        <%
                GUI gui = new GUI( );
                StudentGrades grades = new StudentGrades(); 
          
                out.print(gui.studentNavigation());
                String StudentID = (String) session.getAttribute( "StudentID" );
                out.print( treatmentItem.fetchMyTreatments( StudentID ) );
                
                out.print(gui.footer());
        %>
    </body>
</html>
