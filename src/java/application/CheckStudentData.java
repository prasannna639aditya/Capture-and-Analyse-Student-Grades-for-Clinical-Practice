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
public class CheckStudentData {
    private String [] result;
    
    public CheckStudentData(){
        this.result = new String[10];
    }
    
    public String showCore( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AbilityToEstablishDiagnosis = 1) AS AbilToEstDiagCount,"
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
                + "FROM TBICoreSkills;" );
                //+ "FROM TBICoreSkills WHERE StudentID = 112445898 AND DateAdded LIKE '%2015%';" );
        
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
               form += "<h1>Core Skills Generic ount total " + countTotal + "</h1>\n";
               form += "</div>\n";
        }
        
        return form;
    }
    
    public String showBasic( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AppropriatePatientPosition = 1) AS AppropriatePatientPositionCount,"
                + "SUM(AppropriateOperatorPosition = " + score + " ) AS AppropriateOperatorPositionCount, "
                + "SUM(AppropriateLightPosition = " + score + " ) AS AppropriateLightPositionCount, "
                + "SUM(AppropriateUseOfMirror = " + score + " ) AS AppropriateUseOfMirrorCount, "
                + "SUM(AppropriateFingerSupport = " + score + " ) AS AppropriateFingerSupportCount " 
                + "FROM TBICoreSkills;" );
        
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
               form += "<h1>Basic Operative Skills count total " + countTotal + "</h1>\n";
               form += "</div>\n";
        }
        
        return form;
    }
    
    
    public String showProfessionalism( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Punctuality = 1) AS PunctualityCount,"
                + "SUM(ProfessionalApproach = " + score + " ) AS ProfessionalApproachCount, "
                + "SUM(SelfAwareness = " + score + " ) AS SelfAwarenessCount, "
                + "SUM(StudentInsight = " + score + " ) AS StudentInsightCount "
                + "FROM TBICoreSkills;" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int PunctualityInt = Integer.parseInt(rs.getString("PunctualityCount"));
               int ProfessionalApproachInt = Integer.parseInt(rs.getString("ProfessionalApproachCount"));
               int SelfAwarenessInt = Integer.parseInt(rs.getString("SelfAwarenessCount"));
               int StudentInsightInt = Integer.parseInt(rs.getString("StudentInsightCount"));
               
               countTotal = PunctualityInt + ProfessionalApproachInt + SelfAwarenessInt + StudentInsightInt;
               form += "<h1>Professionalism count total " + countTotal + "</h1>\n";
               form += "</div>\n";
        }
        
        return form;
    }
    
    public String showCommunication( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AbilityToEstablishPatientHistory = 1) AS AbilityToEstablishPatientHistoryCount,"
                + "SUM(AbilityToObtainInformedConsent = " + score + " ) AS AbilityToObtainInformedConsentCount, "
                + "SUM(AbilityToRequestSpecialInvestigations = " + score + " ) AS AbilityToRequestSpecialInvestigationsCount, "
                + "SUM(AbilityToWritePerscription = " + score + " ) AS AbilityToWritePerscriptionCount, "
                + "SUM(CommunicationWithDentalTeam = " + score + " ) AS CommunicationWithDentalTeamCount, "
                + "SUM(CommunicationWithPatientAndFamily = " + score + " ) AS CommunicationWithPatientAndFamilyCount, "
                + "SUM(CommunicationWithTutor = " + score + " ) AS CommunicationWithTutorCount, "
                + "SUM(OutlineOfReferalLetter = " + score + " ) AS OutlineOfReferalLetterCount, "
                + "SUM(PatientRecordKeeping = " + score + " ) AS PatientRecordKeepingCount, "
                + "SUM(Charting = " + score + " ) AS ChartingCount, "
                + "SUM(PresentationOfCase = " + score + " ) AS PresentationOfCaseCount "
                + "FROM TBICoreSkills;" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int AbilityToEstablishPatientHistoryInt = Integer.parseInt(rs.getString("AbilityToEstablishPatientHistoryCount"));
               int AbilityToObtainInformedConsentInt = Integer.parseInt(rs.getString("AbilityToObtainInformedConsentCount"));
               int AbilityToRequestSpecialInvestigationsInt = Integer.parseInt(rs.getString("AbilityToRequestSpecialInvestigationsCount"));
               int AbilityToWritePerscriptionInt = Integer.parseInt(rs.getString("AbilityToWritePerscriptionCount"));
               int CommunicationWithDentalTeamInt = Integer.parseInt(rs.getString("CommunicationWithDentalTeamCount"));
               int CommunicationWithPatientAndFamilyInt = Integer.parseInt(rs.getString("CommunicationWithPatientAndFamilyCount"));
               int CommunicationWithTutorInt = Integer.parseInt(rs.getString("CommunicationWithTutorCount"));
               int OutlineOfReferalLetterInt = Integer.parseInt(rs.getString("OutlineOfReferalLetterCount"));
               int PatientRecordKeepingInt = Integer.parseInt(rs.getString("PatientRecordKeepingCount"));
               int ChartingInt = Integer.parseInt(rs.getString("ChartingCount"));
               int PresentationOfCaseInt = Integer.parseInt(rs.getString("PresentationOfCaseCount"));
               
               countTotal = AbilityToEstablishPatientHistoryInt + AbilityToObtainInformedConsentInt + AbilityToRequestSpecialInvestigationsInt +  AbilityToWritePerscriptionInt + CommunicationWithDentalTeamInt + CommunicationWithPatientAndFamilyInt + CommunicationWithTutorInt + OutlineOfReferalLetterInt + PatientRecordKeepingInt + ChartingInt + PresentationOfCaseInt;
               form += "<h1>Communication count total " + countTotal + "</h1>\n";
               form += "</div>\n";
        }
        
        return form;
    }
    
    public String showKnowledge( int score ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AbilityToUnderstandMedicalHistory = 1) AS AbilityToUnderstandMedicalHistoryCount,"
                + "SUM(BackgroundKnowledgeForSessionProcedure = " + score + " ) AS BackgroundKnowledgeForSessionProcedureCount, "
                + "SUM(JustificationForAndKnowledgeOfAppropriateSpecialInvestigations = " + score + " ) AS JustForKnowledgeOfApprSpecInvestCount "
                + "FROM TBICoreSkills;" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int countTotal = 0;
        
        
        String form = "<div>\n";
        while(rs.next()){
             
               int AbilityToUnderstandMedicalHistoryInt = Integer.parseInt(rs.getString("AbilityToUnderstandMedicalHistoryCount"));
               int BackgroundKnowledgeForSessionProcedureInt = Integer.parseInt(rs.getString("BackgroundKnowledgeForSessionProcedureCount"));
               int JustForKnowledgeOfApprSpecInvestInt = Integer.parseInt(rs.getString("JustForKnowledgeOfApprSpecInvestCount"));
               
               countTotal = AbilityToUnderstandMedicalHistoryInt + BackgroundKnowledgeForSessionProcedureInt + JustForKnowledgeOfApprSpecInvestInt;
               form += "<h1>Knowledge count total " + countTotal + "</h1>\n";
               form += "</div>\n";
        }
        
        return form;
    }
    
}
