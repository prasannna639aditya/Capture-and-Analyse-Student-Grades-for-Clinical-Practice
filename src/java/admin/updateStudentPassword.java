/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.Date;
import dbpackage.DatabaseClass;
import emailsender.Email;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import passwordhash.PasswordHash;

/**
 *
 * @author Delaney
 */
public class updateStudentPassword {
    private String studentID;
    private String password1;
    private String password2;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public updateStudentPassword( ){
        studentID = "";
        password1 = "";
        password2 = "";
        errors = new ArrayList<>( );

        database = new DatabaseClass( );
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
    }
    
    public String getStudentID( ) {
        return studentID;
    }

        
    public void setStudentID( final String studentID ) {
        this.studentID = studentID;
    }
    /**
     * Getter method for the user's password1 (the original password.)
     * @return the variable password1 (string)
     */
    public String getPassword1( ) {
        return password1;
    }
    /**
     * Setter method for the user's password1 (the original password)
     * @param password1 (string)
    */
    public void setPassword1( final String password1 ) {
        this.password1 = password1;
    }
    /**
     * Getter method for the user's password2 (the password used to confirm the 
     * user's password choice)
     * @return the variable password2 (string)
     */
    public String getPassword2( ) {
        return password2;
    }
    /**
     * Setter method for the user's password2 (the password used to confirm the 
     * user's password choice)
     * @param password2 (string)
     */
    public void setPassword2( final String password2 ) {
        this.password2 = password2;
    }
    
    public boolean doesStudentExist(String studentID) {
        String[] dbResult = database.SelectRow( "SELECT StudentID FROM Students WHERE StudentID = '" + studentID + "';" );
        
        if(dbResult.length != 0) {
            return true;
        }
        return false;
    }

    /**
     * Ensures the form is filled out correctly by the user.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateUpdateForm( ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        boolean isValid = true;
        
        if( studentID.equals( "" ) || studentID.length( ) != 9 || ! isInteger( studentID )) {
            errors.add( "User ID required. Must be valid ID and 9 digits in length" );
            isValid = false;
            studentID = "";
        }
        
        if( password1.equals( "" ) || password1.length() < 6 ) {
            errors.add( "Password required. Min length is 6 characters" );
            isValid = false;
        }
        
        if( password2.equals( "" ) || password2.length() < 6 ) {
            errors.add( "Confirm Password required." );
            isValid = false;
        }
        
        if( ! password1.equals( password2 ) ){
            errors.add( "Passwords do not match. Must be identical" );
            isValid = false;
        }
        
        if( doesStudentExist( studentID ) == false){
            errors.add( "Please enter a valid Student ID" );
            isValid = false;
        }
        
        
        if( isValid ) {
            changeStudentsPassword( );
        }
        
        return isValid;
    }
    /**
     * Function to register the new student into the database.
     */
    public void changeStudentsPassword(  ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //System.out.println("successful");
        String query = ("UPDATE Students SET Password = " + PasswordHash.getSaltedHash(password2) + " WHERE Students.StudentID = " + studentID + ";");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //database.Close();
    }
    /**
     * Function to print any error messages that may have been collected throughout the 
     * registration process
     * @return errorList (string)
     */
    public String printErrors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    /**
     * Function to check if a string can be parsed to an integer.
     * @param value
     * @return true if the string is a string representation of an integer and false if otherwise
     */
    public boolean isInteger( String value ) {
        try { 
            Integer.parseInt( value ); 
        } 
        catch( NumberFormatException exception ) { 
            return false; 
        }
        return true;
    }


    
     public String updateForm( ) {
        String form = "<p><form name='registration_form' action='updateStudentPassword.jsp' method='POST'>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='studentID'>Student Id Number:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input type='text' class=\"form-control\" name='studentID' value='" + studentID + "' placeholder='123456789' /><br />\n" 
                        + "</div>\n" 
                        + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='password1'>Password:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='password' name='password1' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='password2'>Confirm Password:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='password' name='password2' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n"; 
        form += "<div class=\"form-group row\">";
        form += "<div class=\"form-group row\">\n" +
            "    <div class=\"col-sm-offset-2 col-sm-10\">\n";
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</form></p>\n";
        
        return form;
    }

}
