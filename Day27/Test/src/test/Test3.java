package test;

public class Test3 {

	public static int count(String str,String search)
	{
		int cnt = 0;
		int pos = 0;
		for(int i=0; i<str.length(); i++)
		{		
			
			if(str.indexOf(search, pos) >= 0)
			{	
				System.out.println(str.indexOf(search, pos));
				pos = search.length() + str.indexOf(search, pos);
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}

}
