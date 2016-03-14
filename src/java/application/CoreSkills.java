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
import javax.servlet.http.HttpServletRequest;
import passwordhash.PasswordHash;

/**
 *
 * @author Delaney
 */
public class CoreSkills {
    String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    String time = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    String hour = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
    
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
    private String comment;
    private String[] result;
    private String password;
    private String passwordToCheck;
    private String treatmentPlanID;
    private String treatmentScore;
    private String checkbox;
    private String professionalism;
    private String communication;
    private String knowledge;
    private String attendance;
    private String cdsNumber;
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
        comment = "";
        password = "";
        passwordToCheck = "";
        professionalism = "";
        communication = "";
        knowledge = "";
        checkbox = "";
        attendance = "";
        cdsNumber = "";
        this.treatmentScore = "";
        this.treatmentPlanID = "";
        this.checkbox = "";
        this.result = new String[10];
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
    
    public String getPasswordToCheck( ) {
        return passwordToCheck;
    }
    
    public void setPasswordToCheck(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }
    
    public String getPassword( ) {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTreatmentScore( ) {
        return treatmentScore;
    }
 
    public void setTreatmentScore( final String treamentScore ) {
        this.treatmentScore = treatmentScore;
    }
    
    public String getTreatmentPlanID( ) {
        return treatmentPlanID;
    }
 
    public void setTreatmentPlanID( final String treamentPlanID ) {
        this.treatmentPlanID = treatmentPlanID;
    }
    
    public String getProfessionalism(){
        return professionalism;
    }
    
    public void setProfessionalism( final String professionalism ) {
        this.professionalism = professionalism;
    }
    
    public String getCommunication(){
        return communication;
    }
    
    public void setCommunication( final String communication ) {
        this.communication = communication;
    }
    
    public String getKnowledge(){
        return knowledge;
    }
    
    public void setKnowledge( final String knowledge ) {
        this.knowledge = knowledge;
    }
    
    public String getCheckbox( ) {
        return checkbox;
    }
 
    public void setCheckbox( final String checkbox) {
        this.checkbox = checkbox;
    }
    
    public String getAttendance( ) {
        return attendance;
    }
 
    public void setAttendance( final String attendance) {
        this.attendance = attendance;
    }
    
    public String getCdsNumber( ) {
        return cdsNumber;
    }
 
    public void setCdsNumber( final String cdsNumber ) {
        this.cdsNumber = cdsNumber;
    }
    
    
    
    public boolean validateMarkingForm( ) throws Exception {
        boolean isValid = true; 
        
        if( ! isInteger( treatmentID ) && treatmentID.length() > 8){
            errors.add( "Please enter a valid Treatment ID" );
            isValid = false;
        }
        
        if( ! isInteger( tutorID ) && tutorID.length() > 8){
            errors.add( "Please enter a valid Tutor" );
            isValid = false;
        }
        
        if( password.equals( "" ) ) {
            errors.add( "Please get the student to re-enter their password." );
            isValid = false;
            password = "";
        }
        
        if( password == null ) {
            errors.add( "Please get the student to re-enter their password." );
            isValid = false;
            password = "";
        }
        
        if( PasswordHash.check( password, passwordToCheck) == false){
           errors.add( "Students password is incorrect. Please get the student to re-enter their password." );
           isValid = false;
           password = "";
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
        
        errorList = "<div>";
            for( String error: errors ) {
                errorList += "<p>" + error + "</p";
            }
        errorList += "</div>";
        
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
    
    
    public void markStudent(  ) throws SQLException {
        CoreSkills core = new CoreSkills();
        TreatmentItems treatment = new TreatmentItems();
        
        database.Insert( "INSERT INTO TBICoreSkills( StudentID, PatientID, TutorID, AbilityToEstablishDiagnosis, AbilityToFormulateATreatmentPlan, EnsuringInformedConsent, EquipmentPreparationSelection,"
                + "ExaminationIntraOralHardTissues, ExaminationIntraOralSoftTissues, ExtraOralExamination, InfectionControl, InterpretationOfSpeciaInvestigations, LocalAnaesthesiaBlock, LocalAnaesthesiaInfiltration,"
                + "ManagementOfComplications, MaterialSelectionAndHandling, AppropriatePatientPosition, AppropriateOperatorPosition, AppropriateLightPosition, AppropriateUseOfMirror, AppropriateFingerSupport,"
                + "DateAdded, TreatmentID, Time, Comment, Professionalism, Communication, Knowledge, Attendance, Hour )"
                +"VALUES( '" + studentID + "', '" + cdsNumber + "', '" + tutorID + "', '" + abilToEstDiag + "', '" + abilToFormTrtPlan + "', '" + ensInfCons + "', '" + equipPrep + "','" + examIntraOralHard + "','" + examIntraOralSoft + "','" + extraOralExam + "','" + infectionControl + "','" + interpOfSpecInves + "','" + localAnaesthesiaBlock + "','" + localAnaesthesiaInfiltration + "','" + managementofComplications + "','" + matSelecHandling + "','" + approPatPos + "','" + approOpPos + "','" + approLightPos + "','" + approUseOfMirror + "','" + approFingerSupport + "','" + date + "','" + treatmentID + "','" + time + "','" + comment + "','" + professionalism + "','" + communication + "','" + knowledge + "', '" + attendance + "', '" + hour + "' );" );
               
        
        database.Insert( "INSERT INTO TreatmentPlanEntries( TreatmentName, ClinicalAlert, Comment)" +
                         "VALUES( '" + treatment.fetchTreatmentName(treatmentID) + "','" + checkbox + "','" + comment + "' );" );
        
        database.Insert( "INSERT INTO TreatmentPlans( TutorID, PatientID, StudentID)" +
                         "VALUES( '" + tutorID + "','" + cdsNumber + "','" + studentID + "' );" );
        
        database.Close();
    }
    
    public String buttonNav(){
        String  form = "<p>  </p>\n";
                
                form += "<div id=\"fixed\"><ul class=\"nav nav-pills nav-justified\">\n" +
                        "  <li class=\"active\"><a href='#info'>Info</a></li>\n" +
                        "  <li><a href='#core'>Core</a></li>\n" +
                        "  <li><a href='#basic'>Basic</a></li>\n" +
                        "  <li><a href='#professionalism'>Professionalism</a></li>\n" +
                        "  <li><a href='#communication'>Communication</a></li>\n" +
                        "  <li><a href='#knowledge'>Knowledge</a></li>\n" +
                        "  <li><a href='#review'>Review</a></li>\n" +
                        "</ul></div>";
                 
        return form;
    }

    public String markingForm( String TutorID, String StudentID, String TreatmentID, String cdsNumber) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        Statement stmt = conn.createStatement();
        ResultSet rsPatient; 
        TreatmentItems treatment = new TreatmentItems();
        rsPatient = stmt.executeQuery("SELECT PatientID, FirstName, LastName, DOB FROM Patients");
        
        
        String form = "<form name='marking_form' action='markStudent.jsp' method='POST'>\n";
        form += "<p>\n";
        form += "<div id=\"test\">";
        form += "<a  name=\"info\"></a><h2>Info</h2>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='studentID'>Student:</label>\n"
                + "<div class=\"col-sm-10\">"
                + "<select name=\"studentID\"class=\"form-control\">\n" 
                        + "  <option value=\"" + StudentID + "\" selected>" + StudentID + "</option>\n" 
                        + "</select><br />"
                + "</div>\n"
                + "</div>\n";
        form += "<div class=\"form-group row\">" +
                "<label class=\"col-sm-2\" for=\"attendance\">Assisting</label>\n" +
                "<div class=\"col-sm-10\">\n" +
                "      <div class=\"checkbox\"><label>" +
                "<input type=\"checkbox\" name=\"attendance\" id=\"checkbox\" value=\"yes\">Student is assisting with procedure.\n" +
                "</label>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='tutorID'>Tutor ID:</label>\n"
                        + "<div class=\"col-sm-10\">"
                        + "<select name=\"tutorID\" class=\"form-control\">\n" 
                        + "  <option value=\"" + TutorID + "\" selected>" + TutorID + "</option>\n" 
                        + "</select><br />" 
                        + "</div>\n" 
                        + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='treatmentID'>Treatment:</label>\n"
                        + "<div class=\"col-sm-10\">"
                        + "<select name=\"treatmentID\" class=\"form-control\" >\n" 
                        + "  <option value=\"" + TreatmentID + "\" selected>" + TreatmentID + "</option>\n" 
                        + "</select><br />"
                        + "</div>\n" 
                        + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='cdsNumber'>Patient CDS Number:</label>\n"
                        + "<div class=\"col-sm-10\">"
                        + "<select name=\"cdsNumber\" class=\"form-control\" >\n" 
                        + "  <option value=\"" + cdsNumber + "\" selected>" + cdsNumber + "</option>\n" 
                        + "</select><br />"
                        + "</div>\n" 
                        + "</div>\n";
        form += "</p>\n";
        form += "</div>\n";
        
        form += "<p>\n";
        form += "<a  name=\"core\"></a><h2>Core Skills Generic</h2>";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='abilToEstDiag'>Ability to establish diagnosis(es):</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"abilToEstDiag\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='abilToFormTrtPlan'>Ability to formulate a treatment plan:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"abilToFormTrtPlan\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='ensInfCons'>Ensuring informed consent:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"ensInfCons\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='equipPrep'>Equipment Preparation/Selection:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"equipPrep\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='examIntraOralHard'>Examination : Intra oral hard tissues:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"examIntraOralHard\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='examIntraOralSoft'>Examination : Intra oral soft tissues:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"examIntraOralSoft\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='extraOralExam'>Extra oral examination:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"extraOralExam\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='infectionControl'>Infection control:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"infectionControl\" class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='interpOfSpecInves'>Interpretation of special investigations:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"interpOfSpecInves\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='localAnaesthesiaBlock'>Local anaesthesia (Block):</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"localAnaesthesiaBlock\" class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='localAnaesthesiaInfiltration'>Local anaesthesia (Infiltration):</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"localAnaesthesiaInfiltration\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='managementofComplications'>Management of complications:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"managementofComplications\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='matSelecHandling'>Material selection and handling:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"matSelecHandling\" class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "</p>\n";
        
        form += "<p>\n";
        form += "<a  name=\"basic\"></a><h2>Basic Operative Skills</h2>";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='approPatPos'>Appropriate patient position:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"approPatPos\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='approOpPos'>Appropriate operator position:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"approOpPos\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='approLightPos'>Appropriate light position:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"approLightPos\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='approUseOfMirror'>Appropriate use of mirror:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"approUseOfMirror\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='approFingerSupport'>Appropriate finger support:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"approFingerSupport\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "</p>\n";
        
        form += "<p>\n";
        form += "<a  name=\"professionalism\"></a><h2>Professionalism</h2>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='professionalism'>Professionalism:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"professionalism\" class='form-control' >\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "</p>\n";
        
        form += "<p>\n";
        form += "<a  name=\"communication\"></a><h2>Communication</h2>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='communication'>Communication:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"communication\"  class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "</p>\n";
        
        form += "<p>\n";
        form += "<p>\n";
        form += "<a  name=\"knowledge\"></a><h2>Knowledge</h2>\n";
        form += "<div class=\"form-group row\">";
        form += "<label class=\"col-sm-2 form-control-label\" for='knowledge'>Knowledge:</label>\n";
        form += "<div class=\"col-sm-10\">";
        form += "<select name=\"knowledge\" class='form-control'>\n" +
                    "  <option value=\"0\" selected>No Grade</option>\n" +
                    "  <option value=\"1\">1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"
                + "</div>\n" 
                + "</div>\n";
        form += "</p>\n";
        
        form += "<p>\n";
        form += "<a  name=\"review\"></a><h2>Review</h2>\n";
        form += "<div class=\"form-group row\">\n";
        form += "<label class=\"col-sm-2\" for=\"checkbox\">Clinical Alert</label>\n" +
                "<div class=\"col-sm-10\">\n" +
                "      <div class=\"checkbox\"><label>" +
                "<input type=\"checkbox\" name=\"checkbox\" id=\"checkbox\" value=\"Yes\">Patient, student or staff exposed to distress or potential/actual harm as a result of inappropriate student actions.\n" +
                "       </label>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>";
        form += "<div class=\"form-group row\">\n";
        form += "<label class=\"col-sm-2\" for=\"comment\">Comment:</label>\n" +
                "<div class=\"col-sm-10\">\n" +
                "<textarea name='comment' placeholder=\"Please comment on the students performance\" value='comment' id=\"exampleTextarea\" class=\"form-control\" rows=\"3\"></textarea>\n" +
                "</select><br /></p>"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">\n";
        form += "<label class=\"col-sm-2\" for='password'>Students Password:</label>\n" +
                "<div class=\"col-sm-10\">\n";
        form += "<input type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" name=\"password\" placeholder=\"Student is required to enter their password\"/><br />\n"
                + "</div>\n" 
                + "</div>\n";
        form += "<div class=\"form-group row\">\n" +
            "    <div class=\"col-sm-offset-2 col-sm-10\">\n" +
            "      <input type='submit' value='Submit' name='submit' /><br />\n" +
            "    </div>\n" +
            "  </div>";
        form += "</p>\n";
        form += "</form>\n";
        conn.close();
        return form;
    }
    
    public String markingDescriptors(){
            String form = "<table class=\"table table-striped table-bordered table-condensed\" width=\"647\">\n";
                   form += "<thead>\n";
                   form += "<th rowspan=\"3\" align=\"center\">Descriptors. For cases appropriate for year of study of dental programme</th>\n";
                   form += "<tr>";
                   form += "<td>Currently UNABLE to meet the outcome with the required quality.</td>\n";
                   form += "<td>Currently UNABLE to meet the outcome with the required quality.</td>\n";
                   form += "<td>ABLE to meet the outcome at the required quality.</td>\n";
                   form += "<td>ABLE to meet the outcome at the required quality.</td>\n";
                   form += "<td>ABLE to meet the outcome INDEPENDANTLY at the required quality.</td>\n";
                   form += "<td>ABLE to meet the outcome INDEPENDANTLY exceeding the required quality.</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<td>Has caused harm or does not seek essential guidance</td>\n";
                   form += "<td>Requires major corrective(procedural) intervention from the tutor.</td>\n";
                   form += "<td>Minor corrective intervention(procedural) from the tutor.</td>\n";
                   form += "<td>Minor corrective intervention(verbal) from the tutor.</td>\n";
                   form += "<td>Confirmatory advice from the tutor.</td>\n";
                   form += "<td>Confirmatory advice from the tutor.</td>\n";
                   form += "</tr>\n";
                   form += "</thead>\n";
                   form += "<tr>\n";
                   form += "<th rowspan=\"1\">Development Indicator/ Grade</th>\n";
                   form += "<td>1</td>"
                           + "<td>2</td>"
                           + "<td>3</td>"
                           + "<td>4</td>"
                           + "<td>5</td>"
                           + "<td>6</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Feedback</th>";
                   form += "<td colspan=\"3\" align=\"center\">Instruct students on their development needs and how to achieve them.</td>\n";
                   form += "<td>Feedback on how to improve quality, if appropriate.</td>\n";
                   form += "<td>Feedback on how to exceed the expected quality.</td>";
                   form += "<td>Reinforce excellent development.</td>\n";
                   form += "</tr>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   
        return form;
    }
    
    public boolean validateStudent(HttpServletRequest request) throws Exception{
        PasswordHash hash = new PasswordHash();
 
        password = request.getParameter( "password" );
        boolean isValid = true;
        
        result = database.SelectRow( "SELECT * FROM Students WHERE StudentID = 119876543;" );
        
            
        
        if( result.length != 0 ) {
            passwordToCheck = result[1];
        }
        
        if( ! validateMarkingForm( ) ){
            return false;
        }
        
        database.Close();
  
        return result.length != 0;
        
    }
}
