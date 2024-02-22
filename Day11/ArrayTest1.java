import java.util.Scanner;

class ArrayTest1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];
		int temp = 0,tempj=0;

		for(int i = 0; i < num.length;i++)
		{
			System.out.println(i+1+"번째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}
		//치환 정렬
		/*for(int j = 0; j < num.length-1; j++)
		{
			
			for(int k =j+1; k< num.length; k++)
			{
				if(num[j] > num[k])
				{
					temp = num[k]
					num[k] = num[j]
					num[j] = temp;
				}
			}		
		}*/
		/*//개선된 치환 정렬
		for(int j = 0; j < num.length-1; j++)
		{
			tempj= j;
			for(int k =j+1; k< num.length; k++)
			{
				if(num[j] > num[k]) i =j;
			}		

			temp = num[tempi];
			num[tempi] = num[j];
			num[j] = temp;
			j = tempj;
	
		}
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i]+"\t");
		*/

		//버블 정렬?
		for(int i = 0; i < num.length;i++)
		{
			System.out.println(i+1+"번째 숫자를 입력 해주세요!");
			num[i] = sc.nextInt();
		}
		for(int j = 0; j < num.length-1; j++)
		{
			for(int k =0; k< num.length-1-j; k++)
			{
				if(num[k] > num[k+1])
				{
					temp = num[k];
					num[k] = num[k+1];
					num[k+1] = temp;
				}
			}
			//만약 정렬이 다 됐다면 break;
		}
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i]+"\t");
		
	}
}