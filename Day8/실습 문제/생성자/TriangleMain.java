class Triangle
{
	int width;
	int height;
	int area;

	public Triangle(int width, int height)
	{
		this.width = width;
		this.height = height;

		areaOfTriangle();
		printCS();
	}
	public void areaOfTriangle()
	{
		area = width * height / 2;
	}
	public void printCS()
	{
		System.out.println("밑변 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + area);
	}
}
class TriangleMain
{
	public static void main(String[] args)
	{
		Triangle t1 = new Triangle(10, 5);
		System.out.println();
		Triangle t2 = new Triangle(4, 2);
		System.out.println();
		Triangle t3 = new Triangle(20, 10);

	}
}