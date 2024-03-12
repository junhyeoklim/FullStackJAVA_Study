package Test;

import java.awt.MenuComponent;

public class PhoneMain {
	public static void main(String[] args)
	{
		int choice=0;

		while(true)
		{
			PhoneUI.mainMenu();

			choice = PhoneUI.sc.nextInt();
			PhoneUI.sc.nextLine();
			try {
				if(choice < PhoneMenuString.INPUT_PHONEINFO || choice > PhoneMenuString.PROGRAM_QUIT)					
					throw new MenuChoiceException(choice);

				switch(choice)
				{
				case PhoneMenuString.INPUT_PHONEINFO:
					PhoneUI.inputMenu();
					PhoneUI.inputMenuChoice();
					break;
				case PhoneMenuString.SEARCH_PHONEINFO:
					PhoneUI.searchPhoneInfo();
					break;
				case PhoneMenuString.DELETE_PHONEINFO:
					PhoneUI.deletePhoneInfo();
					break;
				case PhoneMenuString.SHOW_ALL_PHONEINFO:
					PhoneUI.showAllPhoneInfo();
					break;
				case PhoneMenuString.PROGRAM_QUIT:
					return;
				default:
					System.out.println("잘못 선택하셨습니다.");
				}
			}
			catch (MenuChoiceException e) {
				System.out.println(e.getMessage());
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
		}
	}
}
