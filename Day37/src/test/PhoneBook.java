package test;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

public class PhoneBook  {

	private static PhoneBook pb;
	private TreeSet<PhoneInfo> set;

	private PhoneBook() 
	{
		load();
	}
	
	public void load()
	{
		set = new TreeSet<PhoneInfo>();

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("phoneInfo.data"));) {
			
			if(in != null)
			{
				PhoneInfo phi = (PhoneInfo) in.readObject();
				
				while(phi != null)
				{
					insertPhoneInfo(phi);
					try {
						phi = (PhoneInfo) in.readObject();
					} catch (EOFException e) {
						break;
					}
				}
			}
				
		
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save()
	{
		
		if(set.size() == 0 )
			return;			
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phoneInfo.data"));) {
			Iterator<PhoneInfo> itr = set.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			System.out.println();
		}
//		for(PhoneInfo info: set)
//			info.printCurrentState();
	}
}
