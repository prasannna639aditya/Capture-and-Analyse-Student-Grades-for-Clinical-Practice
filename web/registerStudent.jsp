<%-- 
    Document   : registerStudent
    Created on : Dec 26, 2015, 1:15:44 PM
    Author     : Delaney
--%>

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
            <jsp:useBean id="register" class="application.RegisterStudent" scope="request" />
            <jsp:setProperty name="register" property="*" />
            
            
        
            <%
                GUI gui = new GUI( );
                out.print( gui.tutorNavigation( ));
                
                if( request.getParameter( "submit" ) == null ) {

                    out.print( register.registrationForm( ) );
                }
                else {
                    if( register.validateRegForm( ) ) {
                        session.setAttribute( "Authenticated", register.getStudentID( ) );
                        out.print( "<p>You have successfully registered a student!</p>" );
                        out.print( "<p><a href='tutorWelcome.jsp'>Back to home!</a></p>" );
                    }
                    else{
                        out.print( register.registrationForm( ) );
                        out.print( register.printErrors( ) );
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
