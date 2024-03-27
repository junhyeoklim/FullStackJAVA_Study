package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test5_6 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (s1,s2) -> s2.compareTo(s1)
			);
		
		System.out.println(list);
	}
}