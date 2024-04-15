package salaryVO;

public class SalaryManVO {

	private String name;
	private String department;
	private String rank;
	private int salary;
	private String phoneNumber;


	public SalaryManVO(String name,String phoneNumber,String department,String rank,int salary)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
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


	public int getSalary() {
		return salary;
	}	
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public void showManAllInfo()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("부서 : "+department);
		System.out.println("직급 : "+rank);
		System.out.println("연봉 : "+salary);
	}

	public void showManDepartment()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("직급 : "+rank);
		System.out.println("연봉 : "+salary);
	}

	public void showManRank()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("부서 : "+department);
		System.out.println("연봉 : "+salary);

	}

	public void showManSalary()
	{
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNumber);
		System.out.println("부서 : "+department);
		System.out.println("직급 : "+rank);
	}
}


