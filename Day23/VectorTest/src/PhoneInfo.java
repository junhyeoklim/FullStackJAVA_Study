
public class PhoneInfo {
	private String name;
	private String phone;
	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
	}
	
	@Override
	public String toString() {
		return name + " " + phone;
	}
	
	
}
