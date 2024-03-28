package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
class Student implements Comparable<Student>{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int classRank;
	int schooleRank;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int getTotal()
	{
		return kor+eng+math;
	}
	float getAvg()
	{
		return (float) (Math.round((getTotal()/3f)*10)/10.0) ;	
	}
	@Override
	public int compareTo(Student o) {
		if(this.ban == o.ban)
			return o.getTotal() - this.getTotal();
		else
			return this.ban - o.ban;
	}
	public String toString() {
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAvg()
				+","+schooleRank
				+","+classRank;
	}

}

public class Test2 {

	public static void calculateSchoolRank(ArrayList<Student> list)
	{
		Collections.sort(list);

		int preVschoole = -1;
		int preVtotal = 0;
		for(int i=0; i<list.size();i++)
		{
			Student stu = list.get(i);

			if(stu.getTotal() == preVtotal)
				stu.schooleRank = preVschoole;
			else
			{

				stu.schooleRank = i+1;
			}

			preVtotal = stu.getTotal();
			preVschoole = stu.schooleRank;
		}
	}
	public static void calculateClassRank(ArrayList<Student> list)
	{
		int preVclass = -1;
		int preVtotal = -1;
		int preVban = 0;
		int cnt = 0;

		for(int i=0;i<list.size();i++)
		{
			Student stu = list.get(i);

			if(stu.ban != preVban)
			{
				preVclass = -1;
				preVtotal = -1;
				cnt = 0;
			}
			if(stu.getTotal() == preVtotal)
			{
				stu.classRank = preVclass;
			}
			else
				stu.classRank = cnt+1;

			preVban = stu.ban;
			preVclass = stu.schooleRank;
			preVtotal = stu.getTotal();

			cnt++;
		}

	}
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",2,1,70,90,70)); 
		// 이름, 반, 번호, 국어, 영어, 수학
		list.add(new Student("안자바",2,2,60,100,80)); 
		list.add(new Student("홍길동",1,3,100,100,100)); 
		list.add(new Student("남궁성",1,1,90,70,80)); 
		list.add(new Student("김자바",1,2,80,80,90));
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator<Student> it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
