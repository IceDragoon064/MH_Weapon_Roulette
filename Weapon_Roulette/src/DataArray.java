public class DataArray {
	private String[][] data = {
			{"Great Sword", "0"},
			{"Long Sword", "0"},
			{"Sword & Shield", "0"},
			{"Dual Blades", "0"},
			{"Lance", "0"},
			{"Gunlance", "0"},
			{"Hammer", "0"},
			{"Hunting Horn", "0"},
			{"Switch Axe", "0"},
		    {"Charge Blade", "0"},
			{"Insect Glaive", "0"},
			{"Light Bowgun", "0"},
			{"Heavy Bowgun", "0"},
			{"Bow", "0"}
	};	 
	private String lastWeapon = "";
	private String[][] currentData;
	
	
	// Constructor used to create data with updated usage values
	public DataArray(String[][] array) {
		this.setDataArray(array);
	}
	
	// Empty Constructor will generate base table
	public DataArray() {
		this.setDataArray(data);
	}
	
	public void setDataArray(String[][] array) {
		this.currentData = array;
	}
	
	public String[][] getDataArray() {
		return currentData;
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
	public boolean checkWeapon(int number) {
		String selectedWeapon = this.getWeaponById(number);
		if(selectedWeapon == this.lastWeapon) {
			return true;
		} else {
			this.lastWeapon = selectedWeapon;
			return false;
		}
	}
	
	public int getSize() {
		return data.length;
	}
	
	public String getWeaponById(int id) {
		return data[id][0];
	}
}
