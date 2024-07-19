package study;

import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {

		TreeSet<Integer> lotto = new TreeSet<>();
		
		while(lotto.size() < 6)
		{
			int num = (int) (Math.random()*45)+1;
			lotto.add(num);
		}

			System.out.println(lotto);
	}

}
