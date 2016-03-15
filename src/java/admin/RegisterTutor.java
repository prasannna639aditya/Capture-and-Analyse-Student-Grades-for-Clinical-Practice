package admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RegisterTutor {

    private String tutorID;
    private String firstName;
    private String lastName;
    private String department;
    private String password1;
    private String password2;
    private String email;
    private DatabaseClass database;
    private final ArrayList<String> errors;

    public RegisterTutor() {
        tutorID = "";
        firstName = "";
        lastName = "";
        department = "";
        password1 = "";
        password2 = "";
        email = "";
        errors = new ArrayList<>();

        database = new DatabaseClass();
        database.setup("localhost", "final_year_project", "root", "");
        //database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
    }

    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(final String tutorID) {
        this.tutorID = tutorID;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * setter method for the user's first name
     *
     * @param firstName (string)
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for the user's last name
     *
     * @return the variable lastName (string)
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for the user's last name
     *
     * @param lastName (string)
     *
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Getter method for the user's password1 (the original password.)
     *
     * @return the variable password1 (string)
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * Setter method for the user's password1 (the original password)
     *
     * @param password1 (string)
     */
    public void setPassword1(final String password1) {
        this.password1 = password1;
    }

    /**
     * Getter method for the user's password2 (the password used to confirm the
     * user's password choice)
     *
     * @return the variable password2 (string)
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * Setter method for the user's password2 (the password used to confirm the
     * user's password choice)
     *
     * @param password2 (string)
     */
    public void setPassword2(final String password2) {
        this.password2 = password2;
    }

    /**
     * Ensures the form is filled out correctly by the user.
     *
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateRegForm() throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        boolean isValid = true;

        if (doesUserExist(tutorID)) {
            errors.add("Tutor already exists");
            isValid = false;
            tutorID = "";
        }

        if (tutorID.equals("") || !isInteger(tutorID)) {
            errors.add("Tutor ID required.");
            isValid = false;
            tutorID = "";
        }

        if (firstName.equals("") || isInteger(firstName)) {
            errors.add("First Name required.");
            isValid = false;
            firstName = "";
        }

        if (lastName.equals("") || isInteger(lastName)) {
            errors.add("Last Name required.");
            isValid = false;
            lastName = "";
        }

        if (department.equals("")) {
            errors.add("Please enter a valid email department.");
            isValid = false;
            department = "";
        }

        if (password1.equals("") || password1.length() < 6) {
            errors.add("Password required. Min length is 6 characters");
            isValid = false;
        }

        if (password2.equals("") || password2.length() < 6) {
            errors.add("Confirm Password required.");
            isValid = false;
        }

        if (!password1.equals(password2)) {
            errors.add("Passwords do not match. Must be identical");
            isValid = false;
        }

        if (email.equals("") || !email.contains("@") || !email.contains(".")) {
            errors.add("Please enter a valid email address.");
            isValid = false;
            email = "";
        }

        if (isValid) {
            registerNewUser();

            // This will not work in the labs, as UCC blocks the smpt port
            // If you are running at home uncomment the two lines below and it will 
            // send an email to new registered users.
            //Email email = new Email( );
            //email.sendEmailToNewRegUser( studentID, firstName, getEmail( ) );
        }

        return isValid;
    }

    public boolean doesUserExist(String tutorID) {
        String[] dbResult = database.SelectRow("SELECT TutorID FROM Tutors WHERE TutorID = '" + tutorID + "';");

        if (dbResult.length != 0) {
            return true;
        }

        //database.Close();
        return false;
    }

    /**
     * Function to register the new student into the database.
     */
    public void registerNewUser() throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {

        database.Insert("INSERT INTO Tutors( TutorID, FirstName, LastName, Department, Password, Email )"
                + "VALUES( '" + tutorID + "', '" + firstName + "', '" + lastName + "', '" + department + "', '" + PasswordHash.getSaltedHash(password2) + "', '" + email + "');");

        //database.Close();
    }

    /**
     * Function to print any error messages that may have been collected
     * throughout the registration process
     *
     * @return errorList (string)
     */
    public String printErrors() {
        String errorList;

        errorList = "<ul>";
        for (String error : errors) {
            errorList += "<li>" + error + "</li>";
        }
        errorList += "</ul>";

        return errorList;
    }

    /**
     * Function to check if a string can be parsed to an integer.
     *
     * @param value
     * @return true if the string is a string representation of an integer and
     * false if otherwise
     */
    public boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public String registrationForm() {
        String form = "<p><form name='registration_form' action='registerTutor.jsp' method='POST'>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='tutorID'>Id Number:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input type='text' class=\"form-control\" name='tutorID' value='" + tutorID + "' placeholder='555647' /><br />\n"
                + "</div>\n"
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='firstName'>First Name:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' name='firstName' value='" + firstName + "' placeholder='John' /><br />\n"
                + "</div>\n"
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='lastName'>Last Name:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' name='lastName' value='" + lastName + "' placeholder='Smith' /><br />\n"
                + "</div>\n"
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='email'>Email:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='email' id='email' name='email' value='" + email + "' placeholder='martin@live.ie' /><br />\n"
                + "</div>\n"
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='department'>Department:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<input class=\"form-control\" type='text' id='department' name='department' value='" + department + "' placeholder='Restorative' /><br />\n"
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
        form += "<div class=\"form-group row\">\n"
                + "    <div class=\"col-sm-offset-2 col-sm-10\">\n";
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</div>\n";
        form += "</div>\n";
        form += "</form></p>\n";

        return form;
    }

}
