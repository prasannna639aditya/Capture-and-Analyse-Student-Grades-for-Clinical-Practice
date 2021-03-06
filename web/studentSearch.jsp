<%-- 
    Document   : test
    Created on : 15-Feb-2016, 10:44:35
    Author     : Delaney
--%>

<%@page import="summaryData.StudentTreatmentSummaryData"%>
<%@page import="application.TreatmentItems"%>
<%@page import="guipackage.SearchBox"%>
<%@page import="summaryData.GroupSummaryData"%>
<%@page import="summaryData.StudentSummaryData"%>
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
        <link href="css/table.css" rel="stylesheet">
        <link href="css/dropdown.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="js/Chart.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

        <title>Student Summary Data</title>


    </head>
    <body>

        <jsp:useBean id="search" class="guipackage.SearchBox" scope="request" />
        <jsp:setProperty name="search" property="*" />


        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          out.print(gui.tutorNavigation());
          StudentSummaryData check = new StudentSummaryData();
          GroupSummaryData group = new GroupSummaryData();
          TreatmentItems name = new TreatmentItems();
          StudentTreatmentSummaryData data = new StudentTreatmentSummaryData();
          StudentLookup lookup = new StudentLookup();
          
          
          String studentID = search.getStudentID();
          if( search.getStudentID() == null || studentID.length() != 9) {
           out.print(gui.paragraph2("Please enter a valid student ID."));
          }
          else{
            if( name.hasPerformedTreatments(studentID) == false){
                out.print(gui.paragraph2(name.fetchStudentName(gui.getStudentID()) + " has not performed any treatments yet."));
            }

            else{
        %>
        <p>
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="nav active"><a href="#A" data-toggle="tab">Domain Summary Data</a></li>
                <li class="nav"><a href="#B" data-toggle="tab">Treatment Summary Data</a></li>
                <li class="nav"><a href="#C" data-toggle="tab">Treatment Scores</a></li>
                <li class="nav"><a href="#D" data-toggle="tab">Patients Treated</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="A">
                    <%
                          //String student = (String)request.getParameter("student");
                    %>
                    <p>
                        <%
                             out.println("See the domain summary data for " + name.fetchStudentName(search.getStudentID()));
             
                        %>
                    </p>
                    <p>
                        <%
                             out.print(search.studentData(search.getStudentID()));
                             out.print( search.toBarChart(search.getStudentID()));
                        %>
                    </p>
                </div>
                <div class="tab-pane fade" id="B">
                    <%
                         out.print(data.studentData(search.getStudentID()));
                          // out.println(search.getStudentID());
             
          
                    %>

                </div>  

                <div class="tab-pane fade" id="C">
                    <div id="closer">
                        <%
                             out.print(name.fetchMyTreatments(search.getStudentID()));
              
              
                        %>
                    </div> 
                </div>  

                <div class="tab-pane fade" id="D">

                    <%
                         out.print(name.selectAllPatients(search.getStudentID()));
              
                            }
                      }  
                    %>

                </div> 

            </div>
        </div>      
        <%
          
          out.print(gui.footer());
        %> 
    </p>
</body>
</html>