import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager {

	private String historyLink = "src/weaponhistory.txt";
	private String statLink = "src/weaponstat.txt";
	private String dataLink = "src/data.csv";
	
	Path historyPath = Paths.get(historyLink);
	Path statPath = Paths.get(statLink);
	Path dataPath = Paths.get(dataLink);
	
	WeaponList weaponList = new WeaponList();
	String[] wList = weaponList.getList();
	
	DataArray data = new DataArray();

	
	String ignore = "0123456789.";
	/**
	 * Method to start a new roulette session
	 * @throws Exception
	 */
	public void startNewFile() throws Exception {
		makeHistoryFile();	
		makeStatFile();
	}
	
	/**
	 * Method to check for files before resuming
	 * @throws Exception
	 */
	public boolean checkFiles() throws Exception {
		System.out.println("Checking files...");
		boolean historyFound = checkForFile(historyLink);
		boolean statFound = checkForFile(statLink);
		
		// All files found and the program will resuming
		if(historyFound == true && statFound == true) {
			System.out.println("All files found!");
			return true;
		}
		
		// A file is missing!
		else {
			System.out.println("A file is missing!");
			return false;
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
		
		File file = new File(historyLink);
		if(file.createNewFile() == true) {
			System.out.println("Weapon History File created!");
		} else {
			System.out.println("Unable to create Weapon History File!");
		}

	}
	
	/**
	 * Method to generate stat file
	 * @param firstWeaponName - the first weapon name
	 * @param index - the index position in the file
	 * @throws Exception
	 */
	public void makeStatFile() throws Exception {
		//Delete old file
		if(checkForFile(statLink) == true) {
			Files.delete(statPath);
		}
		
		File file = new File(statLink);
		if(file.createNewFile() == true) {
			System.out.println("Weapon Usage File created!");
			BufferedWriter output = new BufferedWriter(new FileWriter(statLink));
			for(int i = 0; i < wList.length; i++) {
				output.write("0");
				output.newLine();
			}
			output.flush();
			output.close();
		} else {
			System.out.println("Unable to create Weapon Usage File!");
		}
		
	}
	
	/**
	 * Update weaponhistory.txt with the assumption it exists
	 */
	public void updateHistoryFile(int index) throws Exception {
			BufferedWriter output = new BufferedWriter(new FileWriter(historyLink, true));
			long lineCount = (Files.lines(historyPath).count()) + 1;
			System.out.println("Adding " + wList[index]);
			output.write(lineCount + ". " + wList[index]);
			output.newLine();
			output.flush();
			output.close();
	}
	
	public void updateStatFile(int index) throws Exception {
		for(int i = 0; i < wList.length; i++) {
			if(i == (index)) {
				int usageCount = (Integer.parseInt(Files.readAllLines(Paths.get(statLink)).get(i))) + 1;
				
			}
		}
		
		
	}
	
	public void newRoll(int rollNum) throws Exception {
		updateHistoryFile(rollNum);
		updateStatFile(rollNum);
	}

	public String readHistoryFile() throws Exception {
		int index = (int) Files.lines(historyPath).count();
		
		String lastWeapon = Files.readAllLines(Paths.get(historyLink)).get(index - 1);
		lastWeapon = lastWeapon.replaceAll("[0-9|.]", "");
		return lastWeapon;
	}
	
	/**
	 * Check if specific file exists
	 * @return true if the file exists; false otherwise
	 */
	private boolean checkForFile(String filePath) throws Exception {
		File tempFile = new File(filePath);
		return (tempFile.exists());
	}

	
	public boolean checkRoll(int indexRoll) {
		return weaponList.checkWeapon(indexRoll);
	}
	
	public String getWeaponById(int index) {
		return weaponList.getWeaponById(index);
	}
}