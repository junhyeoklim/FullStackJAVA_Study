package test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMissMatchTest {

	public static void main(String[] args) {


		System.out.println("숫자 맞추기 게임!");
		int cpu = (int) (Math.random()*100+1);
		Scanner sc = new Scanner(System.in);
		int user = 0;
		int cnt = 0;
		while(true)
		{
			
			
			try {
				System.out.println("숫자를 입력 해주세요!");
				user = sc.nextInt();
				sc.nextLine();
				cnt++;
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력 하셨습니다!");
				sc.nextLine();
			}
			if(user > cpu)
			{
				System.out.println("입력한 숫자보다 더 작습니다!");
			}
			else if(user < cpu)
			{
				System.out.println("입력한 숫자보다 더 큽니다!");
			}
			else
			{
				System.out.println("정답입니다!");
				System.out.print("입력한 횟수 : "+cnt);
				break;
			}
		}	
		
	}

}
