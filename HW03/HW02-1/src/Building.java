/**
 * This class models the Buildings
 * @author zgoold17
 */


public abstract class Building {

	//VARIABLES
	String name, address;
	Person[] CurrentOccupents;
	
	/**
 	* The first constructor makes things NULL
 	* The second takes name and address and sets up the building	
 	*/
	//CONSTRUCTORS
	public Building(){
		name = null;
		address = null;
	}
	public Building(String name, String address){
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Sets the name and address
	 * @param name
	 * @param address
	 */
	//SET FUNCTIONS
	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Gets the name and address
	 * @return name/address
	 *
	 */
	//GET FUNCTIONS
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}


}
