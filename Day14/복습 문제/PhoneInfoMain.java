import java.util.Scanner;


class PhoneInfoUI
{

	public PhoneInfoUI()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 모든 데이터 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}
}



class Manager
{

	private String[] user = new String[100]];
	private static Manager mag;
	private int cnt;
	private Manager(){};	

	public static Manager userInfoGet()
	{
		if(mag == null)
			mag = new Manager();
		return mag;
	}



	public void userInsert()
	{
		Scanner sc = new Scanner(System.in,"EUC-KR");
		String name = "";
		String phone = "";
		String birth = "";



		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화번호 : ");
		phone = sc.nextLine();
		System.out.print("생년월일 : ");
		birth = sc.nextLine();

		user[0][cnt] = name;
		user[1][cnt] = phone;
		user[2][cnt] = birth;

		cnt++;

		System.out.println("데이터 입력이 완료되었습니다.");
			
	}


	public void userSearch(String name)
	{
		try 
		{
			for(int i =0;i<user[0].length;i++)
			{		
				if(user[0][i].equals(null))
					break;

				else if(name.equals(user[0][i]))
				{
					System.out.println("이름 : "+user[0][i]);
					System.out.println("전화번호 : "+user[1][i]);
					System.out.println("생년월일 : "+user[2][i]);
					System.out.println("데이터 검색이 완료되었습니다.");
					System.out.println();
					break;
				}
			}

		}	
		catch (NullPointerException e) {
			
		}
	}




	public void userList()
	{
		try 
		{
			for(int i =0;i<user[0].length;i++)
			{		
				if(user[0][i].equals(null))
					break;
			
				System.out.println("이름 : "+user[0][i]);
				System.out.println("전화번호 : "+user[1][i]);
				System.out.println("생년월일 : "+user[2][i]);
				System.out.println();

			}
		}	
		catch (NullPointerException e) {
			
		}
	}


	public void userInfoDelete(String name)
	{
		try 
		{
			for(int i =0;i<user[0].length-1;i++)
			{		
				if(user[0][i].equals(null))
					break;
				else if(name.equals(user[0][i]))
				{
					user[0][i] = user[0][i+1];
					user[1][i] = user[1][i+1];
					user[2][i] = user[2][i+1];
					System.out.println("데이터 삭제가 완료되었습니다.");
				}
			}
		}	
		catch (NullPointerException e) {
			
		}
	}
}

class PhoneInfoMain
{
	private static final int DATA_INPUT = 1;
	private static final int DATA_SEARCH = 2;
	private static final int DATA_DELETE = 3;
	private static final int DATA_LIST = 4;
	private static final int END = 5;



	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in,"EUC-KR");
		int choice = 0;
		String name="",phone="",birth="";

		while(true)
		{
			new PhoneInfoUI();
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case DATA_INPUT:
				{
					Manager.userInfoGet().userInsert();
					break;
				}
				case  DATA_SEARCH:
				{
					System.out.println("데이터 검색을 시작합니다.");
					System.out.print("이름 : ");
					name = sc.nextLine();
					Manager.userInfoGet().userSearch(name);
					break;
				}
				case DATA_DELETE:
				{
					System.out.println("데이터 삭제를 시작합니다,");
					System.out.print("이름 : ");
					name = sc.nextLine();
					Manager.userInfoGet().userInfoDelete(name);
					break;
				}
				case DATA_LIST:
				{
					Manager.userInfoGet().userList();
					break;
				}
				case END:
				{
					System.out.println("프로그램을 종료합니다!");
					return;
				}
			}
		}
	}

}

/*

class Manager
{

	private String[][] user = new String[3][100];
	private static Manager mag;
	private int cnt;
	private Manager(){};	

	public static Manager userInfoGet()
	{
		if(mag == null)
			mag = new Manager();
		return mag;
	}



	public void userInsert()
	{
		Scanner sc = new Scanner(System.in,"EUC-KR");
		String name = "";
		String phone = "";
		String birth = "";



		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화번호 : ");
		phone = sc.nextLine();
		System.out.print("생년월일 : ");
		birth = sc.nextLine();

		user[0][cnt] = name;
		user[1][cnt] = phone;
		user[2][cnt] = birth;

		cnt++;

		System.out.println("데이터 입력이 완료되었습니다.");
			
	}


	public void userSearch(String name)
	{
		try 
		{
			for(int i =0;i<user[0].length;i++)
			{		
				if(user[0][i].equals(null))
					break;

				else if(name.equals(user[0][i]))
				{
					System.out.println("이름 : "+user[0][i]);
					System.out.println("전화번호 : "+user[1][i]);
					System.out.println("생년월일 : "+user[2][i]);
					System.out.println("데이터 검색이 완료되었습니다.");
					System.out.println();
					break;
				}
			}

		}	
		catch (NullPointerException e) {
			
		}
	}




	public void userList()
	{
		try 
		{
			for(int i =0;i<user[0].length;i++)
			{		
				if(user[0][i].equals(null))
					break;
			
				System.out.println("이름 : "+user[0][i]);
				System.out.println("전화번호 : "+user[1][i]);
				System.out.println("생년월일 : "+user[2][i]);
				System.out.println();

			}
		}	
		catch (NullPointerException e) {
			
		}
	}


	public void userInfoDelete(String name)
	{
		try 
		{
			for(int i =0;i<user[0].length-1;i++)
			{		
				if(user[0][i].equals(null))
					break;
				else if(name.equals(user[0][i]))
				{
					user[0][i] = user[0][i+1];
					user[1][i] = user[1][i+1];
					user[2][i] = user[2][i+1];
					System.out.println("데이터 삭제가 완료되었습니다.");
				}
			}
		}	
		catch (NullPointerException e) {
			
		}
	}
}

class PhoneInfoMain
{
	private static final int DATA_INPUT = 1;
	private static final int DATA_SEARCH = 2;
	private static final int DATA_DELETE = 3;
	private static final int DATA_LIST = 4;
	private static final int END = 5;



	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in,"EUC-KR");
		int choice = 0;
		String name="",phone="",birth="";

		while(true)
		{
			new PhoneInfoUI();
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case DATA_INPUT:
				{
					Manager.userInfoGet().userInsert();
					break;
				}
				case  DATA_SEARCH:
				{
					System.out.println("데이터 검색을 시작합니다.");
					System.out.print("이름 : ");
					name = sc.nextLine();
					Manager.userInfoGet().userSearch(name);
					break;
				}
				case DATA_DELETE:
				{
					System.out.println("데이터 삭제를 시작합니다,");
					System.out.print("이름 : ");
					name = sc.nextLine();
					Manager.userInfoGet().userInfoDelete(name);
					break;
				}
				case DATA_LIST:
				{
					Manager.userInfoGet().userList();
					break;
				}
				case END:
				{
					System.out.println("프로그램을 종료합니다!");
					return;
				}
			}
		}
	}

}*/