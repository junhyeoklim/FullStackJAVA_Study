import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// 출력 결과는 정렬

//class RandomTest

class CreateCPU
{
	private static int cpu;

	public static int cpuNum()
	{
		Check chk = new Check();
		Random random = new Random();

		while(true)
		{
			int i = random.nextInt(899)+100;

			if(!(chk.checkNum(i)))
			{
				cpu = i;
				break;
			}
		}
		return cpu;
	}
}



class Check
{
	private int result;
	private static int cpunum1,cpunum2,cpunum3;
	private static int usnum1,usnum2,usnum3,strike,boll;
	private static int[] cpuArray = new int[3];
	private static int[] userArray = new int[3];
	


	public static boolean checkNum(int num)
	{
		 cpunum1 = num/100;
		 cpunum2 = num%100/10;
		 cpunum3 = num%100%10;

		if(cpunum1 == cpunum2 || cpunum1 == cpunum3 || cpunum2 == cpunum3)		
			return true;
		else
			return false;
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



	public void start()
	{
		Check chk = new Check();
		Scanner sc = new Scanner(System.in);
		Random random = new Random();	
		
		int[] cpuArray = new int[3];
		int[] userArray = new int[3];

		int cpu=0,user=0;
		
		System.out.println("!! 숫자 야구 게임 !! ");
		cpu = CreateCPU.cpuNum(); //중복되지 않는 3자리 cpu숫자 생성
		System.out.println("cpu 숫자 테스트 및 연결 테스트 : "+cpu);



		while(true)
		{
			System.out.println("중복되지 않으며 첫번째 자리가 0이 아닌 3자리 숫자를 입력 해주세요!");
			user = sc.nextInt();

			if(chk.checkNum(user) || user < 100 || user > 999)
			{	
				System.out.println("숫자는 100이상 999 이하의 겹치지 않는 숫자여야 합니다!");
				System.out.println();
			}
			else if(cpu == user)
			{
				System.out.println("홈런");
				System.out.println("게임을 종료합니다.");
				break;
			}
			else
			{
				chk.checkNum(cpu,user);
			}
		}
	}
}

class RandomTest
{
	public static void main(String[] args)
	{
		GameStart gs = new GameStart();

		gs.start();
	}
}












/*class RandomTest
{

	public static void main(String[] args)
	{	//1번
		int[] lotto = new int[6];
		int num = 0;
		Random random = new Random();


		for(int i=0; i<lotto.length-1;i++)
		{
			System.out.print((char)('A'+i)+" 자 동"+"\t");



			for(int y=0; y<lotto.length-1;y++)
			{
				lotto[y] = random.nextInt(45)+1;

				if(lotto[i] == lotto[y+1])
					i--;
				else
				{
					Arrays.sort(lotto);
					System.out.print(lotto[y] + "\t");
				}
			}
			System.out.println();
		}

	}
}

*/


/*class RandomNum
{
	private int maxA;
	private int minB;
	private int cnt;
	private int random;

	public void randomNum(int max,int min)
	{
		Random rd = new Random();

		maxA = max;
		minB = min;

		for(int i=0; i<10; i++)
		{
			System.out.println("random : "+(rd.nextInt(maxA-minB+1)+minB));
		}
	}
}


class RandomTest
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		RandomNum rand = new RandomNum();

		int maxA = 0;
		int minB = 0;
		
		


		System.out.println("최대 정수를 입력 해주세요!");
		maxA = sc.nextInt();

		System.out.println("최소 정수를 입력 해주세요!");
		minB = sc.nextInt();


		rand.randomNum(maxA,minB);

	}

}*/