import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineLearningApplication {
	// Instance Fields
	private static List<Instructor> instructor;
	private static List<Student> students;
	private static List<nonStudent> NonStudents;
	private static List<Course> course;
	private static List<Course> tempList;

	public OnlineLearningApplication() 
	{
		super();
	}

	public List<Instructor> getInstructor()
	{
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) 
	{
		this.instructor = instructor;
	}

	public List<Student> getTrainee() 
	{
		return students;
	}

	public void setTrainee(List<Student> trainee)
	{
		this.students = students;
	}

	public List<Course> getCourse() 
	{
		return course;
	}

	public void setCourse(List<Course> course) 
	{
		this.course = course;
	}
	public void OnlineLearn() 
	{
		Course CourseInOnlineLearnApp =  new Course();
	}
	 

	// Methods
	public void menu(int i, boolean isStudent) 
	{
		for(;;) //Creating infinite loop
		{
			System.out.println("\nPress\n1 Add Course\n2 Delete Course\n3 Get Instructor Details\n4 Change your account to premium\n5 List All courses");
			System.out.println("6 List Your courses\n7 See Monthly Fee\n8 Log Out \n9 Exit");
			double result;
			Scanner choice = new Scanner(System.in);
			String chosen = choice.nextLine(); //getting user input
			if(chosen.length() > 1){chosen="15";}
			switch (chosen) 
			{
				case "1":
					Scanner courseName = new Scanner(System.in);
					System.out.println("\nWrite Course Name to ADD: ");
					String courseName1 = courseName.nextLine();
					addCourse(i, isStudent, courseName1); //calling add course
					break;
				case "2":
					deleteCourse(i, isStudent); //calling deleteCourse
					break;
				case "3":
					for(int j = 0; j < instructor.size(); j++)   //showing instructor IDs
					{
						System.out.println("\nID: " + ((Instructor) instructor.get(j)).getID() + "  Insctructor: " + ((Instructor) instructor.get(j)).getName());
					} 
					System.out.println("\nEnter ID of Instructor to get detailed info: ");
					Scanner InsName = new Scanner(System.in);
					int InsName1 = InsName.nextInt();   //getting instructor ID from user
					getInstructorDetails(InsName1);   // calling  getInstructorDetails
					break;
				
				case "4":
					changeToPremium(i, isStudent);   //making user premium
					break;
				case "5":
					listAllCourses(i, isStudent);   // listing all courses
					break;
				case "6":
					listEnrolledCourses(i, isStudent); // listing enrolled courses
					break;
				case "7":
					result = monthlyFee(i,isStudent);   //calculating montlyFee
					if(result == 0)
					{
						System.out.println("\nYour Monthly Fee is: 0TL");
					}
					else
					{
						result = Math.round(result * 100.0) / 100.0;
						System.out.println("\nYour Monthly Fee is: "+result+"TL");
					}
					break;
				case "8":
					logout();  //logging out
					break;
				case "9":
					System.out.println("\nYou exited, Thank you for using our platform.");
					exit();
					break;
	
				default:
					System.out.println("Please, choose correct option!");
			}
		

		} 

	}
	//signUp Working Fully
	public void signUp(ArrayList students, ArrayList Nonstudents) 
	{
		System.out.println("\nHello, add your details to sign up:\n");

		Scanner details = new Scanner(System.in); // Here getting details of the user
		System.out.println("\nEnter your name:  ");
		String name = details.nextLine();
		System.out.println("\nEnter your gender:  ");
		String gender = details.nextLine();
		System.out.println("\nEnter your email:  ");
		String email = details.nextLine();
		System.out.println("\nEnter your password:  ");
		String password = details.nextLine();
		System.out.println("\nEnter your age:  ");
		int age = details.nextInt();

		if (age != (int)age || name.length() == 0 || email.length() == 0 || gender.length() == 0 || password.length() == 0) 
		{
			System.out.println("\nPlease, add correct values.");
		}

		
		else 
		{ 
			
			System.out.println("Press\n1 to Create Student account\n2 to Create nonStudent account");
		 
			 Scanner choice1 = new Scanner(System.in);
			 int chosen1 = choice1.nextInt();
			 
			 switch(chosen1) 
			 { 
			 		case 1: //if he is a Student
			 			System.out.println("\nPlease enter your Institution name:  "); 
			 			Scanner choice2 = new Scanner(System.in); 
			 			String Institution = choice2.nextLine();
			 			Student s1 = new Student(name, gender.charAt(0), age, email, password, Institution, false); 
			 			students.add(s1);
			 			break;
			 			
			 		case 2: //if he is a nonStudent
			 			System.out.println("\nPlease enter your Job:  "); 
			 			Scanner choice3 = new Scanner(System.in); 
			 			String job = choice3.nextLine();
			 			System.out.println("\nPlease enter your Position:  "); 
			 			String position = choice3.nextLine(); 
			 			nonStudent nons1 = new nonStudent(name, gender.charAt(0), age, email, password, job, position); 
			 			Nonstudents.add(nons1);
			 			break; 
			 		
			 		default:
			 			System.out.println("Please, choose correct option!"); 
			 			break;
			 }
					  
		 }

	}

	//login Working Fully
	public void login(ArrayList students, ArrayList Nonstudents) 
	{
		System.out.println("\nTo log in enter: \nEmail:  ");
		Scanner choice4 = new Scanner(System.in);
		String email = choice4.nextLine();
		System.out.println("\nEnter your password:  ");
		String password = choice4.nextLine();
		Integer flagLoginChecker = 0;
		if(students.isEmpty() == false) 
		{
			for(int i = 0; i < students.size(); i++)
			{
				if(email.equals( (((Student) students.get(i)).getEmail()) )  && password.equals( (((Student) students.get(i)).getPassword()) ))
				{
					System.out.println("\nLogged in Successfully.\n");
					flagLoginChecker = 1;
					menu(i, true);
				} 
			}	
		}
		
		if(Nonstudents.isEmpty() == false) 
		{
			for(int i = 0; i < Nonstudents.size(); i++)
			{
				if (email.equals( (((nonStudent) Nonstudents.get(i)).getEmail()) )  && password.equals( (((nonStudent) Nonstudents.get(i)).getPassword()) ))
				{
					System.out.println("\nLogged in Successfully.\n");
					flagLoginChecker = 1;
					menu(i, false);
				} 
			}	
		}
		
		if(flagLoginChecker == 0)
		{
			System.out.println("\nEmail or password doesn't match\n");
		}
	}
	
	//addCourse Working Fully
	public void addCourse(int i, boolean isStudent, String courseName) 
	{
		Integer flagPremiumChecker = 0;
		Integer flagCourseNameChecker = 0;
		if(isStudent == true)      //If it is a student, I check Student List
		{	if((((Student) students.get(i)).isPremium()) == true) { flagPremiumChecker = 1;}
			for(int j = 0; j < course.size(); j++)
			{
				if(courseName.equals(((Course) course.get(j)).getName()))
				{	flagCourseNameChecker = 1;
					if(((Course) course.get(j)).isPremium() == (((Student) students.get(i)).isPremium()) || flagPremiumChecker == 1)
					{
						flagPremiumChecker = 1;
						tempList = new ArrayList<>();	//Creating a temporary arrayList 

						if (((Student) students.get(i)).getEnrolled() == null) { tempList.add( (course.get(j)) );((Student) students.get(i)).setEnrolled(tempList); }
						else
						{
							tempList.addAll( ((Student) students.get(i)).getEnrolled() ) ;
							tempList.add( (course.get(j)) );				
							((Student) students.get(i)).setEnrolled(tempList);
						}
						
					}
			
				}
			 }	
			
			if(flagCourseNameChecker == 0) 	{ System.out.println("Course couldn't be found, try different course.\n"); }
			else if(flagPremiumChecker == 0) { System.out.println("Course is premium, please change your account to premium to add.\n"); }
			else { System.out.println("Course added, successfully\n"); }
			menu(i, isStudent);
		}
		
		else //If he is a nonStudent
		{
			if((((nonStudent) NonStudents.get(i)).isPremium()) == true) { flagPremiumChecker = 1;}
			for(int j = 0; j < course.size(); j++)
			{
				if(courseName.equals(((Course) course.get(j)).getName()))
				{	flagCourseNameChecker = 1;
					if(((Course) course.get(j)).isPremium() == (((nonStudent) NonStudents.get(i)).isPremium()) || flagPremiumChecker == 1)
					{
						flagPremiumChecker = 1;
						tempList = new ArrayList<>();	//Creating a temporary arrayList    
						if( ((Student) students.get(i)).getEnrolled() == null) {tempList.add( (course.get(j)) ); ((nonStudent) NonStudents.get(i)).setEnrolled(tempList);}
						
						else
						{
							tempList.addAll( ((nonStudent) NonStudents.get(i)).getEnrolled() );
							tempList.add( (course.get(j)) );				
							((nonStudent) NonStudents.get(i)).setEnrolled(tempList);
						}
					}
			
				}
			 }	
			
			if(flagCourseNameChecker == 0) 	{ System.out.println("Course couldn't be found, try different course.\n"); }
			else if(flagPremiumChecker == 0) { System.out.println("Course is premium, please add credits to add.\n"); }
			else { System.out.println("Course added, successfully\n"); }
			menu(i, isStudent);
		}
	}
	
	//listEnrolledCourses Working Fully
	public void listEnrolledCourses(int i, boolean isStudent) 
	{
		if(isStudent == true)      //If it is a student, I check Student List
		{	
			if( ((Student) students.get(i)).getEnrolled() != null)
			{	
				if((((Student) students.get(i)).getEnrolled()).size() != 0)
				{
					System.out.println("\nYour courses are as follows: ");
					tempList = new ArrayList<>();
					tempList.addAll( ((Student) students.get(i)).getEnrolled() );
					for(int j = 0; j < tempList.size(); j++)
					{
						System.out.println((j+1)+". " + tempList.get(j).getName());
					}
				}
				else
				{
					System.out.println("\nYou aren't enrolled to any course.\n");
				}
				
			}
			else
			{
				System.out.println("\nYou aren't enrolled to any course.\n");
			}
			menu(i, isStudent);
		}
		
		else
		{
			if( ((nonStudent) NonStudents.get(i)).getEnrolled() != null )
			{	
				if((((nonStudent) NonStudents.get(i)).getEnrolled()).size() != 0)
				{
					System.out.println("\nYour courses are as follows: ");
					tempList = new ArrayList<>();
					tempList.addAll( ((nonStudent) NonStudents.get(i)).getEnrolled() );
					for(int j = 0; j < tempList.size(); j++)
					{
						System.out.println((j+1)+". " + tempList.get(j).getName());
					}
				}
				
			}
			else
			{
				System.out.println("\nYou aren't enrolled to any course.\n");
			}
			menu(i, isStudent);
		}
	}
	
	//deleteCourse Working Fully
	public void deleteCourse(int i, boolean isStudent) 
	{Integer flagDeleted = 0;
		if(isStudent == true)      //If it is a student, I check Student List
		{	
			tempList = new ArrayList<>();	//Creating a temporary arrayList    
			if( ((Student) students.get(i)).getEnrolled() != null) {tempList.addAll( ((Student) students.get(i)).getEnrolled() );} 
			else {System.out.println("\nYou aren't enrolled to any course.\n"); return;}
			Scanner courseName1 = new Scanner(System.in);
			System.out.println("\nWrite Course Name to DELETE: ");
			String courseName = courseName1.nextLine();
			
			for(int j = 0; j < tempList.size(); j++)
			{
				if(courseName.equals(((Course) tempList.get(j)).getName()))
				{	
					tempList.remove( tempList.get(j));	flagDeleted = 1;		
				}
			}	
			if(flagDeleted == 1)
			{
				((Student) students.get(i)).setEnrolled(tempList);
				System.out.println("Course deleted, successfully\n"); 
				menu(i, isStudent);
			}
			else {System.out.println("\nYou aren't enrolled to this course.\n"); return;}
			
		}
		
		else //If he is a nonStudent
		{
			tempList = new ArrayList<>();	//Creating a temporary arrayList 
			if( ((nonStudent) NonStudents.get(i)).getEnrolled() != null) {tempList.addAll( ((nonStudent) NonStudents.get(i)).getEnrolled() );} 
			else {System.out.println("\nYou aren't enrolled to any course.\n"); return;}
			Scanner courseName1 = new Scanner(System.in);
			System.out.println("\nWrite Course Name to DELETE: ");
			String courseName = courseName1.nextLine();
			
			for(int j = 0; j < tempList.size(); j++)
			{
				if(courseName.equals(((Course) tempList.get(j)).getName()))
				{	
					tempList.remove( tempList.get(j));	flagDeleted = 1;		
				}
			}	
			if(flagDeleted == 1)
			{
				((nonStudent) NonStudents.get(i)).setEnrolled(tempList);
				System.out.println("Course deleted, successfully\n"); 
				menu(i, isStudent);
			}
			else {System.out.println("\nYou aren't enrolled to this course.\n"); return;}
		}
	}

	public void getInstructorDetails(int id)
	{
		if(id <= instructor.size())
		{
			int j = id - 1;
			System.out.println("\nInsctructor: " + ((Instructor) instructor.get(j)).getName()+"\nID: " + ((Instructor) instructor.get(j)).getID()+"\nAge: "+((Instructor) instructor.get(j)).getAge());
			System.out.println("Gender: " + ((Instructor) instructor.get(j)).getGender() + "\nEmail: " + ((Instructor) instructor.get(j)).getEmail());
		}
		else
		{
			System.out.println("\nFailure, No Instructors found!\n");
		}
	}
	
	//changeToPremium Working Fully
	public void changeToPremium(int i, boolean isStudent) 
	{
		System.out.println("Would you like to change your account to premium? \nClick: Y|N");
		Scanner choice5 = new Scanner(System.in);
		String choice = choice5.nextLine();
		switch(choice.charAt(0))
		{
			case 'Y':
				if(isStudent == true)      //If it is a student, I check Student List
				{
					if(((Student) students.get(i)).isPremium() != true)
					{
						((Student) students.get(i)).setPremium(true);
						System.out.println("\nYour status is now Premium");
					}
					else {System.out.println("\nYou are already a premium member.\n");}
				}
				else 
				{
					if(((nonStudent) NonStudents.get(i)).isPremium() != true)
					{
						((nonStudent) NonStudents.get(i)).setPremium(true);
						System.out.println("\nYour status is now Premium");
					}
					else {System.out.println("\nYou are already a premium member.\n");}
	
				}
				break;
			case 'N':
				System.out.println("\nOperation is canceled!\n");
				menu(i,isStudent);
				break;
			default:
				System.out.println("\nChoose correct option\n");
				break;
		}
		
	}
	
	//listAllCourses Working Fully
	public void listAllCourses(int i, boolean isStudent) 
	{   Integer flagPremiumChecker = 0; Integer counter = 1;
		if(isStudent == true)      //If it is a student, I check Student List
		{	
			if((((Student) students.get(i)).isPremium()) == true) { flagPremiumChecker = 1;}
			System.out.println("\nCourses are as follows: ");
			
			for(int j = 0; j < course.size(); j++)
			{
				if(((Course) course.get(j)).isPremium() == (((Student) students.get(i)).isPremium()) || flagPremiumChecker == 1)
				{
					System.out.println(counter+". " + course.get(j).getName());counter++;
				}
			}
				
			menu(i, isStudent);
		}
		
		else
		{
			if((((nonStudent) NonStudents.get(i)).isPremium()) == true) { flagPremiumChecker = 1;}
			System.out.println("\nCourses are as follows: ");
			
			for(int j = 0; j < course.size(); j++)
			{
				if(((Course) course.get(j)).isPremium() == (((nonStudent) NonStudents.get(i)).isPremium()) || flagPremiumChecker == 1)
				{
					System.out.println(counter+". " + course.get(j).getName());counter++;
				}
			}
			menu(i, isStudent);
		}
	}
	
	public double credit(int i, boolean isStudent)
	{
		if(isStudent == true)      //If it is a student, I check Student List
		{	
			tempList = new ArrayList<>();
			tempList.addAll( ((Student) students.get(i)).getEnrolled() );
			double enrolled_course = 0;
			
			for(int j = 0; j < tempList.size(); j++)
			{
				if(((Course) tempList.get(j)).isPremium() == true)
				{
					enrolled_course++;
				}
			}
			enrolled_course = enrolled_course*0.8;
			return enrolled_course;
		}
		
		else
		{
			tempList = new ArrayList<>();
			tempList.addAll( ((nonStudent) NonStudents.get(i)).getEnrolled() );
			double enrolled_course = 0;
			
			for(int j = 0; j < tempList.size(); j++)
			{
				if(((Course) tempList.get(j)).isPremium() == true)
				{
					enrolled_course++;
				}
			}
			enrolled_course = enrolled_course*0.4;
			return enrolled_course;
		}
	}
	
	public double monthlyFee(int i, boolean isStudent)
	{
		Integer flagPremiumChecker = 0; Integer counter = 1;
		if(isStudent == true)      //If it is a student, I check Student List
		{	
			if((((Student) students.get(i)).isPremium()) == true)
			{ 
				tempList = new ArrayList<>();
				if(((Student) students.get(i)).getEnrolled() == null) {return 0;}
				tempList.addAll( ((Student) students.get(i)).getEnrolled() );
				double enrolled_course = 0;
				if(tempList.size() != 0)
				{
					for(int j = 0; j < tempList.size(); j++)
					{
						if(((Course) tempList.get(j)).isPremium() == true)
						{
							enrolled_course++;
						}
					}
					double a = 10*enrolled_course;
					double b = a - credit(i,isStudent);
					return a-b;
				}
				return 0;
			}
			else
			{
				return 0;
			}
		}
		
		else
		{
			if((((nonStudent) NonStudents.get(i)).isPremium()) == true)
			{ 
				
				tempList = new ArrayList<>();
				if(((nonStudent) NonStudents.get(i)).getEnrolled() == null) {return 0;}
				tempList.addAll( ((nonStudent) NonStudents.get(i)).getEnrolled() );
				double enrolled_course = 0;
				if(tempList.size() != 0)
				{
					for(int j = 0; j < tempList.size(); j++)
					{
						if(((Course) tempList.get(j)).isPremium() == true)
						{
							enrolled_course++;
						}
					}
					double a = 10*enrolled_course;
					double b = a - credit(i,isStudent);
					b = (a-b)*2.0;
					return b;
				}
				return 0;
			}
			else
			{
				return 0;
			}
		}
	}
	
	//logout Working Fully
	public void logout()
	{
		OnlineLearningApplication.main(null);
	}

	//exit Working Fully
	public void exit() 
	{
		System.exit(0);
	}

	public void MyFunctionAddInstructor(String name, char gender, int age, String email, int id, String password)
	{
		Instructor Ins = new Instructor(name, gender, age, email, id, password); 
		instructor.add(Ins);
	}
	
	public void MyFunctionAddCourse(Instructor instructor, String name, float duration, boolean premium)
	{
		Course CourseNew = new Course(instructor, name, duration, premium);
		course.add(CourseNew);
	}
	
	public static void main(String[] args)
	{
		OnlineLearningApplication New_Instance = new OnlineLearningApplication(); // Here to access nonStatic method from static method, I am providing an instance of my class
																
		students = new ArrayList<>();
		NonStudents = new ArrayList<>();
		instructor = new ArrayList<>();
		course = new ArrayList<>();
		
		//I will have 4 Instructors.
		New_Instance.MyFunctionAddInstructor("John", 'M', 36, "john23@metu.edu.tr", 1, "j7799f");    // John teaches 2 courses
		New_Instance.MyFunctionAddInstructor("Emily", 'F', 41, "e_op90@metu.edu.tr", 2, "io9932");  //Emily teaches 2 courses
		New_Instance.MyFunctionAddInstructor("Martin", 'M', 60, "martin_e@metu.edu.tr", 3, "o9ofe");
		New_Instance.MyFunctionAddInstructor("Susan", 'F', 33, "susan99@metu.edu.tr", 4, "fd99f3");
		
		// I will have 6 courses, 2 instructor will teach 2 courses
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(0), "Physics I", 42, false);   // Duration I added as hour.
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(0), "Physics II", 50, true);  //This is my premium course  
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(1), "Software Engineering", 40, false);  
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(1), "Software Architecture", 42, true);  //This is my premium course 
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(2), "Chemistry", 38, false);  
		New_Instance.MyFunctionAddCourse((Instructor) instructor.get(3), "Calculus", 42, true);    //This is my premium course 
		
		
		for (;;) // I am creating very first menu here.
		{
			System.out.println("Press\n1 to Sign up\n2 to Login\n3 to Exit");
			Scanner choice = new Scanner(System.in);
			int chosen = choice.nextInt();

			switch (chosen) 
			{
				case 1:
					New_Instance.signUp((ArrayList) students, (ArrayList) NonStudents);
					break;
					
				case 2:
					New_Instance.login((ArrayList) students, (ArrayList) NonStudents);
					break;
					
				case 3:
					System.out.println("\nYou exited, Thank you for using our platform.");
					New_Instance.exit();
					break;
					
				default:
					System.out.println("Please, choose correct option!");
			}

		}
		

	}

}