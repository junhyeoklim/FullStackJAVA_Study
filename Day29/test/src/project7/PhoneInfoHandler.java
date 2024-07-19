package project7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class PhoneInfoHandler {

	private HashSet<PhoneDTO> phonDTO;
	private static PhoneInfoHandler pifc;
	private Iterator<PhoneDTO> ite;
	public PhoneInfoHandler() {
		phonDTO = new HashSet<>();
	}

	public static PhoneInfoHandler getPhoneInfo()
	{
		if(pifc == null)
			pifc = new PhoneInfoHandler();
		return pifc;
	}



	public void phoneInput(PhoneDTO dto)
	{		
		Iterator<PhoneDTO> ite = phonDTO.iterator();
		if(ite.hasNext() && dto.equals(ite.next()))
		{
			System.out.println("테스트");
		}		
		else 
		{
			phonDTO.add(dto);
			System.out.println("데이터 입력이 완료되었습니다!");
		}
	}

	public void searchPhoneInfo(String name)
	{
		boolean result = search(name);
		ite = phonDTO.iterator();

		if(result)
		{
			ite.next().showPhoneInfo();
		}
		else
			System.out.println("입력한 데이터 정보가 존재하지 않습니다.");
	}

	public boolean search(String name)
	{
		ite = phonDTO.iterator();

		while(ite.hasNext())
		{
			if(ite.next().getName().equals(name))
				return true;
			else
				ite.next();
		}
		return false;
	}

	public void deletePhoneInfo(String name)
	{
		ite = phonDTO.iterator();

		while(ite.hasNext())
		{
			if(ite.next().getName().equals(name))
				ite.remove();
			else
				ite.next();
		}
	}

	public void printAllPhoneInfo()
	{
		ite = phonDTO.iterator();
		while(ite.hasNext())
			ite.next().showPhoneInfo();
	}

}
