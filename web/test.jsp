<%-- 
    Document   : test
    Created on : 05-Mar-2016, 21:31:35
    Author     : Delaney
--%>

<%@page import="summaryData.StudentTreatmentSummaryData"%>
<%@page import="summaryData.TreatmentSummaryData"%>
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
    
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="nav active"><a href="#A" data-toggle="tab">A</a></li>
                <li class="nav"><a href="#B" data-toggle="tab">B</a></li>
                <li class="nav"><a href="#C" data-toggle="tab">C</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade in active" id="A">Content inside tab A</div>
                <div class="tab-pane fade" id="B">Content inside tab B</div>
                <div class="tab-pane fade" id="C">Content inside tab C</div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<%
          GUI gui = new GUI( );
          if( session.getAttribute( "Authenticated" ) != null ) {
                TreatmentSummaryData data = new TreatmentSummaryData();
                StudentTreatmentSummaryData student = new StudentTreatmentSummaryData();
                out.print(data.studentData());
                out.print(student.studentData("119876543"));
          }
        %>
</body>
</html>