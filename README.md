# GradeBoosterSystem

## About the Project: 
This is Grade-booster System, helpful for both the professors and students where a student can register for a course and the professor approves the student to join his/her class.
Student Register for a course, professor get the popup and he accepts the student based on his previous grade and experience. Post approval professor grades the student and comments the learnings for the marks he has lost, which in turn gets into student account and he’d view this in the updates page.
## Users:
### Admin: 

Can grant, revoke and delete access of the user, and we don’t have admin registration, by default there are 2 admins
a.	Userid : ad101 : password : pass1
b.	Userid : ad102 : password : pass2

### Professor: 

Professor can view the students who has registered for his course and he could accept them or reject. And can grade accepted students and comment the links and contents for them to learn, No registration for professor as well, by default one professor.
a.	Userid : pr501 : password : pass1

### Student: Student needs to register an account, post registration could view the course add/drop them. And can view the updates from the professor. At every stages.

Tables Used:
1.	User-info: consists of userid, passwords, is user the admin, student or professor informations.
2.	Student-data: consists of the student information once he registers. 
3.	Course-info : information about courseid, coursename and credits.
4.	Professor-info: professor-name, professorid, experience.
5.	Student-course: the courses that student registers for with professorid
6.	Prof-course: professor course means the courses they teach, with the professor name.

