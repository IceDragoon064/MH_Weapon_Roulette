import java.io.*;

public class Roulette{
	
	public void randomize() throws Exception {
		
		/*
		File file = new File("src/weaponlist.txt");
		BufferedReader br  = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine()) != null) {
			System.out.println(st);
			
		}
		System.out.println("\n");	
		*/
		
		
		File nFile = new File("src/lastweapon.txt");
		BufferedReader nbr  = new BufferedReader(new FileReader(nFile));
		System.out.println("Last weapon used:\n" + nbr.readLine());
	}

}


