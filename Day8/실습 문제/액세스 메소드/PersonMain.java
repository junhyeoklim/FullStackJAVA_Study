class Person
{
	private String name;
	private int age;

	public void setName(String name)
	{
		 this.name = name;
	}

	public void setAge(int age)
	{
		 this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
}

public class PersonMain
{
	public static void main(String[] args)
	{
		Person person = new Person();

		person.setName("후후");
		person.setAge(10);

		System.out.println("이름 : "+person.getName()+" 나이 : "+person.getAge());
	}
}