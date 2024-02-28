import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;



class RandomTest
{
	public static void main(String[] args)
	{

		Random random = new Random();
		int[] num = new int[45];
		int idx = 0,temp=0;



		for(int i =0; i<num.length;i++)
		{
			num[i] = random.nextInt(45)+1;

			for(int j=0; j<i;j++)
			{
				if(num[i] == num[j])
					i--;
			}
		}

		for(int j = 0; j<num.length;j++)
		{
			idx = random.nextInt(45);

			temp = num[j];
			num[j] = num[idx];
			num[idx] = num[j];			
		}


		for(int k = 0; k<num.length;k++)
			System.out.print(num[k]+"\t");
	}
}




/*class RandomTest
{

	public static void main(String[] args)
	{

		Random random = new Random();

		int[] lotto = new int[6];

		for(int i =0; i< lotto.length-1; i++)
		{
			System.out.print((char)('A'+i)+"자 동 ");

			for(int j=0; j< lotto.length;j++)
			{
				lotto[j] = random.nextInt(45)+1;
				for(int k =0;k<j;k++)
				{
					if(lotto[j] == lotto[k])
					{
						j--;
					}
				}
			}
			Arrays.sort(lotto);

			for(int x=0;x<lotto.length;x++)
				System.out.print(lotto[x]+"\t");
			System.out.println();
		}

	}



}
*/



/*class RandomTest
{


	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		int minB = 0;
		int maxA = 0;
		int result = 0;

		System.out.println("최대 정수를 입력 해주세요!");
		maxA = sc.nextInt();
		sc.nextLine();

		System.out.println("최소 정수를 입력 해주세요!");
		minB = sc.nextInt();
		sc.nextLine();



		for(int i = 0; i<10;i++)
		{
			result = random.nextInt(maxA-minB+1)+minB;
			
			System.out.println(result);
		}
	}
}*/

