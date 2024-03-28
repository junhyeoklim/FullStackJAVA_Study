package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileIOTest4 {

	public static void main(String[] args) {

		
		File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
		
		if(path.exists() == false)
			path.mkdirs();
		
		try(PrintStream out = new PrintStream(path+"\\String.txt");
		    BufferedReader read = new BufferedReader(new FileReader(path+"\\String.txt"));) {
		
			out.println("박지성 - 메시 멈추게 하는데 집중하겠다.");
			out.println("올 시즌은 나에게 있어 최고의 시즌이다.");
			out.println("팀이 승리하는 것을 돕기 위해 최선을다하겠다.");
			out.println("환상적인 결증전이 될 것이다.\n");
			out.println("기사 제보 및 보도자료");
			out.println("press@goodnews.co.kr");

			String str ="";
			while((str = read.readLine()) != null) 
			{				
				System.out.println(str);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
