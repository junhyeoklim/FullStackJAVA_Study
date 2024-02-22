package salary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalaryManCreate {
	private static SalaryManSet slm = new SalaryManSet();

	public static void createSalaryMan() {

		slm.setSalaryMan("홍1", "인사", "사원", "3000",0);
		slm.setSalaryMan("홍2", "인사", "주임", "3500",1);
		slm.setSalaryMan("홍3", "인사", "대리", "4000",2);
		slm.setSalaryMan("홍4", "인사", "과장", "4500",3);		

		slm.setSalaryMan("길1", "총무", "사원", "3100",4);
		slm.setSalaryMan("길2", "총무", "주임", "3300",5);
		slm.setSalaryMan("길3", "총무", "대리", "3500",6);
		slm.setSalaryMan("길4", "총무", "과장", "3700",7);

		slm.setSalaryMan("동1", "영업", "사원", "3100",8);
		slm.setSalaryMan("동2", "영업", "주임", "3200",9);
		slm.setSalaryMan("동3", "영업", "대리", "3300",10);
		slm.setSalaryMan("동4", "영업", "과장", "3400",11);
	}
	public static void searchSalaryMan()
	{
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
				case 1: {			
					System.out.println("\n이름 입력");
					String str = sc.nextLine();	
					slm.searchName(str);
					break;
				}
				case 2: {			
					System.out.println("\n부서 입력");
					String str = sc.nextLine();	
					slm.searchJob(str);
					break;
				}
				case 3: {
					System.out.println("\n직급 입력");
					String str = sc.nextLine();	
					slm.searchLevel(str);
					break;
				}
				case 4: {			
					System.out.println("\n연봉 입력");
					String str = sc.nextLine();	
					slm.searchSalary(str);
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
				break;
			}
			else
			{

				System.out.println("다시 입력 해주세요!");
				check = sc.nextLine();

			}
		}
	}
}
