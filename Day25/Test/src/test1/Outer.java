package test1;

//class Outer {
//
//	class Inner
//	{
//		int iv = 10;
//	}
//}

class Outer {

	static class Inner
	{
		int iv = 10;
	}
}

class MainClass
{
	public static void main(String[] args)
	{
		Outer.Inner o = new Outer.Inner();
		
		
		System.out.println(o.iv);
		
	}
}
