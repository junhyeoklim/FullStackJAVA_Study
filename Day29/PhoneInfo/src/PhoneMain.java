public class PhoneMain {
	public static void main(String[] args)
	{
		int choice=0;

		while(true)
		{			
			try
			{
				PhoneUI.mainMenu();
				choice = PhoneUI.sc.nextInt();
				PhoneUI.sc.nextLine();
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

				}
			}
			catch(MenuChoiceException e)
			{
				System.out.println(e.getMessage());
				e.showWrongMenu();
			}					
		}
	}
}