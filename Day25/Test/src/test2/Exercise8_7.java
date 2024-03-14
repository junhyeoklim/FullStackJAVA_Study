package test2;

public class Exercise8_7 {
	private static int i;
	
	static void method(boolean b) {
		
		try {
			System.out.println(1);
			System.out.println("실행 횟수 : "+ i);
			i++;
			if(b) System.exit(0);
			System.out.println(2);
		} catch(RuntimeException r) {
			System.out.println(3);
			return;
		} catch(Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
	}
	public static void main(String[] args) {
		method(true);
		method(false);
	} // main
}
