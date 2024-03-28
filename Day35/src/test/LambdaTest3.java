package test;

interface MyFunction3{
	int square(int x);
}

public class LambdaTest3 {

	public static void main(String[] args) {
		MyFunction3 f = x -> x * x;
		int num = f.square(5);	// 익명 객체의 메소드 호출
		System.out.println(num);
	}
}
