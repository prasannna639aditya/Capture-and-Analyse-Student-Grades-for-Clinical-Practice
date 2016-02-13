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
public class StudentLookup {
    private String firstName;
    private String lastName;
    private String studentID;
    private String email;
    private String [] result;
    
    public StudentLookup(){
        this.email = "";
        this.studentID = "";
        this.firstName = "";
        this.lastName = "";
        this.result = new String[10];
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    
    public String fetchNames() throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT Students.StudentID, Students.FirstName, Students.LastName, Students.Picture, CourseYear.ProgrammeYear, StudentGroups.GroupDescriptor"
                            + " FROM Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Picture</th>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "<th>Programme Year</th>\n";
                   form += "<th>Course Year</th>\n";
                   form += "<th>View Treatment Items</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
               
            while(rs.next()){
                form += "<tr>\n";
                form += "<td><img id='studnetID' src=\"../img/" + rs.getString("Students.Picture") + "\"</td>\n";
                form += "<td><form name='treatments' action='../treatmentItems.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("Students.StudentID") + "\" selected>" + rs.getString("Students.StudentID") + "</option>"
                        + "</select><br /></td>\n";
                form += "<td>" + rs.getString("Students.FirstName") + "</td>\n";
                form += "<td>" + rs.getString("Students.LastName") + "</td>\n";
                form += "<td>" + rs.getString("CourseYear.ProgrammeYear") + "</td>\n";
                form += "<td>" + rs.getString("StudentGroups.GroupDescriptor") + "</td>\n";
                form += "<td><input type=\"submit\" value=\"View Treatments\" class=\"btn-style\"></form></td>";
                form += "</tr>\n";
            }
            
            
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    
    public String fetchYearNames(String year) throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT Students.StudentID, Students.FirstName, Students.LastName, Students.Picture, CourseYear.ProgrammeYear, StudentGroups.GroupDescriptor"
                            + " FROM Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID"
                            + " WHERE CourseYear.YearID =" + year + ";" );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Picture</th>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "<th>Programme Year</th>\n";
                   form += "<th>Course Year</th>\n";
                   form += "<th>View Treatment Items</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
               
            while(rs.next()){
                form += "<tr>\n";
                form += "<td><img id='studnetID' src=\"../img/" + rs.getString("Students.Picture") + "\"</td>\n";
                form += "<td><form name='treatments' action='../treatmentItems.jsp' method='POST'>"
                        + "<select name=\"studentID\" id='dropdown'>"
                        + "<option value=\"" + rs.getString("Students.StudentID") + "\" selected>" + rs.getString("Students.StudentID") + "</option>"
                        + "</select><br /></td>\n";
                form += "<td>" + rs.getString("Students.FirstName") + "</td>\n";
                form += "<td>" + rs.getString("Students.LastName") + "</td>\n";
                form += "<td>" + rs.getString("CourseYear.ProgrammeYear") + "</td>\n";
                form += "<td>" + rs.getString("StudentGroups.GroupDescriptor") + "</td>\n";
                form += "<td><input type=\"submit\" value=\"View Treatments\" class=\"btn-style\"></form></td>";
                form += "</tr>\n";
            }
            
            
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    

}
