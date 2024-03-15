
package chpater9;

public class Exercise9_5 {

	public static int count(String src, String target) {
		int count = 0; // 찾은 횟수
		int pos = 0; // 찾기 시작할 위치
		
		while(true)
		{
			if(src.indexOf(target,pos) > 0)
			{
				count ++;
				pos = target.length() + src.indexOf(target,pos);
			}
			else
				break;			
		}
		
		return count;
		}
		public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
		}
}
