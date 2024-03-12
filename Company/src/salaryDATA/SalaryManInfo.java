package salaryDATA;

public class SalaryManInfo {

	private String name;
	private String department;
	private String rank;
	private String salary;


	public SalaryManInfo(String name,String department,String rank,String salary)
	{
		this.name = name;
		this.department = department;
		this.rank = rank;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public String getDepartment() {
		return department;
	}


	public String getRank() {
		return rank;
	}


	public String getSalary() {
		return salary;
	}	

	public void showManAllInfo()
	{
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+department);
		System.out.println("직급 : "+rank);
		System.out.println("연봉 : "+salary);
	}

	public void showManDepartment()
	{
		System.out.println("이름 : "+name);
		System.out.println("직급 : "+rank);
		System.out.println("연봉 : "+salary);
	}

	public void showManRank()
	{
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+department);
		System.out.println("연봉 : "+salary);

	}

	public void showManSalary()
	{
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+department);
		System.out.println("직급 : "+rank);
	}
}


