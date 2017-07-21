public class Course implements Information {

	private String courseNumber;
	private String courseName;
	// 2:30...GIVE SPECIFIC DIRECTIONS ..AM & PM in main program!!
	private String meetTime;
	private String room;
	private String professorName;
	private int numOfStudents;
	/** DON'T NEED THIS...I'll use boolean isFull instead: private int numOfSeats; //used 
	to see when the class is full / max class size **/
	private String[] studentList;
	private boolean isFull;

	// MAYBE list of students?....need to set setters (for loop) and getter(for loop)
	// need to set up an Array List of Students

	// default constructor method
	public Course() {
		courseNumber = "";
		courseName = "";
		meetTime = "";
		room = "";
		professorName = "";
		numOfStudents = 0;
		// numOfSeats = 0;
		studentList = null;
		isFull = false;
	}

	// overloaded constructor
	public Course(String courseNumber, String courseName, String meetTime,
			String room, String professorName, int numOfStudents,
			String[] studentList, boolean isFull) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.meetTime = meetTime;
		this.room = room;
		this.professorName = professorName;
		this.numOfStudents = numOfStudents;
		// this.numOfSeats = numOfSeats;
		this.studentList = studentList;
		this.isFull = isFull;
	}

	// getter methods
	public String getCourseNumber() {
		return courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getMeetTime() {
		return meetTime;
	}

	public String getRoom() {
		return room;
	}

	public String getProfessorName() {
		return professorName;
	}

	public int getNumOfStudents() {
		return numOfStudents;
	}

	/*
	public int getNumOfSeats(){
		return numOfSeats;
	}
	*/

	// nested within a for loop that cycles through an array
	// only gets array reference!!!
	public String[] getStudentList() {
		String[] studentListCopy = new String[studentList.length];
		for (int i =0; i < studentList.length; i++){
			studentListCopy[i] = studentList[i];
		}
		return studentListCopy;
	}

	public boolean getIsFull() {
		return isFull;
	}

	// setter methods
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}


	
	public void setStudentList(String[] sl) {
		String[] studentList = new String[sl.length]; 
		for (int i = 0; i < sl.length; i++){
			studentList[i] = sl[i];
			}
	}

	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}

	
	// print method
	public void printAllInformation() {
		System.out.println("Course Number: " + courseNumber);
		System.out.println("Course Name: " + courseName);
		System.out.println("Meet Time: " + meetTime);
		System.out.println("Room: " + room);
		System.out.println("Professor's Name: " + professorName);
		System.out.println("Number of Students Registered: " + numOfStudents);
		// // no need to print the number of seats / max size of class
		// no need to print the list of students
		if (isFull == true)
			System.out.println("Is Class Full?: Yes");
		else
			System.out.println("Is Class Full?: No");
		System.out.println();
	}

}
