package project7;

import java.util.Scanner;

public class PhoneInfoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true)
		{
			try {
				PhoneUI.phoneMenuUI();
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case PhoneInfoConstatnt.INPUT_PHONEINFO: {
					PhoneUI.phoneInputUI();
					break;
				}
				case PhoneInfoConstatnt.SEARCH_PHONEINFO: {	
					PhoneUI.phoneSearchUI();
					break;
				}
				case PhoneInfoConstatnt.DELETE_PHONEINFO: {	
					PhoneUI.phoneDeleteUI();
					break;
				}
				case PhoneInfoConstatnt.SHOW_ALL_PHONEINFO: {				
					break;
				}
				case PhoneInfoConstatnt.END: {				
					return;
				}
				default:				
					break;
				}
			}
			catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.\n");
				e.printStackTrace();
				sc.nextLine();
			}
		}

	}

}
