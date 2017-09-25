package Controllerclasses;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import Model.Userinfo;
import UniversityDAO.Connector;
import UniversityDAO.DAOclass;
import application.MainClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable {
	

	@FXML
	Label L1;
	@FXML
	private TableView<Userinfo> tableview;
	@FXML
	private TableColumn<Userinfo, String> coluserid;
	@FXML
	private TableColumn<Userinfo, String> colname;
	@FXML
	private TableColumn<Userinfo, String> colistype;
	@FXML
	private TableColumn<Userinfo, String> colas;
	
	private ObservableList<Userinfo> login = null; 
	private ObservableList<Userinfo> reload = null; 


	
	public void GrantAccess(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		Userinfo uu1 = (Userinfo)tableview.getSelectionModel().getSelectedItem();
		DAOclass.GrantAcces(uu1);
		L1.setText("  USER '"+uu1.getName()+"' GRANTED ");
	    reloaddb();
	}
	public void RevokeAccess() throws IOException, ClassNotFoundException, SQLException
	{
		 Userinfo uu2 = (Userinfo)tableview.getSelectionModel().getSelectedItem();
		 DAOclass.DenyAccess(uu2);
		 L1.setText("  USER '"+uu2.getName()+"' REVOKED ");
	     reloaddb();
	}
	
	public void Signout(ActionEvent event) throws IOException
	{
		MainClass.Login();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		L1.setText("Welcome "+LoginController.userid);
		
		coluserid.setCellValueFactory(new PropertyValueFactory<>("uid"));
		colname.setCellValueFactory(new PropertyValueFactory<>("uname"));
		colistype.setCellValueFactory(new PropertyValueFactory<>("type"));
		colas.setCellValueFactory(new PropertyValueFactory<>("access"));

		//ObservableList<Userinfo> login = null;
		try 
		{
			login = DAOclass.AdminView();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

		//tableview.setItems(null);
		tableview.setItems(login);

	}
	public void reloaddb()
	{
		coluserid.setCellValueFactory(new PropertyValueFactory<>("uid"));
		colname.setCellValueFactory(new PropertyValueFactory<>("uname"));
		colistype.setCellValueFactory(new PropertyValueFactory<>("type"));
		colas.setCellValueFactory(new PropertyValueFactory<>("access"));

		try
		{
			reload = DAOclass.AdminView();	
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		//Actual Reload function
		  tableview.setItems(null);
		  tableview.setItems(reload);
	}
	public void onClickDeleteUserAccount() throws ClassNotFoundException, SQLException
	{
		 //onclick function that gives the appropriate row values
		 Userinfo u1 = (Userinfo)tableview.getSelectionModel().getSelectedItem();
		 DAOclass.DeleteUser(u1);
		 L1.setText("  USER '"+u1.getName()+"' REMOVED " );
	     reloaddb();
	     
	}
}
