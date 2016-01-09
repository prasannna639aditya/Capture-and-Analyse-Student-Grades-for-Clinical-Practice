<%-- 
    Document   : tutorLogin
    Created on : Dec 24, 2015, 8:16:28 PM
    Author     : Delaney
--%>
<%@page import="application.TutorLogin"%>
<%@ page import="guipackage.GUI;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Dental School Tutor Login</title>
    </head>
   
    <body>

        <div class="login-card">
            
            <h1>Welcome Tutor, Please Login</h1>
        
        <%
                TutorLogin login = new TutorLogin();
                
                if( request.getParameter( "submit" ) == null ){
                    out.print( login.tutorLoginForm() );
                }
                else{
                    if( login.loginTutor( request )) {
                        session.setAttribute( "Authenticated", login.getTutorID( ) );
                        session.setAttribute("TutorID", login.getTutorID( ) );
                        session.setAttribute("firstName", login.getFirstName( ) );
                        session.setAttribute("lastName", login.getLastName( ) );
                        session.setAttribute("department", login.getDepartment( ) );
                        session.setAttribute("picture", login.getPicture( ) );
                        response.sendRedirect( "tutorWelcome.jsp" );
                    }
                    out.print( login.tutorLoginForm( ) );
                    out.print( "Tutor ID or Password are incorrect, please try again!" );
                }
         %>
         
        </div>
    </body>
</html>