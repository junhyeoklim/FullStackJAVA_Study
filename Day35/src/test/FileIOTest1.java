//package test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.net.URLEncoder;
//
//public class FileIOTest1 {
//
//	public static void main(String[] args)  {
//
//		//		1번 문제
//		//		답 : 흐름, 데이터 흐름
//
//		//		2번 문제
//		//		답 : FileInputStream, FileOutputStream
//
//		//		3번 문제
//		//		답 : InputStream
//
//		//		4번 문제
//		//		답 :  read(),close();
//
//		//		5번 문제
//		//		답 : read();
//
//		//		6번 문제
//		//		답 : -1
//
//		//		7번 문제
//		//		답 : FileInputStream <-> FileOutputStream
//		//			InputStream <-> OuputStream
//
//		//		8번 문제
//		//		답 : write(),close()
//
//		//		9번 문제
//
//		File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
//
//		if(path.exists() == false)
//			path.mkdirs();
////		try(OutputStream createFile = new FileOutputStream(path+"\\original.bin");
////				DataOutputStream dos = new DataOutputStream(createFile);
////				InputStream readFile = new FileInputStream(path+"\\original.bin");
////				DataInputStream filterIn = new DataInputStream(readFile);
////				FileOutputStream copyFile = new FileOutputStream(path+"\\copy.bin");
////				) 
////		{
////			int cnt =0;
////			int size = 0;
////			while(cnt <10)
////			{
////				dos.writeInt(200);				
////				cnt++;
////			}
////			int num = filterIn.readInt();
////			
////			while(readFile.read() != -1)
////			{
////				int copy = readFile.read();				
////				copyFile.write(copy);
////				System.out.print(num);
////				
////				size++;
////			}
////			System.out.println();			
////			System.out.println("복사한 바이트 수 : " +size);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
////		10번 문제
////		답 : read(byte[])
//		
////		11번 문제
////		답 : write(byte[])
//		
//		
//		try(OutputStream o = new FileOutputStream(path+"\\printTest.txt");
//			PrintStream print = new PrintStream(o);
//			InputStream read = new FileInputStream(path+"\\printTest.txt");
//			OutputStream copy = new FileOutputStream(path+"\\copyPrint.txt");) {
//			
//			byte[] bte = new byte[1024];
//			int len = 0;
//			int cnt = 0;
//			
//			print.println("아아아 테스트");
//			print.println("아아아 테스트");
//			print.println("아아아 테스트");
//			
//			long startTime = System.currentTimeMillis();
//			while(read.read() != -1)
//			{
//				len = read.read(bte);
//				copy.write(bte, 0, len);
//				cnt += len;
//			}
//			long endTime = System.currentTimeMillis();
//			System.out.println("복사된 바이트 크기 : "+cnt);
//			System.out.println("복사 하는데 걸린 시간 : "+(endTime - startTime));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//
//}
