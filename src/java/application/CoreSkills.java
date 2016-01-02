/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.Date;
import dbpackage.DatabaseClass;
import emailsender.Email;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

/**
 *
 * @author Delaney
 */
public class CoreSkills {
    private String studentID;
    private String patientID;
    private String tutorID;
    private String abilToEstDiag;
    private String abilToFormTrtPlan;
    private String ensInfCons;
    private String equipPrep;
    private String examIntraOralHard;
    private String examIntraOralSoft;
    private String extraOralExam;
    private String infectionControl;
    private String interpOfSpecInves;
    private String localAnaesthesia;
    private String matSelecHandling;
    private String approPatPos;
    private String approOpPos;
    private String approLightPos;
    private String approUseOfMirror;
    private String approFingerSupport;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public CoreSkills( ){
        studentID = "";
        patientID = "";
        tutorID = "";
        abilToEstDiag = "";
        abilToFormTrtPlan = "";
        ensInfCons = "";
        equipPrep = "";
        examIntraOralHard = "";
        examIntraOralSoft = "";
        extraOralExam = "";
        infectionControl = "";
        interpOfSpecInves = "";
        localAnaesthesia = "";
        errors = new ArrayList<>( );
        matSelecHandling = "";
        approPatPos = "";
        approOpPos = "";
        approLightPos = "";
        approUseOfMirror = "";
        approFingerSupport = "";
        database = new DatabaseClass( );
        database.setup( "localhost", "final_year_project", "root", "" );
    }
    
    public String getStudentID( ) {
        return studentID;
    }

        
    public void setStudentID( final String studentID ) {
        this.studentID = studentID;
    }

    public String getPatientID( ) {
        return patientID;
    }

    public void setPatientID( final String patientID ) {
        this.patientID = patientID;
    }
    
    public String getTutorID( ) {
        return tutorID;
    }

    public void setTutorID( final String tutorID ) {
        this.tutorID = tutorID;
    }
    
    public String getAbilToEstDiag( ) {
        return abilToEstDiag;
    }

        
    public void setAbilToEstDiag( final String abilToEstDiag ) {
        this.abilToEstDiag = abilToEstDiag;
    }
    
       public String getAbilToFormTrtPlan( ) {
        return abilToFormTrtPlan;
    }

        
    public void setAbilToFormTrtPlan( final String abilToFormTrtPlan ) {
        this.abilToFormTrtPlan = abilToFormTrtPlan;
    } 

    public String getEnsInfCons( ) {
        return ensInfCons;
    }

        
    public void setEnsInfCons( final String ensInfCons ) {
        this.ensInfCons = ensInfCons;
    }  
    
    public String getEquipPrep( ) {
        return equipPrep;
    }

        
    public void setEquipPrep( final String equipPrep ) {
        this.equipPrep = equipPrep;
    }
    
    public String getExamIntraOralHard( ) {
        return examIntraOralHard;
    }

        
    public void setExamIntraOralHard( final String examIntraOralHard ) {
        this.examIntraOralHard = examIntraOralHard;
    }
    
    public String getExamIntraOralSoft( ) {
        return examIntraOralSoft;
    }

        
    public void setExamIntraOralSoft( final String examIntraOralSoft ) {
        this.examIntraOralSoft = examIntraOralSoft;
    }
    
    public String getExtraOralExam( ) {
        return extraOralExam;
    }

        
    public void setExtraOralExam( final String extraOralExam ) {
        this.extraOralExam = extraOralExam;
    }
}
