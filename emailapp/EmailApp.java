package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// file name + the name you want to give it + the strings you want to feed into the public function into email
		Email test = new Email("john", "Doe");
		System.out.println(test.showInfo());
	}

}
