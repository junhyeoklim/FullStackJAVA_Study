import java.util.Scanner;
import java.util.Arrays;

class Test2
{
	public static void main(String[] args)
	{
		/*//1번문제
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");
		int user = sc.nextInt();
		sc.nextLine();

		System.out.println(user+"는 "+String.valueOf(user).length()+"자리 숫자 입니다.");
	

		//2번 문제
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");
		int user = sc.nextInt();
		sc.nextLine();
		int leng = String.valueOf(user).length();
		int[] arr = new int[leng];

		makeArray(arr);
		*/
		Scanner sc = new Scanner(System.in);
		int[] num = {1,3,4,5,7,10,27,39,50,92};
		int checklen = 0;
		int cnt = 0;
		int first = 0;
		int last = num.length-1;
		int mid = (first+last)/2;
		Arrays.sort(num);


		System.out.println("숫자를 입력해주세요!");
		int user = sc.nextInt();
		sc.nextLine();

		

		while(first<=last)
		{		
			cnt++;
			if(num[mid] > user)
				last = mid-1;
			else if(num[mid] < user)
				first = mid+1;
			else if(num[mid] == user)
			{

				System.out.println("mid:"+mid+" "+cnt+"회 검색");
				break;
			}
			mid = (first+last)/2;
		}


	}

	/*public static void makeArray(int[] arr)
	{
		for(int i=0; i<arr.length;i++)
			arr[i] = i+1;

		for(int i=0; i< arr.length;i++)
			System.out.print(arr[i]+"\t");

	}*/
}