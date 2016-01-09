<%-- 
    Document   : tutorWelcome
    Created on : Dec 24, 2015, 8:19:29 PM
    Author     : Delaney
--%>

<%@page import="application.TutorLogin"%>
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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/landing-page.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
           

    <title>Simple Sidebar - Start Bootstrap Template</title>

   
    
    </head>
    <body>
        <%
          GUI gui = new GUI( );
          TutorLogin tutor = new TutorLogin();
          StudentLookup look = new StudentLookup();
          if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                String username = (String) session.getAttribute( "Authenticated" );
                String firstName = (String) session.getAttribute( "firstName" );
                String TutorID = (String) session.getAttribute( "TutorID" );
                String lastName = (String) session.getAttribute( "lastName" );
                String department = (String) session.getAttribute( "department" );
                String picture = (String) session.getAttribute( "picture" );
                out.print(gui.tutorNavigation(true, TutorID, firstName, lastName, department, picture));
                out.print(look.fetchNames());
          }
        %>
        
  
    </body>
</html>
