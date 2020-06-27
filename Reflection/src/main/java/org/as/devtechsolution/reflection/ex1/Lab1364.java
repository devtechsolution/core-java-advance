package org.as.devtechsolution.reflection.ex1;

public class Lab1364 {
	public static void main(String[] args) {
		String className= "org.as.devtechsolution.reflection.ex1.Hello";
		try {
			Class<?> cls= Class.forName(className);
			System.out.println("Class loaded Successfully");
			System.out.println("Class Name: "+ cls.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Class loaded Successfully");
		
	}

}


