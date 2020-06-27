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
