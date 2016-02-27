<%-- 
    Document   : groupSearch
    Created on : 26-Feb-2016, 15:56:19
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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/landing-page.css" rel="stylesheet">
        <link href="../css/simple-sidebar.css" rel="stylesheet">
        <link href="../css/dropdown.css" rel="stylesheet">
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        
        <!--- Site CSS -->
        <link rel="stylesheet" type="text/css" href="../js/components/reset.css">
        <link rel="stylesheet" type="text/css" href="../js/components/site.css">
        <link rel="stylesheet" type="text/css" href="../js/components/grid.css">

        <!--- Component CSS -->
        <link rel="stylesheet" type="text/css" href="../js/components/icon.css">
        <link rel="stylesheet" type="text/css" href="../js/components/input.css">
        <link rel="stylesheet" type="text/css" href="../js/components/button.css">
        <link rel="stylesheet" type="text/css" href="../js/components/divider.css">
        <link rel="stylesheet" type="text/css" href="../js/components/label.css">
        <link rel="stylesheet" type="text/css" href="../js/components/dropdown.css">
        <link rel="stylesheet" type="text/css" href="../js/components/transition.css">
        <link rel="stylesheet" type="text/css" href="../js/components/popup.css">

        <!--- Component JS -->
        <script src="../js/library/jquery.min.js"></script>
        <script src="../js/library/iframe-content.js"></script>
        <script type="text/javascript" src="../js/components/popup.js"></script>
        <script type="text/javascript" src="../js/components/dropdown.js"></script>
        <script type="text/javascript" src="../js/components/transition.js"></script>
        <script>
        $(document)
          .ready(function() {
            $('.ui.dropdown')
              .dropdown({
                on: 'click'
              })
            ;
          })
        ;
        </script>
        
        <title>Group Search</title>
        
        
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
          
          out.println(search.groupSearchBox());
          
          /**String studentID = search.getStudentID();
          if( search.getStudentID() == null || studentID.length() != 9) {
           out.println("Please enter a valid student ID.");
          }
          else{
            //String student = (String)request.getParameter("student");
           out.println("See the summary data for" + name.fetchStudentName(search.getStudentID()));
           out.print(search.studentData(search.getStudentID()));
            // out.println(search.getStudentID());
          }**/
        %> 
           
               
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>
