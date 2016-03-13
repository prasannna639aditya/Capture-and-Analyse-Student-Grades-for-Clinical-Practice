<%-- 
    Document   : adminWelcome
    Created on : 29-Feb-2016, 17:34:56
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
        <meta charset="utf-8">
        <meta name="robots" content="noindex">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../css/sidebar.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="../js/sidebar.js"></script>
        <link href="../css/dropdown.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Welcome Admin</title>
        
        
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          AdminLogin admin = new AdminLogin();
          
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                out.print(gui.adminNavigation());
                String username = (String) session.getAttribute( "Authenticated" );
                String firstName = (String) session.getAttribute( "firstName" );
                String AdminID = (String) session.getAttribute( "AdminID" );
                String lastName = (String) session.getAttribute( "lastName" );
                String department = (String) session.getAttribute( "department" );
                
                out.print(gui.paragraph2("Welcome " + firstName + " " + lastName + ".") );
                out.print(gui.footer());
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
