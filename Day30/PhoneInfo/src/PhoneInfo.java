
public class PhoneInfo {
	private String name;
	private String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void printCurrentState()
	{
		System.out.println("이름 : "  + name);
		System.out.println("전화번호 : "  + phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		return phoneNumber.equals(((PhoneInfo)obj).phoneNumber);
	}

	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}
}