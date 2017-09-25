package Controllerclasses;

import java.io.IOException;

import application.MainClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 
 * @author sridh
 * 
 */
public class RegisteredViewController {
	
	@FXML
	Label L1;

	public void Submit(ActionEvent event) throws IOException
	{
		L1.setText("Success!!!!");
	}
	public void Back(ActionEvent event) throws IOException
	{
		MainClass.test();

	}
}
