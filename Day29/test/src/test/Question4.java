package test;

class Box3<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

public class Question4 {


	// box에 con과 동일한 내용물이 들었는지 확인
    public static <T> boolean compBox(Box3<? extends T> box, T con) {
        T bc = box.get();
//        box.set(con);		// 프로그래머의 실수로 삽입된 문장, 때문에 내용물이 바뀐다.
        return bc.equals(con);
    }
	
	public static void main(String[] args) {
		 Box3<Integer> box1 = new Box3<>();
	        box1.set(24);

	        Box3<String> box2 = new Box3<>();
	        box2.set("Poly");

	        if(compBox(box1, 25))
	            System.out.println("상자 안에 25 저장");

	        if(compBox(box2, "Moly"))
	            System.out.println("상자 안에 Moly 저장");
	        
	        System.out.println(box1.get());
	        System.out.println(box2.get());
	}

}
