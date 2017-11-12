// *******************************************************************
// Generic2.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates generic classes further. It is possible 
// to have multiple type parameters for generic classes.  
// 
// Key Points:
// 1) Multiple Type Parameters for Generic Classes.
// *******************************************************************


import java.util.Scanner;


//Generic class that takes two type parameters, GenTwo, T and S are just names

class GenTwo<T, S>  {	
	
	// Attributes
	private T x;		// Again, x is just an object name; it can be anything
	private S y;
	
	// Default constructor
	public GenTwo()
	{
		x = null;
		y = null;
	}
	
	// Parameterized constructor
	public GenTwo(T v1, S v2)
	{
		x = v1;
		y = v2;
	}
	
	public void setX(T v)
	{
		x = v;
	}

	public T getX()
	{
		return x;
	}

	public void setY(S v)
	{
		y = v;
	}

	public S getY()
	{
		return y;
	}
	
	public String toString()
	{
		return (x.toString() + " " + y.toString());
	}
	

	public boolean equals(Object obj)
	{
		if(this == null || obj == null || this.getClass() != obj.getClass())
			return false;
		else
		{
			GenTwo<T, S> g1 = (GenTwo<T, S>) obj;	// Cast the passed object to a GenTwo object
										// then compare that cast object to "this"
			if(x.equals(g1.x) && y.equals(g1.y))
				return true;
			else
				return false;
		}
	}
	
}   // end of class


//Car Class 
class Car  {

	// Attributes
	private int numOfDoors;
	private double price;
	private int numOfSeats;
	
	// Constructors
	public Car()	// default constructor 
	{
		numOfDoors = 4;
		price = 10000;
		numOfSeats = 5;
	}
	
	public Car(int nd, double pr, int ns)	
	{
		numOfDoors = nd;
		price = pr;
		numOfSeats = ns;
	}
	
	public Car(Car c)	
	{
		numOfDoors = c.numOfDoors;
		price = c.price;
		numOfSeats = c.numOfSeats;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	

	public int getNumOfSeats()
	{
		return numOfSeats;
	}
	
	public void setNumOfSeats(int ns)
	{
		numOfSeats = ns;;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return getNumOfDoors() + " doors, " + getPrice() +
		"$, and " + numOfSeats + " seats."; 
	}
	
	public boolean equals(Car c)
	{
		return (price == c.price && numOfDoors == c.numOfDoors && numOfSeats == c.numOfSeats);	
	}
}   // end of Car class




public class Generic2{
	
	public static void main(String[] args) 
	{
		String familyName1, familyName2;
		Long id1, id2;		// Notice that this is a wrapper class
		Integer creationYear1, creationYear2, creationYear3; 
		Car c1 = new Car(5, 10000, 2), c2 = new Car(2, 32000, 4), c3 = new Car(5, 10000, 2);
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter student ID and Family Name to register in the course: ");
		id1 = kb.nextLong();
		familyName1 = kb.next();
		
		// create a GenTwo object for the entry
		GenTwo<Long, String> stud1 = new GenTwo<Long, String>(id1, familyName1);
		
		System.out.print("\nTo confirm the registration, please re-enter the ID and the Family Name: ");
		id2 = kb.nextLong();
		familyName2 = kb.next();
		
		// create another GenTwo object for the entry
		GenTwo<Long, String> stud2 = new GenTwo<Long, String>(id2, familyName2);
		
		// Now compare the two object for equality
		if (stud1.equals(stud2))
				System.out.println("Thank you. The registration has been confirmed.");
		else
		{
			System.out.println("Sorry. Entries did not match. No registration will take place.");
			System.out.println("Your first entry was: " + stud1 + " and your second entry was: " + stud2);
		}
	
		System.out.print("\nPlease enter the creation year of three cars: ");
		creationYear1 = kb.nextInt();
		creationYear2 = kb.nextInt();
		creationYear3 = kb.nextInt();
		
		// Create GenTwo objects for the cars and the models
		GenTwo<Car, Integer> cm1 = new GenTwo<Car, Integer>(c1, creationYear1);
		GenTwo<Car, Integer> cm2 = new GenTwo<Car, Integer>(c2, creationYear2);
		GenTwo<Car, Integer> cm3 = new GenTwo<Car, Integer>(c3, creationYear3);
		
		// Notice how equality is being checked in this case
		if(cm1.getX().equals(cm2.getX()) && cm1.getY().equals(cm2.getY()))
			System.out.println("Information of first and second car is the same.");
		else
		{
			System.out.println("First and second car do not have the same information.");
			System.out.println("The First Car was: " + cm1.getX() + " Creation year was: " + cm1.getY()
					+ ".\nThe second car was: " + cm2.getX() + " Creation year was: " + cm2.getY() + ".");

		}

		if(cm1.getX().equals(cm3.getX()) && cm1.getY().equals(cm3.getY()))
			System.out.println("\nInformation of first and third car is the same.");
		else
		{
			System.out.println("\nFirst and third car do not have the same information.");
			System.out.println("The First Car was: " + cm1.getX() + " Creation year was: " + cm1.getY()
					+ ".\nThe second car was: " + cm3.getX() + " Creation year was: " + cm3.getY() + ".");

		}
	
	
		// Create a GenTwo object simply that takes Car & Car
		GenTwo<Car, Car> cc1 = new GenTwo<Car, Car>(c1, c2);
		GenTwo<Car, Car> cc2 = new GenTwo<Car, Car>(c1, c3);
		
		System.out.println("\nComparing Car info without considering creation year");
		System.out.println("====================================================");
		
		// Notice how equality is being checked in this case
		if(cc1.getX().equals(cc1.getY()))
			System.out.println("\nFirst and second car have the same information.");
		else
		{
			System.out.println("\nFirst and second car do not have the same information.");
		}

		if(cc2.getX().equals(cc2.getY()))
			System.out.println("\nFirst and third car have the same information.");
		else
			System.out.println("\nFirst and third car do not have the same information.");


	}
}

/* The Output 
Please enter student ID and Family Name to register in the course: 9058923 Jackson

To confirm the registration, please re-enter the ID and the Family Name: 9058923 Jackson
Thank you. The registration has been confirmed.

Please enter the creation year of three cars: 2010 2008 2010
First and second car do not have the same information.
The First Car was: 5 doors, 10000.0$, and 2 seats. Creation year was: 2010.
The second car was: 2 doors, 32000.0$, and 4 seats. Creation year was: 2008.

Information of first and third car is the same.

Comparing Car info without considering creation year
====================================================

First and second car do not have the same information.

First and third car have the same information.

*/

/* Run Again
Please enter student ID and Family Name to register in the course: 9042389 Davidson

To confirm the registration, please re-enter the ID and the Family Name: 5659087 Renoir
Sorry. Entries did not match. No registration will take place.
Your first entry was: 9042389 Davidson and your second entry was: 5659087 Renoir

Please enter the creation year of three cars: 2010 2008 2008
First and second car do not have the same information.
The First Car was: 5 doors, 10000.0$, and 2 seats. Creation year was: 2010.
The second car was: 2 doors, 32000.0$, and 4 seats. Creation year was: 2008.

First and third car do not have the same information.
The First Car was: 5 doors, 10000.0$, and 2 seats. Creation year was: 2010.
The second car was: 5 doors, 10000.0$, and 2 seats. Creation year was: 2008.

Comparing Car info without considering creation year
====================================================

First and second car do not have the same information.

First and third car have the same information.


*/
