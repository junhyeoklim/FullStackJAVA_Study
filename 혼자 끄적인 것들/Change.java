import java.util.Scanner;


/*class Change
{
	public static void main(String[] args)
	{
		//등비 수열
		int a=0,n=0,d=0,mul=0,cnt=0;

		Scanner sc = new Scanner(System.in);
		System.out.println("첫 항을 입력 해주세요.");
		a = sc.nextInt();
		mul = a;

		System.out.println("공비를 입력 해주세요.");
		d = sc.nextInt();
		cnt = d;

		System.out.println("첫 항으로 부터 몇 번째 등비까지 구할지 입력 해주세요.");
		n = sc.nextInt();
		System.out.println();

		if(n<=0)
		{
			System.out.println("1이상의 숫자를 입력 해주세요!");
			n = sc.nextInt();
			System.out.println();
		}


		for(int i =0; i<n; i++)
		{
			cnt *= cnt;
			mul = mul + mul*d;
			System.out.println(mul/d);
		}


		System.out.println("\n첫 항이 "+a+"이고 등비가"+d+"인 등비수열의 "+n+"번째 값 : "+mul);
	}
}*/
class Change
{
	int a,n,d,sum;

	public void setNumber(int a,int n,int d)
	{
		//a : 첫 항, n : 총 출력할 갯수, d : 공차
		this.a = a;
		this.n = n;
		this.d = d;
		this.sum = a;
		calcNumber();
		System.out.println("\n첫 항이 "+a+"이고 등차가"+d+"인 등차수열의 "+n+"번째 값 : "+(sum-d));
	}

	public void calcNumber()
	{
		for(int i =0; i<n; i++)
		{
			sum += d;
			System.out.println(sum-d);
		}
	}
}
class ChangeMain
{
	public static void main(String[] args)
	{
		//등차 수열
		int a=0,n=0,d=0;
		Change num = new Change();

		Scanner sc = new Scanner(System.in);
		System.out.println("첫 항을 입력 해주세요.");
		a = sc.nextInt();

		System.out.println("공차를 입력 해주세요.");
		d = sc.nextInt();

		System.out.println("첫 항으로 부터 몇 번째 등차까지 구할지 입력 해주세요.");
		n = sc.nextInt();
		System.out.println();

		if(n<=0)
		{
			System.out.println("1이상의 숫자를 입력 해주세요!");
			n = sc.nextInt();
			System.out.println();
		}

		num.setNumber(a,n,d);	
	}
}