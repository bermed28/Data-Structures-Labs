package ciic4020.lab7.map.studentRecord;

public class Student {
	private String studentID;
	private String firstName;
	private String lastName;
	private int age;
	private double GPA;
	private String city;
	
	public Student(String idNumber, String firstName, String lastName, int age, double GPA, String city) {
		super();
		if(idNumber.equals(null)) throw new NullPointerException();
		this.studentID = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.GPA = GPA;
		this.city = city;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public double getGPA() {
		return GPA;
	}

	public String getCity() {
		return city;
	}
	
	public String toString() {
		return "{" + this.studentID + ", Name: " + this.firstName + " " + this.lastName 
				+ ", Age: " + this.age + ", GPA: " + this.GPA + ", City: " + this.city + "}";
 	}

	
	
	
	
}
