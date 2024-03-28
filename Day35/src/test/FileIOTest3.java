package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

class MyInfo
{
	String info;
	public MyInfo(String info) { this.info = info; }
	public String toString() { return info; }
}

public class FileIOTest3 {

	public static void main(String[] args) {
//		MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
//		System.out.println(mInfo);
//		System.out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
//		
//		File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
//		
//		if(path.exists() == false)
//			path.mkdirs();
//		
//		PrintWriter out = new PrintWriter(new FileWriter(path+"\\println.txt"));
//		
//		out.println("제 소개를 하겠습니다.");
//		out.println(mInfo);
//		out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
//		out.close();
		
		File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
		
		if(path.exists() == false)
			path.mkdirs();
		try(OutputStream o = new FileOutputStream(path+"\\println.txt");
				PrintStream out = new PrintStream(o);) {
			
			MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
			out.println("제 소개를 하겠습니다.");
			out.println(mInfo);
			out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
