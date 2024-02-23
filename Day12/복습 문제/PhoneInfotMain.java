import java.util.Scanner;

class PhoneInfo
{
	private String name;
	private String phoneNumber;
	private String birthday;

	public PhoneInfo(String name,String phoneNumber,String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		printPhoneInfo();
	}
	public PhoneInfo(String name,String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	public void printPhoneInfo()
	{
		if(birthday != null)
		{
			System.out.println("입력된 정보 출력...");
			System.out.println("name : "+name);
			System.out.println("phone : " +phoneNumber);
			System.out.println("birth : "+ birthday);
			System.out.println();
		}
	}

}

class PhoneInfotMain
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in,"EUC-KR");
		int flag = 0;
		boolean check = true;
		String name = "", phone = "", birth ="";

		while(true)
		{
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력.");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택 : ");
			flag = sc.nextInt();
			sc.nextLine();

				
				switch(flag)
				{
					case 1 :
					{
						System.out.print("이름 : ");
						name = sc.nextLine();

						System.out.print("전화번호 : ");
						phone = sc.nextLine();
	
						System.out.print("생년월일 : ");
						birth = sc.nextLine();
						System.out.println("입력이 완료됐습니다.");
						System.out.println();

						new PhoneInfo(name,phone,birth);
						break;
					}
					case 2 :
					{
						check = false;
						break;	
					}
					default :
					{
						System.out.println("숫자를 입력 해주세요.");
						break;
					}
				}
				if(!check)
				{
					System.out.println("프로그램을 종료합니다.");
						break;
				}
		}
	}
}