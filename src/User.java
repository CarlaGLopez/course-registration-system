//abstract class
//parent class for Professor, Student, and Admin 

public abstract class User {

	private String username;
	private String password;
	private String SSN;
	private String address;
	private String phoneNumber;
	private String[] courseList;

	// NOTE: the constructor in the abstract class is defined as protected,
	// because it is be accessed by subclasses in different packages.
	// When you create an instance of a concrete subclass, its superclass’s
	// constructor is invoked to initialize data
	// fields defined in the superclass
	protected User() {
	}

	protected User(String username, String password, String SSN,
			String address, String phoneNumber, String[] courseList) {
		this.username = username;
		this.password = password;
		this.SSN = SSN;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.courseList = courseList;
	}

	protected User(String SSN, String address, String phoneNumber,
			String[] courseList) {
		this.SSN = SSN;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.courseList = courseList;
	}

	protected User(String un, String pw) {
		username = un;
		password = pw;
	}

	// getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getSSN() {
		return SSN;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String[] getCourseList() {
		String[] courseListCopy = new String[courseList.length];
		for (int i =0; i < courseList.length; i++){
			courseListCopy[i] = courseList[i];
		}
		return courseListCopy;  //sending a reference!!!!!!
		//good practice to copy the array so you don't modify this class's array
	}

	// setters
	public void setUsername(String un) {
		username = un;
	}

	public void setPassword(String pw) {
		password = pw;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String pn) {
		phoneNumber = pn;
	}

	public void setCourseList(String[] cl) {
		String[] courseList = new String[cl.length]; 
		for (int i = 0; i < cl.length; i++){
			courseList[i] = cl[i];
		}

	}
}
