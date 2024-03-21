package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Person
{
	String name;
	int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return name + "(" + age + "세)";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age);	
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Person com = (Person) obj;
		
		if(com.name.equals(name) && com.age == age)
			return true;
		else
			return false;
	}
}

class HashSetTest
{
	public static void main(String[] args)
	{
		HashSet<Person> hSet = new HashSet<Person>();
		hSet.add(new Person("이진호", 10));
		hSet.add(new Person("이진호", 20));
		hSet.add(new Person("김명호", 20));
		hSet.add(new Person("김명호", 15));
		hSet.add(new Person("이진호", 20));
		hSet.add(new Person("김명호", 20));

		System.out.println("저장된 데이터 수 : " +  hSet.size());

		Iterator<Person> itr = hSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}