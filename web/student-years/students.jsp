<%-- 
    Document   : BDS3
    Created on : Jan 11, 2016, 11:26:12 AM
    Author     : Delaney
--%>

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
        <title>Students</title>
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
        $(function() {
          $( "#tabs" ).tabs();
        });
        </script>
        
    </head>
    <body>
        
        <%
          GUI gui = new GUI( );
          out.print(gui.tutorStudentYearsNav());
          StudentLookup look = new StudentLookup();
        %>
         <div id="tabs">
         <ul>
           <li><a href="#tabs-1">All Students</a></li>
           <li><a href="#tabs-2">BDS3</a></li>
           <li><a href="#tabs-3">BDS4</a></li>
           <li><a href="#tabs-4">BDS5</a></li>
           <li><a href="#tabs-5">HYG1</a></li>
           <li><a href="#tabs-6">HYG2</a></li>
         </ul>
         <div id="tabs-1">
           <p>
            <% 
                out.print(look.fetchNames());
            %> 
           </p>
         </div>
           
         <div id="tabs-2">
           <p>
            <% 
                out.print(look.fetchYearNames("1"));
            %> 
           </p>
         </div>
         
         <div id="tabs-3">
           <p>
            <%
                out.print(look.fetchYearNames("2"));
            %> 
           </p>
         </div>
           
         <div id="tabs-4">
           <p>
            <%
                out.print(look.fetchYearNames("3"));
            %>
           </p>
         </div>
           
         <div id="tabs-5">
           <p>
            <%
                out.print(look.fetchYearNames("4"));
            %>
           </p>
         </div>
           
         <div id="tabs-6">
           <p>
            <%
                out.print(look.fetchYearNames("5"));
            %>
           </p>
         </div>
           
        </div> 
        <%
                out.print(gui.footer());
        %>
        
    </body>
</html>
