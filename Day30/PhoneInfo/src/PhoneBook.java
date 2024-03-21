import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneBook {

	private static PhoneBook pb;
	private Set<PhoneInfo> set;

	private PhoneBook() 
	{
		set = new HashSet<PhoneInfo>();
	}

	public static PhoneBook getPhoneBook()
	{
		if(pb==null)
			pb = new PhoneBook();
		return pb;
	}

	public boolean insertPhoneInfo(PhoneInfo phoneInfo)
	{		
		return set.add(phoneInfo);
	}

	public boolean searchPhoneInfoByName(String name)
	{
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();
		boolean result = false;

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getName().equals(name))
			{
				pInfo.printCurrentState();
				result = true;
			}
		}

		return result;
	}

	public boolean deletePhoneInfoByPhoneNumber(String phoneNumber)
	{
		PhoneInfo pInfo = null;
		Iterator<PhoneInfo> itr = set.iterator();

		while(itr.hasNext())
		{			
			pInfo = itr.next();
			if(pInfo.getPhoneNumber().equals(phoneNumber))
			{
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public void printAllPhoneInfo()
	{
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext())
		{
			itr.next().printCurrentState();
		}
//		for(PhoneInfo info: set)
//			info.printCurrentState();
	}
}