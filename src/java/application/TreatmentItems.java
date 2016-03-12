/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Delaney
 */
public class TreatmentItems {
    private String studentID;
    private String treatmentID;
    private String treatmentPlanID;
    private String treatmentScore;
    private String comment;
    private String checkbox;
    private String attendance;
    private String cdsNumber;
    private String patientID;
    private String dateAdded;
    private String [] result;
    private DatabaseClass database;
    
    public TreatmentItems(){
        this.treatmentID = "";
        this.studentID = "";
        this.treatmentScore = "";
        this.comment = "";
        this.treatmentPlanID = "";
        this.checkbox = "";
        this.attendance = "";
        this.cdsNumber = "";
        this.patientID = "";
        this.dateAdded = "";
        this.result = new String[10];
        database = new DatabaseClass( );
        database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        //database.setup( "localhost", "final_year_project", "root", "" );
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String getTreatmentID() {
        return treatmentID;
    }
    
    public void setTreatmentID(String treatmentID) {
        this.treatmentID = treatmentID;
    }
    
    public String getComment( ) {
        return comment;
    }
 
    public void setComment( final String comment ) {
        this.comment = comment;
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
    
    public String getAttendance( ) {
        return attendance;
    }
 
    public void setAttendance( final String attendance ) {
        this.attendance = attendance;
    }
    
    public String getCdsNumber( ) {
        return cdsNumber;
    }
 
    public void setCdsNumber( final String cdsNumber ) {
        this.cdsNumber = cdsNumber;
    }
    
    public String getPatientID( ) {
        return patientID;
    }
 
    public void setPatientID( final String patientID) {
        this.patientID = patientID;
    }
    
    public String getDateAdded( ) {
        return dateAdded;
    }
 
    public void setDateAdded( final String dateAdded) {
        this.dateAdded = dateAdded;
    }
    
    public boolean hasBeenGraded( String StudentID, String TreatmentID ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        //database.setup( "localhost", "final_year_project", "root", "" );
        boolean isGraded = false;
        
        
        
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            isGraded = true;
        }
        
        
        //database.Close();
  
        return isGraded;
    }
    
    public boolean hasPerformedTreatments( String StudentID) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        //database.setup( "localhost", "final_year_project", "root", "" );
        boolean isGraded = true;
        
        result = database.SelectRow( "SELECT TreatmentID FROM TBICoreSkills WHERE StudentID=" + StudentID + ";" );
        
        if( result.length == 0 ) {
            isGraded = false;
        }
        
        
        //database.Close();
  
        return isGraded;
    }
    
    public String showGrade( String StudentID, String TreatmentID ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        //database.setup( "localhost", "final_year_project", "root", "" );
        String grade = "";
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            grade = result[25];
        }
        //database.Close();
  
