package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.RandomAccess;

class Circle implements Serializable
{
	Point p;
	double rad;
	
	public Circle(Point p, double r)
	{
		this.p = p;
		rad=r;
	}
	public void showCircleInfo()
	{
		System.out.printf("[%d, %d] \n", p.x, p.y);
		System.out.println("rad: "+rad);
	}
}

class Point implements Serializable
{
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class FileIOTest6_1 {

	public static void main(String[] args) {

//		39번 문제 
//		답 : InputStream,OutputStream
		
//		40번 문제
//		답 : writeObject()
		
//		41번 문제
//		답 : readObject() , ClassNotFoundException
		
//		42번 문제
//		답 : 
		
//		43번 문제
	File path = new File("C:\\JavaStudy\\eclipse\\Day35\\src\\test");
		
//		try(ObjectOutputStream c1  = new ObjectOutputStream(new FileOutputStream(path+"\\circle.txt"));) {
//			
//			c1.writeObject(new Circle(1, 1, 2.4));
//			c1.writeObject(new Circle(2, 2, 4.8));
//			c1.writeObject(new String("String implements Serializable"));
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path+"\\circle.txt"));
//				) 
//		{
//			Circle c1 = (Circle) in.readObject();
//			Circle c2 = (Circle) in.readObject();
//			String str = (String) in.readObject();
//			
//			c1.showCircleInfo();
//			c2.showCircleInfo();
//			
//			System.out.println(str);
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
//	}
	
//		44번 문제 
	
		try(ObjectOutputStream c = new ObjectOutputStream(new FileOutputStream(path+"\\circle2.txt"));) {
			
			c.writeObject(new Circle(new Point(1, 1), 2.4));
			c.writeObject(new Circle(new Point(2, 2), 4.9));
			c.writeObject(new String("String implements Serializable"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(	ObjectInputStream read = new ObjectInputStream(new FileInputStream(path+"\\\\circle2.txt"));) {
		
			Circle c1 = (Circle) read.readObject();
			Circle c2 = (Circle) read.readObject();
			String str = (String) read.readObject();
			
			c1.showCircleInfo();
			c2.showCircleInfo();
			
			System.out.println(str);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		45번 문제
//		답 : transient
		
//		46번 문제
//		답 : 디폴트 값이 초기화 된다.
		
//		47번 문제
//		답 : RandomAccessFile
		
//		48번 문제
//		답 : read(),read(byte[]),readInt(),readDouble()
		
		
	
	}
}
