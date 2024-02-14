package view;

import peopleData.Child;

public class PlayTest {

	public static void main(String[] args) {
		
		
		Child c1 = new Child("어린이1",15);
		Child c2 = new Child("어린이2",7);
		
		c1.win(c2, 2);
		c1.childStatus();
		
		c2.win(c1, 7);
		c2.childStatus();
		
		
	}

}
