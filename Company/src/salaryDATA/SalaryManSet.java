package salaryDATA;


public class SalaryManSet {

	private String[][] man = new String[4][2];	
	private String str = "";
	private int check = 0,cnt= 0;
	
	
	public void setSalaryMan(String name, String job, String level, String salary)
	{		
		man[0][cnt] = name;
		man[1][cnt] = job;
		man[2][cnt] = level;
		man[3][cnt] = salary;	
		cnt++;
		
		System.out.println("cnt값 확인 : "+ cnt);
	}

	public void searchName(String name)
	{
		System.out.println("배열 확인하기 : "+man[0][0]);
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;i<man[0].length;i++)
		{			
			System.out.println("데이터 확인하기1 : "+name);
			System.out.println("배열 확인하기 : 2"+man[0][0]);
			if(name.equals(man[0][i]))
			{
				System.out.println("데이터 확인하기2 : "+name);
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

			if(i >= man.length)
			{				
				break;
			}
			else if(cnt == man.length)
			{
				//카운트 한 값이 배열의 길이랑 일치 할 경우 출력 후 반복문을 빠져나감
				System.out.println("해당되는 부서가 존재 하지 않습니다\n");
				break;
			}
			else if(job.equals(man[1][i]) && i < man.length)
			{
				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);				
				System.out.println("직급: " + man[2][i]);
				System.out.println("연봉: " + man[3][i]);				
			}	
			else if(!(job.equals(man[1][i]) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}
	}
	
	public void searchLevel(String level)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;i<man[2].length;i++)
		{
			if(i >= man.length)
			{				
				break;
			}
			else if(cnt == man.length)
			{
				//카운트 한 값이 배열의 길이랑 일치 할 경우 출력 후 반복문을 빠져나감
				System.out.println("해당되는 직급이 존재 하지 않습니다\n");
				break;
			}
			else if(level.equals(man[2][i]) && i < man.length)
			{
				//조건이 참이면 입력한 직급에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);
				System.out.println("부서: " + man[1][i]);		
				System.out.println("연봉: " + man[3][i]);			
			}
			else if(!(level.equals(man[2][i]) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}	

	}
	public void searchSalary(String salary)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i=0;i<man[3].length;i++)
		{
			if(i >= man.length)
			{			
				//배열에 있는 값들을 다 확인 후 빠져나가는 브레이크문
				break;
			}
			else if(cnt == man.length)
			{
				//카운트 한 값이 배열의 길이랑 일치 할 경우 출력 후 반복문을 빠져나감
				System.out.println("해당되는 연봉이 존재 하지 않습니다\n");
				break;
			}
			else if(salary.equals(man[3][i]) && i < man.length)
			{
				//조건이 참이면 입력한 연봉에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[0][i]);
				System.out.println("부서: " + man[1][i]);
				System.out.println("직급: " + man[2][i]);					
			}	
			else if(!(salary.equals(man[3][i]) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}	

	}
	
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
