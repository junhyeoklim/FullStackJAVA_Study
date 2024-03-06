import java.util.Arrays;
import java.util.Scanner;



class Test
{
	public static void main(String[] args)
	{
		/*// 1번 문제
		int num = 10; -> num을 문자열로
		
		int num = 10;
		System.out.println(String.valueOf(num));
		

		//2번 문제
		String numStr = "20";
		int num = 0;

		System.out.println(Integer.parseInt(numStr));
				

		//3번 문제
		String str = "0123456789";

		System.out.println(str.substring(3,10));

		//4번 문제
		String str1 = "0123456789";

		System.out.println(str1.substring(4,7));
		

		//5번 문제
		double num = 3.5;
		System.out.println(Math.round(num));

		//6번 문제
		double num = 3.5;
		System.out.println(Math.floor(num));

		//7번 문제
		double num2 = 3.1;
		System.out.println(Math.ceil(num2));


		//8번 문제
		int[] nums = {5,4,1,3,2};

		Arrays.sort(nums);

		for(int i =0; i<nums.length; i++)
		{
			System.out.print(nums[i]);
		}


		//9번 문제
		int[] src = {5,4,1,3,2};
		int[] dest = new int[10];

		System.arraycopy(src,0,dest,3,src.length);

		for(int i =0; i< dest.length; i++)
		{
			System.out.print(dest[i]);
		}

		//10번 문제 
		String str = "";

		System.out.println(str.valueOf(args[0]));


		//11번 문제
		int[] num1 = {0,1,2,3,4,5,6,7,8,9};


		for(int i =0; i< num1.length;i++)
		{
			int idx = (int)(Math.random()*num1.length);
			int temp = 0;
			temp = num1[idx];
			num1[idx] = num1[i];
			num1[i] = temp;
		}
		

		for(int i =0; i<num1.length;i++)
		{
			System.out.print(num1[i]);
		}

		//13번 문제
		int[] arr = {10,20,30,40,50};
		int sum = 0;

		for(int e: arr)
		{
			sum+=e;
			System.out.println(sum);
		}

		//14번 문제
		int money = Integer.parseInt(args[0]);
		int[] coin = {500,100,50,10};
		int[] coinTotal = {5,5,5,5};



		for(int i=0; i<coin.length;i++)
		{
			int coinCount = 0;

			coinCount = money/coin[i]; 
			coinTotal[i] -= coinCount;

			if(coinTotal[i]<0)
			{
				coinCount += coinTotal[i];
				coinTotal[i] = 0;
			}

			money -= coin[i]*coinCount;


			System.out.println(coin[i] + ": "+ coinTotal[i] + "개"); 
			
		}

		if(money>0)
			System.out.println("거스름 돈이 부족합니다.");


		//15번 문제
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] count = new int[4];
		

		for(int i = 0;i<answer.length;i++)
		{
			count[answer[i]-1]++;
		}

		for(int i =0;i<count.length;i++)
		{

			System.out.print(count[i]+": ");

			for(int j=0;j<count[i];j++)
			{
				System.out.print("*");
			}

			System.out.println();
		}


		//16번 문제
		char[][] star = {
			{'*','*',' ',' ',' '},
			{'*','*',' ',' ',' '},
			{'*','*','*','*','*'},
			{'*','*','*','*','*'}
			       };
		char[][] spin = new char[star[0].length][star.length];

		for(int i =0; i<star.length; i++)
		{
			for(int j =0; j<star[i].length; j++)
			{
				System.out.print(star[i][j]);
			}
			System.out.println();
		}

		for(int i= 0 ; i<star.length;i++)
		{
			for(int j =0; j<star[i].length; j++)
			{
				spin[j][i] = star[star.length-1-i][j];
			}
		}

		System.out.println();

		for(int i =0; i<spin.length; i++)
		{
			for(int j =0; j<spin[i].length; j++)
			{
				System.out.print(spin[i][j]);
			}
			System.out.println();
		}



		//17번 문제
		char[] check = {'`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'};
		char[] checkNum = {'q','w','e','r','t','y','u','i','o','p'};
		int idx = 0;
		Scanner sc = new Scanner(System.in);
		String str = "";

		System.out.println("문자열을 입력 해주세요!");
		str = sc.nextLine();

		for(int i =0; i< str.length();i++)
		{
			char ch =  str.charAt(i);

			if(ch >= 'a' && ch <= 'z')
				System.out.print(check[ch - 'a']);
			else if(ch >= '0' && ch <= '9')
				System.out.print(checkNum[ch-'0']);		
		}


		//18번 문제
		int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},
			{40,40,40},
			{50,50,50},
			      };

		int[][] newScore = new int[score.length+1][score[0].length+1];

		for(int i=0;i<score.length;i++)
		{
			for(int j=0;j<score[i].length;j++)
			{
				newScore[i][j] = score[i][j];
				newScore[i][score[i].length] += score[i][j];
				newScore[score.length][j] += score[i][j];
				newScore[score.length][score[i].length] += score[i][j];

			}
		}

		for(int i=0; i<newScore.length;i++)
		{
			for(int j=0; j<newScore[i].length;j++)
			{
				System.out.print(newScore[i][j]+"\t");
			}
			System.out.println();
		}


		//19번 문제
		String[][] words = {
			{"apple"},
			{"banana"},
			{"chair"}
				};
		String[][] check = {
			{"사과"},
			{"바나나"},
			{"의자"}

				};
		String answer = "";
		int cnt = 0;

		Scanner sc = new Scanner(System.in,"EUC-KR");


		for(int i =0; i< words.length; i++)
		{
			System.out.println("Q"+(i+1)+words[i][0]+"의 뜻은?");
			answer = sc.nextLine();

			if(answer.equals(check[i][0]))
			{
				System.out.println("정답입니다!");
				cnt++;
			}
			else
				System.out.println("틀렸습니다.");
		}
		System.out.println("총 "+words.length+"문제중 " + cnt+ "개 맞혔습니다.");


		//20번 문제

		String[] str = {"computer","apple","banana","chair","phone"};
		String answer = "";

		Scanner sc = new Scanner(System.in,"EUC-KR");


		for(int i =0; i<str.length;i++)
		{
			char[] question = str[i].toCharArray();
			int idx = (int)(Math.random()*question.length);
			char temp = ' ';

			temp = question[i];
			question[i] = question[idx];
			question[idx] = temp;

			System.out.println("Q"+(i+1)+". "+new String(question)+"은 무엇인가요?");
			answer = sc.nextLine();

			if(answer.equals(str[i]))
				System.out.println("정답입니다!");
			else
				System.out.println("틀렸습니다!");
		}
		

		//21번 문제
		Scanner sc = new Scanner(System.in,"EUC-KR");
		String str = "";

		System.out.println("문자열을 입력 해주세요");
		str = sc.nextLine();

		System.out.println(str+" : "+isNumber(str));

	}

	public static boolean isNumber(String str)
	{

		for(int i=0;i<str.length();i++)
		{
			char check = str.charAt(i);

			if(!(check >= '0' && check <= '9'))
				return false;
			else if(check == ' ' || check == 0)
				return false;
		}
		return true;
	}
	*/


		//12번 문제
		Scanner sc = new Scanner(System.int);
		int bcnt = 0; scnt =0;
		int cpu = 0;
		String cpuStr = "";

		while(true)
		{
			cpu = (int)(Math.random(900)+100);
			cpuStr = String.valueOf(cpu);

			if(checkNum(cpuStr))
				break;
		}

		System.out.println("!!재밌는 숫자 야구 게임!!");

		while(true)
		{
			System.out.println("!!숫자를 입력 해주세요!!");
			user = sc.nextLine();


			for(int i =0; i<cpuStr.length(); i++)
			{
				
			}

		}


	}


	public static boolean checkNum(char[] ch)
	{
		for(int i=0; i< ch.length-1;i++)
		{
			for(int j=i+1;j<ch.length; j++)
			{
				if(ch[i] == ch[j])
					return false;
			}
		}
		return true;
	}

	
}




