package test;


public class InstanceTest {

	public static void showData(Object obj)
	{
		System.out.println(obj);
	}
	
	public static void main(String[] args) {

		showData(3);
		showData(7.15);
 	}

}

class Numcheck extends Object
{
	public static int INT(int num)
	{
		return num;
	}
}