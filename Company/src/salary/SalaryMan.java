package salary;

import java.util.Arrays;

public class SalaryMan {

	private String[][] man = new String[12][4];	
	String str = "";
	public void setSalaryMan(String name, String job, String level, String salary, int cnt)
	{		
			man[cnt][0] = name;
			man[cnt][1] = job;
			man[cnt][2] = level;
			man[cnt][3] = salary;	
	}
	
	public void searchName(String name)
	{
		for(int i =0; i<man.length;i++)
		{
			if(man[i][0].equals(name))
			{				
				System.out.println("부서: " + man[i][1]);
				System.out.println("직급: " + man[i][2]);
				System.out.println("연봉: " + man[i][3]);
			}
		}		
	}
	public void searchJob(String job)
	{
		for(int i =0; i<man.length;i++)
		{
			if(man[i][1].equals(job))
			{
				System.out.println("이름: " + man[0][i]);				
				System.out.println("직급: " + man[i][2]);
				System.out.println("연봉: " + man[i][3]);
				System.out.println();
			}
		}	
		
	}
	public void searchLevel(String level)
	{
		for(int i =0; i<man.length;i++)
		{
			if(man[i][2].equals(level))
			{
				System.out.println("이름: " + man[i][0]);
				System.out.println("부서: " + man[i][1]);		
				System.out.println("연봉: " + man[i][3]);
				System.out.println();
			}
		}	
		
	}
	public void searchSalary(String salary)
	{
		for(int i =0; i<man.length;i++)
		{
			if(man[i][3].equals(salary))
			{
				System.out.println("이름: " + man[i][0]);
				System.out.println("부서: " + man[i][1]);
				System.out.println("직급: " + man[i][2]);
				System.out.println();
			}
		}	
		
	}
	
}
