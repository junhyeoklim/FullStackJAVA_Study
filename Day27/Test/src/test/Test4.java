package test;

import java.util.Arrays;

public class Test4 {

	public static String fillZero(String src, int length) {

		if(src.equals(null) || src.length() == length)
			return src;
		else if(length <= 0)
			return "";
		else if(src.length() > length)
		{
			String resrc = "";
			for(int i=0; i<length;i++)
			{
				resrc += String.valueOf(src.charAt(i));
			}
			return resrc;
		}
		
		char[] ch = new char[length];

		Arrays.fill(ch, '0');

		System.arraycopy(src.toCharArray(), 0, ch, src.length(), src.length());


		return String.valueOf(ch);

	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}

}
