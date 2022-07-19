import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

	private String weaponhistoryPath = "src/weaponhistory.txt";
	Path path = Paths.get(weaponhistoryPath);
	public void startNewFile() throws Exception {
		makeHistoryFile();	
	}
	
	/**
	 * Generate weaponhistory.txt if it doesn't exist
	 * Or, overwrite current file if it exists
	 */
	private void makeHistoryFile() throws Exception {
		if(checkForFile(weaponhistoryPath) == true) {
			Files.delete(path);
		}
			
		Scanner userStartingWeapon = new Scanner(System.in);
		int weaponId = -1;
		
		// User input validation to prevent InputMismatchException
		do {
			// Read weaponlist.txt to display options for user
			System.out.println("Choose your starting weapon.");
			File file = new File("src/weaponlist.txt");
			LineNumberReader reader = new LineNumberReader(new FileReader(file));
			String st;
			int lineNumber = 1;
			while((st = reader.readLine()) != null) {
				System.out.println(reader.getLineNumber() + ". " + st);
				lineNumber++;
			}
				
			
			System.out.println("\n");	
			weaponId = userStartingWeapon.nextInt();
			
			// Incorrect input message
			if(weaponId < 1 || weaponId > 14)
				System.out.println("Incorrect input. Please try again.");
		} 
		while(weaponId < 1 || weaponId > 14);

				
		switch(weaponId) {
			case 1:
				updateHistory("Great Sword");
				System.out.println("Great Sword selected.");
				break;
			case 2:
				updateHistory("Long Sword");
				System.out.println("Long Sword selected.");
				break;
			case 3:
				updateHistory("Sword & Shield");
				System.out.println("Sword & Shield selected.");
				break;
			case 4:
				updateHistory("Dual Blades");
				System.out.println("Dual Blades selected.");
				break;
			case 5:
				updateHistory("Lance");
				System.out.println("Lance selected.");
				break;
			case 6:
				updateHistory("Gunlance");
				System.out.println("Gunlance selected.");
				break;
			case 7:
				updateHistory("Hammer");
				System.out.println("Hammer selected.");
				break;
			case 8:
				updateHistory("Hunting Horn");
				System.out.println("Hunting Horn selected.");
				break;
			case 9:
				updateHistory("Sword & Shield");
				System.out.println("Sword & Shield selected.");
				break;
			case 10:
				updateHistory("Charge Blade");
				System.out.println("Charge Bladeselected.");
				break;
			case 11:
				updateHistory("Insect Glaive");
				System.out.println("Insect Glaive selected.");
				break;
			case 12:
				updateHistory("Light Bowgun");
				System.out.println("Light Bowngun selected.");
				break;
			case 13:
				updateHistory("Heavy Bowgun");
				System.out.println("Heavy Bowgun selected.");
				break;
			case 14:
				updateHistory("Bow");
				System.out.println("Bow selected.");
				break;
			default:
				break;
		}
	}

	
	/**
	 * Update weaponhistory.txt with the assumption it exists
	 */
	public void updateHistory(String weaponName) throws Exception{
		File history = new File(weaponhistoryPath);

		// Create weapon txt file and add first weapon
		// Else, update file
		if(history.createNewFile()) {
			LineNumberReader reader = new LineNumberReader(new FileReader(weaponhistoryPath));
			BufferedWriter output = new BufferedWriter(new FileWriter(weaponhistoryPath));
			output.write((reader.getLineNumber() + 1) + ". " + weaponName);
			output.flush();
			output.close();
		} else {
			LineNumberReader reader = new LineNumberReader(new FileReader(weaponhistoryPath));
			BufferedWriter output = new BufferedWriter(new FileWriter(weaponhistoryPath,true));
			output.newLine();
			output.write((reader.getLineNumber() + 1) + ". " + weaponName);
			output.flush();
			output.close();
		}
	}
	
	
	
	/**
	 * Check if specific file exists
	 * @return true if the file exists; false otherwise
	 */
	private Boolean checkForFile(String filePath) throws Exception {
		File tempFile = new File(filePath);
		return (tempFile.exists());
	}
}