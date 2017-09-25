package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author sridh
 * 
 * course_prof class with appropriate getters and setters useful for the login
 * Print the date into the database as well
 */
public class OneStudentInfo {

	private StringProperty userid;
	private StringProperty uname;
	private StringProperty gpa;
	private StringProperty exp;
	
	 public OneStudentInfo()
	 {
		 
	 }
	
	 public OneStudentInfo(String userid, String uname, String gpa, String exp)
	 {
		 this.userid=new SimpleStringProperty(userid);
		 this.uname= new SimpleStringProperty(uname);
		 this.gpa = new SimpleStringProperty(gpa);
		 this.exp = new SimpleStringProperty(exp);
	 }
	 
	 public String getName() {
			return uname.get();
		}
		public void setName(String val) {
			uname.set(val);
		}
		public void setUID(String val) {
			userid.set(val);
		}
		public String getUID() {
			return userid.get();
		}
		public void setGpa(String val) {
			gpa.set(val);
		}
		public String getGpa() {
			return gpa.get();
		}
		public String getExp() {
			return exp.get();
		}
		public void setExp(String val) {
			exp.set(val);
		}
	 
		//Property values
		public StringProperty unameProperty()
		{
			return uname;
		}
		public StringProperty uidProperty()
		{
			return userid;
		}
		public StringProperty gpaProperty()
		{
			return gpa;
		}
		public StringProperty expProperty()
		{
			return exp;
		}
	 
}
