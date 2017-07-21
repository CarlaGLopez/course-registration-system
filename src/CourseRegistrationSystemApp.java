import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class CourseRegistrationSystemApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		CourseRegistrationSystem system1 = new CourseRegistrationSystem();

		int choice = 0;
		String line;
		int wordCount;

		Admin admin;

		// ask user if they are a student, professor, or admin
		while (choice != 4) {
			System.out.println("Please enter the number corresponding to whether you are an admin, professor, "
					+ "or student:");
			System.out.println("1. Admin");
			System.out.println("2. Professor");
			System.out.println("3. Student");
			System.out.println("4. EXIT COURSE REGISTRATION SYSTEM");
			choice = input.nextInt();
			input.nextLine(); // consume new-line
			System.out.println();

			switch (choice) {
			case 1: // ADMIN

				String adminUsername = "";
				String adminPassword = "";
				String adminFileName = "admin.txt";
				line = null;
				wordCount = 0;

				System.out.println("Logging in as Admin...");
				System.out.println("Reading username and password from file..");

				// read username and password from file
				try {

					FileReader fileReader1 = new FileReader(adminFileName);
					BufferedReader bufferedReader = new BufferedReader(fileReader1);

					while ((line = bufferedReader.readLine()) != null) {
						// Tokenizer splits the words separated by "," in the
						// file into different lines
						StringTokenizer st = new StringTokenizer(line, ",");
						while (st.hasMoreTokens()) {
							wordCount ++;
							if (wordCount == 1)
								adminUsername = st.nextToken();
							else if (wordCount == 2)
								adminPassword = st.nextToken();
						}
					}
					// save username and password to admin object
					admin = new Admin(adminUsername, adminPassword);
					System.out.println("Admin username: " + admin.getUsername());
					System.out.println("Admin password: " + admin.getPassword());
					System.out.println("Log In Successful!");
					bufferedReader.close();
					
				} catch (FileNotFoundException ex) {
					System.out.println("Unable to open file '" + adminFileName + "'");
					
				} catch (IOException ex) {
					System.out.println("Can't read file");
				}
				System.out.println();

				// activate admin main menu method
				system1.adminMainMenu();

				break;

			case 2: // PROFESSOR
				
				String profFileName = "prof.txt";
				int lineCountProfessorFile = 0;
				
				//login
				System.out.println("Please input your username: ");
				String profUsername = input.nextLine();
				System.out.println("Please input your password:");
				String profPassword = input.nextLine();
				
				// save username and password to file
				try{

					FileWriter fileWriter1 = new FileWriter(profFileName);
					BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
					
					bufferedWriter1.write(profUsername+" "+profPassword);
					bufferedWriter1.newLine();
					lineCountProfessorFile++;

					//Always close files
					bufferedWriter1.close();
					
				} catch (IOException ex) {
					System.out.println("Error writing to file '"+profFileName+"' ");
				}

				// activate professor menu method;
				system1.profMainMenu();
				break;

			case 3: // STUDENT
				
				String studentFileName = "student.txt";
				int lineCountStudentFile = 0;
				wordCount = 0;
				
				// login
				System.out.println("Please input your username: ");
				String studentUsername = input.nextLine();
				System.out.println("Please input your password:");
				String studentPassword = input.nextLine();				
				
				// save username and password to file
				try{

					FileWriter fileWriter2 = new FileWriter(studentFileName);
					BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
					
					bufferedWriter2.write(studentUsername+" "+studentPassword);
					bufferedWriter2.newLine();
					lineCountStudentFile++;

					//Always close files
					bufferedWriter2.close();
					
				} catch (IOException ex) {
					System.out.println("Error writing to file '"+studentFileName+"' ");

				}

				
				

				// activate student menu method;
				system1.studentMainMenu();
				break;

			case 4: // QUIT
				System.out.println("Thank you for using the Course Registration System.");
				break;

			default: // INVALID CHOICE
				System.out.println("Not a valid choice.");
				System.out.println();
				break;
			}
		} // end of while loop

	}

}

