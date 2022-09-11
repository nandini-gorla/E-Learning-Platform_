abstract class Person 
 {
	 //Instance Fields
	 private String name;
	 private char gender; 
	 private int age;
	 private String email;
	 protected String password;
	 
	 //Mutators
	 public String getName() 
	 {
		 return name;
	 }
	 
	 public char getGender() 
	 {
		 return gender;
	 }
	 
	 public int getAge() 
	 {
		 return age;
	 }
	 
	 public String getEmail() 
	 {
		 return email;
	 }

	 public String getPassword()
	 {
		 return password;
	 }
	 
	 public void setName(String name) 
	 {
		 this.name = name;
	 }
	
	 public void setGender(char gender)
	 {
		 this.gender = gender;
	 }
	
	 public void setAge(int age)
	 {
		 this.age = age;
	 }
	 
	 public void setEmail(String email) 
	 {
		 this.email = email;
	 }
	  
	 public void setPassword(String password) 
	 {
		 this.password = password;
	 }
	 
	 
	 //Constructors
	 public Person(String name, char gender, int age, String email) 
	 {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.email = email;
	}
	 
	 public Person(String name, char gender, int age, String email, String password)
	 {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.password = password;
	}
	 

	public Person() 
	{
		super();
		this.name = null;
		this.gender = ' ';
		this.age = 0;
		this.email = null;
		this.password = null;
		
	}

	//Has a relation
	
	public void PersonOnlineLearn()
	 { 
		 OnlineLearningApplication PersonInOnlineLearnApp = new OnlineLearningApplication(); 
	 }
	 
 
	 
	 public void PersonInfo()
	 {
		 System.out.println("Yeni Insan!!");
	 }
 }

 