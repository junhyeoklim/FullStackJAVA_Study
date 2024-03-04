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


		//21번 문제
		MyTv t = new MyTv();
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:"+t.channel+", VOL:"+ t.volume);



		//22번 문제
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));

		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));




	}
	public static boolean isNumber(String str)
	{

		for(int i =0;i<str.length();i++)
		{
			char ch = str.charAt(i);

			if(!(ch >= '0' && ch <= '9'))
				return false;
			else if(ch == 0)
				return false;
		}
		return true;

	}
	
		//23번 문제
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:"+max(data));
		System.out.println("최대값:"+max(null));
		System.out.println("최대값:"+max(new int[]{}));



	public static int max(int[] arr)
	{
		try{
		int maxNum = arr[0];

		if(!(arr.length == 0 || arr.equals(null)))
		{		
			for(int i=0; i<arr.length;i++)
			{
				if(maxNum < arr[i])
					maxNum = arr[i];
			}
		}
			return maxNum;
		}
		catch (Exception e) {
			return -999999;
		}

	}
	*/

		//24번 문제
		int value = 5;
		System.out.println(value+"의 절대값:"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값:"+abs(value));
	}


	public static int abs(int value)
	{

		if(value < 0)
			return value*(-1);
		else 
			return value;
	}
}


/*
class MyTv
{
	boolean isPowerOn;
	int	channel;
	int	volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff()
	{
		if(isPowerOn)
			isPowerOn = false;
		else
			isPowerOn = true;
	}
	void volumeUp()
	{
		if(volume < MAX_VOLUME)
			volume ++;
	}
	void volumeDown()
	{
		if(volume > MIN_VOLUME)
			volume --;
	}
	void channelUp()
	{
		channel ++;
		if(channel > MAX_CHANNEL)
			channel = MIN_CHANNEL;
	}
	void channelDown()
	{
		channel --;
		if(channel < MIN_CHANNEL)
			channel = MAX_CHANNEL;
	}

}


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
