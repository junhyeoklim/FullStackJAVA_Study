package study;


class Box<T extends Number> {
    private T ob;
    
    public void set(T o) { 
        ob = o; 
    }
    
    public T get() { 
        return ob; 
    }
}


public class Question6 {

	// 이 위치에 swapBox 메소드 정의하자.
	public static <T extends Number> void swapBox(Box<T> box1,Box<T> box2)
	{		
		T temp = box1.get();
		box1.set(box2.get());
		box2.set(temp);		
	}
	
	
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);

        Box<Integer> box2 = new Box<>();
        box2.set(55);

        System.out.println(box1.get() + " & " + box2.get());
        swapBox(box1, box2);	// 정의해야 할 swapBox 메소드
        System.out.println(box1.get() + " & " + box2.get());
    }
}
