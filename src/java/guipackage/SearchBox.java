package guipackage;


import application.StudentLookup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import summaryData.StudentSummaryData;
import dbpackage.DatabaseClass;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Delaney
 */
public class SearchBox {
    private String [] result;
    private String studentID;
    private String groupID;
    private String name;
    private String group;
    private String groupDescriptor;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public SearchBox(){
        this.result = new String[10];
        errors = new ArrayList<>( );
        this.studentID = "";
        this.name = "";
        this.groupDescriptor = "";
        database = new DatabaseClass( );
        group = "";
        
        this.result = new String[10];
        database.setup( "localhost", "final_year_project", "root", "" );
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name= name;
    }
    
    
    public String getGroupID() {
        return groupID;
    }
    
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String printErrors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    
    public String showCore( int score, String studentID) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
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
                + "FROM TBICoreSkills WHERE StudentID= " + studentID + ";" );
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
               //form += "<h1>Core Skills Generic ount total " + countTotal + "</h1>\n";
               form += countTotal;
               form += "</div>\n";
        }
        
        return form;
    }
    
    public String showBasic( int score, String studentID ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(AppropriatePatientPosition = " + score + ") AS AppropriatePatientPositionCount,"
                + "SUM(AppropriateOperatorPosition = " + score + " ) AS AppropriateOperatorPositionCount, "
                + "SUM(AppropriateLightPosition = " + score + " ) AS AppropriateLightPositionCount, "
                + "SUM(AppropriateUseOfMirror = " + score + " ) AS AppropriateUseOfMirrorCount, "
                + "SUM(AppropriateFingerSupport = " + score + " ) AS AppropriateFingerSupportCount " 
                + "FROM TBICoreSkills WHERE StudentID= " + studentID + ";" );
        
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
        
        return form;
    }
    
    
    public String showProfessionalism( int score, String studentID ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Professionalism = " + score + ") AS ProfessionalismCount "
                + "FROM TBICoreSkills WHERE StudentID= " + studentID + ";" );
        
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
        
        return form;
    } 
    
    public String showCommunication( int score, String studentID ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Communication = " + score + ") AS CommunicationCount "
                + "FROM TBICoreSkills WHERE StudentID= " + studentID + ";" );
        
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
        
        return form;
    }
    
    public String showKnowledge( int score, String studentID ) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT SUM(Knowledge= " + score + ") AS KnowledgeCount "
                + "FROM TBICoreSkills WHERE StudentID= " + studentID + ";" );
        
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
        
        return form;
    }
    
    public String studentData( String studentID) throws SQLException{
        SearchBox check = new SearchBox();
        
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
                   form += "<th>" + check.showCore(1, studentID) + "</th>\n";
                   form += "<th>" + check.showCore(2, studentID) + "</th>\n";
                   form += "<th>" + check.showCore(3, studentID) + "</th>\n";
                   form += "<th>" + check.showCore(4, studentID) + "</th>\n";
                   form += "<th>" + check.showCore(5, studentID) + "</th>\n";
                   form += "<th>" + check.showCore(6, studentID) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Basic Operative Skills</th>\n";
                   form += "<th>" + check.showBasic(1, studentID) + "</th>\n";
                   form += "<th>" + check.showBasic(2, studentID) + "</th>\n";
                   form += "<th>" + check.showBasic(3, studentID) + "</th>\n";
                   form += "<th>" + check.showBasic(4, studentID) + "</th>\n";
                   form += "<th>" + check.showBasic(5, studentID) + "</th>\n";
                   form += "<th>" + check.showBasic(6, studentID) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Professionalism</th>\n";
                   form += "<th>" + check.showProfessionalism(1, studentID) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(2, studentID) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(3, studentID) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(4, studentID) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(5, studentID) + "</th>\n";
                   form += "<th>" + check.showProfessionalism(6, studentID) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Communication</th>\n";
                   form += "<th>" + check.showCommunication(1, studentID) + "</th>\n";
                   form += "<th>" + check.showCommunication(2, studentID) + "</th>\n";
                   form += "<th>" + check.showCommunication(3, studentID) + "</th>\n";
                   form += "<th>" + check.showCommunication(4, studentID) + "</th>\n";
                   form += "<th>" + check.showCommunication(5, studentID) + "</th>\n";
                   form += "<th>" + check.showCommunication(6, studentID) + "</th>\n";
                   form += "</tr>\n";
                   form += "<tr>";
                   form += "<th>Knowledge</th>\n";
                   form += "<th>" + check.showKnowledge(1, studentID) + "</th>\n";
                   form += "<th>" + check.showKnowledge(2, studentID) + "</th>\n";
                   form += "<th>" + check.showKnowledge(3, studentID) + "</th>\n";
                   form += "<th>" + check.showKnowledge(4, studentID) + "</th>\n";
                   form += "<th>" + check.showKnowledge(5, studentID) + "</th>\n";
                   form += "<th>" + check.showKnowledge(6, studentID) + "</th>\n";
                   form += "</tr>\n";
                   form += "</tr>\n";
                   form += "</table>\n";
                   
        return form;
    }
    
    
    
    
    public String searchBox(){
        String form = "<div class=\"panel-body\">" +
                       "<form name='marking_form' class=\"navbar-form\" role=\"search\" action='studentSearch.jsp' method='POST'>\n" +  
                       "<div class=\"form-group\">\n";
               form += "<input type=\"text\" name='studentID' class=\"form-control\" placeholder=\"Search student ID\">\n" +
                       "</select><br />" +
                       "</div>" +
                       "<button type=\"submit\" class=\"btn btn-default \"><span class=\"glyphicon glyphicon-circle-arrow-right\"></span></button><br />" +
                       "</form>" +
                       "</div>";
        
        return form;
    }
    
    public String groupSearchBox(){
        
        String form = "<form id='form-id' name='group_search' action='groupSearchResults.jsp' method='POST'>" +
                "<div class=\"container\">\n" +
                "	<div class=\"row\">\n" +
                "        <div class=\"col-md-6\">\n" +
                "            <div id=\"custom-search-input\">\n" +
                "                <div class=\"input-group col-md-12\">\n" +
                "                   <input type=\"text\"class=\"form-control input-lg\" name='groupID' placeholder=\"Search a group...\">\n" +
                "                    <span class=\"input-group-btn\">\n" +
                "                        <button class=\"btn btn-info btn-lg\" type=\"button\">\n" +
                "                            <i class=\"glyphicon glyphicon-search\"></i>\n" +
                "                        </button>\n" +
                "                    </span>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "	</div>\n" +
                "</div>" +
                "</form>\n";
                
        return form;
    }
    
    public String addStudents( String groupId){
        
        String form = "<form id='form-id' name='add_student' action='grade.jsp' method='POST'>" +
                "      <div class=\"ui action left icon input\">\n" +
                "      <i class=\"search icon\"></i>\n" +
                "      <input type=\"hidden\" name='groupID' value='" + groupID + "' placeholder=\"Search...\">\n" +
                "      <input type=\"text\" name='studentID' placeholder=\"Add an extra student to the group\"><br/>\n" +
                "      <div><input type=\"text\" name='name' placeholder=\"Please name this group\"></div><br/>\n" +
                "      <input type='submit' value='Add' name='submit' /><br />\n" +
                "    </div></form>\n";
        return form;
    }
    
    public void addToExtras( String tutorID, String groupId, String studentID){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        database.Insert( "INSERT INTO GroupExtras( TutorID, GroupDescriptor, StudentID, DateAdded, Time, GroupName)" +
                         "VALUES( '" + tutorID + "','" + groupId + "','" + studentID + "','" + date + "','" + time + "','" + name + "' );" );
        database.Close();
    }
    
    public boolean checkStudentID( String studentID ){
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "ec2-52-48-85-26.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        result = database.SelectRow( "SELECT * FROM Students WHERE StudentID = '" + studentID + "';" );
        Boolean isStudent = false;
        
        if( result.length != 0 ) {
          isStudent = true;  
        }
        
      return isStudent;  
    }
    
    public boolean doesGroupExist(String groupName) {
        String[] dbResult = database.SelectRow( "SELECT GroupName FROM GroupExtras WHERE GroupName = '" + groupName + "';" );
        
        if(dbResult.length != 0) {
            return true;
        }
        return false;
    }
    
    public boolean checkGroupDescriptor( String descriptor){
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "ec2-52-48-85-26.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        result = database.SelectRow( "SELECT * FROM StudentGroups WHERE GroupDescriptor = '" + descriptor + "';" );
        Boolean isDescriptor = false;
        
        if( result.length != 0 ) {
          isDescriptor = true;  
        }
        
      return isDescriptor;
    }
    
    public boolean checkGroup( String studentID, String groupID ){
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "ec2-52-48-85-26.eu-west-1.compute.amazonaws.com", "final_year_project", "root", "IPNTclyv43" );
        database.setup( "localhost", "final_year_project", "root", "" );
        result = database.SelectRow("SELECT Students.StudentID, Students.FirstName, Students.LastName, Students.Picture, CourseYear.ProgrammeYear, StudentGroups.GroupDescriptor"
                            + " FROM Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE Students.StudentID =" + studentID + " AND StudentGroups.GroupDescriptor=" + groupID + ";" );
        Boolean isInGroup = false;
        
        if( result.length != 0 ) {
          isInGroup = true;  
        }
        
      return isInGroup;  
    }
    
    public String showTutorsGroups(String tutorID) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT * FROM GroupExtras "
                + "WHERE TutorID= " + tutorID + ";" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String form = "<h1>My Groups</h1>\n";
               form += "<div class=\"table-responsive\">\n";
               form += "<table class=\"table table-hover\">\n";
               form += "<thead>\n";
               form += "<tbody>\n";
        if(rs.next()){
          while(rs.next()){ 
               form += "<tr>\n";
               form += "<form name='grade' action='student-years/showGroups.jsp' method='POST'>";
               form += "<input type=\"hidden\" name='groupID' value='" + rs.getString("GroupDescriptor") + "'>\n";
               form += "<input type=\"hidden\" name='studentID' value='" + rs.getString("StudentID") + "'>\n";
               form += "<td>" + rs.getString("GroupName") + "</td>\n";
               form += "<td>" + rs.getString("DateAdded") + "</td>\n";
               form += "<td><input type=\"submit\" value=\"Go to group\" class=\"btn-style\"></td></form>\n";
               form += "<form name='grade' action='student-years/deleteGroup.jsp' method='POST'>";
               form += "<input type=\"hidden\" name='group' value='" + rs.getString("GroupName") + "'>\n";
               form += "<td class='delete'><input type=\"submit\" value=\"Delete Group\" class=\"btn-style\"></td></form>\n";
               form += "</tr>\n";
          }
        }
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>";
        return form;
    }
    
    public void deleteGroup( String groupName, String tutorID){
        database.Insert( "DELETE FROM GroupExtras WHERE GroupName = '" + groupName + "' AND TutorID = " + tutorID + ";" );
        database.Close();
    }
    public String selectTodaysGroup( String groupName ) throws SQLException{
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
        
        String query =( "SELECT * FROM GroupExtras WHERE GroupExtras.GroupName= " + groupName + ";" );
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        
        
        String form = "<div>\n";
        while(rs.next()){
        
        SearchBox search = new SearchBox();
        StudentLookup look = new StudentLookup();
       
        
           form += look.fetchGroupNames(rs.getString("GroupDescriptor"));
           //form += look.fetchExtraStudent(search.getStudentID());
        
        }
        form += "</div>\n";      
       
        return form;  
    }
    
    
    
    
    
    
}
