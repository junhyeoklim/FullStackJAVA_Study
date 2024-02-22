import java.util.Scanner;

class ArrayTest1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];
		int temp = 0;

		/*for(int i = 0; i < num.length;i++)
		{
			System.out.println(i+1+"번째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}
		for(int j = 0; j < num.length; j++)
		{
			for(int k =j+1; k< num.length; k++)
			{
				if(num[j] > num[k])
				{
					temp = num[k];
					num[k] = num[j];
					num[j] = temp;
				}
			}		

		}
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i]+"\t");*/


		//버블 정렬?
		for(int i = 0; i < num.length;i++)
		{
			System.out.println(i+1+"번째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}
		for(int j = 0; j < num.length; j++)
		{
			for(int k =1; k< num.length; k++)
			{
				if(num[k-1] > num[k])
				{
					temp = num[k];
					num[k] = num[k-1];
					num[k-1] = temp;
				}
			}		

		}
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i]+"\t");
	}
}