package org.as.devtechsolution.reflection.ex1;

public class Lab1366 {
	
	public static void main(String[] args) {
		Class cls1= Lab1366.class;
		Class cls2= int.class;
		Class cls3= boolean.class;
		Class cls4= Hello.class;
		
		System.out.println("Name: "+ cls1.getName());
		System.out.println("Name: "+ cls2.getName());
		System.out.println("Name: "+ cls3.getName());
		System.out.println("Name: "+ cls4.getName());
		
	}

}
