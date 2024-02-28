package SalaryDATA;


public class SalaryManSet {

	private SalaryManInfo[] man;
	private int cnt;
	private static SalaryManSet sms;

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감
	private SalaryManSet(int size)
	{
		man = new SalaryManInfo[size];
	};

	public static SalaryManSet getSalary(int size)
	{
		if(sms == null)
			sms = new SalaryManSet(size);
		return sms;
	}

	public void setSalaryMan(String name, String department, String rank, String salary)
	{		
		man[cnt++] = new SalaryManInfo(name,department,rank,salary);				
	}

	public void searchName(String name)
	{		
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i =0;i<man.length;i++)
			{			

				if(name.equals(man[i].getName()))
				{		
					//조건이 참이면 입력한 이름에 해당 되는 데이터를 출력
					System.out.println("부서: " + man[i].getRank());
					System.out.println("직급: " + man[i].getDepartment());
					System.out.println("연봉: " + man[i].getSalary());	
					System.out.println();

				}		
				else if( !(name.equals(man[i].getName())) && i == man.length)		
				{					
					break;
				}

			}	
		}	
		catch (NullPointerException e) {

		}

	}


	public void searchDepartment(String department)
	{
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i =0;i<man.length;i++)
			{

				if(department.equals(man[i].getDepartment()))
				{
					//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
					System.out.println();
					System.out.println("이름: " + man[i].getName());				
					System.out.println("직급: " + man[i].getRank());
					System.out.println("연봉: " + man[i].getSalary());				
				}	
				else if( !(department.equals(man[i].getDepartment())) && i == man.length)		
				{					
					break;
				}
			}
		}	
		catch (NullPointerException e) {

		}

	}

	public void searchRank(String rank)
	{
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i =0;i<man.length;i++)
			{
				if(rank.equals(man[i].getRank()))
				{
					//조건이 참이면 입력한 직급에 해당 되는 데이터를 출력
					System.out.println();
					System.out.println("이름: " + man[i].getName());
					System.out.println("부서: " + man[i].getDepartment());		
					System.out.println("연봉: " + man[i].getSalary());			
				}
				else if( !(rank.equals(man[i].getRank())) && i == man.length)		
				{					
					break;
				}
			}	
		}	
		catch (NullPointerException e) {

		}

	}
	public void searchSalary(String salary)
	{
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i=0;i<man.length;i++)
			{
				if(salary.equals(man[i].getSalary()))
				{
					//조건이 참이면 입력한 연봉에 해당 되는 데이터를 출력
					System.out.println();
					System.out.println("이름: " + man[i].getName());
					System.out.println("부서: " + man[i].getDepartment());
					System.out.println("직급: " + man[i].getRank());					
				}
				else if( !(salary.equals(man[i].getRank())) && i == man.length)		
				{					
					break;
				}
			}
		}		
		catch (NullPointerException e) {

		}
	}
	//등록도니 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		try 
		{
			for(int i =0;i<man.length;i++)
			{		
				if(man[i].equals(null))									
					break;

				System.out.println("이름 : "+man[i].getName());
				System.out.println("부서 : "+man[i].getDepartment());
				System.out.println("직급 : "+man[i].getRank());
				System.out.println("연봉 : "+man[i].getSalary());
				System.out.println();
			}

		}	
		catch (NullPointerException e) {

		}
	}

}
