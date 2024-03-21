package test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Person1 implements Comparable<Person1>
{
    String name;
    int age;

    public Person1(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public void showData()
    {
    	System.out.printf("%s %d \n", name, age);
    }
    public int compareTo(Person1 p)
    {
        if(age>p.age)
            return 1;
        else if(age<p.age)
            return -1;
        else	
            return 0;
    }
}

class ComparableTest 
{
	public static void main(String[] args)
	{
		TreeSet<Person1> sTree=new TreeSet<Person1>(new Comparator<Person1>() {

			@Override
			public int compare(Person1 o1, Person1 o2) {
				return o1.compareTo(o2);
			}
		});
		sTree.add(new Person1("Lee", 24));
		sTree.add(new Person1("Hong", 29));
		sTree.add(new Person1("Choi", 21));
		
		Iterator<Person1> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}