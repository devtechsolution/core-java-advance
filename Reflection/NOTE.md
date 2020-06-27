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

#### Lab1364.java
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

#### Output:
```
	Class loaded Successfully
	Class Name: org.as.devtechsolution.reflection.ex1.Hello
	Class loaded Successfully
```

---
### 2. getClass() method of java.lang.Object
* It returns the instance of **java.lang.Class**.
* It should be used if we have the object of class.
It can be used only for user defined datatypes and not for primitive types.

#### Lab1365.java
```
	package org.as.devtechsolution.reflection.ex1;

	public class Lab1365 {
	
		public static void main(String[] args) {
			showClassInfo("OK");
			showClassInfo(new Lab1365());
			Hello h= new Hello();
			showClassInfo(h);
		}
		
		static void showClassInfo(Object obj) {
			Class cls= obj.getClass();
			System.out.println("\nClass Nme:"+ cls.getName());
		}
		
	}

```
#### Output:
```
	Class Nme:java.lang.String

	Class Nme:org.as.devtechsolution.reflection.ex1.Lab1365

	Class Nme:org.as.devtechsolution.reflection.ex1.Hello
	
	
```

### 3. The .class syntax
* .class can be appended with any type name to get the object of **java.lang.Cla
* It can be used for both user defibed data types as well as primitive data types.

#### Lab1366.java
```
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
	
```

#### Output:
```
	Name: org.as.devtechsolution.reflection.ex1.Lab1366
	Name: int
	Name: boolean
	Name: org.as.devtechsolution.reflection.ex1.Hello
	
```

---

| Methods | Description |
| --- | --- |
| `public boolean isInterface()` | Determines if the specified Class object represents an interface type |
| `public boolen isArray()` | Determines if the specified Class represents an array class.|
| `public boolean isPrimitive()` | Determines if the specified Class object represents a primitive type |
| `public boolen isAnnotation()` |Determines if the specified Class object represents an Annotation Type (From Java 5)
| `public boolean isAnonymousClass()` | Determines if the specified Class object represents an Anonyoums type |
| `public boolen isEnum()` | Determines if the specified Class represents an Enum|
