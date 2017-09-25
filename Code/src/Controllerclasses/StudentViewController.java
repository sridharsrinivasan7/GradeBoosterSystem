package Controllerclasses;

import java.io.IOException;

import application.MainClass;
import javafx.event.ActionEvent;

public class StudentViewController {

	public void signout(ActionEvent event) throws IOException
	{
		MainClass.Login();
	}
	public void Updates(ActionEvent event) throws IOException
	{
		MainClass.StudentUpdates();
	}
	public void AddDrop(ActionEvent event) throws IOException
	{
		MainClass.AddDropCourses();
	}
}
