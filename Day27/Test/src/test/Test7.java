package test;

public class Test7 {

	public static String delChar(String src, String delete)
	{
		StringBuffer stb = new StringBuffer(src.length());
		
		for(int i=0; i < src.length();i++)
		{
			char ch = src.charAt(i);
			
			if(delete.indexOf(ch) == -1)
				stb.append(ch);
		}
		
		
		return stb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "
				+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "
				+ delChar("(1 2 3 4\t5)"," \t"));
	}
}
