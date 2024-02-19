class SimpleMath    // 단순 계산 클래스
{
	public static final double PI=3.1415;	
	public static double add(double n1, double n2){ return n1+n2; }
	public static double min(double n1, double n2){ return n1-n2; }
	public static double mul(double n1, double n2){ return n1*n2; }
}

class AreaMath    // 넓이 계산 클래스
{	
	public static double calCircleArea(double rad)
	{
		double result=SimpleMath.mul(rad, rad);
		result=SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public static double calRectangleArea(double width, double height)
	{		
		return SimpleMath.mul(width, height);
	}
}

class PerimeterMath    // 둘레 계산 클래스
{	
	public static double calCirclePeri(double rad)
	{
		double result=SimpleMath.mul(rad, 2);
		result=SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public static double calRectanglePeri(double width, double height)
	{
		return SimpleMath.add(SimpleMath.mul(width, 2), SimpleMath.mul(height, 2));
	}
}

public class HowMethod
{
	public static void main(String[] args)
	{		
		System.out.println("원의 넓이: "+AreaMath.calCircleArea(2.4));
		System.out.println("직사각형 둘레: "+PerimeterMath.calRectanglePeri(2.0, 4.0));
	}
}