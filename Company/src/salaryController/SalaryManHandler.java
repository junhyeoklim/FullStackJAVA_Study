package salaryController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import salaryDATA.SalaryManDTO;

public class SalaryManHandler {

	private ArrayList<SalaryManDTO> man;
	private Iterator<SalaryManDTO> salaryIter;
	private static SalaryManHandler sms;	
	private boolean check;
	private Scanner sc;

	//싱글톤 사용이유 : 검색 하거나 데이터 입력을 할때마다 새로운 객체가 생성 되는지 배열에 널값이 들어감

	private SalaryManHandler(int size) {
		man = new ArrayList<>(size);
		sc = new Scanner(System.in);
	}

	public static SalaryManHandler getSalary(int size) {
		if (sms == null)
			sms = new SalaryManHandler(size);
		return sms;
	}

	public void setSalaryMan(SalaryManDTO smi) {
		if (!man.stream().anyMatch(m -> m.getPhoneNumber().equals(smi.getPhoneNumber()))) {
			man.add(smi);
		} else {
			System.out.println("이미 등록된 사원입니다.");
		}
	}



	public void searchName(String name)
	{		
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getName().compareTo(name) == 0)
			{
				System.out.println();
				man.get(i).showManAllInfo();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");
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
	}   

	public void searchDepartment(String department)
	{   
		salaryIter = man.iterator();

		while(salaryIter.hasNext())
		{
			if(salaryIter.next().getDepartment().equals(department))
			{
				salaryIter.next().showManDepartment();
				
			}			
		}

	}

	public void searchRank(String rank)
	{
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getRank().compareTo(rank) == 0)
			{
				System.out.println();
				man.get(i).showManRank();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");

	}
	public void searchSalary(String salary)
	{
		int manLength = man.size();

		for (int i = 0; i < manLength; i++) {
			if(man.get(i).getSalary().compareTo(salary) == 0)
			{
				System.out.println();
				man.get(i).showManSalary();
				check = true;
			}
		}
		if(!check)
			System.out.println("찾으시는 사원 정보가 없습니다.");
	}

	public void updatePhoneNumber(String name,String phoeNumber)
	{
		salaryIter = man.iterator();
		while(salaryIter.hasNext()) {
			if(salaryIter.next().getName().equals(name))
			{
				salaryIter.next().setPhoneNumber(phoeNumber);		
			}
		}
	}
	public void updateDepartment(String name,String department)
	{
		salaryIter = man.iterator();
		while(salaryIter.hasNext()) {
			if(salaryIter.next().getName().equals(name))
			{
				salaryIter.next().setDepartment(department);		
			}
		}
	}
	public void updateRank(String name,String rank)
	{
		salaryIter = man.iterator();
		while(salaryIter.hasNext()) {
			if(salaryIter.next().getName().equals(name))
			{
				salaryIter.next().setRank(rank);		
			}
		}
	}
	public void updateSalary(String name,String salary)
	{
		salaryIter = man.iterator();
		while(salaryIter.hasNext()) {
			if(salaryIter.next().getName().equals(name))
			{
				salaryIter.next().setSalary(salary);		
			}
		}
	}
	public void updateAllInfo(String name,String phoneNumber,String department, String rank, String salary)
	{
		salaryIter = man.iterator();
		//String	replaceAll(String regex, String replacement) 이거 써서 바꾸기 하자
		while(salaryIter.hasNext())
		{
			if(salaryIter.next().getName().equals(name))
			{
				salaryIter.next().setPhoneNumber(phoneNumber);
				salaryIter.next().setDepartment(department);
				salaryIter.next().setRank(rank);
				salaryIter.next().setSalary(salary);
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
		salaryIter = man.iterator();

		if(!salaryIter.hasNext())
		{
			System.out.println("사원 정보가 존재하지 않습니다.\n");
		}

		else
		{
			while(salaryIter.hasNext())
				salaryIter.next().showManAllInfo();
			System.out.println();	
		}
	}
}

