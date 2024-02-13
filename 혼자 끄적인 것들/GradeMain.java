import java.util.Scanner;

class Grade
{
	double sub1,sub2,sub3,avg,avgresult;

	public void gradeGet(double num1,double num2,double num3)
	{
		sub1 = num1;
		sub2 = num2;
		sub3 = num3;

		gradeAverage();
		printGrade();
	}

	public void gradeAverage()
	{
		avg = (sub1+sub2+sub3)/3;
		//소수점 둘째자리까지 표시
		avgresult = Math.round(avg*100)/100.0;
	}

	public void printGrade()
	{
		//입력 받은 과목 소수점 제거 
		System.out.printf("\n국어 점수 : %.0f\n",sub1);
		System.out.printf("수학 점수 : %.0f\n",sub2);
		System.out.printf("영어 점수 : %.0f\n\n",sub3);
		System.out.println("평균 : "+avgresult);
	}
}

class GradeMain
{
	public static void main(String[] args)
	{
		double sub1 = 0,sub2 = 0,sub3 = 0;

		Scanner sc = new Scanner(System.in);
		Grade gd = new Grade();


		System.out.println("국어 점수를 입력 해주세요.");
		System.out.print("점수 : ");
		sub1 = sc.nextInt();	

		System.out.println("\n수학 점수를 입력 해주세요.");
		System.out.print("점수 : ");
		sub2 = sc.nextInt();

		System.out.println("\n영어 점수를 입력 해주세요.");
		System.out.print("점수 : ");
		sub3 = sc.nextInt();

		gd.gradeGet(sub1,sub2,sub3);
	}
}