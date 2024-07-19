package test;

public class Test8 {

	public static int getRand(int start,int last)
	{
		int random = (int) Math.random()*last;
		
		random = Math.abs(random);
		
		return 1;
	}
	
	public static void main(String[] args)
	{
		for(int i=0; i< 20; i++)
			System.out.print(getRand(1,-3)+",");
	}
}
