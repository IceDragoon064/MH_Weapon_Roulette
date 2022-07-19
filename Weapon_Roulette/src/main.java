import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leon Lu
 * @version 18 July 2022
 * This code's will select an element from a given string array
 */
public class Main{
	
	public static void main(String[] args) throws Exception {

		System.out.println("-----------------------------------------------------");
		System.out.println("|    Welcome to Monster Hunter Weapon Roulette      |");
		System.out.println("|              Made by Syrus Cosplay                |");
		System.out.println("-----------------------------------------------------\n\n");
		
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("|       Choose the following options:         |");
			System.out.println("-----------------------------------------------");
			System.out.println("| 1. Start a new file.                        |");
			System.out.println("| 2. Continue your last progress              |");
			System.out.println("| 3. How to use this program                  |");
			System.out.println("| 0. End this program.                        |");
			System.out.println("-----------------------------------------------");
			
			Scanner userInput = new Scanner(System.in);
			int userSelection = -1;
			try {
				userSelection = userInput.nextInt();
				System.out.println("Your input: " + userSelection);
			}
			catch(InputMismatchException ex) {
				System.out.println("Your input is invalid, please try again.\n\n");
			}
			
			switch(userSelection) {
				case 1: 
					System.out.println("You've chosen to start a new file.");
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
}

