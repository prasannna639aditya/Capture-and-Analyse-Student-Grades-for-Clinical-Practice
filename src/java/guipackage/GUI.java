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
            form += "<a href=\"#contact\">Contact</a>\n";
            form += "</li>\n";
            form += "</ul>\n";
            form += "</div>\n";
            form += "</div>\n";
            form += "</nav>\n";
        return form;
    }
    

        
    public String tutorDisplay(String TutorID, String firstName, String lastName, String department, String picture) {
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th></th>\n";
                   form += "<th>Tutor ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "<th>Department</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   form += "<tr>\n";
                   form += "<td><img class=\"img-circle\" src=\"" + picture + "\"</td>\n";
                   form += "<td>" + TutorID + "</td>\n";
                   form += "<td>" + firstName + "</td>\n";
                   form += "<td>" + lastName + "</td>\n";
                   form += "<td>" + department + "</td>\n";
                   form += "</tr>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   form += "</div>\n";
        
        return form;
    }
    
    
    public String studentPrint(String StudentID, String firstName, String lastName, String picture) {
        
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th></th>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   form += "<tr>\n";
                   form += "<td><img class=\"img-circle\" src=\"" + picture + "\"</td>\n";
                   form += "<td>" + StudentID + "</td>\n";
                   form += "<td>" + firstName + "</td>\n";
                   form += "<td>" + lastName + "</td>\n";
                   form += "</tr>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   form += "</div>\n";
        
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
            "                            <li><a href=\"student-years/2015.jsp\">2015 Summary Data</a></li>\n" +
            "                            <li><a href=\"student-years/2016.jsp\">2016 Summary Data</a></li>\n" +
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
            "                            <li><a href=\"../student-years/2015.jsp\">2015 Summary Data</a></li>\n" +
            "                            <li><a href=\"../student-years/2016.jsp\">2016 Summary Data</a></li>\n" +        
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
            "                            <li><a href=\"../student-years/2015.jsp\">2015 Summary Data</a></li>\n" +
            "                            <li><a href=\"../student-years/2016.jsp\">2016 Summary Data</a></li>\n" +
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
