package test;

class Orange
{
	int sugarContent;

	public Orange(int sugarContent) {
		this.sugarContent = sugarContent;
	}

	public void showSugarContent()
	{
		System.out.println("당도 : "+sugarContent);
	}
}

class OrangeBox
{
	Orange oran;

	public void store(Orange obj)
	{
		oran = obj;
	}

	public Orange pullOut()
	{
		return oran;
	}
}

class Apple
{
	int weight;

	public Apple(int weight) {
		this.weight = weight;
	}

	public void showAppleWeight()
	{
		System.out.println("무게 : "+weight);
	}
}

class AppleBox
{
	Apple apple;

	public void store(Apple obj)
	{
		apple = obj;
	}

	public Apple pullOut()
	{
		return apple;
	}

}

//class Fruit
//{
//	Object obj;
//	
//	public void store(Object obj)
//	{
//		this.obj = obj;
//	}
//	
//	public Object pullOut()
//	{
//		return obj;
//	}
//}

//	4-5 문제
//class Fruit<T>
//{
//	T obj;
//	
//	public void store(T obj)
//	{
//		this.obj = obj;
//	}
//	
//	public T pullOut()
//	{
//		return obj;
//	}
//}

class Fruit<T>
{
	T obj;

	public Fruit(T obj) {
		this.obj = obj;
	}

	

	public T pullOut()
	{
		return obj;
	}
}

public class TestQuestion4 {

	public static void main(String[] args) {
		//		4-1번 문제
		//		OrangeBox oran = new OrangeBox();
		//		AppleBox apple = new AppleBox();

		//		4-2번 문제 
		//		Fruit oran = new Fruit();
		//		
		//		oran.store(new Orange(10));
		//		((Orange) oran.pullOut()).showSugarContent();
		//		
		//		Fruit apple = new Fruit();
		//		apple.store(new Apple(200));		
		//		((Apple)apple.pullOut()).showAppleWeight();

		//		4-3번 
		//		Fruit oran = new Fruit();
		//		
		//		oran.store("오렌지"); 
		//		((Orange) oran.pullOut()).showSugarContent();

		//		OrangeBox oran = new OrangeBox();
		//		oran.store("오렌지");

		//		4-6번 문제
		Fruit<Orange> oran = new Fruit<Orange>(new Orange(10));		
		oran.pullOut().showSugarContent();



	}

}
