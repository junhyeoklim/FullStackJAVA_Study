class Circle
{
	static final double PI = 3.14;
	double area,round,r;

	public void circleDefine(double num)
	{
		r = num;
	}
 
	public void circleRound()
	{
		round = 2.0*r*PI;
	}

	public void circleArea()
	{
		area = r*r*PI;
	}

	public void circleState()
	{
		System.out.println("반지름 : "+r+" 둘레 : "+round+" 면적 : "+area+"\n");
	}

}

class CircleMain
{
	public static void main(String[] args)
	{
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		Circle c3 = new Circle();

		c1.circleDefine(5);
		c2.circleDefine(10);
		c3.circleDefine(30);

		System.out.println("첫 번째 원");
		c1.circleRound();
		c1.circleArea();
		c1.circleState();

		System.out.println("두 번째 원");
		c2.circleRound();
		c2.circleArea();
		c2.circleState();

		System.out.println("세 번째 원");
		c3.circleRound();
		c3.circleArea();
		c3.circleState();
	}
}
