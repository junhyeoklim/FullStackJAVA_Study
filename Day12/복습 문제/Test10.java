import java.util.Scanner;

class Test10
{
	public static void main(String[] args)
	{
		// 1. 주먹, 2. 가위, 3. 보
		int user = 0, cpu = 0,result = 0,flag=1;
		int cpucnt = 0,usercnt = 0;
		double trygame = 0;

		System.out.println("!!가위 바위 보 게임!!\n");
		Scanner sc = new Scanner(System.in);

		while(true)
		{

			if(flag == 1)
			{
				System.out.println("!!숫자를 입력 해주세요!!");

				System.out.println("1. 가위 2. 바위 3. 보");
				System.out.print("선택 : ");
				user = sc.nextInt();

				cpu = (int)(Math.random()*3)+1;
				sc.nextLine();

				if(user == cpu)
					result = 1;
				else if(user - cpu == -2 || user - cpu == 1)
					result = 2;
				else
					result = 3;
				

				switch(user - cpu)
				{
					case 0:
					{
						System.out.println("비겼습니다!\n");						
						break;
					}
					case 1: case -2:
					{
						System.out.println("이겼습니다!\n");
						usercnt++;
						break;
					}
					case -1: case 2:
					{						
						System.out.println("졌습니다!\n");
						cpucnt++;
						break;
					}
					default :
					{
						System.out.println("숫자를 입력 해주세요!");
						break;
					}
				}
				System.out.println("계속 하시겠습니까?");
				System.out.println("1. 재시작 2. 종료 ");
				flag = sc.nextInt();
				sc.nextLine();
				System.out.println();
			}
			else if(flag == 2)
			{
				trygame = usercnt+cpucnt;
				double total = (usercnt/trygame)*100;
				System.out.println(total);
				System.out.println("게임을 종료 합니다!");
				System.out.println("user-win : "+usercnt +"\tcpu-win : "+ cpucnt);
				System.out.printf("승률 : %.2f%c",total,'%');
				break;
			}

		}
	}
}