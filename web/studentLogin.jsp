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
            else{
                out.print( loginHeader.loginHeader( ) );    
        %>

        <div class="intro-header">
            <div class="container">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <% 
                             out.print( login.studentLoginForm() );
                              out.print( login.printErrors( ) );
         }
     }
                            %>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>

        <%                    
                       
        %>
        <!-- Page Content -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="list-inline">
                            <li>
                                <a href="index.jsp">Home</a>
                            </li>
                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="https://www.ucc.ie/en/dentalschool/about/contact/">Contact</a>
                            </li>
                        </ul>
                        <p class="copyright text-muted small">Copyright &copy; University College Cork 2016. All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </footer>   
    </body>
</html>
