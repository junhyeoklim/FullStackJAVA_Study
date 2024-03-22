package test;

import java.util.Stack;

public class StackQuestion2 {

	public static void main(String[] args) {

		String num1 = String.valueOf(args[0]);
		int cnt = 0;
		System.out.println("expression: "+args[0]);
		Stack check = new Stack();
		
		 for(int i=0; i<num1.length();i++)
		 {
			 if(num1.charAt(i) == '(')
				 check.push(num1.charAt(i)+"");
			 else if(num1.charAt(i) == ')')
				 check.pop();
		 }

		 if(check.isEmpty())
			 System.out.println("괄호가 일치합니다.");
		 else
			 System.out.println("괄호가 일치하지 않습니다.");
//		 System.out.println(check);
		
		
		
		
		
	}

}
