/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
public class TutorLogin {
    private String TutorID; 
    private String password;
    private String firstName;
    private String lastName;
    private String department;
    private String picture;
    private String passwordToCheck;
    private final DatabaseClass database;
    private String[] result;
    private final ArrayList<String> errors;
    /**
     * Constructor for the class
     */
    public TutorLogin(){
        this.TutorID = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.department = "";
        this.picture = "";
        this.passwordToCheck = "";
        database = new DatabaseClass( );
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        this.result = new String[10];
        errors = new ArrayList<>( );
    }
    /**
    * Getter method for the user's TutorID.
    * @return TutorID (string)
    **/
    public String getTutorID() {
        return TutorID;
    }
    /**
     * Setter method for the user's TutorID
     * @param TutorID (string)
     */
    public void setTutorID(String TutorID) {
        this.TutorID = TutorID;
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
    
    public String getPicture ( ){
        return picture;
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
    public boolean loginTutor( HttpServletRequest request ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception  {
        TutorID = request.getParameter( "TutorID" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM Tutors WHERE TutorID = '" + TutorID + "';" );
        
        if( result.length != 0 ) {
            TutorID = result[0];
            firstName = result[1];
            lastName = result[2];
            department = result[3];
            passwordToCheck = result[4];
            picture = result[5];
            
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
        TutorLogin tutor = new TutorLogin();
        
        if( TutorID.equals( "" ) ) {
            isValid = false;
        }
        
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        if( PasswordHash.check( password, passwordToCheck) == false){
           errors.add( "Tutor ID or Password is incorrect" );
           isValid = false;
        }
        
        return isValid;
    }  
    
    public Boolean doesTutorExist(String tutorID){
        result = database.SelectRow( "SELECT * FROM Tutors WHERE TutorID = '" + tutorID + "';" );
        Boolean isTutor = false;
        
        if( result.length != 0 ) {
          isTutor = true;  
        }
       
      database.Close();
      return isTutor;  
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
    
    public String tutorLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"tutorLogin.jsp\" method=\"POST\">\n";
               form += "<div class=\"container\">\n" +
        "        <div class=\"card card-container\">\n" +
        "            <!-- <img class=\"profile-img-card\" src=\"//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120\" alt=\"\" /> -->\n" +
        "            <img id=\"profile-img\" class=\"profile-img-card\" src=\"//ssl.gstatic.com/accounts/ui/avatar_2x.png\" />\n" +
        "            <p id=\"profile-name\" class=\"profile-name-card\"></p>\n" +
        "            <h1>Welcome Tutor</h1>\n" +               
        "            <form class=\"form-signin\">\n" +
        "                <span id=\"reauth-email\" class=\"reauth-email\"></span>\n" +
        "                <input type=\"text\" id=\"inputEmail\" name=\"TutorID\" class=\"form-control\" placeholder=\"Tutor ID\" required autofocus>\n" +
        "                <input type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n" + 
        "                <input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n" +
        "            </form><!-- /form -->\n" +
        "        </div><!-- /card-container -->\n" +
        "    </div><!-- /container -->";
               form += "</form>";
        return form;
    }
 
}