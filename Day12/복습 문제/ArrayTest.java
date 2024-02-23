import java.util.Scanner;

class ArrayTest
{
	public static void main(String[] args)
	{
		/*//2번 문제
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int temp = 0;

		for(int i = 0; i < num.length;i++)
		{
			System.out.println((i+1)+"번 째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}


		for(int j = 0; j < num.length;j++)
		{
			for(int k = j+1; k < num.length; k++)
			{
				if(num[j] > num[k])
				{
					temp = num[k];
					num[k] = num[j];
					num[j] = temp;
				}
			}
		}

		for(int x = 0; x < num.length; x++)
		{
			System.out.print(num[x] + "\t");
		}*/

		//3번 문제

		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int temp = 0;


		for(int i = 0; i < num.length;i++)
		{
			System.out.println((i+1)+"번 째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}


		for(int j = 0; j < num.length;j++)
		{
			for(int k = 0; k < num.length-1; k++)
			{
				if(num[k] > num[k+1])
				{
					temp = num[k+1];
					num[k+1] = num[k];
					num[k] = temp;
				}
			}
		}

		for(int x = 0; x < num.length; x++)
		{
			System.out.print(num[x] + "\t");
		}

	}
}