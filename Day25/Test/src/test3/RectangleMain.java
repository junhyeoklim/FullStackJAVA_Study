package test3;

class Point
{
	int xPos, yPos;

	public Point(int x, int y)
	{
		xPos = x;
		yPos = y;
	}

	public void showPosition()
	{
		System.out.printf("[%d, %d]", xPos, yPos);
	}
}

class Rectangle
{
	Point upperLeft, lowerRight;

	public Rectangle(int x1, int y1, int x2, int y2)
	{
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	public void showPosition()
	{
		System.out.println("직사각형 위치정보...");
		System.out.print("좌 상단 : ");
		upperLeft.showPosition();
		System.out.println("");
		System.out.print("우 하단 : ");
		lowerRight.showPosition();
		System.out.println("\n");
	}
}

public class RectangleMain
{
	public static void main(String[] args)
	{
		
	}
}