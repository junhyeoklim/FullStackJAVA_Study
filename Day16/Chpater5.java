/* chapter5


	1번 문제
	답: 
	    d - > 배열 크기 선언과 초기화는 한번에 할수 없다.
	    e -> 선언과 동시에 크기 지정 안됨

	2번문제
	답: 2
*/
import java.util.Scanner;


class Chpater5
{


	public static void main(String[] args)
	{
		/*//3번문제
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;

		for(int i =0;i<arr.length;i++)
		{
			sum += arr[i];
		}
		System.out.println("sum="+sum);
		

		//4번문제
		int[][] arr ={
				{5,5,5,5,5},
				{10,10,10,10,10}, 
				{20,20,20,20,20}, 
				{30,30,30,30,30}  
			   };

		int total = 0;
		float average =0;


		for(int i =0; i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				total+=arr[i][j];
			}
		}
		average = (float)total/(arr.length*arr[0].length);

		System.out.println("total = "+total);
		System.out.println("average="+average);
		

		//5번 문제
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];

		for(int i=0; i< ballArr.length;i++)
		{
			int j = (int)(Math.random()*ballArr.length);
			int tmp = 0;

			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}

		for(int i=0; i<ball3.length;i++)
		{
			ball3[i] = ballArr[i];
		}


		for(int i=0;i<ball3.length;i++)
		{
			System.out.print(ball3[i]);
		}
		


		//6번 문제

		int[] coinUnit = {500,100,50,10};

		int money =2680;
		System.out.println("money="+money);

		for(int i=0;i<coinUnit.length;i++)
		{
			System.out.println(coinUnit[i]+"원: "+(money/coinUnit[i]));
			money %= coinUnit[i];
		}
		
		//7번 문제
		if(args.length!=1)
		{
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
		}

		int money = Integer.parseInt(args[0]);

		System.out.println("money="+money);

		int[] coinUnit = {500,100,50,10};
		int[] coin = {5,5,5,5};

		for(int i =0;i<coinUnit.length;i++)
		{
			int coinNum = 0;

			coinNum = money/coinUnit[i];
			coin[i] -= coinNum;

			if(coin[i] <0)
			{
				coinNum += coin[i];
				coin[i] = 0;
			}
			money -= coinNum*coinUnit[i];
			System.out.println(coinUnit[i]+"원: "+coinNum);
		}

		if(money > 0)
		{

			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);
		}

		System.out.println("=남은 동전의 개수 =");


		for(int i =0; i<coinUnit.length;i++)
		{
			System.out.println(coinUnit[i]+"원:"+coin[i]);
		}
		



		//8번 문제


		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];

		for(int i=0; i< answer.length;i++)
		{
			counter[answer[i]-1]++;

			/*if(answer[i] == 1)
				counter[0] +=1;
			else if(answer[i] == 2)
				counter[1] +=1;
			else if(answer[i] == 3)
				counter[2] +=1;
			else if(answer[i] == 4)
				counter[3] +=1;*/
		}

		for(int i=0;i<counter.length;i++)
		{
			System.out.print(counter[i]);

			for(int j=0; j < counter[i];j++) {
				System.out.print("*"); // counter[i] ‘*’ . 의 값 만큼 을 찍는다
			}
			/*
			System.out.print((i+1));
	
			for(int j=0; j<counter[i];j++)
				System.out.print("*");
			System.out.println();
			*/
		}
		



		//9번 문제

		char[][] star ={
			{'*','*',' ',' ',' '},
			{'*','*',' ',' ',' '},
			{'*','*','*','*','*'},
			{'*','*','*','*','*'}
			     };

		char[][] result = new char[star[0].length][star.length];

		for(int i=0; i< star.length;i++)
		{
			for(int j=0; j< star[i].length;j++)
			{
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();


		for(int i=0; i<star.length;i++)
		{
			for(int j=0; j< star[i].length;j++)
			{
				result[j][i] = star[3-i][j];
			}
		}

		for(int i=0;i<result.length;i++)
		{
			for(int j =0;j<result[i].length;j++)
			{
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

		

		//10번 문제

		char[] abccode =
			{
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{','}',
				';',':',',','.','/'

			};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};

		String src = "abc123";
		String result ="";

		for(int i=0; i<src.length();i++)
		{
			char ch =src.charAt(i);

			if(ch >= 'a' && ch <='z')
				result += abccode[ch-'a;];
			else if(ch >= '0' && ch <= '9')
				result += numCode[ch-'0'];
		}
		System.out.println("src:"+src);
		System.out.println("result:"+result);


		

		//11번 문제


		int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},
			{40,40,40},
			{50,50,50}
		};

		int[][] result = new int[score.length+1][score[0].length+1];

		for(int i=0; i< score.length;i++)
		{
			for(int j=0;j<score[i].length;j++)
			{
				result[i][j] = score[i][j];
				result[i][score[i].length] += result[i][j];
				result[score.length][j] += result[i][j];

				result[score.length][score[i].length] += result[i][j];
			}
		}


		for(int i =0; i< result.length;i++)
		{
			for(int j=0;j< result[i].length;j++)
			{
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}


		

		//12번 문제

		Scanner sc = new Scanner(System.in,"EUC-KR");

		String[] quize ={"chair","computer","integer"};
		String[] collect = {"의자","컴퓨터","정수"};
		String answer = "";
		int cnt = 0;


		for(int i =0; i<quize.length;i++)
		{
			System.out.print("Q"+(i+1)+". "+quize[i] +"의 뜻은?");
			answer = sc.nextLine();

			if(answer.equals(collect[i]))
			{
				System.out.println("정답입니다.\n");
				cnt++;
			}
			else
				System.out.println("틀렸습니다. 정답은 "+collect[i]+"입니다.");
		}

			System.out.println("전체 " +quize.length+"문제 중"+cnt+"문제 맞추셨습니다.");


		*/

			//13번 문제

		String[] words = {"television","computer","mouse","phone"};

		Scanner scanner = new Scanner(System.in,"EUC-KR");

		for(int i=0; i<words.length;i++)
		{
			char[] question = words[i].toCharArray();

			int idx = (int)(Math.random()*question.length);
			char temp = question[i];			
			question[i] = question[idx];
			question[idx] = temp;

			System.out.printf("Q%d. %s의 정답을 입력 하세요.>",i+1,new String(question));

			String answer = scanner.nextLine();

			if(words[i].equals(answer.trim()))
				System.out.printf("맞았습니다. %n%n");
			else
				System.out.printf("틀렸습니다. %n%n");
		}

	}
}