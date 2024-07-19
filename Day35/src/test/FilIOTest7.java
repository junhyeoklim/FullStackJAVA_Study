package test;

import java.io.File;

public class FilIOTest7 {

	public static void main(String[] args) {
		
		File path = new File("C:\\MyJava\\my.bin");
		
		if(path.exists() == false)
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
	}

}
