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
