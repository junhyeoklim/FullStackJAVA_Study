package SalaryDATA;


public class SalaryManHandler {

	private SalaryManInfo[] man;
	private int cnt;
	private static SalaryManHandler sms;
	//관리자,일반 사용자 구분

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감
	private SalaryManHandler(int size)
	{
		man = new SalaryManInfo[size];
	};

	public static SalaryManHandler getSalary(int size)
	{
		if(sms == null)
			sms = new SalaryManHandler(size);
		return sms;
	}

	public void setSalaryMan(String name, String department, String rank, String salary)
	{	
		int i = 0, j=0;
		SalaryManInfo smi = new SalaryManInfo(name,department,rank,salary);

		if(cnt >= man.length)
		{
			System.out.println("더 이상 저장할 수 없습니다.");
			return;
		}

		for(i=0;i<cnt;i++)
		{
			if(man[i].getName().compareTo(smi.getName()) > 0)
			{
				for(j=cnt-1;j>=i;j--)
				{
					man[j+1] = man[j];
				}
				break;
			}
		}

		man[i] = smi;
		cnt++;
	}

	public void searchName(String name)
	{		
		int result = search(name);
		if(result != -1)
			man[result].showManAllInfo();
		else
			System.out.println("찾으시는 사용자 정보가 없습니다.");

	}

	public int search(String name)
	{
		int first = 0;
		int last = man.length-1;
		int mid = (first+last)/2;

		while(first<=last)
		{
			if(man[mid].getName().compareTo(name) > 0)
				last = mid-1;

			else if(man[mid].getName().compareTo(name) < 0)
				first = mid+1;

			else
				return mid;

			mid = (first+last)/2;
		}
		return -1;

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
					man[i].showManDepartment();		
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
					man[i].showManRank();				
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
					man[i].showManSalary();
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
	//등록된 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		try 
		{
			for(int i =0;i<man.length;i++)
			{		
				if(man[i].equals(null))									
					break;

				man[i].showManAllInfo();
				System.out.println();
			}

		}	
		catch (NullPointerException e) {

		}
	}

}
