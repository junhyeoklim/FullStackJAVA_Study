package project7;

import java.util.Scanner;

public class PhoneUI {

	private static String name;
	private static String phoneNumber;
	private static String major;
	private static String company;
	private static PhoneInfoHandler phif = PhoneInfoHandler.getPhoneInfo();
	private static Scanner sc = new Scanner(System.in);
	private static int year;	
	
	
	public static void phoneMenuUI()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 전체보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}	
	
	public static void phoneInputUI()
	{
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1. 일반 2. 대학 3. 회사");
		System.out.print("선택>> ");	
		int check = sc.nextInt();
		sc.nextLine();
		
		switch (check) {
		case PhoneInfoConstatnt.GENERAL: {
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = sc.nextLine();
			phif.phoneInput(new PhoneDTO(name, phoneNumber));
			break;
		}
		case PhoneInfoConstatnt.UNIVERCITY: {
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = sc.nextLine();
			System.out.print("전공 : ");
			major = sc.nextLine();
			System.out.print("학년 : ");
			year = sc.nextInt();
			sc.nextLine();
			phif.phoneInput(new PhoneUnivDTO(name, phoneNumber,major,year));
			break;
		}
		case PhoneInfoConstatnt.COMPANY: {
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = sc.nextLine();
			System.out.print("회사 : ");
			company = sc.nextLine();
			phif.phoneInput(new PhoneCompanyDTO(name, phoneNumber,company));
			break;
		}
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}		
	}
	
	public static void phoneSearchUI()
	{
			
			System.out.println("데이터 검색을 시작합니다.");
			System.out.println("검색하시고자 하는 이름을 입력하세요.");
			name = sc.nextLine();
			phif.searchPhoneInfo(name);			
	}
	
	public static void phoneDeleteUI()
	{
		
		
		int answer=0;
		System.out.println("검색하시고자 하는 이름을 입력하세요.");		
		name = sc.nextLine();		
		boolean result = phif.search(name);
		if(result)
		{
			System.out.println("정말 삭제하시겠습니까? 1. Yes 2. No");
			answer = sc.nextInt();
			sc.nextLine();
			switch(answer)
			{
			case PhoneInfoConstatnt.YES:
				phif.deletePhoneInfo(name);
				break;
			case PhoneInfoConstatnt.NO:
				break;
			default:
				System.out.println("잘못 누르셨습니다.");
			}
		}
		else
			System.out.println("삭제하시려는 데이터가 없습니다.");
	}
	
	public static void phoneAllInfoUI()
	{
		phif.deletePhoneInfo(name);
	}
}
