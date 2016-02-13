<%-- 
    Document   : treatmentItems
    Created on : Jan 14, 2016, 11:00:19 PM
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
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
        <link href="css/dropdown.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <title>Treatment Items</title>
    </head>
    <body>
        
        <jsp:useBean id="lookup" class="application.StudentLookup" scope="request" />
        <jsp:setProperty name="lookup" property="*" />
        
        <%
          GUI gui = new GUI( );
          TreatmentItems treatmentItem = new TreatmentItems( );
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                out.print(gui.tutorNavigation());
                out.print( treatmentItem.fetchTreatments( lookup.getStudentID() ) );
              }
                        
                        
        %>
         
        <img id="clickMeId" src="img/derek.jpg" onclick="show('comment')"/>&nbsp;&nbsp;<div id="comment" style="float:left;display:none;"><input type="password" name="password" placeholder="Enter Password"/><br />&nbsp;<a href="#" class="buttonintable">Submit</a></div>

        <script>function show(target){
        document.getElementById(target).style.display = 'block';
        document.getElementById("clickMeId").style.display = 'none';
        }
        function hide(target){
        document.getElementById(target).style.display = 'none';
        document.getElementById("clickMeId").style.display = 'block';
        }</script>
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>
