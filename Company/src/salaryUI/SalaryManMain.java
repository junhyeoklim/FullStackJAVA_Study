package salaryUI;


import java.util.Scanner;

import salaryVO.SalaryConstatnt;

public class SalaryManMain {

	
	
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
			case SalaryConstatnt.SALARYMAN_CREATE:{
				SalaryUI.salraryCreate();
				break;
			}
			case SalaryConstatnt.SALARYMAN_SEARCH:{
				SalaryUI.salrarySearch();
				break;
			}
			case SalaryConstatnt.SALARYMAN_UPDATE:{
				SalaryUI.salaryUpdateUI();				
				break;
			}
			case SalaryConstatnt.SALARYMAN_DELETE:{
				SalaryUI.salaryDeleteUI();				
				break;
			}
			case SalaryConstatnt.SALARYMAN_LIST: 
			{			
				SalaryUI.salaryList();
				break;
			}
			case SalaryConstatnt.SALARYMAN_SAVE: 
			{		
				SalaryUI.Save();
				break;
			}			
			case SalaryConstatnt.END:
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

