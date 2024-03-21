package test;

import java.util.Iterator;
import java.util.TreeSet;

public class CreateLottoNum {

	public static void main(String[] args) {

		TreeSet<Integer> lotto = new TreeSet<>();
		
		while(lotto.size() < 6)
		{
			int num = (int) (Math.random()*45+1);
			
			lotto.add(num);
		}
		
		System.out.println(lotto);
	}

}
