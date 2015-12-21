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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/timetable_scheduler_db","root","");
            //System.out.println("successful");
            String query = ("SELECT * FROM users");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("User ID:"+rs.getString("user_id"));
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    
}
