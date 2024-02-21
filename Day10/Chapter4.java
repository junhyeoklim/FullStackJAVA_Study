class Chapter4
{
	public static void main(String[] args)
	{
		/*1. int형 변수 x가 10보다 크고 20보다 작을 때 ture인 조건식
		  답 : if( x > 10 && x < 20)

		   2. char형 변수 ch 가 공백이나 탭이 아닐 때 ture인 조건식
		   답 : if(ch != ' ' && ch != '	')

		   3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
		   답 : if(ch == 'x' || ch == 'X')

		   4. char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
		   답 : if(ch >= '0' && ch <= '9')

		   5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		   답 : if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')

		   6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식
		   답 : if(year%400 == 0 || year%4 == 0 && year%100 !=0)

		   7. boolean형 변수 powerOn가 false일 때 ture인 조건식
		   답 : if(powerOn != ture)

		    8. 문자열 참조변수 str이 "yes"일 때 true인 조건식
		    답 : if(str.equals("yes"))

		

		//4-2. 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		int sum = 0;
		
		for(int i =1; i <=20; i++)
		{
			if(i%2 !=0 && i%3 !=0) 
			{
				sum += i;
				System.out.println("sum : "+ sum);
			}
		}
		System.out.println("2 또는 3의 배수가 아닌 수의 총합 : "+sum);
		
		

		//4-3. 1+(1+2)+(1+2+3)+...+(1+2+3+...+10)의 결과를 계산

		int sum = 0;

		for(int i =1; i <=10;i++)
		{
			for(int j =1; j<=i; j++)
			{
				sum+=j;

			}
			System.out.println(sum);
		}
		System.out.println(sum);
		
		//4-4 1+(-2)+3+.. 과 같은 식으로 계속 더해나갔을 때, 몇 까지 더해야 총합이 100이상이 되는지 구하시오.


		int sum = 0,j = 1;

		for(;;)
		{	

			if(j%2 == 0)
			{
				sum -=j;
			}
			else
			{
				sum  += j;
			}
			if(sum >= 100)
			{
				System.out.println("sum이 100을 넘었을때의 수 : " + j + " sum의 값 : "+sum);
				break;
			}
			j++;
		}
		

		//4-5 다음의 for문을 while문으로 변경하시오.
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=i; j++)
			System.out.print("*");
			System.out.println();
		}
		
		int i= 0;

		while(i<=10)
		{
			int j = 0;

			while(j<=i)
			{
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			
		}
		

		//4-6 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.


		for(int i =1; i<=6; i++)
		{
			for(int j = 1; j<=6; j++)
			{
				if(i+j == 6)
				{
					System.out.println("첫 번째 주사위 눈 : " +i+" 두 번째 주사위 눈 : " + j);
				}
			}			
		}
		


		//4-7 Math.random()을 이용해서 1부터 6 사이의 임의의 정수를 변수 value에 저장 하는 코드를 완성하라.
		int value = (int)(Math.random()*6+1);
		System.out.println("value:"+value);

		


		//4-8 방정식 의 모든 해를 구하시오 단 x와 y는 정수이고 각각의 범위는 2x+4y=10 . , x y0<=x<=10, 0<=y<=10 이다.

		for(int x = 0; x<=10; x++)
		{
			for(int y=0; y<=10; y++)
			{
				if((2*x+4*y) == 10)
				{
					System.out.println("x= "+ x + ",  y="+ y);
				}
			}
		}
		


		//4-9
		String str = "12345";
		int sum = 0;
		for(int i=0; i < str.length(); i++) {
			sum+= (str.charAt(i) - 48);
		}
		System.out.println("sum="+sum);
		


		//4-10

		int num = 12345;
		int sum = 0;
		
		for(int i =1; i <=num%10; i++){

			sum+=i;
			
		}
		/* 답안지 풀이(내 방식도 맞긴 한데 출제자의 의도 파악을 하면 이게 정답)
		whil(num>0)
		{
			sum += num%10;
			num /= 10;
		}
		*/
		System.out.println("sum="+sum);



		

		//4-11
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; // 세번째 값
		System.out.print(num1+","+num2);

		for (int i = 0 ; i < 8 ; i++ ) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print(","+num3);
		}

		




		//4-12
		int i =1,j=1;

		for(int h = 0; h<=2;h++)
		{
			for(j=1;j<=3;j++)
			{
				for(int z= 2+3*h; z<=4+3*h; z++)
				{
					if(z<10)
						System.out.print(z+"*"+j+"="+(z*j)+"\t");					
				}
				System.out.println();
			}
				System.out.println();
				System.out.println();
		}
		
		//4-13 코드가 어떻게 돌아가는지 한번 생각 해보자
		String value = "12o54";
		char ch = ' ';
		boolean isNumber = true;
		// charAt(int i) 반복문과 를 이용해서 문자열의 문자를
		// . 하나씩 읽어서 검사한다
		for(int i=0; i < value.length() ;i++) {			

			ch = value.charAt(i);

			if( ch >= '0'  && ch <= '9')
			{
				isNumber = true;
			}
			else
			{
				isNumber = false;
				break;
			}
		}
		if (isNumber) {
		System.out.println(value+" 는 숫자입니다 .");
		} else {
		System.out.println(value+" 는 숫자가 아닙니다 .");
		}


		//4-14
		// 1~100 사이의 임의의 값을 얻어서  answer 에 저장한다.
		int answer = (int)(Math.random()*100)+1;
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기위한 변수
		// Scanner 화면으로 부터 사용자입력을 받기 위해서 클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			count++;
			System.out.print("1 과 100사이의 값을 입력하세요 :");  
			input = s.nextInt(); //  입력받은 값을 input변수 에 저장한다.
		
			if(input > answer)
			{
				System.out.println("더 작은 수를 입력하세요.");
			}
			else if(input < answer)
			{
				System.out.println("더 큰 수를 입력하세요.");
			}
			else 
			{
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 "+ count + "번입니다.");
				break;
			}

		} while(true); // 무한반복문
		
		*/
		//4-15
		int number = 12321;
		int tmp = number;
		int result =0; // number 변수 를 거꾸로 변환해서 담을 변수
		while(tmp !=0) {
			result = result*10 + tmp%10;
			tmp /= 10;
		}
		if(number == result)
		System.out.println( number + "는 회문수 입니다 ."); 
		else
		System.out.println( number + "는 회문수가 아닙니다 ."); 
		}

}