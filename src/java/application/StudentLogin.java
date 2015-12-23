/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Delaney
 */
public class StudentLogin {
    private String StudentID; 
    private String password;
    private String firstName;
    private String lastName;
    private String[] result;
    /**
     * Constructor for the class
     */
    public StudentLogin(){
        this.StudentID = "";
        this.password = "";
        this.firstName = "";
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
    /**
     * Getter method for the user's last name (surname)
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    /**
     * Function used to log the user into the system, giving them access to view timetables,
     * add events and use the system.
     * @param request (HttpServletRequest)
     * @return true if logged in and false if otherwise.
     */
    public boolean loginUser( HttpServletRequest request ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );

        
        
        StudentID = request.getParameter( "StudentID" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM Students WHERE StudentID = '" + StudentID + 
                                     "' AND Password = '" + password  + "';" );
        
        if( result.length != 0 ) {
            firstName = result[2];
            lastName = result[4];
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
    public boolean validateLogin( ){
        boolean isValid = true;
        
        if( StudentID.equals( "" ) ) {
            isValid = false;
        }
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        return isValid;
    }  
    /**
     * Form used by the user to log into the system
     * @return form (string)
     */
    public String loginForm( ) {
        String form = "<form name=\"login_form\" action=\"index.jsp\" method=\"POST\">\n";
               form += "<label for=\"StudentID\">UCC ID:</label>\n";
               form += "<input type=\"text\" name=\"StudentID\" value=\"" + StudentID + "\"placeholder=\"Enter StudentID\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }
}

