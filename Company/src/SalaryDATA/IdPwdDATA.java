package SalaryDATA;

public class IdPwdDATA {
	private String adminName = "admin";
	private String pwd = "1234";
	private String user = "user";
	private String userpwd = "1111";
	private boolean result;
	
	public String getAdminName() {
		return adminName;
	}

	public String getPwd() {
		return pwd;
	}
	
	public String getUser() {
		return user;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public boolean adminLogin(String id, String password)
	{
		if(id.equals(adminName) && password.equals(pwd))
			result = true;
		else
			result = false;
		return result;
	}
	public boolean userLogin(String id, String password)
	{
		if(id.equals(user) && password.equals(userpwd))
			result = true;
		else
			result = false;
		return result;
	}
}
