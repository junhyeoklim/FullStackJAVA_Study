public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	
	public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
		super(name, phoneNumber);
		this.major = major;
		this.year = year;
	}

	@Override
	public void printCurrentState() {
		super.printCurrentState();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
}