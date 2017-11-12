// *******************************************************************
// Generic1.java By: Aiman Hanna (C) 1993 - 2017
// This program introduces generic classes. 
// 
// Key Points:
// 1) Generics.
// *******************************************************************


// Generic Class 
// Notice that both GenClass and T are just names; they can be anything 
// else (except reserved keywords of course). T here indicate the type that 
// will be plugged to the class when the class is instantiated
class GenClass<T>  {	
	
	// Attributes
	private T x;		// Again, x is just an object name; it can be anything
	
	// Constructor
	public GenClass(T y)
	{
		x = y;
	}
	
	public void setX(T y)
	{
		x = y;
	}

	public T getX()
	{
		return x;
	}

	public void showInfo()
	{
		System.out.println("Here is the data of the object; it is: " + x);
	}
	
}   // end of class





public class Generic1{
	
	public static void main(String[] args) 
	{
		String s1 = "Introducing Generics";
		Integer i1 = 10;		// Notice that this is a wrapper class
		Double d1 = 12.8;		// Notice that this is a wrapper class

		
		// Use the generic class for the three different types
		// Without generics, that would require the creation of three classes to do so
		GenClass<String> gc1 = new GenClass<String>(s1);
		GenClass<Integer> gc2 = new GenClass<Integer>(i1);
		GenClass<Double> gc3 = new GenClass<Double>(d1);
		
		System.out.println("Displaying initial objects information");
		System.out.println("=====================================");
		
		gc1.showInfo();
		gc2.showInfo();
		gc3.showInfo();
		
		
		// Modify object information; this is done in the same fashion as always
		gc1.setX("Isn\'t It Good to Use Generics?");
		gc2.setX(126);
		gc3.setX(182.7);

		System.out.println("\n\nDisplaying objects information after modifications");
		System.out.println("==================================================");
		
		gc1.showInfo();
		gc2.showInfo();
		gc3.showInfo();
	}
}

/* The Output 
Displaying initial objects information
=====================================
Here is the data of the object; it is: Introducing Generics
Here is the data of the object; it is: 10
Here is the data of the object; it is: 12.8


Displaying objects information after modifications
==================================================
Here is the data of the object; it is: Isn't It Good to Use Generics?
Here is the data of the object; it is: 126
Here is the data of the object; it is: 182.7
*/

