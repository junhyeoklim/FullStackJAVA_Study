class Number3
{
	public static void main(String[] args)
	{
		int i = 0, count = 0;
		for( i = 4; i <= 100; i = i+4)
		{			
		   count = count + 1;			
		}
		   System.out.println("4의 배수의 갯수 :  " + count);
	}
}

/*class Number3
{
	public static void main(String[] args)
	{
		int i=0, count=0;
		for( i = 1; i <= 100; i = i+1)
		{			
		  if(i%4==0)
		    count = count + 1;			
		}
		   System.out.println("4의 배수의 갯수 :  " + count);
	}
}*/