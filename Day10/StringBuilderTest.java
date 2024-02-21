class StringBuilderTest
{
	public static void main(String[] args)
	{
		/*//1. String str1 = "ABCDEFGHIJKLMN"; 역순으로 출력

		String str1 = "ABCDEFGHIJKLMN";
		StringBuilder stb = new StringBuilder(str1);

		
		System.out.println(stb.reverse().toString());*/

		//2. String str2 = "990208-1012752"이 문자열을 활용하여 중간에 삽입된 -를 삭제한 String 인스턴스를 생성.

		String str2 = "990208-1012752";
		int idx = 0;


		StringBuilder stb = new StringBuilder(str2);
		idx = stb.indexOf("-");

		if(idx != -1)
		{
			str2 = stb.deleteCharAt(idx).toString();
			System.out.println(str2);
		}

	}
}