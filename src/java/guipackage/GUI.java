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
        form += "<a class=\"navbar-brand topnav\" href=\"#\">Start Bootstrap</a>\n";
        form += "<a class=\"navbar-brand topnav\" href=\"#\">Start Bootstrap</a>\n";
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
    

   /**     
        public String header(boolean printName, String firstName, String lastName) {
        form = "<nav class=\"navbar navbar-default navbar-fixed-top topnav\" role=\"navigation\">\n";
        form += "<div class=\"container topnav\">\n";
        form += "<div class=\"navbar-header\">\n";
        form += "<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n"; 
        form += "<span class=\"sr-only\">Toggle navigation</span>\n";
        form += "<span class=\"icon-bar\"></span>\n";
        form += "<span class=\"icon-bar\"></span>\n";
        form += "<span class=\"icon-bar\"></span>\n";
        form += "</button>\n";        
        if(printName) {
            form += "<h3 id=\"welcomeH\">Welcome "+firstName+" "+lastName+"</h3>";
        }
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
        **/
        
    public String tutorNavigation(boolean printName, String firstName, String lastName) {
        form = "<div id=\"wrapper\">\n";
        form += "<div id=\"sidebar-wrapper\">\n";
        form += "<ul class=\"sidebar-nav\">\n";
        form += "<li class=\"sidebar-brand\">\n"; 
        if(printName) {
            form += "<h3 id=\"welcomeH\">Welcome "+firstName+" "+lastName+"</h3>";
        }
        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"tutorWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"registerStudent.jsp\">Register a Student</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "<h1>Simple Sidebar</h1>\n";
        form += "<p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>\n";
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
        if(printName) {
            form += "<h3 id=\"welcomeH\">Welcome "+firstName+" "+lastName+"</h3>";
        }
        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "</li>\n";
        form += "<li><a href=\"tutorWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "</ul>\n";        
        form += "</div>\n";
        form += "<div id=\"page-content-wrapper\">\n";  
        form += "<div class=\"container-fluid\">\n";
        form += "<div class=\"row\">\n";
        form += "<div class=\"col-lg-12\">\n";
        form += "<a href=\"#menu-toggle\" class=\"btn btn-default\" id=\"menu-toggle\">Toggle Menu</a>\n";
        form += "<h1>Simple Sidebar</h1>\n";
        form += "<p></p>\n";
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
        form += "</li>\n";
        form += "<a href=\"index.jsp\">Logout</a>\n";
        form += "<li><a href=\"tutorWelcome.jsp\">Home</a></li>\n";
        form += "<li><a href=\"registerStudent.jsp\">Register a Student</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
        form += "<li><a href=\"#\">Dashboard</a></li>\n";
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
