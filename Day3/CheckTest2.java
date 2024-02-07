import java.util.Scanner;
class CheckTest2
{
	public static void main(String[] args)
	{
		int num=0,ck=0;

		for(num=2;num<=100;num++)
		{
			for(ck=2;ck<num;ck++)
			{
				if(num%ck == 0) break;
			}

			if(num == ck)
			{
				System.out.println(num);
			}
		}
	}
}
/*class CheckTest2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long num=0,ck=0,user=0,cnt=0;

		System.out.println("몇 번째 소수를 찾으시겠습니까?");
		user = sc.nextLong();
		
		for(num=2;true;num++)
		{
			for(ck=2;ck<num;ck++)
			{
				if((num%ck).equals(0)) break;
			}

			if(num.equals(ck))
			{
				cnt++;
			}

			if(user.equals(cnt))
			{
				System.out.println();
				System.out.println(user+"번째 소수는 "+num+"입니다!");
				break;
			}
		}
	}
}*/