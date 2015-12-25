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
}
