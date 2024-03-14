package test;

class Business
{
	private String company;
	private String work;

	public Business(String company, String work)
	{
		this.company = company;
		this.work = work;
	}
	public void showBusinessInfo()
	{
		System.out.println("회사 : " + company);
		System.out.println("업무 : " + work);
	}
	public void changeWork(String work)
	{
		this.work=work;
	}
	public Business clone() throws CloneNotSupportedException
	{
		Business copy = (Business)super.clone();
		return copy;
	}
}

class PersonalInfo implements Cloneable
{
	private String name;
	private int age;
	private Business bness;

	public PersonalInfo(String name, int age, String company, String work)
	{
		this.name = name;
		this.age = age;
		bness = new Business(company, work);
	}
	public void showPersonalInfo()
	{
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		bness.showBusinessInfo();
		System.out.println("");
	}
	public void changeWork(String work)
	{
		bness.changeWork(work);
	}
	public PersonalInfo clone() throws CloneNotSupportedException
	{
		PersonalInfo copy = (PersonalInfo)super.clone();
		//copy.bness = (Business)bness.clone();
		copy.bness = bness.clone();
		return copy;
	}
}

class DeepCopyImpl
{
	public static void main(String[] args)
	{

		try {
			
		
			PersonalInfo pInfo = new PersonalInfo("James", 22, "HiMedia", "encoding");
			PersonalInfo pCopy = (PersonalInfo)pInfo.clone();
			pCopy.changeWork("decoding");

			pInfo.showPersonalInfo();
			pCopy.showPersonalInfo();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
	}
}
