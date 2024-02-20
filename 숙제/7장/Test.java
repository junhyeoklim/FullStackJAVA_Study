/*class Test
{
	public static void main(String[] args)
	{
		//8번 문제

		String number = "123";
		System.out.println("출력 값 : "+add(number));
	}

	public static String add(String number)
	{
		return number+ "456";
	}
	
}
*/

class Test
{
	public static void main(String[] args)
	{
		Excercise ex1 = Excercise.getInstance();
		Excercise ex2 = Excercise.getInstance();

		System.out.println("ex1 == ex2 " + (ex1 == ex2));
	}
}

class Excercise
{

	private static Excercise slnt = new Excercise();
	
	public static Excercise getInstance()
	{
		return slnt;
	}
}