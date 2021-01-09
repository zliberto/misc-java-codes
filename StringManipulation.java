import java.util.*;

public class M1 {

	Scanner scan = new Scanner(System.in);
	String fullName, firstName, lastName;
	
	public static void main(String[] args) {
		
		M1 object = new M1();
		object.fullName = object.getName();
		object.splitName(object.fullName);
		object.checkCapitalization(object.firstName, object.lastName);
		System.out.println("Your name is " + object.firstName + " " + object.lastName);
		
		

	}
	
	String getName() {
		
		System.out.println("Please type in your name in the following format: Firstname Lastname");
		fullName = scan.nextLine();
		return fullName;
		
	}
	
	void splitName(String name) {
		
		int index = name.indexOf(" ");
		firstName = name.substring(0,index);
		lastName = name.substring(index+1);
		
	}
	
	void checkCapitalization (String first, String last) {
		
		char firstCharF = first.charAt(0);
		char firstCharL = last.charAt(0);
		
		if (Character.isLowerCase(firstCharF)) {
			
			firstName = Character.toUpperCase(firstCharF) + firstName.substring(1);
			
		}
		
		if (Character.isLowerCase(firstCharL)) {
			lastName = Character.toUpperCase(firstCharL) + lastName.substring(1);
		}
			
		}
	

}
