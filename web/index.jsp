<%-- 
    Document   : index
    Created on : Dec 22, 2015, 2:28:28 PM
    Author     : Delaney
--%>
<%@page import="application.StudentLogin"%>
<%@ page import="guipackage.GUI;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/loginform.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Dental School Grading System</title>
    </head>
   
    <body>
        <%
          GUI loginHeader = new GUI( );  
          out.print( loginHeader.loginHeader( ) );
        %>

    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>Dental Hospital Login</h1>
                        <h4>Please select a login below</h4>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                <a href="studentLogin.jsp" class="btn btn-default btn-lg"><img border="0" alt="W3Schools" src="http://findicons.com/files/icons/1773/free/256/person.png" width="25" height="25"> <span class="network-name">Student</span></a>
                            </li>
                            <li>
                                <a href="tutorLogin.jsp" class="btn btn-default btn-lg"><img border="0" alt="W3Schools" src="http://icons.iconarchive.com/icons/icons-land/vista-people/256/Office-Customer-Male-Light-icon.png" width="25" height="25"> <span class="network-name">Tutor</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Page Content -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-inline">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li
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

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
