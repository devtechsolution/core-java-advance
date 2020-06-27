package org.as.devtechsolution.reflection.ex3;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1369 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		String cname= "org.as.devtechsolution.reflection.ex3.Hai";
		
		Class cl= Class.forName(cname);
		
		System.out.println("\n PUBLIC CONSTRUCTORS");
		
		Constructor [] publicCons= cl.getConstructors();
		Stream<Constructor> publicConstStream = Arrays.stream(publicCons);
		// publicConstStream.forEach(constructor-> System.out.println(constructor));
		publicConstStream.forEach(System.out::println);
		
		System.out.println("\n DECLARED CONSTRUCTORS");
		
		Constructor [] declaredCons= cl.getDeclaredConstructors();
		Stream<Constructor> declaredConsStream = Arrays.stream(declaredCons);
		// declaredConsStream.forEach(constructor-> System.out.println(constructor));
		declaredConsStream.forEach(System.out::println);
	}

}


