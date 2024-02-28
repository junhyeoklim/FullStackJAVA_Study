package salaryUI;

import java.util.Scanner;

import SalaryDATA.SalaryManSet;

public class SalaryManCreate {

	private static SalaryManSet salarySet = SalaryManSet.getSalary(100);
	private static String name;
	private	static String department;
	private	static String rank;
	private	static String salary;
	private static final int NAME = 1;
	private static final int DEPARTMENT = 2;
	private static final int RANK = 3;
	private static final int SALARY = 4;


	public static void createSalaryMan() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("사원 정보 입력하기!");

		System.out.println("이름을 입력 해주세요!");
		System.out.print("이름 : ");
		name = sc.nextLine();

		System.out.println("부서를 입력 해주세요!");
		System.out.print("부서 : ");
		department = sc.nextLine();

		System.out.println("직급을 입력 해주세요!");
		System.out.print("직급 : ");
		rank = sc.nextLine();

		System.out.println("연봉을 입력해주세요!");
		System.out.print("연봉 : ");
		salary = sc.nextLine();
		System.out.println();
		salarySet.setSalaryMan(name, department, rank, salary);			

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
				case NAME: {			
					System.out.println("\n이름 입력");
					String str = sc.nextLine();	
					salarySet.searchName(str);
					break;
				}
				case DEPARTMENT: {			
					System.out.println("\n부서 입력");
					String str = sc.nextLine();	
					salarySet.searchDepartment(str);
					break;
				}
				case RANK: {
					System.out.println("\n직급 입력");
					String str = sc.nextLine();	
					salarySet.searchRank(str);
					break;
				}
				case SALARY: {			
					System.out.println("\n연봉 입력");
					String str = sc.nextLine();	
					salarySet.searchSalary(str);
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
	public static void salaryList()
	{
		salarySet.salaryManeList();
	}
}
