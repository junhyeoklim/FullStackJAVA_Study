class Triangle
{
	int height,bottom,width;

	public void TriangleDefine(int num1,int num2)
	{
		bottom = num1;
		height = num2;
	}

	public void TriangleWidth()
	{
		width = (height*bottom)/2;
	}

	public void TriangleState()
	{
		System.out.println("밑변 : "+bottom+" 높이 : "+height+" 넓이 : "+width+"\n");
	}
}
class TriangleMain
{
	public static void main(String[] args)
	{
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		Triangle t3 = new Triangle();

		t1.TriangleDefine(10,5);
		t2.TriangleDefine(4,2);
		t3.TriangleDefine(20,10);

		System.out.println("첫 번째 삼각형");
		t1.TriangleWidth();
		t1.TriangleState();

		System.out.println("두 번째 삼각형");
		t2.TriangleWidth();
		t2.TriangleState();

		System.out.println("세 번째 삼각형");
		t3.TriangleWidth();
		t3.TriangleState();
	}
}