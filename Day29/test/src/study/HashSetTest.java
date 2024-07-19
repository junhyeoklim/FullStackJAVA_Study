package study;

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
		return Objects.hash(name,age); //적절한 해쉬 코드를 만들어서 반환 시키는게 있으니 가급적 이걸 사용
//		return age%3;
	}
	@Override
	public boolean equals(Object obj) {
		
		Person comp = (Person) obj;
		
		if(comp.name.equals(name) && comp.age == age)
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

