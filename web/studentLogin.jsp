<%-- 
    Document   : studentLogin
    Created on : Dec 22, 2015, 8:05:47 PM
    Author     : Delaney
--%>
<%@page import="application.StudentLogin"%>
<%@ page import="guipackage.GUI;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/login2.css" rel="stylesheet">
        <script src="js/login.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Dental School Student Login</title>
    </head>
   
    <body>
      
        <%
                StudentLogin login = new StudentLogin();
                GUI loginHeader = new GUI( );
                
                if( request.getParameter( "submit" ) == null ){
                    out.print( loginHeader.loginHeader( ) );
                    %>
                    
                    <div class="intro-header">
                        <div class="container">

                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="intro-message">
                                       <% 
                   
                                        out.print( login.studentLoginForm() );
                                       %>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.container -->

                    </div>
                    <div class="content-section-a">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <hr class="section-heading-spacer">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">Google Web Fonts and<br>Font Awesome Icons</h2>
                    <p class="lead">This template features the 'Lato' font, part of the <a target="_blank" href="http://www.google.com/fonts">Google Web Font library</a>, as well as <a target="_blank" href="http://fontawesome.io">icons from Font Awesome</a>.</p>
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="img/phones.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>       
                <%
                }
                else{
                    if( login.loginStudent( request )) {
                        session.setAttribute( "Authenticated", login.getStudentID( ) );
                        session.setAttribute("firstName", login.getFirstName( ) );
                        session.setAttribute("lastName", login.getLastName( ) );
                        session.setAttribute("picture", login.getPicture( ) );
                        session.setAttribute("StudentID", login.getStudentID( ) );
                        response.sendRedirect( "studentWelcome.jsp" );
                    }
                    out.print( login.studentLoginForm( ) );
                    out.print( "Student ID or Password are incorrect, please try again!" );
                }
         %>
       
    </body>
</html>
