import java.util.Random;
import java.util.Scanner;

class RandomGame
{
	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int cpu= 0,user=0,cnt=1;
		cpu = random.nextInt(100)+1;

		System.out.println("게임을 시작합니다.");
		System.out.println("숫자를 입력하세요.");		
		user = scan.nextInt();
		
		while(true)
		{
			if(user > cpu)
			{
				System.out.println("당신이 입력한 숫자 보다 작습니다.");
				cnt++;
				user = scan.nextInt();
			}
			else if(user < cpu)
			{
				System.out.println("당신이 입력한 숫자 보다 큽니다");
				cnt++;
				user = scan.nextInt();
			}
			else
			{
				System.out.println("정답입니다. 당신은 " + cnt + "번만에 정답을 입력하셨습니다.");
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		
	}
}