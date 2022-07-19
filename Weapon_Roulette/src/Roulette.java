import java.util.Scanner;
public class Roulette{
	
	public void menu() throws Exception {
		System.out.println("-----------------------------------------------");
		System.out.println("|       Choose the following options:         |");
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. Start a new file.                        |");
		System.out.println("| 2. Continue your last progress              |");
		System.out.println("| 3. How to use this program                  |");
		System.out.println("| 0. End this program.                        |");
		System.out.println("-----------------------------------------------");
		
		FileManager fileManager = new FileManager();
		Scanner userInput = new Scanner(System.in);
		int userSelection = -1;
		do {
			userSelection = userInput.nextInt();
			System.out.println("Your input: " + userSelection);
		}
		while(userSelection < 0 || userSelection > 3);

		switch(userSelection) {
			case 1: 
				System.out.println("You've chosen to start a new file.");
				fileManager.startNewFile();
				break;
			case 2:
				System.out.println("You are resuming your progress.");
				
				break;
			case 3:
				System.out.println("Displaying instructions.");
				break;
			case 0:
				System.out.println("Exiting program. Have a good day.");
				System.exit(0);
		}
	}
}


