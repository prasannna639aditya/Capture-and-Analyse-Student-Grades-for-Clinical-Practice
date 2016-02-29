<%-- 
    Document   : adminLogin
    Created on : 29-Feb-2016, 17:30:44
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/login.css" rel="stylesheet">
        <link href="../css/landing-page.css" rel="stylesheet">
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Administrator Login</title>
    </head>
   
    <body>

        <div class="login-card">
            
            <h1>Welcome Admin, Please Login</h1>
        
        <%
                AdminLogin login = new AdminLogin();
                
                if( request.getParameter( "submit" ) == null ){
                    out.print( login.adminLoginForm() );
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
                    out.print( login.adminLoginForm( ) );
                    out.print( "Admin ID or Password are incorrect, please try again!" );
                }
         %>
         
        </div>
    </body>
</html>