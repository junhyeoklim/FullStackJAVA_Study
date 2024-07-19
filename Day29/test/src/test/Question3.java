package test;

class Box2<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}


public class Question3 {

	 public static void addBox(Box2<? super Integer> b1, Box2<? extends Integer> b2, Box2<? extends Integer> b3) {
	        b1.set(b3.get() + b2.get());	// 프로그래머의 실수가 있는 부분
	    }
	 
	public static void main(String[] args) {
		  Box2<Integer> box1 = new Box2<>();
	        box1.set(24);
	        Box2<Integer> box2 = new Box2<>();
	        box2.set(37);        
	        Box2<Integer> result = new Box2<>();
	        result.set(0);

	        addBox(result, box1, box2);    // result에 24 + 37의 결과 저장     
	        System.out.println(result.get());    // 61 출력 
	}

}
