public class nonStudent extends Trainee implements Performance
{
	//Instance Fields
	private String job;
	private String position;
	private int credit;
	
	//Mutators
	public String getJob()
	{
		return job;
	}
	
	public String getPosition() 
	{
		return position;
	}
	
	public void setJob(String job) 
	{
		this.job = job;
	}
	
	public void setPosition(String position) 
	{
		this.position = position;
	}

	@Override
	public float credit() 
	{
		return 0;
	}

	@Override
	public float monthlyFee() 
	{
		return 0;
	}
	
	
	//Constructor
	public nonStudent(String name, char gender, int age, String email,  String password, String job, String position) 
	{
		super(name, gender, age, email);
		this.job = job;
		this.position = position;
		this.password = password;
	}
	
	public nonStudent(String name, char gender, int age, String email, String job, String position, boolean premium) 
	{
		super(name, gender, age, email);
		this.job = job;
		this.position = position;
		this.premium = premium;
	}
	public nonStudent()
	{
		super();
	}
}
