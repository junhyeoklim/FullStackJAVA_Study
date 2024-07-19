import java.util.Scanner;

public class PhoneUI {
	private static final int MAX_CNT=100;
	public static Scanner sc = new Scanner(System.in);
	private static PhoneBook pb = PhoneBook.getPhoneBookInst(MAX_CNT);


	private PhoneUI(){}
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
