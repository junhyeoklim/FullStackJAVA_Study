import java.util.Scanner;

class PhoneInfo
{
	private String name;
	private String phone;

	PhoneInfo(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	public String getName()
	{
		return name;
	}
	public void showPhoneInfo()
	{
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	private String major;
	private int year;

	PhoneUnivInfo(String name ,String phone, String major, int year)
	{
		super(name, phone);
		this.major = major;
		this.year = year; 
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	private String company;

	PhoneCompanyInfo(String name ,String phone, String company)
	{
		super(name, phone);
		this.company = company;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("회사 : " + company);
	}
}

class PhoneBook
{
	private static PhoneBook pb;
	private PhoneInfo[] pInfoArr;
	private int cntOfPhone;
	private PhoneBook(int sizePhoneInfo)
	{
		pInfoArr = new PhoneInfo[sizePhoneInfo];
		cntOfPhone = 0;
	}
	public static PhoneBook getPhoneBookInst(int sizePhoneInfo)
	{
		if(pb == null)
			pb = new PhoneBook(sizePhoneInfo);
		return pb;
	}
	public void inputPhoneInfo(PhoneInfo pInfo)
	{
		int i = 0, j=0;
		if(cntOfPhone >= pInfoArr.length)
		{
			System.out.println("더 이상 저장할 수 없습니다.");
			return;
		}
		for(i=0;i<cntOfPhone;i++)
		{
			if(pInfoArr[i].getName().compareTo(pInfo.getName()) > 0)
			{
				for(j=cntOfPhone-1;j>=i;j--)
				{
					pInfoArr[j+1] = pInfoArr[j];
				}
				break;
			}
		}
		pInfoArr[i] = pInfo;
		cntOfPhone++;
	}
	public void searchPhoneInfo(String name)
	{
		int result = search(name);
		if(result != -1)
			pInfoArr[result].showPhoneInfo();
		else
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(int idx)
	{
		int i=0;
		for(i=idx;i<cntOfPhone-1;i++)
			pInfoArr[i] = pInfoArr[i+1];
		pInfoArr[i] = null;
		cntOfPhone--;
		System.out.println("삭제가 완료되었습니다.");
	}


	public int search(String name)
	{
		int first = 0;
		int last = pInfoArr.length-1;
		int mid = (first+last)/2;


		while(first<=last)
		{
			if(pInfoArr[mid].getName().compareTo(name) > 0)
				last = mid-1;

			else if(pInfoArr[mid].getName().compareTo(name) < 0)
				first = mid+1;

			else
				return mid;

			mid = (first+last)/2;
		}
		return -1;		
	}

	public void showAllPhoneInfo()
	{
		for(int i=0;i<cntOfPhone;i++)
			pInfoArr[i].showPhoneInfo();
	}
}

class PhoneUI
{
	private static final int MAX_CNT=5;
	public static Scanner sc = new Scanner(System.in,"EUC-KR");
	private static PhoneBook pb = PhoneBook.getPhoneBookInst(MAX_CNT);

	public static final int INPUT_PHONEINFO = 1;
	public static final int SEARCH_PHONEINFO = 2;
	public static final int DELETE_PHONEINFO = 3;
	public static final int SHOW_ALL_PHONEINFO = 4;
	public static final int PROGRAM_QUIT = 5;

	public static final int GENERAL 	= 1;
	public static final int UNIVERSITY 	= 2;
	public static final int COMPANY 	= 3;

	public static final int YES = 1;
	public static final int NO = 2;

	public static void mainMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void inputMenu()
	{
		System.out.println("1. 일반, 2. 대학, 3. 회사");
	}
	public static void inputMenuChoice()
	{
		int choice=0;
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
		case GENERAL:
			inputGeneralPhoneInfo();
			break;
		case UNIVERSITY:
			inputUniversityPhoneInfo();
			break;
		case COMPANY:
			inputCompanyPhoneInfo();
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
		}
	}

	public static void inputGeneralPhoneInfo()
	{
		String name, phone;

		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화번호 : ");
		phone = sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.");
		pb.inputPhoneInfo( new PhoneInfo(name, phone) );
	}

	public static void inputUniversityPhoneInfo()
	{
		String name, phone, major;
		int year;

		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화번호 : ");
		phone = sc.nextLine();
		System.out.print("전공 : ");
		major = sc.nextLine();
		System.out.print("학년 : ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.");
		pb.inputPhoneInfo( new PhoneUnivInfo(name, phone, major, year) );
	}

	public static void inputCompanyPhoneInfo()
	{
		String name, phone, company;

		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화번호 : ");
		phone = sc.nextLine();
		System.out.print("회사 : ");
		company = sc.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.");
		pb.inputPhoneInfo( new PhoneCompanyInfo(name, phone, company) );
	}

	public static void searchPhoneInfo()
	{
		String name;
		System.out.println("데이터 검색을 시작합니다.");
		System.out.println("검색하시고자 하는 이름을 입력하세요.");
		name = sc.nextLine();
		pb.searchPhoneInfo(name);			
	}
	public static void deletePhoneInfo()
	{
		String name;
		int result=0, answer=0;
		System.out.println("검색하시고자 하는 이름을 입력하세요.");		
		name = sc.nextLine();		
		result = pb.search(name);
		if(result != -1)
		{
			System.out.println("정말 삭제하시겠습니까? 1. Yes 2. No");
			answer = sc.nextInt();
			sc.nextLine();
			switch(answer)
			{
			case YES:
				pb.deletePhoneInfo(result);
				break;
			case NO:
				break;
			default:
				System.out.println("잘못 누르셨습니다.");
			}
		}
		else
			System.out.println("삭제하시려는 데이터가 없습니다.");
	}
	public static void showAllPhoneInfo()
	{
		pb.showAllPhoneInfo();
	}
}

class PhoneMain
{		
	public static void main(String[] args)
	{
		int choice=0;

		while(true)
		{
			PhoneUI.mainMenu();
			choice = PhoneUI.sc.nextInt();
			PhoneUI.sc.nextLine();
			switch(choice)
			{
				case PhoneUI.INPUT_PHONEINFO:
					PhoneUI.inputMenu();
					PhoneUI.inputMenuChoice();
					break;
				case PhoneUI.SEARCH_PHONEINFO:
					PhoneUI.searchPhoneInfo();
					break;
				case PhoneUI.DELETE_PHONEINFO:
					PhoneUI.deletePhoneInfo();
					break;
				case PhoneUI.SHOW_ALL_PHONEINFO:
					PhoneUI.showAllPhoneInfo();
					break;
				case PhoneUI.PROGRAM_QUIT:
					return;
				default:
					System.out.println("잘못 선택하셨습니다.");
			}		
		}
	}
}