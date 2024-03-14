package test1;

import java.util.Scanner;
import java.util.Vector;

class MenuChoiceException extends Exception
{
	private int choice;
	MenuChoiceException(int choice)
	{
		super("유효하지 않은 메뉴 값입니다.");
		this.choice = choice;
	}
	public void showWrongMenu()
	{
		System.out.println( choice + "에 해당하는 선택은 존재하지 않습니다.");
		System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
	}
}

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
	private Vector<PhoneInfo> pInfoArr;	
	
	private PhoneBook(int sizePhoneInfo)
	{
		pInfoArr = new Vector<PhoneInfo>(sizePhoneInfo);
		
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

		for(i=0;i<pInfoArr.size();i++)
		{
			if(pInfoArr.get(i).getName().compareTo(pInfo.getName()) > 0)
			{
				break;
			}
		}
		pInfoArr.add(pInfo);		
	}
	public void searchPhoneInfo(String name)
	{
		int result = search(name);
		if(result != -1)
			pInfoArr.get(result).showPhoneInfo();
		else
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(int idx)
	{
		
		pInfoArr.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}


	public int search(String name)
	{
		for(int i=0;i<pInfoArr.size();i++)
		{
			if(pInfoArr.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;		
	}

	public void showAllPhoneInfo()
	{
		for(int i=0;i<pInfoArr.size();i++)
			pInfoArr.get(i).showPhoneInfo();
	}
}

interface PhoneMenuString
{
	int INPUT_PHONEINFO = 1;
	int SEARCH_PHONEINFO = 2;
	int DELETE_PHONEINFO = 3;
	int SHOW_ALL_PHONEINFO = 4;
	int PROGRAM_QUIT = 5;

	int GENERAL 	= 1;
	int UNIVERCITY 	= 2;
	int COMPANY 	= 3;

	int YES = 1;
	int NO = 2;
}

class PhoneUI
{
	private static final int MAX_CNT=100;
	public static Scanner sc = new Scanner(System.in);
	private static PhoneBook pb = PhoneBook.getPhoneBookInst(MAX_CNT);



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
	public static void inputMenuChoice() throws MenuChoiceException
	{
		int choice=0;
		choice = sc.nextInt();
		sc.nextLine();
		if(choice < PhoneMenuString.GENERAL || choice > PhoneMenuString.COMPANY)
			throw new MenuChoiceException(choice);
		switch(choice)
		{
		case PhoneMenuString.GENERAL:
			inputGeneralPhoneInfo();
			break;
		case PhoneMenuString.UNIVERCITY:
			inputUniversityPhoneInfo();
			break;
		case PhoneMenuString.COMPANY:
			inputCompanyPhoneInfo();
			break;
		}
	}

	public static void inputGeneralPhoneInfo()
	{
		String name;
		String phone;

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
		String name;
		String phone;
		String major;
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
		String name;
		String phone;
		String company;

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
		int result=0;
		int answer=0;
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
			case PhoneMenuString.YES:
				pb.deletePhoneInfo(result);
				break;
			case PhoneMenuString.NO:
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
			try
			{
				PhoneUI.mainMenu();
				choice = PhoneUI.sc.nextInt();
				PhoneUI.sc.nextLine();
				if(choice < PhoneMenuString.INPUT_PHONEINFO || choice > PhoneMenuString.PROGRAM_QUIT)
					throw new MenuChoiceException(choice);

				switch(choice)
				{
				case PhoneMenuString.INPUT_PHONEINFO:
					PhoneUI.inputMenu();
					PhoneUI.inputMenuChoice();
					break;
				case PhoneMenuString.SEARCH_PHONEINFO:
					PhoneUI.searchPhoneInfo();
					break;
				case PhoneMenuString.DELETE_PHONEINFO:
					PhoneUI.deletePhoneInfo();
					break;
				case PhoneMenuString.SHOW_ALL_PHONEINFO:
					PhoneUI.showAllPhoneInfo();
					break;
				case PhoneMenuString.PROGRAM_QUIT:
					return;

				}
			}
			catch(MenuChoiceException e)
			{
				System.out.println(e.getMessage());
				e.showWrongMenu();
			}					
		}
	}
}