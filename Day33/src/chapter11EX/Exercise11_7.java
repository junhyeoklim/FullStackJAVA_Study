package chapter11EX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//class Student {
//	String name;
//	int ban;
//	int no;
//	int kor;
//	int eng;
//	int math;
//	Student(String name, int ban, int no, int kor, int eng, int math) {
//		this.name = name;
//		this.ban = ban;
//		this.no = no;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}
//	int getTotal() {
//		return kor+eng+math;
//	}
//	float getAverage() {
//		return (int)((getTotal()/ 3f)*10+0.5)/10f;
//	}
//	public String toString() {
//		return name
//				+","+ban
//				+","+no
//				+","+kor
//				+","+eng
//				+","+math
//				+","+getTotal()
//				+","+getAverage()
//				;
//	}
//
//}
//class BanNoAscending implements Comparator<Student> {	
//	@Override
//	public int compare(Student o1, Student o2) {
//		if(o1.ban == o2.ban)
//			return o1.no - o2.no;					
//		return o1.ban - o2.ban;
//	}
//}
//public class Exercise11_7 {
//
//	public static void main(String[] args) {
//		ArrayList<Student> list = new ArrayList<>();
//		list.add(new Student("이자바",2,1,70,90,70)); 
//		list.add(new Student("안자바",2,2,60,100,80)); 
//		list.add(new Student("홍길동",1,3,100,100,100)); 
//		list.add(new Student("남궁성",1,1,90,70,80)); 
//		list.add(new Student("김자바",1,2,80,80,90)); 
//		Collections.sort(list, new BanNoAscending());
//		Iterator<Student> it = list.iterator();
//		while(it.hasNext())
//		System.out.println(it.next());
//	}
//
//}
