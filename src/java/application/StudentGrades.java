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
public class StudentGrades {
    private String studentID;
    private String treatmentID;
    private final DatabaseClass database;
    private String [] result;
    
    public StudentGrades(){
        this.treatmentID = "";
        this.studentID = "";
        database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
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
        boolean isGraded = false;
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            isGraded = true;
        }
        
        
        ////database.Close();
  
        return isGraded;
    }
    
    public String showGrade( String StudentID, String TreatmentID ) {
        String grade = "";
        
        result = database.SelectRow( "SELECT * FROM TBICoreSkills WHERE StudentID = '" + StudentID + "' AND TreatmentID = '" + TreatmentID + "';" );
        
        if( result.length != 0 ) {
            grade = result[25];
        }
        
        
        ////database.Close();
  
        return grade;
    }
    
    public String fetchTreatments( String StudentID) throws SQLException{
            //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
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
                    form += "<td class='red'>" + showGrade( StudentID,rs.getString("TreatmentItems.TreatmentItemID") ) + "</td>\n";
                    form += "</tr>\n";
                }
                
            }
        
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    

}
