package Test;

public class PhoneBook {
	private static PhoneBook pb;
	private PhoneInfo[] pInfoArr;
	private int cntOfPhone;
	PhoneBook(int sizePhoneInfo)
	{
		pInfoArr = new PhoneInfo[sizePhoneInfo];
		cntOfPhone = 0;
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
		if(cntOfPhone >= pInfoArr.length)
		{
			System.out.println("더 이상 저장할 수 없습니다.");
			return;
		}
		for(i=0;i<cntOfPhone;i++)
		{
			if(pInfoArr[i].getName().compareTo(pInfo.getName()) > 0)
			{
				for(j=cntOfPhone-1;j>=i;j--)
				{
					pInfoArr[j+1] = pInfoArr[j];
				}
				break;
			}
		}
		pInfoArr[i] = pInfo;
		cntOfPhone++;
	}
	public void searchPhoneInfo(String name)
	{
		int result = search(name);
		if(result != -1)
			pInfoArr[result].showPhoneInfo();
		else
			System.out.println("찾으시는 데이터가 없습니다.");
	}
	public void deletePhoneInfo(int idx)
	{
		int i=0;
		for(i=idx;i<cntOfPhone-1;i++)
			pInfoArr[i] = pInfoArr[i+1];
		pInfoArr[i] = null;
		cntOfPhone--;
		System.out.println("삭제가 완료되었습니다.");
	}


	public int search(String name)
	{
		for(int i=0;i<cntOfPhone;i++)
		{
			if(pInfoArr[i].getName().compareTo(name) == 0)
				return i;
		}
		return -1;		
	}

	public void showAllPhoneInfo()
	{
		for(int i=0;i<cntOfPhone;i++)
			pInfoArr[i].showPhoneInfo();
	}
}
