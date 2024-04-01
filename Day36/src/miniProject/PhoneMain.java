//package miniProject;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Scanner;
//import java.util.Set;
//
//
//class PhoneUI
//{
//	private static PhoneBook phone;
//	private static String name;
//	private static String phoneNumber;
//	private static String major;
//	private static int year;
//	private static String company;
//	private static Scanner sc = new Scanner(System.in);
//
//	public PhoneUI() {
//		phone =   PhoneBook.getPhoneBook();
//	}	
//
//	public static void phoneMainUI()
//	{
//		System.out.println("선택하세요...");
//		System.out.println("1. 데이터 입력");
//		System.out.println("2. 데이터 검색");
//		System.out.println("3. 데이터 삭제");
//		System.out.println("4. 모든 데이터 보기");
//		System.out.println("5. 프로그램 종료");
//		System.out.print("선택 : ");
//	}
//
//	public static void phoneInputUI()
//	{
//		int choice = 0;
//		
//		System.out.println("데이터 입력을 시작합니다.");
//		System.out.println("1. 일반 2. 대학 3. 회사");
//		System.out.print("선택 >> ");
//		PhoneInfo pinfo = null;
//		choice = sc.nextInt();
//		sc.nextLine();
//		try {
//			switch(choice)
//			{
//			case PhoneConstant.NOMAL:
//			{
//				System.out.print("이름 : ");
//				name = sc.nextLine();
//				System.out.print("전화번호 : ");
//				phoneNumber = sc.nextLine();
//				pinfo = new PhoneInfo(name, phoneNumber); 
//				break;
//			}
//			case PhoneConstant.UNIV:
//			{
//				System.out.print("이름 : ");
//				name = sc.nextLine();
//				System.out.print("전화번호 : ");
//				phoneNumber = sc.nextLine();
//				System.out.print("전공 : ");
//				major = sc.nextLine();
//				System.out.print("학년 : ");
//				year = sc.nextInt();
//				sc.nextLine();
//				pinfo = new PhoneUnivInfo(name, phoneNumber,major,year);
//				break;
//			}
//			case PhoneConstant.COMPANY:
//			{
//				System.out.print("이름 : ");
//				name = sc.nextLine();
//				System.out.print("전화번호 : ");
//				phoneNumber = sc.nextLine();
//				System.out.print("회사 : ");
//				company = sc.nextLine();
//				sc.nextLine();
//				pinfo = new PhoneCompanyInfo(name, phoneNumber,company);
//				break;
//			}
//			default :
//			{
//				System.out.println("데이터를 확인 해주세요");
//				break;
//			}
//			}
//			phone.setPhoneInfo(pinfo);
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("데이터 형식에 맞는 값을 입력 하세요!");
//			sc.nextLine();
//		}
//	}
//
//	public static void phoneSearchUI()
//	{
//		System.out.println("데이터 검색을 시작합니다.");
//		System.out.println("이름을 입력 하세요.");
//		System.out.print("이름 : ");
//		name = sc.nextLine();
//		phone.searchName(name);
//
//	}
//	public static void phoneDeleteUI()
//	{
//		int result = 0;
//		int answer = 0;
//
//		System.out.println("데이터 삭제를 시작합니다.");
//		System.out.println("이름을 입력 하세요.");
//		System.out.print("이름 : ");
//		name = sc.nextLine();		
//		result = phone.search(name);
//
//		if(result != -1)
//		{
//			System.out.println("정말로 삭제 하시겠습니까? 1. Yes 2. No");
//			answer = sc.nextInt();
//			sc.nextLine();			
//			switch (answer) {
//			case PhoneConstant.YES: {
//				phone.deleteInfo(result);
//				break;
//			}
//			case PhoneConstant.NO:
//			{
//				System.out.println("데이터 삭제를 취소하였습니다.");
//				break;
//			}
//			default:
//			{
//				System.out.println("데이터를 입력 해주세요");
//				break;
//			}
//			}
//		}
//		else
//			System.out.println("입력하신 정보가 존재하지 않습니다.");
//	}
//
//	public static void phoneShowUI()
//	{
//		phone.showInfo();
//	}
//
//	public static void phoneInfoSaveUI()
//	{
//		phone.save();
//		sc.close();
//	}
//}
//
//
//
//class PhoneInfo implements Serializable
//{
//	private String name;
//	private String phoneNumber;
//
//	public PhoneInfo(String name,String phoneNumber) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//	}
//
//	public void showInfo()
//	{
//		System.out.println("이름 : "+name);
//		System.out.println("전화 번호 : "+phoneNumber);
//	}
//
//	public String getName()
//	{
//		return name;
//	}
//	public String getPhoneNumber()
//	{
//		return phoneNumber;
//	}
//}
//
//class PhoneUnivInfo extends PhoneInfo implements Serializable
//{
//	private String major;
//	private int year;
//
//	public PhoneUnivInfo(String name, String phoneNumber,String major,int year) {
//		super(name, phoneNumber);
//		this.major = major;
//		this.year = year;
//	}
//
//	public void showInfo()
//	{
//		super.showInfo();
//		System.out.println("전공 : "+major);
//		System.out.println("학년 : "+year);
//	}
//
//
//}
//class PhoneCompanyInfo extends PhoneInfo implements Serializable
//{
//
//	private String company;
//
//	public PhoneCompanyInfo(String name, String phoneNumber,String company) {
//		super(name, phoneNumber);
//		this.company = company;
//	}
//	public void showInfo()
//	{
//		super.showInfo();
//		System.out.println("회사 : "+company);
//	}
//}
//
//class PhoneBook
//{
//	private Set<PhoneInfo> phon;
//	private Iterator<PhoneInfo> iter;
//	private File path = new File("C:\\Users\\TJ\\Documents\\save");
//	private File save = new File(path,"phonInfo.data");
//	private static PhoneBook phifo;
//	private int length;
//
//
//	private PhoneBook() {
//		load();
//	}
//
//	public void load()
//	{		
//		if(save.exists() == false)
//		{
//			System.out.println("파일이 존재하지 않습니다.");
//			return;
//		}
//		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(save));) {
//
//			if(input != null)
//				phon = (HashSet<PhoneInfo>) input.readObject();
//		} catch (FileNotFoundException e) {
//			phon = new HashSet<>();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void save()
//	{
//		if(phon.size() == 0)
//			return;
//
//
//		if(path.exists() == false)
//		{
//			System.out.println("파일 저장 경로를 생성 하였습니다.");
//			path.mkdirs();
//		}
//
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(save));) {
//			out.writeObject(phon);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public static PhoneBook getPhoneBook()
//	{
//		if(phifo == null)
//			phifo = new PhoneBook();
//		return phifo;
//	}
//
//	public void setPhoneInfo(PhoneInfo phi)
//	{
//		iter = phon.iterator();
//		PhoneInfo pInfo = null;
//		phon.add(phi);
//		if(!iter.hasNext())
//			phon.add(phi);
//		else {
//		while(iter.hasNext())
//		{
//			pInfo = iter.next();
//			if(pInfo.getPhoneNumber().equals(phi.getPhoneNumber()))
//			{
//				System.out.println("이미 저장된 전화 번호 입니다.");
//				return;
//			}
//		}		
//		}
//		System.out.println("데이터 입력이 완료되었습니다.");
//	}	
//
//
//	public void searchName(String name)
//	{		
//		iter = phon.iterator();
//		PhoneInfo pInfo = null;
//		while(iter.hasNext())
//		{
//			pInfo = iter.next();
//			if(pInfo.getName().equals(name))
//			{
//				pInfo.showInfo();
//				return;
//			}
//		}
//		System.out.println("찾으시는 데이터가 존재 하지 않습니다.");
//	}
//
//	public int search(String name)
//	{
//		length = phon.size();
//		int i=0;
//		for(iter = phon.iterator(); iter.hasNext();)
//		{
//			if(iter.next().getName().equals(name))
//				return i;
//			i++;
//		}
//		return -1;
//	}
//
//	public void deleteInfo(int idx)
//	{		
//		phon.remove(idx);
//		System.out.println("삭제가 완료되었습니다.");
//	}
//
//	public void showInfo()
//	{
//		iter = phon.iterator();
//
//		if(!iter.hasNext())
//			System.out.println("입력된 데이터가 존재 하지 않습니다.");
//		else
//		{
//			while(iter.hasNext())
//			{
//				iter.next().showInfo();
//				System.out.println();
//			}
//		}
//	}
//}
//
//
//
//public class PhoneMain {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		new PhoneUI();
//		
//		int choice = 0;
//		while(true)
//		{
//			PhoneUI.phoneMainUI();
//			choice = sc.nextInt();
//			sc.nextLine();
//
//			switch (choice) {
//			case PhoneConstant.DATA_INPUT: {
//				PhoneUI.phoneInputUI();
//				break;
//			}
//			case PhoneConstant.DATA_SEARCH: {
//				PhoneUI.phoneSearchUI();
//				break;
//			}
//			case PhoneConstant.DATA_DELETE: {
//				PhoneUI.phoneDeleteUI();
//				break;
//			}
//			case PhoneConstant.DATA_SHOW: {
//				PhoneUI.phoneShowUI();
//				break;
//			}
//			case PhoneConstant.END: {
//				PhoneUI.phoneInfoSaveUI();
//				System.out.println("프로그램을 종료 합니다.");
//
//				return;				
//			}
//			default:
//				System.out.println("잘못 입력 하셨습니다.");
//				break;
//			}
//		}
//
//
//	}
//
//}
