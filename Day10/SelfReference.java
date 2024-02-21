class SimpleAdder
{
	private int num;
	public SimpleAdder(){num=0;}
	
	public SimpleAdder add(int num)
	{
		this.num+=num;
		return this; // 자기 자신의 주소값을 반환
	}
	public void showResult()
	{
		System.out.println("add result: "+num);
	}
}

class SelfReference
{
	public static void main(String[] args)
	{
		SimpleAdder adder=new SimpleAdder();
		adder.add(1).add(3).add(5).showResult(); //앞의 객체의 주소값이 오면 그 주소의 해당되는 객체 메소드에 접근 할 수 있다.
	}
}