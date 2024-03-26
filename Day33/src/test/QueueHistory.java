package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueHistory {
	static Queue q = new LinkedList<>();
	static final int MAX_SIZE=5;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String user = "";
		
		
		System.out.println("//////////////////////////////////////////////////////////");
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(!(user.equals("q")||user.equals("Q")))
		{			
			System.out.print(">>");
			user = sc.nextLine();
			System.out.println(user);
			
			q.add(user);
			
			if(q.size() > MAX_SIZE)
			{
				q.remove();
			}
			
			if(user.equals("help"))
			{
				System.out.println("help - 도윰말을 보여줍니다.");
				System.out.println("q 또는 Q - 프로그램을 종료합니다.");
				System.out.println("history - 최근에 입력한 명령어를 5개 보여줍니다.");				
			}
			else if(user.equals("history"))
			{
				int i =0;
				for(Iterator<String> qqiter = q.iterator();qqiter.hasNext();)
				System.out.println((++i)+". "+qqiter.next());
			}
		}
		
		
		
		
		
		System.out.println("//////////////////////////////////////////////////////////");
		
		
		
	}

}
