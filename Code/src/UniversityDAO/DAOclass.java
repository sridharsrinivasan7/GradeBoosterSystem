package UniversityDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controllerclasses.LoginController;
import Model.Admin;
import Model.Course;
import Model.CourseEnrolled;
import Model.Course_Prof;
import Model.OneStudentInfo;
import Model.Professor;
import Model.Student;
import Model.StudentData;
import Model.Userinfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 * 
 * @author sridh
 * This class has all the references to the sql queries that is being executed from the other classes.
 */
public class DAOclass {
	
	@FXML
	private static TableView<Userinfo> tableview;	
	
	private static ObservableList<Userinfo> data;
	private static ObservableList options;
	private static ObservableList<Course_Prof> data1;
	private static ObservableList<Course_Prof> reloaddata;
	
	private static ObservableList<CourseEnrolled> data3;
	private static ObservableList<OneStudentInfo> data4;
	private static ObservableList<CourseEnrolled> data5;
	private static ObservableList<Course> data6;


	public static Admin AuthAdmin(String uid) throws ClassNotFoundException, SQLException
	{
		Admin a = new Admin();
		String id=uid;
		Connection conn = (Connection) Connector.RetConn();
		try{
			
			Statement st = (Statement) conn.createStatement();
			String query = "select userid, pwd from `user-info` where userid = '"+uid+"' and isAdmin='yes' " ;
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				a.setUID(rs.getString("userid"));
				a.setPassword(rs.getString("pwd"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return a;
	}
	public static Student AuthStud(String uid) throws ClassNotFoundException, SQLException
	{
		Student s = new Student();
		String id=uid;
		Connection conn = (Connection) Connector.RetConn();
		try{
			
			Statement st = (Statement) conn.createStatement();
			String query = "select userid, pwd from `user-info` where userid = '"+uid+"' and access='allow' " ;
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				s.setUID(rs.getString("userid"));
				s.setPassword(rs.getString("pwd"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return s;
	}
	public static Professor AuthProf(String uid) throws ClassNotFoundException, SQLException
	{
		Professor p = new Professor();
		String id=uid;
		Connection conn = (Connection) Connector.RetConn();
		try{
			
			Statement st = (Statement) conn.createStatement();
			String query = "select userid, pwd from `user-info` where userid = '"+uid+"' and isType='professor' and access='allow' " ;
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				p.setUID(rs.getString("userid"));
				p.setPassword(rs.getString("pwd"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return p;
	}
	public static ObservableList<Userinfo> AdminView() throws ClassNotFoundException, SQLException
	{
		data = FXCollections.observableArrayList();
		Connection conn = (Connection) Connector.RetConn();
        try
        {
			Statement st = (Statement) conn.createStatement();
			String query = "select name, userid, isType, access from `user-info` ";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				data.add(new Userinfo(rs.getString("userid"),rs.getString("name"),rs.getString("isType"),rs.getString("access")));
				//user.setName(rs.getString("name"));
				//user.setTYPE(rs.getString("isType"));
				//user.setUID(rs.getString("userid"));
			}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return data;
	}
	public static void DeleteUser(Userinfo obj) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) Connector.RetConn();
		
		try
		{
		 String query = "delete from `user-info` where userid =?";
		 PreparedStatement pst = conn.prepareStatement(query);
		 pst.setString(1, obj.getUID());
		 pst.executeUpdate();
		 pst.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void DenyAccess(Userinfo obj) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) Connector.RetConn();
        try
        {
         String query = "UPDATE `user-info` SET access='deny' WHERE userid =?";
   		 PreparedStatement pst = conn.prepareStatement(query);
   		 pst.setString(1, obj.getUID());
   		 pst.executeUpdate();
   		 pst.close();
        }
        catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void GrantAcces(Userinfo obj) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) Connector.RetConn();
        try
        {
         String query = "UPDATE `user-info` SET access='allow' WHERE userid =?";
   		 PreparedStatement pst = conn.prepareStatement(query);
   		 pst.setString(1, obj.getUID());
   		 pst.executeUpdate();
   		 pst.close();
        }
        catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String InsertStudinfo(StudentData obj) throws ClassNotFoundException, SQLException
	{
	  String msg;
	  Connection conn = (Connection) Connector.RetConn();
	  try
	  {
		  Statement st1 = (Statement) conn.createStatement();
		  Statement st2 = (Statement) conn.createStatement();
		  String query1 = "INSERT INTO `student-data` VALUES('"+obj.getSname()+"','"+obj.getPassword()+"','"+obj.getEmail()+"','"+obj.getDept()+"','"+obj.getAge()+"','"+obj.getStudentid()+"','"+obj.getExp()+"','"+obj.getGpa()+"')"; 
		  st1.executeUpdate(query1);
		  st1.close();
		  String query2 = "INSERT INTO `user-info` VALUES('"+obj.getSname()+"','"+obj.getPassword()+"','"+obj.getStudentid()+"','student','allow','no')";
		  st2.executeUpdate(query2);
		  st2.close();
		  msg= "  Data Inserted success";
		  
	  }
	  catch(Exception e)
	  {
		 msg= "  Data insertion unsuccessful, choose a different userid";
		e.printStackTrace();
	  }
	  return msg;
	}
	public static ObservableList CourseDropDowm() throws ClassNotFoundException, SQLException
	{
		options = FXCollections.observableArrayList();
		Connection conn = (Connection) Connector.RetConn();
		try
		{
		  Statement st1 = (Statement) conn.createStatement();
		  String query1 = "select cname from `course-info`"; 
		  ResultSet rs = st1.executeQuery(query1);
		  while(rs.next())
		  {
			  options.add(rs.getString("cname"));
			  
			  //System.out.println(rs.getString(1));
		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return options;
	}
	public static ObservableList<Course_Prof> AddtoTables(String cnme) throws ClassNotFoundException, SQLException
	{
		data1 = FXCollections.observableArrayList();
		Connection conn = (Connection) Connector.RetConn();
		try
		{
		  Statement st1 = (Statement) conn.createStatement();
		  String query1 = "SELECT `cname`,`course-info`.`courseid`, `pname` FROM `course-info` inner JOIN `prof-course` on `course-info`.`courseid` = `prof-course`.`courseid` where cname='"+cnme+"'"; 
		  ResultSet rs = st1.executeQuery(query1);
		  while(rs.next())
		  {
			  data1.add(new Course_Prof(rs.getString("courseid"), rs.getString("cname"), rs.getString("pname")));
		  }
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return data1;
	}
	public static String AddCourses(Course_Prof obj) throws ClassNotFoundException, SQLException
	{
		String msg="";
		String stname="";
		String Profid = "";
		Connection conn = (Connection) Connector.RetConn();
		String stid=LoginController.userid;
		String Profname= obj.getPname();
		try
		{
			Statement st1 = (Statement) conn.createStatement();
			String q1= "select name from `student-data` WHERE studentid ='"+stid+"'";
			Statement st2 = (Statement) conn.createStatement();
			Statement st3 = (Statement) conn.createStatement();
			String q2 = "select professorid from `prof-course` where pname='"+Profname+"'";
			ResultSet rs1 = st1.executeQuery(q1);
			ResultSet rs2 = st2.executeQuery(q2);
			while(rs1.next())
			{
				stname=rs1.getString("name");
			}
			while(rs2.next())
			{
				Profid=rs2.getString("professorid");
			}
			String query1 = "INSERT INTO `student-course`(`studentid`, `courseid`, `sname`, `status`,`professorid`) VALUES('"+stid+"','"+obj.getCourseid()+"','"+stname+"','waitlisted','"+Profid+"')"; 
			st3.executeUpdate(query1);
			st1.close();
			st2.close();
			st3.close();
			msg="Dear " +stname+" your request has been sent to the department for review ";
		}
		catch(Exception e)
		{
			msg="Unsuccessful attempt";
			e.printStackTrace();
		}
		return msg;
	}
	public static String DropCourse(Course_Prof obj) throws ClassNotFoundException, SQLException 
	{
		String msg="";
		Connection conn = (Connection) Connector.RetConn();
		try
		{
		 String stuid = LoginController.userid;
		 Statement st1 = (Statement) conn.createStatement();
		 Statement st2 = (Statement) conn.createStatement();
		 /*String q1= "select count(*) as count from `student-course`";
		 ResultSet rs= st1.executeQuery(q1);
		 String var1 = rs.getString("count");
		 System.out.print(var1);*/
		 //st1.close();
		 //rs.close();
		 
		 String query1 = "delete from `student-course` where studentid=? and courseid=?";
		 PreparedStatement pst = conn.prepareStatement(query1);
		 pst.setString(1, stuid);
		 pst.setString(2, obj.getCourseid());
		 pst.executeUpdate();
		 pst.close();
		 
		 //rs.close();
		 /*String q2 = "select count(*) as count1 from `student-course`";
		 ResultSet rs1= st2.executeQuery(q2);
		 String var2 = rs1.getString("count1");
		 rs1.close();*/
		 
		 /*if(var1.equals(var2))
		 {*/
			 msg = "Course "+obj.getCname()+" Dropped ";
		 //}
		/* msg = "Course"+obj.getCname()+" Dropped ";
		 rs1.close();*/
	    }
	    catch(Exception e)
	    {
		  msg =" You need to register to drop ";
		  e.printStackTrace();
	    }
	
	return msg;	
}
  public static ObservableList<Course_Prof> CourseReload() throws ClassNotFoundException, SQLException
  {
	  String Stuid = LoginController.userid;
	  reloaddata = FXCollections.observableArrayList();
	  Connection conn = (Connection) Connector.RetConn();
	  try
      {
			Statement st = (Statement) conn.createStatement();
			String query = "select `course-info`.`courseid`,`cname`,`pname` from `student-course` inner JOIN `course-info` on `student-course`.`courseid` = `course-info`.`courseid` INNER JOIN `prof-course` on `course-info`.`courseid`=`prof-course`.`courseid` where studentid = '"+Stuid+"' and status='waitlisted'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				reloaddata.add(new Course_Prof(rs.getString("courseid"),rs.getString("cname"),rs.getString("pname")));
			}
      }
	  catch(Exception e)
      {
      	e.printStackTrace();
      }
	return reloaddata;
  }
  public static ObservableList<CourseEnrolled> Courseenrolled() throws ClassNotFoundException, SQLException
  {
	  String Profid = LoginController.userid;
	  data3 = FXCollections.observableArrayList();
	  Connection conn = (Connection) Connector.RetConn();
	  try
      {
			Statement st = (Statement) conn.createStatement();
			String query = "SELECT `studentid`, `sname`,`courseid` FROM `student-course` WHERE professorid='"+Profid+"' and status='waitlisted'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				data3.add(new CourseEnrolled(rs.getString("studentid"),rs.getString("sname"),rs.getString("courseid")));
			}
      }
	  catch(Exception e)
      {
      	e.printStackTrace();
      }
	return data3;
  }
  public static ObservableList<OneStudentInfo> Studentinfo(String id1) throws ClassNotFoundException, SQLException
	{
		//OneStudentInfo oo = new OneStudentInfo();
		data4 = FXCollections.observableArrayList();
		String uuid=id1;
		Connection conn = (Connection) Connector.RetConn();
		try{
			
			Statement st = (Statement) conn.createStatement();
			String query = "select studentid, name, gpa, exp from `student-data` where studentid = '"+uuid+"' " ;
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				data4.add(new OneStudentInfo(rs.getString("studentid"),rs.getString("name"),rs.getString("gpa"),rs.getString("exp")));
				//oo.setUID(rs.getString("studentid"));
				//oo.setName(rs.getString("name"));
				//oo.setGpa(rs.getString("gpa"));
				//oo.setExp(rs.getString("exp"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return data4;
	}
  public static String ApproveReq(OneStudentInfo obj,String crsid) throws ClassNotFoundException, SQLException
  {
	  String msg="";
	  Connection conn = (Connection) Connector.RetConn();
	  try
	  {
	   Statement st = (Statement) conn.createStatement();
	   System.out.println(obj.getUID());
	   System.out.println(crsid);
	   String query11 = "UPDATE `student-course` SET status='Approved' WHERE studentid =? and courseid=? ";
	   //String query11 = "UPDATE `student-course` SET status='Approved' WHERE studentid ='"+obj.getUID()+"' and courseid='crsid' ";
	   //st.executeUpdate(query11);
	   PreparedStatement pst = conn.prepareStatement(query11);
	   pst.setString(1, obj.getUID());
	   pst.setString(2, crsid);
	   pst.executeUpdate();
	   pst.close();
	    //st.close();
	   msg= "Approval has been sent to the student";
     }
	        catch(Exception e)
			{
	        	msg="Rejection notification sent to the student";
				e.printStackTrace();
			}
	  return msg;
		
  }
  
  public static String RejectionRes(OneStudentInfo obj,String crsid, String cmts) throws ClassNotFoundException, SQLException
  {
	  String msg="";
	  Connection conn = (Connection) Connector.RetConn();
	  try
	  {
	   Statement st = (Statement) conn.createStatement();
	   System.out.println(obj.getUID());
	   System.out.println(crsid);
	   String query11 = "UPDATE `student-course` SET status='Rejected',comments = '"+cmts+"' WHERE studentid =? and courseid=? ";
	   PreparedStatement pst = conn.prepareStatement(query11);
	   pst.setString(1, obj.getUID());
	   pst.setString(2, crsid);
	   pst.executeUpdate();
	   pst.close();
	   msg= "Response has been sent to the student";
     }
	        catch(Exception e)
			{
	        	msg="Rejection notification sent to the student";
				e.printStackTrace();
			}
	  return msg;
		}
  public static ObservableList<CourseEnrolled> Registeredcandidates() throws ClassNotFoundException, SQLException
  {
	  String Profid = LoginController.userid;
	  data5 = FXCollections.observableArrayList();
	  Connection conn = (Connection) Connector.RetConn();
	  try
      {
			Statement st = (Statement) conn.createStatement();
			String query = "SELECT `studentid`, `sname`,`courseid` FROM `student-course` WHERE professorid='"+Profid+"' and status='Approved'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				data5.add(new CourseEnrolled(rs.getString("studentid"),rs.getString("sname"),rs.getString("courseid")));
			}
      }
	  catch(Exception e)
      {
      	e.printStackTrace();
      }
	return data5;
  }
  public static String ScoreSubmittion(CourseEnrolled obj,String points, String comments) throws ClassNotFoundException, SQLException
  {
	  String msg="";
	  Connection conn = (Connection) Connector.RetConn();
	  try
	  {
	   String query11 = "UPDATE `student-course` SET score='"+points+"',comments = '"+comments+"' WHERE studentid =? and courseid=? ";
	   PreparedStatement pst = conn.prepareStatement(query11);
	   pst.setString(1, obj.getUserid());
	   pst.setString(2, obj.getCourseid());
	   pst.executeUpdate();
	   pst.close();
	   msg= "Response has been sent to the student";
     }
	        catch(Exception e)
			{
	        	msg="Update failure";
				e.printStackTrace();
			}
	  return msg;
		}
  public static Course CourseUpdates() throws ClassNotFoundException, SQLException
  {
	  Connection conn = (Connection) Connector.RetConn();
	  Course course1 = new Course();
	  String stuid = LoginController.userid;
	  try
	  {
		  Statement stt1 = (Statement) conn.createStatement();
		  String query11 = "select courseid,status from `student-course` WHERE studentid ='"+stuid+"' and status ='waitlisted' ";
		  ResultSet rs = stt1.executeQuery(query11);
		  while(rs.next())
		  {
			course1.setCourseid(rs.getString("courseid"));
			course1.setStatus(rs.getString("status"));
		   }
		  
	  }
	   catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return course1;
  }
  public static Course FailureNotification() throws ClassNotFoundException, SQLException
  {
	  Connection conn = (Connection) Connector.RetConn();
	  Course course2 = new Course();
	  String stuid = LoginController.userid;
	  try
	  {
		  Statement stt1 = (Statement) conn.createStatement();
		  String query11 = "select courseid, comments,status from `student-course` WHERE studentid ='"+stuid+"' and status ='Rejected' ";
		  ResultSet rs = stt1.executeQuery(query11);
		  while(rs.next())
		  {
			course2.setCmts(rs.getString("comments"));
			course2.setStatus(rs.getString("status"));
			course2.setCourseid(rs.getString("courseid"));
		   }
		  
	  }
	   catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return course2;
  }
  public static Course ScoreandSuggesstions() throws ClassNotFoundException, SQLException
  {
	  Connection conn = (Connection) Connector.RetConn();
	  Course course3 = new Course();
	  String stuid = LoginController.userid;
	  try
	  {
		  Statement stt1 = (Statement) conn.createStatement();
		  String query11 = "select courseid, score, comments from `student-course` WHERE studentid ='"+stuid+"' and status ='Approved' ";
		  ResultSet rs = stt1.executeQuery(query11);
		  while(rs.next())
		  {
			course3.setCmts(rs.getString("comments"));
			course3.setMarks(rs.getString("score"));
			course3.setCourseid(rs.getString("courseid"));
		   }
		  
	  }
	   catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return course3;
  }
}