import java.util.Scanner;

public class SecretMessages {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char cont;
		do {
			runDecoder(scan);
			System.out.println("Encode another Message? (Y/N) ");
			cont = scan.nextLine().charAt(0);
		} while (cont != 'n' && cont != 'N');
		System.out.println("Goodbye!");
		scan.close();
	}

	private static void runDecoder(Scanner scan) {
		System.out.println("Enter a message to encode or decode");
		String message = scan.nextLine();
		String output = "";
		int keyVal;
		do {
			System.out.println("Enter a secret key (-25 to 25): ");
			try {
				keyVal = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				keyVal = 200;
			}
			if (keyVal < -25 || keyVal > 25)
				System.out.println("Invalid key value");
		} while (keyVal < -25 || keyVal > 25);
		
		char key = (char) (keyVal);
		
		for (int x = 0; x < message.length(); x++) {
			char input = message.charAt(x);
			if (input >= 'A' && input <= 'Z') {
				input += key;
				if (input > 'Z')
					input -= 26;
				if (input < 'A')
					input += 26;
			} else if (input >= 'a' && input <= 'z') {
				input += key;
				if (input > 'z')
					input -= 26;
				if (input < 'a')
					input += 26;
			} else if (input >= '0' && input <= '9') {
				input += (keyVal % 10);
				if (input < '0')
					input += (keyVal % 10);
				if (input > '9')
					input -= (keyVal % 100);
			}
			
			output += input;
		}
		
		System.out.println(output);
	}

}
