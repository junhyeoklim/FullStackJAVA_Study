package study;


class Box1<T> 
{
	private T ob;     
	public void set(T o) 
	{ 
		ob = o; 
	}
	public T get()
	{ 
		return ob; 
	}
}

class Question8 {
	public static void addBox(Box1<? super Integer> b1, Box1<? extends Integer> b2, Box1<? extends Integer> b3) {
		b1.set(b2.get() + b3.get());	// 프로그래머의 실수가 있는 부분
	}

	public static void main(String[] args) {
		Box1<Integer> box1 = new Box1<>();
		box1.set(24);
		Box1<Integer> box2 = new Box1<>();
		box2.set(37);        
		Box1<Integer> result = new Box1<>();
		result.set(0);

		addBox(result, box1, box2);    // result에 24 + 37의 결과 저장     
		System.out.println(result.get());    // 61 출력 
	}
}