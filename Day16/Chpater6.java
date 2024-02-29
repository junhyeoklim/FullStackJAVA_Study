class Chpater6
{

	public static void main(String[] args)
	{	
		/*8번문제
		- 클래스변수(static변수) : width,height
		- 인스턴스변수 : kind,num
		- 지역변수 : k,n

		9번 문제
		답 : static을 붙여야 하는 변수는 weapon,armor이다.
		     그 이유는 모든 병사들의 공격력과 방어력이 같아야 하므로 
		     모든 병사 객체들이 참조 할수 있어야 하기 때문이다.

		10번 문제
		답 : e

		11번 문제
		답 : b,a

		12번 문제
		답 : c,d

		13번 문제
		답 : b,c,d

		14번 문제
		답 : c,d,e

		15번 문제
		답 : c

		16번 문제
		답 : a,c

		17번 문제
		답 : b

		18번 문제
		답 : 라인 A
		이유 : 클래스 변수에다가 인스턴스 변수를 집어 넣었기 떄문에 오류가 난다.

		19번 문제
		답 : ABC123
		     After change: ABC123

		
		//20번 문제
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));

	}

	public static int[] shuffle(int[] num)
	{
		int temp = 0;

		for(int i =0; i<num.length;i++)
		{
			int idx = (int)(Math.random()*num.length);
			temp = num[i];
			num[i] = num[idx];
			num[idx] = temp;
		}
		return num;
	}	
	*/

	//21번 문제
}
/*
class MyPoint
{
	//6~7번 문제
	int x;
	int y;

	public MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public double getDistance(int x1,int y1)
	{
		double leng = 0;
		int w = x-x1;
		int h = y-y1;

		leng = w*w+h*h;

		return Math.sqrt(leng);
	}
}



class Student
{
	//3~5번문제
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public int getTotal()
	{

		return (kor+eng+math);
	}
	public float getAverage()
	{
		float avg = (float)(getTotal())/3;
		avg = (float)(Math.round(avg*10)/10.0);
		return avg;
	}


	public Student(String name, int ban , int no, int kor, int eng,int math)
	{

		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public float info()
	{

		System.out.print(name+",");
		System.out.print(ban+",");
		System.out.print(no+",");
		System.out.print(kor+",");
		System.out.print(eng+",");
		System.out.print(math+",");
		System.out.print(getTotal()+",");
		return getAverage();
	}

}
*/
