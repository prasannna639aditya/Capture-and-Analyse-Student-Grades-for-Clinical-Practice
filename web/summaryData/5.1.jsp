<%-- 
    Document   : 5.1
    Created on : 06-Mar-2016, 20:48:53
    Author     : Delaney
--%>

<%@page import="summaryData.StudentYearlySummaryData"%>
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
        <link href="../css/sidebar.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="../js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <tite> Group 5.1 Summary Data</title>
    </head>
    <body
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          StudentYearlySummaryData year = new StudentYearlySummaryData();
          out.print(gui.tutorSummaryNavigation2());
                out.print(year.studentData("5.1"));
          out.print(gui.footer());  
        %>   
        
    </body>
</html>