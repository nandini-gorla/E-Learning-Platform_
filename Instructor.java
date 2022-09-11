public class Instructor extends Person
{
	//Instance Fields
	public int ID;
	
	public void InstructorDemo()
	{
		 Course CourseInstructor = new Course();
		 CourseInstructor.Hello();
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public Instructor()
	{
		super();
	}

	public Instructor(String name, char gender, int age, String email, int id, String password) {
		super(name, gender, age, email);
		this.ID = id;
	}


}