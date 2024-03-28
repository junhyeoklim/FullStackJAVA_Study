package test;

interface MyFunction2{
	void printVar(String name, int i);
}

public class LambdaTest2 {

	public static void main(String[] args) {
		MyFunction2 f = (name,i) -> System.out.println(name + "=" + i);
		f.printVar("Hong", 100);	// 익명 객체의 메소드 호출
	}
}