package org.as.devtechsolution.reflection.ex2;
import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1368 {
	
	public static void main(String[] args) {
		String cname= "org.as.devtechsolution.reflection.ex2.Employee";
		try {
			Class cl1= Class.forName(cname);
			showClassDetails(cl1);
			Class cl2= "OK".getClass();
			showClassDetails(cl2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	static void showClassDetails(Class cl) {
		System.out.println("\n** Nme:"+ cl.getName());
		
		Class superClass= cl.getSuperclass();
		System.out.println("Super Class:"+ superClass.getName());
		
		Package pack= cl.getPackage();
		System.out.println("Package:"+ pack.getName());
		
		Class interf[]= cl.getInterfaces();
		System.out.println("Implemented Interfaces:");
		Stream<Class> stream = Arrays.stream(interf);
		stream.forEach(intr-> {
			System.out.println(intr.getName());
		});
	}

}

class Person implements Comparable{
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}

class Employee extends Person implements Serializable, Cloneable{}
