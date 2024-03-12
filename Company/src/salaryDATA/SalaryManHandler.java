package salaryDATA;

import java.util.Vector;

public class SalaryManHandler {

	private Vector<SalaryManInfo> man;
	private int cnt;
//	private static SalaryManHandler sms;
	private static SalaryManHandler sms;	

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감
	private SalaryManHandler(int size)
	{
		man = new Vector<SalaryManInfo>(size);
	};

	public static SalaryManHandler getSalary(int size)
	{
		if(sms == null)
			sms = new SalaryManHandler(size);
		return sms;
	}

	public void setSalaryMan(SalaryManInfo smi)
	{	
		int i = 0, j=0;		
		int manLength = man.size();
//		if(cnt >= man.length)
//		{
//			System.out.println("더 이상 저장할 수 없습니다.");
//			return;
//		}
		

		for(i=0;i<manLength;i++)
		{
			if(man.get(i).getName().compareTo(smi.getName()) > 0)
			{
//				for(j=cnt-1;j>=i;j--)
//				{
//					man[j+1] = man[j];
//				}
				break;
			}
		}

		man.add(i, smi);
//		cnt++;
	}

	public void searchName(String name)
	{		
		int result = search(name);
		if(result != -1)
			man.get(result).showManAllInfo();
		else
			System.out.println("찾으시는 사용자 정보가 없습니다.");

	}

	public int search(String name)
	{
		int manLength = man.size();
		
		for (int i = 0; i < manLength; i++) {			
			if (man.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;

	}   

	public void searchDepartment(String department)
	{   
		int manLength = man.size();
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i =0;i<manLength;i++)
			{
				if(department.equals(man.get(i).getDepartment()))
				{
					//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
					System.out.println();
					man.get(i).showManDepartment();		
				}
				else if( !(department.equals(man.get(i).getDepartment())) && i == manLength)		
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
		int manLength = man.size();
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i =0;i<manLength;i++)
			{
				if(rank.equals(man.get(i).getRank()))
				{
					//조건이 참이면 입력한 직급에 해당 되는 데이터를 출력
					man.get(i).showManRank();				
				}
				else if( !(rank.equals(man.get(i).getRank())) && i == manLength)		
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
		int manLength = man.size();
		try 
		{
			//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
			for(int i=0;i<manLength;i++)
			{
				if(salary.equals(man.get(i).getSalary()))
				{
					//조건이 참이면 입력한 연봉에 해당 되는 데이터를 출력
					man.get(i).showManSalary();
				}
				else if( !(salary.equals(man.get(i).getRank())) && i == manLength)		
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
		int manLength = man.size();
		try 
		{
			for(int i =0;i<manLength;i++)
			{		
				if(man.get(i).equals(null))									
					break;

				man.get(i).showManAllInfo();
				System.out.println();
			}

		}	
		catch (NullPointerException e) {

		}
	}

}
