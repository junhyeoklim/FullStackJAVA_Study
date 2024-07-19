package test;

public class Test2 {

	public static void main(String[] args) {

		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		int idx = fullPath.lastIndexOf("\\");
		
		for(int i=0; i<idx; i++)
		{
			path += String.valueOf(fullPath.charAt(i));					
		}
		
		for(int i = idx+1; i <fullPath.length(); i++)
		{
			fileName += String.valueOf(fullPath.charAt(i));
		}
		
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
		
	}

}
