<%-- 
    Document   : 3.1
    Created on : 06-Mar-2016, 20:35:03
    Author     : Delaney
--%>

<%@page import="summaryData.GroupTreatmentSummaryData"%>
<%@page import="summaryData.GroupSummaryData"%>
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
        <link href="../css/table.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="../js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    </head>
    <body
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          GroupSummaryData group = new GroupSummaryData();
          out.print(gui.tutorSummaryNavigation2());
          GroupTreatmentSummaryData data = new GroupTreatmentSummaryData();
        %>
        
        <p>
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="nav active"><a href="#A" data-toggle="tab">Domain Summary Data</a></li>
                <li class="nav"><a href="#B" data-toggle="tab">Treatment Summary Data</a></li>
            </ul>
        <div class="tab-content">
                <div class="tab-pane fade in active" id="A">
        <%
              //String student = (String)request.getParameter("student");
        %>
        <p id="top">
        <%
             out.println("See the summary data for group 3.1");
        %>
        </p>
        <p>
        <%
             out.print(group.studentData("3.1"));
        %>
        </p>
                </div>
                <div class="tab-pane fade" id="B">
                    <p>
        <%
             out.print(data.studentData("3.1"));
          
        %>
                    </p>
                </div>
            </div>
        </div>      
        <%
          
          out.print(gui.footer());
        %> 
    </p>
    </body>
</html>