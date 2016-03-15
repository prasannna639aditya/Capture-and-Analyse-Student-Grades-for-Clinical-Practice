<%-- 
    Document   : updateStudentPassword
    Created on : 13-Mar-2016, 20:04:24
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
<%@page import="admin.AdminLogin"%>
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
        <link href="../css/sidebar.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="../js/sidebar.js"></script>
        <link href="../css/extras.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Change a students password</title>


    </head>
    <body>

        <jsp:useBean id="update" class="admin.updateStudentPassword" scope="request" />
        <jsp:setProperty name="update" property="*" />

        <%      
                GUI gui = new GUI();
                TreatmentItems treatment = new TreatmentItems();
                out.print(gui.adminNavigation());
                if( request.getParameter( "submit" ) == null ) {

                    out.print( update.updateForm( ) );
                }
                else {
                    if( update.validateUpdateForm( ) ) {
                        out.print( gui.paragraph2("<p>You have successfully updated " + treatment.fetchStudentName(update.getStudentID()) + "s password.</p>") );
                        out.print( "<p id=\"home\"><a href='adminWelcome.jsp'>Back to home!</a></p>" );
                    }
                    else{
                        out.print( update.updateForm( ) );
                        out.print( update.printErrors( ) );
                    }
                }
                out.print(gui.footer());
        %>

    </body>
</html>
