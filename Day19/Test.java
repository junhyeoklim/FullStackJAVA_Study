import java.util.Scanner;

class Friend
{
	private static String name;
	private static String phone;
	private static String addres;

	public static void test(String name,String phone,String addres)
	{
		name = name;
		phone = phone;
		addres = addres;	
	}

	public void showData()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
		System.out.println("주소 : "+addres);
	}

	public void showBasicInfo(){}

}

class HighFriend extends Friend
{
	private String job;

	public HighFriend(String name,String phone,String addres,String job)
	{
		Friend.test(name,phone,addres);
		this.job = job;
	}

	public void showData()
	{
		super.showData();
		System.out.println("직장 : "+job);	
	}

	public void showBasicInfo()
	{
		System.out.println("이름 : "+super.name);
		System.out.println("직장 : "+job);
	}

}

class UnivFriend extends Friend
{
	private String major;

	public UnivFriend(String name,String phone,String addres,String major)
	{
		Friend.test(name,phone,addres);
		this.major = major;
	}

	public void showData()
	{
		super.showData();
		System.out.println("전공 : "+major);
	}

	public void showBasicInfo()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
		System.out.println("전공 : "+major);
	}

}
class FriendUi
{

	private Friend[] friend;
	private Scanner sc = new Scanner(System.in,"EUC-KR");	
	private String name = "";
	private String phone = "";
	private String addres = "";
	private String job = "";
	private String major = "";
	private int cnt;

	public FriendUi(int i) 
	{
		friend =  new Friend[i];
	}
	

	public void friendUi()
	{

		System.out.println("*** 메뉴 선택 ***");
		System.out.println("1. 고교 정보 저장");
		System.out.println("2. 대학 친구 저장");
		System.out.println("3. 전체 정보 출력");
		System.out.println("4. 전체 기본 정보 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택>>");
	}

	public void friendHInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		System.out.print("주소 :");
		addres = sc.nextLine();

		System.out.print("직장 :");
		job = sc.nextLine();
		System.out.println();

		addFriendInfo(new HighFriend(name,phone,addres,job));

	}

	private void addFriendInfo(Friend fren)
	{
		friend[cnt++] = fren;
	}

	public void friendUInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		System.out.print("주소 :");
		addres = sc.nextLine();

		System.out.print("전공 :");
		major = sc.nextLine();

		addFriendInfo(new UnivFriend(name,phone,addres,major));
	}

	public void printBasicInfo()
	{
		for(int i=0; i<cnt;i++)
		{
			friend[i].showBasicInfo();
			System.out.println("");
		}
	}

	public void printAllInfo()
	{
		for(int i=0; i<cnt;i++)
		{
			friend[i].showData();
			System.out.println("");
		}
	}
}



class Test
{
	private static final int HIGH = 1;
	private static final int UNIV = 2;
	private static final int ALL_INFO = 3;
	private static final int ALL_BSIC_INFO = 4;
	private static final int END = 5;



	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in,"EUC-KR");
		int input = 0;
		FriendUi frendhandle = new FriendUi(10);


		while(true)
		{

			frendhandle.friendUi();

			input = sc.nextInt();
			sc.nextLine();

			switch(input)
			{
				case HIGH :
				{
					frendhandle.friendHInput();
					System.out.println();
					break;
				}
				case UNIV :
				{
					frendhandle.friendUInput();
					System.out.println();
					break;
				}
				case ALL_INFO :
				{
					frendhandle.printAllInfo();
					System.out.println();
					break;
				}
				case ALL_BSIC_INFO :
				{
					frendhandle.printBasicInfo();
					System.out.println();
					break;
				}
				case END :
				{
					return;
				}
				default :
				{
					System.out.println("다시 입력 해주세요");
					break;
				}
			}
		}

	}
}