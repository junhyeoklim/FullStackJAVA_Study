import java.util.Scanner;


class Test
{
	public static void main(String[] args)
	{
		
		/*//1번 문제
		if(args.length != 3)
		{
			System.out.println("usage: java ArrayEx15 NUM1 OP NUM2");
			System.exit(0);
		}
	
		int num1 = Integer.parseInt(args[0]);
		char op = args[1].charAt(0);
		int num2 = Integer.parseInt(args[2]);



		switch(op)
		{
			case '+':
			{
				System.out.println("java ArrayEx17 "+(num1+num2));
				break;
			}
			case 'x' :
			{
				System.out.println("java ArrayEx17 "+(num1*num2));
				break;
			}
			case '/' :
			{
				System.out.println("java ArrayEx17 "+(num1/num2));
				break;
			}
			case '-' :
			{
				System.out.println("java ArrayEx17 "+(num1-num2));
				break;
			}
			default :
			{
				System.out.println("알맞은 값을 입력 하세요");
			}
		}
		*/



		/*//2번 문제 -> 비 효율적


		int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},
			{40,40,40},
			{50,50,50},
			      };
		int[][] total = new int[score.length+1][score[0].length+3];


			for(int i=0; i<score.length;i++)
			{
				for(int j=0; j<score[i].length;j++)
				{
					total[i][score[i].length-score[i].length] = i+1;
					total[i][j+1] = score[i][j];
					total[i][score[i].length+1] += score[i][j];
					total[score.length][j+1] += score[i][j];
				}
				total[i][score[i].length+2] = total[i][score[i].length+1] / score[i].length;
			}
			System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
			System.out.println("============================================");

			for(int i=0; i< total.length-1;i++)
			{
				for(int j=0; j<total[i].length; j++)
				{
					System.out.print(total[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println("============================================");
			System.out.print("총점:"+"\t"+total[score.length][1]+"\t"+total[score.length][2]+"\t"+total[score.length][3]+"\t");



			//3번 문제
			Scanner sc = new Scanner(System.in,"EUC-KR");

			byte[][] shipBoard = {
				{0,0,0,0,0,0,1,0,0},
				{1,1,1,1,0,0,1,0,0},
				{0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,0,0},
				{1,1,0,1,0,0,0,0,0},
				{0,0,0,1,0,0,0,0,0},
				{0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,1,1,1,0}
					   };

			boolean flag = true;
			String user = "";


			while(true)
			{


				System.out.print("좌표를 입력하세요.(종료는 00)>");
				user = sc.nextLine();

				if(user.length() > 2 || user.length() < 2)
					System.out.print("잘못된 입력입니다. 다시 입력해주세요.");
				else if(user.equals("00"))
					break;

				char userX = user.charAt(0);
				char userY = user.charAt(1);
				
				for(int i =0; i<shipBoard.length;i++)
				{
					for(int j=0;j<shipBoard[i].length;j++)
					{
						if(shipBoard[userX - '0'][userY-'0'] != 1 )
						{
							System.out.println("x");
							flag = false;
							break;
						}
						else
						{
							System.out.println("o");
							flag = false;
							break;
						}						
					}
						if(!flag)
							break;
				}				
			}



			//4번 문제
			Scanner sc = new Scanner(System.in);

			int[][] array = {
				 {1,2,3,4,5},
				 {6,7,8,9,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20},
				 {21,22,23,24,25}
				     };
			
			int user = 0;
			int temp =0;

			for(int i=0; i<array.length;i++)
			{
				for(int j=0;j<array[i].length;j++)
				{
					int idx = (int)(Math.random()*5);
					int idy = (int)(Math.random()*5);					

					temp = array[i][j];
					array[i][j] = array[idx][idy];
					array[idx][idy] = temp;

				}
			}

			for(int i=0;i<array.length;i++)
			{
				for(int j=0; j<array[i].length;j++)
				{
					System.out.print(array[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println();



			while(true)
			{

				System.out.print("1~25의 숫자를 입력하세요.(종료:0)>");
				user = sc.nextInt();
				sc.nextLine();

				if(user == 0)
					break;

				for(int i=0;i<array.length;i++)
				{
					for(int j=0; j<array[i].length;j++)
					{
						if(array[i][j] == user)
							array[i][j] = 0;
						System.out.print(array[i][j]+"\t");

					}
					System.out.println();
				}
				System.out.println();
				
				
			}



			//5번 문제
			class AAA{}
			class BBB{}
			클래스 BBB가 클래스 AAA를 상속 받을려면?

			답 : extends를 쓰면 된다 ex) class BBB extends AAA{}

			//6번 문제
			답 : 메소드 생성?

			//7번 문제
			답 : 부모로 부터 상속 받은 메소드의 값을 변형 시키는것? 
			      부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의하는 것을 오버라이딩이라고 한다. 
			     ex:)

			//8번 문제
			답 : object
			

			//9번 문제

	}
class Car
{
	int gasolineGauge;

	public Car(int gasolineGauge)
	{
		this.gasolineGauge = gasolineGauge;
	}
}
class HybridCar extends Car
{
	int electricGauge;
}
class HybridWaterCar extends HybridCar
{
	int waterGauge;

	public void showCurrentGuage()
	{
		System.out.println("잔여 가솔린 : "+gasolineGauge);
		System.out.println("잔여 전기량 : "+electricGauge);
		System.out.println("잔여 워터량 : "+waterGauge);
	}
}
*/


}