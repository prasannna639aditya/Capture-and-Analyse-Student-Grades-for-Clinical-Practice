package guipackage;
/**
 *
 * @author Delaney
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class GUI {
    private String form;
    private String studentID;
    private final SecureRandom random;

    public GUI( ) {
        this.random = new SecureRandom( );
        this.studentID = "";
    }

    public String nextSessionId( ) {
        return new BigInteger( 130, random ).toString( 32 );
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String loginHeader( ) {
     String form = "<nav class=\"navbar navbar-default navbar-fixed-top topnav\" role=\"navigation\">\n";
            form += "<div class=\"container topnav\">\n";
            form += "<div class=\"navbar-header\">\n";
            form += "<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n"; 
            form += "<span class=\"sr-only\">Toggle navigation</span>\n";
            form += "<span class=\"icon-bar\"></span>\n";
            form += "<span class=\"icon-bar\"></span>\n";
            form += "<span class=\"icon-bar\"></span>\n";
            form += "</button>\n";        
            form += "<a class=\"navbar-brand topnav\" href=\"#\">Cork University Dental Hospital</a>\n";
            form += "</div>\n";
            form += "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n";  
            form += "<ul class=\"nav navbar-nav navbar-right\">\n";
            form += "<li>\n";
            form += "<a href=\"#about\">About</a>\n";
            form += "</li>\n";
            form += "<li>\n";
            form += "<a href='admin/adminLogin.jsp'>Admin</a>\n";
            form += "</li>\n";
            form += "<li>\n";
            form += "<a href=\"https://www.ucc.ie/en/dentalschool/about/contact/\">Contact</a>\n";
            form += "</li>\n";
            form += "</ul>\n";
            form += "</div>\n";
            form += "</div>\n";
            form += "</nav>\n";
        return form;
    }
    

        
    public String tutorDisplay(String TutorID, String firstName, String lastName) {
            SearchBox search = new SearchBox();
            String form = "<div class=\"row\">\n" +
                    "            <div class=\"col-md-4\">\n" +
                    "                <p> </p>\n" +
                    "                <img class=\"img-responsive img-rounded\"  src=\"img/tutors/" + TutorID + ".jpg\" alt=\"\">\n" +
                    "            </div>\n" +
                    "            <!-- /.col-md-8 -->\n" +
                    "            <div class=\"col-md-4\">\n" +
                    "                <h2>Welcome " + firstName + " " + lastName + "</h2>\n" +
                    "                <p>Please search for a group below that you would like to grade. Enter in the group ID. You will then have the option to add another student to this group session.</p>   \n";
                   form +=       search.groupSearchBox2() +
                    "            </div>\n" +
                    "            <!-- /.col-md-4 -->\n" +
                    "        </div>";
         return form;
    }
    
    
    public String studentPrint(String StudentID, String firstName, String lastName) {
        
            
        String form = "<div class=\"row\">\n" +
                    "            <div class=\"col-md-4\">\n" +
                    "                <p> </p>\n" +
                    "                <img class=\"img-responsive img-rounded\"  src=\"img/students/" + StudentID + ".jpg\" alt=\"\">\n" +
                    "            </div>\n" +
                    "            <!-- /.col-md-8 -->\n" +
                    "            <div class=\"col-md-4\">\n" +
                    "                <h2>Welcome " + firstName + " " + lastName + "</h2>\n" +
                    "                <p>Please click on this link to see an <a href=\"studentGradeView.jsp\">analysis</a> of your results. To view the marking structure, please take a look at the <a href=\"markingDescriptors.jsp\">marking descriptors</a>.</p>   \n" +
                    "            </div>\n" +
                    "            <!-- /.col-md-4 -->\n" +
                    "        </div>";
         return form;
    }
    
    public String studentNavigation(){
         String form = "<div class=\"row\">\n";
            form += "<!-- uncomment code for absolute positioning tweek see top comment in css -->\n" +
            "    <div class=\"absolute-wrapper\"> </div>\n" +
            "    <!-- Menu -->\n" +
            "    <div class=\"side-menu\">\n" +
            "    \n" +
            "    <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
            "    <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "    <div class=\"navbar-header\">\n" +
            "        <div class=\"brand-wrapper\">\n" +
            "            <!-- Hamburger -->\n" +
            "            <button type=\"button\" class=\"navbar-toggle\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "\n" +
            "            <!-- Brand -->\n" +
            "            <div class=\"brand-name-wrapper\">\n" +
            "                <a class=\"navbar-brand\" href=\"index.jsp\">\n" +
            "                 <span class=\"glyphicon glyphicon-repeat\">   Logout\n" +
            "                </a>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Search -->\n" +
            "\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Menu -->\n" +
            "    <div class=\"side-menu-container\">\n" +
            "        <ul class=\"nav navbar-nav\">\n" +
            "\n" +
            "            <li class=\"active\"><a href=\"studentWelcome.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n" +  
            "            <li class=\"active\"><a href=\"studentGradeView.jsp\"><span class=\"glyphicon glyphicon-pencil\"></span> My Grades</a></li>\n" + 
            "            <li class=\"active\"><a href=\"studentMarkingDescriptors.jsp\"><span class=\"glyphicon glyphicon-edit\"></span> Marking Descriptors</a></li>\n" +
            "\n" +
            "\n" +
            "\n" +
            "        </ul>\n" +
            "    </div><!-- /.navbar-collapse -->\n" +
            "</nav>\n" +
            "    \n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Content -->\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <div class=\"side-body\">\n" +
            "        <div class=\"space\"></div>\n";
         
         return form;
    }
    
    public String tutorNavigation(){
         String form = "<div class=\"row\">\n";
            form += "<!-- uncomment code for absolute positioning tweek see top comment in css -->\n" +
            "    <div class=\"absolute-wrapper\"> </div>\n" +
            "    <!-- Menu -->\n" +
            "    <div class=\"side-menu\">\n" +
            "    \n" +
            "    <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
            "    <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "    <div class=\"navbar-header\">\n" +
            "        <div class=\"brand-wrapper\">\n" +
            "            <!-- Hamburger -->\n" +
            "            <button type=\"button\" class=\"navbar-toggle\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "\n" +
            "            <!-- Brand -->\n" +
            "            <div class=\"brand-name-wrapper\">\n" +
            "                <a class=\"navbar-brand\" href=\"index.jsp\">\n" +
            "                 <span class=\"glyphicon glyphicon-repeat\">   Logout\n" +
            "                </a>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Search -->\n" +
            "            <a data-toggle=\"collapse\" href=\"#search\" class=\"btn btn-default\" id=\"search-trigger\">\n" +
            "                <span class=\"glyphicon glyphicon-search\"></span>\n" +
            "            </a>\n" +
            "\n" +
            "            <!-- Search body -->\n" +
            "            <div id=\"search\" class=\"panel-collapse collapse\">\n" +
            "                <div class=\"panel-body\">\n";
            SearchBox search = new SearchBox();
            form += search.searchBox();
            form +=        "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Menu -->\n" +
            "    <div class=\"side-menu-container\">\n" +
            "        <ul class=\"nav navbar-nav\">\n" +
            "\n" +
            "            <li class=\"active\"><a href=\"tutorWelcome.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n" +
            "            <li class=\"active\"><a href=\"registerStudent.jsp\"><span class=\"glyphicon glyphicon-plus\"></span> Register a student</a></li>\n" +    
            "            <li class=\"active\"><a href=\"student-years/groupSearch.jsp\"><span class=\"glyphicon glyphicon-pencil\"></span> Grade students</a></li>\n" + 
            "            <li class=\"active\"><a href=\"markingDescriptors.jsp\"><span class=\"glyphicon glyphicon-edit\"></span> Marking Descriptors</a></li>\n" +
            "\n" +
            "            <!-- Dropdown-->\n" +
            "            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                <a data-toggle=\"collapse\" href=\"#dropdown-lvl1\">\n" +
            "                    <span class=\"glyphicon glyphicon-folder-open\"></span> Student Analysis<span class=\"caret\"></span>\n" +
            "                </a>\n" +
            "\n" +
            "                <!-- Dropdown level 1 -->\n" +
            "                <div id=\"dropdown-lvl1\" class=\"panel-collapse collapse\">\n" +
            "                    <div class=\"panel-body\">\n" +
            "                        <ul class=\"nav navbar-nav\">\n" +
            "                            <li><a href=\"summaryData/summaryData.jsp\">All Students</a></li>\n" +
            "\n" +
            "                            <!-- Dropdown level 2 -->\n" +
            "                            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                                <a data-toggle=\"collapse\" href=\"#dropdown-lvl2\">\n" +
            "                                    <span class=\"glyphicon glyphicon-list-alt\"></span> Group Summary Data <span class=\"caret\"></span>\n" +
            "                                </a>\n" +
            "                                <div id=\"dropdown-lvl2\" class=\"panel-collapse collapse\">\n" +
            "                                    <div class=\"panel-body\">\n" +
            "                                        <ul class=\"nav navbar-nav\">\n" +
            "                                            <li><a href=\"summaryData/3.1.jsp\">3.1</a></li>\n" +
            "                                            <li><a href=\"summaryData/3.2.jsp\">3.2</a></li>\n" +
            "                                            <li><a href=\"summaryData/3.3.jsp\">3.3</a></li>\n" +
            "                                            <li><a href=\"summaryData/3.4.jsp\">3.4</a></li>\n" +
            "                                            <li><a href=\"summaryData/3.5.jsp\">3.5</a></li>\n" +
            "                                            <li><a href=\"summaryData/4.1.jsp\">4.1</a></li>\n" +
            "                                            <li><a href=\"summaryData/4.2.jsp\">4.2</a></li>\n" +
            "                                            <li><a href=\"summaryData/4.3.jsp\">4.3</a></li>\n" +
            "                                            <li><a href=\"summaryData/4.4.jsp\">4.4</a></li>\n" +
            "                                            <li><a href=\"summaryData/4.5.jsp\">4.5</a></li>\n" +
            "                                            <li><a href=\"summaryData/5.1.jsp\">5.1</a></li>\n" +
            "                                            <li><a href=\"summaryData/5.2.jsp\">5.2</a></li>\n" +
            "                                            <li><a href=\"summaryData/5.3.jsp\">5.3</a></li>\n" +
            "                                            <li><a href=\"summaryData/5.4.jsp\">5.4</a></li>\n" +
            "                                            <li><a href=\"summaryData/5.5.jsp\">5.5</a></li>\n" +
            "                                        </ul>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </li>\n" +
            "\n" +
            "\n" +
            "        </ul>\n" +
            "    </div><!-- /.navbar-collapse -->\n" +
            "</nav>\n" +
            "    \n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Content -->\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <div class=\"side-body\">\n";
         
         return form;
    }
        
    public String adminNavigation(){
         String form = "<div class=\"row\">\n";
            form += "<!-- uncomment code for absolute positioning tweek see top comment in css -->\n" +
            "    <div class=\"absolute-wrapper\"> </div>\n" +
            "    <!-- Menu -->\n" +
            "    <div class=\"side-menu\">\n" +
            "    \n" +
            "    <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
            "    <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "    <div class=\"navbar-header\">\n" +
            "        <div class=\"brand-wrapper\">\n" +
            "            <!-- Hamburger -->\n" +
            "            <button type=\"button\" class=\"navbar-toggle\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "\n" +
            "            <!-- Brand -->\n" +
            "            <div class=\"brand-name-wrapper\">\n" +
            "                <a class=\"navbar-brand\" href=\"../index.jsp\">\n" +
            "                 <span class=\"glyphicon glyphicon-repeat\">   Logout\n" +
            "                </a>\n" +
            "            </div>\n" +
            "\n" +   
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Menu -->\n" +
            "    <div class=\"side-menu-container\">\n" +
            "        <ul class=\"nav navbar-nav\">\n" +
            "\n" +
            "            <li class=\"active\"><a href=\"../adminWelcome.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n" +  
            "            <li class=\"active\"><a href=\"registerStudent.jsp\"><span class=\"glyphicon glyphicon-pencil\"></span> Register Student</a></li>\n" + 
            "            <li class=\"active\"><a href=\"registerTutor.jsp\"><span class=\"glyphicon glyphicon-edit\"></span> Register Tutor</a></li>\n" +
            "            <li class=\"active\"><a href=\"registerPatient.jsp\"><span class=\"glyphicon glyphicon-plus\"></span> Create Patient</a></li>\n" +
            "\n" +
            "\n" +
            "\n" +
            "        </ul>\n" +
            "    </div><!-- /.navbar-collapse -->\n" +
            "</nav>\n" +
            "    \n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Content -->\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <div class=\"side-body\">\n";
         
         return form;
    }
    
    public String tutorStudentYearsNav(){
         String form = "<div class=\"row\">\n";
            form += "<!-- uncomment code for absolute positioning tweek see top comment in css -->\n" +
            "    <div class=\"absolute-wrapper\"> </div>\n" +
            "    <!-- Menu -->\n" +
            "    <div class=\"side-menu\">\n" +
            "    \n" +
            "    <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
            "    <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "    <div class=\"navbar-header\">\n" +
            "        <div class=\"brand-wrapper\">\n" +
            "            <!-- Hamburger -->\n" +
            "            <button type=\"button\" class=\"navbar-toggle\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "\n" +
            "            <!-- Brand -->\n" +
            "            <div class=\"brand-name-wrapper\">\n" +
            "                <a class=\"navbar-brand\" href=\"../index.jsp\">\n" +
            "                 <span class=\"glyphicon glyphicon-repeat\">   Logout\n" +
            "                </a>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Search -->\n" +
            "            <a data-toggle=\"collapse\" href=\"#search\" class=\"btn btn-default\" id=\"search-trigger\">\n" +
            "                <span class=\"glyphicon glyphicon-search\"></span>\n" +
            "            </a>\n" +
            "\n" +
            "            <!-- Search body -->\n" +
            "            <div id=\"search\" class=\"panel-collapse collapse\">\n" +
            "                <div class=\"panel-body\">\n";
            SearchBox search = new SearchBox();
            form += search.searchBox2();
            form +=        "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Menu -->\n" +
            "    <div class=\"side-menu-container\">\n" +
            "        <ul class=\"nav navbar-nav\">\n" +
            "\n" +
            "            <li class=\"active\"><a href=\"../tutorWelcome.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n" +
            "            <li class=\"active\"><a href=\"../registerStudent.jsp\"><span class=\"glyphicon glyphicon-plus\"></span> Register a student</a></li>\n" +    
            "            <li class=\"active\"><a href=\"../student-years/groupSearch.jsp\"><span class=\"glyphicon glyphicon-pencil\"></span> Grade students</a></li>\n" + 
            "            <li class=\"active\"><a href=\"../markingDescriptors.jsp\"><span class=\"glyphicon glyphicon-edit\"></span> Marking Descriptors</a></li>\n" +
            "\n" +
            "            <!-- Dropdown-->\n" +
            "            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                <a data-toggle=\"collapse\" href=\"#dropdown-lvl1\">\n" +
            "                    <span class=\"glyphicon glyphicon-folder-open\"></span> Student Analysis<span class=\"caret\"></span>\n" +
            "                </a>\n" +
            "\n" +
            "                <!-- Dropdown level 1 -->\n" +
            "                <div id=\"dropdown-lvl1\" class=\"panel-collapse collapse\">\n" +
            "                    <div class=\"panel-body\">\n" +
            "                        <ul class=\"nav navbar-nav\">\n" +
            "                            <li><a href=\"../summaryData/summaryData.jsp\">All Students</a></li>\n" +       
            "\n" +
            "                            <!-- Dropdown level 2 -->\n" +
            "                            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                                <a data-toggle=\"collapse\" href=\"#dropdown-lvl2\">\n" +
            "                                    <span class=\"glyphicon glyphicon-list-alt\"></span> Groups <span class=\"caret\"></span>\n" +
            "                                </a>\n" +
            "                                <div id=\"dropdown-lvl2\" class=\"panel-collapse collapse\">\n" +
            "                                    <div class=\"panel-body\">\n" +
            "                                        <ul class=\"nav navbar-nav\">\n" +
            "                                            <li><a href=\"../summaryData/3.1.jsp\">3.1</a></li>\n" +
            "                                            <li><a href=\"../summaryData/3.2.jsp\">3.2</a></li>\n" +
            "                                            <li><a href=\"../summaryData/3.3.jsp\">3.3</a></li>\n" +
            "                                            <li><a href=\"../summaryData/3.4.jsp\">3.4</a></li>\n" +
            "                                            <li><a href=\"../summaryData/3.5.jsp\">3.5</a></li>\n" +
            "                                            <li><a href=\"../summaryData/4.1.jsp\">4.1</a></li>\n" +
            "                                            <li><a href=\"../summaryData/4.2.jsp\">4.2</a></li>\n" +
            "                                            <li><a href=\"../summaryData/4.3.jsp\">4.3</a></li>\n" +
            "                                            <li><a href=\"../summaryData/4.4.jsp\">4.4</a></li>\n" +
            "                                            <li><a href=\"../summaryData/4.5.jsp\">4.5</a></li>\n" +
            "                                            <li><a href=\"../summaryData/5.1.jsp\">5.1</a></li>\n" +
            "                                            <li><a href=\"../summaryData/5.2.jsp\">5.2</a></li>\n" +
            "                                            <li><a href=\"../summaryData/5.3.jsp\">5.3</a></li>\n" +
            "                                            <li><a href=\"../summaryData/5.4.jsp\">5.4</a></li>\n" +
            "                                            <li><a href=\"../summaryData/5.5.jsp\">5.5</a></li>\n" +
            "                                        </ul>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </li>\n" +
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </li>\n" +
            "\n" +
            "\n" +
            "        </ul>\n" +
            "    </div><!-- /.navbar-collapse -->\n" +
            "</nav>\n" +
            "    \n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Content -->\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <div class=\"side-body\">\n";
         
         return form;
    }
    
    
     public String tutorSummaryNavigation2(){
         String form = "<div class=\"row\">\n";
            form += "<!-- uncomment code for absolute positioning tweek see top comment in css -->\n" +
            "    <div class=\"absolute-wrapper\"> </div>\n" +
            "    <!-- Menu -->\n" +
            "    <div class=\"side-menu\">\n" +
            "    \n" +
            "    <nav class=\"navbar navbar-default\" role=\"navigation\">\n" +
            "    <!-- Brand and toggle get grouped for better mobile display -->\n" +
            "    <div class=\"navbar-header\">\n" +
            "        <div class=\"brand-wrapper\">\n" +
            "            <!-- Hamburger -->\n" +
            "            <button type=\"button\" class=\"navbar-toggle\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "\n" +
            "            <!-- Brand -->\n" +
            "            <div class=\"brand-name-wrapper\">\n" +
            "                <a class=\"navbar-brand\" href=\"../index.jsp\">\n" +
            "                 <span class=\"glyphicon glyphicon-repeat\">   Logout\n" +
            "                </a>\n" +
            "            </div>\n" +
            "\n" +
            "            <!-- Search -->\n" +
            "            <a data-toggle=\"collapse\" href=\"#search\" class=\"btn btn-default\" id=\"search-trigger\">\n" +
            "                <span class=\"glyphicon glyphicon-search\"></span>\n" +
            "            </a>\n" +
            "\n" +
            "            <!-- Search body -->\n" +
            "            <div id=\"search\" class=\"panel-collapse collapse\">\n" +
            "                <div class=\"panel-body\">\n";
            SearchBox search = new SearchBox();
            form += search.searchBox2();
            form +=        "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "\n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Menu -->\n" +
            "    <div class=\"side-menu-container\">\n" +
            "        <ul class=\"nav navbar-nav\">\n" +
            "\n" +
            "            <li class=\"active\"><a href=\"../tutorWelcome.jsp\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n" +
            "            <li class=\"active\"><a href=\"../registerStudent.jsp\"><span class=\"glyphicon glyphicon-plus\"></span> Register a student</a></li>\n" +    
            "            <li class=\"active\"><a href=\"../student-years/groupSearch.jsp\"><span class=\"glyphicon glyphicon-pencil\"></span> Grade students</a></li>\n" + 
            "            <li class=\"active\"><a href=\"../markingDescriptors.jsp\"><span class=\"glyphicon glyphicon-edit\"></span> Marking Descriptors</a></li>\n" +
            "\n" +
            "            <!-- Dropdown-->\n" +
            "            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                <a data-toggle=\"collapse\" href=\"#dropdown-lvl1\">\n" +
            "                    <span class=\"glyphicon glyphicon-folder-open\"></span> Student Analysis<span class=\"caret\"></span>\n" +
            "                </a>\n" +
            "\n" +
            "                <!-- Dropdown level 1 -->\n" +
            "                <div id=\"dropdown-lvl1\" class=\"panel-collapse collapse\">\n" +
            "                    <div class=\"panel-body\">\n" +
            "                        <ul class=\"nav navbar-nav\">\n" +
            "                            <li><a href=\"summaryData.jsp\">All Students</a></li>\n" +
            "\n" +
            "                            <!-- Dropdown level 2 -->\n" +
            "                            <li class=\"panel panel-default\" id=\"dropdown\">\n" +
            "                                <a data-toggle=\"collapse\" href=\"#dropdown-lvl2\">\n" +
            "                                    <span class=\"glyphicon glyphicon-list-alt\"></span> Groups <span class=\"caret\"></span>\n" +
            "                                </a>\n" +
            "                                <div id=\"dropdown-lvl2\" class=\"panel-collapse collapse\">\n" +
            "                                    <div class=\"panel-body\">\n" +
            "                                        <ul class=\"nav navbar-nav\">\n" +
            "                                            <li><a href=\"3.1.jsp\">3.1</a></li>\n" +
            "                                            <li><a href=\"3.2.jsp\">3.2</a></li>\n" +
            "                                            <li><a href=\"3.3.jsp\">3.3</a></li>\n" +
            "                                            <li><a href=\"3.4.jsp\">3.4</a></li>\n" +
            "                                            <li><a href=\"3.5.jsp\">3.5</a></li>\n" +
            "                                            <li><a href=\"4.1.jsp\">4.1</a></li>\n" +
            "                                            <li><a href=\"4.2.jsp\">4.2</a></li>\n" +
            "                                            <li><a href=\"4.3.jsp\">4.3</a></li>\n" +
            "                                            <li><a href=\"4.4.jsp\">4.4</a></li>\n" +
            "                                            <li><a href=\"4.5.jsp\">4.5</a></li>\n" +
            "                                            <li><a href=\"5.1.jsp\">5.1</a></li>\n" +
            "                                            <li><a href=\"5.2.jsp\">5.2</a></li>\n" +
            "                                            <li><a href=\"5.3.jsp\">5.3</a></li>\n" +
            "                                            <li><a href=\"5.4.jsp\">5.4</a></li>\n" +
            "                                            <li><a href=\"5.5.jsp\">5.5</a></li>\n" +
            "                                        </ul>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </li>\n" +       
            "                        </ul>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </li>\n" +
            "\n" +
            "\n" +
            "        </ul>\n" +
            "    </div><!-- /.navbar-collapse -->\n" +
            "</nav>\n" +
            "    \n" +
            "    </div>\n" +
            "\n" +
            "    <!-- Main Content -->\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <div class=\"side-body\">\n";
         
         return form;
    }
    
    
    public String footer(){
        form = "        </div>\n" +
               "    </div>\n" +
               "</div>";
        
        return form;
    }
}
