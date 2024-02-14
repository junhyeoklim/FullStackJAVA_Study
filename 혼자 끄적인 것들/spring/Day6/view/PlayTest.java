package view;

import peopleData.Child;
import java.util.Scanner;


public class PlayTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		String name1 = null,name2 = null;
		String flag = "y";
		int cnt1,cnt2;
		
		

		for(;;)
		{
			if(flag.equals("y"))
			{
				System.out.println("첫 번째 캐릭터의 이름을 입력 해주세요");
				name1 = sc.next();
				System.out.println("\n첫 번째 캐릭터의 구슬 갯수를 입력 해주세요");
				cnt1 = sc.nextInt();
			
				System.out.println("두 번째 캐릭터의 이름을 입력 해주세요");
				name2 = sc.next();
				System.out.println("\n두 번째 캐릭터의 구슬 갯수를 입력 해주세요");
				cnt2 = sc.nextInt();
			
				Child c1 = new Child(name1,cnt1);
				Child c2 = new Child(name2,cnt2);
		
				c1.win(c2, 8);		
				c2.childStatus();
				System.out.println();
		
				c2.win(c1, 7);
				c1.childStatus();		
				
			}
			else if(flag.equals("n"))
			{
				System.out.println("게임 종료!");
				break;
			}
			else
			{
				System.out.println("다시 입력 해주세요!");
				flag = sc.next();
			}
			System.out.println("다시 하겠습니까?");
			flag = sc.next();
		}
		
		
	}

}
