<%-- 
    Document   : viewStudentScore
    Created on : 14-Feb-2016, 17:49:15
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
<%@page import="application.StudentLookup"%>
<%@page import="application.CoreSkills"%>
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

        <title>View Score</title>
    </head>
    <body>

        <div class="login-card">          


            <jsp:useBean id="lookup" class="application.StudentLookup" scope="request" />
            <jsp:setProperty name="lookup" property="*" />
            <jsp:useBean id="treatmentItem" class="application.TreatmentItems" scope="request" />
            <jsp:setProperty name="treatmentItem" property="*" />

            <%
              GUI gui = new GUI( );
              //TreatmentItems treatmentItem = new TreatmentItems( );
                /**if( session.getAttribute( "Authenticated" ) == null ) {
                    response.sendRedirect( "index.jsp" );
                }
                else {
                    out.print(gui.tutorNavigation());
                    out.print( treatmentItem.fetchScore( lookup.getStudentID(), treatmentItem.fetchStudentName(lookup.getStudentID()), treatmentItem.getTreatmentID()) );
                }**/
            if( request.getParameter( "submit" ) == null ) {
                 out.print(gui.tutorNavigation());
                 //out.print( treatmentItem.fetchScore( lookup.getStudentID(), treatmentItem.fetchStudentName(lookup.getStudentID()), treatmentItem.getTreatmentID()) );       
                 out.print( treatmentItem.showScore(lookup.getStudentID(),treatmentItem.getTreatmentID(), treatmentItem.getPatientID(), treatmentItem.getDateAdded()));
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
