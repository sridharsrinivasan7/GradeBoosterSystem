package Controllerclasses;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.CourseEnrolled;
import Model.OneStudentInfo;
import Model.Userinfo;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * 
 * @author sridh
 * professor views the students who are in the wait list and decides to add or drop them. 
 */
public class ProfWaitController implements Initializable {
	
	@FXML
	private Label L1;
	@FXML
	private TableView<CourseEnrolled> table1;
	@FXML
	private TableView<OneStudentInfo> table;
	@FXML
	private TableColumn<CourseEnrolled, String> col1;
	@FXML
	private TableColumn<CourseEnrolled, String> col2;
	@FXML
	private TableColumn<CourseEnrolled, String> col3;
	@FXML
	private TableColumn<CourseEnrolled, String> col11;
	@FXML
	private TableColumn<CourseEnrolled, String> col21;
	@FXML
	private TableColumn<CourseEnrolled, String> col31;
	@FXML
	private TableColumn<CourseEnrolled, String> col41;
	@FXML
	private TextField comments;
	
	//String comment = comments.getText();
	
	private ObservableList<CourseEnrolled> pass1 = null; 
	private ObservableList<CourseEnrolled> pass11 = null; 
	private ObservableList<OneStudentInfo> pass2 = null; 
	String cid;
	
	public void View() throws IOException, ClassNotFoundException, SQLException
	{
		col11.setCellValueFactory(new PropertyValueFactory<>("uid"));
		col21.setCellValueFactory(new PropertyValueFactory<>("uname"));
		col31.setCellValueFactory(new PropertyValueFactory<>("gpa"));
		col41.setCellValueFactory(new PropertyValueFactory<>("exp"));
		
		CourseEnrolled course = (CourseEnrolled)table1.getSelectionModel().getSelectedItem();
		String id = course.getUserid();
		cid = course.getCourseid();
		try
		{
		 pass2= DAOclass.Studentinfo(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table.setItems(null);
		table.setItems(pass2);
		L1.setText(comments.getText());

		//MainClass.ProfWaitList2();
	}
	public void Back(ActionEvent event) throws IOException
	{
		MainClass.ProfViews();
	}
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {

		col1.setCellValueFactory(new PropertyValueFactory<>("userid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("uname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		
		try
		{
		  pass1= DAOclass.Courseenrolled();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		table1.setItems(null);
		table1.setItems(pass1);
	}
	
	public void Approve() throws ClassNotFoundException, SQLException
	{
		OneStudentInfo stud1 = (OneStudentInfo)table.getSelectionModel().getSelectedItem();
		String response = DAOclass.ApproveReq(stud1,cid);
		L1.setText(response);
		Reloadtable();
	}
	
	public void Rejected() throws ClassNotFoundException, SQLException
	{
		String cmt = comments.getText();
		OneStudentInfo stud2 = (OneStudentInfo)table.getSelectionModel().getSelectedItem();
		String response = DAOclass.RejectionRes(stud2,cid,cmt);
		L1.setText(response);
		Reloadtable();
		
	}
	public void Reloadtable() {

		col1.setCellValueFactory(new PropertyValueFactory<>("userid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("uname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		
		try
		{
		  pass11= DAOclass.Courseenrolled();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		table1.setItems(null);
		table1.setItems(pass11);
	}
	
}
