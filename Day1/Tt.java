import java.util.Scanner;

class Tt
{
	public static void main(String[] args)
	{
		System.out.println("학점을 입력하시오.");
		Scanner scan = new Scanner(System.in);
		double score = scan.nextDouble();
		String grade = "";

		switch((int)score/10)
		{
		  case 9 : 
		    grade = "A";
		    break;
		   default :
		    grade = "F";
		     break;
		}
		System.out.println("학점 : " + grade);
	}
}