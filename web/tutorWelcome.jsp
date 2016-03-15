<%-- 
    Document   : tutorWelcome
    Created on : Dec 24, 2015, 8:19:29 PM
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
<%@page import="guipackage.SearchBox"%>
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
        <link href="css/welcome.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Welcome Tutor</title>



    </head>
    <body>
        <%
          GUI gui = new GUI( );
          TutorLogin tutor = new TutorLogin();
          CoreSkills core = new CoreSkills();
          StudentSummaryData check = new StudentSummaryData();
          SearchBox search = new SearchBox();
          
          StudentLookup look = new StudentLookup();
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String username = (String) session.getAttribute( "Authenticated" );
                String firstName = (String) session.getAttribute( "firstName" );
                String TutorID = (String) session.getAttribute( "TutorID" );
                String lastName = (String) session.getAttribute( "lastName" );
                String department = (String) session.getAttribute( "department" );
                String picture = (String) session.getAttribute( "picture" );
                out.print(gui.tutorNavigation());
                out.print(gui.tutorDisplay(TutorID, firstName, lastName));
                out.print(search.showTutorsGroups(TutorID));
                
                out.print(gui.footer());
                
                
                //out.print(search.selectTodaysGroup("test"));
                //out.print(core.markingDescriptors());
                /**out.print(check.showCore(1));
                out.print(check.showBasic(1));
                out.print(check.showProfessionalism(1));
                out.print(check.showCommunication(1));
                out.print(check.showKnowledge(1));
                out.print(check.studentData**/
          }
        %>



    </body>
</html>
