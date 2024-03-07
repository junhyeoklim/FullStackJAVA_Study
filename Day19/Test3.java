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

	public void showPhoneInfo()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	private String major;
	private int year;


	public PhoneUnivInfo(String name,String phoneNumber,String major,int year)
	{
		super(name,phoneNumber);
		this.major = major;
		this.year = year;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+year);

	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	private String company;


	public PhoneCompanyInfo(String name,String phoneNumber,String company)
	{
		super(name,phoneNumber);
		this.company = company;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("회사 : "+company);
	}
}

class PhoneInfoHandler
{ 
	private Scanner sc = new Scanner(System.in,"EUC-KR");
	private PhoneInfo[] phi;
	private int cnt;
	private String name;
	private String phone;
	private String addres;
	private String company;
	private String major;
	private int year;

	public PhoneInfoHandler(int i)
	{
		phi = new PhoneInfo[i];
	}

	public void addPhoneIfo(PhoneInfo phon)
	{
		int i =0, j=0;

		if(cnt >= phi.length)
		{
			System.out.println("더 이상 저장할 수 없습니다.");
			return;
		}

		for(i=0; i<cnt;i++)
		{
			if(phi[i].getName().compareTo(phon.getName()) >0)
			{
				for(j=cnt-1;j>=i;j--)
				{
					phi[j+1] = phi[j];
				}
				break;
			}
		}
		phi[i] = phon;
		cnt++;
	}

	public void companyInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		System.out.print("회사 :");
		company = sc.nextLine();

		addPhoneIfo(new PhoneCompanyInfo(name,phone,company));
	}

	public void univInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		System.out.print("전공 :");
		major = sc.nextLine();

		System.out.print("학년 :");
		year = sc.nextInt();
		sc.nextLine();

		addPhoneIfo(new PhoneUnivInfo(name,phone,major,year));

	}
	public void basicInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		addPhoneIfo(new PhoneInfo(name,phone));
	}

	public void printPhoneInfo()
	{
		for(int i =0; i<cnt; i++)
		{
			phi[i].showPhoneInfo();
			System.out.println();
		}
	}

	public boolean searchPhoneInfo(String name)
	{
		boolean result = false;

		for(int i=0; i<cnt; i++)
		{
			if(name.compareTo(phi[i].getName())==0)	
			{
				phi[i].showPhoneInfo();
				result = true;
			}

		}
		return result;
	}

	public void deletePhoneInfo(String name)
	{
		for(int i =0; i< cnt-1; i++)
		{
			if(name.compareTo(phi[i].getName())==0)	
			{
				phi[i] = phi[i+1];
				break;
			}
		}
	}

	public void selectMenu(int num)
	{
		switch(num)
		{
			case 1:
			{
				basicInput();
				break;
			}
			case 2:
			{
				univInput();
				break;
			}
			case 3:
			{
				companyInput();
				break;
			}
			default:
			{
				System.out.println("번호를 선택 해주세요!");
				break;
			}
		}
	}
}

class PhoneInfoUI
{
	public static void phoneUI()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void inputUI()
	{
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("1. 일반, 2. 대학, 3. 회사\n");
		System.out.print("선택 >> ");
	}

	public static void searchUI()
	{
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
	}

	public static void deleteUI()
	{
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름 : ");
	}

	public static void endUI()
	{
		System.out.println("프로그램을 종료 합니다!");
	}

}




class Test3
{
	private static final int IUPUT = 1;
	private static final int SEARCH = 2;
	private static final int DELETE = 3;
	private static final int VIEW = 4;
	private static final int END = 5;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in,"EUC-KR");
		PhoneInfoHandler pih = new PhoneInfoHandler(2);

		while(true)
		{
			PhoneInfoUI.phoneUI();
			int input = sc.nextInt();
			sc.nextLine();

			switch(input)
			{
				case IUPUT:
				{
					PhoneInfoUI.inputUI();

					int select = sc.nextInt();
					sc.nextLine();

					pih.selectMenu(select);
					System.out.println("데이터 입력이 완료되었습니다.");
					System.out.println();
					break;
				}
				case SEARCH:
				{
					PhoneInfoUI.searchUI();
					String name = sc.nextLine();

					if(!pih.searchPhoneInfo(name))
						System.out.println("찾으시는 사용자를 찾을 수 없습니다.");
					else
						System.out.println("데이터 검색이 완료되었습니다.");

					System.out.println();
					break;
				}
				case DELETE:
				{
					PhoneInfoUI.deleteUI();
					String name = sc.nextLine();
					pih.deletePhoneInfo(name);
					if(!pih.searchPhoneInfo(name))
						System.out.println("찾으시는 사용자를 찾을 수 없습니다.");
					else
						System.out.println("데이터 삭제를 완료하였습니다.");
					System.out.println();
					break;
				}
				case VIEW:
				{
					pih.printPhoneInfo();
					break;
				}
				case END:
				{
					PhoneInfoUI.endUI();
					return;
				}
				default :
				{
					System.out.println("데이터를 입력 해주세요!");
					break;
				}
			}		
		}



	}
}