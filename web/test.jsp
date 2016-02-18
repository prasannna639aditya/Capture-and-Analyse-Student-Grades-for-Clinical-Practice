<%-- 
    Document   : test
    Created on : 15-Feb-2016, 10:44:35
    Author     : Delaney
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="guipackage.GUI;"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" media="screen" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300italic' rel='stylesheet' type='text/css'>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
        $(function() {
        $( "#accordion" ).accordion();
        });
        </script>
        <title>Timetable Scheduler</title>
    </head>
   
    <body>
        
        
        
        
        <div id="accordion">
            <h3>Help</h3>
                <div>
                 <p>
                  Welcome to the UCC Computer Science Scheduling help page. Here, we hope to answer any questions you may have. However,
                  if you can’t find an answer here, feel free to contact us by using our Contact page and we will get back to you as soon as possible.
                 </p>
                </div>                     
            
            <h3>How do I register for the system?</h3>
                <div>
                 <p>
                  On the log in page, there is a blue link that says ‘register here’. This will bring you to a page which requires you to fill out a few details about yourself, including the stream of computer science you are studying, your student number and a password for logging into the system.
                  Once the required fields are filled out, you will be registered with the system. 
                  You will receive a confirmation email to your own email account. 
                 </p>
                </div>
           
            <h3>How do I log in to the system?</h3>
                <div>
                 <p>
                   If you are fully registered, you will be able to log in to view your schedule.
               To do this, you need your student number and your password that you set up upon registration. 
               These are the only credentials needed for logging in. 

                 </p>
                </div>
           
            <h3>What if I forgot my password?</h3>
                <div>
                 <p>
                     If you have forgotten your password, you can click on the forgotten password link underneath the log in button on the home page. 
               This will bring you to a window that will require you to enter your email address. Your new password will be sent to this email address. 

                 </p>
                </div>
            
            <h3>Tell me about my timetable?</h3>
                <div>
                 <p>
                 Once you log in, you will automatically see your timetable, displaying all the events that you have during the week that you log in. 
               This will include your lectures, your own personal events that you have added yourself and any meeting that have been scheduled by 
               your lecturers. You will also see a notification bar. This tells you any events that are coming up for you and any meetings or events that 
               have been scheduled for you since you last logged in. 

                 </p>
                </div>
            <h3>Adding events</h3>
                <div>
                 <p>
                 If you click on the tab on your Timetable page that says ‘Add Meeting’, it will bring you to a page with a form on it.
                This form asks you some relevant information to add a meeting to your timetable. 
                It allows you to add a meeting at any time that is free for you on any date. 
                <b>NOTE: You cannot override lectures or group meetings.</b>
 

                 </p>
                </div>
            </div>
            
            
            
        </div>

        
                
    </body>
</html>