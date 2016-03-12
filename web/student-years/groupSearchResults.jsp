<%-- 
    Document   : groupSearchResults
    Created on : 26-Feb-2016, 18:04:31
    Author     : Delaney
--%>

<%@page import="application.TreatmentItems"%>
<%@page import="guipackage.SearchBox"%>
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
        <title>Group Search Results</title>
        
        
    </head>
    <body>
        
        <jsp:useBean id="search" class="guipackage.SearchBox" scope="request" />
        <jsp:setProperty name="search" property="*" />
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          out.print(gui.tutorStudentYearsNav());
          StudentSummaryData check = new StudentSummaryData();
          GroupSummaryData group = new GroupSummaryData();
          TreatmentItems name = new TreatmentItems();
          
          String groupID = search.getGroupID();
          
          if(search.checkGroupDescriptor(groupID) == true){
            out.print(search.addStudents(groupID));
            out.print(look.startTable());
            out.print(look.fetchGroupNames(groupID));
            out.print(look.endTable());
          }
          
          else{
        %> 
        <p> </p>
        <%
              out.println(search.groupSearchBox());
        %>
        <p><h4 id="left"> Please enter a valid group </h4></p>
        <%
          }
          
          out.print(gui.footer());
          //String studentID = search.getStudentID();
          //out.println(look.fetchExtraStudent(studentID));
        %> 
    </body>
</html>

