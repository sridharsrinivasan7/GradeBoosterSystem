package Controllerclasses;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Course;
import Model.Course_Prof;
import Model.Userinfo;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 
 * @author sridh
 * Add/drop class where a student selects from the drop down and adds it to the cart and later finialised it or drops it  
 */
public class AdDropController implements Initializable {
	
	private static ObservableList<Course> option;
	private ObservableList<Course_Prof> val; 
	private ObservableList<Course_Prof> val1; 

	
	private static ObservableList<Course_Prof> value = null;
	
	@FXML
	ComboBox crslist= new ComboBox();
	@FXML
	Label response;
	@FXML
	private TableView<Course_Prof> tableview2;
	@FXML
	private TableColumn<Userinfo, String> col1;
	@FXML
	private TableColumn<Userinfo, String> col2;
	@FXML
	private TableColumn<Userinfo, String> col3;
	

	public void Back(ActionEvent event) throws IOException
	{
		MainClass.StudentView();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//String studid = LoginController.userid;
		col1.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("cname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("pname"));
		try 
		{
			option=DAOclass.CourseDropDowm();
			crslist.setItems(option);
			
			//Getting the table values for the registered users
			val=DAOclass.CourseReload();
			tableview2.setItems(null);
			tableview2.setItems(val);

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			//val=DAOclass.CourseReload();
		}
			//courselist.setMaxHeight(7);
		
	}
	
	//Reloades the table once the student add/removes the course
	public void reloadTable()
	{
		col1.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("cname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("pname"));

		try
		{
			val1 = DAOclass.CourseReload();	
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		//Actual Reload function
		  tableview2.setItems(null);
		  tableview2.setItems(val1);
	}
	public void AddtoTable() throws ClassNotFoundException, SQLException
	{
		col1.setCellValueFactory(new PropertyValueFactory<>("courseid"));
		col2.setCellValueFactory(new PropertyValueFactory<>("cname"));
		col3.setCellValueFactory(new PropertyValueFactory<>("pname"));
		
		String select = (String)crslist.getSelectionModel().getSelectedItem();
		try
		{
		 value=DAOclass.AddtoTables(select);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		tableview2.setItems(null);
		tableview2.setItems(value);
	}
	
	public void RegisterCourse() throws IOException, ClassNotFoundException, SQLException
	{
		Course_Prof c1 = (Course_Prof)tableview2.getSelectionModel().getSelectedItem();
		String mssg= DAOclass.AddCourses(c1);
		response.setText(mssg);

	}
	
	public void DropCourse() throws Exception
	{
		Course_Prof c2 = (Course_Prof)tableview2.getSelectionModel().getSelectedItem();
		String mssg = DAOclass.DropCourse(c2);
		response.setText(mssg);
		reloadTable();
	}
	
}
