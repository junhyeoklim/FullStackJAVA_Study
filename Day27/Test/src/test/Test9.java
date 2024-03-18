package test;

public class Test9 {

	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를" + stringCount(src, "aa") +"개 찾았습니다."); 
	}
	static int stringCount(String src, String key) {
		int cnt = stringCount(src, key, 0);		
		return cnt;
	}

	static int stringCount(String src, String key, int pos) {
		int count = 0;

		for(int i=0;i<src.length();i++)
		{

			if(src.indexOf(key,pos) >= 0)
			{
				count ++;
				pos = key.length() + src.indexOf(key,pos);				
			}

		}
		return count;
	}
}
