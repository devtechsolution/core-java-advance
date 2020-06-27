### Introduction
* Java Reflection allow us 
	 * To inspect classes, interfaces, fields and methods at runtime.
	 * To instantiate new objects.
	 * To invoke methods dynamically at runtime.
	 * To modify or access the values of fields.

* Java Reflection API mainly used in:
	 * IDE's (Integrated Development Environment) e.g. Eclipse, STS, NetBeans etc.
	 * Debugger
	 * Servers
	 * Testing tools etc.
 
* JVM creates default object of type **java.lang.Class** while loading the class.
* All types in Java including primitive types( int, long, double, float,char etc.) and arrays having default objects of type **java.lang.Class**.
* We need to access that default  object to inspect any classes or their members.
* We can use the following techniques to access default object:
	1. **forName()** method of **java.lang.Class**.
	2. **getClass()** method of **java.lang.Object**.
	3. The **.class** syntax.

----
	
### 1. forName() method of java.lang.Class
* It is used to load the class dynamically and return the instance of **java.lang.Class**
* It should be used if we know the fully qualified name of the class.
* It can be used only for **User Defined** data types and nt for primitive types.
----
```
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
	
	
	class Hello{}

```

