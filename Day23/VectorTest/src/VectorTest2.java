import java.util.Vector;

public class VectorTest2 {

	public static void main(String[] args) {
		Vector<PhoneInfo> vec = new Vector<PhoneInfo>();
		PhoneInfo info1 = new PhoneInfo("홍길동", "010");
		PhoneInfo info2 = new PhoneInfo("배트맨", "011");
		vec.add(info1);
		vec.add(info2);
		for(int i = 0;i<vec.size();i++) {
			PhoneInfo info = vec.get(i);
			info.showPhoneInfo();
		}
		System.out.println("==================");
		for(PhoneInfo info : vec) {
			info.showPhoneInfo();
		}
		System.out.println("==================");
		for(PhoneInfo info : vec) {
			System.out.println(info);
		}
	}

}
