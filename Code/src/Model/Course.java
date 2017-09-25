package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * course class with appropriate getters and setters useful for the login
 * @author sridh
 *
 */
public class Course {
	
	private String courseid;
	private String cname;
	private String cmts;
	private String marks;
	private String status;

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getCmts() {
		return cmts;
	}
	public void setCmts(String cmts) {
		this.cmts = cmts;
	}
	public Course()
	{
		
	}
	public Course(String courseid, String cname)
	{
		this.courseid=courseid;
		this.cname=cname;
	}
	
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	/*private StringProperty courseid ;
	private StringProperty cname ;

	public Course()
	{
		
	}
  
	 public Course(String courseid)
	 {
		 this.courseid=new SimpleStringProperty(courseid);
	 }
	 
	 public Course(String courseid, String cname)
	 {
		 this.courseid=new SimpleStringProperty(courseid);
		 this.cname= new SimpleStringProperty(cname);
	 }
	 
	    public String getName() {
			return cname.get();
		}
		public void setName(String val) {
			cname.set(val);
		}
		public void setCourseid(String val) {
			courseid.set(val);
		}
		public String getCourseid() {
			return courseid.get();
		}
		
	//Property values
	public StringProperty cnameProperty()
	{
		return cname;
	}
	public StringProperty courseidProperty()
	{
		return courseid;
	}*/
}
