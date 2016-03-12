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
public class RegisterPatient {
    private String dob;
    private String firstName;
    private String lastName;
    private String gender;
    private String cdsNumber;
    private String ethenticity;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public RegisterPatient( ){
        dob = "";
        firstName = "";
        lastName = "";
        gender = "";
        cdsNumber = "";
        ethenticity = "";
        errors = new ArrayList<>( );

        database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
    }
    
    public String getDob( ) {
        return dob;
    }

        
    public void setDob( final String dob ) {
        this.dob = dob;
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
    public String getEthenticity( ) {
        return ethenticity ;
    }
    
    public void setEthenticity( final String ethenticity ) {
        this.ethenticity = ethenticity ;
    }
    
    public String getCdsNumber( ) {
        return cdsNumber;
    }
 
    public void setCdsNumber( final String cdsNumber ) {
        this.cdsNumber = cdsNumber;
    }
    
    
    public String getGender( ) {
        return gender;
    }
 
    public void setGender( final String gender ) {
        this.gender = gender;
    }
    
    
    
    /**
     * Ensures the form is filled out correctly by the user.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateRegForm( ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        boolean isValid = true;
        if( firstName.equals( "" ) || isInteger( firstName ) ) {
            errors.add( "First Name required." );
            isValid = false;
            firstName = "";
        }
      
        if( lastName.equals( "" ) || isInteger( lastName ) ) {
            errors.add( "Last Name required." );
            isValid = false;
            lastName = "";
        }
        
        if( gender.equals( "" )) {
            errors.add( "Please enter the gender of the patient." );
            isValid = false;
            gender = "";
        }
        
        if( ethenticity.equals( "" )) {
            errors.add( "Please enter the patients ethenticity." );
            isValid = false;
            ethenticity = "";
        }
        
        if( cdsNumber.equals( "" )) {
            errors.add( "Please enter a valid CDS Number." );
            isValid = false;
            cdsNumber = "";
        }
        
        if( dob.equals( "" )) {
            errors.add( "Please enter a valid date of birth." );
            isValid = false;
            dob = "";
        }
        if( isValid ) {
            registerNewPatient( );
            
            // This will not work in the labs, as UCC blocks the smpt port
            // If you are running at home uncomment the two lines below and it will 
            // send an email to new registered users.
            
            //Email email = new Email( );
            //email.sendEmailToNewRegUser( studentID, firstName, getEmail( ) );
        }
        
        return isValid;
    }
    /**
     * Function to register the new student into the database.
     */
    public void registerNewPatient(  ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
       
        database.Insert( "INSERT INTO Patients( DOB, FirstName, LastName, Gender, CDSNumber, Ethenticity)" +
                         "VALUES( '" + dob + "','" + firstName + "', '" + lastName + "', '" + gender + "', '" + cdsNumber + "', '" + ethenticity + "');" );
        
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
     
     public String registrationForm() {
        String form = "<p><form name='registration_form' action='registerPatient.jsp' method='POST'>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='firstName'>First Name:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' name='firstName' value='" + firstName +  "' placeholder='John' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='lastName'>Last Name:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' name='lastName' value='" + lastName +  "' placeholder='Smith' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='dob'>Date of birth:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' id='dob' name='dob' value='" + dob +  "' placeholder='16/02/1994' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='gender'>Gender:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' id='gender' name='gender' value='" + gender +  "' placeholder='Gender' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='cdsNumber'>CDS Number:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' id='cdsNumber' name='cdsNumber' value='" + cdsNumber +  "' placeholder='CDS Number' /><br />\n" 
                    + "</div>\n" 
                    + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='ethenticity'>Gender:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' id='ethenticity' name='ethenticity' value='" + ethenticity +  "' placeholder='Irish' /><br />\n" 
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
