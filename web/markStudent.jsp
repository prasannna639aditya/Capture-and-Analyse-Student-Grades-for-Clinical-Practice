<%-- 
    Document   : markStudent
    Created on : Jan 3, 2016, 9:17:15 PM
    Author     : Delaney
--%>

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
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="login-card">          
            <jsp:useBean id="core" class="application.CoreSkills" scope="request" />
            <jsp:setProperty name="core" property="*" />
            
            
        
            <%
                GUI gui = new GUI( );
                out.print( gui.navigation( ));
                String TutorID = (String) session.getAttribute( "TutorID" );
                
                if( request.getParameter( "submit" ) == null ) {
                    out.print( core.markingForm( TutorID ) );
                }
                else {
                    if( core.validateMarkingForm( ) ) {
                        core.getStudentID();
                        out.print( "<p>You have successfully graded </p>" + core.getStudentID() + ".</p>"  );
                        out.print( "<p><a href='tutorWelcome.jsp'>Back to home!</a></p>" );
                    }
                    else{
                        out.print( core.markingForm( TutorID ) );
                        out.print( core.printErrors( ) );
                    }
                }
            %>
           
        </div>    
        </div>
        </div>
</div>
</div>
    </body>
</html>
