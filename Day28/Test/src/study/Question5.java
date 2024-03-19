package study;

class DBox<L, R>{
	private L left;
	private R right;
	public void set(L o, R r) {
		left = o;
		right = r;
	}
	public String toString() { return left + " & " + right; }
}

class DDBox<U,D>
{
	private U left;
	private D right;
	
	public void set(U l,D r)
	{
		left = l;
		right = r;
	}
	@Override
	public String toString() {
		return left+"\n"+right;
	}
}

public class Question5 {

	public static void main(String[] args) {

		DBox<String, Integer> box1 = new DBox<>();
		box1.set("Apple", 25);
		DBox<String, Integer> box2 = new DBox<>();
		box2.set("Orange", 33);
		DBox<DBox<String, Integer>, DBox<String, Integer>> box3 = new DBox<>();
		box3.set(box1,box2);
			// 두 개의 상자를 하나의 상자에 담음
		System.out.println(box3);	// 상자의 내용물 출력
		
	}

}
