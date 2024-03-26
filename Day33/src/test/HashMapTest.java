package test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();

		while(it.hasNext()) {
			Map.Entry<String, Integer> e = it.next();
			System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
		}

		Set<String> kset = map.keySet();
		System.out.println("참가자 명단 : " + kset);

		Collection<Integer> values = map.values();
		Iterator<Integer> vit = values.iterator();

		int total = 0;

		while(vit.hasNext()) {
			Integer i = vit.next();
			total += i.intValue();
		}

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
		
	}

}
