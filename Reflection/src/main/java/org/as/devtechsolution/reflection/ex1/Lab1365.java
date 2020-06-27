package org.as.devtechsolution.reflection.ex1;

public class Lab1365 {

	public static void main(String[] args) {
		showClassInfo("OK");
		showClassInfo(new Lab1365());
		Hello h= new Hello();
		showClassInfo(h);
	}
	
	static void showClassInfo(Object obj) {
		Class cls= obj.getClass();
		System.out.println("\nClass Nme:"+ cls.getName());
	}
	
}


/*
 Class Nme:java.lang.String

 Class Nme:org.as.devtechsolution.reflection.ex1.Lab1365

 Class Nme:org.as.devtechsolution.reflection.ex1.Hello 
 
  
 */