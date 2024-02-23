import java.util.Scanner;


class ArrayTest2Main
{
	/*public static void swapOneDArr(int[] arr)
	{



	}*/
	public static void swapTwoDArr(int[][] arr)
	{
		int[] lastAdd = arr[arr.length-1];

		for(int i=arr.length-1;i>0;i-- )
		{
			arr[i] = arr[i-1];
		}

		arr[0] = lastAdd;
		
	}

	public static void main(String[] args)
	{
		int[][] array ={
				{1,2,3},
				{4,5,6},
				{7,8,9}
			      };

		swapTwoDArr(array);
		
		for(int i=0;i<array.length;i++)
		{
			for(int  j=0; j<array[i].length;j++)
			{
				System.out.print(array[i][j]);
			}
			System.out.println("");
		}
	}
}


/*class ArrayTest2Main
{
	public static void addOneDArr(int[] arr, int add)
	{
		for(int i=0;i<arr.length; i++)
			arr[i] += add;
	}

	public static void addTwoDArr(int[][] arr, int add) 
	{ 
		for(int i  = 0; i< arr.length; i++)
		{
			addOneDArr(arr[i],add);
		}		
	 }


	public static void main(String[] args)
	{

		int[][] array = new int[2][3];

		for(int i=0;i<array.length;i++)
		{
			for(int  j=0; j<array[i].length;j++)
			{
				array[i][j] = i+j;
			}
		}

		addTwoDArr(array,5);

		for(int i=0;i<array.length;i++)
		{
			for(int  j=0; j<array[i].length;j++)
			{
				System.out.print(array[i][j]);
			}
			System.out.println("");
		}
	}
}

*/
/*class  ArrayTest2Main
{
	public static int minValue(int[] arr)
	{
		int min = arr[0];
		for(int i=1;i<arr.length;i++)
			if(min>arr[i]) min = arr[i];
		return min;
	}
	public static int maxValue(int[] arr)
	{
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
			if(max<arr[i]) max = arr[i];
		return max;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		System.out.println("숫자 " + arr.length + "개를 입력하세요.");
		for(int i=0;i<arr.length;i++)
			arr[i] = sc.nextInt();

		System.out.println("가장 작은 수는 " + minValue(arr));
		System.out.println("가장 큰 수는 " + maxValue(arr));
	}
}

*/
/*class ArrayTest2Main
{
	public static int minValue(int[] arr)
	{
		int min = 0;
		for(int j =0; j<arr.length-1;j++)
		{
			for(int i =j+1; i<arr.length; i++)
			{
				 if(arr[j] < arr[i])
					min = arr[j];
				else if(arr[j] > arr[i])
					min = arr[i];
				else
					continue;
			}
		}
		return min;
	}

	public static int maxValue(int[] arr)
	{
		int max=0;

		for(int i =0; i<arr.length-1; i++)
		{
			if(arr[i] > arr[i+1])
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


		for(int i = 0; i< array.length; i++)
		{
			System.out.println(i+1+"번 째 숫자를 입력 해주세요!");
			array[i] = sc.nextInt();
		}

		System.out.println("최소값 : "+minValue(array)+"최대 값 : "+maxValue(array));
	}
}*/