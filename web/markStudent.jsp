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
        <meta charset="utf-8">
        <meta name="robots" content="noindex">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/sidebar.css" rel="stylesheet">
        <link href="css/dropdown.css" rel="stylesheet">
        <link href="css/extras.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
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
                   out.print( core.buttonNav()); 
                   out.print( core.markingForm( TutorID, treatment.getStudentID(), treatment.getTreatmentID()) );
                   if(treatment.isAbsent(attendance) == true)
                   {
                       out.print(attendance);
                   }
                   
                }
                else {
                   if(core.getPassword() != ""){
                    if( core.validateStudent( request ) ) {
                        core.markStudent();
                        out.print( "<p>You have successfully graded </p>" + treatment.fetchStudentName(core.getStudentID()) + ".</p>"  );
                        //out.print( "<p>Treatment </p>" + treatment.fetchTreatmentName(treatment.getTreatmentID()) + ".</p>"  );
                       // out.print( treatment.clinicalAlert(core.getStudentID(),treatment.getTreatmentID()));
                        out.print( "<p><a href='tutorWelcome.jsp'>Back to home!</a></p>" );
                    }
                   }
                    else{
                        out.print( core.buttonNav()); 
                        out.print( core.printErrors( ) );
                        out.print( core.markingForm( TutorID, treatment.getStudentID(),treatment.getTreatmentID() ) );
                        
                    }
                }
               out.print(gui.footer());   
            %>
    </body>
</html>