        return grade;
    }
    
    public String buttonNav(){
        String  form = "<p>  </p>\n";
                
                form += "<div id=\"fixed\"><ul class=\"nav nav-pills nav-justified\">\n" +
                        "  <li class=\"active\"><a href='#info'>Info</a></li>\n" +
                        "  <li><a href='#periodontics'>Periodontics</a></li>\n" +
                        "  <li><a href='#prevention'>Prevention</a></li>\n" +
                        "  <li><a href='#direct'>Direct Restorations</a></li>\n" +
                        "  <li><a href='#indirect'>Indirect Restorations</a></li>\n" +
                        "  <li><a href='#endo'>Endodontics</a></li>\n" +
                        "  <li><a href='#pros'>Prosthodontics</a></li>\n" +
                        "  <li><a href='#tooth'>Tooth Whitening</a></li>\n" +
                        "</ul></div>";
                 
        return form;
    }
    
    public String showScore( String StudentID, String TreatmentID, String PatientID, String DateAdded ) throws SQLException {
        TreatmentItems treatment = new TreatmentItems();
        DatabaseClass database = new DatabaseClass( );
        database.setup( "ec2-52-31-7-122.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        //database.setup( "localhost", "final_year_project", "root", "" );
        String dateAdded = "";
        String time = "";
        String patientID = "";
        String treatmentID = "";
        String AbilityToEstablishDiagnosis = "";
        String AbilityToFormulateATreatmentPlan = "";
        String EnsuringInformedConsent = "";
        String EquipmentPreparationSelection = "";
        String ExaminationIntraOralHardTissues = "";
        String ExaminationIntraOralSoftTissues = "";
        String ExtraOralExamination = "";
        String InfectionControl = "";
        String InterpretationOfSpeciaInvestigations = "";
        String LocalAnaesthesiaBlock = "";
        String LocalAnaesthesiaInfiltration = "";
        String ManagementOfComplications = "";
        String MaterialSelectionAndHandling = "";
        String AppropriatePatientPosition = "";
        String AppropriateOperatorPosition =  "";
        String AppropriateLightPosition = "";
        String AppropriateUseOfMirror = "";
        String AppropriateFingerSupport = "";
        String Comment = "";
        String Professionalism = "";
        String Communication = "";
        String Knowledge = "";
        String Attendance = "";
        String Hour = "";

        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "' AND PatientID = '" + PatientID + "' AND DateAdded = '" + DateAdded + "';" );
        
        if( result.length != 0 ) {
            dateAdded = result[22];
            time = result[24];
            patientID = result[2];
            treatmentID = result[23];
            AbilityToEstablishDiagnosis = result[4];
            AbilityToFormulateATreatmentPlan = result[5];
            EnsuringInformedConsent = result[6];
            EquipmentPreparationSelection = result[7];
            ExaminationIntraOralHardTissues  = result[8];
            ExaminationIntraOralSoftTissues = result [9];
            ExtraOralExamination = result[10];
            InfectionControl = result[11];
            InterpretationOfSpeciaInvestigations = result[12];
            LocalAnaesthesiaBlock = result[13];
            LocalAnaesthesiaInfiltration = result[14];
            ManagementOfComplications = result[15];
            MaterialSelectionAndHandling = result[16];
            AppropriatePatientPosition = result[17];
            AppropriateOperatorPosition = result[18];
            AppropriateLightPosition = result[19];
            AppropriateUseOfMirror = result[20];
            AppropriateFingerSupport = result[21];
            Comment = result[25];
            Professionalism = result[26];
            Communication = result[27];
            Knowledge = result[28];
            Attendance = result[29];
            Hour = result[30];
        }
        
        TreatmentItems score = new TreatmentItems();
        
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table table-bordered\">\n";
                   form += "<thead>\n";
                   
                   form += "<th colspan=\"2\"><h1>Overview</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Student</th>\n";
                   form += "<td>" + score.fetchStudentName(StudentID) + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Date graded</th>\n";
                   form += "<td>" + dateAdded + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Time graded</th>\n";
                   form += "<td>" + time + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Patient CDS Number</th>\n";
                   form += "<td>" + patientID + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Treatment</th>\n";
                   form += "<td>" + score.fetchTreatmentName(treatmentID) + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Tutors Comments</th>\n";
                   form += "<td>" + Comment + "</td>\n";
                   form += "</tr>\n"; 
                   form += "<tr>\n";
                   form += "<th>Assiting</th>\n";
                   if( Attendance == "absent"){
                   form += "<td>" + Attendance + " from " + treatment.session(Hour) + "</td>\n";
                   }
                   if( Attendance == "yes"){
                   form += "<td>" + Attendance + " in " + treatment.session(Hour) + "</td>\n";
                   }
                   else{
                   form += "<td>" + Attendance + "</td>\n";    
                   }
                   form += "</tr>\n"; 
                   form += "<tr>\n";
                   form += "<th>Clinical Alert</th>\n";
                   form += "<td>" + score.fetchClinicalAlert(score.fetchTreatmentName(treatmentID),StudentID ) + "</td>\n";
                   form += "</tr>\n"; 
                   form += "<tr>\n";
                   
                   form += "<th colspan=\"2\"><h1>Core Skills Generic</h1></th>\n";
                   form += "<tr>";
                   form += "<th>Ability to establish diagnosis</th>\n";
                   form += "<td>" + AbilityToEstablishDiagnosis + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Ability to formulate a treatment plan</th>\n";
                   form += "<td>" + AbilityToFormulateATreatmentPlan + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Ensuring informed consent</th>\n";
                   form += "<td>" + EnsuringInformedConsent + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Equipment Preperation/Selection</th>\n";
                   form += "<td>" + EquipmentPreparationSelection + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Examination : Intra oral hard tissues</th>\n";
                   form += "<td>" + ExaminationIntraOralHardTissues + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Examination : Intra oral soft tissues</th>\n";
                   form += "<td>" + ExaminationIntraOralSoftTissues + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Extra oral examination</th>\n";
                   form += "<td>" + ExtraOralExamination + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Infection control</th>\n";
                   form += "<td>" + InfectionControl + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Interpretation of special investigations</th>\n";
                   form += "<td>" + InterpretationOfSpeciaInvestigations + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Local anaesthesia (Block)</th>\n";
                   form += "<td>" + LocalAnaesthesiaBlock + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Local anaesthesia (Infiltration)</th>\n";
                   form += "<td>" + LocalAnaesthesiaInfiltration + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Management of complications</th>\n";
                   form += "<td>" + ManagementOfComplications + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Material selection and handling</th>\n";
                   form += "<td>" + MaterialSelectionAndHandling + "</td>\n";
                   form += "</tr>\n";
                   
                   form += "<th colspan=\"2\"><h1>Basic Operative Skills</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate patient position</th>\n";
                   form += "<td>" + AppropriatePatientPosition + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate operator position</th>\n";
                   form += "<td>" + AppropriateOperatorPosition + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate light position</th>\n";
                   form += "<td>" + AppropriateLightPosition + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate use of mirror</th>\n";
                   form += "<td>" + AppropriateUseOfMirror + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate finger support</th>\n";
                   form += "<td>" + AppropriateFingerSupport + "</td>\n";
                   form += "</tr>\n";
                   
                   form += "<th colspan=\"2\"><h1>Professionalism</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Professionalism</th>\n";
                   form += "<td>" + Professionalism + "</td>\n";
                   form += "</tr>\n";
                   
                   form += "<th colspan=\"2\"><h1>Communication</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Communication</th>\n";
                   form += "<td>" + Communication + "</td>\n";
                   form += "</tr>\n";
                   
                   
                   form += "<th colspan=\"2\"><h1>Knowledge</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Knowledge</th>\n";
                   form += "<td>" + Knowledge + "</td>\n";
                   form += "</tr>\n";
                   
                   
                   form += "</thead>\n";
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";

        //conn.close(); 
        return form; 
    }
    
    public String fetchTreatments( String StudentID, String domain, String cdsNumber) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TreatmentItems.TreatmentItemID, TreatmentItems.TreatmentName, TreatmentItems.DomainID, TreatmentItems.RequirementsGroupID, TreatmentItems.RequirementsWeighting"
                            + " FROM TreatmentItems WHERE TreatmentItems.DomainID=" + domain + "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            TreatmentItems treatment = new TreatmentItems();

            
            
            String form =  "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>Treatment ID</th>\n";
                   form += "<th>Treatment Name</th>\n";
                   form += "<th>Patient CDS Number</th>\n";
                   form += "<th>Grade</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
               
            while(rs.next()){
                
                    form += "<tr>\n";
                    form += "<td><form name='grade' action='markStudent.jsp' method='POST'>"
                            + "<select name=\"studentID\" id='dropdown'>"
                            + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                            + "</select><br /></td>"
                            + "<td><select name=\"treatmentID\" id='dropdown'>"
                            + "<option value=\"" + rs.getString("TreatmentItems.TreatmentItemID") + "\" selected>" + rs.getString("TreatmentItems.TreatmentItemID") + "</option>"
                            + "</select><br />"
                            + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n"
                            + "<td><select name=\"cdsNumber\" id='dropdown'>"
                            + "<option value=\"" + cdsNumber + "\" selected>" + cdsNumber + "</option>"
                            + "</select><br /></td>";
                    form += "<td><input type=\"submit\" value=\"Grade\" class=\"btn-style\"></form>\n";
                    form += "" + absent(StudentID,rs.getString("TreatmentItems.TreatmentItemID") ) + "</td>\n";                     
                    /**form += "<td><select name=\"attendance\">"
                          + "<option value='absent' selected>Absent</option>"
                          + "<option value='present'>Present</option>"
                          + "<option value='assisting'>Assisting</option>"
                          + "</select><br />"
                          + "</td>\n"; **/
                    form += "</tr>\n";
               
                
            }
            
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
    
    
    public String absent(String StudentID, String TreatmentID) throws SQLException{
        TreatmentItems attendance = new TreatmentItems();
//        String TutorID = (String) session.getAttribute( "TutorID" );
        String form = "<form name='absent' action='absent.jsp' method='POST'>"
                            + "<select name=\"studentID\" id='dropdown'>"
                            + "<option value=\"" + StudentID + "\" selected></option>"
                            + "</select><br />"
                            + "<select name=\"treatmentID\" id='dropdown'>"
                            + "<option value=\"" + TreatmentID + "\" selected></option>"
                            + "</select><br />\n";
        form += "<input type=\"submit\" value=\"Absent\" class=\"btn-style\"></form>\n";
        
        return form;
        
    }
    
    public void markStudentAbsent( String studentID, String tutorID, String treatmentID ) throws SQLException {
        CoreSkills core = new CoreSkills();
        TreatmentItems treatment = new TreatmentItems();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String hour = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
    
        
        database.Insert( "INSERT INTO TBICoreSkills( StudentID, PatientID, TutorID, AbilityToEstablishDiagnosis, AbilityToFormulateATreatmentPlan, EnsuringInformedConsent, EquipmentPreparationSelection,"
                + "ExaminationIntraOralHardTissues, ExaminationIntraOralSoftTissues, ExtraOralExamination, InfectionControl, InterpretationOfSpeciaInvestigations, LocalAnaesthesiaBlock, LocalAnaesthesiaInfiltration,"
                + "ManagementOfComplications, MaterialSelectionAndHandling, AppropriatePatientPosition, AppropriateOperatorPosition, AppropriateLightPosition, AppropriateUseOfMirror, AppropriateFingerSupport,"
                + "DateAdded, TreatmentID, Time, Comment, Professionalism, Communication, Knowledge, Attendance, Hour )"
                +"VALUES( '" + studentID + "', '" + cdsNumber + "', '" + tutorID + "', '0', '0', '0', '0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','" + date + "','" + treatmentID + "','" + time + "','Absent from session','0','0','0','','" + hour + "' );" );
        
        
        database.Close();
    }
    
    public String fetchMyTreatments( String StudentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TBICoreSkills.PatientID, TBICoreSkills.TreatmentID, TBICoreSkills.DateAdded, TreatmentItems.TreatmentName, TreatmentItems.DomainID"
                            + " FROM TreatmentItems JOIN TBICoreSkills ON TBICoreSkills.TreatmentID = TreatmentItems.TreatmentItemID"
                            + " WHERE TBICoreSkills.StudentID=" + StudentID + "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>Treatment ID</th>\n";
                   form += "<th>Treatment Name</th>\n";
                   form += "<th>Domain ID</th>\n";
                   form += "<th>Date Graded</th>";
                   form += "<th>Patient CDS</th>";
                   form += "<th> </th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
               
            while(rs.next()){
                
                    form += "<tr>\n";
                    form += "<td><form name='grade' action='viewStudentScore.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                        + "</select><br /></td>"
                        + "<td><select name=\"treatmentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("TBICoreSkills.TreatmentID") + "\" selected>" + rs.getString("TBICoreSkills.TreatmentID") + "</option>"
                        + "</select><br />"
                        + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.DomainID") + "</td>\n"+ "<select name=\"studentID\" id='dropdown'>";
                    form += "<td><select name=\"dateAdded\" id='dropdown'>"
                         + "<option value=\"" + rs.getString("TBICoreSkills.DateAdded") + "\" selected>" + rs.getString("TBICoreSkills.DateAdded") + "</option>"
                         + "</select><br /></td>"
                         + "<td><select name=\"patientID\" id='dropdown'>"
                         + "<option value=\"" + rs.getString("TBICoreSkills.PatientID") + "\" selected>" + rs.getString("TBICoreSkills.PatientID") + "</option>"
                         + "</select><br /></td>";
                    form += "<td><input type=\"submit\" value=\"View Score\" class=\"btn-style\"></td></form>\n";
                    form += "</tr>\n";
                
                
            }
        
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
    public String fetchMyTreatments2( String StudentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TBICoreSkills.PatientID, TBICoreSkills.TreatmentID, TBICoreSkills.DateAdded, TreatmentItems.TreatmentName, TreatmentItems.DomainID"
                            + " FROM TreatmentItems JOIN TBICoreSkills ON TBICoreSkills.TreatmentID = TreatmentItems.TreatmentItemID"
                            + " WHERE TBICoreSkills.StudentID=" + StudentID + "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>Treatment ID</th>\n";
                   form += "<th>Treatment Name</th>\n";
                   form += "<th>Domain ID</th>\n";
                   form += "<th>Date Graded</th>";
                   form += "<th>Patient CDS</th>";
                   form += "<th> </th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
               
            while(rs.next()){
                
                    form += "<tr>\n";
                    form += "<td><form name='grade' action='viewMyScore.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                        + "</select><br /></td>"
                        + "<td><select name=\"treatmentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("TBICoreSkills.TreatmentID") + "\" selected>" + rs.getString("TBICoreSkills.TreatmentID") + "</option>"
                        + "</select><br />"
                        + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.DomainID") + "</td>\n"+ "<select name=\"studentID\" id='dropdown'>";
                    form += "<td><select name=\"dateAdded\" id='dropdown'>"
                         + "<option value=\"" + rs.getString("TBICoreSkills.DateAdded") + "\" selected>" + rs.getString("TBICoreSkills.DateAdded") + "</option>"
                         + "</select><br /></td>"
                         + "<td><select name=\"patientID\" id='dropdown'>"
                         + "<option value=\"" + rs.getString("TBICoreSkills.PatientID") + "\" selected>" + rs.getString("TBICoreSkills.PatientID") + "</option>"
                         + "</select><br /></td>";
                    form += "<td><input type=\"submit\" value=\"View Score\" class=\"btn-style\"></td></form>\n";
                    form += "</tr>\n";
                
                
            }
        
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
   
    
    
    public String fetchStudentName( String StudentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT FirstName, LastName FROM Students WHERE StudentID=" + StudentID + ";");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String form = "";
            while(rs.next()){
                form += rs.getString("FirstName") + " " + rs.getString("LastName") + "\n";
            }
            
            return form;
    }
    
    public String session(String hour){
        String period = "";
        
        int periodInt = Integer.parseInt(hour);
        if( periodInt < 12){
            period = "morning";
        }
        
        else{
            period = "afternoon";
        }
                
       return period;         
    }
    
    public String fetchClinicalAlert( String treatmentName, String studentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT ClinicalAlert FROM TreatmentPlanEntries JOIN TreatmentPlans "
                            + "ON TreatmentPlanEntries.PlanEntryID = TreatmentPlans.PlanID "
                            + "WHERE TreatmentPlanEntries.TreatmentName = '" + treatmentName + "'"
                            + " AND TreatmentPlans.StudentID = '" + studentID + "';");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String form = "";
            if(rs.next()){
                form += rs.getString("ClinicalAlert") + "\n";
            }
            
            return form;
    }
    
    public String fetchTutorName( String TutorID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT FirstName, LastName FROM TutorsWHERE TutorID=" + TutorID + ";");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String form = "";
            while(rs.next()){
                form += rs.getString("FirstName") + " " + rs.getString("LastName") + "\n";
            }
            
            return form;
    }
    
    public String fetchTreatmentName( String TreatmentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TreatmentName FROM TreatmentItems WHERE TreatmentItemID=" + TreatmentID + ";");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String form = "";
            while(rs.next()){
                form += rs.getString("TreatmentName") + "\n";
            }
            
            return form;       
    }
    
    public boolean isAbsent( String attendance){
        boolean is = false;
        
        if(attendance == "absent"){
            is = true;
        }
        return is;
    }
    

}

    





