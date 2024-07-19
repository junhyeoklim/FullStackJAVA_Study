package test;

class Point3D
{
	int x,y,z;

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point3D() {
		this(0,0,0);
	}

	public boolean equals(Object obj)
	{			
		Point3D pt = (Point3D) obj;
			return (this.x == pt.x && this.y == pt.y && this.z == pt.z);
	}

	@Override
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}
}


public class Test {

	public static void main(String[] args) {

		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?"+(p1==p2));
		System.out.println("p1.equals(p2)?"+p1.equals(p2));

	}

}
