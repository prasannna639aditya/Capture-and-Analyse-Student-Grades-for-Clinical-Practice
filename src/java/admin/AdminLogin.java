/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author Delaney
 */

import dbpackage.DatabaseClass;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import passwordhash.PasswordHash;

/**
 *
 * @author Delaney
 */
public class AdminLogin {
    private String AdminID; 
    private String password;
    private String firstName;
    private String lastName;
    private String department;
    private String passwordToCheck;
    private String[] result;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    /**
     * Constructor for the class
     */
    public AdminLogin(){
        this.AdminID = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.department = "";
        this.passwordToCheck = "";
        this.result = new String[10];
        
        database = new DatabaseClass( );
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        errors = new ArrayList<>( );
    }
    /**
    * Getter method for the user's Admin ID.
    * @return AdminID (string)
    **/
    public String getAdminID() {
        return AdminID;
    }
    /**
     * Setter method for the user's Admin ID.
     * @param AdminID (string)
     */
    public void setAdminID(String AdminID) {
        this.AdminID = AdminID;
    }
    /**
     * Getter method for the user's first name
     * @return the variable firstName (string)
     */
    public String getFirstName( ) {
        return firstName;
    }
    /**
     * Getter method for the user's last name (surname)
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    
    public String getDepartment( ){
        return department;
    }
    public String getpasswordToCheck( ) {
        return passwordToCheck;
    }
    
    public void setPasswordToCheck(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }

    /**
     * Function used to log the user into the system, giving them access to view timetables,
     * add events and use the system.
     * @param request (HttpServletRequest)
     * @return true if logged in and false if otherwise.
     */
    public boolean loginAdmin( HttpServletRequest request ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception  {
        AdminID = request.getParameter( "AdminID" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM Admin WHERE AdminID = '" + AdminID + "';" );
        
        if( result.length != 0 ) {
            AdminID = result[0];
            firstName = result[1];
            lastName = result[2];
            department = result[3];
            passwordToCheck = result[4];
            
        }
        
        if( ! validateLogin( ) ){
            return false;
        }
        
        database.Close();
  
        return result.length != 0;
    }
    /**
     * Function to validate if the user's log in credentials are correct. ie. they match
     * the TutorID and password stored in the database
     * @return true if correct and false if otherwise.
     */
    public boolean validateLogin( ) throws Exception{
        boolean isValid = true;
        
        if( AdminID.equals( "" ) ) {
           isValid = false;
        }
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        if( PasswordHash.check( password, passwordToCheck) == false){
           errors.add( "Admin ID or Password is incorrect" );
           isValid = false;
        }
        
        return isValid;
    }  
    
    /**
     * Function to print any error messages that may have been collected throughout the 
     * login process
     * @return errorList (string)
     */
    public String printErrors( ) {
        String errorList;
        
        errorList = "<div>";
            for( String error: errors ) {
                errorList += error;
            }
        errorList += "</div>";
        
        return errorList;
    }
    
    /**
    public String adminLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"adminLogin.jsp\" method=\"POST\">\n";
               form += "<label for=\"AdminID\">Admin ID:</label>\n";
               form += "<input type=\"text\" name=\"AdminID\" value=\"" + AdminID + "\"placeholder=\"TutorID\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }**/
    
    public String adminLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"adminLogin.jsp\" method=\"POST\">\n";
               form += "<div class=\"container\">\n" +
        "        <div class=\"card card-container\">\n" +
        "            <!-- <img class=\"profile-img-card\" src=\"//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120\" alt=\"\" /> -->\n" +
        "            <img id=\"profile-img\" class=\"profile-img-card\" src=\"//ssl.gstatic.com/accounts/ui/avatar_2x.png\" />\n" +
        "            <p id=\"profile-name\" class=\"profile-name-card\"></p>\n" +
        "            <h1>Welcome Admin</h1>\n" +               
        "            <form class=\"form-signin\">\n" +
        "                <span id=\"reauth-email\" class=\"reauth-email\"></span>\n" +
        "                <input type=\"text\" id=\"inputEmail\" name=\"AdminID\" class=\"form-control\" placeholder=\"Admin ID\" required autofocus>\n" +
        "                <input type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n" + 
        "                <input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n" +
        "            </form><!-- /form -->\n" +
        "        </div><!-- /card-container -->\n" +
        "    </div><!-- /container -->";
               form += "</form>";
        return form;
    }
 
}
