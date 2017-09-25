package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * 
 * @author sridh
 * course_prof class with appropriate getters and setters useful for the login
 * Print the date into the database as well
 */
public class Course_Prof {

	private StringProperty courseid ;
	private StringProperty cname ;
	private StringProperty pname ;

	public Course_Prof()
	{
		
	}
  
	/* public Course_Prof(String courseid)
	 {
		 this.courseid=new SimpleStringProperty(courseid);
	 }*/
	 
	 public Course_Prof(String courseid, String cname, String pname)
	 {
		 this.courseid=new SimpleStringProperty(courseid);
		 this.cname= new SimpleStringProperty(cname);
		 this.pname = new SimpleStringProperty(pname);
	 }

	public String getCourseid() {
		return courseid.get();
	}

	public void setCourseid(StringProperty courseid) {
		this.courseid = courseid;
	}

	public String getCname() {
		return cname.get();
	}

	public void setCname(StringProperty cname) {
		this.cname = cname;
	}

	public String getPname() {
		return pname.get();
	}

	public void setPname(StringProperty pname) {
		this.pname = pname;
	}
	
	//Property values
	public StringProperty cnameProperty()
	{
		return cname;
	}
	public StringProperty courseidProperty()
	{
		return courseid;
	}
	public StringProperty pnameProperty()
	{
		return pname;
	}
	 
}
