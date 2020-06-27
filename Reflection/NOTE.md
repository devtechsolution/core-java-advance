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
```java
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
```java
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
```java
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


#### Lab1367.java
```java
	package org.as.devtechsolution.reflection.ex2;

	public class Lab1367 {
		
		public static void main(String[] args) {
			
			Class cls1= int.class;
			Class cls2= Cloneable.class;
			Class cls3= args.getClass();
			Class cls4= Color.class;
			
			verifyClass(cls1);
			verifyClass(cls2);
			verifyClass(cls3);
			verifyClass(cls4);
			
			
		}
		
		static void verifyClass(Class cls) {
			
			System.out.println("\n** Nme:"+ cls.getName());
			System.out.println("Primitive: "+ cls.isPrimitive());
			System.out.println("Interface: "+ cls.isInterface());
			System.out.println("Array: "+ cls.isArray());
			System.out.println("Enum: "+ cls.isEnum());
			
		}
	
	}

	
```
#### Color.class
```java
	package org.as.devtechsolution.reflection.ex2;
	
	public enum Color {
		RED, BLUE
	
	}

```

#### Output:
```
	
	** Nme:int
	Primitive: true
	Interface: false
	Array: false
	Enum: false
	
	** Nme:java.lang.Cloneable
	Primitive: false
	Interface: true
	Array: false
	Enum: false
	
	** Nme:[Ljava.lang.String;
	Primitive: false
	Interface: false
	Array: true
	Enum: false
	
	** Nme:org.as.devtechsolution.reflection.ex2.Color
	Primitive: false
	Interface: false
	Array: false
	Enum: true

	
```

---

| Methods | Description |
| --- | --- |
| `public String getName()` | Returns the fully qualified name of the entity (class, interface, array class, primitive type, or void) represented by this Class object, as a String. |
| `public String getSimpleName()` | Returns the simple name of the underlying class as given in the source code.|
| `public Package getPackage()` | Return the object of Package Class |
| `public native Class getSuperClass()` |Return the default object of super Class|
| `public native Class[]  getInterfaces()` | Return the Class type array of implemented interfaces |

#### Lab1368.java

```java
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


```

#### Output:
```
	
	** Nme:org.as.devtechsolution.reflection.ex2.Employee
	Super Class:org.as.devtechsolution.reflection.ex2.Person
	Package:org.as.devtechsolution.reflection.ex2
	Implemented Interfaces:
	java.io.Serializable
	java.lang.Cloneable
	
	** Nme:java.lang.String
	Super Class:java.lang.Object
	Package:java.lang
	Implemented Interfaces:
	java.io.Serializable
	java.lang.Comparable
	java.lang.CharSequence
	
```

---

| Methods | Description |
| --- | --- |
| `public Constructor<?>[] getConstructors()` | Returns all the public constructors. |
| `public Constructor<?>[] getDeclaredConstructors()` | Returns all the public and non-public constructors. |
| `public Method[] getMethods()` | Returns All public methods of current and super-classes.|
| `public Method[] getDeclaredMethods()` | Returns All public and non-public methods of current class only. |
| `public Field[] getFields()` | Returns All public fields(variable) of current and super-classes.|
| `public Field[] getDeclaredFields()` | Returns All public and non-public variable  of current class only. |
| `public Class[] getClasss()` | Returns All public inner classes of current and super-classes.|
| `public Class[] getDeclaredClasses()` | Returns All public and non-public inner classes of current class only. |
| `public Annotation[] getAnnotations()` | Returns All Annotations marked for current class. |


#### Hello.java
```java
	package org.as.devtechsolution.reflection.ex3;

	class Hello{
		public String data;
		int value;
		public final void processData(int ab, String st) {	}
		boolean isValid() {
			return false;
		}
		public class Inner1{}
		class Inner2{}
	}
```

#### Hai.java
```java
	package org.as.devtechsolution.reflection.ex3;

	public class Hai extends Hello{
		
		String name; 
		public int id;
		protected double fee;
		private long phone;
		
		private Hai() {}
		private Hai(int ab, String st) {}
		
		public Hai(char ch, long val, boolean b1) {}
		Hai(char ch, double val, String st){}
		
		public Hai(int ab, long val, float f1) {}
		protected Hai(byte by,boolean b1, float f2) {}
		
		void show() {}
		
		public void display(int ab, boolean valid, long phn) {}
		private int[] getValues(String nm, long phn) {
			return null;
		}
		class A{}
		public class B{}
		class C{}
	}
	
```

#### Lab1369.java
```java
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

```

#### Outtput:
```
	
 	PUBLIC CONSTRUCTORS
	public org.as.devtechsolution.reflection.ex3.Hai(int,long,float)
	public org.as.devtechsolution.reflection.ex3.Hai(char,long,boolean)
	
	 DECLARED CONSTRUCTORS
	protected org.as.devtechsolution.reflection.ex3.Hai(byte,boolean,float)
	public org.as.devtechsolution.reflection.ex3.Hai(int,long,float)
	org.as.devtechsolution.reflection.ex3.Hai(char,double,java.lang.String)
	private org.as.devtechsolution.reflection.ex3.Hai()
	private org.as.devtechsolution.reflection.ex3.Hai(int,java.lang.String)
	public org.as.devtechsolution.reflection.ex3.Hai(char,long,boolean)
	
```
#### Lab1370.java

```java
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
	

```
#### Output:
```
	
 	PUBLIC METHODS
	public void org.as.devtechsolution.reflection.ex3.Hai.display(int,boolean,long)
	public final void org.as.devtechsolution.reflection.ex3.Hello.processData(int,java.lang.String)
	public final void java.lang.Object.wait() throws java.lang.InterruptedException
	public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
	public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
	public boolean java.lang.Object.equals(java.lang.Object)
	public java.lang.String java.lang.Object.toString()
	public native int java.lang.Object.hashCode()
	public final native java.lang.Class java.lang.Object.getClass()
	public final native void java.lang.Object.notify()
	public final native void java.lang.Object.notifyAll()
	
	 DECLARED METHODS
	private int[] org.as.devtechsolution.reflection.ex3.Hai.getValues(java.lang.String,long)
	void org.as.devtechsolution.reflection.ex3.Hai.show()
	public void org.as.devtechsolution.reflection.ex3.Hai.display(int,boolean,long)
	
```

#### Lab1371.java

```java
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

	

```
#### Output:
```
	
 	
 	PUBLIC FIELDS
	public int org.as.devtechsolution.reflection.ex3.Hai.id
	public java.lang.String org.as.devtechsolution.reflection.ex3.Hello.data
	
	DECLARED FIELDS
	java.lang.String org.as.devtechsolution.reflection.ex3.Hai.name
	public int org.as.devtechsolution.reflection.ex3.Hai.id
	protected double org.as.devtechsolution.reflection.ex3.Hai.fee
	private long org.as.devtechsolution.reflection.ex3.Hai.phone

	
```

#### Lab1372.java

```java
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

	

```
#### Output:
```
	
 	PUBLIC INNER-CLASSES
	class org.as.devtechsolution.reflection.ex3.Hai$B
	class org.as.devtechsolution.reflection.ex3.Hello$Inner1
	
	DECLARED INNER-CLASSES
	class org.as.devtechsolution.reflection.ex3.Hai$B
	class org.as.devtechsolution.reflection.ex3.Hello$Inner1
		
	
```

### Accessing Modifiers Information
- **public int getModifiers()**: To get the modifiers information for the class, methods, fields etc.
- Constants are defined for all the modifiers in **java.lang.reflect.Modifier.class**.
- **getModifiers() method returns int value** i.e. **sum of t all the constants of modifiers** used.
- To verify the specific modifier used or not:
	- **public static String toString(int modifirs)**
	- **public static boolean isXXX(int modifirs)** 
		- XXX is **modifier name**
		- Ex:- **Public, Private, Protected, Abstract, Final Static etc.**
```java
			Modifier and Type		 Constant Field	Value
			
			
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
```
#### Lab1373.java

```java
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
		
```

####Output:
```
	PUBLIC: 1
	PRIVATE: 2
	PROTECTED: 4
	FINAL: 16
	STATIC: 8
	NATIVE: 256
	ABSTRACT: 1024
	SYNCHRONIZED: 32
	ABSTRACT: 1024
	STRICT: 2048
	TRANSIENT: 128
	VOLATILE: 64
	
	*****private static final void org.as.devtechsolution.reflection.ex4.Employee.m5()
	Modifiers: 26
	STR: private static final
	PUBLIC: false
	PRIVATE: true
	PROTECTED: false
	FINAL: true
	STATIC: true
	NATIVE: false
	ABSTRACT: false
	SYNCHRONIZED: false
	ABSTRACT: false
	STRICT: false
	TRANSIENT: false
	VOLATILE: false
	
	*****public synchronized void org.as.devtechsolution.reflection.ex4.Employee.m3()
	Modifiers: 33
	STR: public synchronized
	PUBLIC: true
	PRIVATE: false
	PROTECTED: false
	FINAL: false
	STATIC: false
	NATIVE: false
	ABSTRACT: false
	SYNCHRONIZED: true
	ABSTRACT: false
	STRICT: false
	TRANSIENT: false
	VOLATILE: false
	
	*****protected abstract void org.as.devtechsolution.reflection.ex4.Employee.m4()
	Modifiers: 1028
	STR: protected abstract
	PUBLIC: false
	PRIVATE: false
	PROTECTED: true
	FINAL: false
	STATIC: false
	NATIVE: false
	ABSTRACT: true
	SYNCHRONIZED: false
	ABSTRACT: true
	STRICT: false
	TRANSIENT: false
	VOLATILE: false
	
	*****void org.as.devtechsolution.reflection.ex4.Employee.m6()
	Modifiers: 0
	STR: 
	PUBLIC: false
	PRIVATE: false
	PROTECTED: false
	FINAL: false
	STATIC: false
	NATIVE: false
	ABSTRACT: false
	SYNCHRONIZED: false
	ABSTRACT: false
	STRICT: false
	TRANSIENT: false
	VOLATILE: false
	
	*****final native void org.as.devtechsolution.reflection.ex4.Employee.m2()
	Modifiers: 272
	STR: final native
	PUBLIC: false
	PRIVATE: false
	PROTECTED: false
	FINAL: true
	STATIC: false
	NATIVE: true
	ABSTRACT: false
	SYNCHRONIZED: false
	ABSTRACT: false
	STRICT: false
	TRANSIENT: false
	VOLATILE: false

```
---
#### Creating object using default Constructor

- ***public Object newInstance()**
#### Lab1374.java
```java
	package org.as.devtechsolution.reflection.ex5;
	
	public class Lab1374 {
	
		public static void main(String[] args)  {
			String cname= "org.as.devtechsolution.reflection.ex5.User";
			try {
				Class c1= Class.forName(cname);
				Object obj= c1.newInstance();
				System.out.println(obj);
			} catch (  ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class User{
		public User() {
			System.out.println("User Def Cons");
		}
	}
```
#### Output:
```
User Def Cons
org.as.devtechsolution.reflection.ex5.User@15db9742

```

- If we know the parameter types of the constructor we want to access, we can use the **```getDeclaredConstructor(Class[] paramTypes)``` with  array of Class object** rather than obtain the array of all constructors.
	-- ```Constructor c= c1.getDeclaredConstructor(Class[] paramTypes)```
- It will throw **java.lang.NoSuchMethodException** if the required constructor  not found.

#### Lab1375.java
```java

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
```
#### Output:
	public org.as.devtechsolution.reflection.ex5.Employee(int,java.lang.String,int,long)
	java.lang.NoSuchMethodException: org.as.devtechsolution.reflection.ex5.Employee.<init>(java.lang.String, int)
		at java.lang.Class.getConstructor0(Unknown Source)
		at java.lang.Class.getDeclaredConstructor(Unknown Source)
		at org.as.devtechsolution.reflection.ex5.Lab1375.main(Lab1375.java:19)

```