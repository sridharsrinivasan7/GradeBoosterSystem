package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author sridh
 * Userinfo class with appropriate getters and setters useful for the login
 * Print the date into the database as well
 */
public class Userinfo {

	private StringProperty userid;
	private StringProperty uname;
	private StringProperty type;
	private StringProperty access;


	

	public Userinfo()
	{
		
	}
  
	 public Userinfo(String userid, String uname, String type, String access)
	 {
		 this.userid=new SimpleStringProperty(userid);
		 this.uname= new SimpleStringProperty(uname);
		 this.type = new SimpleStringProperty(type);
		 this.access = new SimpleStringProperty(access);

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
		public void setTYPE(String val) {
			type.set(val);
		}
		public String getTYPE() {
			return type.get();
		}
		public String getAccess() {
			return access.get();
		}
		public void setAccess(String val) {
			access.set(val);
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
	public StringProperty typeProperty()
	{
		return type;
	}
	public StringProperty accessProperty()
	{
		return access;
	}
}
