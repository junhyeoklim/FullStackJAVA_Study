package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class MyInfo
{
	String info;
	public MyInfo(String info) { this.info = info; }
	public String toString() { return info; }
}

class ReTest
{
	public static void main(String[] args)
	{
//		File path = new File("println.txt");
//		
//		try(PrintWriter out = new PrintWriter(path);) {
//			MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
//			out.println("제 소개를 하겠습니다.");
//			out.println(mInfo);
//			out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try(BufferedReader bfr = new BufferedReader(new FileReader(path))
//			) {
//		
//			String str = "";
//			
//			while((str =bfr.readLine()) != null)
//				System.out.println(str);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		24번 문제
//		답 : 유니코드
		
//		25번 문제
//		답 : 운영체제의 기본 인코딩 방식으로의 인코딩을 자동화하기 위해서
		
//		26번 문제
//		답 : Writer,Reader
		
//		27번 문제
//		답 : FileWriter,FileReader
		
//		28번 문제
//		답 : reader(),read(char[] cbuf, int off, int len)
		
//		29번 문제
//		답 : write(int c),write(char[] cbuf, int off, int len)
		
//		30번 문제
//		
//		try(PrintWriter out = new PrintWriter("hyper.txt");) {
//		
//			out.write('A');
//			out.write('B');
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		31번 문제
//		
//		try(BufferedReader bfr = new BufferedReader(new FileReader("hyper.txt"));) {
//			
//			String str = "";
//			
//			while((str = bfr.readLine()) != null)
//				System.out.println(str);
//			
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		32번 문제
//		답 : BufferedWriter,BufferdReader
		
//		33번 문제
//		답 : readLine(),write(String s) 
				
		
//		34번 문제
//		try(PrintWriter out = new PrintWriter("String.txt");) {
//			
//			out.println("박지성 - 메시 멈추게 하는데 집중하겠다.");
//			out.println("올 시즌은 나에게 있어 최고의 시즌이다.");
//			out.println("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
//			out.println("환상적인 결증전이 될 것이다.\n");
//			out.println("기사 제보 및 보도자료");
//			out.println("press@goodnews.co.kr");
//		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		35번 문제
//		try(BufferedReader bfr = new BufferedReader(new FileReader("String.txt"));) {
//			
//			String str = "";
//			
//			while((str = bfr.readLine()) != null)
//				System.out.println(str);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		36번 문제
//		답 : system.out 에 있는 기능을 거의 제공?
		
//		37번 문제
		
//		try(BufferedWriter out = new BufferedWriter(new PrintWriter("printf.txt"));) {
//		
//			out.write("제 나이는 24살 입니다.\n");
//			out.write("저는 자바가 좋습니다.\n");
//			out.write("특히 I/O부분에서 많은 매력을 느낍니다.");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try(BufferedReader bfr = new BufferedReader(new FileReader("printf.txt"));) {
//		
//			String str = "";
//			
//			while((str = bfr.readLine()) != null)
//				System.out.println(str);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


//		39번 문제
//		답 : ObjectOuputStream,ObjectInputStream
		
//		40번 문제 
//		답 : wirteObject(Object o)
		
//		41번 문제
//		답 : readObject();
		
//		42번 문제
//		답 : 직렬화,역직렬화
		
//		43~44번 문제
//		
//		try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("String.txt"));) {
//		
//			o.writeObject(new Circle(1,1,2.4));
//			o.writeObject(new Circle(2,2,4.8));
//			o.writeObject(new String("String implements Serializable"));		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream("String.txt"));) {
//		
//			Circle c = (Circle) o.readObject();
//			Circle c2 = (Circle) o.readObject();
//			String str = (String) o.readObject();
//			
//			c.showCircleInfo();
//			c2.showCircleInfo();
//			System.out.println(str);
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		45번 문제
//		답 : transient 
		
//		46번 문제
//		답 : 디폴트 값으로 초기화 된다.
		
//		47번 문제
//		답 : RandomAccessFile
		
//		48번 문제
//		답 : read(),read(byte[]),readInt(),readDouble()
		
//		49번 문제
//		답 : wirte(int c),write(byte[]),writeInt(int c),writeDouble(double c);
		
//		50번 문제
//		답 : getFilePointer(),seek(long pos)
		
//		try(RandomAccessFile rand = new RandomAccessFile("data.bin", "rw");) {
//			
//			System.out.println("파일의 위치 출력1 : "+rand.getFilePointer());
//			rand.writeInt(200);
//			rand.writeInt(500);
//			System.out.println("파일의 위치 출력2 : "+rand.getFilePointer());
//			rand.writeDouble(48.65);
//			rand.writeDouble(52.24);
//			System.out.println("파일의 위치 출력3 : "+rand.getFilePointer());
//			rand.seek(0);
//			System.out.println("파일의 위치 출력4 : "+rand.getFilePointer());
//			int num1 = rand.readInt();
//			int num2 = rand.readInt();
//			System.out.println(num1+" - "+num2);
//			System.out.println("파일의 위치 출력5 : "+rand.getFilePointer());
//			double d1 = rand.readDouble();
//			double d2 = rand.readDouble();
//			System.out.println(d1+" - "+d2);
//			rand.seek(0);
//			rand.seek(rand.length()); // 마지막 위치로 이동 하는 방법			
//			System.out.println("파일의 위치 출력6 : "+rand.getFilePointer());
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		54번 문제
//		답 : File
		
//		55번 문제
		File path1 = new File("C:\\MyJava");
		File path2 = new File("C:\\YourJava");
		File filePath = new File(path1,"my.bin");
		File movefilePath = new File(path2,"my.bin");
		
		if(path1.exists() == false )
		{
			System.out.println("디렉터리 경로를 생성 하였습니다.");
			path1.mkdirs();
		}
		else if(filePath.exists() == false)
		{
			try(OutputStream out = new FileOutputStream(filePath);) {
			System.out.println("파일 생성이 완료되었습니다.");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(path2.exists() == false)
			path2.mkdirs();
		
		if(filePath.renameTo(movefilePath))
			System.out.println("파일 이동에 성공하였습니다.");
		else
			System.out.println("파일 이동에 실패하였습니다.");
		
		
		
	}
}
//class Circle implements Serializable
//{
//	Point p;
//	double rad;
//	
//	public Circle(int x, int y, double r)
//	{
//		p = new Point(x, y);
//		rad=r;
//	}
//	public void showCircleInfo()
//	{
//		System.out.printf("[%d, %d] \n", p.x, p.y);
//		System.out.println("rad: "+rad);
//	}
//}
//
//class Point implements Serializable
//{
//	int x;
//	int y;
//	
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
