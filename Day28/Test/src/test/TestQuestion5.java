package test;

interface SimpleInterface
{
	public void showYourName();
}

class UpperClass
{
	public void showYourAncestor()
	{
		System.out.println("UpperClass");
	}
}

class AAA extends UpperClass 
{
	public void showYourName()
	{
		System.out.println("Class AAA");
	}
}

class BBB  extends UpperClass implements SimpleInterface
{
	public void showYourName() 
	{
		System.out.println("Class BBB");
	}
}

class TestQuestion5
{	
	public static <T extends UpperClass> void showInstanceAncestor(T param)
	{
		param.showYourAncestor();		
	}

	public static <T extends SimpleInterface> void showInstanceName(T param)
	{
		param.showYourName();
	}
	public static void main(String[] args) {

		//		5-1~5-4번 문제
		//		AAA dd = new AAA();
		//		
		//		dd.aaa(10);
		//		dd.<BBB>aaa(new BBB());
		//		dd.aaa(new BBB());

		//		class MyClass
		//		{
		//			public <T> void simpleMethod(T param)
		//			{
		//				param.showData();
		//				System.out.println(param);
		//			}
		//		}
		//		
		//		오류 원인은 모든 클래스가 showData()메소드를 가지고 있는지 아닌지를 모르기 때문에 오류가 난다.

		//		5-5번 문제

		//			AAA aaa=new AAA();
		//			BBB bbb=new BBB();
		//
		//			showInstanceAncestor(aaa);
		//			showInstanceName(aaa);
		//			showInstanceAncestor(bbb);
		//			showInstanceName(bbb);

		//			5-7번 문제
		//			답 : 제네릭 부분에 extends로 제한을 준다
		AAA aaa=new AAA();
		BBB bbb=new BBB();

		showInstanceAncestor(aaa);
		showInstanceName(bbb);

	}
}
