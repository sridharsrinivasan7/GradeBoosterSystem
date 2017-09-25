package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author sridh
 * Main class where run the program and this class has all the references to the page layouts
 *
 */
public class MainClass extends Application {
	
	static Stage stage1;
	public static AnchorPane anchor;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		try
		{
			stage1= primaryStage;
			Login();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public static void Login() throws IOException
	{   
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/P1.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("Login");
		stage1.setScene(scene);
		stage1.show();
	}
	
	public static void NewStudent() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/Registration.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("Register");
		stage1.setScene(scene);
		stage1.show();
	}
	
	public static void AdminViews() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/AdminViews.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("AdminViews");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void ProfViews() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/ProfViews.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("ProfViews");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void ProfWaitList() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/ProfWaitList.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("ProfWaitList");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void ProfWaitList2() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/ProfWaitList2.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("ProfWaitList");
		stage1.setScene(scene);
		stage1.show();
	}
	/*public static void Registerd() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/Registerd.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("Registerd");
		stage1.setScene(scene);
		stage1.show();
	}	*/
	public static void test() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/tessst.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("Registerd");
		stage1.setScene(scene);
		stage1.show();
	}	
	public static void RegisteredView() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/RegisteredView.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("Registerd");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void StudentView() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/StudentViews.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("StudentView");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void StudentUpdates() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/StudentUpdatesViews.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("StudentView");
		stage1.setScene(scene);
		stage1.show();
	}
	public static void AddDropCourses() throws IOException
	{
		Parent root = FXMLLoader.load(MainClass.class.getResource("/View/AddDrpCrs.fxml"));
	    //anchor=loader.load();
	    Scene scene = new Scene(root);
		stage1.setTitle("StudentView");
		stage1.setScene(scene);
		stage1.show();
	}
 }

