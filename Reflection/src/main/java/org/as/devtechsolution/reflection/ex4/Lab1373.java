package org.as.devtechsolution.reflection.ex4;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lab1373 {
	
	public static void main(String[] args) {
		try {
			Class cl= Class.forName("org.as.devtechsolution.reflection.ex4.Employee");
			System.out.println("PUBLIC: "+ Modifier.PUBLIC);
			System.out.println("PRIVATE: "+ Modifier.PRIVATE);
			System.out.println("PROTECTED: "+ Modifier.PROTECTED);
			System.out.println("FINAL: "+ Modifier.FINAL);
			System.out.println("STATIC: "+ Modifier.STATIC);
			System.out.println("NATIVE: "+ Modifier.NATIVE);
			System.out.println("ABSTRACT: "+ Modifier.ABSTRACT);
			System.out.println("SYNCHRONIZED: "+ Modifier.SYNCHRONIZED);
			System.out.println("ABSTRACT: "+ Modifier.ABSTRACT);
			System.out.println("STRICT: "+ Modifier.STRICT);
			System.out.println("TRANSIENT: "+ Modifier.TRANSIENT);
			System.out.println("VOLATILE: "+ Modifier.VOLATILE);
			
			/*
			
			Modifier and Type		Constant Field	Value
			
			
			 public static final int ABSTRACT 		1024 
			 public static final int FINAL 			16 
			 public static final int INTERFACE 		512 
			 public static final int NATIVE 		256 
			 public static final int PRIVATE 		2 
			 public static final int PROTECTED 		4 
			 public static final int PUBLIC 		1 
			 public static final int STATIC 		8 
			 public static final int STRICT 		2048 
			 public static final int SYNCHRONIZED 	32 
			 public static final int TRANSIENT 		128 
			 public static final int VOLATILE 		64 
			 */
			
			Method declaredMethods[]= cl.getDeclaredMethods();
			
			Stream<Method> declaredMethodStream = Arrays.stream(declaredMethods);
			/* publicMethod.forEach(method-> System.out.println(method));*/
			// declaredMethodStream.forEach(System.out::println);
			
			declaredMethodStream.forEachOrdered(
						m->{
							System.out.println("\n*****"+m);
							int modifiers = m.getModifiers();
							System.out.println("Modifiers: "+ modifiers);
							String str = Modifier.toString(modifiers);
							System.out.println("STR: "+str);
							System.out.println("PUBLIC: "+ Modifier.isPublic(modifiers));
							System.out.println("PRIVATE: "+ Modifier.isPrivate(modifiers));
							System.out.println("PROTECTED: "+ Modifier.isProtected(modifiers));
							System.out.println("FINAL: "+ Modifier.isFinal(modifiers));
							System.out.println("STATIC: "+ Modifier.isStatic(modifiers));
							System.out.println("NATIVE: "+ Modifier.isNative(modifiers));
							System.out.println("ABSTRACT: "+ Modifier.isAbstract(modifiers));
							System.out.println("SYNCHRONIZED: "+ Modifier.isSynchronized(modifiers));
							System.out.println("ABSTRACT: "+ Modifier.isAbstract(modifiers));
							System.out.println("STRICT: "+ Modifier.isStrict(modifiers));
							System.out.println("TRANSIENT: "+ Modifier.isTransient(modifiers));
							System.out.println("VOLATILE: "+ Modifier.isVolatile(modifiers));
							
						}
					);
		} catch (ClassNotFoundException e) {
			System.out.println("Employee class not found");
			e.printStackTrace();
		}
	}
	

}

abstract class Employee{
	//public void m1() {	}
	native final void m2();
	public synchronized void m3() { }
	protected abstract void m4();
	private static final void m5() { }
	void m6() { }
}
