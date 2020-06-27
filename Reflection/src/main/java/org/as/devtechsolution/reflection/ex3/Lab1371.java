package org.as.devtechsolution.reflection.ex3;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1371 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		String cname= "org.as.devtechsolution.reflection.ex3.Hai";
		
		Class cl= Class.forName(cname);
		
		System.out.println("\n PUBLIC FIELDS");
		
		Field [] publicFields= cl.getFields();
		Stream<Field> publicFieldStream = Arrays.stream(publicFields);
		/* publicFieldStream.forEach(method-> System.out.println(method));*/
		publicFieldStream.forEach(System.out::println);
		
		System.out.println("\n DECLARED FIELDS");
		
		Field[] dclaredFields= cl.getDeclaredFields();
		Stream<Field> dclaredFieldStream = Arrays.stream(dclaredFields);
		/* dclaredFieldStream.forEach(method-> System.out.println(method));*/
		dclaredFieldStream.forEach(System.out::println);
	}

}
