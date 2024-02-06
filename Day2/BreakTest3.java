/*class BreakTest3
{
	public static void main(String[] args)
	{
		int i=0,cnt=0;
		for(i=1;i<=100;i++)
		{
			if(i%5!=0) continue;
			else if(i%7!=0) continue;
			
			cnt++;
			System.out.println("5와 7의 공배수 : " + i);
			
		}
		System.out.println("5와 7의 공배수 갯수 : " + cnt);
	}
}*/

/*class BreakTest3
{
	public static void main(String[] args)
	{
		int i=0,cnt=0;
		for(i=1;i<=100;i++)
		{
			if(i%5!=0 || i%7!=0)
			{				
			 	continue;
			}
			cnt++;
			System.out.println("5와 7의 공배수 : " + i);
		}
		System.out.println("5와 7의 공배수 갯수 : " + cnt);
	}
}*/

class BreakTest3
{
	public static void main(String[] args)
	{
		int i=0,cnt=0;
		for(i=1;i<=100;i++)
		{
			if(i%5==0 && i%7==0)
			{		
				cnt++;
				System.out.println("5와 7의 공배수 : " + i);		
			 	continue;
			}

		}
		System.out.println("5와 7의 공배수 갯수 : " + cnt);
	}
}