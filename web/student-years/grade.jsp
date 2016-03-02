<%-- 
    Document   : grade
    Created on : 26-Feb-2016, 22:02:53
    Author     : Delaney
--%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="application.TreatmentItems"%>
<%@page import="guipackage.SearchBox"%>
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
        
        
        <!--- Site CSS -->
        <link rel="stylesheet" type="text/css" href="../js/components/reset.css">
        <link rel="stylesheet" type="text/css" href="../js/components/site.css">
        <link rel="stylesheet" type="text/css" href="../js/components/grid.css">

        <!--- Component CSS -->
        <link rel="stylesheet" type="text/css" href="../js/components/icon.css">
        <link rel="stylesheet" type="text/css" href="../js/components/input.css">
        <link rel="stylesheet" type="text/css" href="../js/components/button.css">
        <link rel="stylesheet" type="text/css" href="../js/components/divider.css">
        <link rel="stylesheet" type="text/css" href="../js/components/label.css">
        <link rel="stylesheet" type="text/css" href="../js/components/dropdown.css">
        <link rel="stylesheet" type="text/css" href="../js/components/transition.css">
        <link rel="stylesheet" type="text/css" href="../js/components/popup.css">

        <!--- Component JS -->
        <script src="../js/library/jquery.min.js"></script>
        <script src="../js/library/iframe-content.js"></script>
        <script type="text/javascript" src="../js/components/popup.js"></script>
        <script type="text/javascript" src="../js/components/dropdown.js"></script>
        <script type="text/javascript" src="../js/components/transition.js"></script>
        <title>Grade Students</title>
        
        
    </head>
    <body>
        
        <jsp:useBean id="search" class="guipackage.SearchBox" scope="request" />
        <jsp:setProperty name="search" property="*" />
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          out.print(gui.tutorNavigation());
          StudentSummaryData check = new StudentSummaryData();
          StudentYearlySummaryData year = new StudentYearlySummaryData();
          TreatmentItems name = new TreatmentItems();
          String TutorID = (String) session.getAttribute( "TutorID" );
          
          String groupID = search.getGroupID();
          String studentIDs = search.getStudentID();
          
          String[] studentOutputArray;
        
          
            
            if(search.checkStudentID(search.getStudentID()) == true){
             if(search.checkGroup(search.getStudentID(), groupID) == false){
               out.println( name.fetchStudentName(search.getStudentID()) + " has been added to session with group " + groupID + ".");
               out.print(look.fetchGroupNames(groupID));
               out.print(look.fetchExtraStudent(search.getStudentID()));
               search.addToExtras(TutorID, groupID, search.getStudentID());
             }

             else{
              out.println("Please select a student who is not in group " + groupID + ".");
              out.print(search.addStudents(groupID));
              out.println(look.fetchGroupNames(groupID));
             }
            }

            else{
              out.println("Please enter a valid student ID.");
              out.print(search.addStudents(groupID));
              out.println(look.fetchGroupNames(groupID));
            }

          
          
          
          
        %> 
           
               
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>
