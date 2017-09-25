package Controllerclasses;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.CourseEnrolled;
import Model.OneStudentInfo;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 
 * @author sridh
 * Here professor, views the registered student and updates the scores and comments for them
 */

public class ProfRegController implements Initializable
{
	@FXML
	private TableView<CourseEnrolled> tab1;
	@FXML
	private TableColumn<CourseEnrolled, String> col1;
	@FXML
	private TableColumn<CourseEnrolled, String> col2;
	@FXML
	private TableColumn<CourseEnrolled, String> col3;
	@FXML
	private TextField score;
	@FXML 
	private TextField cmts;
	
	private ObservableList<CourseEnrolled> ipass = null; 
	
	String marks;
	String comment;
	
	public void Back(ActionEvent event) throws IOException
	{
		MainClass.ProfViews();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		col1.setCellValueFactory(new PropertyValueFactory<>("userid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("uname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		
		try
		{
		  ipass= DAOclass.Registeredcandidates();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tab1.setItems(null);
		tab1.setItems(ipass);
	}
	public void submit() throws ClassNotFoundException, SQLException
	{
		marks=score.getText();
		comment=cmts.getText();
		CourseEnrolled ce =(CourseEnrolled)tab1.getSelectionModel().getSelectedItem();
		String res = DAOclass.ScoreSubmittion(ce, marks, comment);
	}
	
	
}
