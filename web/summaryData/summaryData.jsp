<%-- 
    Document   : summaryData
    Created on : 18-Feb-2016, 20:20:42
    Author     : Delaney
--%>


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
        <title>Student Summary Data</title>
        
        
    </head>
    <body>
     
        <div id="wrapper">
        <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
             <a href="../index.jsp">Logout</a>
            </li>
            <li><a href="../tutorWelcome.jsp">Home</a></li>
            <li><a href="../registerStudent.jsp">Register a Student</a></li>
            <li><a href="../student-years/students.jsp">Grade Students</a></li>
            <li><a href="summaryData.jsp">Summary Data</a></li>
            <li><a href="../markingDescriptors.jsp">Marking Descriptors</a></li>
               <form name='marking_form' action='../studentSearch.jsp' method='POST'>
               <li>
               <div class="input-group">
               <input type="text" name='studentID' class="form-control" placeholder="Search student ID">
               </select><br/>
               <input type='submit' value='Search' name='submit' /><br />
               </div>
               </li>
               </form>
        </ul>          
        </div>
        <div id="page-content-wrapper"> 
        <div class="container-fluid">
        <div class="row">
        <div class="col-lg-12">
        
        
        
        
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          StudentSummaryData check = new StudentSummaryData();
          StudentYearlySummaryData year = new StudentYearlySummaryData();
        %> 
        
        
        <!--<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>-->
        
        
        <div>
         <ul>
            <li a href="year1StudentData.jsp">BDS3</li>
            <li a href="year2StudentData.jsp">BDS4</li>
            <li a href="year3StudentData.jsp">BDS5</li>
            <li a href="year4StudentData.jsp">HYG1</li>
            <li a href="year5StudentData.jsp">HYG2</li>
         </ul>
        </div>
        
        <h1> All student data summarized</h1>
        <%
          out.print(check.studentData());
          
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