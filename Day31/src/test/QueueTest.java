package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;


public class QueueTest {
	static Queue<String> q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println(q.size());
		System.out.println("=============================================");
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		while(true)
		{
			int cnt = 0;
			System.out.print(">>");
			String menu = sc.nextLine();
			System.out.println(menu);
			q.add(menu);
			
			if(menu.equals("help"))
			{
				System.out.println("help - 도움말을 보여줍니다.");
				System.out.println("q 또는 Q - 프로그램을 종료합니다.");
				System.out.println("history - 최근에 입력한 명령어를 5개 보여줍니다.");
			}
			else if(menu.equals("q") || menu.equals("Q"))
				break;
			else if(q.size() !=0 &&menu.equals("history"))
			{
//				LinkedList<String> tmp = (LinkedList<String>) q;
//				ListIterator<String> iter = tmp.listIterator();
				for(Iterator<String> itera = q.iterator(); itera.hasNext();)
					System.out.println(++cnt+". "+itera.next());
			}
			
			if(q.size() == MAX_SIZE)
				q.remove();
		}

		System.out.println("=============================================");
//		12번 문제
//		답 : 12345 
//			 54321
	}

}
