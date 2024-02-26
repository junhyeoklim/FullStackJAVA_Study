package salaryDATA;

import java.util.Scanner;

public class SalaryManCreate {
	
	private static SalaryManSet slm = new SalaryManSet();
	private static String name;
	private static String job;
	private static String level;
	private static String salary;
	
	public static void createSalaryMan() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("사원 정보 입력하기!");

			System.out.println("이름을 입력 해주세요!");
			System.out.print("이름 : ");
			name = sc.nextLine();
			
			System.out.println("부서를 입력 해주세요!");
			System.out.print("부서 : ");
			job = sc.nextLine();
			
			System.out.println("직급을 입력 해주세요!");
			System.out.print("직급 : ");
			level = sc.nextLine();
			
			System.out.println("연봉을 입력해주세요!");
			System.out.print("연봉 : ");
			salary = sc.nextLine();
			slm.setSalaryMan(name, job, level, salary);

		
	}
}
