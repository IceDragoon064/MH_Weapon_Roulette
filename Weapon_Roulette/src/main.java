

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
		Roulette weaponRoll = new Roulette();
		while(true) {
			weaponRoll.menu();
		}
	}
}

