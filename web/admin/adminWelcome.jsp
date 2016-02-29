<%-- 
    Document   : adminWelcome
    Created on : 29-Feb-2016, 17:34:56
    Author     : Delaney
--%>

<%@page import="admin.AdminLogin"%>
<%@page import="summaryData.StudentYearlySummaryData"%>
<%@page import="summaryData.StudentSummaryData"%>
<%@page import="application.StudentLookup"%>
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
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/landing-page.css" rel="stylesheet">
        <link href="../css/simple-sidebar.css" rel="stylesheet">
        <link href="../css/dropdown.css" rel="stylesheet">
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Welcome Admin</title>
        
        
    </head>
    <body>
     
        <div id="wrapper">
        <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
             <a href="../index.jsp">Logout</a>
            </li>
            <li><a href="adminWelcome.jsp">Home</a></li>
            <li><a href="registerStudent.jsp">Register a student</a></li>
            <li><a href="registerTutor.jsp">Register a tutor</a></li>
        </ul>          
        </div>
        <div id="page-content-wrapper"> 
        <div class="container-fluid">
        <div class="row">
        <div class="col-lg-12">
        <%
          GUI gui = new GUI( );
          AdminLogin admin = new AdminLogin();
          
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String username = (String) session.getAttribute( "Authenticated" );
                String firstName = (String) session.getAttribute( "firstName" );
                String AdminID = (String) session.getAttribute( "AdminID" );
                String lastName = (String) session.getAttribute( "lastName" );
                String department = (String) session.getAttribute( "department" );
                
                out.println("Welcome " + firstName + " " + lastName + "." );
                
          }
        %>
        
        
        
        
        
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script>$("#menu-toggle").click(function(e) {e.preventDefault();$("#wrapper").toggleClass("toggled");});</script>
        </div>
       </div>
      </div>
     </div>
    </div>
        
    </body>
</html>