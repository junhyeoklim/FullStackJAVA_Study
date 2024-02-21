class BuilderString
{
	public static void main(String[] args)
	{
		StringBuilder strBuf=new StringBuilder("AB"); //문자열 객체 변경이 가능하긴 하나 이것을 문자열 객체 변경이라고 보기는 어렵다
		strBuf.append(25);
		strBuf.append('Y').append(true);
		System.out.println(strBuf);		
		
		strBuf.insert(2, false);
		strBuf.insert(strBuf.length(), 'Z');
		System.out.println(strBuf);
	}
}