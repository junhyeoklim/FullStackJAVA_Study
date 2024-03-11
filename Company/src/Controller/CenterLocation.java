package Controller;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CenterLocation {
	
	private static int x;
	private static int y;
	
	public static void location(int w, int h) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		
		int sw = d.width;
		int sh = d.height;
		
		x = (sw-w)/2;
		y = (sh-h)/2;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}
	
	
}
