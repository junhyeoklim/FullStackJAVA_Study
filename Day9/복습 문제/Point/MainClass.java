class Point
{
	private int xPos, yPos;

	public Point(int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	public void showPointInfo()
	{
		System.out.println("[" + xPos + ", " + yPos + "]");
	}
}
class Circle
{
	private Point center;
	private int radius;

	Circle(int x,int y, int r)
	{
		center = new Point(x,y);
		radius = r;
	}
	public void showCircleInfo()
	{
		System.out.println("radius : " + radius);
		center.showPointInfo();
	}
}

class Ring
{
	private Circle ic;
	private Circle oc;

	Ring(int ix,int iy,int ir, int ox,int oy,int or)
	{
		ic = new Circle(ix,iy,ir);
		oc = new Circle(ox,oy,or);
	}
	public void showRingInfo()
	{
		System.out.println("Inner Circle Info...");
		ic.showCircleInfo();
		System.out.println("Outer Circle Info...");
		oc.showCircleInfo();
	}
}
class MainClass
{
	public static void main(String[] args)
	{
		Ring ring = new Ring(1, 1, 4, 2, 2, 9);
		ring.showRingInfo();
	}
}