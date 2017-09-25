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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfWaitController2 implements Initializable 

{
	
	@FXML
	Label L1;
	@FXML
	private static TableView<OneStudentInfo> table;
	@FXML
	private TableColumn<OneStudentInfo, String> col1;
	@FXML
	private TableColumn<OneStudentInfo, String> col2;
	@FXML 
	private TableColumn<OneStudentInfo, String> col3;
	@FXML
	private TableColumn<OneStudentInfo, String> col4;
	
	private static ObservableList<OneStudentInfo> passby = null; 

	
	public void Back(ActionEvent event) throws IOException
	{
		MainClass.ProfWaitList();
	}
	public void Approve(ActionEvent event) throws IOException
	{
		L1.setText("Notification sent to the Student regarding the Approval");
	}
	public void Reject(ActionEvent event) throws IOException
	{
		L1.setText("Notification sent to the Student regarding the Rejection");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		col1.setCellValueFactory(new PropertyValueFactory<>("userid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("uname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("gpa"));
		col4.setCellValueFactory(new PropertyValueFactory<>("exp"));
		
		
	}
/*	public static void reload(CourseEnrolled obj) throws ClassNotFoundException, SQLException
	{
		String uid = obj.getUserid();
		passby = DAOclass.Studentinfo(uid);
		table.setItems(null);
		table.setItems(passby);
	}*/
}
