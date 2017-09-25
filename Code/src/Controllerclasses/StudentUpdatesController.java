package Controllerclasses;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Course;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
/**
 * 
 * @author sridh
 * Student updates, where a student could view the updated from the professor regarding the course registration, score and other stuffs
 */

public class StudentUpdatesController implements Initializable {

	@FXML
	Label lb1;
	@FXML
	Label lb2;
	@FXML
	Label lb3;
	@FXML
	Label lb4;
	
	private static ObservableList<Course> d6;
	
	public void Back(ActionEvent event) throws IOException
	{
		MainClass.StudentView();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try 
		{
			Course course1= DAOclass.CourseUpdates();
			Course course2= DAOclass.FailureNotification();
			Course course3 = DAOclass.ScoreandSuggesstions();

			//lb1.setText(course1.getCourseid());
			lb1.setText(course2.getCourseid());
			lb2.setText(course2.getCmts());
			lb1.setText(course3.getCourseid());
			lb3.setText(course3.getMarks());
			lb4.setText(course3.getCmts());
			
			lb1.setText(course1.getCourseid());
		  		
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
