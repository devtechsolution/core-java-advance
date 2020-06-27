package org.as.devtechsolution.reflection.ex5;

import java.lang.reflect.Constructor;

public class Lab1375 {
	
	public static void main(String[] args) {
		
		String cname= "org.as.devtechsolution.reflection.ex5.Employee";
		
		try {
			Class c1= Class.forName(cname);
			
			Class paramsReq1[] = new Class[] { int.class, String.class, int.class, long.class };
			Constructor cons1= c1.getDeclaredConstructor(paramsReq1);
			System.out.println(cons1);
			
			Class paramsReq2[] = new Class[] { String.class, int.class };
			Constructor cons2= c1.getDeclaredConstructor(paramsReq2);
 			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Employee{
	public Employee(int eid, String nm, int age, long phone) {	}
	public Employee(int eid, String nm) {
	}
}