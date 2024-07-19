package test;

public class Test6 {

	public static double round(double num, int idx)
	{
		return Math.round(num*Math.pow(10, idx))/Math.pow(10, idx);
	}

	public static void main(String[] args) {
		System.out.println(round(3.1415,1));
		System.out.println(round(3.1415,2));
		System.out.println(round(3.1415,3));
		System.out.println(round(3.1415,4));
		System.out.println(round(3.1415,5));
	}
}
