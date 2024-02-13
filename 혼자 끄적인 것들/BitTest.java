class BitTest
{
	public static void main(String[] args)
	{

		System.out.println("15678의 오른쪽 끝에서 3번째 비트는 " + (15678 >> 2 & 1));
		System.out.println("15678의 오른쪽 끝에서 5번째 비트는 " + (15678 >> 4 & 1));
	}
}