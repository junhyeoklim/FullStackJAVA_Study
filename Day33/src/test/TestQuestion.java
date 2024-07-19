package test;

import java.util.Stack;

public class TestQuestion {

	public static void main(String[] args) {

		String str = String.valueOf(args[0]);
		char ch = ' ';
		Stack<String> stack = new Stack<>();
		System.out.println("expression: "+str);
		
		for(int i =0; i<str.length();i++)
		{
			ch = str.charAt(i);
			
			if(ch == '(')
			{
				stack.add(String.valueOf(ch));
			}
			else if(ch == ')')
			{
				stack.pop();
			}			
		}
		
		
		
		if(stack.empty())		
			System.out.println("괄호가 일치합니다.");
		else
			System.out.println("괄호가 일치하지 않습니다.");
	}

}
