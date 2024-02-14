package view;
import java.util.Scanner;
public class TeamHomework {
	// 등차수열 재귀함수로

	   public static void main(String[] args)
	   {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("첫항 입력 : ");
	      int a = sc.nextInt();

	      
	      System.out.println("공차 입력 : ");
	      int d = sc.nextInt();

	      
	      System.out.println("몇번째 항까지? : ");
	      int n = sc.nextInt();
	      arithmetic(a, d, n);

	      
	   }   
	   public static void arithmetic(int a, int d, int n)
	   {
	         if (n == 1)
	         {
	            System.out.print(a + "  ");   //System.out.print(a + " ");
	         } 


	         else
	         {
	            int resultOfArithmetic = a + (n-1)*d;
	            
	            arithmetic(a, d, n-1);
	            System.out.print(resultOfArithmetic + "  ");

	         }
	             
	   }   
	}

