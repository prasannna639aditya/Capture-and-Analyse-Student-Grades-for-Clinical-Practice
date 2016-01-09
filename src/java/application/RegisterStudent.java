/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.Date;
import dbpackage.DatabaseClass;
import emailsender.Email;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import passwordhash.PasswordHash;

/**
 *
 * @author Delaney
 */
public class RegisterStudent {
    private String studentID;
    private String yearID;
    private String groupID;
    private String firstName;
    private String lastName;
    private String email;
    private String password1;
    private String password2;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public RegisterStudent( ){
        studentID = "";
        yearID = "";
        groupID = "";
        firstName = "";
        lastName = "";
        email = "";
        password1 = "";
        password2 = "";
        errors = new ArrayList<>( );

        database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
    }
    
    public String getStudentID( ) {
        return studentID;
    }

        
    public void setStudentID( final String studentID ) {
        this.studentID = studentID;
    }

    public String getYearID( ) {
        return yearID;
    }

    public void setYearID( final String yearID ) {
        this.yearID = yearID;
    }
    
    public String getGroupID( ) {
        return groupID;
    }

    public void setGroupID( final String groupID ) {
        this.groupID = groupID;
    }

    public String getFirstName( ) {
        return firstName;
    }
    /**
     * setter method for the user's first name
     * @param firstName (string)
     */
    public void setFirstName( final String firstName ) {
        this.firstName = firstName;
    }

    /**
     * Getter method for the user's last name
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    /**
     * Setter method for the user's last name
     * @param lastName (string)
     **/
    public void setLastName( final String lastName ) {
        this.lastName = lastName;
    }
    /**
     * Getter method for the user's email address
     * @return the variable email (string)
     */
    public String getEmail( ) {
        return email;
    }
    /**
     * Setter method for the user's email address
     * @param email (string)
     */
    public void setEmail( final String email ) {
        this.email = email;
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

    /**
     * Ensures the form is filled out correctly by the user.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateRegForm( ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        boolean isValid = true;
        
        if(doesUserExist(studentID)) {
            errors.add( "User already exists" );
            isValid = false;
            studentID = "";
        }
        
        if( studentID.equals( "" ) || studentID.length( ) != 9 || ! isInteger( studentID )) {
            errors.add( "User ID required. Must be valid ID and 9 digits in length" );
            isValid = false;
            studentID = "";
        }
        
        if( firstName.equals( "" )  ) {
            errors.add( "First Name required." );
            isValid = false;
            firstName = "";
        }
      
        if( lastName.equals( "" )  ) {
            errors.add( "Last Name required." );
            isValid = false;
            lastName = "";
        }
        
        if( email.equals( "" ) || ! email.contains( "@" ) || ! email.contains( "." ) ) {
            errors.add( "Email required. Must be valid email address" );
            isValid = false;
            email = "";
        }
        
        if( password1.equals( "" ) ) {
            errors.add( "Password required. Min length is 6 characters" );
            isValid = false;
        }
        
        if( password2.equals( "" ) ) {
            errors.add( "Confirm Password required." );
            isValid = false;
        }
        
        if( ! password1.equals( password2 ) ){
            errors.add( "Passwords do not match. Must be identical" );
            isValid = false;
        }
        
        
        if( isValid ) {
            registerNewUser( );
            
            // This will not work in the labs, as UCC blocks the smpt port
            // If you are running at home uncomment the two lines below and it will 
            // send an email to new registered users.
            
            Email email = new Email( );
            email.sendEmailToNewRegUser( studentID, firstName, getEmail( ) );
        }
        
        return isValid;
    }
    
    public boolean doesUserExist(String studentID) {
        String[] dbResult = database.SelectRow( "SELECT StudentID FROM Students WHERE StudentID = '" + studentID + "';" );
        
        if(dbResult.length != 0) {
            return true;
        }
        return false;
    }
    /**
     * Function to register the new student into the database.
     */
    public void registerNewUser(  ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
       
        database.Insert( "INSERT INTO Students( StudentID, Password, FirstName, LastName, Email )" +
                         "VALUES( '" + studentID + "', '" + PasswordHash.getSaltedHash(password2)  + "', '" + firstName + "', '" + lastName+ "', '" + email + "');" );
        
        database.Insert( "INSERT INTO StudentClass( StudentID, YearID, GroupID )" +
                         "VALUES( '" + studentID + "', '" + yearID + "','" + groupID + "' );" );
        
        database.Close();
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



    public String[] getStudent( String studentID ) {
        String[] dbResult = database.SelectRow( "SELECT * FROM Students WHERE StudentID = '" + studentID + "';" );
        
        database.Close();
        return dbResult;
    }

    
     public String registrationForm( ) {
        String form = "<form name='registration_form' action='registerStudent.jsp' method='POST'>\n";
        form += "<label for='studentID'>Id Number:</label>\n";
        form += "<input type='text' name='studentID' value='" + studentID + "' placeholder='123456789' /><br />\n";
        
        form += "<label for='groupID'>Group Description:</label>\n";
        form += "<select name=\"groupID\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>3.1</option>\n" +
                    "  <option value=\"2\">3.2</option>\n" +
                    "  <option value=\"3\">3.3</option>\n" +
                    "  <option value=\"4\">3.4</option>\n" +
                    "  <option value=\"5\">3.5</option>\n" +
                    "  <option value=\"6\">4.1</option>\n" +
                    "  <option value=\"7\">4.2</option>\n" +
                    "  <option value=\"8\">4.3</option>\n" +
                    "  <option value=\"9\">4.4</option>\n" +
                    "  <option value=\"10\">4.5</option>\n" +
                    "  <option value=\"11\">5.1</option>\n" +
                    "  <option value=\"12\">5.2</option>\n" +
                    "  <option value=\"13\">5.3</option>\n" +
                    "  <option value=\"13\">5.4</option>\n" +
                    "  <option value=\"13\">5.5</option>\n" +
                "</select><br />"; 
        form += "<label for='yearID'>Year:</label>\n";
        form += "<select name=\"yearID\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                "</select><br />";       
        form += "<label for='firstName'>First Name:</label>\n";
        form += "<input type='text' name='firstName' value='" + firstName +  "' placeholder='John' /><br />\n";
        form += "<label for='lastName'>Last Name:</label>\n";
        form += "<input type='text' name='lastName' value='" + lastName +  "' placeholder='Smith' /><br />\n";
        form += "<label for='email'>Email:</label>\n";
        form += "<input type='email' id='email' name='email' value='" + email +  "' placeholder='martin@live.ie' /><br />\n";
        form += "<label for='password1'>Password:</label>\n";
        form += "<input type='password' name='password1' /><br />\n";
        form += "<label for='password2'>Confirm Password:</label>\n";
        form += "<input type='password' name='password2' /><br />\n"; 
        
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</form>\n";
        
        return form;
    }

}
