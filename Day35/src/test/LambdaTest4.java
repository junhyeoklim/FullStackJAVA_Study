package test;

interface MyFunction4{
	int roll();
}

public class LambdaTest4 {

	public static void main(String[] args) {
		MyFunction4 f =() -> (int) (Math.random() * 6);
		int num = f.roll();	// 익명 객체의 메소드 호출
		System.out.println(num);
	}
}
