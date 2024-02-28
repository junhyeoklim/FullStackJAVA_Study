package SalaryDATA;

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
}
