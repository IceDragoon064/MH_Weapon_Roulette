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
		WeaponList list = new WeaponList();
		String[] weaponList = list.getList();
		// User input validation to prevent InputMismatchException
		do {
			// Read weaponlist.txt to display options for user
			System.out.println("Choose your starting weapon.");

			for(int i = 0; i < weaponList.length; i++) {
				System.out.println((i+1) + ". " + weaponList[i]);
			}
			weaponId = userStartingWeapon.nextInt();
			
			// Incorrect input message
			if(weaponId < 1 || weaponId > 14)
				System.out.println("Incorrect input. Please try again.");
		} 
		while(weaponId < 1 || weaponId > 14);
		System.out.println("You've chosen " + weaponList[weaponId - 1]);
		updateHistory(weaponList[weaponId - 1]);

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
			reader.close();
		} else {
			LineNumberReader reader = new LineNumberReader(new FileReader(weaponhistoryPath));
			BufferedWriter output = new BufferedWriter(new FileWriter(weaponhistoryPath,true));
			output.newLine();
			output.write((reader.getLineNumber() + 1) + ". " + weaponName);
			output.flush();
			output.close();
			reader.close();
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