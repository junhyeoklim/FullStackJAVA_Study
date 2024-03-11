package salaryUI;


import java.util.Scanner;

import SalaryDATA.SalaryManCreate;
import SalaryDATA.SalaryManHandler;
import SalaryDATA.SalaryManInfo;

public class SalaryManMain {

	private static final int SALARYMAN_CREATE = 1;
	private static final int SALARYMAN_SEARCH = 2;
	private static final int SALARYMAN_LIST = 3;
	private static final int END = 4;

	public static void main(String[] args) {

		int choice = 0;

		Scanner sc = new Scanner(System.in);
		
		

		while(true)
		{	
			SalaryUI.printMenu();

			//숫자 이외에 다른 데이터 타입이 들어 올 경우를 대비한 예외 처리
			while(true)
			{
				Scanner sc1 = new Scanner(System.in);

				try {							
					choice = sc1.nextInt();
					sc1.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("숫자를 입력 해주세요!\n");
					SalaryUI.printMenu();
				}
			}


			switch (choice) {
			case SALARYMAN_CREATE:{
				SalaryManCreate.createSalaryMan();
				break;
			}
			case SALARYMAN_SEARCH:{
				SalaryManCreate.searchSalaryMan();
				break;
			}

			case SALARYMAN_LIST: 
			{			
				SalaryManCreate.salaryList();
				break;
			}
			case END:
			{
				System.out.println("프로그램을 종료합니다!");

				return;
			}
			default:
			{
				System.out.println("잘못 입력 하셨습니다.");
				break;
			}

			}
		}	
	}
}

