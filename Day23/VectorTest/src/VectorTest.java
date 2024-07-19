import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector vec = new Vector();
		PhoneInfo info1 = new PhoneInfo("홍길동", "010");
		PhoneInfo info2 = new PhoneInfo("배트맨", "011");
		vec.add(info1);
		vec.add(info2);
		for(int i = 0;i<vec.size();i++) {
			PhoneInfo info = (PhoneInfo)vec.get(i);
			info.showPhoneInfo();
		}
		System.out.println("==================");
		for(Object obj : vec) {
			PhoneInfo info = (PhoneInfo)obj;
			info.showPhoneInfo();
		}
		System.out.println("==================");
		for(Object obj : vec) {
			System.out.println(obj);
		}
		
	}
}