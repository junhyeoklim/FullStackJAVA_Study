class Swap
{
	public static void main(String[] args)
	{
		int num1 = 10, num2 = 5;
		System.out.println(num1 + " " + num2);
		
		int swap = 0;
		
		swap = num1;
		num1 = num2;
		num2 = swap;
		
		System.out.println(num1 + " " + num2);
	}
}