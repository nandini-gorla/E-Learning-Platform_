import java.util.List;

public class Trainee extends Person
{

	//Instance Fields
	public static List<Course> enrolled;   
	protected boolean premium;

	public boolean isPremium() 
	{
		return premium;
	}

	public void setPremium(boolean premium) 
	{
		this.premium = premium;
	}
	
	public List<Course> getEnrolled() 
	{
		return enrolled;
	}

	public void setEnrolled(List<Course> enrolled)
	{
		this.enrolled = enrolled;
	}
	
	// Constructors
	public Trainee(String name, char gender, int age, String email) {
		super(name, gender, age, email);
	}
	
	public Trainee() 
	{
		super();
	}

	public void NewTrainee()
	{
		System.out.println("Salam men Traineeyem");
	}

	
}