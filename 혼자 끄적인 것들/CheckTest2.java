class CheckTest2
{
	//사용자가 입력한 번호에 해당 하는 소수를 출력하는 명령문
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num=0,ck=0,user=0,cnt=0;

		System.out.println("몇 번째 소수를 찾으시겠습니까?");
		user = sc.nextInt();
		
		for(num=2;true;num++)
		{
			for(ck=2;ck<num;ck++)
			{
				if(num%ck == 0) break;
			}

			if(num == ck)
			{
				cnt++;
			}

			if(user == cnt)
			{
				System.out.println();
				System.out.println(user+"번째 소수는 "+num+"입니다!");
				break;
			}
		}
	}
}