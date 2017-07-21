import java.util.Scanner;
import java.util.ArrayList;



public class CourseRegistrationSystem {

	private Scanner input = new Scanner(System.in);

	// default constructor
	public CourseRegistrationSystem() {
	}

	// create array lists to hold list of Courses, Students, and Professors separately
	private ArrayList<Course> listOfAllCourses = new ArrayList<Course>();
	private ArrayList<Student> listOfAllStudents = new ArrayList<Student>();
	private ArrayList<Professor> listOfAllProfessors = new ArrayList<Professor>();

	// initialize admin object;
	Admin admin;
	
// Admin Main Menu method
	public void adminMainMenu() {
		int selection = 0;
		while (selection != 4) {
			System.out.println("Admin Main Menu:");
			System.out.println("1. Course Affairs");
			System.out.println("2. Student Affairs");
			System.out.println("3. Professor Affiars");
			System.out.println("4. LOGOUT");
			System.out.print("Enter the number of your selection: ");
			selection = input.nextInt();
			System.out.println();

			switch (selection) {
			case 1: // activate Admin's Course Affairs Menu
				adminCourseAffairsMenu();
				break;
			case 2:
				// activate Admin's Student Affairs Menu
				adminStudentAffairsMenu();
				break;
			case 3:
				// activate Admin's Professor Affairs Menu
				
				break;
			case 4:
				System.out.println("Admin Logged Out");
				System.out.println();
				break;
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}

	
	//Admin's Course Affairs Menu
	public void adminCourseAffairsMenu() {
		int option = 0;
		while (option != 5) {
			System.out.println("Course Affairs:");
			System.out.println("1. Add a Course");
			System.out.println("2. Remove a Course");
			System.out.println("3. Display all Courses");
			System.out.println("4. Display all Courses that are full");
			System.out.println("5. BACK TO MAIN MENU");
			System.out.print("Enter the number of your selection: ");
			option = input.nextInt();
			System.out.println();
			// IMPORTANT NOTE: The Scanner nextInt method does not consume the last newline character of your input,
			//  so since that newline is consumed in the next call to Scanner#nextLine, put a blank Scanner nextLine
			//  before hand to consume the rest of the newline
			input.nextLine();  // consume newline
			
			switch (option) {
			case 1: // activate addCourse method
				addCourse();
				break;
			case 2: // activate removeCourse method
				removeCourse();
				break;
			case 3: // print arrayList of courses
				printAllCourses();
				break;
			case 4: // Display all Courses that are full
				printFullCourses();
				break;
			case 5:
				System.out.println();
				break;
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}
	
	// Course Affairs SubMenu: addCourse
	public void addCourse() {
		// public Course(String courseNumber, String courseName, String meetTime, String room, String professorName,
		//  int numOfStudents, String[] studentList, boolean isFull){
		String cNum;
		String cName;
		String mT;
		String rm;
		String profName;
		int numStud;
		String[] studList;
		boolean isFull = false;

		String answer = "n";  //??
		Course tempCourse;

		System.out.println("Enter the following information about the course to be added");
		System.out.println("Course Number: ");
		cNum = input.nextLine();
		
		System.out.println("Course Name: ");
		cName = input.nextLine();

		System.out.println("Meet Time: ");
		mT = input.nextLine();

		System.out.println("Room: ");
		rm = input.nextLine();

		System.out.println("Professor's Last Name: ");
		profName = input.nextLine();
		//listOfAllProfessors.add(new Professor(profName)); 

		System.out.println("Number of Students: ");
		numStud = input.nextInt();
		input.nextLine(); // Consume new-line leftover

		//DEBUGGING:??????
		System.out.println("Enter the Student ID Number of Each Student in the Class: ");
		studList = new String[numStud];
		for (int i = 0; i < numStud; i++) {
			studList[i] = input.nextLine();
			listOfAllStudents.add(new Student(studList[i])); //students could be repeated in listOfAllStudents
		}

		System.out.println("Is the class full? Y or N?");
		answer = input.nextLine();
		if (answer.equalsIgnoreCase("Y")) {
			isFull = true;
		} else if (answer.equalsIgnoreCase("N")) {
			isFull = false;
		}
		System.out.println();

		// use constructor to add the course into Course ArrayList
		// DEBUGGING: isFull may cause problems. check initialization and etc.
		tempCourse = new Course(cNum, cName, mT, rm, profName, numStud, studList, isFull);
		listOfAllCourses.add(tempCourse);
		System.out.println("Course Added!");
		System.out.println();
	}

	
	// Course Affairs SubMenu: removeCourse()
	public void removeCourse() {
		String courseName;
		System.out.println("Enter the name of the Course to be deleted: ");
		courseName = input.nextLine();
		for (int i = 0; i < listOfAllCourses.size(); i++) {
			if (courseName.equalsIgnoreCase(listOfAllCourses.get(i).getCourseName())) {
				listOfAllCourses.remove(i);
			}
		}
		System.out.println("Course Removed!");
		System.out.println();
		// DIDN'T DO:
		// if teacher is teaching deleted course, make a new array that doesn't have that course
		// if student is registered in deleted course, make a new array that doesn't have that course
	}

	
	// Course Affairs SubMenu: printAllCourses()
	public void printAllCourses() {
		Course tempCourse;
		for (int i = 0; i < listOfAllCourses.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			tempCourse = listOfAllCourses.get(i);
			tempCourse.printAllInformation();
		}
	}

	
	// Course Affairs SubMenu: printFullCourses() 
	public void printFullCourses() {
		Course tempCourse;
		int count = 0;
		for (int i = 0; i < listOfAllCourses.size(); i++) {
			tempCourse = listOfAllCourses.get(i);
			if (tempCourse.getIsFull() == true) {
				System.out.println("(" + (count++) + ")");
				tempCourse.printAllInformation();
			}
		}
	}

	//Admin's Student Affairs Menu:
	public void adminStudentAffairsMenu() {
		int option = 0;
		while (option != 8) {
			System.out.println("Student Affairs:");
			System.out.println("1. Add a Student");
			System.out.println("2. Remove a Student");
			System.out.println("3. Edit Student");
			System.out.println("4. Display all Courses");
			System.out.println("5. Display all Students");
			System.out.println("6. Register course(s) for a student");
			System.out.println("7. Display course(s) taken by a student");
			System.out.println("8. BACK TO MAIN MENU");
			System.out.print("Enter the number of your selection: ");
			option = input.nextInt();
			input.nextLine(); // consume new-line leftover
			System.out.println();

			switch (option) {
			case 1: // activate addStudent method
				addStudent();
				break;
			case 2: // activate removeStudent method
				removeStudent();
				break;
			case 3: // activate editStudent method //can also register for courses here
				editStudent();
				break;
			case 4: // activate printAllCourses method
				printAllCourses();
				break;
			case 5: // activate printAllStudents method
				printAllStudents();
				break;
			case 6: // activate registerStudentForCourses method
				registerStudentForCourses();
				break;
			case 7: // activate printCoursesOfStudent method
				printCoursesOfStudent();
				break;
			case 8:
				System.out.println();
				break;
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}

	// Student Affairs SubMenu: addStudent()
	public void addStudent() {
		String un = "";
		String pw = "";
		String sNum;
		String SSN;
		String address;
		String phoneNum;
		String DOB;
		String major;
		String gpa;
		String[] courseList;
		Student tempStudent;
		
		System.out.println("Enter in the student's username: ");
		un = input.nextLine();
		
		System.out.println("Enter in the student's password: ");
		pw = input.nextLine();
		
		System.out.println("Enter student's number: ");
		sNum = input.nextLine();
		
		System.out.println("Enter student's SSN: ");
		SSN = input.nextLine();
		
		System.out.println("Enter student's address: ");
		address = input.nextLine();
		
		System.out.println("Enter student's phone number: ");
		phoneNum = input.nextLine();
		
		System.out.println("Enter student's date of birth: ");
		DOB = input.nextLine();
		
		System.out.println("Enter student's major: ");
		major = input.nextLine();
		
		System.out.println("Enter student's GPA: ");
		gpa = input.nextLine();
		
		//not registering for any classes...that is done in case 6 of the menu
		courseList = new String[5];
		for (int i = 0; i < 5; i++){
			courseList[i] = "";       //blank array
		}
		
		//make new Student object and add to array list of Students
		tempStudent = new Student(un, pw, sNum, SSN, address, phoneNum, DOB, major, gpa, courseList);
		listOfAllStudents.add(tempStudent);
		System.out.println("Student Added!");
		System.out.println();	
	}

	// Student Affairs SubMenu: removeStudent()
	public void removeStudent() {
		String studentNum;
		System.out.println("Enter the Student's number to remove the student: ");
		studentNum = input.nextLine();
		for (int i = 0; i < listOfAllStudents.size(); i++) {
			if (studentNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				listOfAllStudents.remove(i);
			}
		}
		System.out.println();
		System.out.println("Student Removed!");
		System.out.println();
		// DIDN'T DO:
		// if student is enrolled in courses, make a new student array that doesn't have that student
		// if student is a part of a professor's array of students , make a new array that doesn't have that student
	}

	
	// Student Affairs SubMenu: editStudent()
	public void editStudent() {
		String sNum;  
		int attribute; 
		String change;
		Student tempStudent;
		
		System.out.println("Enter the Student's number to edit the student: ");
		sNum = input.nextLine(); 
		
		//Alternative way to do this using Array List methods?..
		for (int i=0; i < listOfAllStudents.size(); i++){
			if (sNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				tempStudent = listOfAllStudents.get(i);
				
				//ask user what attribute of the student they would like to change
				System.out.println("What information of this student would you like to change?");
				System.out.println("1. Student Number");
				System.out.println("2. SSN");
				System.out.println("3. address");
				System.out.println("4. phone number");
				System.out.println("5. date of birth");
				System.out.println("6. major");
				System.out.println("7. GPA");		
				//have user enter attribute that he wants to change 		
				attribute = input.nextInt(); 	
				input.nextLine();  //consume new-line
					
				//DEBUGGIN STARTS HERE
				//depending on user's chosen attribute execute the following: 
				switch (attribute) {
				case 1:
					System.out.println("What is the new Student number?");
					change = input.nextLine();  
					tempStudent.setStudentNumber(change);
					break; 
				case 2:
					System.out.println("What is the new SSN?");
					change = input.nextLine(); 
					tempStudent.setSSN(change);
					break; 
				case 3:
					System.out.println("What is the student's new address?");
					change = input.nextLine(); 
					tempStudent.setAddress(change);
					break; 
				case 4:
					System.out.println("What is the student's new phone number?");
					change = input.nextLine(); 
					tempStudent.setPhoneNumber(change);
					break; 
				case 5:
					System.out.println("What is the student's new date of birth?");
					change = input.nextLine(); 
					tempStudent.setDateOfBirth(change);
					break; 
				case 6: 
					System.out.println("What is the student's new major?");
					change = input.nextLine();
					tempStudent.setMajor(change);
				case 7: 
					System.out.println("What is the student's new GPA?");
					change = input.nextLine();
					tempStudent.setGPA(change);
				default: 
					System.out.println("Incorrect value!");
					System.out.println();
					break;
				}
				System.out.println(); 
			}
		}
	}

	
	// Student Affairs SubMenu: printAllStudents
	public void printAllStudents() {
		Student tempStudent;
		for (int i = 0; i < listOfAllStudents.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			tempStudent = listOfAllStudents.get(i);
			tempStudent.printAllInformation();
			System.out.println();
		}
	}


	// Student Affairs SubMenu: registerStudentForCourses
	public void registerStudentForCourses() {
		String studentNum;
		Student tempStudent;
		int numOfCourses;
		String[] tempCourseList;
		
		System.out.println("Enter the student number of the student who you wish to register for classes: ");
		studentNum = input.nextLine();
		
		for (int i=0; i < listOfAllStudents.size(); i++){
			if (studentNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				tempStudent = listOfAllStudents.get(i);
		
				//prompt user to specify how many courses the student is going to register for
				System.out.println("How many courses will the student be taking?");
				numOfCourses = input.nextInt();
				input.nextLine();  //consume new-line
				
				//create an array to hold the courses the student is taking
				tempCourseList = new String[numOfCourses];
				for (int j = 0; j < numOfCourses; j++){
					tempCourseList[i] = input.nextLine();
				}
				tempStudent.setCourseList(tempCourseList);
				System.out.println("Student registered for classes");	
			}
		}
	}


	// Student Affairs SubMenu: printCoursesOfStudent
	// reused for Student's Main Menu:
	public void printCoursesOfStudent() {
		Student tempStudent;
		System.out.print("Enter the student number of the student whose course list you want to see: ");
		String studentNum = input.nextLine();
		System.out.println();
		
		for (int i=0; i < listOfAllStudents.size(); i++){
			if (studentNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				System.out.println("(" + (i + 1) + ")");
				tempStudent = listOfAllStudents.get(i);
				tempStudent.printCourses();
				System.out.println();
			}
		}	
	}
	
	//Admin's Professor Affairs Menu:
	public void adminProfAffairsMenu() {
		int option = 0;
		while (option != 8) {
			System.out.println("Professor Affairs:");
			System.out.println("1. Add a Professor");
			System.out.println("2. Remove a Professor");
			System.out.println("3. Display All Professors");
			System.out.println("4. BACK TO MAIN MENU");
			System.out.print("Enter the number of your selection: ");
			option = input.nextInt();
			input.nextLine(); // consume new-line leftover
			System.out.println();

			switch (option) {
			case 1: // activate addProfessor method
				addProfessor();
				break;
			case 2: // activate removeProfessor method
				removeProfessor();
				break;
			case 3: // activate editStudent method //can also register for courses here
				printAllProfessors();
				break;
			case 4:
				System.out.println();
				break;
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}
	
	public void addProfessor(){
		String un = "";
		String pw = "";
		String ID;
		String SSN;
		String name;
		String address;
		String officeLocation;
		String phoneNum;
		String[] studentList;
		Professor tempProf;
		
		System.out.println("Enter in the professor's username: ");
		un = input.nextLine();
		
		System.out.println("Enter in the professor's password: ");
		pw = input.nextLine();
		
		System.out.println("Enter professor's ID: ");
		ID = input.nextLine();
		
		System.out.println("Enter professor's SSN: ");
		SSN = input.nextLine();
		
		System.out.println("Enter professor's name: ");
		name = input.nextLine();
		
		System.out.println("Enter professor's address: ");
		address = input.nextLine();
		
		System.out.println("Enter professor's office location: ");
		officeLocation = input.nextLine();
		
		System.out.println("Enter professor's phone number: ");
		phoneNum = input.nextLine();

		
		//not registering for any classes...that is done in case 6 of the menu
		studentList = new String[5];
		for (int i = 0; i < 5; i++){
			studentList[i] = "";       //blank array
		}
		
		//make new Student object and add to array list of Students
		tempProf = new Professor(un, pw, ID, SSN, name, address, officeLocation, phoneNum, studentList);
		listOfAllProfessors.add(tempProf);
		System.out.println("Professor Added!");
		System.out.println();			
	}
	

	public void removeProfessor() {
		String name;
		System.out.println("Enter the Professor's name to remove the professor: ");
		name = input.nextLine();
		for (int i = 0; i < listOfAllProfessors.size(); i++) {
			if (name.equalsIgnoreCase(listOfAllProfessors.get(i).getName())) {
				listOfAllProfessors.remove(i);
			}
		}
		System.out.println();
		System.out.println("Professor Removed!");
		System.out.println();
	}
	
	public void printAllProfessors() {
		Professor tempProf;
		for (int i = 0; i < listOfAllProfessors.size(); i++) {
			System.out.println("(" + (i + 1) + ")");
			tempProf = listOfAllProfessors.get(i);
			tempProf.printAllInformation();
			System.out.println();
		}
	}
	
	
	
//Professor's Main Menu Method
	public void profMainMenu(){
		int selection = 0;
		while (selection != 4) {
			System.out.println("Prof Main Menu:");
			System.out.println("1. View All Courses");
			System.out.println("2. View All Students");
			System.out.println("3. Change Username");
			System.out.println("4. LOGOUT");
			System.out.println("Enter the number of your selection: ");
			selection = input.nextInt();
			input.nextLine();  //consume new-line
			System.out.println();

			switch (selection) {
			case 1: // activate printAllCoursesMethod
				printCoursesOfProfessor();
				break;
			case 2: //viewAllStudents method
				printStudentsOfProfessor();
				break;
			case 3: // change password
				setProfPassword();
				break;
			case 4: //change username
				setProfUsername();
				break;
			case 5: 
				System.out.println("Logging Out...");
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}
	
	public void printCoursesOfProfessor() {
		Professor tempProf;
		System.out.print("Enter the professor's name whose student list you want to see: ");
		String profName = input.nextLine();
		System.out.println();
		
		for (int i=0; i < listOfAllProfessors.size(); i++){
			if (profName.equalsIgnoreCase(listOfAllProfessors.get(i).getName())) {
				System.out.println("(" + (i + 1) + ")");
				tempProf = listOfAllProfessors.get(i);
				tempProf.printCourses();
				System.out.println();
			}
		}	
	}
	
	
	public void printStudentsOfProfessor(){
		Course tempCourse;
		System.out.print("Enter the professor's name whose student list you want to see: ");
		String profName = input.nextLine();
		System.out.println();
		
		for (int i=0; i < listOfAllCourses.size(); i++){
			if (profName.equalsIgnoreCase(listOfAllCourses.get(i).getProfessorName())) {
				System.out.println("(" + (i + 1) + ")");
				tempCourse = listOfAllCourses.get(i);
				System.out.println(tempCourse.getStudentList());
				System.out.println();
			}
		}	
	}
	
	// change professor's password
	public void setProfPassword(){
		Professor tempProf;
		System.out.print("Enter the professor's name:");
		String name = input.nextLine();
		System.out.println();
		
		System.out.println("Enter new password:");
		String pw = input.nextLine();
		
		for (int i=0; i < listOfAllProfessors.size(); i++){
			if (name.equalsIgnoreCase(listOfAllProfessors.get(i).getName())) {
				tempProf = listOfAllProfessors.get(i);
				tempProf.setPassword(pw);
				System.out.println();
			}
		}
		System.out.println("Password changed!");
		System.out.println();
	}
	
	//change username
	public void setProfUsername(){
		Professor tempProf;
		System.out.print("Enter the professor's name:");
		String name = input.nextLine();
		System.out.println();
		
		System.out.println("Enter new username:");
		String un = input.nextLine();
		
		for (int i=0; i < listOfAllProfessors.size(); i++){
			if (name.equalsIgnoreCase(listOfAllProfessors.get(i).getName())) {
				tempProf = listOfAllProfessors.get(i);
				tempProf.setUsername(un);
				System.out.println();
			}
		}
		System.out.println("Username changed!");
		System.out.println();
	}
	
	
//Student's Main Menu Method
	public void studentMainMenu(){
		int selection = 0;
		while (selection != 4) {
			System.out.println("Student Main Menu:");
			System.out.println("1. View All Courses");
			System.out.println("2. View All Courses Student is Registered in");
			System.out.println("3. Change Password");
			System.out.println("4. Change Username");
			System.out.println("5. LOGOUT" );
			System.out.println("Enter the number of your selection: ");
			selection = input.nextInt();
			input.nextLine();  //consume new-line
			System.out.println();

			switch (selection) {
			case 1: // printCourseArrayList
				printAllCourses();
				break;
			case 2: //printCoursesOfStudent
				printCoursesOfStudent();
				break;
			case 3: // change password
				setStudentPassword();
				break;
			case 4: //change username
				setStudentUsername();
				break;
			case 5:
				System.out.println("Logging Out..");
				break;
			default:
				System.out.println("Invalid selection!");
				System.out.println();
			}
		}
	}
	
	public void setStudentPassword(){
		Student tempStudent;
		System.out.print("Enter the student number of the student whose password is to be changed:");
		String studentNum = input.nextLine();
		System.out.println();
		
		System.out.println("Enter new password:");
		String pw = input.nextLine();
		
		for (int i=0; i < listOfAllStudents.size(); i++){
			if (studentNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				tempStudent = listOfAllStudents.get(i);
				tempStudent.setPassword(pw);
				System.out.println();
			}
		}
		System.out.println("Password changed!");
		System.out.println();
	}
	
	
	public void setStudentUsername(){
		Student tempStudent;
		System.out.print("Enter the student number of the student whose username is to be changed:");
		String studentNum = input.nextLine();
		System.out.println();
		
		System.out.println("Enter new username:");
		String un = input.nextLine();
		
		for (int i=0; i < listOfAllStudents.size(); i++){
			if (studentNum.equalsIgnoreCase(listOfAllStudents.get(i).getStudentNumber())) {
				tempStudent = listOfAllStudents.get(i);
				tempStudent.setUsername(un);
				System.out.println();
			}
		}
		System.out.println("Username changed!");
		System.out.println();
	}

	
	// CLOSE SCANNER PLEASE
	

}
