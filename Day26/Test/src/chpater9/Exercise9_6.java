package chpater9;

import java.util.Arrays;

public class Exercise9_6 {

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
		char[] srcArrays = new char[src.length()];
		String resrc = "";
		
		Arrays.fill(ch, '0');		
		
		for(int i=0;i<srcArrays.length;i++)
		{
			srcArrays[i] = src.charAt(i);
		}				
		
		System.arraycopy(srcArrays,0, ch, src.length(), src.length());
		
		
		for(int i=0;i<ch.length;i++)
		{
			resrc += String.valueOf(ch[i]);
		}		
		return resrc;
	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
