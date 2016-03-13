<%-- 
    Document   : summaryData
    Created on : 18-Feb-2016, 20:20:42
    Author     : Delaney
--%>


<%@page import="guipackage.SearchBox"%>
<%@page import="summaryData.AllStudentTreatmentSummary"%>
<%@page import="summaryData.GroupSummaryData"%>
<%@page import="summaryData.StudentSummaryData"%>
<%@page import="application.StudentLookup"%>
<%@page import="guipackage.GUI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Summary Data</title>
        <meta charset="utf-8">
        <meta name="robots" content="noindex">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../css/sidebar.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">
        <link href="../css/dropdown.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="../js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css"> 
    </head>
    <body>
     
        <%
          GUI gui = new GUI( );
          out.print(gui.tutorSummaryNavigation2());
          StudentLookup look = new StudentLookup();
          StudentSummaryData check = new StudentSummaryData();
          GroupSummaryData group = new GroupSummaryData();
          AllStudentTreatmentSummary data = new AllStudentTreatmentSummary();
          SearchBox search = new SearchBox();
        %> 
        <p> </p>
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
             out.println("All Student data summarised");
        %>
        </p>
        <p>
        <%
             out.print(check.studentData());
             out.print( search.toAllBarChart());
        %>
        </p>
                </div>
                <div class="tab-pane fade" id="B">
                    <p>
        <%
             out.print(data.studentData());
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