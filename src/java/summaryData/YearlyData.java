/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summaryData;

/**
 *
 * @author Delaney
 */
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
public class YearlyData {
    private String [] result;
    
    public YearlyData(){
        this.result = new String[10];
    }
    
    public String showCore() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT * FROM TBICoreSkills WHERE DateAdded LIKE '%2016%';" );
        
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               form += "<p>" + rs.getString("StudentID") + "</p>";
        }
        
        conn.close();
        return form;
    }
    
    public String showBasic( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AppropriatePatientPosition = " + score + ") AS AppropriatePatientPositionCount,"
                + "SUM(AppropriateOperatorPosition = " + score + " ) AS AppropriateOperatorPositionCount, "
                + "SUM(AppropriateLightPosition = " + score + " ) AS AppropriateLightPositionCount, "
                + "SUM(AppropriateUseOfMirror = " + score + " ) AS AppropriateUseOfMirrorCount, "
                + "SUM(AppropriateFingerSupport = " + score + " ) AS AppropriateFingerSupportCount " 
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE tb.DateAdded LIKE '%" + group + "%';" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int AppropriatePatientPositionInt = Integer.parseInt(rs.getString("AppropriatePatientPositionCount"));
               int AppropriateOperatorPositionInt = Integer.parseInt(rs.getString("AppropriateOperatorPositionCount"));
               int AppropriateLightPositionInt = Integer.parseInt(rs.getString("AppropriateLightPositionCount"));
               int AppropriateUseOfMirrorInt = Integer.parseInt(rs.getString("AppropriateUseOfMirrorCount"));
               int AppropriateFingerSupportInt = Integer.parseInt(rs.getString("AppropriateFingerSupportCount"));
               
               countTotal = AppropriatePatientPositionInt + AppropriateOperatorPositionInt + AppropriateLightPositionInt + AppropriateUseOfMirrorInt + AppropriateFingerSupportInt;
               form += countTotal;
               form += "</div>\n";
        }
        conn.close();
        return form;
    }
    
    
    public String showProfessionalism( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Professionalism = " + score + ") AS ProfessionalismCount "
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE tb.DateAdded LIKE '%" + group + "%';" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int ProfessionalismInt = Integer.parseInt(rs.getString("ProfessionalismCount"));
               
               countTotal = ProfessionalismInt;
               form += countTotal;
               form += "</div>\n";
        }
        conn.close();
        return form;
    }
    
    public String showCommunication( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Communication = " + score + ") AS CommunicationCount "
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE tb.DateAdded LIKE '%" + group + "%';" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int CommunicationInt = Integer.parseInt(rs.getString("CommunicationCount"));
               
               countTotal = CommunicationInt;
               form += countTotal;
               form += "</div>\n";
        }
        conn.close();
        return form;
    }
    
    public String showKnowledge( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Knowledge= " + score + ") AS KnowledgeCount "
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE tb.DateAdded LIKE '%" + group + "%';" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int KnowledgeInt = Integer.parseInt(rs.getString("KnowledgeCount"));
               
               countTotal = KnowledgeInt;
               form += countTotal;
               form += "</div>\n";
        }
        conn.close();
        return form;
    }
    
    public String studentData() throws SQLException{
        GroupSummaryData check = new GroupSummaryData();
        String form = "<table class=\"table table-striped table-bordered table-condensed\" width=\"647\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th></th>\n";
                   form += "<th colspan=\"6\">Development Need Indicator</th>";
                   form += "</tr>";
                   form += "<tr>\n";
                   form += "<th>Skill</th>\n";
                   form += "<th>1 (Total)</th>\n";
                   form += "<th>2 (Total)</th>\n";
                   form += "<th>3 (Total)</th>\n";
                   form += "<th>4 (Total)</th>\n";
                   form += "<th>5 (Total)</th>\n";
                   form += "<th>6 (Total)</th>\n";
                   form += "</tr>\n";
                   form += "</thead>\n";
                   form += "<tr>";
                   form += "<th>Core Skills Generic</th>\n";
                   form += showCore();
                   form += "</tr>\n";
                   
        return form;
    }
    
    public String searchBox(){
        String form = "<div class=\"input-group\">\n" +
        "      <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\">\n" +
        "      <input type='submit' value='Submit' name='submit' /><br />\n" +
        "    </div><!-- /input-group --></li>\n";
        
        return form;
    }
    
    
}
