package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileIoTest6 {

	public static void main(String[] args) {
File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
		
		if(path.exists() == false)
			path.mkdirs();
		
		try(PrintWriter out= new PrintWriter(new FileWriter(path+"\\printf.txt"));				
			BufferedWriter bfw = new BufferedWriter(out);
			InputStream size = new FileInputStream(path+"\\printf.txt");						
				)	
		{
			bfw.write("제 나이는 24살 입니다.\n\n");			
			bfw.write("저는 자바가 좋습니다.\n");			
			bfw.write("특히 I/O 부분에서 많은 매력을 느낍니다.\n");

			
//			char[] cnt = new char[54];
//			int readCnt = bfr.read(cnt, 0, cnt.length);
			
			
//			for(int i=0;i<readCnt;i++)
//			{
//				System.out.print(cnt[i]);
//			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		try(BufferedReader bfr = new BufferedReader(new FileReader(path+"\\printf.txt"));) 
		{
			String str = null;
			while((str = bfr.readLine()) != null)
			{				
				System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
