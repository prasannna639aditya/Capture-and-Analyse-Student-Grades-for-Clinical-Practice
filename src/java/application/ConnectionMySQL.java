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
import java.sql.Statement;




/**
 *
 * @author Delaney
 */
public class ConnectionMySQL {
    public static void main(String args[]){
        try{
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/final_year_project","root","");
            Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-52-31-7-122.eu-west-1.compute.amazonaws.com/final_year_project","root","IPNTclyv43");
            //System.out.println("successful");
            String query = ("SELECT Students.StudentID, Students.FirstName, Students.LastName, Students.Picture, CourseYear.ProgrammeYear, StudentGroups.GroupDescriptor"
                            + " FROM Students JOIN StudentGroups JOIN StudentClass JOIN CourseYear"
                            + " ON Students.StudentID = StudentClass.StudentID AND StudentClass.GroupID = StudentGroups.GroupID AND StudentClass.YearID = CourseYear.YearID");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("User ID:"+rs.getString("FirstName"));
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    
}
