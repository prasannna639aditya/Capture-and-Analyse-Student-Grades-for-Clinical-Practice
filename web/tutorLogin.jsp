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
        <link href="css/login2.css" rel="stylesheet">
        <script src="js/login.js"></script>
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Dental School Tutor Login</title>
    </head>
   
    <body>

        
        
        <%
                TutorLogin login = new TutorLogin();
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
                                        out.print( login.tutorLoginForm() );
                                       %>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.container -->

                    </div>
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
                <%
                    
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
                    else{
                        out.print( loginHeader.loginHeader( ) );    
                        %>
                    
                    <div class="intro-header">
                        <div class="container">

                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="intro-message">
                                       <% 
                                        out.print( login.tutorLoginForm() );
                                         out.print( login.printErrors( ) );
                    }
                }
                                       %>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                        <!-- /.container -->

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
                <%                    
                       
         %>
         
    </body>
</html>