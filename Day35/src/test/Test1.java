//package test;
//
//import java.util.Iterator;
//import java.util.TreeSet;
//
//class Student implements Comparable<Student>{
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
//	int getTotal()
//	{
//		return kor+eng+math;
//	}
//	float getAvg()
//	{
//		return (float) (Math.round((getTotal()/3f)*10)/10.0) ;	
//	}
//	@Override
//	public int compareTo(Student o) {
//		return (int) (getAvg() - o.getAvg());
//	}
//	public String toString() {
//		return name
//				+","+ban
//				+","+no
//				+","+kor
//				+","+eng
//				+","+math
//				+","+getTotal()
//				+","+getAvg();
//	}
//	
//}
//
//public class Test1 {
//
//	public static int cntAvg(TreeSet<Student> set, int from,int to)
//	{
//		Student first = new Student(null, to, to, from, from, from);
//		Student second = new Student(null, to, to, to, to, to);
//		
//		return set.subSet(first, second).size();
//	}
//	
//	public static void main(String[] args) {
//
//		TreeSet<Student> stuTree = new TreeSet<>();
//		
//		stuTree.add(new Student("이자바", 1, 4, 70, 90, 70));
//		stuTree.add(new Student("남궁성", 1, 2, 90, 70, 80));
//		stuTree.add(new Student("김자바", 1, 3, 80, 80, 90));
//		stuTree.add(new Student("홍길동", 1, 1, 100, 100, 100));
//		
//		
//		Iterator<Student> iter = stuTree.iterator();
//		
//		while(iter.hasNext())
//			System.out.println(iter.next());
//		
//		System.out.println("[60~69] : "+cntAvg(stuTree,60,69)); 
//		System.out.println("[70~79] : "+cntAvg(stuTree,70,79)); 
//		System.out.println("[80~89] : "+cntAvg(stuTree,80,89)); 
//		System.out.println("[90~100] : "+cntAvg(stuTree,90,101)); 
//		
//	}
//
//}
