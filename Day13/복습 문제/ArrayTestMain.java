import java.util.Scanner;


/*class ArrayTestMain
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int user=0,cpu=0,result=0;
		String flag = "y";

		while(true)
		{
			if(falg.equals("y"))
			{
			System.out.println("숫자를 입력 해주세요!");
			System.out.println("1.가위 2.바위 3.보");
			user = sc.nextInt();
			cpu = Math.random()*3+1;
			result = user - cpu;



			switch(result)
			{
				case 1: case -2:
				{
					System.out.println("이겼습니다!");
					break;
				}
				case 0:
				{
					System.out.println("비겼습니다!");
					break;
				}
				case -1:case 2:
				{
					System.out.println("졌습니다!");
					break;
				}
			}
			}
			else if(flag.equals("n")
		}
	}
}
*/



/*class ArrayTestMain
{
	public static void main(String[] args)
	{
		for(int i=1; i<=100;i++)
		{

			if((i%10)%3 == 0 && i%10!=0)
			System.out.print(i+"짝!");
			System.out.println(i);
		}
	}
}
*/






/*class ArrayTestMain
{
	public static void main(String[] args)
	{

		int[][] arr ={
				{10,20,30},
				{40,50,60},
				{70,80,90}
			  };

		//7번문제
		/*for(int i =0; i<arr.length;i++)
		{
			for(int j =0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}



		//8번 문제
		for(int[] e: arr)
		{
			for(int k : e)
			{
				System.out.print(k+"\t");
			}
			System.out.println();
		}
	}
}
*/




/*class ArrayTestMain
{

	public static int minValue(int[] arr)
	{
		int min = arr[0];

		for(int e:arr)
		{
			if(min > e)
			{
				min = e;
			}
		}
		return min;

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] array = {1,2,3,4,5};
		int i =0;

		/*for(i=0;i<array.length;i++)
		{
			System.out.println((i+1)+"번째 숫자를 입력 해주세요!");
			array[i] = sc.nextInt();
		}
		System.out.println("최소값 테스트 : "+minValue(array));
	}
}
*/



/*class ArrayTestMain
{
	public static void changeArray(int[][] arr)
	{
		int[] lastarray = arr[2];

		for(int i = arr.length-1; i>0;i--)
		{
			arr[i] = arr[i-1];
		}
		arr[0] = lastarray;
	}


	public static void main(String[] args)
	{
		int[][] array = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
			      };

		changeArray(array);

		for(int i = 0; i<array.length;i++)
		{
			for(int j =0; j<array[i].length;j++)
			{
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
}*/







/*class ArrayTestMain
{
	public static void addOneDArr(int[] arr,int add)
	{
		for(int i = 0; i<arr.length; i++)
		{
			arr[i]+=add;
		}
	}


	public static void addTwoDArr(int[][] arr,int add)
	{
		for(int i =0; i<arr.length;i++)
			addOneDArr(arr[i],add);

	}
	

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int[][] array = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
			      };


		for(int i = 0; i<array.length;i++)
		{
			for(int j =0; j<array[i].length;j++)
			{
				System.out.println("["+(i)+"]"+"["+j+"]"+"숫자 입력");
				array[i][j] = sc.nextInt();
			}
		}
		addTwoDArr(array,5);

		for(int i = 0; i<array.length;i++)
		{
			for(int j =0; j<array[i].length;j++)
			{
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
*/



















/*class ArrayTestMain
{
	public static int minValue(int[] arr)
	{
		int min = arr[0];

		for(int i =0;i<arr.length;i++)
		{
			if(min > arr[i])
			{
				min = arr[i];
			}
		}
		return min;

	}
	public static int maxValue(int[] arr)
	{
		int max = arr[0];

		for(int i =0;i<arr.length;i++)
		{
			if(max < arr[i])
			{
				max = arr[i];
			}
		}
		return max;
	}
	




	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] array = new int[5];
		int i =0;

		for(i=0;i<array.length;i++)
		{
			System.out.println((i+1)+"번째 숫자를 입력 해주세요!");
			array[i] = sc.nextInt();
		}


		System.out.println("최소값 테스트 : "+minValue(array));
		System.out.println("최대값 테스트 : "+maxValue(array));


	}
}
*/