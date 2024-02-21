class BuilderString
{
	public static void main(String[] args)
	{
		StringBuilder strBuf=new StringBuilder("AB");
		strBuf.append(25);
		strBuf.append('Y').append(true);
		System.out.println(strBuf);		
		
		strBuf.insert(2, false);
		strBuf.insert(strBuf.length(), 'Z');
		System.out.println(strBuf);
	}
}