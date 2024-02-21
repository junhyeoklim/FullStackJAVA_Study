class StringAdd
{
	public static void main(String[] args)
	{
		String str1="Lemon"+"ade"; // 내부적으로 본다면 "Lemon".concat("ade")
		String str2="Lemon"+'A'; // 내부적으로 본다면 "Lemon".concat('A') -> char형을 String으로 변환해주는 값을 찾아 보면 "Lemon".concat(String.valueOf('A'))
		String str3="Lemon"+3; //내부적으로 본다면 "Lemon".concat(3) -> int형을 String으로 변환해주는 값을 찾아 보면 "Lemon".concat(String.valueOf(3))
		String str4=1+"Lemon"+2; // 나중에 분석(concat을 쓰면 객체가 5개가 생성되기 때문에 다른 방법을 씀)
		str4+='!';
		
		System.out.println(str1);		
		System.out.println(str2);		
		System.out.println(str3);		
		System.out.println(str4);
	}
}