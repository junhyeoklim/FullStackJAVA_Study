class Excercise6
{
	public static void main(String[] args)
	{
		int under = 0, height = 0;

		for(height=0;height<5;height++)
		{
			for(int s =0; s <4-height;s++ )
			{
				System.out.print(" ");
			}
			for(under=0;under<2*height+1;under++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}