package salary;


public class SalaryManSet {

	private String[][] man = new String[12][4];	
	private String str = "";
	private int check = 0,cnt= 0;
	
	
	public void setSalaryMan(String name, String job, String level, String salary, int cnt)
	{		
		man[cnt][0] = name;
		man[cnt][1] = job;
		man[cnt][2] = level;
		man[cnt][3] = salary;	
	}

	public void searchName(String name)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;true;i++)
		{
			if(i >= man.length)
			{			
				//배열에 있는 값들을 다 확인 후 빠져나가는 브레이크문
				break;
			}
			else if(cnt == man.length)
			{
				//카운트 한 값이 배열의 길이랑 일치 할 경우 출력 후 반복문을 빠져나감
				System.out.println("해당되는 이름이 존재 하지 않습니다\n");
				break;
			}
			else if(man[i][0].equals(name) && i < man.length)
			{				
				//조건이 참이면 입력한 이름에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("부서: " + man[i][1]);
				System.out.println("직급: " + man[i][2]);
				System.out.println("연봉: " + man[i][3]);				
			}
			else if(!(man[i][0].equals(name) && i < man.length))
			{
				cnt++;
			}			
		}		
	}
	public void searchJob(String job)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;true;i++)
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
			else if(man[i][1].equals(job) && i < man.length)
			{
				//조건이 참이면 입력한 부서에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[i][0]);				
				System.out.println("직급: " + man[i][2]);
				System.out.println("연봉: " + man[i][3]);				
			}	
			else if(!(man[i][0].equals(job) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}	

	}
	public void searchLevel(String level)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i =0;true;i++)
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
			else if(man[i][2].equals(level) && i < man.length)
			{
				//조건이 참이면 입력한 직급에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[i][0]);
				System.out.println("부서: " + man[i][1]);		
				System.out.println("연봉: " + man[i][3]);			
			}
			else if(!(man[i][0].equals(level) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}	

	}
	public void searchSalary(String salary)
	{
		//입력한 값에 해당 되는 값을 전부 다 찾아서 출력하는 반복문
		for(int i=0;true;i++)
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
			else if(man[i][3].equals(salary) && i < man.length)
			{
				//조건이 참이면 입력한 연봉에 해당 되는 데이터를 출력
				System.out.println();
				System.out.println("이름: " + man[i][0]);
				System.out.println("부서: " + man[i][1]);
				System.out.println("직급: " + man[i][2]);					
			}	
			else if(!(man[i][0].equals(salary) && i < man.length))
			{
				//입력한 값이 배열에 저장된 값과 일치 하지 않는 경우 카운트
				cnt++;
			}	
		}	

	}

}
