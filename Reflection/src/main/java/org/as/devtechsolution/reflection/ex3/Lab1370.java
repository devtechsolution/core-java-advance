package org.as.devtechsolution.reflection.ex3;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1370 {
	public static void main(String[] args) throws ClassNotFoundException {
		String cname= "org.as.devtechsolution.reflection.ex3.Hai";
		
		Class cl= Class.forName(cname);
		
		System.out.println("\n PUBLIC METHODS");
		
		Method [] publicMethod= cl.getMethods();
		Stream<Method> publicMethodStream = Arrays.stream(publicMethod);
		/* publicMethod.forEach(method-> System.out.println(method));*/
		publicMethodStream.forEach(System.out::println);
		
		System.out.println("\n DECLARED METHODS");
		
		Method [] dclaredMethod= cl.getDeclaredMethods();
		Stream<Method> dclaredMethodStream = Arrays.stream(dclaredMethod);
		/* dclaredMethodStream.forEach(method-> System.out.println(method));*/
		dclaredMethodStream.forEach(System.out::println);
	}

}
