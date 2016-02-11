<%-- 
    Document   : viewGrade
    Created on : 04-Feb-2016, 22:32:42
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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        
        
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
                out.print( treatmentItem.fetchScore( lookup.getStudentID(), treatmentItem.fetchStudentName(lookup.getStudentID()), treatmentItem.getTreatmentID()) );       
           
        }                 
        %>
           
        </div>    
        </div>
        </div>
</div>
</div>
    </body>
</html>
