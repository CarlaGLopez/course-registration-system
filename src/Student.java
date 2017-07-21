
public class Student extends User implements Information, CourseList {
	// should have the following attributes:Username password, Student Number,SSN, Address,Phone, Date of Birth, 
	//  Major and GPA
	private String studentNumber;
	private String dateOfBirth;
	private String major;
	private String GPA;

	
	//default constructor
	public Student() {
	}

	
	//constructors
	public Student(String username, String password, String studentNumber, String SSN, String address, 
			String phoneNumber, String dateOfBirth, String major, String GPA, String[] courseList) {
		super(username, password, SSN, address, phoneNumber, courseList);
		this.studentNumber = studentNumber;
		this.dateOfBirth = dateOfBirth;
		this.major = major;
		this.GPA = GPA;
	}

	
	public Student(String studentNumber, String SSN, String address, String phoneNumber, String dateOfBirth, 
			String major, String GPA, String[] courseList) {
		super(SSN, address, phoneNumber, courseList);
		this.studentNumber = studentNumber;
		this.dateOfBirth = dateOfBirth;
		this.major = major;
		this.GPA = GPA;
	}

	
	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	
	//getters
	public String getStudentNumber() {
		return studentNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMajor() {
		return major;
	}

	public String getGPA() {
		return GPA;
	}

	
	//setters
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	
	// prints student info
	public void printAllInformation() {
		// no need to print username & password
		System.out.println("Student Number:" + studentNumber);
		System.out.println("SSN: " + getSSN());
		System.out.println("Address: " + getAddress());
		System.out.println("Phone:" + getPhoneNumber());
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Major:" + major);
		System.out.println("GPA: " + GPA);
	}

	
	//prints course list of a student
	public void printCourses() {
		System.out.println("Courses registered in: ");
		for (int i = 0; i < getCourseList().length; i++) {
			System.out.println((i + 1) + ": " + getCourseList()[i]);
		}
		System.out.println();
	}


}
