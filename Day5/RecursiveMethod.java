class RecursiveMethod
{
	public static void main(String[] args)
	{
		System.out.println("Start");
		reHi(3);
		System.out.println("End");
	}

	public static void reHi(int num)
	{
		if(num == 0) return;
		System.out.println("Hi");
		reHi(num-1);
		System.out.println("Bye");
	}
}