package guipackage;
/**
 *
 * @author Delaney
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class GUI {
    private String form;
    private final SecureRandom random;

    public GUI( ) {
        this.random = new SecureRandom( );
    }

    public String nextSessionId( ) {
        return new BigInteger( 130, random ).toString( 32 );
    }
    
    public String loginHeader( ) {
        form = "<nav class=\"navbar navbar-default navbar-fixed-top topnav\" role=\"navigation\">\n";
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
        form += "<a href=\"#services\">Services</a>\n";
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
    

        
    public String tutorWelcomeNavigation(boolean printName, String TutorID, String firstName, String lastName, String department, String picture) {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 

        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"tutorWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"registerStudent.jsp\">Register a Student</a></li>\n";
        form += "<li><a href=\"markStudent.jsp\">Grade Student</a></li>\n";
        form += "<li><a href=\"student-years/students.jsp\">Students</a></li>\n";
        form += "<li><a href=\"summaryData/summaryData.jsp\">Summary Data</a></li>\n";
        form += "<li>\n" +
        "    <div class=\"input-group\">\n" +
        "      <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\">\n" +
        "      <span class=\"input-group-btn\">\n" +
        "        <button class=\"btn btn-default\" type=\"button\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span></button>\n" +
        "      </span>\n" +
        "    </div><!-- /input-group --></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        
        if(printName) {
            
                   form += "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Picture</th>\n";
                   form += "<th>Tutor ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "<th>Department</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   form += "<tr>\n";
                   form += "<td><img src=\"" + picture + "\"</td>\n";
                   form += "<td>" + TutorID + "</td>\n";
                   form += "<td>" + firstName + "</td>\n";
                   form += "<td>" + lastName + "</td>\n";
                   form += "<td>" + department + "</td>\n";
                   form += "</tr>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   form += "</div>\n";
            
        }
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "<script src=\"js/jquery.js\"></script>\n";
        form += "<script src=\"js/bootstrap.min.js\"></script>\n";
        form += "    <script>$(\"#menu-toggle\").click(function(e) {e.preventDefault();$(\"#wrapper\").toggleClass(\"toggled\");});</script>\n";
        return form;
    }
    
    public String tutorNavigation() {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 

        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"tutorWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"registerStudent.jsp\">Register a Student</a></li>\n";
        form += "<li><a href=\"markStudent.jsp\">Grade Student</a></li>\n";
        form += "<li><a href=\"student-years/students.jsp\">Students</a></li>\n";
        form += "<li><a href=\"summaryData/summaryData.jsp\">Summary Data</a></li>\n";
        form += "<li>\n" +
        "    <div class=\"input-group\">\n" +
        "      <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\">\n" +
        "      <span class=\"input-group-btn\">\n" +
        "        <button class=\"btn btn-default\" type=\"button\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span></button>\n" +
        "      </span>\n" +
        "    </div><!-- /input-group --></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "<script src=\"js/jquery.js\"></script>\n";
        form += "<script src=\"js/bootstrap.min.js\"></script>\n";
        form += "    <script>$(\"#menu-toggle\").click(function(e) {e.preventDefault();$(\"#wrapper\").toggleClass(\"toggled\");});</script>\n";
        return form;
    }
    
    
    public String studentWelcomeNavigation(boolean printName, String StudentID, String firstName, String lastName, String picture) {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 

        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"studentWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"studentGradeView.jsp\">View Treatments</a></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        if(printName) {
            
                   form += "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Picture</th>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   form += "<tr>\n";
                   form += "<td><img src=\"" + picture + "\"</td>\n";
                   form += "<td>" + StudentID + "</td>\n";
                   form += "<td>" + firstName + "</td>\n";
                   form += "<td>" + lastName + "</td>\n";
                   form += "</tr>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   form += "</div>\n";
            
        }
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "<script src=\"js/jquery.js\"></script>\n";
        form += "<script src=\"js/bootstrap.min.js\"></script>\n";
        form += "    <script>$(\"#menu-toggle\").click(function(e) {e.preventDefault();$(\"#wrapper\").toggleClass(\"toggled\");});</script>\n";
        return form;
    }
    
    
        public String studentNavigation(boolean printName, String firstName, String lastName) {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 
        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"studentWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"studentGradeView.jsp\">View Treatments</a></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "<script src=\"js/jquery.js\"></script>\n";
        form += "<script src=\"js/bootstrap.min.js\"></script>\n";
        form += "    <script>$(\"#menu-toggle\").click(function(e) {e.preventDefault();$(\"#wrapper\").toggleClass(\"toggled\");});</script>\n";
        return form;
    }
    
        public String navigation() {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 
        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"studentWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"studentGradeView.jsp\">View Treatments</a></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "<script src=\"js/jquery.js\"></script>\n";
        form += "<script src=\"js/bootstrap.min.js\"></script>\n";
        form += "    <script>$(\"#menu-toggle\").click(function(e) {e.preventDefault();$(\"#wrapper\").toggleClass(\"toggled\");});</script>\n";
        return form;
    }
        
    
}
