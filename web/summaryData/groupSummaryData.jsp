<%-- 
    Document   : BDS3
    Created on : Jan 11, 2016, 11:26:12 AM
    Author     : Delaney
--%>

<%@page import="summaryData.StudentYearlySummaryData"%>
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
        <div id="wrapper">
        <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
             <a href="../index.jsp">Logout</a>
            </li>
            <li><a href="../tutorWelcome.jsp">Home</a></li>
            <li><a href="../registerStudent.jsp">Register a Student</a></li>
            <li><a href="students.jsp">Grade Students</a></li>
            <li><a href="../summaryData.jsp">Summary Data</a></li>
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
          StudentYearlySummaryData year = new StudentYearlySummaryData();
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
                out.print(year.studentData("3.1"));
            %> 
           </p>
         </div>
           
         <div id="tabs-2">
           <p>
            <% 
                out.print(year.studentData("3.1"));
            %> 
           </p>
         </div>
         
         <div id="tabs-3">
           <p>
            <%
                out.print(year.studentData("3.3"));
            %> 
           </p>
         </div>
           
         <div id="tabs-4">
           <p>
            <%
                out.print(year.studentData("3.4"));
            %>
           </p>
         </div>
           
         <div id="tabs-5">
           <p>
            <%
                out.print(year.studentData("3.5"));
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
           
          
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>
