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
    
    public boolean hasBeenGraded( String StudentID ) {
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        boolean isGraded = false;
        
        
        
        
        result = database.SelectRow( "SELECT TreatmentID FROM TBICoreSkills WHERE StudentID = '" + StudentID + "';" );
        
        if( result.length != 0 ) {
            isGraded = true;
        }
        
        
        //database.Close();
  
        return result.length != 0;
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
                if( hasBeenGraded( StudentID ) == false){
                    form += "<td>already graded</td>\n";
                }
                else{
                form += "<td><input type=\"submit\" value=\"Grade\" class=\"btn-style\"></td></form>\n";
                }
                form += "</tr>\n";
            }
            
            
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    

}

