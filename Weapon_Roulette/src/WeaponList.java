public class WeaponList{
	
	private String[] weaponList = new String[] {
			"Great Sword",
			"Long Sword",
			"Sword & Shield",
			"Dual Blades",
			"Lance",
			"Gunlance",
			"Hammer",
			"Hunting Horn",
			"Switch Axe",
			"Charge Blade",
			"Insect Glaive",
			"Light Bowgun",
			"Heavy Bowgun",
			"Bow"	
	};
	
	private String lastWeapon = "";
	
	public String[] getList() {
		return weaponList;
	}
	
	public void setLastWeapon(String weaponName) {
		this.lastWeapon = weaponName;
	}
	
	public String getLastWeapon() {
		return this.lastWeapon;
	}
	
	/**
	 * @param selectedWeapon - the weapon chosen from the roulette to be compared
	 * @return true if the selected weapon is the same as the last weapon; false if otherwise
	 */
	public boolean checkWeapon(String selectedWeapon) {
		return (selectedWeapon == this.lastWeapon);
	}
	
	public int getSize() {
		return weaponList.length;
	}
}