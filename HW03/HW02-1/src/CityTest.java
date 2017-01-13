import java.util.ArrayList;

/**
 * This creates and tests a "city" to see if things are running correctly
 * @author zgoold17
 * *needs for loops rather than printF statements
 */

public class CityTest{

	public static void main(String[] args) {
		/**
		 * These statements create the school, cityhall, and people arraylists
		 */
		ArrayList<Person> schoolPeople = new ArrayList<Person>();
		ArrayList<Building> buildings = new ArrayList<Building>();
		ArrayList<Person> cityHallPeople = new ArrayList<Person>();
		
		/**
		 * These statements create the buildings and add them to the building arraylist
		 */
		School s1 = new School("Whitworth University", "300 W Hawthorne");
		CityHall c1 = new CityHall("Pioneer Place", "Portland, OR");
		buildings.add(s1);
		buildings.add(c1);
		
		/**
		 * These statements put kids and teachers and police in the arraylists
		 */	
		schoolPeople.add(new Kid("KitKat", "Phil", 5, "0"));
		schoolPeople.add(new Kid("Recess", "Zach", 6, "0"));
		schoolPeople.add(new Kid("Snickers", "Katelyn", 7, "0"));
		schoolPeople.add(new Kid("JollyRancher", "Frank", 8, "0"));
		schoolPeople.add(new Teacher("Computer Science", 20, "Pete Tucker", 45, "4567891"));
		schoolPeople.add(new Teacher("Computer Science", 16, "Kent", 46, "789891"));
		cityHallPeople.add(new Police(Police.Role.Captain,"Frank", 48, "1234567"));
		cityHallPeople.add(new Police(Police.Role.Chief,"Bob", 24, "6784567"));
		
		/**
		 * These statements type what people are in which building
		 * Also states what the names are of the buildings
		 */
		System.out.printf("People in the "+s1.getName()+" school are: ");
		for (Person person: schoolPeople){
			System.out.printf(person.getName());
		}
		System.out.printf("People in the "+c1.getName()+ " City Hall are: ");
		for (Person person: cityHallPeople){
			System.out.printf(person.getName());
		}
		
		/**
		 * These statements pay the employees (police and teachers)
		 */
		for (int i=0; i<schoolPeople.size(); i++){
			if (schoolPeople.get(i) instanceof Employee){
				((Teacher) schoolPeople.get(i)).getPaid();
			}
		}
		for (int i=0; i<cityHallPeople.size(); i++){
			if (cityHallPeople.get(i) instanceof Employee){
				((Police) cityHallPeople.get(i)).getPaid();
			}
		}
		

		
		//Random rnd = new Random();
		
		
		/*
		for (int i=0; i<people.length; i++){ //for loop to display people
			System.out.printf(people[i].name+"\n");	
		}
		for (int i=0; i<structures.length; i++){ //for loop to display buildings names
			System.out.printf(structures[i].name+"\n");	
		}
		*/
	}

}
