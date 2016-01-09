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
public class TutorLogin {
    private String TutorID; 
    private String password;
    private String firstName;
    private String lastName;
    private String department;
    private String picture;
    private String[] result;
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
        this.result = new String[10];
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
    /**
     * Function used to log the user into the system, giving them access to view timetables,
     * add events and use the system.
     * @param request (HttpServletRequest)
     * @return true if logged in and false if otherwise.
     */
    public boolean loginTutor( HttpServletRequest request ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );

        
        
        TutorID = request.getParameter( "TutorID" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM Tutors WHERE TutorID = '" + TutorID + 
                                     "' AND Password = '" + password  + "';" );
        
        if( result.length != 0 ) {
            firstName = result[1];
            lastName = result[2];
            department = result[3];
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
     * the TutorID and password stored in the database
     * @return true if correct and false if otherwise.
     */
    public boolean validateLogin( ){
        boolean isValid = true;
        
        if( TutorID.equals( "" ) ) {
            isValid = false;
        }
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        return isValid;
    }  
    
    
    public String tutorLoginForm( ) {
        String form = "<form name=\"login_form\" action=\"tutorLogin.jsp\" method=\"POST\">\n";
               form += "<label for=\"TutorID\">Tutor ID:</label>\n";
               form += "<input type=\"text\" name=\"TutorID\" value=\"" + TutorID + "\"placeholder=\"TutorID\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }
 
}