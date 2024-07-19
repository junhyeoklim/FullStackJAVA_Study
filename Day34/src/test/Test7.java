package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test7 {

	public static void main(String[] args) throws FileNotFoundException {

		
//		1번 문제
//		답 : 데이터의 흐름, 데이터의 흐름을 형성해주는 통로
		
//		2번 문제
//		답 : InputStream , OutputStream
	
//		3번 문제
//		답 : InputStream		
		
//		4번 문제
//		답 : read(),close()
		
//		5번 문제
//		답 : read()
		
//		6번 문제
//		답 : -1

//		7번 문제
//		답 : InputStream <-> OutputStream, FileInputStream <-> FileOutputStream
		
//		8번 문제
//		답 : write(),close()
		
////		9번 문제
//		
//		File test = new File("C:\\JavaStudy\\eclipse\\Day34\\src\\test");
//		
//		if(test.exists() == false)
//			test.mkdir();
//		int r =0;
//		int cnt = 0;
//		
//		try {
//			FileInputStream original = new FileInputStream(test+"\\original.txt");
//			FileOutputStream copy = new FileOutputStream(test+"\\copy.txt"); 
//			
//		while((r = original.read()) != -1)
//		{
//			copy.write(r);			
//			cnt++;			
//		}
//			
//		System.out.println("복사된 byte는 " +cnt);
//		original.close();
//		copy.close();
//		}
//			 catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//		
//		10번 문제
//		답 : read(byte[])
			
//		11번 문제
//		답 : write(byte[])
		
//		12번 문제
//		File test = new File("C:\\JavaStudy\\eclipse\\Day34\\src\\test");
//		byte[] r = new byte[1024];
//		int len = 0;
//		int cnt = 0;
//		
//		if(test.exists() == false)
//			test.mkdir();
//		
//		FileInputStream original = new FileInputStream(test+"\\original.txt");
//		FileOutputStream copy = new FileOutputStream(test+"\\copy.txt");
//		
//		try {
//			while((len = original.read(r)) != -1)
//			{
//				copy.write(r,0,len);
//				cnt++;
//			}
//			System.out.println(cnt+"복사 완료");
//			
//			original.close();
//			copy.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		13번 문제
//		답 : 필터 스트림 ,필터 입력 스트림 - 필터 출력 스트림
		
//		14번 문제
//		답 : DataInputStream,DataOutPutStream
		
//		15번 문제 
		
//		File test = new File("C:\\JavaStudy\\eclipse\\Day34\\src\\test");
//		
//		if(test.exists() == false)
//			test.mkdirs();
//		
//			try(OutputStream out = new FileOutputStream(test+"\\newFile.bin");
//				DataOutputStream filterOut = new DataOutputStream(out);) {
//				
//				
//				filterOut.writeInt(275);
//				filterOut.writeDouble(45.79);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			try(InputStream in = new FileInputStream(test+"\\newFile.bin");
//					DataInputStream filterIn = new DataInputStream(in);) {
//				int num1 = filterIn.readInt();
//				double num2 = filterIn.readDouble();
//				System.out.println(num1);
//				System.out.println(num2);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
//		16번 문제
//		답 : FilterInputStream,FilterOutputStream
		
//		17번 문제
//		답: BunfferedInputStream,BufferedOuputStream
		
//		18번 문제
//		File test = new File("C:\\JavaStudy\\eclipse\\Day34\\src\\test");
//		
//		if(test.exists() == false)
//			test.mkdirs();
//		int cnt = 0;
//		int len = 0;
//		try(FileInputStream original = new FileInputStream(test+"\\original.txt");
//			BufferedInputStream bin = new BufferedInputStream(original);
//			FileOutputStream copy = new FileOutputStream(test+"\\copy.txt");
//			BufferedOutputStream bout = new BufferedOutputStream(copy)	
//				)
//		{
//			long startTime = System.currentTimeMillis();
//			while((len = bin.read()) != -1)
//			{
//				bout.write(len);
//				cnt++;
//			}
//			long endTime = System.currentTimeMillis();			
//			System.out.println(cnt+"복사 완료");
//			System.out.println("경과 시간 : "+(endTime - startTime));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
//		21번 문제
		File test = new File("C:\\JavaStudy\\eclipse\\Day34\\src\\test");
		
		if(test.exists() == false)
			test.mkdirs();
		
			try(OutputStream out = new FileOutputStream(test+"\\newFile.bin");
				BufferedOutputStream bout = new BufferedOutputStream(out);
				DataOutputStream dout = new DataOutputStream(bout);
				 ) {
				
				long startTime = System.currentTimeMillis();
				dout.writeInt(275);
				dout.writeDouble(45.79);
				long endTime = System.currentTimeMillis();
				
				System.out.println("복사 시간 : "+(endTime-startTime));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			try(InputStream in = new FileInputStream(test+"\\newFile.bin");
				BufferedInputStream bin = new BufferedInputStream(in);
					DataInputStream filterIn = new DataInputStream(bin);) {
				int num1 = filterIn.readInt();
				double num2 = filterIn.readDouble();
				System.out.println(num1);
				System.out.println(num2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
