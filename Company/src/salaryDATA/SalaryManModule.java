package salaryDATA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalaryManModule {
	private static final int NAME = 1;
	private static final int JOB = 2;
	private static final int LEVEL = 3;
	private static final int SALARY = 4;
	private static final int LISt = 5;

	
	/*
	 * private String name; private String job; private String level; private String
	 * salary;
	 */



	public static void searchSalaryMan()
	{
		SalaryManSet slm = new SalaryManSet();

		int flag = 0;
		String check = "y";		

		while(true)
		{
			Scanner sc = new Scanner(System.in);

			if(check.equals("y"))
			{
				while(true)
				{
					Scanner sc1 = new Scanner(System.in);
					try {
						System.out.println("검색할 항목을 숫자로 입력 하세요");
						System.out.println("1.이름 2.부서 3.직급 4.연봉");
						flag = sc1.nextInt();							
						break;
					} catch (Exception e) {
						System.out.println("숫자를 입력 해주세요!\n");						
					}					
				}
				switch (flag) {
				case NAME: {			
					System.out.println("\n이름 입력");
					String str = sc.nextLine();	
					slm.searchName(str);
					break;
				}
				case JOB: {			
					System.out.println("\n부서 입력");
					String str = sc.nextLine();	
					slm.searchJob(str);
					break;
				}
				case LEVEL: {
					System.out.println("\n직급 입력");
					String str = sc.nextLine();	
					slm.searchLevel(str);
					break;
				}
				case SALARY: {			
					System.out.println("\n연봉 입력");
					String str = sc.nextLine();	
					slm.searchSalary(str);
					break;
				}				
				case LISt:
				{
					System.out.println("\n 등록된 사원 전체 출력");
					String str = sc.nextLine();	
					slm.salaryManeList();;
					break;
				}
				default:
					System.out.println("\n숫자를 입력 해주세요!");			
				}
				System.out.println("\n계속 검색 하시겠습니까? y,n");
				check = sc.nextLine();
				System.out.println();

			}
			else if(check.equals("n"))
			{
				System.out.println("검색을 종료합니다!");
				return;
			}
			else
			{

				System.out.println("다시 입력 해주세요!");
				check = sc.nextLine();

			}
		}
	}
}
