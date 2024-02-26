	package SalaryMain;
	
	import java.util.Scanner;

import salaryDATA.SalaryManCreate;
import salaryDATA.SalaryManModule;
import salaryUI.SalaryUserInterface;
	
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
				SalaryUserInterface.printMenu();
				choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case SALARYMAN_CREATE: {
					SalaryManCreate.createSalaryMan();
					break;
				}
				case SALARYMAN_SEARCH:
				{
					SalaryManModule.searchSalaryMan();
					break;
				}
				
				 case SALARYMAN_LIST: 
				 {			
					SalaryManModule.searchSalaryMan();
					  break;
				  }
				case END:
				{
					System.out.println("프로그램을 종료합니다!");
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}	
		}
	}
	
