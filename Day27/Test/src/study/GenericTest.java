package study;

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
	Orange item;
	
	public void store(Orange item) {
		this.item = item;
	}
	
	public Orange pullOut()
	{
		return item;
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
		System.out.println("무게 ; "+weight);
	}
}

class AppleBox
{
	Apple weight;
	
	public void store(Apple weight)
	{
		this.weight = weight;
	}
	
	public Apple pullOut()
	{
		return weight;
	}
}

class FruitBox<T>
{
	T obj;
	
	public FruitBox(T obj) {
		this.obj = obj;
	}

	public void store(T obj)
	{
		this.obj = obj;
	}
	
	public T pullOut()
	{
		return obj;
	}
}



public class GenericTest {

	public static void main(String[] args) {

//		//문제 2번
//		FruitBox fruit = new FruitBox();
//		
//		fruit.store(new Orange(10));
//		
//		Orange oran = (Orange) fruit.pullOut();
//		oran.showSugarContent();
//		
//		fruit.store(new Apple(200));
//		
//		Apple aple = (Apple) fruit.pullOut();
//		aple.showAppleWeight();
		
		//문제 3번
//		FruitBox fruit = new FruitBox();
//		
//		fruit.store("오렌지");
//		Orange oran = (Orange) fruit.pullOut();
//		oran.showSugarContent();
//		
//		OrangeBox obx = new OrangeBox();
//		
//		obx.store("오렌지");
		
		//문제 5번~7번
		FruitBox<Orange> orBox=new FruitBox<Orange>(new Orange(10));
		Orange org=orBox.pullOut();
		org.showSugarContent();
		
		FruitBox<Apple> apBox=new FruitBox<Apple>(new Apple(20));
		Apple app=apBox.pullOut();
		app.showAppleWeight();
	}

}
