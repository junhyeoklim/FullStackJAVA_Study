package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };		

		HashMap<String,Integer> map = new HashMap<>();	
		int cnt = 0;

		for(int i=0; i< data.length;i++)
		{


			if(map.containsKey(data[i]))
			{
				Integer value = map.get(data[i]);
				map.put(data[i], value+1);
			}
			else
				map.put(data[i], 1);
		}

		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			int value = entry.getValue().intValue();
			System.out.println(entry.getKey() +": "+printBar('#', value) +" "+ entry.getValue());
		}
	}
	
	static String printBar(char ch,int value)
	{
		char[] bar = new char[value];
		
		for(int i=0;i<bar.length;i++)
		{
			bar[i] = ch;
		}
		return new String(bar);
	}

}
