package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {

	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		Vector list = new Vector(); // Vector 검색결과를 담을
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim(); // trim()으로 입력내용에서 공백을 제거
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			String pattern = ".*"+input+".*"; // input을 포함하는 모든 문자열
			Pattern p = Pattern.compile(pattern);
			for(int i=0; i< phoneNumArr.length;i++) {
				String phoneNum = phoneNumArr[i];
				String tmp = phoneNum.replace("-",""); // phoneNum '-' 에서 를 제거
				Matcher m = p.matcher(tmp);
				if(m.find()) { // , list phoneNum . 패턴과 일치하면 에 을 추가한다
					list.add(phoneNum);
				}
			}
			if(list.size()>0) { // 검색결과가 있으면
				System.out.println(list); // 검색결과를 출력하고
				list.clear();
			} 
		}
	}
}
