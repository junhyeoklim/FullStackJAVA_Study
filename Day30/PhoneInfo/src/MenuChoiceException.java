public class MenuChoiceException extends Exception {
	
	public MenuChoiceException(int menu)
	{		
		super(menu + "에 해당하는 선택은 존재하지 않습니다.\n" + 
				"메뉴 선택을 처음부터 다시 진행합니다.");
	}
}