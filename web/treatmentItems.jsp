<%-- 
    Document   : treatmentItems
    Created on : Jan 14, 2016, 11:00:19 PM
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
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
        <link href="css/dropdown.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Treatment Items</title>
    </head>
    <body>
        
        <jsp:useBean id="lookup" class="application.StudentLookup" scope="request" />
        <jsp:setProperty name="lookup" property="*" />
        
        <%
          GUI gui = new GUI( );
          TreatmentItems treatmentItem = new TreatmentItems( );
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                out.print(gui.tutorNavigation());
                %>
                <h1>Periodontics</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "1" ) );
                %>
                <h1>Prevention</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "2" ) );
                %>
                <h1>Direct Restorations</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "3" ) );
                %>
                <h1>Indirect Restorations</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "4" ) );
                %>
                <h1>Endodontics</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "5" ) );
                %>
                <h1>Prosthodontics</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "6" ) );
                %>
                <h1>Tooth Whitening</h1>
                <%
                        out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "7" ) );
        
              }
                        
              session.setAttribute("attendance", treatmentItem.getAttendance( ) );
              out.print(gui.footer());
        %>
        
    </body>
</html>
