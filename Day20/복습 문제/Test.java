import java.util.Scanner;
import java.util.Arrays;

class Friend
{
	private String name;
	private String phone;
	private String addres;

	public Friend(String name,String phone,String addres)
	{
		this.name = name;
		this.phone = phone;
		this.addres = addres;
	}

	public void showData()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
		System.out.println("주소 : "+addres);
	}

	public void showBasicInfo()
	{}

	public String getName()
	{
		return name;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getAddres()
	{
		return addres;
	}

}

class HighFriend extends Friend
{
	private String work;
	private Friend frien;


	public HighFriend(String name,String phone,String addres,String work)
	{
		super(name,phone,addres);
		this.work = work;
	}

	public void showData()
	{
		super.showData();
		System.out.println("직장 : "+work);
	}

	public void showBasicInfo()
	{
		System.out.println("이름 : "+super.getName());
		System.out.println("전화번호 : "+super.getPhone());
		System.out.println("직장 : "+work);
	}
}

class UnivFriend extends Friend
{
	private String major;



	public UnivFriend(String name,String phone,String addres,String major)
	{
		super(name,phone,addres);
		this.major = major;
	}

	public void showData()
	{
		super.showData();
		System.out.println("전공 : "+major);
	}

	public void showBasicInfo()
	{
		System.out.println("이름 : "+super.getName());
		System.out.println("전화번호 : "+super.getPhone());
		System.out.println("전공 : "+major);
	}

}

class FriendHandler
{
	private Friend[] frien;
	private int cnt;
	private String name;
	private String phone;
	private String addres;
	private String work;
	private String major;
	private Scanner sc = new Scanner(System.in,"EUC-KR");

	public FriendHandler(int i)
	{
		frien = new Friend[i];
	}

	public void addFriend(Friend fren)
	{
		frien[cnt++] = fren;
	}

	public void friendUI()
	{
		System.out.println("*** 메뉴 선택 ***");
		System.out.println("1. 고교 정보 저장");
		System.out.println("2. 대학 친구 저장");
		System.out.println("3. 전체 정보 출력");
		System.out.println("4. 전체 기본 정보 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택>>");
	}

	public void highInput()
	{
		boolean result = checkSize();
		if(result == false)
		{
			System.out.println("더이상 데이터를 저장할 수 없습니다.");
			System.out.println();
			return;
		}

		System.out.print("이름 : ");
		name = sc.nextLine();

		System.out.print("전화번호 : ");
		phone = sc.nextLine();

		System.out.print("주소 : ");
		addres = sc.nextLine();

		System.out.print("직장 : ");
		work = sc.nextLine();

		addFriend(new HighFriend(name,phone,addres,work));

	}

	public void univInput()
	{
		boolean result = checkSize();
		if(result == false)
		{
			System.out.println("더이상 데이터를 저장할 수 없습니다.");
			System.out.println();
			return;
		}

		System.out.print("이름 : ");
		name = sc.nextLine();

		System.out.print("전화번호 : ");
		phone = sc.nextLine();

		System.out.print("주소 : ");
		addres = sc.nextLine();

		System.out.print("전공 : ");
		major = sc.nextLine();

		addFriend(new UnivFriend(name,phone,addres,major));

	}

	public void printAllInfo()
	{
		for(int i=0; i<cnt;i++)
		{
			frien[i].showData();
			System.out.println();
		}
	}


	public void printBasicInfo()
	{
		for(int i=0; i<cnt;i++)
		{
			frien[i].showBasicInfo();
			System.out.println();
		}
	}

	public boolean checkSize()
	{
		if(cnt >= frien.length)
			return false;
		return true;
	}
}




class Test
{
	private static final int HIGH_INPUT = 1;
	private static final int UNIV_INPUT = 2;
	private static final int ALL_PRINT = 3;
	private static final int BASIC_PRINT = 4;
	private static final int END = 5;

	public static void main(String[] args)
	{

		//0번 문제

		Scanner sc = new Scanner(System.in);
		FriendHandler fhd = new FriendHandler(1);

		while(true)
		{
			fhd.friendUI();
			int input = sc.nextInt();
			sc.nextLine();

			switch(input)
			{
				case HIGH_INPUT:
				{
					fhd.highInput();
					break;
				}
				case UNIV_INPUT:
				{
					fhd.univInput();
					break;
				}
				case ALL_PRINT:
				{
					fhd.printAllInfo();
					break;
				}
				case BASIC_PRINT:
				{
					fhd.printBasicInfo();
					break;
				}
				case END:
				{
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				default :
				{
					System.out.println("값을 입력 해주세요!");
					break;
				}
			}

		}


		/*//1번 문제
		답 : abstract

		//2번 문제
		답 : abstract public void eat();
		     *상속 받을려면 자식도 추상 클래스를 상속받는다는 의미로 abstract을 붙여준다

		//3번 문제
		답 : Object

		//4번 문제
		답 : 

		//5번 문제
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력 해주세요");
		int user = sc.nextInt();
		sc.nextLine();

		System.out.println(user+"는/은 " + String.valueOf(user).length()+"자리 숫자 입니다.");



		//6번 문제
		Scanner sc = new Scanner(System.in);
		int[] num = {1,3,4,5,7,10,27,39,50,92};
		int cnt = 0;
		Arrays.sort(num);

		int first = 0;
		int last = num.length-1;
		int mid = (first+last)/2;

		System.out.println("숫자를 입력 해주세요");
		int user = sc.nextInt();
		sc.nextLine();


		while(first<=last)
		{
			cnt++;



			if(num[mid] > user)
			{
				last = mid-1;
			}
			else if(num[mid] < user)
			{
				first = mid+1;
			}
			else if(num[mid] == user)
			{
				System.out.println("mid: "+mid+" "+cnt+"회");
				return;
			}
			else
			{
				System.out.println("숫자를 찾을 수 없습니다.");
				return;
			}

			mid = (first+last)/2;
		}



		//7번 문제
		답: 메서드 위에 @Override를 써준다
			ex) @Override
			    public void test(){}


		//8번 문제
		답: @Deprecated를 sayHello 위에 적어준다


		//9번 문제
		답 : @SuppressWarnings("deprecation")을 사용 해준다.
		class AAA
		{
			@Deprecated
			public void sayHello()
			{
				System.out.println("Hello");
			}
		}

		class MainClass
		{
			@SuppressWarnings("deprecation")
			public static void main(String[] args)
			{
				AAA aaa = new AAA();
				aaa.sayHello();
			}
		}



		//10번 문제
		답 : 다중 상속을 지원 하기 위해 사용 되는 방법이다. 추상 클래스 처럼 쓰이지만 오로지 추상 메소드와
			상수만을 포함한다.

		//11번 문제
		답 : 인터페이스 구현은 우선 상속을 받을 때 처럼 부모클래스에서 여러 메소드를 선언만 하고 
		     자식 클래스에서 implements로 상속 받은 후 오버라이딩 한다.
		*/
	}
}
