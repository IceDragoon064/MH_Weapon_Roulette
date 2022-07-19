import java.io.*;

/**
 * @author Leon Lu
 * @version 18 July 2022
 * This code's will select an element from a given string array
 */
public class main{
	public static void main(String[] args) throws Exception {
		/*
		File file = new File("src/weaponlist.txt");
		BufferedReader br  = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine()) != null)
			System.out.println(st);
		*/
		
		File nFile = new File("src/lastweapon.txt");
		BufferedReader nbr  = new BufferedReader(new FileReader(nFile));
		System.out.println("Last weapon used:\n" + nbr.readLine());
	}
}

