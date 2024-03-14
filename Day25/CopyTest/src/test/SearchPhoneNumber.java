package test;

import java.util.Scanner;

public class SearchPhoneNumber {

	public static void main(String[] args) {

		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
				};
		String[] replace = new String[phoneNumArr.length];
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">>");
		String str = sc.nextLine();
		String strlist = "";
		int cnt = 0;
		
		for(int i =0; i<replace.length;i++)
		{
			replace[i] = phoneNumArr[i].replace("-", "");
		}		
		
		System.out.print("[");
		
		for(int i=0; i<phoneNumArr.length;i++)
		{			
			int idx = replace[i].indexOf(str);
			
			if(idx != -1)
				System.out.print(phoneNumArr[cnt]+",");
			cnt++;
		}
		System.out.println("]");
		System.out.println(">>");
//		System.out.println(strlist);
		
	}

}
