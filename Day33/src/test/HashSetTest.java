package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet<String> num1 = new HashSet<>();
		HashSet<String> num2 = new HashSet<>();
		HashSet<String> hap = new HashSet<>();
		HashSet<String> kyo = new HashSet<>();
		HashSet<String> cha = new HashSet<>();
		
		
		num1.add("1");
		num1.add("2");
		num1.add("3");
		num1.add("4");
		num1.add("5");
		
		num2.add("4");
		num2.add("5");
		num2.add("6");
		num2.add("7");
		num2.add("8");
		
		Iterator<String> num1iter = num1.iterator();
		Iterator<String> num2iter = num2.iterator();
		
		while(num2iter.hasNext())
		{
			String tmp = num2iter.next();
			if(num1.contains(tmp))
				kyo.add(tmp);
		}
		while(num1iter.hasNext())
		{
			String tmp = num1iter.next();
			if(!num2.contains(tmp))
				cha.add(tmp);
		}
		num1iter = num1.iterator();
		while(num1iter.hasNext())
			hap.add(num1iter.next());
		num2iter = num2.iterator();
		while(num2iter.hasNext())
			hap.add(num2iter.next());
		
		
		System.out.println("교집합 : "+kyo);
		System.out.println("합 집합 : "+hap);
		System.out.println("차집합 : "+cha);

	}
	
	

}
