package chpater9;

import java.util.Arrays;

public class Exercise9_10 {

	public static String format(String str, int length, int alignment)
	{

		String src = "";

		if(length < str.length())
		{
			for(int i=0;i<length;i++)
			{
				src += String.valueOf(str.charAt(i));
			}
			return src;
		}
		else
		{
			char[] ch = new char[length];
			char[] copy = new char[str.length()];
			Arrays.fill(ch, ' ');

			for(int i=0;i<copy.length;i++)
			{
				copy[i] = str.charAt(i);
			}
			switch (alignment) {
			case 0:
			default:
			{
				System.arraycopy(copy, 0, ch, 0, copy.length);				
				break;				
			}
			case 1: {
				System.arraycopy(copy, 0, ch, (ch.length-copy.length)/2, copy.length);
				break;				
			}
			case 2: {
				System.arraycopy(copy, 0, ch, ch.length-copy.length, copy.length);
				break;				
			}

			}
			return new String(ch);
		}

	}
	public static void main(String[] args) {
		String str = "가나다"; 
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	}
}
