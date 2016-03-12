<%-- 
    Document   : adminLogin
    Created on : 29-Feb-2016, 17:30:44
    Author     : Delaney
--%>

<%@page import="admin.AdminLogin"%>
<%@page import="summaryData.GroupSummaryData"%>
<%@page import="summaryData.StudentSummaryData"%>
<%@page import="application.StudentLookup"%>
<%@page import="guipackage.GUI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/login2.css" rel="stylesheet">
        <script src="../js/login.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Administrator Login</title>
    </head>
   
    <body>

        
        
        <%
                AdminLogin login = new AdminLogin();
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
                   
                                        out.print( login.adminLoginForm() );
                                       %>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.container -->

                    </div>
                    <div class="content-section-a">

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
                    if( login.loginAdmin( request )) {
                        session.setAttribute( "Authenticated", login.getAdminID( ) );
                        session.setAttribute("TutorID", login.getAdminID( ) );
                        session.setAttribute("firstName", login.getFirstName( ) );
                        session.setAttribute("lastName", login.getLastName( ) );
                        session.setAttribute("department", login.getDepartment( ) );
                        response.sendRedirect( "adminWelcome.jsp" );
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
                                        out.print( login.adminLoginForm() );
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