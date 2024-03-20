package salaryController;

import java.util.Scanner;
import java.util.Vector;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import salaryDATA.SalaryManDTO;

public class SalaryManHandler {

	private Vector<SalaryManDTO> man;
	private static SalaryManHandler sms;	
	private boolean check;
	private Scanner sc = new Scanner(System.in);
	


	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감
	private SalaryManHandler(int size)
	{
		man = new Vector<SalaryManDTO>(size);
	};

	public static SalaryManHandler getSalary(int size)
	{
		if(sms == null)
			sms = new SalaryManHandler(size);
		return sms;
	}

	public void setSalaryMan(SalaryManDTO smi)
	{	
		int manLength = man.size();
		int i = 0, j=0;		
		
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

		//기존에 사용하던 알고리즘
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;

		//Pattern 사용 알고리즘
		//		Pattern p = Pattern.compile(name);
		//
		//		for (int i = 0; i < manLength; i++) {			
		//			Matcher m = p.matcher(man.get(i).getName());			
		//			if(m.matches())
		//				return i;
		//		}
		//		return -1;

	}   

	public void searchDepartment(String department)
	{   
		int manLength = man.size();

		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		//		Pattern p = Pattern.compile(department);
		//
		//		for (int i = 0; i < manLength; i++) {			
		//			Matcher m = p.matcher(man.get(i).getDepartment());
		//			if(m.matches())
		//			{
		//				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
		//				System.out.println();
		//				man.get(i).showManDepartment();	
		//				check = true;
		//			}				
		//		}

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getDepartment().compareTo(department) == 0)
			{
				man.get(i).showManDepartment();	
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사용자 정보가 없습니다.");
	}

	public void searchRank(String rank)
	{
		int manLength = man.size();
		//		Pattern p = Pattern.compile(rank);
		//
		//		for (int i = 0; i < manLength; i++) {			
		//			Matcher m = p.matcher(man.get(i).getRank());
		//			if(m.matches())
		//			{
		//				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
		//				System.out.println();
		//				man.get(i).showManRank();	
		//				check = true;
		//			}				
		//		}
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getRank().compareTo(rank) == 0)
			{
				System.out.println();
				man.get(i).showManRank();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사용자 정보가 없습니다.");

	}
	public void searchSalary(String salary)
	{
		int manLength = man.size();
		//		Pattern p = Pattern.compile(salary);
		//
		//		for (int i = 0; i < manLength; i++) {			
		//			Matcher m = p.matcher(man.get(i).getSalary());
		//			if(m.matches())
		//			{
		//				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
		//				System.out.println();
		//				man.get(i).showManSalary();	
		//				check = true;
		//			}				
		//		}
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getSalary().compareTo(salary) == 0)
			{
				System.out.println();
				man.get(i).showManSalary();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사용자 정보가 없습니다.");
	}

	public void updateDepartment(String name,String department)
	{
		int manLength = man.size();
		//String	replaceAll(String regex, String replacement) 이거 써서 바꾸기 하자
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setDepartment(department);		
			}
		}
	}
	public void updateRank(String name,String rank)
	{
		int manLength = man.size();
		//String	replaceAll(String regex, String replacement) 이거 써서 바꾸기 하자
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setRank(rank);		
			}
		}
	}
	public void updateSalary(String name,String salary)
	{
		int manLength = man.size();
		//String	replaceAll(String regex, String replacement) 이거 써서 바꾸기 하자
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setSalary(salary);		
			}
		}
	}
	public void updateAllInfo(String name,String department, String rank, String salary)
	{
		int manLength = man.size();
		//String	replaceAll(String regex, String replacement) 이거 써서 바꾸기 하자
		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				man.get(i).setDepartment(department);
				man.get(i).setRank(rank);
				man.get(i).setSalary(salary);
			}
		}
	}

	public void deleteSalary(int idx)
	{
		man.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}
	//등록된 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		int manLength = man.size();

		if(manLength == 0)
		{
			System.out.println("사원 정보가 존재하지 않습니다.\n");
			return;
		}

		for(int i =0;i<manLength;i++)
		{
			man.get(i).showManAllInfo();
			System.out.println();	
		}				
	}

}
