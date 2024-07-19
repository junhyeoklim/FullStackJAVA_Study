package project7;

public class PhoneCompanyDTO extends PhoneDTO{

	private String company;
	
	public PhoneCompanyDTO(String name, String phoneNumber,String company) {
		super(name, phoneNumber);
		this.company = company;
	}

	public void showPhonInfo()
	{
			super.showPhoneInfo();
			System.out.println("전공 : "+company);
	}
	
}
