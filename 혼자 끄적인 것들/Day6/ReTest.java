/*class ReTestMain1
{
	public static int factorial(int num)
	{
		if(num == 1) return 1;
		else return num*factorial(num-1);
	}
	public static void main(String[] args)
	{
		// 1. Factorial을 재귀메소드로
		System.out.println(factorial(5));
	}
}*/

/*class ReTestMain1
{
	public static int factorial(int num)
	{
		if(num == 1) return 1;
		else return num+factorial(num-1);
	}
	public static void main(String[] args)
	{
		// 2. 1~n까지의 합을 재귀메소드로
		System.out.println(factorial(3));
	}
}*/

/*class ReTestMain1
{
	public static int factorial(int num)
	{
		if(num == 1) return 2;
		else return 2*factorial(num-1);
	}
	public static void main(String[] args)
	{
		// 3. 정수 n을 전달 받아서, 2의 n승을 계산하여 반환하는 메소드를 재귀의 형태로
		System.out.println(factorial(5));
	}
}*/

class ReTest
{
	static final double PI = 3.14;
	double radious,round,area;

	public void circleDefine(double r)
	{
		radious = r;
		circleRound();
		circleArea();
		circleState();
	}

	public void circleRound()
	{
		round = 2*PI*radious;
	}

	public void circleArea()
	{
		area = PI*radious*radious;
	}

	public void circleState()
	{
		System.out.println("반지름 : "+radious+" 둘레 : "+round+" 면적 : "+area);
	}
}

class ReTestMain1
{
	public static void main(String[] args)
	{
		ReTest c1 = new ReTest();
		ReTest c2 = new ReTest();
		ReTest c3 = new ReTest();

		c1.circleDefine(5);
		c2.circleDefine(10);
		c3.circleDefine(30);
	}
}






















