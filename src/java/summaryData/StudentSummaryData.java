/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summaryData;

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
public class StudentSummaryData {
    private String [] result;
    
    public StudentSummaryData(){
        this.result = new String[10];
    }
    
    public String showCore( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AbilityToEstablishDiagnosis = " + score + ") AS AbilToEstDiagCount,"
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
                + "FROM TBICoreSkills" );
                //+ "FROM TBICoreSkills WHERE StudentID = 112445898 AND DateAdded LIKE '%2015%';" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "";
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
        }
        
        return form;
    }
    
    public String showBasic( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriatePatientPosition = " + score + ") AS AppropriatePatientPositionCount,"
                + "SUM(AppropriateOperatorPosition = " + score + " ) AS AppropriateOperatorPositionCount, "
                + "SUM(AppropriateLightPosition = " + score + " ) AS AppropriateLightPositionCount, "
                + "SUM(AppropriateUseOfMirror = " + score + " ) AS AppropriateUseOfMirrorCount, "
                + "SUM(AppropriateFingerSupport = " + score + " ) AS AppropriateFingerSupportCount " 
                + "FROM TBICoreSkills" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "";
        while(rs.next()){
             
               int AppropriatePatientPositionInt = Integer.parseInt(rs.getString("AppropriatePatientPositionCount"));
               int AppropriateOperatorPositionInt = Integer.parseInt(rs.getString("AppropriateOperatorPositionCount"));
               int AppropriateLightPositionInt = Integer.parseInt(rs.getString("AppropriateLightPositionCount"));
               int AppropriateUseOfMirrorInt = Integer.parseInt(rs.getString("AppropriateUseOfMirrorCount"));
               int AppropriateFingerSupportInt = Integer.parseInt(rs.getString("AppropriateFingerSupportCount"));
               
               countTotal = AppropriatePatientPositionInt + AppropriateOperatorPositionInt + AppropriateLightPositionInt + AppropriateUseOfMirrorInt + AppropriateFingerSupportInt;
               form += countTotal;
        }
        
        return form;
    }
    
    
    public String showProfessionalism( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(Professionalism = " + score + ") AS ProfessionalismCount "
                + "FROM TBICoreSkills" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "";
        while(rs.next()){
             
               int ProfessionalismInt = Integer.parseInt(rs.getString("ProfessionalismCount"));
               
               countTotal = ProfessionalismInt;
               form += countTotal;
        }
        
        return form;
    }
    
    public String showCommunication( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(Communication = " + score + ") AS CommunicationCount "
                + "FROM TBICoreSkills" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "";
        while(rs.next()){
             
               int CommunicationInt = Integer.parseInt(rs.getString("CommunicationCount"));
               
               countTotal = CommunicationInt;
               form += countTotal;
        }
        
        return form;
    }
    
    public String showKnowledge( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(Knowledge= " + score + ") AS KnowledgeCount "
                + "FROM TBICoreSkills" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "";
        while(rs.next()){
             
               int KnowledgeInt = Integer.parseInt(rs.getString("KnowledgeCount"));
               
               countTotal = KnowledgeInt;
               form += countTotal;
        }
        
        return form;
    }
    
    public String studentData() throws SQLException{
        StudentSummaryData check = new StudentSummaryData();
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
                   form += "<th>" + check.showCore(1) + "</th>\n";
                   form += "<th>" + check.showCore(2) + "</th>\n";
                   form += "<th>" + check.showCore(3) + "</th>\n";
                   form += "<th>" + check.showCore(4) + "</th>\n";
                   form += "<th>" + check.showCore(5) + "</th>\n";
                   form += "<th>" + check.showCore(6) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Basic Operative Skills</th>\n";
                   form += "<th>" + check.showBasic(1) + "</th>\n";
                   form += "<th>" + check.showBasic(2) + "</th>\n";
                   form += "<th>" + check.showBasic(3) + "</th>\n";
                   form += "<th>" + check.showBasic(4) + "</th>\n";
                   form += "<th>" + check.showBasic(5) + "</th>\n";
                   form += "<th>" + check.showBasic(6) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Professionalism</th>\n";
                   form += "<th>" + check.showProfessionalism(1) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(2) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(3) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(4) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(5) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(6) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Communication</th>\n";
                   form += "<th>" + check.showCommunication(1) + "</th>\n";
                   form += "<th>" + check.showCommunication(2) + "</th>\n";
                   form += "<th>" + check.showCommunication(3) + "</th>\n";
                   form += "<th>" + check.showCommunication(4) + "</th>\n";
                   form += "<th>" + check.showCommunication(5) + "</th>\n";
                   form += "<th>" + check.showCommunication(6) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Knowledge</th>\n";
                   form += "<th>" + check.showKnowledge(1) + "</th>\n";
                   form += "<th>" + check.showKnowledge(2) + "</th>\n";
                   form += "<th>" + check.showKnowledge(3) + "</th>\n";
                   form += "<th>" + check.showKnowledge(4) + "</th>\n";
                   form += "<th>" + check.showKnowledge(5) + "</th>\n";
                   form += "<th>" + check.showKnowledge(6) + "</th>\n";
                   form += "</tr>\n";
                   form += "</tr>\n";
                   form += "</table>\n";
                   
        return form;
    }
    
}
