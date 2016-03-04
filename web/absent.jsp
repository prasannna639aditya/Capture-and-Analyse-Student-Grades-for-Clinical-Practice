<%-- 
    Document   : markStudent
    Created on : Jan 3, 2016, 9:17:15 PM
    Author     : Delaney
--%>

<%@page import="guipackage.SearchBox"%>
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
    
        <title>Absent</title>
    </head>
    <body>
        
        <div class="login-card">          
            <jsp:useBean id="core" class="application.CoreSkills" scope="request" />
            <jsp:setProperty name="core" property="*" />
            <jsp:useBean id="lookup" class="application.StudentLookup" scope="request" />
            <jsp:setProperty name="lookup" property="*" />
            <jsp:useBean id="treatment" class="application.TreatmentItems" scope="request" />
            <jsp:setProperty name="treatment" property="*" />
            <jsp:useBean id="search" class="guipackage.SearchBox" scope="request" />
            <jsp:setProperty name="search" property="*" />
            
            
        
            <%
                GUI gui = new GUI( );
                StudentLookup studentLookup = new StudentLookup();
                out.print( gui.tutorNavigation( ));
                String TutorID = (String) session.getAttribute( "TutorID" );
                String attendance = treatment.getAttendance();
                String absent = "absent";
                
              
                  if( request.getParameter( "submit" ) == null ) {
                        treatment.markStudentAbsent(treatment.getStudentID(), TutorID, treatment.getTreatmentID());
                        out.print( "<p>You have marked </p>" + treatment.fetchStudentName(treatment.getStudentID()) + " absent.</p>"  );
                        //out.print( "<p>Treatment </p>" + treatment.fetchTreatmentName(treatment.getTreatmentID()) + ".</p>"  );
                       // out.print( treatment.clinicalAlert(core.getStudentID(),treatment.getTreatmentID()));
                        out.print( "<p><a href='tutorWelcome.jsp'>Back to home!</a></p>" );
                  
                }
            %>
        
        
        </div>    
        </div>
        </div>
</div>
</div>
    </body>
</html>