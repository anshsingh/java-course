package net.azib.java.students.t040750;

/**
 * Dog
 *
 * @author t040750
 */
public class Dog {

	String name; 		//Main1: ei saa teha staailiseks, kuna muidu iga Dog tüüpi objekti
						// muutuja name kirjutatakse ühte ja samasse mäluauku, st iga objekti puhul
						// omab name seda väärtust, mis viimane objekt talle andis
	
	/**
	 * @param string
	 */
	public Dog(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public Dog() {
		this.name = "Unknown";
	}

	String getName() {
		/*
		final String newName = "";
		return newName;
		*/
		return name;
	}
	/* Main1 
	public static void main(String[] args) {
		Dog a = new Dog();
		Dog b = new Dog();
		
		a.name = "Sharik";
		b.name = "Tuzik";
		
		System.out.println("I have 2 dogs: " + a.getName() + " and " + b.getName());
	}
	*/
	
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		
		Dog c = new Dog();
		
		System.out.println("I have 3 dogs: " + a.getName() + ", " + b.getName() + " and " + c.getName());
	}
}