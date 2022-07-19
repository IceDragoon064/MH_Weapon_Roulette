import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

	private String historyLink = "src/weaponhistory.txt";
	private String statLink = "src/weaponstat.txt";
	
	Path historyPath = Paths.get(historyLink);
	Path statPath = Paths.get(statLink);
	
	WeaponList weaponList = new WeaponList();
	String[] wList = weaponList.getList();
	
	/**
	 * Method to start a new roulette session
	 * @throws Exception
	 */
	public void startNewFile() throws Exception {
		makeHistoryFile();	
	}
	
	/**
	 * Method to check for files before resuming
	 * @throws Exception
	 */
	public void resumeRoulette() throws Exception {
		boolean historyFound = checkForFile(historyLink);
		boolean statFound = checkForFile(statLink);
		
		// All files found and the program will resuming
		if(historyFound == true && statFound == true) {
			System.out.println("All files found!");
		}
		
		// A file is missing!
		else {
			System.out.println("A file is missing!");
		}
	}
	
	
	/**
	 * Method to generate a new weapon history file
	 * If a history file exists, delete it
	 * Then, generate a new file
	 */
	public void makeHistoryFile() throws Exception {
		//Delete old file
		if(checkForFile(historyLink) == true) {
			Files.delete(historyPath);
		}
		
		Scanner userStartingWeapon = new Scanner(System.in);
		int weaponId = -1;

		// User input validation to prevent InputMismatchException
		do {
			// Read weaponlist.txt to display options for user
			System.out.println("Choose your starting weapon.");

			for(int i = 0; i < wList.length; i++) {
				System.out.println((i+1) + ". " + wList[i]);
			}
			weaponId = userStartingWeapon.nextInt();
			
			// Incorrect input message
			if(weaponId < 1 || weaponId > 14)
				System.out.println("Incorrect input. Please try again.");
		} 
		while(weaponId < 1 || weaponId > 14);
		System.out.println("You've chosen weapon: " + wList[weaponId - 1]);
		updateHistoryFile(wList[weaponId - 1]);
		makeStatFile(wList[weaponId - 1], weaponId);
	}
	
	public void makeStatFile(String firstWeaponName, int index) throws Exception {
		//Delete old file
		if(checkForFile(statLink) == true) {
			Files.delete(statPath);
		}
		
		BufferedWriter output = new BufferedWriter(new FileWriter(statLink));
		for(int i = 0; i < wList.length; i++) {
			if(i != (index - 1)) {
				output.write("0");
				output.newLine();
			} else {
				output.write("1");
				output.newLine();
			}
		}
		output.flush();
		output.close();
		
	}
	
	/**
	 * Update weaponhistory.txt with the assumption it exists
	 */
	public void updateHistoryFile(String weaponName) throws Exception{
		File history = new File(historyLink);

		// Create weapon txt file and add first weapon
		// Else, update file
		if(history.createNewFile()) {
			LineNumberReader reader = new LineNumberReader(new FileReader(historyLink));
			BufferedWriter output = new BufferedWriter(new FileWriter(historyLink));
			output.write((reader.getLineNumber() + 1) + ". " + weaponName);
			output.newLine();
			output.flush();
			output.close();
			reader.close();
		} else {
			LineNumberReader reader = new LineNumberReader(new FileReader(historyLink));
			BufferedWriter output = new BufferedWriter(new FileWriter(historyLink,true));
			output.write((reader.getLineNumber() + 1) + ". " + weaponName);
			output.newLine();
			output.flush();
			output.close();
			reader.close();
		}
	}
	

	public String readHistoryFile() throws Exception{
		if(checkForFile(historyLink) == true) {
			
			int index = (int) Files.lines(historyPath).count();
			String lastWeapon = Files.readAllLines(Paths.get(historyLink)).get(index);
			return lastWeapon;
		}
		
		else {
			System.out.println("Warning: File does not exist.");
			return "Nope";
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