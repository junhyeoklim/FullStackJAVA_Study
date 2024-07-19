package test;

class Test2
{
	public static void main(String[] args)
	{
		Box5<String> box = new Box5<>();
		
		box.setItem("First String");
		box.nextBox = new Box5<String>();
		box.nextBox.setItem("Second String");
		box.nextBox.nextBox = new Box5<String>();
		box.nextBox.nextBox.setItem("Third String");
		
		Box5<String> printBox;
		
		printBox = box;
		System.out.println(printBox.getItem());
		printBox = box.nextBox;
		System.out.println(printBox.getItem());
		printBox = printBox.nextBox;
		System.out.println(printBox.getItem());
		
		
	}
}

class Box5<T> {
	
	private T item;
	public Box5<T> nextBox;
	
	public T getItem()
	{
		return item;
	}
	
	public void setItem(T obj)
	{
		item = obj;
	}

}

