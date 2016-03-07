<%-- 
    Document   : markingDescriptors
    Created on : 22-Feb-2016, 17:18:52
    Author     : Delaney
--%>

<%@page import="summaryData.StudentSummaryData"%>
<%@page import="application.CoreSkills"%>
<%@page import="application.TutorLogin"%>
<%@page import="application.StudentLookup"%>
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
        <title>Marking Descriptors</title>

   
    
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          CoreSkills core = new CoreSkills();
          
                out.print(gui.tutorNavigation());
        %>
        <p> </p>
        <%
                out.print(core.markingDescriptors());
                out.print(gui.footer());   
        %>
        
    
    </body>
</html>
