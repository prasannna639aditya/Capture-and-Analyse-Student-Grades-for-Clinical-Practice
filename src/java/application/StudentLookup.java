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
    
    public String fetchNames() throws SQLException{
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            //System.out.println("successful");
            String query = ("SELECT Students.StudentID, Students.FirstName, Students.LastName, Students.Picture, CourseYear.ProgrammeYear, StudentGroups.GroupDescriptor"
                            + " FROM Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            
            
            String form = "<div class=\"table-responsive\">\n";
                   form += "<table class=\"table\">\n";
                   form += "<thead>\n";
                   form += "<tr>\n";
                   form += "<th>Student ID</th>\n";
                   form += "<th>First Name</th>\n";
                   form += "<th>Surname</th>\n";
                   form += "<th>Picture</th>\n";
                   form += "<th>Programme Year</th>\n";
                   form += "<th>Course Year</th>\n";
                   form += "</tr>\n";
                   form += "<tbody>\n";
                   form += "<tr>\n";
                   
            while(rs.next()){
                form += "<tr>\n";
                form += "<td>" + rs.getString("Students.StudentID") + "</td>\n";
                form += "<td>" + rs.getString("Students.FirstName") + "</td>\n";
                form += "<td>" + rs.getString("Students.LastName") + "</td>\n";
                form += "<td><img src=\"" + rs.getString("Students.Picture") + "\"</td>\n";
                form += "<td>" + rs.getString("CourseYear.ProgrammeYear") + "</td>\n";
                form += "<td>" + rs.getString("StudentGroups.GroupDescriptor") + "</td>\n";
                form += "</tr>\n";
            }
            
            form += "</tbody>\n";
            form += "</table>\n";
            form += "</div>\n";
            
        conn.close();
        return form;
    }
    

}
