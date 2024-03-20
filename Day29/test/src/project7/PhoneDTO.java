package project7;

public class PhoneDTO {

	private String name;
	private String phoneNumber;
	private String major;
	private int year;
	private String company;


	public PhoneDTO(String name, String phoneNumber)
	{
		//일반 정보 저장
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMajor() {
		return major;
	}
	public int getYear() {
		return year;
	}
	public String getCompany() {
		return company;
	}	

	public void showPhoneInfo()
	{
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
	}
}
