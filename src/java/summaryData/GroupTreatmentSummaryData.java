/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summaryData;

import java.applet.Applet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Delaney
 */
public class GroupTreatmentSummaryData extends Applet {
    private String [] result;
    private String group;
    
    public GroupTreatmentSummaryData(){
        this.result = new String[10];
        this.group = "";
    }
    
    public String showAbilToEstDiag( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AbilityToEstablishDiagnosis = " + score + ") AS AbilToEstDiagCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AbilToEstDiagInt = Integer.parseInt(rs.getString("AbilToEstDiagCount"));
               countTotal = AbilToEstDiagInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAbilityToFormulateATreatmentPlan( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AbilityToFormulateATreatmentPlan = " + score + ") AS AbilityToFormulateATreatmentPlanCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AbilityToFormulateATreatmentPlanInt = Integer.parseInt(rs.getString("AbilityToFormulateATreatmentPlanCount"));
               countTotal = AbilityToFormulateATreatmentPlanInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showEnsuringInformedConsent( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(EnsuringInformedConsent = " + score + ") AS EnsuringInformedConsentCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int EnsuringInformedConsentInt = Integer.parseInt(rs.getString("EnsuringInformedConsentCount"));
               countTotal = EnsuringInformedConsentInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showEquipmentPreparationSelection( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(EquipmentPreparationSelection = " + score + ") AS EquipmentPreparationSelectionCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int EquipmentPreparationSelectionInt = Integer.parseInt(rs.getString("EquipmentPreparationSelectionCount"));
               countTotal = EquipmentPreparationSelectionInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showExaminationIntraOralHardTissues( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(ExaminationIntraOralHardTissues = " + score + ") AS ExaminationIntraOralHardTissuesCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int ExaminationIntraOralHardTissuesInt = Integer.parseInt(rs.getString("ExaminationIntraOralHardTissuesCount"));
               countTotal = ExaminationIntraOralHardTissuesInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showExaminationIntraOralSoftTissues( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(ExaminationIntraOralSoftTissues = " + score + ") AS ExaminationIntraOralSoftTissuesCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int ExaminationIntraOralSoftTissuesInt = Integer.parseInt(rs.getString("ExaminationIntraOralSoftTissuesCount"));
               countTotal = ExaminationIntraOralSoftTissuesInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showExtraOralExamination( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(ExtraOralExamination = " + score + ") AS ExtraOralExaminationCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int ExtraOralExaminationInt = Integer.parseInt(rs.getString("ExtraOralExaminationCount"));
               countTotal = ExtraOralExaminationInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showInfectionControl( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(InfectionControl = " + score + ") AS InfectionControlCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int InfectionControlInt = Integer.parseInt(rs.getString("InfectionControlCount"));
               countTotal = InfectionControlInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showInterpretationOfSpeciaInvestigations( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(InterpretationOfSpeciaInvestigations = " + score + ") AS InterpretationOfSpeciaInvestigationsCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int InterpretationOfSpeciaInvestigationsInt = Integer.parseInt(rs.getString("InterpretationOfSpeciaInvestigationsCount"));
               countTotal = InterpretationOfSpeciaInvestigationsInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showLocalAnaesthesiaBlock( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(LocalAnaesthesiaBlock = " + score + ") AS LocalAnaesthesiaBlockCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int LocalAnaesthesiaBlockInt = Integer.parseInt(rs.getString("LocalAnaesthesiaBlockCount"));
               countTotal = LocalAnaesthesiaBlockInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showLocalAnaesthesiaInfiltration( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(LocalAnaesthesiaInfiltration = " + score + ") AS LocalAnaesthesiaInfiltrationCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int LocalAnaesthesiaInfiltrationInt = Integer.parseInt(rs.getString("LocalAnaesthesiaInfiltrationCount"));
               countTotal = LocalAnaesthesiaInfiltrationInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showManagementOfComplications( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(ManagementOfComplications = " + score + ") AS ManagementOfComplicationsCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int ManagementOfComplicationsInt = Integer.parseInt(rs.getString("ManagementOfComplicationsCount"));
               countTotal = ManagementOfComplicationsInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showMaterialSelectionAndHandling( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(MaterialSelectionAndHandling = " + score + ") AS MaterialSelectionAndHandlingCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int MaterialSelectionAndHandlingInt = Integer.parseInt(rs.getString("MaterialSelectionAndHandlingCount"));
               countTotal = MaterialSelectionAndHandlingInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAppropriatePatientPosition( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriatePatientPosition = " + score + ") AS AppropriatePatientPositionCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AppropriatePatientPositionInt = Integer.parseInt(rs.getString("AppropriatePatientPositionCount"));
               countTotal = AppropriatePatientPositionInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAppropriateOperatorPosition( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriateOperatorPosition = " + score + ") AS AppropriateOperatorPositionCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AppropriateOperatorPositionInt = Integer.parseInt(rs.getString("AppropriateOperatorPositionCount"));
               countTotal = AppropriateOperatorPositionInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAppropriateLightPosition( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriateLightPosition = " + score + ") AS AppropriateLightPositionCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AppropriateLightPositionInt = Integer.parseInt(rs.getString("AppropriateLightPositionCount"));
               countTotal = AppropriateLightPositionInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAppropriateUseOfMirror( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriateUseOfMirror = " + score + ") AS AppropriateUseOfMirrorCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AppropriateUseOfMirrorInt = Integer.parseInt(rs.getString("AppropriateUseOfMirrorCount"));
               countTotal = AppropriateUseOfMirrorInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showAppropriateFingerSupport( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
        String query =( "SELECT SUM(AppropriateFingerSupport = " + score + ") AS AppropriateFingerSupportCount "
                      + "FROM TBICoreSkills AS tb JOIN Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                      + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                      + " WHERE StudentGroups.GroupDescriptor =" + group + ";" );
        
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        String form = "<div>\n";
        while(rs.next()){
               int AppropriateFingerSupportInt = Integer.parseInt(rs.getString("AppropriateFingerSupportCount"));
               countTotal = AppropriateFingerSupportInt;
               form += countTotal;
               form += "</div>\n";
        }
        
        conn.close();
        return form;
    }
    
    public String showProfessionalism( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
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
    
    public String showCommunication( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
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
    
    public String showKnowledge( int score, String group) throws SQLException {
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
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
    
    public String studentData( String group) throws SQLException{
        String form = "<table class=\"table table-striped table-bordered table-condensed\" width=\"647\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th></th>\n";
                   form += "<th colspan=\"6\">Development Need Indicator</th>";
                   form += "</tr>";
                   form += "<tr>\n";
                   form += "<th>Skill</th>\n";
                   form += "<td>1 (Total)</td>\n";
                   form += "<td>2 (Total)</td>\n";
                   form += "<td>3 (Total)</td>\n";
                   form += "<td>4 (Total)</td>\n";
                   form += "<td>5 (Total)</td>\n";
                   form += "<td>6 (Total)</td>\n";
                   form += "</tr>\n";
                   form += "</thead>\n";
                   form += "<tr>";
                   form += "<th>Ability To Establish Diagnosis</th>\n";
                   form += "<th>" + showAbilToEstDiag( 1, group ) + "</th>\n";
                   form += "<th>" + showAbilToEstDiag( 2, group  ) + "</th>\n";
                   form += "<th>" + showAbilToEstDiag( 3, group  ) + "</th>\n";
                   form += "<th>" + showAbilToEstDiag( 4, group  ) + "</th>\n";
                   form += "<th>" + showAbilToEstDiag( 5, group  ) + "</th>\n";
                   form += "<th>" + showAbilToEstDiag( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Ability To Formulate A Treatment Plan</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 1, group  ) + "</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 2, group  ) + "</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 3, group  ) + "</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 4, group  ) + "</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 5, group  ) + "</th>\n";
                   form += "<th>" + showAbilityToFormulateATreatmentPlan( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Ensuring Informed Consent</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 1, group  ) + "</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 2, group  ) + "</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 3, group  ) + "</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 4, group  ) + "</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 5, group  ) + "</th>\n";
                   form += "<th>" + showEnsuringInformedConsent( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Equipment Preparation Selection</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 1, group  ) + "</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 2, group  ) + "</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 3, group  ) + "</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 4, group  ) + "</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 5, group  ) + "</th>\n";
                   form += "<th>" + showEquipmentPreparationSelection( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Examination Intra Oral Hard Tissues</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 1, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 2, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 3, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 4, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 5, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralHardTissues( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Examination Intra Oral Soft Tissues</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 1, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 2, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 3, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 4, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 5, group  ) + "</th>\n";
                   form += "<th>" + showExaminationIntraOralSoftTissues( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Extra Oral Examination</th>\n";
                   form += "<th>" + showExtraOralExamination( 1, group  ) + "</th>\n";
                   form += "<th>" + showExtraOralExamination( 2, group  ) + "</th>\n";
                   form += "<th>" + showExtraOralExamination( 3, group  ) + "</th>\n";
                   form += "<th>" + showExtraOralExamination( 4, group  ) + "</th>\n";
                   form += "<th>" + showExtraOralExamination( 5, group  ) + "</th>\n";
                   form += "<th>" + showExtraOralExamination( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Infection Control</th>\n";
                   form += "<th>" + showInfectionControl( 1, group  ) + "</th>\n";
                   form += "<th>" + showInfectionControl( 2, group  ) + "</th>\n";
                   form += "<th>" + showInfectionControl( 3, group  ) + "</th>\n";
                   form += "<th>" + showInfectionControl( 4, group  ) + "</th>\n";
                   form += "<th>" + showInfectionControl( 5, group  ) + "</th>\n";
                   form += "<th>" + showInfectionControl( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Interpretation Of Special Investigations</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 1, group  ) + "</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 2, group  ) + "</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 3, group  ) + "</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 4, group  ) + "</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 5, group  ) + "</th>\n";
                   form += "<th>" + showInterpretationOfSpeciaInvestigations( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Local Anaesthesia Block</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 1, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 2, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 3, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 4, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 5, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaBlock( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Local Anaesthesia Infiltration</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 1, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 2, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 3, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 4, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 5, group  ) + "</th>\n";
                   form += "<th>" + showLocalAnaesthesiaInfiltration( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Management Of Complications</th>\n";
                   form += "<th>" + showManagementOfComplications( 1, group  ) + "</th>\n";
                   form += "<th>" + showManagementOfComplications( 2, group  ) + "</th>\n";
                   form += "<th>" + showManagementOfComplications( 3, group  ) + "</th>\n";
                   form += "<th>" + showManagementOfComplications( 4, group  ) + "</th>\n";
                   form += "<th>" + showManagementOfComplications( 5, group  ) + "</th>\n";
                   form += "<th>" + showManagementOfComplications( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Material Selection And Handling</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 1, group  ) + "</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 2, group  ) + "</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 3, group  ) + "</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 4, group  ) + "</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 5, group  ) + "</th>\n";
                   form += "<th>" + showMaterialSelectionAndHandling( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Appropriate Patient Position</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 1, group  ) + "</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 2, group  ) + "</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 3, group  ) + "</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 4, group  ) + "</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 5, group  ) + "</th>\n";
                   form += "<th>" + showAppropriatePatientPosition( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Appropriate Operator Position</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 1, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 2, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 3, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 4, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 5, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateOperatorPosition( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Appropriate Light Position</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 1, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 2, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 3, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 4, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 5, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateLightPosition( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Appropriate Use Of Mirror</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 1, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 2, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 3, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 4, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 5, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateUseOfMirror( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Appropriate Finger Support</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 1, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 2, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 3, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 4, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 5, group  ) + "</th>\n";
                   form += "<th>" + showAppropriateFingerSupport( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Professionalism</th>\n";
                   form += "<th>" + showProfessionalism( 1, group  ) + "</th>\n";
                   form += "<th>" + showProfessionalism( 2, group  ) + "</th>\n";
                   form += "<th>" + showProfessionalism( 3, group  ) + "</th>\n";
                   form += "<th>" + showProfessionalism( 4, group  ) + "</th>\n";
                   form += "<th>" + showProfessionalism( 5, group  ) + "</th>\n";
                   form += "<th>" + showProfessionalism( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Communication</th>\n";
                   form += "<th>" + showCommunication( 1, group  ) + "</th>\n";
                   form += "<th>" + showCommunication( 2, group  ) + "</th>\n";
                   form += "<th>" + showCommunication( 3, group  ) + "</th>\n";
                   form += "<th>" + showCommunication( 4, group  ) + "</th>\n";
                   form += "<th>" + showCommunication( 5, group  ) + "</th>\n";
                   form += "<th>" + showCommunication( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Knowledge</th>\n";
                   form += "<th>" + showKnowledge( 1, group  ) + "</th>\n";
                   form += "<th>" + showKnowledge( 2, group  ) + "</th>\n";
                   form += "<th>" + showKnowledge( 3, group  ) + "</th>\n";
                   form += "<th>" + showKnowledge( 4, group  ) + "</th>\n";
                   form += "<th>" + showKnowledge( 5, group  ) + "</th>\n";
                   form += "<th>" + showKnowledge( 6, group  ) + "</th>\n";
                   form += "</tr>\n";
                   form += "</tr>\n";
                   form += "</thead>\n";
                   form += "</tbody>\n";
                   form += "</table>\n";
                   
        return form;
    }
}
