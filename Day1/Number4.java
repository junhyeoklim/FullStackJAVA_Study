class Number4
{
	public static void main(String[] args)
	{
		int i = 0, sum = 0,count = 0;
		for(i = 7; sum <=1000;  i = i+7)
		{
		  count = count + 1;
		  sum = sum + i;
		 System.out.println("7의 배수=" + i + "  "+ " sum = "+ sum + " " +count +"번째 항");
		}
		  
	}
}


/*class Number4
{
	public static void main(String[] args)
	{
		int sum = 0,count = 0;
		for(int i = 7;; i++)
		{
			if(i%7 == 0)
			{ 
			   sum += i;
			   count++;
			   System.out.println("7의 배수=" + i + "  "+"sum = "+sum+" "+ count +"번째 항");
			 	if(sum >= 1000)
				{
					break;
				}
			}
		}
	}
}*/