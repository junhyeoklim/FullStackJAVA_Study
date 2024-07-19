package test;

import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		
		TreeSet<Integer> lotto = new TreeSet<>();
		
		while(lotto.size() < 6)
		{
			int random = (int) (Math.random()*45+1);
			lotto.add(random);
		}
		
		System.out.println(lotto);
	}

}
