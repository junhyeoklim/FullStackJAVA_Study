import java.util.Scanner;

public class PhoneBookUI {
	private PhoneBook pb;
	public static Scanner sc = new Scanner(System.in);
	
	public PhoneBookUI()
	{
		this.pb = PhoneBook.getPhoneBook();
	}
	
	public void printMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ��� ������ ����");
		System.out.println("5. ���α׷� ����");
		System.out.println("���� : ");
	}
	
	public void inputMenu()
	{
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("���� >>");
	}
	
	public void inputPhoneInfo(int menu)
	{
		String name, phoneNumber, major, company;
		int year=0;
		boolean result;
		PhoneInfo phoneInfo = null;
		
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("�̸� : ");
		name = sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		phoneNumber = sc.nextLine();
		
		if(menu == 1)	// �߰�
			phoneInfo = new PhoneInfo(name, phoneNumber);
		else if(menu == 2)
		{
			System.out.println("���� : ");
			major = sc.nextLine();
			System.out.println("�г� : ");
			year = sc.nextInt();
			phoneInfo = new PhoneUnivInfo(name, phoneNumber, major, year);
		}
		else if(menu==3)
		{
			System.out.println("ȸ�� : ");
			company = sc.nextLine();
			phoneInfo = new PhoneCompanyInfo(name, phoneNumber, company);
		}
		result = pb.insertPhoneInfo(phoneInfo);
		if(result == false)
			System.out.println("�̹� ��ϵ� ������ �Դϴ�.");
		else System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	
	public void searchPhoneInfoByName()
	{
		String name;
		System.out.println("�˻��Ͻð��� �ϴ� �̸��� �Է��� �ּ���.");
		name = sc.nextLine();
		System.out.println("����� �˻��� �����մϴ�.");
		if( !pb.searchPhoneInfoByName(name)) System.out.println("ã���ô� ����ڰ� �����ϴ�.");
	}
	
	public void deletePhoneInfoByPhoneNumber()
	{
		String phoneNumber;
		System.out.println("�����Ͻð��� �ϴ� ��ȭ��ȣ�� �Է��� �ּ���.");
		phoneNumber = sc.nextLine();
		boolean result = pb.deletePhoneInfoByPhoneNumber(phoneNumber);
		if(result) System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		else System.out.println("�����Ͻð��� �ϴ� ��ȭ��ȣ ������ �����ϴ�.");
	}
	
	public void printAllPhoneInfo()
	{
		System.out.println("��� ����� ������ ����մϴ�.");
		pb.printAllPhoneInfo();
	}
	
	public void quitProgram()
	{
		System.out.println("���α׷��� �����մϴ�.");
		sc.close();
	}
}