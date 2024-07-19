package optional;

import java.util.Optional;
import java.util.OptionalInt;

//class ContInfo {
//	String phone;   // null 일 수 있음
//	String adrs;    // null 일 수 있음
//
//	public ContInfo(String ph, String ad) {
//		phone = ph;
//		adrs = ad;
//	}
//
//	public String getPhone() { return phone; }
//	public String getAdrs() { return adrs; }
//
//}
//class Friend {
//    String name;
//    Company cmp;    // null 일 수 있음
//
//    public Friend(String n, Company c) {
//        name = n;
//        cmp = c;
//    }
//
//    public String getName() { return name; }
//    public Company getCmp() { return cmp; }
//}
//
//class Company {
//    String cName;
//    ContInfo cInfo;    // null 일 수 있음
//
//    public Company(String cn, ContInfo ci) {
//        cName = cn;
//        cInfo = ci;
//    }
//
//    public String getCName() { return cName; }
//    public ContInfo getCInfo() { return cInfo; }
//
//}
//class ContInfo {
//    String phone;   // null 일 수 있음
//    String adrs;    // null 일 수 있음
//
//    public ContInfo(String ph, String ad) {
//        phone = ph;
//        adrs = ad;
//    }
//
//    public String getPhone() { return phone; }
//    public String getAdrs() { return adrs; }
//
//}
//class ContInfo {
//    Optional<String> phone;   // null 일 수 있음
//    Optional<String> adrs;    // null 일 수 있음
//
//    public ContInfo(Optional<String> ph, Optional<String> ad) {
//        phone = ph;
//        adrs = ad;
//    }
//    public Optional<String> getPhone() { return phone; }
//    public Optional<String> getAdrs() { return adrs; }
//}
class Friend {
    String name;
    Optional<Company> cmp;    // null 일 수 있음

    public Friend(String n, Optional<Company> c) {
        name = n;
        cmp = c;
    }

    public String getName() { return name; }
    public  Optional<Company> getCmp() { return cmp; }
}

class Company {
    String cName;
    Optional<ContInfo> cInfo;    // null 일 수 있음

    public Company(String cn, Optional<ContInfo> ci) {
        cName = cn;
        cInfo = ci;
    }

    public String getCName() { return cName; }
    public Optional<ContInfo> getCInfo() { return cInfo; }

}

class ContInfo {
	Optional<String> phone;   // null 일 수 있음
	Optional<String> adrs;    // null 일 수 있음

    public ContInfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }

    public  Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}
public class OptionalTest {
//    public static void showCompAddr(Optional<Friend> f) {
//        	
//    	String addr = f.map(Friend::getCmp)
//    			.map(Company::getCInfo)
//    			.map(ContInfo::getAdrs)
//    			.orElse("There's no address information.");
//            System.out.println(addr);
//    }
    public static void showCompAddr(Optional<Friend> f) {
        
    	
    	
    	String addr = f.flatMap(Friend::getCmp)
    			.flatMap(Company::getCInfo)
    			.flatMap(ContInfo::getAdrs)
    			.orElse("There's no address information.");
    
            System.out.println(addr);
    }
	public static void main(String[] args) {
		//		Optional<String> os1 = Optional.of(new String("Toy"));
		//		Optional<String> os2 = Optional.of(new String("Toy2"));

		//		13번 문제
		//		os1.ifPresent(s -> System.out.println(s));
		//		os2.ifPresent(s -> System.out.println(s));

		//		os1.ifPresent(System.out::println);
		//		os2.ifPresent(System.out::println);

		//		14번 문제
		//		Optional<String> os1 = Optional.of("Optional String");
		//		Optional<String> os2 = os1.map(s -> s.toUpperCase());
		//		
		//		System.out.println(os2.get());
		//		
		//		Optional<String> os3 = os1.map(s -> s.replace(" ","_")).map(s -> s.toLowerCase());
		//		
		//		System.out.println(os3.get());

		//		15번 문제
		//		Optional<String> os1 = Optional.empty();
		//		Optional<String> os2 = Optional.of("So Basic");
		//		
		//		String s1 = os1.map(s-> s.toString()).orElse("Empty");
		//		String s2 = os2.map(s-> s.toString()).orElse("Empty");
		//				
		//		
		//		System.out.println(s1);
		//		System.out.println(s2);

		//		16번 문제
//		Optional<ContInfo> ci = Optional.ofNullable(new ContInfo(null, "Republic of Korea")); 
//		String phone = ci.map(c -> c.getPhone()).orElse("There is no phone number.");
//		String addr = ci.map(c -> c.getAdrs()).orElse("There is no address.");
//
//		System.out.println(phone);
//		System.out.println(addr);
		
//		17번 문제
//		 ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
//	        Company cp = new Company("YaHo Co., Ltd.", ci);
//	        Friend frn = new Friend("LEE SU", cp);
//
//	        // 친구 정보에서 회사 주소를 출력
//	        showCompAddr(Optional.of(frn));
		
//		18번 문제
//		Optional<String> os1 = Optional.of("Good");
//		Optional<String> os2 = os1.map(s -> s.toLowerCase());
//		
//		System.out.println(os2.get());
//		
//		
//		Optional<String> os3 = os1.flatMap(s -> Optional.of(s.toLowerCase()));
//		 
//		System.out.println(os3.get());
		
//		19번 문제
//		  Optional<ContInfo> ci = Optional.of(
//		            new ContInfo(Optional.ofNullable(null), Optional.of("Republic of Korea"))
//		        );
//		        
//		        String phone = ci.flatMap(s -> s.getPhone()).orElse("There is no phone");
//
//		        String addr = ci.flatMap(s -> s.getAdrs()).orElse("There is no address");
//		          
//		        System.out.println(phone);
//		        System.out.println(addr);
		
//		20번 문제
//		Optional<ContInfo> ci = Optional.of(new ContInfo(Optional.ofNullable(null),Optional.of("Republic of Korea")));
//		
//	    Optional<Company> cp = Optional.of(new Company("YaHo Co., Ltd.", ci));
//	    Optional<Friend> frn = Optional.of(new Friend("LEE SU", cp));

	        // 친구 정보에서 회사 주소를 출력
//	        showCompAddr(frn);
		
//		21번 문제
//        OptionalInt oi1 = OptionalInt.of(3);
//        OptionalInt oi2 = OptionalInt.empty();
//        
//        System.out.print("[Step 1.] : ");
//        oi1.ifPresent(i -> System.out.print(i + "\t"));
//        oi2.ifPresent(i -> System.out.print(i));
//        System.out.println();
//
//        System.out.print("[Step 2.] : ");
//        System.out.print(oi1.orElse(100) + "\t");
//        System.out.print(oi2.orElse(100) + "\t");
//        System.out.println();
		
		
	}

}
