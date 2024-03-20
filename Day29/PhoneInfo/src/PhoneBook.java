import java.util.ArrayList;

public class PhoneBook {
	private static PhoneBook pb;
	private ArrayList<PhoneInfo> pInfo;
	private PhoneBook(int sizePhoneInfo)
	{
		pInfo = new ArrayList<PhoneInfo>(sizePhoneInfo);
	}
	public static PhoneBook getPhoneBookInst(int sizePhoneInfo)
	{
		if(pb == null)
			pb = new PhoneBook(sizePhoneInfo);
		return pb;
	}
	public void inputPhoneInfo(PhoneInfo pInfo)
	{
		int i = 0, j=0;
		int pInfoSize = this.pInfo.size();
		for(i=0;i<pInfoSize;i++)
		{
			if(this.pInfo.get(i).getName().compareTo(pInfo.getName()) > 0)
			{
				break;
			}
		}
		this.pInfo.add(i,pInfo);
	}
	public void searchPhoneInfo(String name)
	{
		int result = search(name);
		if(result != -1)
			pInfo.get(result).showPhoneInfo();
		else
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(int idx)
	{
		pInfo.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}


	public int search(String name)
	{
		int pInfoSize = this.pInfo.size();
		for(int i=0;i<pInfoSize;i++)
		{
			if(pInfo.get(i).getName().compareTo(name) == 0)
				return i;
		}
		return -1;		
	}

	public void showAllPhoneInfo()
	{
		int pInfoSize = this.pInfo.size();
		for(int i=0;i<pInfoSize;i++)
			pInfo.get(i).showPhoneInfo();
	}
}
