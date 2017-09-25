package Controllerclasses;

import java.io.IOException;
import java.sql.SQLException;

import Model.StudentData;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * 
 * @author sridh
 * where new student enters all the information and decides to login 
 */
public class RegisterController {

	@FXML
	Label lb1;
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private PasswordField password;
	@FXML
	private TextField email;
	@FXML
	private TextField dept;
	@FXML
	private TextField age;
	@FXML
	private TextField gpa;
	@FXML
	private TextField exp;
	
	private int num;
	
	public void Registerstud(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		StudentData student = new StudentData();
		
		student.setStudentid(id.getText().toLowerCase());
		student.setSname(name.getText().toLowerCase());
		student.setPassword(password.getText().toLowerCase());
		student.setEmail(email.getText().toLowerCase());
		student.setDept(dept.getText().toLowerCase());
		num = Integer.parseInt(age.getText());
		student.setAge(num);
		student.setGpa(gpa.getText());
		student.setExp(exp.getText());
		String res = DAOclass.InsertStudinfo(student); 
		lb1.setText(res);	
	}
	public void BacktoP1(ActionEvent event) throws IOException
	{
		MainClass.Login();
	}
}
