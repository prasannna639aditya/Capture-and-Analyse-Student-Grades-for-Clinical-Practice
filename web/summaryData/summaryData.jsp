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
        
        
        <%
          GUI gui = new GUI( );
          StudentLookup look = new StudentLookup();
          out.print(gui.tutorNavigation());
          StudentSummaryData check = new StudentSummaryData();
          StudentYearlySummaryData year = new StudentYearlySummaryData();
        %> 
        
        <ul>
            <li a href="year1StudentData.jsp">BDS3</li>
            <li a href="year2StudentData.jsp">BDS4</li>
            <li a href="year3StudentData.jsp">BDS5</li>
            <li a href="year4StudentData.jsp">HYG1</li>
            <li a href="year5StudentData.jsp">HYG2</li>
        </ul>
        <%
          out.print(check.studentData());
          
          out.print("Test with numb");
          out.print(year.showCore(1, "2"));
          
          out.print("Test");
          out.print(check.showCore(5));
        %> 
           
               
         </div>    
        </div>
       </div>
     </div>
    </div>
        
    </body>
</html>