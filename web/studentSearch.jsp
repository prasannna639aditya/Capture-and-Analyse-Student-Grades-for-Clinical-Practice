<%-- 
    Document   : test
    Created on : 15-Feb-2016, 10:44:35
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
<%@page import="guipackage.SearchBox"%>
<%@page import="summaryData.StudentYearlySummaryData"%>
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
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
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
          StudentYearlySummaryData year = new StudentYearlySummaryData();
          TreatmentItems name = new TreatmentItems();
          
          
          String studentID = search.getStudentID();
          if( search.getStudentID() == null || studentID.length() != 9) {
           out.println("Please enter a valid student ID.");
          }
          else{
            if( name.hasPerformedTreatments(studentID) == false){
                out.println(name.fetchStudentName(gui.getStudentID()) + " has not performed any treatments yet.");
            }

            else{
              //String student = (String)request.getParameter("student");
             out.println("See the summary data for" + name.fetchStudentName(search.getStudentID()));
             out.print(search.studentData(search.getStudentID()));
              // out.println(search.getStudentID());
            }
          }
          out.print(gui.footer());
        %> 
           
               
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>