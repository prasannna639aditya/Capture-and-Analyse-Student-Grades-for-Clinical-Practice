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
    String date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
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
    private String[] result;
    private String password;
    private String passwordToCheck;
    private String treatmentPlanID;
    private String treatmentScore;
    private String checkbox;
    private String punctuality;
    private String professionalApproach;
    private String selfAwareness;
    private String studentInsight;
    private String abilToEstPatientHistory;
    private String abilToEnsureInformedConsent;
    private String abilToReqSpecialInvestigations;
    private String abilToWritePerscription;
    private String communicationWithDentalTeam;
    private String communicationWithPatientAndFamily;
    private String communicationWithTutor;
    private String outlineOfReferalLetter;
    private String patientRecordKeeping;
    private String charting;
    private String presentationOfCase;
    private String abilToUnderstandMedicalHistory;
    private String backKnowledgeForSessionProcedure;
    private String justKnowledgeOfApproSpecInvest;        
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
        password = "";
        passwordToCheck = "";
        punctuality = "";
        professionalApproach = "";
        selfAwareness = "";
        studentInsight = "";
        abilToEstPatientHistory = "";
        abilToEnsureInformedConsent = "";
        abilToReqSpecialInvestigations = "";
        abilToWritePerscription = "";
        communicationWithDentalTeam = "";
        communicationWithPatientAndFamily = "";
        communicationWithTutor = "";
        outlineOfReferalLetter = "";
        patientRecordKeeping = "";
        charting = "";
        presentationOfCase = "";
        abilToUnderstandMedicalHistory = "";
        backKnowledgeForSessionProcedure = "";
        justKnowledgeOfApproSpecInvest = ""; 
        checkbox = "";
        this.treatmentScore = "";
        this.treatmentPlanID = "";
        this.checkbox = "";
        this.result = new String[10];
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
    
    public String getPunctuality( ) {
        return punctuality;
    }
 
    public void setPunctuality( final String punctuality ) {
        this.punctuality = punctuality;
    }
    
    public String getProfessionalApproach( ) {
        return professionalApproach;
    }
 
    public void setProfessionalApproach( final String professionalApproach ) {
        this.professionalApproach = professionalApproach;
    }
    
    public String getSelfAwareness( ) {
        return selfAwareness;
    }
 
    public void setSelfAwareness( final String selfAwareness ) {
        this.selfAwareness = selfAwareness;
    }
    
    public String getStudentInsight( ) {
        return studentInsight;
    }
 
    public void setStudentInsight( final String studentInsight ) {
        this.studentInsight = studentInsight;
    }
    
    public String getAbilToEstPatientHistory( ) {
        return abilToEstPatientHistory;
    }
 
    public void setAbilToEstPatientHistory( final String abilToEstPatientHistory ) {
        this.abilToEstPatientHistory = abilToEstPatientHistory;
    }
    
    public String getAbilToEnsureInformedConsent( ) {
        return abilToEnsureInformedConsent;
    }
 
    public void setAbilToEnsureInformedConsent( final String abilToEnsureInformedConsent ) {
        this.abilToEnsureInformedConsent = abilToEnsureInformedConsent;
    }
    
    public String getAbilToReqSpecialInvestigations( ) {
        return abilToReqSpecialInvestigations;
    }
 
    public void setAbilToReqSpecialInvestigations( final String abilToReqSpecialInvestigations ) {
        this.abilToReqSpecialInvestigations = abilToReqSpecialInvestigations;
    }
    
    public String getAbilToWritePerscription( ) {
        return abilToWritePerscription;
    }
 
    public void setAbilToWritePerscription( final String abilToWritePerscription ) {
        this.abilToWritePerscription = abilToWritePerscription;
    }
    
    public String getCommunicationWithDentalTeam( ) {
        return communicationWithDentalTeam;
    }
 
    public void setCommunicationWithDentalTeam( final String communicationWithDentalTeam ) {
        this.communicationWithDentalTeam = communicationWithDentalTeam;
    }
    
    public String getCommunicationWithTutor( ) {
        return communicationWithTutor;
    }
 
    public void setCommunicationWithTutor( final String communicationWithTutor) {
        this.communicationWithTutor = communicationWithTutor;
    }
    
    public String getOutlineOfReferalLetter( ) {
        return outlineOfReferalLetter;
    }
 
    public void setOutlineOfReferalLetter( final String outlineOfReferalLetter) {
        this.outlineOfReferalLetter = outlineOfReferalLetter;
    }
    
    public String getPatientRecordKeeping( ) {
        return patientRecordKeeping;
    }
 
    public void setPatientRecordKeeping( final String patientRecordKeeping) {
        this.patientRecordKeeping = patientRecordKeeping;
    }
    
    public String getCharting( ) {
        return charting;
    }
 
    public void setCharting( final String charting) {
        this.charting = charting;
    }
    
    public String getPresentationOfCase( ) {
        return presentationOfCase;
    }
 
    public void setPresentationOfCase( final String presentationOfCase) {
        this.presentationOfCase = presentationOfCase;
    }
    
    public String getCommunicationWithPatientAndFamily( ) {
        return communicationWithPatientAndFamily;
    }
 
    public void setCommunicationWithPatientAndFamily( final String communicationWithPatientAndFamily) {
        this.communicationWithPatientAndFamily = communicationWithPatientAndFamily;
    }
    
    public String getAbilToUnderstandMedicalHistory( ) {
        return abilToUnderstandMedicalHistory;
    }
 
    public void setAbilToUnderstandMedicalHistory( final String abilToUnderstandMedicalHistory) {
        this.abilToUnderstandMedicalHistory = abilToUnderstandMedicalHistory;
    }
    
    public String getBackKnowledgeForSessionProcedure( ) {
        return backKnowledgeForSessionProcedure;
    }
 
    public void setBackKnowledgeForSessionProcedure( final String backKnowledgeForSessionProcedure) {
        this.backKnowledgeForSessionProcedure = backKnowledgeForSessionProcedure;
    }
    
    public String getJustKnowledgeOfApproSpecInvest( ) {
        return justKnowledgeOfApproSpecInvest;
    }
 
    public void setJustKnowledgeOfApproSpecInvest( final String justKnowledgeOfApproSpecInvest) {
        this.justKnowledgeOfApproSpecInvest = justKnowledgeOfApproSpecInvest;
    }
    
    public String getCheckbox( ) {
        return checkbox;
    }
 
    public void setCheckbox( final String checkbox) {
        this.checkbox = checkbox;
    }
    
    /**
    public boolean checkPassword( HttpServletRequest request ) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception  {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "ec2-52-48-85-26.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );

        
        
        tutorID = request.getParameter( "TutorID" );
        
        
        result = database.SelectRow( "SELECT * FROM Tutors WHERE TutorID = '" + tutorID + "';" );
        
        if( result.length != 0 ) {
            tutorID = result[0];
            passwordToCheck = result[4];
            
        }
        
        if( ! validateMarkingForm( ) ){
            return false;
        }
        System.out.println(passwordToCheck);
        System.out.println(password);
        //database.Close();
  
        return result.length != 0;
    }**/
    
    
    
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
        
        if( ! isInteger( patientID ) && patientID.length() > 8){
            errors.add( "Please enter a valid Patient" );
            isValid = false;
        }
        
        /**
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        if( PasswordHash.check( password, passwordToCheck) == false){
           isValid = false;
        }**/
         
        if( isValid ) {
            CoreSkills core = new CoreSkills();
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
    
    
    public void markStudent(  ) throws SQLException {
        CoreSkills core = new CoreSkills();
        TreatmentItems treatment = new TreatmentItems();
        
        database.Insert( "INSERT INTO TBICoreSkills( StudentID, PatientID, TutorID, AbilityToEstablishDiagnosis, AbilityToFormulateATreatmentPlan, EnsuringInformedConsent, EquipmentPreparationSelection,"
                + "ExaminationIntraOralHardTissues, ExaminationIntraOralSoftTissues, ExtraOralExamination, InfectionControl, InterpretationOfSpeciaInvestigations, LocalAnaesthesiaBlock, LocalAnaesthesiaInfiltration,"
                + "ManagementOfComplications, MaterialSelectionAndHandling, AppropriatePatientPosition, AppropriateOperatorPosition, AppropriateLightPosition, AppropriateUseOfMirror, AppropriateFingerSupport,"
                + "DateAdded, TreatmentID, Time, TreatmentScore, Comment, Punctuality, ProfessionalApproach, SelfAwareness, StudentInsight, AbilityToEstablishPatientHistory, AbilityToObtainInformedConsent, AbilityToRequestSpecialInvestigations,"
                + "AbilityToWritePerscription, CommunicationWithDentalTeam, CommunicationWithPatientAndFamily, CommunicationWithTutor, OutlineOfReferalLetter, PatientRecordKeeping, Charting, PresentationOfCase, AbilityToUnderstandMedicalHistory, BackgroundKnowledgeForSessionProcedure, JustificationForAndKnowledgeOfAppropriateSpecialInvestigations )"
                +"VALUES( '" + studentID + "', '" + patientID + "', '" + tutorID + "', '" + abilToEstDiag + "', '" + abilToFormTrtPlan + "', '" + ensInfCons + "', '" + equipPrep + "','" + examIntraOralHard + "','" + examIntraOralSoft + "','" + extraOralExam + "','" + infectionControl + "','" + interpOfSpecInves + "','" + localAnaesthesiaBlock + "','" + localAnaesthesiaInfiltration + "','" + managementofComplications + "','" + matSelecHandling + "','" + approPatPos + "','" + approOpPos + "','" + approLightPos + "','" + approUseOfMirror + "','" + approFingerSupport + "','" + date + "','" + treatmentID + "','" + time + "','" + treatmentResult + "','" + comment + "','" + punctuality + "','" + professionalApproach + "','" + selfAwareness + "','" + studentInsight + "','" + abilToEstPatientHistory  + "','" + abilToEnsureInformedConsent + "','" + abilToReqSpecialInvestigations + "','" + abilToWritePerscription + "','" + communicationWithDentalTeam + "', '" + communicationWithPatientAndFamily + "', '" + communicationWithTutor + "','" + outlineOfReferalLetter+ "','" + patientRecordKeeping + "','" + charting + "','" + presentationOfCase + "','" + abilToUnderstandMedicalHistory + "','" + backKnowledgeForSessionProcedure + "','" + backKnowledgeForSessionProcedure + "' );" );
        
        database.Insert( "INSERT INTO TreatmentPlanEntries( TreatmentName, TreatmentScore, ClinicalAlert, Comment)" +
                         "VALUES( '" + treatment.fetchTreatmentName(treatmentID) + "','" + treatmentResult + "','" + checkbox + "','" + comment + "' );" );
        
        database.Insert( "INSERT INTO TreatmentPlans( TutorID, PatientID, StudentID)" +
                         "VALUES( '" + tutorID + "','" + patientID + "','" + studentID + "' );" );
        
        database.Close();
    }
    
    /**
    public void clinical() throws SQLException{
        TreatmentItems treatment = new TreatmentItems();
        database.Insert( "INSERT INTO TreatmentPlanEntries( TreatmentPlanID, TreatmentItem, TreatmentScore, ClinicalAlert, Comment)"
                + "VALUES ( '" + treatmentPlanID + "', '" + treatment.fetchTreatmentName(treatmentID) + "', '" + treatmentScore + "', '" + checkbox + "', '" + comment + "');");
    
        database.Close();
    }**/
    
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
        form += "<h1>Core Skills Generic</h1>";
        form += "<label for='abilToEstDiag'>Ability to establish diagnosis(es):</label>\n";
        form += "<select name=\"abilToEstDiag\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />"; 
        form += "<label for='abilToFormTrtPlan'>Ability to formulate a treatment plan:</label>\n";
        form += "<select name=\"abilToFormTrtPlan\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='ensInfCons'>Ensuring informed consent:</label>\n";
        form += "<select name=\"ensInfCons\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='equipPrep'>Equipment Preparation/Selection:</label>\n";
        form += "<select name=\"equipPrep\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='examIntraOralHard'>Examination : Intra oral hard tissues:</label>\n";
        form += "<select name=\"examIntraOralHard\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='examIntraOralSoft'>Examination : Intra oral soft tissues:</label>\n";
        form += "<select name=\"examIntraOralSoft\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='extraOralExam'>Extra oral examination:</label>\n";
        form += "<select name=\"extraOralExam\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='infectionControl'>Infection control:</label>\n";
        form += "<select name=\"infectionControl\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='interpOfSpecInves'>Interpretation of special investigations:</label>\n";
        form += "<select name=\"interpOfSpecInves\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaBlock'>Local anaesthesia (Block):</label>\n";
        form += "<select name=\"localAnaesthesiaBlock\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='localAnaesthesiaInfiltration'>Local anaesthesia (Infiltration):</label>\n";
        form += "<select name=\"localAnaesthesiaInfiltration\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='managementofComplications'>Management of complications:</label>\n";
        form += "<select name=\"managementofComplications\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='matSelecHandling'>Material selection and handling:</label>\n";
        form += "<select name=\"matSelecHandling\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        
        form += "<h1>Basic Operative Skills</h1>";
        form += "<label for='approPatPos'>Appropriate patient position:</label>\n";
        form += "<select name=\"approPatPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='approOpPos'>Appropriate operator position:</label>\n";
        form += "<select name=\"approOpPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='approLightPos'>Appropriate light position:</label>\n";
        form += "<select name=\"approLightPos\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='approUseOfMirror'>Appropriate use of mirror:</label>\n";
        form += "<select name=\"approUseOfMirror\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='approFingerSupport'>Appropriate finger support:</label>\n";
        form += "<select name=\"approFingerSupport\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        
        form += "<h1>Professionalism</h1>\n";
        form += "<label for='punctuality'>Punctuality:</label>\n";
        form += "<select name=\"punctuality\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='professionalApproach'>Professional Approach:</label>\n";
        form += "<select name=\"professionalApproach\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='selfAwareness'>Self Awareness:</label>\n";
        form += "<select name=\"selfAwareness\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='studentInsight'>StudentInsight:</label>\n";
        form += "<select name=\"studentInsight\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        
        form += "<h1>Communication</h1>\n";
        form += "<label for='abilToEstPatientHistory'>Ability to establish patient history:</label>\n";
        form += "<select name=\"abilToEstPatientHistory\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='abilToEnsureInformedConsent'>Ability to ensure informed consent:</label>\n";
        form += "<select name=\"abilToEnsureInformedConsent\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='abilToReqSpecialInvestigations'>Ability to request special investigations:</label>\n";
        form += "<select name=\"abilToReqSpecialInvestigations\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='abilToWritePerscription'>Ability to write perscription:</label>\n";
        form += "<select name=\"abilToWritePerscription\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='communicationWithDentalTeam'>Communication with dental team:</label>\n";
        form += "<select name=\"communicationWithDentalTeam\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='communicationWithPatientAndFamily'>Communication with patient/family members:</label>\n";
        form += "<select name=\"communicationWithPatientAndFamily\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";        
        form += "<label for='communicationWithTutor'>Communication with tutor:</label>\n";
        form += "<select name=\"communicationWithTutor\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='outlineOfReferalLetter'>Outline of referal letter:</label>\n";
        form += "<select name=\"outlineOfReferalLetter\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='patientRecordKeeping'>Patient record keeping:</label>\n";
        form += "<select name=\"patientRecordKeeping\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='charting'>Charting:</label>\n";
        form += "<select name=\"charting\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='presentationOfCase'>Presentation of case:</label>\n";
        form += "<select name=\"presentationOfCase\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        
        form += "<h1>Knowledge</h1>\n";
        form += "<label for='abilToUnderstandMedicalHistory '>Ability to understand medical history:</label>\n";
        form += "<select name=\"abilToUnderstandMedicalHistory\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='backKnowledgeForSessionProcedure'>Background Knowledge for session/procedure:</label>\n";
        form += "<select name=\"backKnowledgeForSessionProcedure\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        form += "<label for='justKnowledgeOfApproSpecInvest'>Justification for, and knowledge of appropriate special investigations:</label>\n";
        form += "<select name=\"justKnowledgeOfApproSpecInvest\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>1</option>\n" +
                    "  <option value=\"2\">2</option>\n" +
                    "  <option value=\"3\">3</option>\n" +
                    "  <option value=\"4\">4</option>\n" +
                    "  <option value=\"5\">5</option>\n" +
                    "  <option value=\"6\">6</option>\n" +
                "</select><br />";
        
        form += "<h1>Review</h1>\n";
        form += "<label for=\"checkbox\">Clinical Alert</label>\n" +
                "<input type=\"checkbox\" name=\"checkbox\" id=\"checkbox\" value=\"Yes\">\n";
        form += "<label for='comment'>Comment:</label>\n" +
                "<textarea name='comment' placeholder=\"Please comment on the students performance\" value='comment' id='comment'></textarea>\n" +
                "</select><br />";
        
        //form += "<label for='password'>Password:</label>\n";
        //form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />";
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
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
}
