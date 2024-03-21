package test;

class Box<T> {
	private T ob;     
	public void set(T o) { ob = o; }
	public T get() { return ob; }
}

public class TTTesst {
	public static void addBox(Box<? super Integer> b1, Box<? extends Integer> b2, Box<? extends Integer> b3) {
		b1.set(b3.get() + b2.get());
	}
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		box1.set(24);
		Box<Integer> box2 = new Box<>();
		box2.set(37);        
		Box<Integer> result = new Box<>();
		result.set(0);

		addBox(result, box1, box2);    // result에 24 + 37의 결과 저장     
		System.out.println(result.get());    // 61 출력 
	}

}
