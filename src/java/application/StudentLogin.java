/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
    private String[] result;
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
        this.result = new String[10];
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
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        //database.setup( "ec2-52-31-84-76.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
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
        
        //database.Close();
  
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
        }
        if( password.equals( "" ) ) {
            isValid = false;
        }
        if( PasswordHash.check( password, passwordToCheck) == false){
           isValid = false;
        }
        
        
        return isValid;
    }  
    /**
     * Form used by the user to log into the system
     * @return form (string)
     */
    /**
    public String loginForm( ) {
        String form = "<form name=\"login_form\" action=\"studentLogin.jsp\" method=\"POST\">\n";
               form += "<label for=\"StudentID\">Student ID:</label>\n";
               form += "<input type=\"text\" name=\"StudentID\" value=\"" + StudentID + "\"placeholder=\"Enter StudentID\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    } **/
    
    public String studentLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"studentLogin.jsp\" method=\"POST\">\n";
               form += "<label for=\"StudentID\">Student ID:</label>\n";
               form += "<input type=\"text\" name=\"StudentID\" value=\"" + StudentID + "\"placeholder=\"StudentID\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }
 
}

