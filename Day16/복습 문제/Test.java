import java.util.Scanner;
import java.util.Random;

class CpuCreate
{
	private static int cpu;

	public static int create()
	{
		Check chk = new Check();

		while(true)
		{
			cpu = new Random().nextInt(899)+100;

			if(Check.checkNum(cpu))
				return cpu;
		}
	}
}

class Check
{
	private static int[] chnum = new int[3];
	private static boolean chk;
	private static int strike,boll;
	private static int[] cpuArray = new int[3];
	private static int[] userArray = new int[3];

	public static boolean checkNum(int num)
	{
		chnum[0] = num/100;
		chnum[1] = num%100/10;
		chnum[2] = num%100%10;

		for(int i =0; i<chnum.length-1;i++)
		{
			for(int j =i+1; j<chnum.length;j++)
			{
				if(chnum[i] == chnum[j])
				{
					chk = false;
					return chk;
				}
				else
					chk = true;
			}
		}
		return chk;
	}
	public static void checkNum(int cpu,int user)
	{
		boolean out = true;

		cpuArray[0] = cpu/100;
		cpuArray[1] = cpu%100/10;
		cpuArray[2] = cpu%100%10;

		userArray[0] = user/100;
		userArray[1] = user%100/10;
		userArray[2] = user%100%10;


		for(int i=0;i<cpuArray.length;i++)
		{
			for(int j =0;j<cpuArray.length;j++)
			{
				if((cpuArray[j] != userArray[j]) && cpuArray[i] == userArray[j])
					boll++;				
			}
			if(cpuArray[i] == userArray[i])
				strike++;
		}
		if(boll == 0 && strike == 0)
		{
			System.out.print("아웃!\n");
		}
		else
		{
			System.out.println("스트라이크 : "+strike+"\t볼 : "+boll);
			strike =0;
			boll =0;
		}
	}
}


class GameStart
{
	private static final int STRIKE = 1;
	private static final int BOL = 2;
	private static final int OUT = 3;
	private static final int HOME_RUN = 4;



	public static void start()
	{
		Check chk = new Check();
		Scanner sc = new Scanner(System.in);
		Random random = new Random();	
		
		int[] cpuArray = new int[3];
		int[] userArray = new int[3];

		int cpu=0,user=0;
		
		System.out.println("!! 숫자 야구 게임 !! ");
		cpu = CpuCreate.create(); //중복되지 않는 3자리 cpu숫자 생성
		System.out.println("cpu 숫자 테스트 및 연결 테스트 : "+cpu);

		System.out.println("중복되지 않으며 첫번째 자리가 0이 아닌 3자리 숫자를 입력 해주세요!");

		while(true)
		{

			user = sc.nextInt();
			sc.nextLine();

			if(!Check.checkNum(user) || user < 100 || user > 999)
			{	
				System.out.println("숫자는 100이상 999 이하의 겹치지 않는 숫자여야 합니다!");
				System.out.println();
				continue;
			}
			else if(cpu == user)
			{
				System.out.println("홈런");
				System.out.println("게임을 종료합니다.");
				break;
			}
			else
			{
				Check.checkNum(cpu,user);
			}
		}
	}
}






class Test
{
	public static void main(String[] args)
	{
		GameStart.start();
	}
}