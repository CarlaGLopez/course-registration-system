//DEBUGGING:
import java.io.*;
import java.util.StringTokenizer;

public class Admin extends User {

	public Admin() {
	}

	public Admin(String un, String pw) {
		super(un, pw);
	}

	/*
	 * DEBUGGING: public void readUsernamePassword(String fileName){ try {
	 * 
	 * String line = null; int wordCount = 0;
	 * 
	 * //FileReader reads text files in the default encoding FileReader
	 * fileReader = new FileReader(fileName);
	 * 
	 * //recommended to wrap FileReader in BufferedReader BufferedReader
	 * bufferedReader = new BufferedReader(fileReader);
	 * 
	 * 
	 * while ( (line = bufferedReader.readLine() ) != null) { //Tokenizer splits
	 * the words separated by "," in files into different lines StringTokenizer
	 * st = new StringTokenizer(line, ","); while (st.hasMoreTokens()) {
	 * System.out.println(st.nextToken()); wordCount++; if (wordCount == 1)
	 * username = st.nextToken(); else if (wordCount == 2) password =
	 * st.nextToken(); } } //always close files bufferedReader.close(); }
	 * 
	 * catch (FileNotFoundException ex){
	 * System.out.println("Unable to open file '" + fileName + "'");
	 * 
	 * }
	 * 
	 * catch(IOException ex) { System.out.println("Can't read file");
	 * 
	 * } }
	 */
}
