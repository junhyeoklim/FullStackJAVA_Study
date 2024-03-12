
class PersonMain {

		public static void main(String[] args) {
			Person person = new Person("ȫ�浿", 10);
			try {
				Person cpyPerson = (Person) person.clone();
				person.show();
				cpyPerson.show();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	