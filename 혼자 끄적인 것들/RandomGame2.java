import java.util.Random;
import java.util.Scanner;

class RandomGame2
{
	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int cpu= 0,user=0,uscnt=0,cpcnt=0;

		//게임 진행 여부 판별 하는 플래그 변수 선언 및 처음 진행을 위해 y로 초기화
		String flag = "y";

		//user와 cpu에 들어 있는 숫자를 문자로 바꾸기 위한 문자열 선언 및 null 값으로 초기화
		String chuser = null,chcpu = null;


		System.out.println("!!!가위바위보 게임!!!");
		
		//flag에 'n'값이 입력 되기 전 까지 무한 반복하는 while문
		while(true)
		{
		    if(flag.equals("y"))
		      {
			System.out.println("\n"+"선택 하세요 가위:1 바위:2 보:3");
			user = scan.nextInt();
			cpu = random.nextInt(3)+1;

			//user가 입력한 숫자를 가위,바위,보 문자로 바꾸는 스위치 문
			switch(user)
			{
			  case 1 : chuser = "가위";
			  break;
			  case 2 : chuser = "바위";
			  break;
			  case 3 : chuser = "보";
			  break;
			  default :
			  {
				System.out.println("숫자를 다시 입력 해주세요!!");
				System.out.println();
				continue;
			   }
			}

			//cpu에 있는 랜덤 숫자를 가위,바위,보 문자로 바꾸는  스위치 문
			switch(cpu)
			{
			  case 1 : chcpu = "가위";
			  break;
			  case 2 : chcpu = "바위";
			  break;
			  case 3 : chcpu = "보";
			  break;
			  default :
	                          break;
			}


			if(user == 1 && cpu == 1 || user == 2 && cpu == 2 || user == 3 && cpu == 3)
			{
				System.out.println("\n"+"user : " + chuser + "  "+ "cpu : " + chcpu);
				System.out.println("비겼다.."+"\n");
				System.out.println();
			}

			else if(user == 1 && cpu == 2 || user == 2 && cpu == 3 || user == 3 && cpu == 1)
			{
				cpcnt++;
				System.out.println("\n"+"user : " + chuser + "  "+ "cpu : " + chcpu);
				System.out.println("졌다ㅠㅠ"+"\n");
			}
	
			else if(user == 1 && cpu == 3 || user == 2 && cpu == 1 || user == 3 && cpu == 2)
			{
				uscnt++;
				System.out.println("\n"+"user : " + chuser + "  "+ "cpu : " + chcpu);
				System.out.println("이겼다!!"+"\n");
			}
		     }

		    else if(flag.equals("n"))
		     {
			System.out.println("\n"+"게임을 종료합니다!");
			System.out.println("user win : "+uscnt+" "+" cpu win : "+cpcnt);
			break;
		     }

		    //flag에 y,n이외에 값이 들어 오면 재입력 받는 else문
		    else
		     {
		        System.out.println("\n"+"y 또는 n을 입력 해주세요!");   		
		      }

                             System.out.println("계속 하시겠습니까? y,n");
		     flag = scan.next();	      		 
		}
			
	}
}