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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Delaney
 */
public class CoreSkills {
    private String studentID;
    private String patientID;
    private String tutorID;  
    private String abilToEstDiag;
    private String abilToFormTrtPlan;
    private String ensInfCons;
    private String equipPrep;
    private String examIntraOralHard;
    private String examIntraOralSoft;
    private String extraOralExam;
    private String infectionControl;
    private String interpOfSpecInves;
    private String localAnaesthesiaBlock;
    private String localAnaesthesiaInfiltration;
    private String managementofComplications;
    private String matSelecHandling;
    private String approPatPos;
    private String approOpPos;
    private String approLightPos;
    private String approUseOfMirror;
    private String approFingerSupport;
    private String treatmentID;
    private String dateAdded;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public CoreSkills( ){
        studentID = "";
        patientID = "";
        tutorID = "";
        treatmentID = "";
        abilToEstDiag = "";
        abilToFormTrtPlan = "";
        ensInfCons = "";
        equipPrep = "";
        examIntraOralHard = "";
        examIntraOralSoft = "";
        extraOralExam = "";
        infectionControl = "";
        interpOfSpecInves = "";
        localAnaesthesiaBlock = "";
        localAnaesthesiaInfiltration = "";
        managementofComplications = "";
        matSelecHandling = "";
        approPatPos = "";
        approOpPos = "";
        approLightPos = "";
        approUseOfMirror = "";
        approFingerSupport = "";
        dateAdded = "";
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

    public String getPatientID( ) {
        return patientID;
    }

    public void setPatientID( final String patientID ) {
        this.patientID = patientID;
    }
    
    public String getTutorID( ) {
        return tutorID;
    }

    public void setTutorID( final String tutorID ) {
        this.tutorID = tutorID;
    }
    
    public String getAbilToEstDiag( ) {
        return abilToEstDiag;
    }

        
    public void setAbilToEstDiag( final String abilToEstDiag ) {
        this.abilToEstDiag = abilToEstDiag;
    }
    
       public String getAbilToFormTrtPlan( ) {
        return abilToFormTrtPlan;
    }

        
    public void setAbilToFormTrtPlan( final String abilToFormTrtPlan ) {
        this.abilToFormTrtPlan = abilToFormTrtPlan;
    } 

    public String getEnsInfCons( ) {
        return ensInfCons;
    }

        
    public void setEnsInfCons( final String ensInfCons ) {
        this.ensInfCons = ensInfCons;
    }  
    
    public String getEquipPrep( ) {
        return equipPrep;
    }

        
    public void setEquipPrep( final String equipPrep ) {
        this.equipPrep = equipPrep;
    }
    
    public String getExamIntraOralHard( ) {
        return examIntraOralHard;
    }

        
    public void setExamIntraOralHard( final String examIntraOralHard ) {
        this.examIntraOralHard = examIntraOralHard;
    }
    
    public String getExamIntraOralSoft( ) {
        return examIntraOralSoft;
    }

        
    public void setExamIntraOralSoft( final String examIntraOralSoft ) {
        this.examIntraOralSoft = examIntraOralSoft;
    }
    
    public String getExtraOralExam( ) {
        return extraOralExam;
    }

        
    public void setExtraOralExam( final String extraOralExam ) {
        this.extraOralExam = extraOralExam;
    }
    
    public String getInfectionControl( ) {
        return infectionControl;
    }

        
    public void setInfectionControl( final String infectionControl ) {
        this.infectionControl = infectionControl;
    }
    
    public String getInterpOfSpecInves( ) {
        return interpOfSpecInves;
    }

        
    public void setInterpOfSpecInves( final String interpOfSpecInves ) {
        this.interpOfSpecInves = interpOfSpecInves;
    }
    
    public String getLocalAnaesthesiaBlock( ) {
        return localAnaesthesiaBlock;
    }

        
    public void setLocalAnaesthesiaBlock( final String localAnaesthesiaBlock ) {
        this.localAnaesthesiaBlock = localAnaesthesiaBlock;
    }
    
    public String getLocalAnaesthesiaInfiltration( ) {
        return localAnaesthesiaInfiltration;
    }

        
    public void setLocalAnaesthesiaInfiltration( final String localAnaesthesiaInfiltration ) {
        this.localAnaesthesiaInfiltration = localAnaesthesiaInfiltration;
    }
    
    public String getManagementofComplications( ) {
        return managementofComplications;
    }

        
    public void setManagementofComplications( final String managementofComplications ) {
        this.managementofComplications = managementofComplications;
    }
    
    public String getMatSelecHandling( ) {
        return matSelecHandling;
    }

        
    public void setMatSelecHandling( final String matSelecHandling ) {
        this.matSelecHandling = matSelecHandling;
    }
    
    public String getApproPatPos( ) {
        return approPatPos;
    }

        
    public void setApproPatPos( final String approPatPos ) {
        this.approPatPos = approPatPos;
    }
    
    public String getApproOpPos( ) {
        return approOpPos;
    }

        
    public void setApproOpPos( final String approOpPos ) {
        this.approOpPos = approOpPos;
    }
    
    public String getApproLightPos( ) {
        return approLightPos;
    }

        
    public void setApproLightPos( final String approLightPos ) {
        this.approLightPos = approLightPos;
    }
    
    public String getApproUseOfMirror( ) {
        return approUseOfMirror;
    }

        
    public void setApproUseOfMirror( final String approUseOfMirror ) {
        this.approUseOfMirror = approUseOfMirror;
    }
    
    public String getApproFingerSupport( ) {
        return approFingerSupport;
    }

        
    public void setApproFingerSupport( final String approFingerSupport ) {
        this.approFingerSupport = approFingerSupport;
    }
    
    public String getTreatmentID( ) {
        return treatmentID;
    }

        
    public void setTreatmentID( final String treatmentID ) {
        this.treatmentID = treatmentID;
    }
    
    public String getDateAdded( ) {
        return dateAdded;
    } 
    /**
     * Setter method for the end date of the event
     * @param dateAdded (string)
     */
    public void setDateAdded( final String dateAdded ) {
        this.dateAdded = dateAdded;
    }
    
    public boolean validateMarkingForm( ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception {
        boolean isValid = true; 
        
        if(hasBeenGraded(studentID, treatmentID)) {
            errors.add( "User already exists" );
            isValid = false;
            studentID = "";
        }
        
        return isValid;
    }
    
    
    public boolean hasBeenGraded(String studentID, String treatmentID) {
        String[] dbResult = database.SelectRow( "SELECT StudentID FROM TBICoreSkills WHERE StudentID = '" + studentID + 
                                               "AND TreatmentID = '" + treatmentID + "';" );
        
        if(dbResult.length != 0) {
            return true;
        }
        return false;
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
    
    public String markingForm( ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Statement stmt = conn.createStatement();
        ResultSet rsStudent; 
        rsStudent = stmt.executeQuery("SELECT StudentID, FirstName, LastName FROM Students"); 
        
        String form = "<form name='marking_form' action='markStudent.jsp' method='POST'>\n";
        form += "<label for='studentID'>Student:</label>\n";
        form += "<select name=\"studentID\"id='dropdown' >\n";
        while ( rsStudent.next() ) {
        form += "<option value=\"" + rsStudent.getString("StudentID") + "\" >" + rsStudent.getString("FirstName") + " " + rsStudent.getString("LastName") + "</option>\n";
        }
        form += "<label for='patientID'>Patient:</label>\n";
        form += "<input type='patientID' name='patientID' value='" + patientID +  "' placeholder='1234'  /><br />\n";
        form += "<label for='tutorID'>Tutor:</label>\n";
        form += "<input type='tutorID' name='tutorID' value='" + tutorID +  "' placeholder='54321'  /><br />\n";
        form += "<label for='treatmentID'>Treatment:</label>\n";
        form += "<input type='treatmentID' name='treatmentID' value='" + treatmentID +  "' placeholder='54321'  /><br />\n";
        form += "<label for='abilToEstDiag'>Ability to establish diagnosis(es):</label>\n";
        form += "<select name=\"abilToEstDiag\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />"; 
        form += "<label for='abilToFormTrtPlan'>Ability to formulate a treatment plan:</label>\n";
        form += "<select name=\"abilToFormTrtPlan\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='ensInfCons'>Ensuring informed consent:</label>\n";
        form += "<select name=\"ensInfCons\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='equipPrep'>Equipment Preparation/Selection:</label>\n";
        form += "<select name=\"equipPrep\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='examIntraOralHard'>Examination : Intra oral hard tissues:</label>\n";
        form += "<select name=\"examIntraOralHard\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='examIntraOralSoft'>Examination : Intra oral soft tissues:</label>\n";
        form += "<select name=\"examIntraOralSoft\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='extraOralExam'>Extra oral examination:</label>\n";;
        form += "<select name=\"extraOralExam\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='infectionControl'>Infection control:</label>\n";;
        form += "<select name=\"infectionControl\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='interpOfSpecInves'>Interpretation of special investigations:</label>\n";;
        form += "<select name=\"interpOfSpecInves\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaBlock'>Local anaesthesia (Block):</label>\n";;
        form += "<select name=\"localAnaesthesiaBlock\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaInfiltration'>Local anaesthesia (Infiltration):</label>\n";;
        form += "<select name=\"localAnaesthesiaInfiltration\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='managementofComplications'>Management of complications:</label>\n";;
        form += "<select name=\"managementofComplications\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='matSelecHandling'>Material selection and handling:</label>\n";;
        form += "<select name=\"matSelecHandling\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approPatPos'>Appropriate patient position:</label>\n";;
        form += "<select name=\"approPatPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approOpPos'>Appropriate operator position:</label>\n";;
        form += "<select name=\"approOpPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approLightPos'>Appropriate light position:</label>\n";;
        form += "<select name=\"approLightPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approUseOfMirror'>Appropriate use of mirror:</label>\n";;
        form += "<select name=\"approUseOfMirror\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approFingerSupport'>Appropriate finger support:</label>\n";;
        form += "<select name=\"approFingerSupport\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form +=    "<label for=\"dateAdded\">Date:</label>\n"
                        + "<input type=\"text\" class=\"datepicker\" name=\"endDate\" value=\"" + dateAdded + "\" placeholder=\"2016/01/31\"/><br />\n";
        
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</form>\n";
        conn.close();
        return form;
    }
    
}
