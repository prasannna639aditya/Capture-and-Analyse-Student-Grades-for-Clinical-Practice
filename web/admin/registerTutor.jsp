<%-- 
    Document   : registerTutor
    Created on : 29-Feb-2016, 17:46:12
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
        <title>Register a tutor</title>
        
        
    </head>
    <body>
            <jsp:useBean id="register" class="admin.RegisterTutor" scope="request" />
            <jsp:setProperty name="register" property="*" />
            
        <%
                GUI gui = new GUI();
                out.print(gui.adminNavigation());
                if( request.getParameter( "submit" ) == null ) {

                    out.print( register.registrationForm( ) );
                }
                else {
                    if( register.validateRegForm( ) ) {
                        session.setAttribute( "Authenticated", register.getTutorID( ) );
                        out.print( gui.paragraph2("<p>You have successfully registered " + register.getTutorID() +  "as a tutor.</p>") );
                        out.print( "<p id=\"home\"><a href='adminWelcome.jsp'>Back to home!</a></p>" );
                    }
                    else{
                        out.print( register.registrationForm( ) );
                        out.print( register.printErrors( ) );
                    }
                }
                out.print(gui.footer());
        %>
        
        
        
        
        
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script>$("#menu-toggle").click(function(e) {e.preventDefault();$("#wrapper").toggleClass("toggled");});</script>
        </div>
       </div>
      </div>
     </div>
    </div>
        
    </body>
</html>