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
public class StudentYearlySummaryData {
    private String [] result;
    
    public StudentYearlySummaryData(){
        this.result = new String[10];
    }
    
    public String showCore( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT tb.StudentID, "
                + "SUM(AbilityToEstablishDiagnosis = 1) AS AbilToEstDiagCount, "
                + "SUM(AbilityToFormulateATreatmentPlan = " + score + " ) AS AbilToFormATreatmentPlanCount, "
                + "SUM(EnsuringInformedConsent = " + score + " ) AS EnsuringInfConCount, "
                + "SUM(EquipmentPreparationSelection = " + score + " ) AS EquipPrepSelectCount, "
                + "SUM(ExaminationIntraOralHardTissues = " + score + " ) AS ExamIntraOralHardCount, "
                + "SUM(ExaminationIntraOralSoftTissues = " + score + " ) AS ExamIntraOralSoftCount, "
                + "SUM(ExtraOralExamination = " + score + " ) AS ExtraOralExaminationCount, "
                + "SUM(InfectionControl = " + score + " ) AS InfectionControlCount, "
                + "SUM(InterpretationOfSpeciaInvestigations = " + score + " ) AS InterpOfSpeciaInvestCount, "
                + "SUM(LocalAnaesthesiaBlock = " + score + " ) AS LocalAnaesthesiaBlockCount, "
                + "SUM(LocalAnaesthesiaInfiltration = " + score + " ) AS LocalAnaesthesiaInfiltrationCount, "
                + "SUM(ManagementOfComplications = " + score + " ) AS ManagementOfComplicationsCount, "
                + "SUM(MaterialSelectionAndHandling = " + score + " ) AS MaterialSelectionAndHandlingCount " 
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int AbilToEstDiagInt = Integer.parseInt(rs.getString("AbilToEstDiagCount"));
               int AbilToFormATreatmentPlanInt = Integer.parseInt(rs.getString("AbilToFormATreatmentPlanCount"));
               int EnsuringInfConInt = Integer.parseInt(rs.getString("EnsuringInfConCount"));
               int EquipPrepSelectInt = Integer.parseInt(rs.getString("EquipPrepSelectCount"));
               int ExamIntraOralHardInt = Integer.parseInt(rs.getString("ExamIntraOralHardCount"));
               int ExamIntraOralSoftCountInt = Integer.parseInt(rs.getString("ExamIntraOralSoftCount"));
               int ExtraOralExaminationInt = Integer.parseInt(rs.getString("ExtraOralExaminationCount"));
               int InfectionControlInt = Integer.parseInt(rs.getString("InfectionControlCount"));
               int InterpOfSpeciaInvestInt = Integer.parseInt(rs.getString("InterpOfSpeciaInvestCount"));
               int LocalAnaesthesiaBlockInt = Integer.parseInt(rs.getString("LocalAnaesthesiaBlockCount"));
               int LocalAnaesthesiaInfiltrationInt = Integer.parseInt(rs.getString("LocalAnaesthesiaInfiltrationCount"));
               int ManagementOfComplicationsInt = Integer.parseInt(rs.getString("ManagementOfComplicationsCount"));
               int MaterialSelectionAndHandlingInt = Integer.parseInt(rs.getString("MaterialSelectionAndHandlingCount"));
               
               countTotal = AbilToEstDiagInt + AbilToFormATreatmentPlanInt + EnsuringInfConInt + EquipPrepSelectInt + ExamIntraOralHardInt + ExamIntraOralSoftCountInt + ExtraOralExaminationInt + InfectionControlInt + InterpOfSpeciaInvestInt + LocalAnaesthesiaBlockInt + LocalAnaesthesiaInfiltrationInt + ManagementOfComplicationsInt + MaterialSelectionAndHandlingInt;
               //form += "<h1>Core Skills Generic ount total " + countTotal + "</h1>\n";
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showBasic( int score, String group ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AppropriatePatientPosition = 1) AS AppropriatePatientPositionCount,"
                + "SUM(AppropriateOperatorPosition = " + score + " ) AS AppropriateOperatorPositionCount, "
                + "SUM(AppropriateLightPosition = " + score + " ) AS AppropriateLightPositionCount, "
                + "SUM(AppropriateUseOfMirror = " + score + " ) AS AppropriateUseOfMirrorCount, "
                + "SUM(AppropriateFingerSupport = " + score + " ) AS AppropriateFingerSupportCount " 
                + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
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
                            + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
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
                            + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
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
                            + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
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
    
    public String studentData(String group) throws SQLException{
        StudentYearlySummaryData check = new StudentYearlySummaryData();
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
                   form += "<th>" + check.showCore(1,group) + "</th>\n";
                   form += "<th>" + check.showCore(2,group) + "</th>\n";
                   form += "<th>" + check.showCore(3,group) + "</th>\n";
                   form += "<th>" + check.showCore(4,group) + "</th>\n";
                   form += "<th>" + check.showCore(5,group) + "</th>\n";
                   form += "<th>" + check.showCore(6,group) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Basic Operative Skills</th>\n";
                   form += "<th>" + check.showBasic(1,group) + "</th>\n";
                   form += "<th>" + check.showBasic(2,group) + "</th>\n";
                   form += "<th>" + check.showBasic(3,group) + "</th>\n";
                   form += "<th>" + check.showBasic(4,group) + "</th>\n";
                   form += "<th>" + check.showBasic(5,group) + "</th>\n";
                   form += "<th>" + check.showBasic(6,group) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Professionalism</th>\n";
                   form += "<th>" + check.showProfessionalism(1,group) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(2,group) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(3,group) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(4,group) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(5,group) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(6,group) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Communication</th>\n";
                   form += "<th>" + check.showCommunication(1,group) + "</th>\n";
                   form += "<th>" + check.showCommunication(2,group) + "</th>\n";
                   form += "<th>" + check.showCommunication(3,group) + "</th>\n";
                   form += "<th>" + check.showCommunication(4,group) + "</th>\n";
                   form += "<th>" + check.showCommunication(5,group) + "</th>\n";
                   form += "<th>" + check.showCommunication(6,group) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Knowledge</th>\n";
                   form += "<th>" + check.showKnowledge(1,group) + "</th>\n";
                   form += "<th>" + check.showKnowledge(2,group) + "</th>\n";
                   form += "<th>" + check.showKnowledge(3,group) + "</th>\n";
                   form += "<th>" + check.showKnowledge(4,group) + "</th>\n";
                   form += "<th>" + check.showKnowledge(5,group) + "</th>\n";
                   form += "<th>" + check.showKnowledge(6,group) + "</th>\n";
                   form += "</tr>\n";
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
