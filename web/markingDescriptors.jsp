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
        <title>Marking Descriptors</title>

   
    
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          CoreSkills core = new CoreSkills();
          
                out.print(gui.tutorNavigation());
                out.print(core.markingDescriptors());
             
        %>
        
    
    </body>
</html>
