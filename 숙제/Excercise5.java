class Excercise5
{
	public static void main(String[] args)
	{
		int under = 0, height = 0;

		for(height =0; height <5; height++)
		{
			for(under = 5; under > height; under--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}