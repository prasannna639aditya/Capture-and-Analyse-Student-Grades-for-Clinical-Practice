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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Delaney
 */
public class CoreSkills {
    String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    
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
    private int treatmentResult;
    private String comment;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public CoreSkills( ){
        studentID = "";
        patientID = "";
        tutorID = "";
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
        treatmentID = "";
        treatmentResult = 0;
        comment = "";
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
    
    public String getComment( ) {
        return comment;
    }

        
    public void setComment( final String comment ) {
        this.comment = comment;
    }
    
    
    
    
    public boolean validateMarkingForm( ) {
        boolean isValid = true; 
        
        if( ! isInteger( treatmentID ) && treatmentID.length() > 8){
            errors.add( "Please enter a valid Treatment ID" );
            isValid = false;
        }
        
        if( ! isInteger( tutorID ) && tutorID.length() > 8){
            errors.add( "Please enter a valid Tutor" );
            isValid = false;
        }
        
        if( ! isInteger( patientID ) && patientID.length() > 8){
            errors.add( "Please enter a valid Patient" );
            isValid = false;
        }
         
        if( isValid ) {
            treatmentResult = score( abilToEstDiag, abilToFormTrtPlan , ensInfCons , equipPrep, examIntraOralHard, examIntraOralSoft, extraOralExam, infectionControl, interpOfSpecInves, localAnaesthesiaBlock, localAnaesthesiaInfiltration, managementofComplications, matSelecHandling, approPatPos, approOpPos , approLightPos , approUseOfMirror, approFingerSupport );
            getStudent( studentID );
            markStudent( );
        }  
        
        return isValid;
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
    
    public int score( String abilToEstDiag, String abilToFormTrtPlan , String ensInfCons , String equipPrep, String examIntraOralHard, String examIntraOralSoft, String extraOralExam, String infectionControl, String interpOfSpecInves, String localAnaesthesiaBlock, String localAnaesthesiaInfiltration, String managementofComplications, String matSelecHandling, String approPatPos, String approOpPos , String approLightPos , String approUseOfMirror, String approFingerSupport ){
        int result = 0;
        int sum = 0;
        
        int abilToEstDiagInt = Integer.parseInt(abilToEstDiag);
        int abilToFormTrtPlanInt = Integer.parseInt(abilToFormTrtPlan);
        int ensInfConsInt = Integer.parseInt(ensInfCons);
        int equipPrepInt = Integer.parseInt(equipPrep);
        int examIntraOralHardInt = Integer.parseInt(examIntraOralHard);
        int examIntraOralSoftInt = Integer.parseInt(examIntraOralSoft);
        int extraOralExamInt = Integer.parseInt(extraOralExam);
        int infectionControlInt = Integer.parseInt(infectionControl);
        int interpOfSpecInvesInt = Integer.parseInt(interpOfSpecInves);
        int localAnaesthesiaBlockInt = Integer.parseInt(localAnaesthesiaBlock);
        int localAnaesthesiaInfiltrationInt = Integer.parseInt(localAnaesthesiaInfiltration);
        int managementofComplicationsInt = Integer.parseInt(managementofComplications);
        int matSelecHandlingInt = Integer.parseInt(matSelecHandling);
        int approPatPosInt = Integer.parseInt(approPatPos);
        int approOpPosInt = Integer.parseInt(approOpPos);
        int approLightPosInt = Integer.parseInt(approLightPos);
        int approUseOfMirrorInt = Integer.parseInt(approUseOfMirror);
        int approFingerSupportInt = Integer.parseInt(approFingerSupport);
        
        sum = abilToEstDiagInt + abilToFormTrtPlanInt + ensInfConsInt + equipPrepInt + examIntraOralHardInt + examIntraOralSoftInt + extraOralExamInt + infectionControlInt + interpOfSpecInvesInt + localAnaesthesiaBlockInt + localAnaesthesiaInfiltrationInt + managementofComplicationsInt + matSelecHandlingInt + approPatPosInt + approOpPosInt + approLightPosInt + approUseOfMirrorInt + approFingerSupportInt ; 
        result = sum/18;
        
        return result;
    }
    
    public String[] getStudent( String studentID ) {
        String[] dbResult = database.SelectRow( "SELECT * FROM Students WHERE StudentID = '" + studentID + "';" );
        
        
        return dbResult;
    }
    
    
    public void markStudent(  ) {
       
        database.Insert( "INSERT INTO TBICoreSkills( StudentID, PatientID, TutorID, AbilityToEstablishDiagnosis, AbilityToFormulateATreatmentPlan, EnsuringInformedConsent, EquipmentPreparationSelection,"
                + "ExaminationIntraOralHardTissues, ExaminationIntraOralSoftTissues, ExtraOralExamination, InfectionControl, InterpretationOfSpeciaInvestigations, LocalAnaesthesiaBlock, LocalAnaesthesiaInfiltration,"
                + "ManagementOfComplications, MaterialSelectionAndHandling, AppropriatePatientPosition, AppropriateOperatorPosition, AppropriateLightPosition, AppropriateUseOfMirror, AppropriateFingerSupport,"
                + "DateAdded, TreatmentID, Time, TreatmentScore, Comment )"
                +"VALUES( '" + studentID + "', '" + patientID + "', '" + tutorID + "', '" + abilToEstDiag + "', '" + abilToFormTrtPlan + "', '" + ensInfCons + "', '" + equipPrep + "','" + examIntraOralHard + "','" + examIntraOralSoft + "','" + extraOralExam + "','" + infectionControl + "','" + interpOfSpecInves + "','" + localAnaesthesiaBlock + "','" + localAnaesthesiaInfiltration + "','" + managementofComplications + "','" + matSelecHandling + "','" + approPatPos + "','" + approOpPos + "','" + approLightPos + "','" + approUseOfMirror + "','" + approFingerSupport + "','" + date + "','" + treatmentID + "','" + time + "','" + treatmentResult + "','" + comment + "' );" );
        
        /**database.Insert( "INSERT INTO TreatmentPlanEntries( TreatmentPlanID, TreatmentItem, GroupID )" +
                         "VALUES( '" + studentID + "', '" + yearID + "','" + groupID + "' );" );**/
        
        database.Close();
    }
    
    public String markingForm( String TutorID, String StudentID, String TreatmentID) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Statement stmt = conn.createStatement();
        ResultSet rsPatient; 
        rsPatient = stmt.executeQuery("SELECT PatientID, FirstName, LastName, DOB FROM Patients");
        
        String form = "<form name='marking_form' action='markStudent.jsp' method='POST'>\n";
        form += "<label for='studentID'>Student:</label>\n"
                + "<select name=\"studentID\" id='dropdown'>\n" 
                        + "  <option value=\"" + StudentID + "\" selected>" + StudentID + "</option>\n" 
                        + "</select><br />"; 
        
        form += "<label for='patientID'>Patient:</label>\n";
        form += "<select name=\"patientID\"id='dropdown' >\n";
        while ( rsPatient.next() ) {
            form += "<option value=\"" + rsPatient.getString("PatientID") + "\" >" + rsPatient.getString("FirstName") + " " + rsPatient.getString("LastName") +  "</option>\n";
        }
        form += "</select><br />";
        
        form += "<label for='tutorID'>Tutor ID:</label>\n"
                        + "<select name=\"tutorID\" id='dropdown'>\n" 
                        + "  <option value=\"" + TutorID + "\" selected>" + TutorID + "</option>\n" 
                        + "</select><br />"; 
        
        form += "<label for='treatmentID'>Treatment:</label>\n"
                        + "<select name=\"treatmentID\" id='dropdown'>\n" 
                        + "  <option value=\"" + TreatmentID + "\" selected>" + TreatmentID + "</option>\n" 
                        + "</select><br />"; 
        
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
        form += "<label for='extraOralExam'>Extra oral examination:</label>\n";
        form += "<select name=\"extraOralExam\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='infectionControl'>Infection control:</label>\n";
        form += "<select name=\"infectionControl\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='interpOfSpecInves'>Interpretation of special investigations:</label>\n";
        form += "<select name=\"interpOfSpecInves\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaBlock'>Local anaesthesia (Block):</label>\n";
        form += "<select name=\"localAnaesthesiaBlock\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaInfiltration'>Local anaesthesia (Infiltration):</label>\n";
        form += "<select name=\"localAnaesthesiaInfiltration\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='managementofComplications'>Management of complications:</label>\n";
        form += "<select name=\"managementofComplications\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='matSelecHandling'>Material selection and handling:</label>\n";
        form += "<select name=\"matSelecHandling\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approPatPos'>Appropriate patient position:</label>\n";
        form += "<select name=\"approPatPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approOpPos'>Appropriate operator position:</label>\n";
        form += "<select name=\"approOpPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approLightPos'>Appropriate light position:</label>\n";
        form += "<select name=\"approLightPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approUseOfMirror'>Appropriate use of mirror:</label>\n";
        form += "<select name=\"approUseOfMirror\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='approFingerSupport'>Appropriate finger support:</label>\n";
        form += "<select name=\"approFingerSupport\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"5\">6</option>\n" +
                "</select><br />";
        form += "<label for='comment'>Comment:</label>\n" +
                "<textarea name='comment' value='comment' id='comment'>Please comment on the students performance.</textarea>\n" +
                "</select><br />";
                
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</form>\n";
        conn.close();
        return form;
    }
    
}
