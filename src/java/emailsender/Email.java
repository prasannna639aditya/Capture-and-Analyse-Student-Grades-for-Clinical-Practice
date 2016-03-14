/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailsender;

/**
 *
 * @author Delaney
 */
import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import dbpackage.DatabaseClass;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {   
    private Properties props;
    private String username;
    private String password;
    private final Session session;
    
    public Email( ) {
        this.username = "112445898@umail.ucc.ie";
        this.password = "IPNTclyv43";
        
        this.props = new Properties( );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", "587" );
        
        this.session = Session.getInstance( props, new javax.mail.Authenticator( ) {
            @Override
            protected PasswordAuthentication getPasswordAuthentication( ) {
                return new PasswordAuthentication( username, password);
            }
        });
    }
    
    public void sendEmailToNewRegUser( final String studentID, final String firstName, final String email ) {
        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( username ) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( email ) );
            message.setSubject( "Welcome to the Cork University Dental Hospital Grading Service" );
            message.setSentDate( new Date( ) );
            
            message.setContent( "<img alt='UCC Logo' title='Ucc Logo' style=\"width:60%; height:180px; margin-left:auto; margin-right:auto; display:block;\" src='data:image/jpeg;base64,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' />"
                              + "<h1>Welcome " + firstName + "</h1>"
                              + "<p>You have successfully registered to the <b>Cork University Dental Hospital Grading Service Application</b>.</p>"
                              + "<p>You can now login to the services web app using " + studentID + " as your Student ID and add view your practical progress.</p>"
                              + "<p><b>If you face any problems, please write to us on this email.</b></p>"
                              + "<p>We look forward to seeing you on the site!</p>" 
                              + "<p>The CUDH Team!</p><br />"
                              + "<p></p>", 
                             
                                "text/html; charset=utf-8" );
            Transport.send( message );
        } 
        catch( MessagingException exception ) {
            
        }
    }
    
    public boolean sendPasswordToUser( final String studentID, final String token) {        
        DatabaseClass database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
        
        String[] dbResult = database.SelectRow("SELECT * FROM Students WHERE StudentID = '" + studentID + "';" );
        
        if( dbResult.length == 0 ){
            return false;
        }
        
        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( username ) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( dbResult[5] ) );
            message.setSubject( "Forgot password" );
            message.setSentDate( new Date( ) );
            
            message.setContent( "<img alt='UCC Logo' title='Ucc Logo' style=\"width:60%; height:180px; margin-left:auto; margin-right:auto; display:block;\" src='data:image/jpeg;base64,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' />"
                              + "<h1>Did you forget your password?</h1>"
                              + "<h2>Hi " + dbResult[2] + "</h2>"
                              + "<p>It appears you've forgotten the username or password for your Cork University Dental Hospital Grading Service. "
                              + "We've provided a link to reset your password below.</p>"
                              + "<p>Username: " + dbResult[0] + "</p>" 
                              + "<p>Reset Link: <a href=\"http://localhost:8080/FinalYearProject/reset_password.jsp\">Click here to reset your password</a></p>"
                              + "<p>If you feel you've received this email in error, or if you have any further trouble logging in, ",
                    
                              "text/html; charset=utf-8" );
            Transport.send( message );
            //database.Close( );
        } 
        catch( MessagingException exception ) {
            return false;
        }
        
        return true;
    }
}
