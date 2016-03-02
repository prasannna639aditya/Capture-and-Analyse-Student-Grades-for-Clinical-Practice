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
    private String [] result;
    
    public TreatmentItems(){
        this.treatmentID = "";
        this.studentID = "";
        this.treatmentScore = "";
        this.comment = "";
        this.treatmentPlanID = "";
        this.checkbox = "";
        this.attendance = "";
        this.result = new String[10];
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
    
    public boolean hasBeenGraded( String StudentID, String TreatmentID ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        boolean isGraded = false;
        
        
        
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            isGraded = true;
        }
        
        
        //database.Close();
  
        return isGraded;
    }
    
    public String showGrade( String StudentID, String TreatmentID ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        String grade = "";
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            grade = result[25];
        }
        //database.Close();
  
        return grade;
    }
    
    public String showScore( String StudentID, String TreatmentID ) throws SQLException {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
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

        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
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
        }
        
        TreatmentItems score = new TreatmentItems();
        
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   
                   form += "<th><h1>Overview</h1></th>\n";
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
                   form += "<th>Patient</th>\n";
                   form += "<td>" + score.fetchPatientName(patientID) + "</td>\n";
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
                   form += "<th>Clinical Alert</th>\n";
                   form += "<td>" + score.fetchClinicalAlert(score.fetchTreatmentName(treatmentID),StudentID ) + "</td>\n";
                   form += "</tr>\n"; 
                   form += "<tr>\n";
                   
                   form += "<th><h1>Core Skills Generic</h1></th>\n";
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
                   
                   form += "<th><h1>Basic Operative Skills</h1></th>\n";
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
                   
                   form += "<th><h1>Professionalism</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Professionalism</th>\n";
                   form += "<td>" + Professionalism + "</td>\n";
                   form += "</tr>\n";
                   
                   form += "<th><h1>Communication</h1></th>\n";
                   form += "<tr>\n";
                   form += "<th>Communication</th>\n";
                   form += "<td>" + Communication + "</td>\n";
                   form += "</tr>\n";
                   
                   
                   form += "<th><h1>Knowledge</h1></th>\n";
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
    
    public String fetchTreatments( String StudentID) throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TreatmentItems.TreatmentItemID, TreatmentItems.TreatmentName, TreatmentItems.DomainID, TreatmentItems.RequirementsGroupID, TreatmentItems.RequirementsWeighting"
                            + " FROM TreatmentItems");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            
            String form = "<div>Please see the treatments that " + StudentID + " has and has not been graded for\n";
                   form += "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>Treatment ID</th>\n";
                   form += "<th>Treatment Name</th>\n";
                   form += "<th>Domain ID</th>\n";
                   form += "<th>Requirements Group ID</th>\n";
                   form += "<th>Attendance</th>\n";
                   form += "<th>Grade</th>";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
               
            while(rs.next()){
                if( hasBeenGraded( StudentID, rs.getString("TreatmentItems.TreatmentItemID") ) == true){
                    form += "<tr class='graded'>\n";
                    form += "<td><form name='grade' action='viewScore.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                        + "</select><br /></td>"
                        + "<td><select name=\"treatmentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("TreatmentItems.TreatmentItemID") + "\" selected>" + rs.getString("TreatmentItems.TreatmentItemID") + "</option>"
                        + "</select><br />"
                        + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.DomainID") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsGroupID") + "</td>\n";
                    form += "<td></td>\n";
                    //form += "<td class='red'>" + showGrade( StudentID,rs.getString("TreatmentItems.TreatmentItemID") ) + "</td>\n";
                    form += "<td><input type=\"submit\" value=\"View Score\" class=\"btn-style\"></td></form>\n";
                    form += "</tr>\n";
                }
                
               else{
                    form += "<tr>\n";
                    form += "<td><form name='grade' action='markStudent.jsp' method='POST'>"
                            + "<select name=\"studentID\" id='dropdown'>"
                            + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                            + "</select><br /></td>"
                            + "<td><select name=\"treatmentID\" id='dropdown'>"
                            + "<option value=\"" + rs.getString("TreatmentItems.TreatmentItemID") + "\" selected>" + rs.getString("TreatmentItems.TreatmentItemID") + "</option>"
                            + "</select><br />"
                            + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.DomainID") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsGroupID") + "</td>\n";
                    form += "<td><select name=\"attendance\">"
                          + "<option value='absent' selected>Absent</option>"
                          + "<option value='present'>Present</option>"
                          + "<option value='assisting'>Assisting</option>"
                          + "</select><br />"
                          + "</td>\n";
                    form += "<td><input type=\"submit\" value=\"Grade\" class=\"btn-style\"></td></form>\n";
                    form += "</tr>\n";
                }
                
            }
        
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
    public String fetchMyTreatments( String StudentID) throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TreatmentItems.TreatmentItemID, TreatmentItems.TreatmentName, TreatmentItems.DomainID, TreatmentItems.RequirementsGroupID, TreatmentItems.RequirementsWeighting"
                            + " FROM TreatmentItems");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            
            String form = "<div>Please see the treatments that " + StudentID + " has and has not been graded for\n";
                   form += "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>Treatment ID</th>\n";
                   form += "<th>Treatment Name</th>\n";
                   form += "<th>Domain ID</th>\n";
                   form += "<th>Requirements Group ID</th>\n";
                   form += "<th>Requirements Weighting</th>\n";
                   form += "<th>Grade</th>";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
               
            while(rs.next()){
                if( hasBeenGraded( StudentID, rs.getString("TreatmentItems.TreatmentItemID") ) == true){
                    form += "<tr class='graded'>\n";
                    form += "<td><form name='grade' action='viewStudentScore.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + StudentID + "\" selected>" + StudentID + "</option>"
                        + "</select><br /></td>"
                        + "<td><select name=\"treatmentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("TreatmentItems.TreatmentItemID") + "\" selected>" + rs.getString("TreatmentItems.TreatmentItemID") + "</option>"
                        + "</select><br />"
                        + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.TreatmentName") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.DomainID") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsGroupID") + "</td>\n";
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsWeighting") + "</td>\n";
                    //form += "<td class='red'>" + showGrade( StudentID,rs.getString("TreatmentItems.TreatmentItemID") ) + "</td>\n";
                    form += "<td><input type=\"submit\" value=\"View Score\" class=\"btn-style\"></td></form>\n";
                    form += "</tr>\n";
                }
                
               else{
                    form += "<tr>\n";
                    form += "</tr>\n";
                }
                
            }
        
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
   
    
    
    public String fetchStudentName( String StudentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
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
    
    public String fetchClinicalAlert( String treatmentName, String studentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
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
    
    public String fetchPatientName( String PatientID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT FirstName, LastName FROM Patients WHERE PatientID=" + PatientID + ";");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String form = "";
            while(rs.next()){
                form += rs.getString("FirstName") + " " + rs.getString("LastName") + "\n";
            }
            
            return form;
    }
    
    public String fetchTreatmentName( String TreatmentID) throws SQLException{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
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
        boolean is = true;
        
        if(attendance == "absent"){
            is = false;
        }
        return is;
    }
    

}

    





