package emailapp;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLengh = 10;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "Company.com";
	
	
	// constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: " + this.firstName  + " " + this.lastName );
		
		// call a method asking for the department = return the department
		this.department = setDepartment();
		
		this.password = randomPassword(defaultPasswordLengh);

		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}
	
	
	// ask for the department
	private String setDepartment() {
	    System.out.println("Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Depertment code: ");
	    Scanner in = new Scanner(System.in);
	    String depChoiceReturn = null;
	    int depChoice = in.nextInt();
	    
	    switch (depChoice) {
	        case 1:
	            depChoiceReturn = "Sales";
	            break;
	        case 2:
	            depChoiceReturn = "Development";
	            break;
	        case 3:
	            depChoiceReturn = "Accounting";
	            break;
	        case 0:
	            // if no department is chosen it will return nothing and closing the form.
	            return "";
	        default:
	            System.out.println("Invalid choice. Please choose a valid department.");
	            // when a number is given that is not listed it will simply request to enter a valid department code.
	            return setDepartment();
	    }
	    
	    return depChoiceReturn;
	}
	// generate a random password and encrypt this
	private String randomPassword(int lenght) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRTSUVW!@#";
		char[] password = new char[lenght];
		for(int i=0; i<lenght; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailBoxCapacity() {
		return mailboxCapacity;
	};
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nYOUR PASSWORD: " + password +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
