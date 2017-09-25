package Model;

/**
 * 
 * @author sridh
 * Admin class with appropriate getters and setters useful for the login
 */
public class Admin {

	private String name;
	private String uid;
	private String type;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUID(String uid) {
		this.uid = uid;
	}
	public String getUID() {
		return uid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setTYPE(String type) {
		this.type = type;
	}
	public String getTYPE() {
		return type;
	}
	
	public String toString(){
		return "Name: " + name + ", uid: " +uid+ "TYPE " +type;
	}

}
