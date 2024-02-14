package view;

public class Change {
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
