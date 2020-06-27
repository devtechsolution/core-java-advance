package org.as.devtechsolution.reflection.ex3;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1372 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		String cname= "org.as.devtechsolution.reflection.ex3.Hai";
		
		Class cl= Class.forName(cname);
		
		System.out.println("\n PUBLIC INNER-CLASSES");
		
		Class [] publicInnerClasses= cl.getClasses();
		Stream<Class> publicInnerClassStream = Arrays.stream(publicInnerClasses);
		/* publicInnerClassStream.forEach(method-> System.out.println(method));*/
		publicInnerClassStream.forEach(System.out::println);
		
		System.out.println("\n DECLARED INNER-CLASSES");
		
		Class [] declaredInnerClasses= cl.getClasses();
		Stream<Class> declaredInnerClassStream = Arrays.stream(declaredInnerClasses);
		/* declaredInnerClassStream.forEach(method-> System.out.println(method));*/
		declaredInnerClassStream.forEach(System.out::println);
	}

}
