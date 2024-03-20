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

		if(ite.hasNext() && ite.next().getName().equals(dto.getName()))
		{
			System.out.println("이미 저장된 데이터 입니다.");
		}		
		else if(ite.hasNext())
		{
			ite.next();
			phonDTO.add(dto);
		}
		else
			phonDTO.add(dto);		
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

	@Override
	public int hashCode() {
		ite = phonDTO.iterator();
		return Objects.hash(ite.next().getPhoneNumber());
	}
	@Override
	public boolean equals(Object obj) {
		Iterator<PhoneDTO> comp = (Iterator<PhoneDTO>) obj;
		ite = phonDTO.iterator();
		if(comp.next().getPhoneNumber().compareTo(ite.next().getPhoneNumber()) == 0)			
			return true;
		else
			return false;
	}
}
