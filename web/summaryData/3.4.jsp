<%-- 
    Document   : 3.4
    Created on : 06-Mar-2016, 20:40:57
    Author     : Delaney
--%>

<%@page import="summaryData.StudentTreatmentSummaryData"%>
<%@page import="application.TreatmentItems"%>
<%@page import="summaryData.StudentSummaryData"%>
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
        <title>Group 3.4 Summary Data</title>
    </head>
    <body>
        
        <jsp:useBean id="search" class="guipackage.SearchBox" scope="request" />
        <jsp:setProperty name="search" property="*" />
        
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          out.print(gui.tutorSummaryNavigation2());
          StudentSummaryData check = new StudentSummaryData();
          GroupSummaryData group = new GroupSummaryData();
          GroupTreatmentSummaryData data = new GroupTreatmentSummaryData();
          
          String studentID = search.getStudentID();
          
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
             out.println("See the summary data for group 3.4");
        %>
                    </p>
                    <p>
        <%
             out.print(group.studentData("3.4"));
        %>
                    </p>
                    </div>
                    <div class="tab-pane fade" id="B">
                    <p id="top">
            <%
             out.println("See the treatment summary data for group 3.4");
        %>
                    </p>
                    <p>
        <%
             out.print(data.studentData("3.4"));
            
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