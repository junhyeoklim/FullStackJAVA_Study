package salaryUI;

import java.util.Scanner;
import java.util.Vector;

import salaryDATA.SalaryConstatnt;
import salaryDATA.SalaryManHandler;
import salaryDATA.SalaryManInfo;

public class SalaryUI {
	private static SalaryManHandler salarySet = SalaryManHandler.getSalary(2);
	private static String name;
	private	static String department;
	private	static String rank;
	private	static String salary;	
	private static Scanner sc = new Scanner(System.in);


	public static void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 사원 정보 입력");
		System.out.println("2. 사원 정보 검색");
		System.out.println("3. 사원 정보 변경");
		System.out.println("4. 모든 사원정보 보기");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void salraryCreate()
	{


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
		salarySet.setSalaryMan(new SalaryManInfo(name, department, rank, salary));	
	}

	public static void salrarySearch()
	{
		int flag = 0;
		String check = "y";	
		while(true)
		{


			if(check.equals("y"))
			{
				while(true)
				{
					Scanner sc1 = new Scanner(System.in);
					try {
						System.out.println("검색할 항목을 숫자로 입력 하세요");
						System.out.println("1.이름 2.부서 3.직급 4.연봉");
						flag = sc1.nextInt();
						sc1.nextLine();						
						break;
					} catch (Exception e) {
						System.out.println("숫자를 입력 해주세요!\n");
						sc.nextLine();
					}	

				}
				switch (flag) {
				case SalaryConstatnt.NAME: {			
					System.out.println("\n이름 입력");
					String str = sc.nextLine();	
					salarySet.searchName(str);
					break;
				}
				case SalaryConstatnt.DEPARTMENT: {			
					System.out.println("\n부서 입력");
					String str = sc.nextLine();	
					salarySet.searchDepartment(str);
					break;
				}
				case SalaryConstatnt.RANK: {
					System.out.println("\n직급 입력");
					String str = sc.nextLine();	
					salarySet.searchRank(str);
					break;
				}
				case SalaryConstatnt.SALARY: {			
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

	public static void salaryUpdateUI(){
		System.out.println("사원정보 변경을 시작합니다.");
		System.out.println("변경하고자 하는 사원 이름을 입력 해주세요");

		System.out.print("이믈:");
		name = sc.nextLine();		

		int result = salarySet.search(name);

		if(result == -1)
		{
			System.out.println("찾으시는 사용자 정보가 없습니다.");
			return;
		}

		System.out.println("변경 할려는 카테고리를 선택 하세요.");
		System.out.println("1. 부서, 2. 직급, 3.연봉, 4.전체");
		System.out.print("선택>>");
		int choice = sc.nextInt();		
		sc.nextLine();

		switch (choice) {
		case SalaryConstatnt.UPDATE_DEPARTMENT: {
			System.out.println("변경할 부서 이름을 입력 하세요.");
			System.out.print("부서 :");
			department = sc.nextLine();
			salarySet.updateDepartment(name,department);
			System.out.println("변경이 완료 되었습니다!");
			break;				
		}
		case SalaryConstatnt.UPDATE_RANK: {
			System.out.println("새로운 직급을 입력 하세요.");
			System.out.print("직급 :");
			rank = sc.nextLine();
			salarySet.updateRank(name, rank);
			System.out.println("변경이 완료 되었습니다!");
			break;				
		}
		case SalaryConstatnt.UPDATE_SALARY: {
			System.out.println("변경할 연봉을 입력 하세요.");
			System.out.print("연봉 :");
			salary = sc.nextLine();
			salarySet.updateSalary(name, salary);
			System.out.println("변경이 완료 되었습니다!");
			break;				
		}
		case SalaryConstatnt.UPDATE_ALL: {
			System.out.println("새롭게 변경될 정보들을 입력 하세요.");
			System.out.print("부서 :");
			department = sc.nextLine();
			
			System.out.print("직급 :");
			rank = sc.nextLine();
			
			System.out.print("연봉 :");
			salary = sc.nextLine();			

			salarySet.updateAllInfo(name, department,rank,salary);
			System.out.println("변경이 완료 되었습니다!");
			break;				
		}
		default:
			System.out.println("올바른 값을 입력 해주세요!");
		}
	}
}
