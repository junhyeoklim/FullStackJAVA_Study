/*1.저장 -> 일반 배열 선언
2.검색 -> 배열 인덱스와 입력된 데이터 값을 비교해서 동일하면 그 값을 변수에 저장해서 리턴 해주거나 
	 System으로 출력
3.삭제 -> 검색이랑 비슷하게 하나 데이터가 일치하면 해당 요소의 뒤에 저장된 요소들을 한 칸씩 앞으로 이동
*/

import java.util.Scanner;


class PhoneInfo
{	
	public PhoneInfo(String[][] user)
	{
		for(int i =0;i<user[0].length;i++)
		{			
			try {
				System.out.println("이름 : "+user[0][i]);
				System.out.println("휴대폰 번호 : "+user[1][i]);
				System.out.println("생년월일 : "+user[2][i]);
				System.out.println();
			} catch (NullPointerException e) {	
				
			}			
		}		
	}
}

class Manager
{
	private String[][] user = new String[3][100];
	private int cnt = 0;

	//user[0][] -> 이름, user[1][] ->휴대폰 번호, user[2][] -> 생년월일 저장, cnt -> 저장할 배열의 index 값을 증가
	public void phoneInfoSet(String name, String phoneNumber,String birthday)
	{
		user[0][cnt] = name;
		user[1][cnt] = phoneNumber;
		user[2][cnt] = birthday;		
		cnt++;

		System.out.println("데이터 입력이 완료되었습니다. ");
	}

	public void searchPhoneInfo(String name)
	{
		for(int i =0; i<user[0].length;i++)
		{
			if(name.equals(user[0][i]))
			{
				System.out.println("이름 : "+user[0][i]);
				System.out.println("전화번호 : "+user[1][i]);
				System.out.println("생년월일 : "+user[2][i]);				
				System.out.println("데이터 검색이 완료되었습니다.");
				System.out.println();
				break;
			}
			else
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다.");
				break;
			}
			
		}
	}
	public void deltePhoneInfo(String name)
	{
		for(int i =0; i<user[0].length;i++)
		{
			if(name.equals(user[0][i]))
			{
				for(;i<user[0].length-1;i++)
				{
					user[0][i] = user[0][i+1];
					user[1][i] = user[1][i+1];
					user[2][i] = user[2][i+1];
				}
				System.out.println("데이터 삭제가 완료되었습니다.");
				System.out.println();
				break;
			}
			else if((i+1) == user[0].length)
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다!");
				System.out.println();
				break;
			}
		}
	}

	public void print()
	{
		new PhoneInfo(user);
	}
}



class PhoneInfoMain
{
	public static void main(String[] args)
	{
		final int INPUT = 1;
		final int SEARCH = 2;
		final int DELETE = 3;
		final int ALLDATA = 4;
		final int END = 5;

		Scanner sc = new Scanner(System.in,"EUC-KR");	
		Manager manager = new Manager();

		String name = "",phone = "",birth = "";
		int check = 0;

		while(true)
		{
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 데이터 모든 데이터 보기");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");
			check = sc.nextInt();			
			sc.nextLine();

			switch(check)
			{
				case INPUT:
				{
					System.out.print("이름 : ");
					name = sc.nextLine();

					System.out.print("전화번호 : ");
					phone = sc.nextLine();

					System.out.print("생년월일 : ");
					birth = sc.nextLine();

					System.out.println("입력이 완료됐습니다.\n");

					manager.phoneInfoSet(name,phone,birth);
					break;
				}
				case SEARCH:
				{
					System.out.print("이름 : ");
					name = sc.nextLine();
					manager.searchPhoneInfo(name);
					break;
				}
				case DELETE:
				{
					System.out.println("데이터 삭제를 시작합니다.");
					System.out.print("이름 : ");
					name = sc.nextLine();
					manager.deltePhoneInfo(name);
					break;
				}
				case ALLDATA:
				{
					manager.print();
					break;
				}
				case END:
				{
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				default :
				{
					System.out.println("카테고리를 선택 해주세요!");
					break;
				}
			}
		}
	}
}