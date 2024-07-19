package test;

import java.util.Optional;
import java.util.OptionalInt;

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
//
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
    Company cmp;    // null 일 수 있음

    public Friend(String n, Company c) {
        name = n;
        cmp = c;
    }

    public String getName() { return name; }
    public Company getCmp() { return cmp; }
}

class Company {
    String cName;
    ContInfo cInfo;    // null 일 수 있음

    public Company(String cn, ContInfo ci) {
        cName = cn;
        cInfo = ci;
    }

    public String getCName() { return cName; }
    public ContInfo getCInfo() { return cInfo; }

}

class ContInfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}


public class TestQuestion {
//	  public static void showCompAddr(Optional<Friend> f) {
//	        String addr = f.map(Friend::getCmp)
//	        			   .map(Company::getCInfo)
//	        			   .map(ContInfo::getAdrs)
//	        			   .orElse("There's no address information.");
//	    
//	            System.out.println(addr);
//	    }
	
	public static void showCompAddr(Optional<Friend> f) {
//        String addr = f.map(Friend::getCmp)
//        				.map(Company::getCInfo)
//        				.map(ContInfo::getAdrs)
//        				.orElse("There's no address information.");
        String addr = f.map(s -> s.getCmp())
        		.map(s -> s.getCInfo())
        		.map(s -> s.getAdrs())
        		.orElse("There's no address information.");
                
            System.out.println(addr);
    }
	
	public static void main(String[] args) {
////		13번 문제 
//		
//		Optional<String> op1 = Optional.of(new String("Toy1"));
//		Optional<String> op2 = Optional.of(new String("Toy2"));
//		
//		op1.ifPresent(s -> System.out.println(s));
//		op2.ifPresent(s -> System.out.println(s));
//		
////		14번 문제
//		op1.ifPresent(System.out::println);
//		op2.ifPresent(System.out::println);
		
//		15번 문제
//		Optional<String> op1 = Optional.empty();
//		Optional<String> op2 = Optional.of("So Basic");
//		
//		String s1 = op1.map(s -> s.toString()).orElse("Empty");
//		String s2 = op2.map(s -> s.toString()).orElse("Empty");
//		
//		System.out.println(s1);
//		System.out.println(s2);
		
//		16번 문제	    
//		Optional<ContInfo> op = Optional.ofNullable(new ContInfo(null, "Republic of Korea"));
//		
//		
////	    String phone = op.map(p -> p.getPhone()).orElse("There is no phone number.");
////	    String addr = op.map(a -> a.getAdrs()).orElse("There is no address.");
//
//	    String phone = op.map(ContInfo::getPhone).orElse("There is no phone number.");
//	    String addr = op.map(ContInfo::getAdrs).orElse("There is no address.");
//        System.out.println(phone);
//        System.out.println(addr);

//		17번 문제
//		  ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
//	        Company cp = new Company("YaHo Co., Ltd.", ci);
//	        Friend frn = new Friend("LEE SU", cp);
//
//	        // 친구 정보에서 회사 주소를 출력
//	        showCompAddr(Optional.of(frn));
		
//		18번 문제
//		Optional<String> op = Optional.of("Optional String");
//		
//		op.map(s -> s.toLowerCase())
//		  .ifPresent(s -> System.out.println(s));
//		
//		op.flatMap(s -> Optional.of(s.toLowerCase()))
//		.ifPresent(s -> System.out.println(s));   
		
//		19번 문제
//        Optional<ContInfo> ci = Optional.of(
//                new ContInfo(Optional.ofNullable(null), Optional.of("Republic of Korea"))
//            );
//            
//            String phone = ci.flatMap(s -> s.getPhone()).orElse("There is no phone");
//
//            String addr = ci.flatMap(a -> a.getAdrs()).orElse("There is no address");
//              
//            System.out.println(phone);
//            System.out.println(addr);
		
//		20번 문제
//		ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
//        Company cp = new Company("YaHo Co., Ltd.", ci);
//        Friend frn = new Friend("LEE SU", cp);
//
//        // 친구 정보에서 회사 주소를 출력
//        showCompAddr(Optional.of(frn));
		
//		21번 문제
//		OptionalInt oi1 = OptionalInt.of(3);
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
