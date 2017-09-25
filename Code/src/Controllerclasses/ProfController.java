package Controllerclasses;

import java.io.IOException;

import application.MainClass;
import javafx.event.ActionEvent;

/**
 * 
 * @author sridh
 * professor selects the tab to proceed further
 */
public class ProfController {

	public void Logout(ActionEvent event) throws IOException
	{
		MainClass.Login();
	}
	public void Registered(ActionEvent event) throws IOException
	{
		MainClass.test();
	}
	public void Waitlisted(ActionEvent event) throws IOException
	{
		MainClass.ProfWaitList();
	}
}
