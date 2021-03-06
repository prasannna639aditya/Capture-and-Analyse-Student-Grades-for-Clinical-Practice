<%-- 
    Document   : treatmentItems
    Created on : Jan 14, 2016, 11:00:19 PM
    Author     : Delaney
--%>

<%@page import="guipackage.SearchBox"%>
<%@page import="application.TreatmentItems"%>
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
        <link href="css/sidebar.css" rel="stylesheet">
        <link href="css/dropdown2.css" rel="stylesheet">
        <link href="css/table2.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/sidebar.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
          SearchBox search = new SearchBox();
          String TutorID = (String) session.getAttribute( "TutorID" );
            if( session.getAttribute( "Authenticated" ) == null ) {
                response.sendRedirect( "index.jsp" );
            }
            else {
                out.print(gui.tutorNavigation());
                
                
             if( treatmentItem.doesPatientExist( lookup.getCdsNumber()) == true){
        %>
        <p>
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="nav active"><a href="#A" data-toggle="tab">Periodontics</a></li>
                <li class="nav"><a href="#B" data-toggle="tab">Prevention</a></li>
                <li class="nav"><a href="#C" data-toggle="tab">Direct Restorations</a></li>
                <li class="nav"><a href="#D" data-toggle="tab">Indirect Restorations</a></li>
                <li class="nav"><a href="#E" data-toggle="tab">Endodontics</a></li>
                <li class="nav"><a href="#F" data-toggle="tab">Prosthodontics</a></li>
                <li class="nav"><a href="#G" data-toggle="tab">Tooth Whitening</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="A">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "1", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="B">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "2", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="C">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "3", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="D">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "4", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="E">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "5", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="F">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "6", lookup.getCdsNumber() ) );
                    %>
                </div>
                <div class="tab-pane fade" id="G">
                    <%
                            out.print( treatmentItem.fetchTreatments( lookup.getStudentID(), "7", lookup.getCdsNumber() ) );
                    %>
                </div>
                </p>
                <%
             }
             else{
                %>
                <p>
                    <%
                    out.print(gui.paragraph("This patient does not exist. Please re-select your group and re-enter the correct patient CDS number"));
                    %>
                </p>
                <%
                out.print(search.showTutorsGroups(TutorID));
            }
           }
                        
             session.setAttribute("attendance", treatmentItem.getAttendance( ) );
             out.print(gui.footer());
                %>

                </body>
                </html>
