//package test;
//
//import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//
//public class FileIOTest5 {
//
//	public static void main(String[] args) {
//		
//		File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
//		
//		if(path.exists() == false)
//			path.mkdirs();
//		
//		try(PrintWriter print = new PrintWriter(path+"\\printf.txt");
//		
//				) {
//			
//			print.printf("제 나이는 %d 살 입니다.\n",24);
//			print.println("저는 자바가 좋습니다.");
//			print.println("특히 I/O 부분에서 많은 매력을 느낍니다.");
//			
//			String str;
//	
//			try (BufferedReader read = new BufferedReader(new FileReader(path+"\\printf.txt"))) {
//				while(true)
//				{
//					str = read.readLine();
//					if(str == null)
//						break;
//					System.out.println(str);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
