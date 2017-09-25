package Controllerclasses;

import java.io.IOException;
import java.sql.SQLException;

import Model.Admin;
import Model.Professor;
import Model.Student;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * @author sridh
 * Login controller class used to check the type users with the radiobutton and hit the mysql database to validate the userid and password
 */


public class LoginController {

	@FXML
	ToggleGroup group = new ToggleGroup();
	@FXML
	RadioButton radmin = new RadioButton("ADMIN");
	@FXML
	RadioButton rprofessor = new RadioButton("PROFESSOR");
	@FXML
	RadioButton rstudent = new RadioButton("STUDENT");
	@FXML
	Label rwarning;
	@FXML
	private TextField UID;
	@FXML
	private PasswordField PWD;
	
	//Admin Data
	public static String userid;
	public static String pass;
	public static String type;
	
	public void Register(ActionEvent event) throws IOException
	{
		MainClass.NewStudent();
	}
	
	public void LoginMethod(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		
		rprofessor.setToggleGroup(group);
		rstudent.setToggleGroup(group);
		radmin.setToggleGroup(group);

		//Gathering info from the FX fields
		String DBuserid= UID.getText();
		
		DBuserid = DBuserid.toLowerCase();
		
		String DBpassword = PWD.getText();
		
		if(group.getSelectedToggle()!=null)
		{
			if(group.getSelectedToggle()==radmin)
			{
				try {
					 
					 Admin admin = DAOclass.AuthAdmin(DBuserid);
			 
					 userid = admin.getUID();
					 pass = admin.getPassword();
					 
					if(DBuserid.equals(userid) && DBpassword.equals(pass))
					{
						rwarning.setText("Login Success for "+userid);
						MainClass.AdminViews();
					}
					else 
					{
						rwarning.setText("USERID/PASSWORD INCORRECT");
					}
						
				} catch (Exception e) {

					e.printStackTrace();
				}
				//MainClass.AdminViews();
				//rwarning.setText("Admin selected");
			 }
			else if(group.getSelectedToggle()==rprofessor)
			{
				try {
					 
					 Professor Prof = DAOclass.AuthProf(DBuserid);
			 
					 userid = Prof.getUID();
					 pass = Prof.getPassword();
					 
					if(DBuserid.equals(userid) && DBpassword.equals(pass))
					{
						rwarning.setText("Login Success for "+userid);
						MainClass.ProfViews();
					}
					else 
					{
						rwarning.setText("USERID/PASSWORD INCORRECT");
					}
						
				} catch (Exception e) {

					e.printStackTrace();
				}
				//MainClass.ProfViews();
			}
				//MainClass.ProfViews();
			else if(group.getSelectedToggle()==rstudent)
			{
				try {
					 
					 Student stud = DAOclass.AuthStud(DBuserid);
			 
					 userid = stud.getUID();
					 pass = stud.getPassword();
					 
					if(DBuserid.equals(userid) && DBpassword.equals(pass))
					{
						rwarning.setText("Login Success for "+userid);
						MainClass.StudentView();
					}
					else 
					{
						rwarning.setText("USERID/PASSWORD INCORRECT");
					}
						
				} catch (Exception e) {

					e.printStackTrace();
				}
				//MainClass.StudentView();
				//rwarning.setText("Student selected");
			}
		}
		else
		{
			rwarning.setText("Please select the User type of Login:");
		}
		
	}
	public void Exit(ActionEvent event) 
	{
		System.out.println("Byeeeee Guys");
		System.exit(0);
	}
}
