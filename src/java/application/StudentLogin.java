/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import passwordhash.PasswordHash;
import sun.security.util.Password;

/**
 *
 * @author Delaney
 */
public class StudentLogin {
    private String StudentID; 
    private String password;
    private String firstName;
    private String lastName;
    private String picture;
    private String passwordToCheck;
    private String hashCheck;
    private final DatabaseClass database;
    private String[] result;
    private final ArrayList<String> errors;
    
    /**
     * Constructor for the class
     */
    public StudentLogin(){
        this.StudentID = "";
        this.password = "";
        this.firstName = "";
        this.hashCheck = "";
        this.picture = "";
        this.passwordToCheck = "";
        database = new DatabaseClass( );
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        this.result = new String[10];
        errors = new ArrayList<>( );
    }
    /**
    * Getter method for the user's StudentID.
    * @return StudentID (string)
    **/
    public String getStudentID() {
        return StudentID;
    }
    /**
     * Setter method for the user's StudentID
     * @param StudentID (string)
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }
    /**
     * Getter method for the user's first name
     * @return the variable firstName (string)
     */
    public String getFirstName( ) {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Getter method for the user's last name (surname)
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPicture( ) {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String getpasswordToCheck( ) {
        return passwordToCheck;
    }
    
    public void setPasswordToCheck(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }
    
    public boolean loginStudent( HttpServletRequest request ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        PasswordHash hash = new PasswordHash();
 

        StudentID = request.getParameter( "StudentID" );
        password = request.getParameter( "password" );
        
        
        result = database.SelectRow( "SELECT * FROM Students WHERE StudentID = '" + StudentID + "';" );
        
            
        
        if( result.length != 0 ) {
            StudentID = result[0];
            passwordToCheck = result[1];
            firstName = result[2];
            lastName = result[3];
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
     * the StudentID and password stored in the database
     * @return true if correct and false if otherwise.
     */
    public boolean validateLogin( ) throws Exception{
        boolean isValid = true;
        
        if( StudentID.equals( "" ) ) {
            isValid = false;
            StudentID = "";
        }
        if( password.equals( "" ) ) {
            errors.add( "Please enter a valid password" );
            isValid = false;
            password = "";
        }
        if( PasswordHash.check( password, passwordToCheck) == false){
           errors.add( "Student ID or Password is incorrect" );
           isValid = false;
           password = "";
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
    
    public String studentLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"studentLogin.jsp\" method=\"POST\">\n";
               form += "<div class=\"container\">\n" +
        "        <div class=\"card card-container\">\n" +
        "            <!-- <img class=\"profile-img-card\" src=\"//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120\" alt=\"\" /> -->\n" +
        "            <img id=\"profile-img\" class=\"profile-img-card\" src=\"//ssl.gstatic.com/accounts/ui/avatar_2x.png\" />\n" +
        "            <p id=\"profile-name\" class=\"profile-name-card\"></p>\n" +
        "            <h1>Welcome Student</h1>\n" +               
        "            <form class=\"form-signin\">\n" +
        "                <span id=\"reauth-email\" class=\"reauth-email\"></span>\n" +
        "                <input type=\"text\" id=\"inputEmail\" name=\"StudentID\" class=\"form-control\" placeholder=\"Student ID\" required autofocus>\n" +
        "                <input type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n" + 
        "                <input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n" +
        "            </form><!-- /form -->\n" +
        "        </div><!-- /card-container -->\n" +
        "    </div><!-- /container -->";
               form += "</form>";
        return form;
    }
}

