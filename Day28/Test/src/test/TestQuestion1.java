package test;

import java.util.Arrays;

class Person implements Comparable<Person>{
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return name + ": " + age;
	}



	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
}


public class TestQuestion1 {

	public static void main(String[] args) {
		Person[] ar = new Person[3];

		ar[0] = new Person("Lee", 29);
		ar[1] = new Person("Goo", 15);
		ar[2] = new Person("Soo", 37);
		
		Arrays.sort(ar);
		
		for(int i=0; i<ar.length;i++)
		{
			System.out.println(ar[i]);
		}

	}

}
