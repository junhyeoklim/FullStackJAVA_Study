public class MenuChoiceException extends Exception {
	
	public MenuChoiceException(int menu)
	{		
		super(menu + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.\n" + 
				"�޴� ������ ó������ �ٽ� �����մϴ�.");
	}
}