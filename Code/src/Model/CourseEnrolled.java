package Model;

	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.property.StringProperty;

    public class CourseEnrolled 
    {
		private StringProperty userid ;
		private StringProperty uname ;
		private StringProperty courseid ;
		
		/**
		 * @author sridh
         * course_prof class with appropriate getters and setters useful for the login
         * Print the date into the database as well
		 */

		public CourseEnrolled()
		{
			
		}
	  
		/* public Course_Prof(String courseid)
		 {
			 this.courseid=new SimpleStringProperty(courseid);
		 }*/
		 
		 public CourseEnrolled(String userid, String uname, String courseid)
		 {
			 this.userid = new SimpleStringProperty(userid);
			 this.uname= new SimpleStringProperty(uname);
			 this.courseid=new SimpleStringProperty(courseid);
		 }

		public String getCourseid() {
			return courseid.get();
		}

		public void setCourseid(StringProperty courseid) {
			this.courseid = courseid;
		}

		public String getUname() {
			return uname.get();
		}

		public void setUname(StringProperty uname) {
			this.uname = uname;
		}

		public String getUserid() {
			return userid.get();
		}

		public void setPname(StringProperty userid) {
			this.userid = userid;
		}
		
		//Property values
		public StringProperty unameProperty()
		{
			return uname;
		}
		public StringProperty courseidProperty()
		{
			return courseid;
		}
		public StringProperty useridProperty()
		{
			return userid;
		}
		 
}
