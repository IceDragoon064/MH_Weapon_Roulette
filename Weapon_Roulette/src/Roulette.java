import java.util.Random;
import java.util.Scanner;
public class Roulette{
	
	private int minRoll = 0;
	private int maxRoll = 14;
	private FileManager fileManager = new FileManager();
	public void menu() throws Exception {
		System.out.println("-----------------------------------------------");
		System.out.println("|       Choose the following options:         |");
		System.out.println("-----------------------------------------------");
		System.out.println("| 1. Start a new file.                        |");
		System.out.println("| 2. Continue your last progress              |");
		System.out.println("| 0. End this program.                        |");
		System.out.println("-----------------------------------------------");
		
		
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
				spinRoulette();
				break;
			case 2:
				System.out.println("Resuming your progress....");
				if(fileManager.checkFiles() == true) {
					System.out.println("Your last weapon used is" + fileManager.readHistoryFile());
					spinRoulette();
				}
				break;
			case 0:
				System.out.println("Exiting program. Have a good day.");
				System.exit(0);
		}
	}
	
	public void spinRoulette() throws Exception {
		System.out.println("\n\n");
		while(true) {
			System.out.println("Ready to roll?\nInput 1 when you are ready.");
			Scanner userReady = new Scanner(System.in);
			int readyInt = -1;
			int index = -1;
			do {
				readyInt = userReady.nextInt();
			} 
			while(readyInt != 1);
			
			// Keep rolling until a new weapon is chosen
			while(true) {
				Random rand = new Random();
				index = rand.nextInt(maxRoll - minRoll) + minRoll;
				System.out.println(index);
				if(fileManager.checkRoll(index) == false) {
					System.out.println("Rolled a " + index);
					System.out.println("Your weapon is the " + fileManager.getWeaponById(index));
					fileManager.newRoll(index);
					break;
				}
			}
		}
	}
}


