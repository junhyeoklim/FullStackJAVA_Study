package test;

public class Test5 {

	public static boolean contains(String src, String check)
	{
		if(src.indexOf(check) > 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(contains("14523","23"));
		System.out.println(contains("12345","67"));
	}
}
