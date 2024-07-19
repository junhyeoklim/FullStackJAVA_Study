package person;

public class Person implements Cloneable{
	private String name;
	private int age;
	
	public Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public void show()
	{
		System.out.println(name+" "+age);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

class PersonMain {

	public static void main(String[] args) {
		Person person = new Person("홍길동", 10);
		try {
			Person cpyPerson = (Person) person.clone();
			person.show();
			cpyPerson.show();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
