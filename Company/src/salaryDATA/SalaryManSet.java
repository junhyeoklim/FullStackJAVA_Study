package salaryDATA;


public class SalaryManSet {

	private String[][] man = new String[4][2];	
	private String str = "";
	private int check = 0,cnt= 0;
	private static SalaryManSet sms;
	
	//싱글톤 사용
	private SalaryManSet(){};
	
	public static SalaryManSet setSalary()
	{
		if(sms == null)
			sms = new SalaryManSet();
		return sms;
	}
	
	public void setSalaryMan(String name, String job, String level, String salary)
	{		
		man[0][cnt] = name;
		man[1][cnt] = job;
		man[2][cnt] = level;
		man[3][cnt] = salary;	
		cnt++;		
	}
	
	public void searchName(String name)
	{		
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;i<man[0].length;i++)
		{			
		
			if(name.equals(man[0][i]))
			{		
				//조건이 참이면 입력한 이름에 해당 되는 데이터를 출력
				System.out.println("부서: " + man[1][i]);
				System.out.println("직급: " + man[2][i]);
				System.out.println("연봉: " + man[3][i]);	
				System.out.println();
				break;
			}		
			else
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다.");
				break;
			}
		}		
	}

	public void searchJob(String job)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;i<man[1].length;i++)
		{
	
			if(job.equals(man[1][i]))
			{
				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);				
				System.out.println("직급: " + man[2][i]);
				System.out.println("연봉: " + man[3][i]);				
			}	
			else
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다.");
				break;
			}
		}
	}

	public void searchLevel(String level)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;i<man[2].length;i++)
		{
			if(level.equals(man[2][i]))
			{
				//조건이 참이면 입력한 직급에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);
				System.out.println("부서: " + man[1][i]);		
				System.out.println("연봉: " + man[3][i]);			
			}
			else
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다.");
				break;
			}
		}	

	}
	public void searchSalary(String salary)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i=0;i<man[3].length;i++)
		{
			if(salary.equals(man[3][i]))
			{
				//조건이 참이면 입력한 연봉에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);
				System.out.println("부서: " + man[1][i]);
				System.out.println("직급: " + man[2][i]);					
			}	
			else
			{
				System.out.println("일치하는 데이터가 존재하지 않습니다.");
				break;
			}
		}	

	}
	//등록도니 사원 전부를 출력하는 메소드
	public void salaryManeList()
	{
		for(int i =0;i<man[0].length;i++)
		{			
			try {
				System.out.println("이름 : "+man[0][i]);
				System.out.println("부서 : "+man[1][i]);
				System.out.println("직급 : "+man[2][i]);
				System.out.println("연봉 : "+man[2][i]);
				System.out.println();
			} catch (NullPointerException e) {	

			}			
		}		
	}

}
