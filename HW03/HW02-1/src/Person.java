/**
 * This class represents the People you can create
 * This is the base class
 * 
 * @author zgoold17
 *
 */


public abstract class Person {
	//Variables
	String name, phoneNumber;
	int age;
	/////Constructor 1
	public Person(){
		this.name = null;
		this.age = 0;
		this.phoneNumber = null;
	}
	/////Constructor 2
	public Person(String name, String phoneNumber, int age){
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	//GET FUNCTIONS
	public String getName(){
		return name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public int getAge(){
		return age;
	}
	//SET FUNCTIONS
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	///////
	
	
}
