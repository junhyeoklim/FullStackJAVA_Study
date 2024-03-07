import java.util.Scanner;


class PhoneInfo
{
	private String name;
	private String phoneNumber;

	public PhoneInfo(String name,String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showData()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
	}

	public String getName()
	{
		return name;
	}
	public String getphoneNumber()
	{
		return phoneNumber;
	}

}

class PhoneUnivInfo extends PhoneInfo
{
	private String major;
	private int year;

	public PhoneUnivInfo(String name,String phoneNumber, String major,int year)
	{
		super(name,phoneNumber);
		this.major = major;
		this.year = year;
	}

	public void showData()
	{
		super.showData();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	private String company;

	public PhoneCompanyInfo(String name,String phoneNumber, String company)
	{
		super(name,phoneNumber);
		this.company = company;

	}

	public void showData()
	{
		super.showData();
		System.out.println("회사 : "+company);
	}
}

class PhoneInfoUI
{
	public static void mainUI()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void phoneInputSelectUI()
	{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("1. 일반, 2. 대학, 3. 회사\n");
		System.out.print("선택 >> ");
	}
}

class PhoneHandler
{
	private static PhoneHandler ph;
	private PhoneInfo[] phoneArr;
	private int cnt;
	private static Scanner sc = new Scanner(System.in,"EUC-KR");
	private String name;
	private String phoneNumber;
	private String major;
	private int year;
	private String company;


	public static PhoneHandler(int size)
	{
		if(ph == null)
			ph = new PhoneHandler(size);
		return ph;
	}

	public void addPhoneInfo(PhoneInfo phi)
	{
		if(cnt >= phone.length)
		{
			System.out.println("데이터를 더이상 저장 할 수 없습니다.");
			return;
		}

		for(i=0;i<cnt;i++)
		{
			if(phoneArr[i].getName().compareTo(phi.getName()) > 0)
			{
				for(j=cnt-1;j>=i;j--)
				{
					phoneArr[j+1] = phoneArr[j];
				}
				break;
			}
		}
		phoneArr[i] = phi;
		cnt++;
	}

	public void inputBasicInfo()
	{
		System.out.print("이름 : ");
		name = sc.nextLine();

		System.out.print("전화번호 : ");
		phoneNumber = sc.nextLine();

		addPhoneInfo(new PhoneInfo(name,phoneNumber));
		System.out.println("데이터 입력이 완료되었습니다.\n");
	}

	public void inputUnivInfo()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phoneNumber = sc.nextLine();

		System.out.print("전공 : ");
		major = sc.nextLine();

		System.out.print("학년 : ");
		year = sc.nextInt();
		sc.nextLine();

		addPhoneInfo(new PhoneUnivInfo(name,phoneNumber,major,year));
		System.out.println("데이터 입력이 완료되었습니다.\n");
	}
	public void inputCompanyInfo()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phoneNumber = sc.nextLine();

		System.out.print("회사 : ");
		company = sc.nextLine();

		addPhoneInfo(new PhoneCompanyInfo(name,phoneNumber,company));
		System.out.println("데이터 입력이 완료되었습니다.\n");
	}

	public void searchPhoneInfo(String name)
	{
		int first = 0;
		int last = phoneArr.length-1;
		int mid = (first+last)/2

		while(first<=last)
		{
			if(phoneArr[mid].getName().compareTo(name) > 0)
				last = mid-1;
			else if(phoneArr[mid].getName().compareTo(name) < 0)
				first = mid+1;
			else
				break;
			mid = (first+last)/2;
		}

		pInfoArr[mid].showData();
	}
}



interface SELECT
{
	int INPUT = 1;
	int SEARCH = 2;
	int DELETE = 3;
	int VIEW = 4;
	int END = 5;
	int BASIC = 1;
	int UNIV = 2;
	int COMPANY = 3;
}


class PhoneMain2
{
	public static void main(String[] args)
	{
	}
}