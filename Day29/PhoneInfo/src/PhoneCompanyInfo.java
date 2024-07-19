
public class PhoneCompanyInfo extends PhoneInfo {
	private String company;

	PhoneCompanyInfo(String name ,String phone, String company)
	{
		super(name, phone);
		this.company = company;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("회사 : " + company);
	}
}
