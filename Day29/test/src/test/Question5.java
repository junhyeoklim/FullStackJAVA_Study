package test;

//class ArrayTest<T>
//{
//	private T arr;
//	
//	public void arrSet(T arr)
//	{
//		this.arr = arr;
//	}
//	
//	public T arrGet()
//	{
//		return arr;
//	}
//}
class Fruit
{
	public void printMe()
	{
		System.out.println("나는 과일");
	}
}

class Apple<N> extends Fruit
{
	private N sugar;
	
	@Override
	public void printMe() {
		super.printMe();
		System.out.println("사과");
	}
	
	public void sugarSet(N sugar)
	{
		this.sugar = sugar;
	}
	public N sugarGet()
	{
		return sugar;
	}
	@Override
	public String toString() {
		return "당도 : " + sugar;
	}
}

class Orange<N> extends Fruit
{
	private N price;
	
	@Override
	public void printMe() {
		super.printMe();
		System.out.println("오렌지");
	}
	
	public void priceSet(N price)
	{
		this.price = price;
	}
	public N priceGet()
	{
		return price;
	}
	
	@Override
	public String toString() {
		return "가격 : "+price;
	}
}

class FruitBox<T>
{
	private T item;
	
	public void store(T item)
	{
		this.item = item;
	}
	public T pullOut()
	{
		return item;
	}
}

public class Question5 {

//	public static <T> void test(T[] arr) {
//			for(int i=0;i<arr.length;i++)
//			{
//				System.out.println(arr[i]);
//			}
//	}
	
	public static void fruitTest(FruitBox<? extends Fruit> fru)
	{
		Fruit fi = fru.pullOut();
		fi.printMe();
	}
	
	public static void main(String[] args) {
//		문제 1번
//		ArrayTest<String> arr = new ArrayTest<>();
//		arr.arrSet("55");
//		
//		String[] num = new String[3];
//		
//		for(int i=0; i<num.length;i++)
//		{
//			num[i] = arr.arrGet()+i;
//			
//		}
//		test(num);
//		
//		문제 2번
//		답 :  Apple 클래스에 있는 값들을 매개변수로 전달될 수 있다.
		
//		문제 3번
//		답 : Fruit 클래스 안에 있는 메소드 
		
//		문제 4번
//		답 : <T extends Fruit>
		
//		문제 5번
//		답 : 
		FruitBox<Fruit> box1=new FruitBox<Fruit>();
		box1.store(new Fruit());
		
		FruitBox<Apple> box2=new FruitBox<Apple>();
		box2.store(new Apple());
		
		fruitTest(box1);
		fruitTest(box2);
	}
}
