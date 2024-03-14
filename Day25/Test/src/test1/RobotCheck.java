package test1;

class Robot
{
	public Robot() {}
}

class DanceRobot extends Robot
{
	public static void dance()
	{
		System.out.println("춤을 춥니다");
	}
}

class SingRobot extends Robot
{
	public static void sing()
	{
		System.out.println("노래를 합니다");
	}
}

class DrawRobot extends Robot
{
	public static void draw()
	{
		System.out.println("그림을 그립니다");
	}
}



public class RobotCheck {

	public static void action(Robot r)
	{
		if(r instanceof DanceRobot)
			DanceRobot.dance();
		else if(r instanceof SingRobot)
			SingRobot.sing();
		else if(r instanceof DrawRobot)
			DrawRobot.draw();
	}
	
	public static void main(String[] args) {
		
		RobotCheck.action(new DanceRobot());
		RobotCheck.action(new SingRobot());
		RobotCheck.action(new DrawRobot());
		

	}

}
