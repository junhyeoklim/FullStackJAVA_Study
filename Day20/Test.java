interface TV
{
	public void onTV();
}

interface Computer
{
	public void dataReceive();
}

class ComputerImpl
{	
	public void dataReceive()
	{
		System.out.println("영상 데이터 수신 중");
	}
	public void onTV()
	{
		System.out.println("영상 출력 중");
	}
}

class IPTV implements TV,Computer
{
	ComputerImpl comp=new ComputerImpl();
	
	public void dataReceive()
	{
		comp.dataReceive();
	}
	public void onTV()
	{
		comp.onTV();
	}
	public void powerOn()
	{
		dataReceive();
		onTV();
	}
}

class Test
{	

	public static void main(String[] args)
	{
		IPTV iptv= new IPTV();
		iptv.powerOn();
		
		TV tv=iptv;
		Computer comp=iptv;
	}
}








/*interface UpperCasePrintable
{
	// 비어 있음
}

UpperCasePrintable 인터페이스가 갖는 의미는 무엇인가?
"다른 클래스와의 구별을 위한 특별한 표시의 목적으로 사용되었다."

이렇듯 인터페이스는 클래스의 정의에, 약속된 형태의 특별한 표시를 위한 용도로도 사용이 된다. 그리고
이러한 경우에는 위 예제에서 보이듯이 아무것도 채워지지 않은 형태로 인터페이스가 정의되기도 한다.

아무 메서드도 담고 있지 않고, 단지 자신을 구현하는 클래스가 특정 속성을 가짐을 표시해주는 인터페이스를 마커 인터페이스(marker interface)라 한다.

class ClassPrinter 
{
	public static void print(Object obj)
	{
		String org=obj.toString();
		if(obj instanceof UpperCasePrintable)
		{
			org=org.toUpperCase();
		}
		
		System.out.println(org);
	}
}

class PointOne implements UpperCasePrintable
{
	private int xPos, yPos;
	
	PointOne(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	
	public String toString()
	{
		String posInfo="[x pos:"+xPos + ", y pos:"+yPos+"]";
		return posInfo;
	}
}

class PointTwo
{
	private int xPos, yPos;
	
	PointTwo(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	
	public String toString()
	{
		String posInfo="[x pos:"+xPos + ", y pos:"+yPos+"]";
		return posInfo;
	}
}

class Test
{
	public static void main(String[] args)
	{
		PointOne pos1=new PointOne(1, 1);
		PointTwo pos2=new PointTwo(2, 2);
		PointOne pos3=new PointOne(3, 3);
		PointTwo pos4=new PointTwo(4, 4);
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
		ClassPrinter.print(pos3);
		ClassPrinter.print(pos4);
	}
}
*/

/*interface PersonalNumberStorage
{
	 void addPersonalInfo(String perNum, String name);
	 String searchName(String perNum);
}

class PersonalNumInfo
{
	String name;
	String number;
	
	PersonalNumInfo(String name, String number)
	{
		this.name=name;
		this.number=number;
	}
	
	String getName(){return name;}
	String getNumber(){return number;}
}

class PersonalNumberStorageImpl implements PersonalNumberStorage
{
	PersonalNumInfo[] perArr;
	int numOfPerInfo;
	
	public PersonalNumberStorageImpl(int sz)
	{
		perArr=new PersonalNumInfo[sz];
		numOfPerInfo=0;
	}
	
	public void addPersonalInfo(String name, String perNum)
	{
		perArr[numOfPerInfo]=new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}
	
	public String searchName(String perNum)
	{
		for(int i=0; i<numOfPerInfo; i++)
		{
			if(perNum.compareTo(perArr[i].getNumber())==0)
				return perArr[i].getName();
		}		
		return null;
	}
}


class Test
{
	public static void main(String[] args)
	{
		PersonalNumberStorage storage=new PersonalNumberStorageImpl(100);
		storage.addPersonalInfo("김기동", "950000-1122333");
		storage.addPersonalInfo("장산길", "970000-1122334");	
		
		System.out.println(storage.searchName("950000-1122333"));
		System.out.println(storage.searchName("970000-1122334"));
	}
}
*/
/*class Test
{
	public static void main(String[] args)
	{
		System.out.println(add(5));	//5
		System.out.println(add(5,10));	//15
		System.out.println(add(5,10,15));	//30
	}

	//메서드 오버라이딩 방법
	/*public static int add(int num)
	{
		return num;	
	}
	public static int add(int num1,int num2)
	{
		return num1+num2;
	}
	public static int add(int num1,int num2,int num3)
	{
		return num1+num2+num3;
	}

	//가변인자 방법
	public static int add(int... num)
	{
		int result = 0;
		for(int sum : num)
			result += sum;
		return result;			
	}
}*/