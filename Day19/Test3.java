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
	{}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	private String major;
	private int year;
	private PhoneInfo phi = new PhoneInfo(major, major);


	public PhoneUnivInfo(String name,String phoneNumber,String major,int year)
	{
		super(name,phoneNumber);
		this.major = major;
		this.year = year;
	}
	public void showPhoneInfo()
	{
		System.out.println("이름 : "+super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+year);

	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	private String company;
	private PhoneInfo phi;

	public PhoneCompanyInfo(String name,String phoneNumber,String company)
	{
		super(name,phoneNumber);
		this.company = company;
	}
	public void showPhoneInfo()
	{
		System.out.println("이름 : "+super.getName());
		System.out.println("전화번호 : "+super.getPhoneNumber());
		System.out.println("회사 : "+company);
	}
}

class PhoneInfoHandler
{
	private Scanner sc = new Scanner(System.in,"EUC-KR");
	private PhoneInfo[] phi;
	private int cnt;
	private String name = "";
	private String phone = "";
	private String addres = "";
	private String company = "";
	private String major = "";
	private String year = "";

	public PhoneInfoHandler(int i)
	{
		phi = new PhoneIfo[i];
	}

	public void addPhoneIfo(PhoneInfo phon)
	{
		phi[cnt++] = phon;
	}

	public void companyInput()
	{
		System.out.print("이름 :");
		name = sc.nextLine();

		System.out.print("전화번호 :");
		phone = sc.nextLine();

		System.out.print("회사 :");
		company = sc.nextLine();

		addPhoneIfo(new PhoneCompanyInfo(name,phone,company))
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
		year = sc.nextLine();

		addPhoneIfo(new PhoneUnivInfo(name,phone,major,year))
	}

	public void printPhoneInfo()
	{
		for(int i =0; i<cnt; i++)
		{
			phi[i].showPhoneInfo();
		}
	}
}

class PhoneInfoUI
{
	public static void phoneUI()
	{
		
	}

}




class Test3
{
	public static void main(String[] args)
	{
	}
}