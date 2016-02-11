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
    private String [] result;
    
    public TreatmentItems(){
        this.treatmentID = "";
        this.studentID = "";
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
                   form += "<th>Requirements Weighting</th>\n";
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
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsWeighting") + "</td>\n";
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
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsWeighting") + "</td>\n";
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
    
    public String fetchSpecificTreatment( String StudentID, String Domain) throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT TreatmentItems.TreatmentItemID, TreatmentItems.TreatmentName, TreatmentItems.DomainID, TreatmentItems.RequirementsGroupID, TreatmentItems.RequirementsWeighting"
                            + " FROM TreatmentItems ON TreatmentItems.DomainID=" + Domain + ";");
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
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsWeighting") + "</td>\n";
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
                    form += "<td>" + rs.getString("TreatmentItems.RequirementsWeighting") + "</td>\n";
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
    
    
    public String fetchScore( String StudentID, String StudentName, String Treatment) throws SQLException{
        //String form = "<p>Hello" + StudentID + "</p>";
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT * FROM TBICoreSkills WHERE StudentID=" + StudentID + ";");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            TreatmentItems score = new TreatmentItems();

            
            
            String form = "<div>Please see the treatments that " + StudentID + " has and has not been graded for\n";
                   form += "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   
            while(rs.next()){
                   form += "<tr>\n";
                   form += "<th>Student</th>\n";
                   form += "<td>" + StudentName + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Date graded</th>\n";
                   form += "<td>" + rs.getString("DateAdded") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Time graded</th>\n";
                   form += "<td>" + rs.getString("Time") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Patient</th>\n";
                   form += "<td>" + score.fetchPatientName(rs.getString("PatientID")) + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Treatment</th>\n";
                   form += "<td>" + score.fetchTreatmentName(rs.getString("TreatmentID")) + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Ability to establish diagnosis</th>\n";
                   form += "<td>" + rs.getString("AbilityToEstablishDiagnosis") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Ability to formulate a treatment plan</th>\n";
                   form += "<td>" + rs.getString("AbilityToFormulateATreatmentPlan") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Ensuring informed consent</th>\n";
                   form += "<td>" + rs.getString("EnsuringInformedConsent") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Equipment Preperation/Selection</th>\n";
                   form += "<td>" + rs.getString("EquipmentPreparationSelection") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Examination : Intra oral hard tissues</th>\n";
                   form += "<td>" + rs.getString("ExaminationIntraOralHardTissues") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Examination : Intra oral soft tissues</th>\n";
                   form += "<td>" + rs.getString("ExaminationIntraOralSoftTissues") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Extra oral examination</th>\n";
                   form += "<td>" + rs.getString("ExtraOralExamination") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Infection control</th>\n";
                   form += "<td>" + rs.getString("InfectionControl") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Interpretation of special investigations</th>\n";
                   form += "<td>" + rs.getString("InterpretationOfSpeciaInvestigations") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Local anaesthesia (Block)</th>\n";
                   form += "<td>" + rs.getString("LocalAnaesthesiaBlock") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Local anaesthesia (Infiltration)</th>\n";
                   form += "<td>" + rs.getString("LocalAnaesthesiaInfiltration") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Management of complications</th>\n";
                   form += "<td>" + rs.getString("ManagementOfComplications") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Material selection and handling</th>\n";
                   form += "<td>" + rs.getString("MaterialSelectionAndHandling") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate patient position</th>\n";
                   form += "<td>" + rs.getString("AppropriatePatientPosition") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate operator position</th>\n";
                   form += "<td>" + rs.getString("AppropriateOperatorPosition") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate light position</th>\n";
                   form += "<td>" + rs.getString("AppropriateLightPosition") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate use of mirror</th>\n";
                   form += "<td>" + rs.getString("AppropriateUseOfMirror") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Appropriate finger support</th>\n";
                   form += "<td>" + rs.getString("AppropriateFingerSupport") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Tutors Comments</th>\n";
                   form += "<td>" + rs.getString("Comment") + "</td>\n";
                   form += "</tr>\n";
                   form += "<tr>\n";
                   form += "<th>Aggregated score</th>\n";
                   form += "<td>" + rs.getString("TreatmentScore") + "</td>\n";
                   form += "</tr>\n";
                   
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   
                   form += "</tr>\n";
                
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

}

    





