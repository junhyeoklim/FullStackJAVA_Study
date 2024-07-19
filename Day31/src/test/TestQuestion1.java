package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TestQuestion1 {

	public static void main(String[] args) {

		List<String> test = Arrays.asList("Box","Toy","Box","Toy");
		
		HashSet<String> deleteTest = new HashSet<String>(test);
		
		test = new ArrayList<>(deleteTest);
		
		Iterator<String> iter = test.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
	}

}
