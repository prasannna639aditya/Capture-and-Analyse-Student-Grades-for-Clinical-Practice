<%-- 
    Document   : grade
    Created on : 26-Feb-2016, 22:02:53
    Author     : Delaney
--%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Grade Students</title>
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
          String TutorID = (String) session.getAttribute( "TutorID" );
          
          String groupID = search.getGroupID();
          String studentIDs = search.getStudentID();
          String groupName = search.getName();
          
          String[] studentOutputArray;
        
          
            if(search.checkStudentID(search.getStudentID()) == true){
             if(search.checkGroup(search.getStudentID(), groupID) == false){
               out.println( gui.paragraph2(name.fetchStudentName(search.getStudentID()) + " has been added to session with group " + groupID + "."));
               out.print(look.startTable());
               out.print(look.fetchGroupNames(groupID));
               out.print(look.fetchExtraStudent(search.getStudentID()));
               out.print(look.endTable());
               search.addToExtras(TutorID, groupID, search.getStudentID());
             }

             else{
              out.print(gui.paragraph3("Please select a student who is not in group " + groupID + "."));
              out.print(search.addStudents(groupID));
              out.print(look.startTable());
              out.println(look.fetchGroupNames(groupID));
              out.print(look.endTable());
             }
            }

            else{
              out.print(gui.paragraph2("Please enter a valid student ID."));
              out.println(search.addStudents(groupID));
            %>
            
            <p id="away">
           <%
            out.println(look.startTable());
            out.println(look.fetchGroupNames(groupID));
            out.print(look.endTable());
            }
           %>
            <p>
            <%
           out.print(gui.footer());
          
          
          
          
        %> 
        
    </body>
</html>
