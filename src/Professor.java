

public class Professor extends User implements Information, CourseList {

	private String ID;
	private String name;
	private String officeLocation;

	public Professor() {
	}

	public Professor(String username, String password, String ID, String SSN,
			String name, String address, String officeLocation,
			String phoneNumber, String[] courseList) {
		super(username, password, SSN, address, phoneNumber, courseList);
		this.ID = ID;
		this.name = name;
		this.officeLocation = officeLocation;
	}

	public Professor(String ID, String SSN, String name, String address,
			String officeLocation, String phoneNumber, String[] courseList) {
		super(SSN, address, phoneNumber, courseList);
		this.ID = ID;
		this.name = name;
		this.officeLocation = officeLocation;
	}

	public Professor(String name) {
		this.name = name;
	}

	// getters
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	// setters
	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	// prints all information
	public void printAllInformation() {
		// no need to print username & password
		System.out.println("ID:" + ID);
		System.out.println("SSN: " + getSSN());
		System.out.println("Name: " + name);
		System.out.println("Address: " + getAddress());
		System.out.println("Office Location:" + officeLocation);
		System.out.println("Phone:" + getPhoneNumber());
		System.out.println();
	}

	public void printCourses() {
		System.out.println("Teaching following courses: ");
		for (int i = 0; i < getCourseList().length; i++) {
			System.out.println((i + 1) + ": " + getCourseList()[i]);
		}
		System.out.println();
	}

}
