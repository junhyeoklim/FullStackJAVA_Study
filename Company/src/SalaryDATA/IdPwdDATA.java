package SalaryDATA;

public class IdPwdDATA {
	private String adminName = "admin";
	private String pwd = "1234";
	private boolean result;
	
	public String getAdminName() {
		return adminName;
	}

	public String getPwd() {
		return pwd;
	}
	
	public boolean login(String id, String password)
	{
		if(id.equals(adminName) && password.equals(pwd))
			result = true;
		else
			result = false;
		return result;
	}
}
