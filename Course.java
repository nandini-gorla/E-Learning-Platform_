public class Course 
{
	//Instance Fields
	public Instructor Instructor;
	public String name;
	public float duration;
	public boolean premium;

	
	
	public Instructor getInstructor() {
		return Instructor;
	}

	public void setInstructor(Instructor instructor) {
		Instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	//Constructor
	public Course(Instructor instructor, String name, float duration, boolean premium)
	{
		super();
		Instructor = instructor;
		this.name = name;
		this.duration = duration;
		this.premium = premium;
	}
	
	public Course()
	{
		super();
	}
	
	//Has relation
	public void CourseTrainee() 
	{ 
		Trainee CourseTrainee = new Trainee();
	 	CourseTrainee.NewTrainee();
	}
	 
	

	public void Hello()
	{
		System.out.println("Salam men Course'am");
	}
}

