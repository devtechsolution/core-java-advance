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
